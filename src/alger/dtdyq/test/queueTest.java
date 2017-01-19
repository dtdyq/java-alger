package alger.dtdyq.test;

import alger.dtdyq.list.Queue;

public class queueTest {
	public static void main(String[] args) {
		Queue<String> queue=new Queue<>("test");
		for(int i=1;i<100;i++){
			queue.enQueue(i+"test");
			System.out.println(queue.deQueue());
			
		}
	}
}
