package alger.dtdyq.test;

import alger.dtdyq.list.Stack;

public class StackTest {

	public static void main(String[] args) {
		System.out.println("==============SatckTest================");
		Stack<String> s=new Stack<>(3,"testSatck");
		s.push("A");
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push("B");
		System.out.println(s.size());
		System.out.println(s.stackSize());
		s.push("C");
		System.out.println(s.peek());
		s.push("D");
		s.resetSize(10);
		System.out.println(s.push("K"));
		System.out.println(s.stackSize());

	}

}
