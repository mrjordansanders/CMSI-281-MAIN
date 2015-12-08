import java.util.Stack;
import java.util.Iterator;
import java.util.ArrayList;

public class BinaryTree implements Iterable{
	private Node root;
	private int size;
	private Node cursor;


	//Binary Tree Constructors
	public BinaryTree(){
		size = 0;
	}

	public BinaryTree(Object obj){
		Node newNode = new Node(obj);
		root = newNode;
		cursor = newNode;
		size = 1;
	}

	//Binary Tree Comparison Methods
	public boolean contains(Object obj){
		throw UnsupportedOperationException;
	}

	public boolean similar(BinaryTree b){
		return similarTrees(this.root, b.root);
	}

	public boolean equals(BinaryTree b){
		return equalTrees(this.root, b.root);
	}

	//Binary Tree Adding/Deleting Methods

	public boolean putCursorAtRoot(){
		if(root == null && size == 0){
			return false;
		} else {
			cursor = root;
			return true;
		}
	}
	public boolean putCursorAtLeftSon(){
		Node newNode = cursor;
		if(newNode.getLeftSon() == null){
			return false;
		} else {
			cursor = newNode.getLeftSon();
			return true;
		}
	}

	public boolean putCursorAtRightSon(){
		Node newNode = cursor;
		if(newNode.getRightSon() == null){
			return false;
		} else {
			cursor = newNode.getRightSon();
			return true;
		}
	}

	public boolean putCursorAtFather(){
		Node newNode = cursor;
		if(newNode.getFather() == null){
			return false;
		} else {
			cursor = newNode.getFather();
			return true;
		}
	}

	public boolean attachLeftSonAtCursor(Object obj){
		Node newNode = new Node(obj);

		if(cursor.getLeftSon() == null){
			cursor.setLeftSon(newNode);
			newNode.setFather(cursor);
			size++;
			return true;
		} else {
			return false;
		}
	}

	public boolean attachRightSonAtCursor(Object obj){
		Node newNode = new Node(obj);

		if(cursor.getRightSon() == null){
			cursor.setRightSon(newNode);
			newNode.setFather(cursor);
			size++;
			return true;
		} else {
			return false;
		}
	}

	public boolean pruneFromCursor(){
		Node father = cursor.getFather();

		if(father.getLeftSon() == cursor){
			father.setLeftSon(null);
			cursor.setFather(null);
		} else if(father.getRightSon() == cursor){
			father.setRightSon(null);
			cursor.setFather(null);
		} else {
			return false;
		}
		int nodesLost = inOrder().size();
		size = size - nodesLost;
		return true;
	}

	public boolean isEmpty(){
		if(size != 0){
			return false;
		} else {
			return true;
		}
	}

	public boolean similarTrees(Node lhs, Node rhs){
	    if (lhs == null && rhs == null){
	        return true;
	    }
	    if ((lhs == null && rhs != null) || (lhs != null && rhs == null)){
	        return false;
	    }
	    return equalTrees(lhs.getLeftSon(), rhs.getLeftSon()) && equalTrees(lhs.getRightSon(), rhs.getRightSon());
	}

	public boolean equalTrees(Node lhs, Node rhs) {
    	if (lhs == rhs) {
        	return true;
    	}
    	if (lhs == null || rhs == null) {
        	return false;
    	}
   		return lhs.item.equals(rhs.item) && equalTrees(lhs.getLeftSon(), rhs.getLeftSon()) && equalTrees(lhs.getRightSon(), rhs.getRightSon());
	} 

	public InOrderIterator inOrder(){
		return new InOrderIterator(this);
	}

	public PreOrderIterator iterator(){
		return new PreOrderIterator(this);
	}

	private class InOrderIterator implements Iterator{
		Stack<Node> s = new Stack<Node>();
		ArrayList<Object> lst = new ArrayList<Object>();
		int offset = 0;

  		public InOrderIterator(BinaryTree b){
  			if(b.root == null){
  				return;
  			}

  			Node currentNode = b.root;

  			while(!s.empty() || currentNode != null){
  				if(currentNode != null){
     				s.push(currentNode);
     				currentNode = currentNode.getLeftSon();
     			} else {
     				Node n = s.pop();
     				lst.add(n.item);
     				currentNode = n.getRightSon();
     			}
  			}
  		}

		public boolean hasNext(){
     		if(next() == null){
     			return false;
     		}else {
     			return true;
  			}
  		}

		public void remove() {
    		throw new UnsupportedOperationException();
		}

		public Node next(){
			Node n = new Node(lst.get(offset));
			offset++;
			return n;
     	}

     	public int size(){
     		return lst.size();
     	}
   	}

   	private class PreOrderIterator implements Iterator{

		Stack<Node> s = new Stack<Node>();
		ArrayList<Object> lst = new ArrayList<Object>();
		int offset = 0;

  		public PreOrderIterator(BinaryTree b){
  			if(b.root == null){
  				return;
  			}

  			s.push(b.root);

  			while(!s.empty()){

  				Node n = s.pop();
  				lst.add(n.item);

  				if(n.getRightSon() != null){
  					s.push(n.getRightSon());
  				}

  				if(n.getLeftSon() != null){
  					s.push(n.getLeftSon());
  				}
  			}
  		}

		public boolean hasNext(){
     		if(next() == null){
     			return false;
     		}else {
     			return true;
  			}
  		}

		public void remove() {
    		throw new UnsupportedOperationException();
		}

		public Node next(){
			Node n = new Node(lst.get(offset));
			offset++;
			return n;
     	}
   	}


	

	//Node class
	private class Node {
		private Object item;
		private Node lson;
		private Node rson;
		private Node father;

		//Node Constructor
		public Node(Object obj){
			item = obj;
		}

		public Node(Node n){
			if(n != null){
				item = n.item;
				lson = n.lson;
				rson = n.rson;
				father = n.father;
			} else {
				item = null;
				lson = null;
				rson = null;
				father = null;
			}
		}

		//Set Node Values
		public void setLeftSon(Node link){
			lson = link;
		}

		public void setRightSon(Node link){
			rson = link;
		}

		public void setFather(Node link){
			father = link;
		}

		public boolean hasChild(Node link){
			if(lson != null && rson != null){
				return true;
			} else {
				return false;
			}
		}

		//Return Node Values
		public Node getLeftSon(){
			return lson;
		}

		public Node getRightSon(){
			return rson;
		}

		public Node getFather(){
			return father;
		}

		public Object ItemToString(){
			return item.toString();
		}
	}
}
