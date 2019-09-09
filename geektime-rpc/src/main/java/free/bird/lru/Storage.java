package free.bird.lru;

/**
 * @author freebird
 */
public interface Storage<K,V> {

    V get(K key);

}
