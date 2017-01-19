package alger.dtdyq.test;

import java.util.Iterator;

import alger.List;
import alger.dtdyq.list.ArrayList;
import alger.dtdyq.list.LinkList;

public class ArrayListTest {

	public static void main(String[] args) {
		System.out.println("================ArrayListTest=============");
		ArrayList<String> l=new ArrayList<>();
		l.add("frist");
		ArrayList<String> el=new ArrayList<>();
//		el.add("frist");
//		el.delFrist();
		System.out.println(l.equals(el));
		System.out.println(l.size());
		l.del(0);
		System.out.println(l);
		l.add("second");
		l.add("third");
		l.set(1, "reset");
		l.delFrist();
		System.out.println("l==>\n"+l);
		System.out.println("l.get(2)===>"+l.get(2));
		System.out.println("====test iterator and add(list<E>)====");
		List<String> ll=new LinkList<>();
		ll.add("hhhh");
		ll.add("kkkkk");
		l.addAll(ll);
		Iterator<String> it=l.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("=======================================");
		l.add("second");
		l.add("second");
		l.add("test");
		System.out.println("l==>\n"+l);
		System.out.println("indexOf('second'): "+l.indexOf("second"));
		System.out.println("lastIndexOf('second'): "+l.lastIndexOf("second"));
		System.out.println("hashCode: "+l.hashCode());
		System.out.println("contains: "+l.contains("second"));
		System.out.println("contains: "+l.contains("list"));
		System.out.println("=================reverse==================");
		Iterator<String> i=l.reverse();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
