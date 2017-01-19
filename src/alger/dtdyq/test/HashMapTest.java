package alger.dtdyq.test;

public class HashMapTest {
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
