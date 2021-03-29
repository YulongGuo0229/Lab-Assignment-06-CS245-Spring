package lab06;
	
public interface SortedList<T extends Comparable<T>>
{
public boolean add(T item);
public T remove(int pos);
public T get(int pos);
public int size();
}
