package aed.collections;

public interface IList<T> extends Iterable<T>{

    //adds a new element to the end of the list
    public void add(T item);

    //adds a new element at a specified position in the list
    public void addAt(int index, T item);

    //removes an element from the end of the list, returning it. If there are no elements, returns null.
    public T remove();

    //removes an element at a particular position. If there is no element at such position, nothing happens.
    public T remove(int index);

    //checks whether the list is empty, returning true if so, false otherwise
    public boolean isEmpty();

    //returns the number of elements currently in the list
    public int size();

    //returns the element stored in the specified position, where 0 is the beginning of the list.
    //if there is no such element, returns null
    public T get(int index);

    //replaces the element at the specified position with a new element. If there is no element in the specified position, nothing happens
    public void set(int index, T element);

    //returns a shallow copy of the list
    public IList<T> shallowCopy();


}
