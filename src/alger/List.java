package alger;
import java.util.Iterator;

/**
 * 
 * @author dtdyq
 *
 */
public interface List<E> extends Iterable<E>{
	int size();
	boolean add(E val);
	boolean addAll(List<E> list);
	E get(int key);
	E getFrist();
	E getLast();
	boolean set(int key,E val);
	int indexOf(E val);
	int lastIndexOf(E val);
	boolean del(int index);
	boolean delFrist();
	boolean delLast();
	boolean contains(E key);
	Iterator<E> iterator();
}
