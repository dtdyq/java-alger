package alger.dtdyq.list;

public class DeQueue<Item> {
	private class Node{
		Item item;
		Node last;
		Node next;
		public Node(Item item,Node last, Node next){
			this.item=item;
			this.last=last;
			this.next=next;
		}
		public String toString(){
			return item+"";
		}
	}
	private Node head,tail;
	private int N;				//length of DeQueue
	private String name;
	/**
	 * initialize a DeQueue with default name;
	 */
	public DeQueue(){
		this.name="DeQueue";
	}
	/**
	 * initialize q DeQueue with specified name
	 * @param name
	 */
	public DeQueue(String name){
		this.name=name;
	}
	/**
	 * get the size of DeQueue
	 */
	public int size(){
		return N;
	}
	/**
	 * add the specified element to head of DeQueue
	 * @param item
	 */
	public void addHead(Item item){
		N++;
		if(head==null){
			head=new Node(item,null,null);
			tail=head;
			return;
		}
		head=new Node(item,null,head);
		head.next.last=head;
	}
	/**
	 * add the specified element to tail of DeQeue
	 * @param item
	 */
	public void addTail(Item item){
		N++;
		if(tail==null){
			tail=new Node(item,null,null);
			head=tail;
			return;
		}
		tail=new Node(item,tail,null);
		tail.last.next=tail;
	}
	/**
	 * delete a element from the head of DeQueue
	 */
	public Item delHead(){
		if(head==null){
			return null;
		}
		Item item=head.item;
		head=head.next;
		if(head==null){
			tail=null;
		}
		else{
			head.last=null;
		}
		N--;
		return item;
	}
	/**
	 * delete a element from the tail of DeQueue
	 */
	public Item delTail(){
		if(tail==null){
			return null;
		}
		Item item=tail.item;
		tail=tail.last;
		if(tail==null){
			head=null;
		}
		else{
			tail.next=null;
		}
		N--;
		return item;
	}
	/**
	 * get the head element but donnot delete it
	 */
	public Item peekHead(){
		if(head==null){
			return null;
		}
		return head.item;
	}
	/**
	 * get the tail element but donnot delete it
	 */
	public Item peekTail(){
		if(tail==null){
			return null;
		}
		return tail.item;
	}
		
	@Override
	public String toString(){
		return name+": "+N;
	}

}






