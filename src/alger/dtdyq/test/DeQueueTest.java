package alger.dtdyq.test;

import alger.dtdyq.list.DeQueue;

public class DeQueueTest {
	public static void main(String[] args){
		DeQueue<String> dq=new DeQueue<String>("test");
		dq.addHead("aaaaa");
		dq.addHead("bbbbb");
		System.out.println(dq);
		System.out.println(dq.delTail());
		System.out.println(dq.delHead());
		System.out.println(dq.delHead());
		dq.addTail("ccccc");
		System.out.println(dq.delHead());
		System.out.println(dq.size());
		dq.addHead("dddd");
		dq.addTail("eeee");
		dq.addTail("ffff");
		System.out.println(dq);
		System.out.println(dq.delHead());
		System.out.println(dq.delTail());
		System.out.println(dq.peekHead());
		System.out.println(dq.peekTail());
		dq.delHead();
		System.out.println(dq.peekHead());
		System.out.println(dq.peekTail());
	}
}
