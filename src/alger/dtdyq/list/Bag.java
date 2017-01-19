package alger.dtdyq.list;


import java.util.Iterator;

public class Bag<Item> {
	private Item[] bag;
	private int size=5;
	private int N=0;
	private String name;
	@SuppressWarnings("unchecked")
	private void bagFull(){
		size*=2;
		Item[] temp=(Item[])new Object[size];
		for(int i=0;i<N;i++){
			temp[i]=bag[i];
		}
		bag=temp;
	}
	/**
	 * initialize a bag with default name
	 */
	public Bag(){
		this("bag");
	}
	/**
	 * initialize a bag with specified name
	 * @param name
	 */
	@SuppressWarnings("unchecked")
	public Bag(String name){
		this.name=name;
		bag=(Item[])new Object[size];
	}
	/**
	 * get the size of bag
	 * @return size
	 */
	public int size(){
		return N;
	}
	/**
	 * add a element to bag
	 * @param item
	 */
	public void add(Item item){
		if(N==size){
			bagFull();
		}
		bag[N++]=item;
	}
	@Override
	public String toString(){
		return name+": "+N;
	}
	public Iterator<Item> iterator(){
		return new bagIterator();
	}
	private class bagIterator implements Iterator<Item>{
		private int temp=0;
		@Override
		public boolean hasNext() {
			return temp!=N;
		}

		@Override
		public Item next() {
			return bag[temp++];
		}
		
	}
	/**
	 * test if the specified element is exit in bag, 
	 * @param item
	 * @return true if conatins the element,else return false 
	 */
	public boolean contains(Item item){
		for(Item i:bag){
			if(item.equals(i)){
				return true;
			}
		}
		return false;
	}
	/**
	 * test if the specified bag is this's subset
	 * @param temp
	 * @return true or false
	 */
	public boolean contains(Bag<Item> temp){
		Iterator<Item> it=temp.iterator();
		while(it.hasNext()){
			Item i=it.next();
			if(!contains(i)){
				return false;
			}
		}
		return true;
	}
	/**
	 * add all of this bag's element into specified bag,if the bag contains it ,just ignore 
	 * @param temp
	 */
	public Bag<Item> union(Bag<Item> temp){
		Bag<Item> b=new Bag<>();
		Iterator<Item> i=iterator();
		while(i.hasNext()){
			b.add(i.next());
		}
		Iterator<Item> it=temp.iterator();
		while(it.hasNext()){
			Item item=it.next();
			if(!b.contains(item)){
				b.add(item);
			}
		}
		return b;
	}
	/**
	 * return a bag witch contains element of exiting in this bag and specified bag
	 */
	public Bag<Item>  intersection(Bag<Item> temp){
		Bag<Item> b=new Bag<>();
		Iterator<Item> it=temp.iterator();
		while(it.hasNext()){
			Item i=it.next();
			if(contains(i)){
				b.add(i);
			}
		}
		return b;
	}
	/**
	 * get the bag compased by the element which exits in this bag but don't be contained
	 *by specified bag
	 */
	public Bag<Item> complement(Bag<Item> temp){
		if(temp==null || this.intersection(temp).size()==0){
			return this;
		}
		Bag<Item> b=new Bag<>();
		Iterator<Item> it=this.iterator();
		while(it.hasNext()){
			Item i=it.next();
			if(!temp.contains(i)){
				b.add(i);
			}
		}
		return b;
	}

}
