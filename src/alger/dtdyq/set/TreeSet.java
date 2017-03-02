package alger.dtdyq.set;

public class TreeSet<T extends Comparable<T>> {
	private class Node{
		T val;
		Node left;
		Node right;
		public Node(T val,Node left,Node right){
			this.val=val;
			this.left=left;
			this.right=right;
		}
		public String toString(){
			return val.toString();
		}
	}
	private Node head;
	private int size;
	public int size(){
		return size;
	}
	public void add(T val){
		head=add(head, val);
		size++;
	}
	private Node add(Node node,T val){
		if(node==null){
			return new Node(val,null,null);
		}
		int cmp=val.compareTo(node.val);
		if(cmp<0){
			node.left=add(node.left,val);
		}
		else if(cmp>0){
			node.right=add(node.right,val);
		}
		else{
			node.val=val;
		}
		return node;
	}
	public void clear(){
		head.left=null;
		head.right=null;
		head=null;
		size=0;
	}
	public boolean contains(T val){
		return contains(head,val);
	}
	private boolean contains(Node head,T val){
		int cmp=val.compareTo(head.val);
		if(cmp==0){
			return true;
		}
		else if(cmp<0){
			return contains(head.left,val);
		}
		else{
			return contains(head.right,val);
		}
	}
	public boolean isEmpty(){
		return size==0;
	}
	public void remove(T val){
		if(!contains(val)){
			return;
		}
		Node temp=head;
		while(temp!=null){
			int cmp=val.compareTo(temp.val);
			if(cmp==0){
				break;
			}
			else if(cmp<0){
				temp=temp.left;
			}
			else{
				temp=temp.right;
			}
		}
	}
	public T delMin(){
		if(size==0){
			return null;
		}
		size--;
		return delMin(head).val;
	}
	private Node delMin(Node node){
		Node temp=node;
		Node pre=null;
		while(temp.left!=null){
			pre=temp;
			temp=temp.left;
		}
		Node v=temp;
		if(pre!=null){
			pre.left=temp.right;
			temp=null;
		}
		else{
			head=head.right;
		}
		return v;
	}
	public T delMax(){
		if(size==0){
			return null;
		}
		size--;
	 	return delMax(head).val;
	}
	private Node delMax(Node node){
		Node temp=node;
		Node pre=null;
		while(temp.right!=null){
			pre=temp;
			temp=temp.right;
		}
		Node t=temp;
		if(pre!=null){
			pre.right=temp.left;
			temp=null;
		}
		else{
			head=head.left;
		}
		return t;
	}
	public T getFrist(){
		if(head==null){
			return null;
		}
		Node temp=head;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp.val;
	}
	public T getLast(){
		if(head==null){
			return null;
		}
		Node temp=head;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp.val;
	}
	public static void main(String[] args){
		TreeSet<Integer> ts=new TreeSet<>();
//		ts.add(20);
//		ts.add(30);
//		ts.add(45);
		ts.add(50);
		ts.add(18);
		ts.add(15);
//		ts.add(40);
		
		System.out.println(ts.delMax());
		
		System.out.println(ts.delMin());
		System.out.println(ts.delMin());
		
		System.out.println(ts.size());
	}
}






