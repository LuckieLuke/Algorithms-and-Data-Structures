public interface MapInterface <K extends Comparable<K>, V> {
    void setValue(K key, V value);
    V getValue(K key);
}
