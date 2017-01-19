package alger.dtdyq.map;

import com.sun.javafx.css.StyleCacheEntry.Key;

@SuppressWarnings({ "rawtypes", "hiding" })
public class HashMap<Key,Value > {
	private int N=1481;
	private int len=0;
	private int[] PrimeArray={ 421,1481,2753,3449,4261,5273,6029,13669,24371,41113,83869, 266603};

	private class Node<Key,Value>{
		Key key;
		Value val;
		public Node(Key key,Value val){
			this.key=key;
			this.val=val;
		}
	}
	@SuppressWarnings("unchecked")
	private Node<Key,Value>[] map=(Node<Key,Value>[])new Node[N];
	private int Hash(Key key){     
		return key.hashCode()%N;
	}
	private int reHash(int key){
		return lowN(N)-key%lowN(N);
	}
	private int lowN(int p){
		int lo=0,hi=12;
		int mid=(lo+hi)/2;
		while(lo<hi){
			if(PrimeArray[mid]<p){
				lo=mid+1;
				mid=(lo+hi)/2;
			}
			else if(PrimeArray[mid]>p){
				hi=mid-1;
				mid=(lo+hi)/2;
			}
			else return PrimeArray[mid-1];
		}
		return N-3;
	}
	private int HiN(int p){
		int lo=0,hi=12;
		int mid=(lo+hi)/2;
		while(lo<hi){
			if(PrimeArray[mid]<p){
				lo=mid+1;
				mid=(lo+hi)/2;
			}
			else if(PrimeArray[mid]>p){
				hi=mid-1;
				mid=(lo+hi)/2;
			}
			else return PrimeArray[mid+1];
		}
		return N+7;
	}
	@SuppressWarnings("unchecked")
	private void reSize(){
		int num=HiN(N);
		Node<Key,Value>[] temp=(Node<Key, Value>[])new Node[num];
		for(int i=0;i<num;i++){
			temp[i]=null;
		}
		for(int i=0;i<N;i++){
			if(map[i]!=null){
				temp[i]=new Node(map[i].key,map[i].val);
			}
		}
		N=num;
		map=temp;
	}
	@SuppressWarnings("unchecked")
	public void put(Key key,Value val){
		if(len>N/2){
			reSize();
		}
		int k=Hash(key);
		while(map[k]!=null && !map[k].key.equals(key)){
			k=reHash(k);
		}
		if(map[k]==null){
			map[k]=new Node(key,val);
			len++;
		}
		else{
			map[k].val=val;
		}
	}
	public Value get(Key key){
		int k=Hash(key);
		while(!map[k].key.equals(key)){
			k=reHash(k);
		}
		return map[k].val;
	}
	public int size(){
		return len;
	}
	public Value delete(Key key){
		int k=Hash(key);
		while(!map[k].key.equals(key)){
			k=reHash(k);
		}
		Value temp=map[k].val;
		map[k]=null;
		len--;
		return temp;
	}
	public boolean isEmpty(){
		return len==0;
	}
	public static void main(String[] args){
		HashMap<Integer,String> map=new HashMap<>();
		map.put(23, "string");
		map.put(64, "Integer");
		map.put(23, "void");
		map.put(300, "Boolean");
		map.put(100000, "bifweyu");
		System.out.println(map.get(100000));
		System.out.println(map.get(23));
		System.out.println(map.isEmpty());
		System.out.println(map.delete(23));
		System.out.println(map.size());
		
		long t1=System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			map.put(i,"test");
		}
		System.out.println(System.currentTimeMillis()-t1);
		
		TreeMap<Integer,String> tree=new TreeMap<>();
		long t3=System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			tree.put(i,"test");
		}
		System.out.println(System.currentTimeMillis()-t3);
		
		java.util.HashMap<Integer,String> map1=new java.util.HashMap<Integer,String>();
		long t2=System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			map1.put(i,"test");
		}
		System.out.println(System.currentTimeMillis()-t2);
		
		java.util.TreeMap<Integer,String> tree1=new java.util.TreeMap<Integer,String>();
		long t4=System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			tree1.put(i,"test");
		}
		System.out.println(System.currentTimeMillis()-t4);
	}
}





