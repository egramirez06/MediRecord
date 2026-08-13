package clinic;
public interface KeyDinamicsLists<T,K> extends DynamicLists<T,K>{
    public T get(K id);
    public boolean remove( K id);
}
