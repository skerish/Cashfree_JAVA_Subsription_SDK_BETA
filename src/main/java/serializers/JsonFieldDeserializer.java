package serializers;

public interface JsonFieldDeserializer<T> {
  public T deserialize(String value);
}
