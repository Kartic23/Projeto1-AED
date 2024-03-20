package aed.collections;

public interface IQueue<T> extends Iterable<T>{

    public void enqueue(T item);

    public T dequeue();

    public T peek();

    public boolean isEmpty();

    public int size();

    public IQueue<T> shallowCopy();
}