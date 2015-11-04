
public class LinkedDeque{
	private Node leftEnd;
	private Node rightEnd;
	private int size;


	public LinkedDeque() { // Makes an empty LinkedDeque
		size = 0;
    }

		
	public void InsertLeft(Object o){ // Inserts an item at the front of the LinkedDeque
		Node newNode = new Node(o);   
  		if(size == 0){
  			leftEnd = rightEnd = newNode; 
  		} else {
  			leftEnd.setLeftLink(newNode);  
  			newNode.setRightLink(leftEnd);  
  			leftEnd = newNode;  
  		}
  		size++;
	}
	
	public void InsertRight(Object o){ // Inserts an item at the end of the LinkedDeque
		Node newNode = new Node(o);  
  		newNode.right = null;  
  		if(size == 0){
  			rightEnd = leftEnd = newNode; 
  		} else {
  			rightEnd.setRightLink(newNode);  
  			newNode.setLeftLink(rightEnd);  
  			rightEnd = newNode;  
  		}
  		size++;
	}
	
	public void deleteLeft(){ // Delete the item at the front
		leftEnd = leftEnd.returnRightLink();
		size--;
	}
	
	public void deleteRight(){ // Delete the item at the end
		rightEnd = rightEnd.returnLeftLink();
		size--;
	}
	
	public Object left(){ //Returns the front of the list
		return leftEnd;
	}
	
	public Object right(){ //Returns the end of the list
		return rightEnd;
	}
	
	public int size(){ //Returns the size of the list
		return size;
	}
	
	public String toString (){ //converts the Deque into a String
		Node node = leftEnd;
		String stringOfDeque = "";
		String nodeData = "";
    	for(int j = 0; j < size; j++){
    			nodeData = "" + node.item;
    			stringOfDeque +=("[" + node.item + "]");
    			node = node.right;
        }
        return stringOfDeque;
    }

	class Node {
		private Object item;
		private Node left;
		private Node right;

		public Node(Object o){
			item = o;
		}

		public void setLeftLink(Node link){
			left = link;
		}

		public void setRightLink(Node link){
			right = link;
		}

		public Node returnRightLink(){
			return right;

		}

		public Node returnLeftLink(){
			return left;
		}

    }
	
	public static void main (String[] args ){
		LinkedDeque d = new LinkedDeque();

		//testing InsertLeft, InsertRight methods on types of different sizes, Left, Right, and Size methods
		d.InsertLeft(1.5);
		d.InsertRight(2);
		d.InsertRight("Hello, My Name is Jordan!");
		System.out.println(d.toString());
		System.out.println(d.size());
		d.InsertLeft(d.left());
		d.InsertRight(d.right());
		System.out.println(d.toString());

		//testing of DeleteRight and DeleteLeft Methods
		d.deleteRight();
		d.deleteLeft();
		System.out.println(d.toString());	
	}
}	
