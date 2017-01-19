/**
 * file:LinkList.java
 * author:dtdyq
 * Date:12 14, 2016
 * Dependencies:List.java
 * public				 int size();
 * public 				 boolean add(E val);
 * public 				 boolean addAll(List<E> list);
 * public 		         E get(int key);
 * public 				 E getFrist();
 * public                E getLast();
 * public 				 boolean set(int key,E val);
 * public 			     int indexOf(E val);
 * public 			 	 int lastIndexOf(E val);
 * public 	             boolean del(int index);
 * public 	             boolean delFrist();
 * public 	             boolean delLast();
 * public 	             Iterator<E> iterator();
 */
package alger.dtdyq.list;
/**
 * The {@code LinkList} class implenmented by linked list represent a data structure
 * which can used to create a list of Object,and support the methods of <em>add</em>¡¢<em>
 * delete</em>¡¢<em>get</em>¡¢set</em> and so on.
 * @author dtdyq 
 */
import java.util.Iterator;
import alger.List;

public class LinkList<E> implements List<E>,Cloneable{
	private class Node{
		E val;
		Node next;
		Node last;
		Node(E val,Node next,Node last){
			this.val=val;
			this.next=next;
			this.last=last;
		}
		public String toString(){
			return val.toString();
		}
		public int hashCode(){
			return val.hashCode();
		}
	}
	Node fristNode,lastNode;
	int size;					//length of LinkList
	private class LinkListIterator implements Iterator<E>{
		private Node temp=fristNode;
		@Override
		public boolean hasNext() {
			return temp!=null;
		}

		@Override
		public E next() {
			E item=temp.val;
			temp=temp.next;
			return item;
		}
	}
	private class reverseIterator implements Iterator<E>{
		private Node temp=lastNode;
		@Override
		public boolean hasNext() {
			return temp!=null;
		}

