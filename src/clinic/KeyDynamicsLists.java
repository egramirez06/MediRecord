package clinic;
public interface KeyDynamicsLists<T,K> extends DynamicLists<T>{
    public T get(K id);
    public boolean remove(K id);
}
