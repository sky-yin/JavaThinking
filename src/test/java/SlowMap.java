import com.sun.tools.javac.comp.Enter;

import java.util.Map;
import java.util.Objects;

public class SlowMap<K,V> implements Map.Entry<K, V> {

    private K key;
    private V value;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V result = this.value;
        this.value = value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlowMap<?, ?> slowMap = (SlowMap<?, ?>) o;
        return Objects.equals(key, slowMap.key) &&
                Objects.equals(value, slowMap.value);
    }

    @Override
    public int hashCode() {
        return (this.key == null?0:key.hashCode())^
                (this.value == null?0:value.hashCode());
    }
}
