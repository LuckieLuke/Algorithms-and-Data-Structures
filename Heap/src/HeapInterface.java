public interface HeapInterface <T extends Comparable<T>>{
    void put(T item); // dodaje element do kopca
    T pop(); // pobiera element "największy" wg naturalnej kolejności
}
