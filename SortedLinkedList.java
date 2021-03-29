package lab06;

public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T>
{
	Node<T> head;
	int size;

	public class Node<T>
	{
		T data;
		Node<T> previous, next;
		public Node(T d, Node<T> p, Node<T> n) {
			data = d;
			previous = p;
			next = n;
		}
	}

	public void LinkedList() {
		head = null;
		size = 0;
	}

	public boolean add(T item) {
		if (size == 0) {// if head is null
			head  = new Node<T>(item, null, null);
		}
		else {
			head.previous = new Node<T>(item, null, head);// make item the previous one of head
			head = head.previous;
		}
		size++;
		return false;
	}

	public T get(int pos) {
		if (size == 0) {
			throw new UnsupportedOperationException("Error, incorrect size");
		}
		else if(pos< 0 || pos >=  size){
			throw new UnsupportedOperationException("Error, incorrect position");
		}
		else {
			Node current = head;
			int position = 0;
			while (current != null) {
				if (position == pos) {// check where pos is
					return (T) current.data;
				}
				position++;
				current = current.next;// current to next element
			}
			return null;
		}
	}

	public T remove(int pos) {
		if (size == 0) {
			throw new UnsupportedOperationException("Error, incorrect size");
		}
		else{
		Node temp = new Node(null,null,null);
		Node current = head;
		int position = 0;
		while (current != null) {
			if (position == pos) {// check where pos is
				temp = current;
				for (int i=0; (current!=null)&&(i<pos-1); i++) {
					current = current.next;
				}
				break;
			}
			position++;
			current = current.next;
		}
		size--;
		return (T)temp.data;
		}
	}

	public int size() {
		return size;
	}
}
