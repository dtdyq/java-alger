package alger.dtdyq.list;
/**
 * 
 * @author dtdyq
 *
 * @param <E>
 */
public class Stack<E> {
	private String name;
	private int size;
	private int N=0;
	private class Node{
		E val;
		Node next;
		public Node(E val,Node next){
			this.val=val;
			this.next=next;
		}
	}
	private Node head;
	/**
	 * initialize a stack with default size
	 * @return Stack
	 */
	public Stack(){
		this.size=22;
	}
	/**
	 * initialize a stack with specified length
	 * @param size
	 */
	public Stack(int size){
		this();
		this.size=size;
	}
	/**
	 * initialize a stack with default length and specified name
	 * @param name
	 */
	public Stack(String name){
		this();
		this.name=name;
	}
	/**
	 * initialize a stack with specified lengh and name
	 * @param size
	 * @param name
	 */
	public Stack(int size,String name){
		this();
		this.size=size;
		this.name=name;
	}
	@Override
	public String toString(){
		return this.name;
	}
	/**
	 * push the specified element into satck
	 * @param val
	 * @return if be added successfully ,return true,else return false; 
	 */
	public boolean push(E val){
		if(isFull()){
			System.out.println("stack is full");
			return false;
		}
		if(head==null){
			N++;
			head=new Node(val,null);
			return true;
		}
		N++;
		head=new Node(val,head);
		return true;
	}
	/*
	 * pop the element of satck's top and delete it
	 * @return element
	 */
	public E pop(){
		if(isEmpty()){
			System.out.println("satck is empty");
			return null;
		}
		E item=head.val;
		head=head.next;
		N--;
		return item;
	}
	/**
	 * obtain the frist element of satck's top but not delete it
	 * @return element
	 */
	public E peek(){
		if(isEmpty()){
			System.out.println("stack is empty");
			return null;
		}
		return head.val;
	}
	/**
	 * @return return true while stack is full
	 */
	public boolean isFull(){
		return N==size;
	}
	/**
	 * @return return true if satck is empy
	 */
	public boolean isEmpty(){
		return N==0;
	}
	/**
	 * reset stack's size
	 * @param size
	 * @return true when specified size is reasonable
	 */
	public boolean resetSize(int size){
		if(size<0){
			return false;
		}
		if(size<N){
			System.out.println("specified size is too samll");
			return false;
		}
		this.size=size;
		return true;
	}
	/**
	 * @return return the num of element
	 */
	public int size(){
		return N;
	}
	/**
	 * 
	 * @return return size of the satck
	 */
	public int stackSize(){
		return size;
	}
	public static void main(String[] args) {
		
		
	}

}
