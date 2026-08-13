package clinic;
public interface KeyDinamicsLists<T,K> extends DynamicLists<T>{
    public T get(K id);
    public boolean remove(K id);
}
