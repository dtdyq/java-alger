package alger.dtdyq.list;

public class Queue<Item> {
	private Item[] queue;
	private int size=16;
	private int queueLength;
	private int rear=0,head=0;
	private String name;
	@SuppressWarnings("unchecked")
	private void queueFull(){
		Item[] temp=(Item[])new Object[size*2];
		for(int i=head,j=0;i<rear;i=(i+1)%size,j++){
			temp[j]=queue[i];
		}
		head=0;
		rear=queueLength+1;
		size*=2;
		queue=temp;
	}
	@SuppressWarnings("unchecked")
	private void queueReduce(){
		Item[] temp=(Item[])new Object[size/2];
		for(int i=head,j=0;i!=rear;i=(i+1)%size,j++){
			temp[j]=queue[i];
		}
		head=0;
		rear=queueLength+1;
		size/=2;
		queue=temp;
	}
	/**
	 * create a queue with default name
	 */
	@SuppressWarnings("unchecked")
	public Queue(){
		this.name="queue";
		queue=(Item[])new Object[size];
	}
	/**
	 * create a queue with specified name
	 * @param name
	 */
	public Queue(String name){
		this();
		this.name=name;
	}
	/**
	 * add a element to the rear of queue
	 * @param item
	 */
	public void enQueue(Item item){
		if((rear+1)%size==head){
			queueFull();
		}
		queue[rear]=item;
		rear=(rear+1)%size;
		queueLength++;
	}
	/**
	 * delete element form the head of queue and return
	 * @return item
	 */
	public Item deQueue(){
		if(head==rear){
			return null;
		}
		Item item=queue[head];
		queue[head]=null;
		queueLength--;
		head = (head+1)%size;
		if(queueLength<size/4){
			queueReduce();
		}
		return item;
	}
	public String toString(){
		return this.name+": "+this.queueLength;
	}
	/**
	 * get the size of queue
	 * @return
	 */
	public int size(){
		return this.queueLength;
	}
	/**
	 * peek the head element of queue but not delete it
	 */
	public Item peek(){
		if(head==rear){
			return null;
		}
		return queue[head];
	}


}
