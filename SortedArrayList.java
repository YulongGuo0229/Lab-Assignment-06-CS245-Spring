package lab06;
import java.util.List;

public class SortedArrayList<T extends Comparable<T>> implements SortedList<T>
{
	
	public T[] a;
	public int size;
	boolean flag=false;
	public SortedArrayList() //makes new array list and sets size at 0
    {
        a = (T[]) new Object[10];
        size = 0;
    }
	
	public boolean add(T item)
	{
		if(size <= a.length){
            grow_array();
            flag=true;
        }
        a[size++] = item;
		return flag;
	}
	
	public T remove(int pos)
	{
		if (size == 0){
			throw new UnsupportedOperationException("Error, incorrect size");
	}
		 if(pos< 0 || pos> size- 1){
	            throw new UnsupportedOperationException("Error, incorrect position");
	        }
	        T item = a[pos];
	        for(int i = pos; i < size - 1;i++){
	            a[i] = a[i + 1];
	        }
	        size -= 1;
	        return item;
	}
	
	public T get(int pos)
	{
		if(pos< 0 || pos >=  size){
			throw new UnsupportedOperationException("Error, incorrect position");
        }
		else
        return a[pos];
	}
	
	public int size()
	{
		return size;
	}
	
	private void grow_array() //doubles size of array
    {
        T [] new_arr = (T[]) new Object[a.length * 2];
        for (int i = 0; i < a.length; i++){
            new_arr[i] = a[i];
        }
        a = new_arr;
    }
}
