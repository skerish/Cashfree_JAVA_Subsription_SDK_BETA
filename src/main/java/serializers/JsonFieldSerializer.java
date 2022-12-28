package serializers;

public interface JsonFieldSerializer<T> {
  public String serialize(T value);
}