		@Override
		public E next() {
			E item=temp.val;
			temp=temp.last;
			return item;
		}
		
	}
	private int pow(int k,int x){
		int num=1;
		for(int i=0;i<x;i++){
			num*=k;
		}
		return num;
	}
	/**
	 * create a new LinkList Object
	 * @return LinkList
	 */
	public LinkList(){
		fristNode=null;
		lastNode=null;
		size=0;
	}
	/**
	 * get the size of linked list
	 * @param  
	 * @return int
	 */
	@Override
	public int size(){
		return size;
	}
	/**
	 * add the element to linklist
	 * @param val instance of E
	 * @return boolean if added successful return true,else false
	 */
	@Override
	public boolean add(E val){
		if(fristNode==null){
			try{
				fristNode=new Node(val,null,null);
				lastNode=fristNode;
			}catch(Exception e){
				return false;
			}
			size++;
			return true;
		}
		try{
			Node temp=new Node(val,null,lastNode);
			lastNode.next=temp;
			lastNode=temp;
			size++;
			return true;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * add a collection of E which implements interface List
	 * @param List<E>
	 * @return boolean if added successful return true,else false
	 */
	@Override
	public boolean addAll(List<E> list){
		Iterator<E> it=list.iterator();
		while(it.hasNext()){
			try{
				add(it.next());
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}
	/**
	 * get the value at index of key
	 * @param key
	 * @return E 
	 */
	@Override
	public E get(int key){
		if(key>=size || fristNode==null){
			System.out.println("==flow out==");
			return null;
		}
		Node temp;
		int count=0;
		if(key<size/2){
			for(temp=fristNode,count=0;temp!=null && count!=key;count++,temp=temp.next);
		}else{
			for(temp=lastNode,count=0;temp!=null && count!=size-key-1;count++,temp=temp.last);
		}
		return temp.val;
	}
	/**
	 * get the frist element of linklist
	 * @return E
	 */
	@Override
    public E getFrist(){
    	if(size==0){
    		System.out.println("list is null");
    		return null;
    	}
    	return fristNode.val;
    }
	/**
	 * get the last element of linklist
	 * @return E
	 */
	@Override
	public E getLast(){
		if(size==0){
			System.out.println("list is null");
			return null;
		}
		return lastNode.val;
	}
	/**
	 * reset the element which's index is key to val
	 * @param key
	 * @param val
	 * @return E
	 */
	@Override
	public boolean set(int key,E val){
		if(key>size){
			System.out.println("flow out");
			return false;
		}
		Node temp=fristNode;
		try{
			for(int count=0;count!=key;count++,temp=temp.next);
		}catch(Exception e){
			return false;
		}
		temp.val=val;
		return true;
	}
	/**
	 * Returns the index of the first occurrence of the specified element in this list,
	 * or -1 if this list does not contain the element. More formally, returns the 
	 * lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or
	 * -1 if there is no such index. 
	 *  @return int 
	 */
	@Override
	public int indexOf(E val){
		Node temp=fristNode;
		int count;
		for(count=0;temp!=null && !temp.val.equals(val);temp=temp.next,count++);
		if(temp==null){
			return -1;
		}
		return count;
	}

	/**
	 * return the index of the last occurrence of the specified element in this list
	 * or -1 if this list does not contain the element.
	 * @param E
	 * @return int
	 */
	@Override
	public int lastIndexOf(E val){
		Node temp=lastNode;
		int count;
		for(count=1;temp!=null && !temp.val.equals(val);temp=temp.last,count++);
		if(temp==null){
			return -1;
		}
		return size-count;
	}

	/**
	 * delete the element which's index is been given in list
	 * @param int
	 * @return true or false
	 */
	@Override
	public boolean del(int index){
		if(index>size){
			System.out.println("value is too large");
			return false;
		}
		if(index==0){
			delFrist();
			return true;
		}
		Node temp=fristNode;
		try{
			for(int count=0;temp!=null && count!=index;count++,temp=temp.next);
		}catch(Exception e){
			return false;
		}
		try {
			if (temp.next == null) {
				lastNode = temp.last;
				lastNode.next = null;
				return true;
			}
		}catch(NullPointerException e){
			return false;
		}
		temp.last.next=temp.next;
		temp.next.last=temp.last;
		size--;
		return true;
	}
	/**
	 * delete the frist element in list
	 * @return if delete successfully ,return true,else return false
	 */
	@Override
	public boolean delFrist(){
		if(fristNode==null){
			return false;
		}
		size--;
		fristNode=fristNode.next;
		if(fristNode==null){
			return true;
		}
		fristNode.last=null;
		return true;
	}
	/**
	 * delete the last element in list
	 * @return if delete successfully ,return true,else return false
	 */
	@Override
	public boolean delLast(){
		if(lastNode==null){
			return false;
		}
		size--;
		lastNode=lastNode.last;
		if(lastNode==null){
			fristNode=null;
			return true;
		}
		lastNode.next=null;
		return true;
	}
	/**
	 * return a iterator class for specified List 
	 * @return Iterator<E>
	 */
	@Override
	public Iterator<E> iterator(){
		return new LinkListIterator();
	}
	/**
	 * @return return the hashCode of list
	 */
	@Override
	public int hashCode(){
		Node temp=fristNode;
		if(temp==null){
			return fristNode.hashCode();
		}
		int hashCode=0;
		int count;
		for(count=0;temp!=null;temp=temp.next,count++){
			hashCode+=temp.hashCode()*pow(11,count);
		}
		return hashCode;
	}
	/**
	 * @return return the string which contain all element and index
	 */
	@Override
	public String toString(){
		String str=null;
		str="size: "+size+"\n";
		Node temp;
		int count;
		for(temp=fristNode,count=0;temp!=null;temp=temp.next,count++){
			str+=count+" : "+temp.val+"\n";
		}
		return str;
	}
	/**
	 * test if the specified element is contained in list
	 * @param key
	 * @return if contained ,return true,else return false
	 */
	public boolean contains(E key){
		Node temp=fristNode;
		for(;temp!=null && !temp.val.equals(key);temp=temp.next);
		if(temp==null){
			return false;
		}
		else{
			return true;
		}
	}
	/**
	 * return a iterator class which can reversed traverse all list
	 * @return Iterator
	 */
	public Iterator<E> reverse(){
		return new reverseIterator();
	}
	@Override
	public boolean equals(Object list){
		if(list==null){
			return false;
		}
		if(this.getClass()==list.getClass()){
			if(this.hashCode()==list.hashCode()){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		System.out.println("==========LinkList============");
	}

}











