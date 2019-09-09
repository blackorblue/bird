package free.bird.lru;

public class FreeBirdCache<K,V> extends LruCache<K,V> {

    public FreeBirdCache(int capacity, Storage<K, V> lowSpeedStorage) {
        super(capacity, lowSpeedStorage);
    }

    public V get(K key) {
        return null;
    }
}
