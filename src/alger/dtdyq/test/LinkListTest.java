package alger.dtdyq.test;

import java.util.Iterator;
import alger.List;
import alger.dtdyq.list.LinkList;

public class LinkListTest {

	public static void main(String[] args){
		System.out.println("================LinkListTest=============");
		LinkList<String> l=new LinkList<>();
		l.add("frist");
		l.del(0);
		System.out.println("l==>\n"+l);
		l.add("second");
		l.add("third");
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
		System.out.println("size: "+l.size());
		System.out.println("=======================================");
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
