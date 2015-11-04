import java.util.Iterator;

public class LinkedDeque<Item> implements Iterable<Item>{
	private int size; //The size of the deque
	private Node before; //Placemarker for the beginning of a list
	private Node after; //Placemarker for the end of a list

	public LinkedDeque() { // Makes an empty LinkedDeque
		before = new Node();
		after = new Node();
		before.next = after;
		after.previous = before;
    }

		
	public void InsertLeft(Item item){ // Inserts an item at the front of the LinkedDeque
		size++;
		Node node = new Node();
		node.item = item; //Sets the node's item to the passed in item
		node.previous = before; // Sets the node's previous value to before, marking it at the front
		node.next = before.next; // Sets the node's next value to the old first node(before.next)
		before.next.previous = node; //Sets old first item's previous to the new Node making the Old first second in the list
		before.next = node; //Sets before's next to the new Node making the new Node first in the list
	}
	
	public void InsertRight(Item item){ // Inserts an item at the end of the LinkedDeque
		size++;
		Node node = new Node();
		node.item = item; //Sets the node's item to the passed in item
		node.next = after; //Sets the node's previous value to after, marking it at the end
		after.previous.next = node; //Sets old last node's next to the new node 
		node.previous = after.previous; //Sets new node's previous to old last node
		after.previous = node; //Now after's previous is the new node making it last in the list
	}
	
	public void DeleteLeft(){ // Delete the item at the front
		size--;
		Node first = before.next; //Gets the first node
		Node second = first.next; //Gets the second node
		second.previous = before; //Sets second's previous to before
		before.next = second; //Sets before's next to second
	}
	
	public void DeleteRight(){ // Delete the item at the end
		size--;
		Node last = after.previous; //Gets the last node
		Node second2Last = after.previous.previous; //Gets the second to last node
		second2Last.next = after; //Sets second2Last's next to after
		after.previous=second2Last; //Sets after's previous to second2last
		
	}
	
	public Object left(){ //Returns the front of the list
		Node first = before.next;
		return first.item;
	}
	
	public Object right(){ //Returns the end of the list
		Node last = after.previous;
		return last.item;
	}
	
	public int size(){ //Returns the size of the list
		return size;
	}
	
	public String toString (){ //converts the Deque into a String
	}
	
	public Iterator<Item> iterator(){ // return an iterator over items in order from front to end
     return new LinkedDequeIterator();
    }
	
	private class LinkedDequeIterator implements Iterator<Item>{
		Node current = before;
		
		public boolean hasNext(){
			return current.next != after;
		}
		
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;   
		}
	}
	
	private class Node{
		private Item item;
		private Node next;
		private Node previous;
    }
	
	public static void main ( String[] args ){
		LinkedDeque d = new LinkedDeque();

		d.addFirst(1);
		d.addLast(2);
		d.addFirst(3);
		Iterator i = d.iterator();
		System.out.println(i.hasNext());
		while(i.hasNext()){
			System.out.println(i.next());
		}	
	}
}		
