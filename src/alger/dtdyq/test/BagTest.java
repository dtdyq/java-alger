package alger.dtdyq.test;

import java.util.Iterator;

import alger.dtdyq.list.Bag;

public class BagTest {
	public static void main(String[] args) {
		System.out.println("==============BagTest=============");
		Bag<String> bag=new Bag<>();
		bag.add("aaa");
		bag.add("bbb");
		System.out.println(bag.size());
		bag.add("ccc");
		Bag<String> b=new Bag<>();
		b.add("ddd");
		Bag<String> bag2=bag.union(b);
		Iterator<String> it=bag2.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
