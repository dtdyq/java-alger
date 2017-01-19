package alger.dtdyq.list;

import java.util.Iterator;

import alger.List;

public class ArrayList <E> implements List<E>,Cloneable{
	private E[] Array;
	private int N=0;
    private int size=16;
    private int pow(int k,int x){
		int num=1;
		for(int i=0;i<x;i++){
			num*=k;
		}
		return num;
	}
    @SuppressWarnings("unchecked")
	private void test(){
    	if(N<size/2){
    		size/=2;
    		E[] temp=(E[])new Object[size];
    		for(int i=0;i<N;temp[i]=Array[i],i++);
    		Array=temp;
    	}
    }
    private class ArrayReverseIterator implements Iterator<E>{
		private int temp=N-1;
		public boolean hasNext(){
			return temp!=-1;
		}
		public E next(){
			return Array[temp--];
		}
	}
    private class ArrayIterator implements Iterator<E>{
		private int temp=0;
		@Override
		public boolean hasNext() {
			return temp!=N;
		}
		@Override
		public E next() {
			return Array[temp++];
		}
	}
    /**
     * initialize a ArrayList with default size
     * @return object of Arraylist 
     */
    @SuppressWarnings("unchecked")
	public ArrayList(){
    	Array=(E[])new Object[size];
    }
    /**
     * initialize a ArrayList with specified size
     * @param size
     * @return a object of ArrayList ,it's length is size
     */
    @SuppressWarnings("unchecked")
	public ArrayList(int size){
    	this.size=size;
    	Array=(E[])new Object[size];
    }
    /**
     * get the real size of ArrayList
     * @return the size of specified arraylist
     */
	@Override
	public int size() {
		return N;
	}
	/**
	 * add the specified value to ArrayList 
	 * @return if add successfully ,return true,else return false
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E val) {
		try{
			if(N<=size/2){
				Array[N]=val;
			}
			else{
				size*=2;
				E[] temp=(E[])new Object[size];
				for(int i=0;i<N;temp[i]=Array[i],i++);
				Array=temp;
				Array[N]=val;
			}
		}catch(Exception e){
			return false;
		}
		N++;
		return true;
	}
	/**
	 * add the specified list which has implemented the interface <code>list</code>
	 */
	@Override
	public boolean addAll(List<E> list) {
		Iterator<E> it=list.iterator();
		while(it.hasNext()){
			add(it.next());
		}
		return true;
	}
	/**
	 * get the specified value
	 * @return E
	 */
	@Override
	public E get(int key) {
		if(key<0||key>=N){
			return null;
		}
		return Array[key];
	}
	/**
	 * get the frist element in array
	 * @return E's instance or null
	 */
	@Override
	public E getFrist() {
		if(N==0){
			return null;
		}
		return Array[0];
	}
	/**
	 * get the last element in array
	 * @return E's instance or null
	 */
	@Override
	public E getLast() {
		if(N==0){
			return null;
		}
		return Array[N-1];
	}
	/**
	 * reset the specfied index key's value
	 * @param key
	 * @param val
	 * @return boolean
	 */
	@Override
	public boolean set(int key, E val) {
		if(N==0 || key<0 || key>=N){
			return false;
		}
		Array[key]=val;
		return true;
	}
	/**
	 * get specified element's index in positive direction
	 * @param val
	 * @return index
	 */
	@Override
	public int indexOf(E val) {
		for(int i=0;i<N;i++){
			if(Array[i].equals(val)){
				return i;
			}
		}
		return -1;
	}
	/**
	 * get specified element's index in negative direction
	 * @param val
	 * @return index
	 */
	@Override
	public int lastIndexOf(E val) {
		for(int i=N-1;i>=0;i--){
			if(Array[i].equals(val)){
				return i;
			}
		}
		return -1;
	}
	/**
	 * delete the specified index's element
	 * @param index
	 * @return true or false
	 */
	@Override
	public boolean del(int index) {
		if(index<0 || index>=N){
			return false;
		}
		for(int i=index;i<N-1;Array[i]=Array[++i]);
		N--;
		test();
		return true;
	}
	/**
	 * delete the frist element in specified ArrayList
	 * @return return true when be delete successfully,else return false
	 */
	@Override
	public boolean delFrist() {
		if(N==0){
			return false;
		}
		for(int i=0;i<N-1;Array[i]=Array[++i]);
		N--;
		test();
		return true;
	}
	/**
	 * delete the last element in specified Arraylist
	 * @return return true when be delete successfully,else return false
	 */
	@Override
	public boolean delLast() {
		if(N==0)
			return false;
		Array[--N]=null;
		test();
		return true;
	}
	/**
	 * return a iterator class for specified List 
	 * @return Iterator<E>
	 */
	@Override
	public Iterator<E> iterator() {
		
		return new ArrayIterator();
	}
	
	/**
	 * @return return the string which contain all element and index
	 */
	@Override
	public String toString(){
		String str="size: "+N+"\n";
		for(int i=0;i<N;i++){
			str+=i+" : "+Array[i]+"\n";
		}
		return str;
	}
	/**
	 * @return return the hashCode of list
	 */
	@Override
	public int hashCode(){
		if(N==0){
			return Array.hashCode();
		}
		int hashCode=0;
		for(int i=0;i<N;i++){
			hashCode+=Array[i].hashCode()*pow(11,i);
		}
		return hashCode;
	}
	/**
	 * return a iterator class which can reversed traverse all list
	 * @return Iterator
	 */
	public Iterator<E> reverse(){
		return new ArrayReverseIterator();
	}
	@Override
	public boolean contains(E key) {
		if(N==0){
			return false;
		}
		for(int i=0;i<N;i++){
			if(Array[i].equals(key)){
				return true;
			}
		}
		return false;
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
}













