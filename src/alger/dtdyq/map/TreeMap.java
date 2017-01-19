package alger.dtdyq.map;

public class TreeMap <Key extends Comparable<Key>,Value extends Object> {
	private final static boolean RED=true;
	private final static boolean BLACK=false;
	private class Node{
		Key key;
		Value val;
		int N;
		boolean color;
		Node left,right;
		public Node(Key key,Value val,int N,boolean color){
			this.key=key;
			this.val=val;
			this.N=N;
			this.color=color;
		}
	}
	private Node root;
	private void flipColor(Node node){
		node.left.color=BLACK;
		node.right.color=BLACK;
		node.color=RED;
	}
	  private void flipColors(Node h) {
	        // h must have opposite color of its two children
	        // assert (h != null) && (h.left != null) && (h.right != null);
	        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
	        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
	        h.color = !h.color;
	        h.left.color = !h.left.color;
	        h.right.color = !h.right.color;
	    }
	private int size(Node node){
		if(node==null){
			return 0;
		}
		return node.N;
	}
	private Node rotateLeft(Node h){
		Node x=h.right;
		h.right=x.left;
		x.left=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}
	private Node rotateRight(Node h){
		Node x=h.left;
		h.left=x.right;
		x.right=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.left)+size(h.right);
		return x;
	}
	private Node leftLeft(Node h){
		h=rotateRight(h);
		flipColor(h);
		return h;
	}
	private boolean isRed(Node node){
		if(node==null)	return false;
		return node.color==RED;
	}
	private Value get(Node root,Key key){
		if(root==null)		return null;
		int cmp=key.compareTo(root.key);
		if(cmp<0){
			return get(root.left,key);
		}
		else if(cmp>0){
			return get(root.right,key);
		}
		else{
			return root.val;
		}
	}
	private Node put(Node root,Key key,Value val){
		if(root==null)	return new Node(key,val,1,RED);
		int cmp=key.compareTo(root.key); 
		if(cmp<0){
			root.left=put(root.left,key,val);
		}
		else if(cmp>0){
			root.right=put(root.right,key,val);
		}
		else{
			root.val=val;
		}
		if(isRed(root.right) && !isRed(root.left)){
			root=rotateLeft(root);
		}
		if(isRed(root.left) && isRed(root.left.left)){
			root=leftLeft(root);
		}
		if(isRed(root.right) && isRed(root.left)){
			flipColor(root);
		}
		root.N=1+size(root.left)+size(root.right);
		return root;
	}
	public int size(){
		if(root==null)	return 0;
		return root.N;
	}
	public TreeMap(){
		root=null;
	}
	public void put(Key key,Value val){
		root=put(root,key,val);
		root.color=BLACK;
	}
	
	public Value get(Key key){
		if(root==null){
			return null;
		}
		return get(root,key);
	}
	public Value getMax(){
		if(root==null){
			return null;
		}
		return getMax(root).val;
	}
	private Node getMax(Node root){
		while(root.right!=null){
			root=root.right;
		}
		return root;
	}
	public Value getMin(){
		if(root==null){
			return null;
		}
		return getMin(root).val;
	}
	private Node getMin(Node root){
		while(root.left!=null){
			root=root.left;
		}
		return root;
	}
	private Node moveRedLeft(Node h){
		flipColors(h);
		if(isRed(h.right.left)){
			h.right=rotateRight(h.right);
			h=rotateLeft(h);
		}
		return h;
	}
	public void delMin(){
		if(!isRed(root.left) && !isRed(root.right)){
			root.color=RED;
		}
		root=delMin(root);
		if(!isEmpty()){
			root.color=BLACK;
		}
	}
	private boolean isEmpty(){
		if(root==null){
			return true;
		}
		return false;
	}
	private Node delMin(Node root){
		if(root.left==null){
			return null;
		}
		if(!isRed(root.left) && !isRed(root.left.left)){
			root=moveRedLeft(root);
		}
		root.left=delMin(root.left);
		return balance(root);
	}
	private Node balance(Node root){
		if(isRed(root.right)){
			root=rotateLeft(root);
		}
		if(isRed(root.right) && !isRed(root.left)){
			root=rotateLeft(root);
		}
		if(isRed(root.left) && isRed(root.left.left)){
			root=leftLeft(root);
		}
		if(isRed(root.right) && isRed(root.left)){
			flipColor(root);
		}
		root.N=1+size(root.left)+size(root.right);
		return root;
	}
	private Node moveRedRight(Node root){
		flipColors(root);
		if(!isRed(root.left.left)){
			root=rotateRight(root);
		}
		return root;
	}
	public void delMax(){
		if(!isRed(root.left) && !isRed(root.right)){
			root.color=RED;
		}
		root=delMax(root);
		if(!isEmpty()){
			root.color=BLACK;
		}
	}
	private Node delMax(Node root){
		if(isRed(root.left)){
			root=rotateRight(root);
		}
		if(root.right==null){
			return null;
		}
		if(!isRed(root.right) && !isRed(root.right.left)){
			root=moveRedRight(root);
		}
		root.right=delMax(root.right);
		return balance(root);
	}
	public boolean contains(Key key){
		return get(key)!=null;
	}
	public void del(Key key){
		if(!isRed(root.left) && !isRed(root.right)){
			root.color=RED;
		}
		root=del(root,key);
		if(!isEmpty()){
			root.color=BLACK;
		}
	}
	private Node del(Node root,Key key){
		if(key.compareTo(root.key)<0){
			if(!isRed(root.left) && !isRed(root.left.left)){
				root=moveRedLeft(root);
			}
			root.left=del(root.left,key);
		}
		else{
			if(isRed(root.left)){
				root=rotateRight(root);
			}
			if(key.compareTo(root.key)==0 && (root.right==null)){
				return null;
			}
			if(!isRed(root.right) && !isRed(root.right.left)){
				root=moveRedRight(root);
			}
			if(key.compareTo(root.key)==0){
				root.val=get(root.right,min(root.right).key);
				root.key=min(root.right).key;
				root.right=delMin(root.right);
			}
		}
		return balance(root);
	}
	 private Node min(Node x) { 
	        // assert x != null;
	        if (x.left == null) return x; 
	        else                return min(x.left); 
	    } 

	public static void main(String[] args){
		System.out.println("=============TreeMapTest===============");
		TreeMap<Integer,String> tm=new TreeMap<>();
		tm.put(12, "frist");
		tm.put(24, "second");
		tm.put(44, "third");
		tm.put(11, "fourth");
		tm.del(24);
		System.out.println("size---> "+tm.size());
		System.out.println("get(24)---> "+tm.get(24));
		System.out.println("size---> "+tm.size());
		System.out.println("getMax()---> "+tm.getMax());
		System.out.println("getMin()---> "+tm.getMin());
		tm.delMin();
		System.out.println("size---> "+tm.size());
		System.out.println("getMin()---> "+tm.getMin());
		tm.delMax();
		System.out.println("size---> "+tm.size());
		System.out.println("getMax()---> "+tm.getMax());
		System.out.println("contains(24)---> "+tm.contains(24));
		
	}
}



















