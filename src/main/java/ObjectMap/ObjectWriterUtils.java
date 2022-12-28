package ObjectMap;

import Annotations.Serialize;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import lombok.SneakyThrows;
import serializers.JsonFieldSerializer;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjectWriterUtils {
  private static Set<String> javaBasicTypes;
  static {
    javaBasicTypes = new HashSet<>();

    javaBasicTypes.add("java.lang.Boolean");
    javaBasicTypes.add("java.lang.String");

    javaBasicTypes.add("java.lang.Short");
    javaBasicTypes.add("java.lang.Integer");
    javaBasicTypes.add("java.lang.Long");
    javaBasicTypes.add("java.lang.Float");
    javaBasicTypes.add("java.lang.Double");
    javaBasicTypes.add("java.math.BigInteger");
    javaBasicTypes.add("java.math.BigDecimal");
  }

  @SneakyThrows
  @SuppressWarnings("unchecked")
  public static <T> String writeValue(T t) {
    JsonObject jsonObject = new JsonObject();
    for (Field field: ObjectMappingUtils.getAllFields(t.getClass())) {
      Object fieldValue = getField(field, t);
      if (fieldValue == null) continue;

      String fieldValueAsString;
      String fieldName = field.getName();
      Class<?> fieldClass = field.getType();
      if (javaBasicTypes.contains(fieldClass.getName())) {
        fieldValueAsString = fieldValue.toString();
      } else if ("java.util.List".equals(fieldClass.getName())) {
        JsonArray jsonArray = new JsonArray();
        List<Object> casted = (List<Object>) fieldValue;
        for (Object obj: casted) {
          jsonArray.add(writeValue(obj));
        }
        fieldValueAsString = jsonArray.toString();
      } else {
        Serialize serialize = field.getAnnotation(Serialize.class);
        fieldValueAsString = serialize == null ?
            writeValue(fieldClass) : getFieldInstanceUsingCustomSerializer(serialize, fieldValue);
      }
      if ("java.lang.Integer".equals(fieldClass.getName())) {
        jsonObject.set(fieldName, Integer.parseInt(fieldValueAsString));
      } else if ("java.lang.Boolean".equals(fieldClass.getName())) {
        jsonObject.set(fieldName, Boolean.parseBoolean(fieldValueAsString));
      } else {
        jsonObject.set(fieldName, fieldValueAsString);
      }
    }

    String res = jsonObject.toString()
            .replaceAll("\\\\", "")
            .replaceAll("\"\\[", "\\[")
            .replaceAll("]\"", "]")
            .replaceAll("\"\\{", "\\{")
            .replaceAll("}\"", "}");

    return res;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  private static String getFieldInstanceUsingCustomSerializer(Serialize serialize, Object obj) {
    Class<? extends JsonFieldSerializer> serializerClass = serialize.using();
    JsonFieldSerializer jsonFieldSerializer = ObjectMappingUtils.getTypedInstance(serializerClass);

    return jsonFieldSerializer.serialize(obj);
  }

  @SuppressWarnings("deprecation")
  public static Object getField(Field field, Object object) {
    boolean isFieldAccessible = field.isAccessible();
    if (!isFieldAccessible) {
      field.setAccessible(true);
      try {
        Object obj = field.get(object);
        field.setAccessible(false);
        return obj;
      } catch (IllegalAccessException x) {
        throw new RuntimeException(x);
      }
    }
    return null;
  }
}
