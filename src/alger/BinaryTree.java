package alger;


public class BinaryTree {

    private class Node {

        int key;
        String name;

        Node leftChild;
        Node rightChild;
        
        //Node parent;

        Node(int key, String name) {

            this.key = key;
            this.name = name;

        }

        public String toString() {

            return "key: "+key + "\nvalue: " +name;

		/*
         * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

        }

    }

    Node root;
    private Node add(Node root,int key,String name){
    	if(root==null){
    		return new Node(key,name);
    	}
    	int cmp=root.key>key?1:root.key==key?0:-1;
    	if(cmp<0){
    		root.rightChild=add(root.rightChild,key,name);
    	}
    	if(cmp>0){
    		root.leftChild=add(root.leftChild,key,name);
    	}
    	if(cmp==0){
    		root.name=name;
    	}
    	return root;
    }
    public void addNode(int key, String name) {
    	root=add(root,key,name);
    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth

    public static void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            // Traverse the left node

            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node

            System.out.println(focusNode);

            // Traverse the right node

            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    public static void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }

    }

    public static void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);

        }
    }

    public Node findNode(int key) {

        // Start at the top of the tree

        Node focusNode = root;

        // While we haven't found the Node
        // keep looking

        while (focusNode.key != key) {

            // If we should search to the left

            if (key < focusNode.key) {

                // Shift the focus Node to the left child

                focusNode = focusNode.leftChild;

            } else {

                // Shift the focus Node to the right child

                focusNode = focusNode.rightChild;

            }

            // The node wasn't found

            if (focusNode == null)
                return null;

        }

        return focusNode;

    }    

    public int size() {
        return size(root);
    }
private int size(Node temp){
	if (temp == null) return 0;
    return 1 + size(temp.leftChild) + size(temp.rightChild);
}
    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50, "Boss");

        theTree.addNode(25, "Vice President");

        theTree.addNode(15, "Office Manager");

        theTree.addNode(30, "Secretary");

        theTree.addNode(75, "Sales Manager");

        theTree.addNode(85, "Salesman 1");
        
        theTree.addNode(75, "john conner");

        preorderTraverseTree(theTree.root);
        System.out.println("============================");
        inOrderTraverseTree(theTree.root);
        System.out.println("============================");
        postOrderTraverseTree(theTree.root);
        System.out.println("============================");
        System.out.println(theTree.size());
        System.out.println(theTree.findNode(75));
        System.out.println(theTree.findNode(15));

    }
}