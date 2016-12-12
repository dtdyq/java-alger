package third;

public class HashLink <Key,Value>{
	private int M;
	private SearchST<Key,Value>[] ST;
	public HashLink(){
		this(997);
	}
	@SuppressWarnings("unchecked")
	public HashLink(int size){
		this.M=size;
		ST=(SearchST<Key,Value>[])new SearchST[size];
		for(int i=0;i<M;i++){
			ST[i]=new SearchST<Key, Value>();
		}
	}
	private int Hash(Key key){
		return (key.hashCode() & 0x7fffffff)%M;
	}
	
	public void put(Key key,Value val){
		ST[Hash(key)].put(key, val);
	}
	public Value get(Key key){
		return ST[Hash(key)].get(key);
	}
	public int size(){
		int counter=0;
		for(int i=0;i<M;i++){
			counter=counter+ST[i].size();
		}
		return counter;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		@SuppressWarnings("rawtypes")
		HashLink hl=new HashLink();
		hl.put(222, "草房子");
		hl.put(333, "零落成泥碾作尘");
		hl.put(444, "养蜜蜂的人");
		hl.put(555, "大抵如此");
		System.out.println(hl.get(555));
		System.out.println(hl.size());
	}
	
}
















