package Annotations;

import serializers.JsonFieldSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Serialize {
  @SuppressWarnings("rawtypes")
  Class<? extends JsonFieldSerializer> using();
}