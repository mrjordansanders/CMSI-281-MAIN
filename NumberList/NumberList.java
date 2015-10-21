/**     

    <b>Note: Corrections have been made to the return types for both toArray() methods. (2015-10-13).</b>

    An object of this class represents a number list, i.e., an ordered collection
    of integers, each of Java class <a href="http://docs.oracle.com/javase/7/docs/api/java/lang/Long.html">Long</a>, 
    with duplicates permitted. Be sure to read the Java documentation on
    <a href="http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html">interface java.util.Collection</a>.

*/

import java.util.Arrays;


public class NumberList implements java.util.Collection {

	private int actSize = 0;
	private Object myList[];
  

    /** Constructs an empty number list. */
    public NumberList(){
        myList = new Object[10];
    }
	
    /** Constructs a number list from an array of Longs. */
    public NumberList(Long[] l ){

		
		myList = new Object[l.length];
		for(int i = 0; i < myList.length; i++){
			long tempLong = l[i];
			int convertedLong = (int) tempLong;
			myList[i] = convertedLong;
		}
    }
    
    /** Increases by one the number of instances of the given element in this collection. */
    public boolean add(Object obj ) {
        if(myList.length - actSize <= 5){
            myList = Arrays.copyOf(myList, myList.length * 2);
        }
		
		myList[actSize] = obj;
		actSize++;
		
		return true;
    }
    

    /** Adds all of the elements of the given number list to this one. */
    public boolean addAll (java.util.Collection c  ) {
		
        /*while(myList.length <= (myList.length + this.length)){
            myList = Arrays.copyOf(myList, myList.length * 2);
        }
		
		for(int b = 0; b < this.length; b++){
			myList[actSize] = this[b];
			actSize++;
		}
		return true;*/
		 throw new UnsupportedOperationException();
    }
 

    /** Removes all of the elements from this collection. */
    public void clear () {
		for(int i = 0; i < actSize; i++){
			myList[i] = null;
		}
    }
 

    /** Returns true iff this number list contains at least one instance of the specified element. */
    public boolean contains ( Object obj ) {
        for(int i = 0; i < myList.length; i++){
			if(obj.equals(myList[i])){
				return true;
			}
			return false;
			}
		return false;
	}
 


    /** Returns true iff this number list contains at least one instance of each element 
        in the specified list. Multiple copies of some element in the argument do not
        require multiple copies in this number list. */
    public boolean containsAll ( java.util.Collection c ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }
 
 


    /** Compares the specified object with this collection for equality. */
    public boolean equals ( Object obj ) {
		/*
		while(myList.length <= (myList.length + obj.length)){
            myList = Arrays.copyOf(myList, myList.length * 2);
        }
		
		for(int j = 0; j > obj.length; j++){
			result = myList[j].equals(obj);
		}*/
        throw new UnsupportedOperationException();
    }
 



    /** Returns the hashcode value for this collection. */
    public int hashCode () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Returns true if this collection contains no elements. */
    public boolean isEmpty () {
        if(actSize == 0){
			return true;
		} else {
			return false;
		}
    }



    /** Returns an iterator over the elements in this collection. Replicated elements should
        be "iterated over" just once. */
    public java.util.Iterator iterator () {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }



    /** Removes a single instance of the specified element from 
        this collection, if it is present. */
    public boolean remove ( Object obj ) {
        /*String removed = myArray[obj];
		String[] temp = new String[obj];
		
		for(int i = 0, j = 0; i < myList.length; i++){
			if (i != obj) {
				temp[j++] = myList[i].toString();
			}
		}
		myList = temp;
		return removed;*/
		throw new UnsupportedOperationException();
    }



    /** Removes all of this collection's elements that are also contained 
        in the specified collection. */
    public boolean removeAll ( java.util.Collection c ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }




	/** Retains only the elements in this collection that are contained in the specified collection. 
		 In other words, removes from this collection all of its elements that are not contained in the 
		 specified collection. */
	public boolean retainAll ( java.util.Collection c ) {
		throw new UnsupportedOperationException();
	}


    /** Returns the number of elements in this number list, including duplicates. */
    public int sizeIncludingDuplicates () {
        int arraySize = (myList.length - 1);
        return arraySize;
    }
    
    

    /** Returns a Long[] containing all of the elements in this collection, not including duplicates. */
    public Long[] toArray () {
		/*Long[] toArray = new Long[myList.length];
		toArray = Arrays.copyOf(actSize, myList);
		return toArray;*/
		throw new UnsupportedOperationException();
    }



    /** Not supported for this class. */
    public Object[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
    }




    /** Returns the number of elements in this number list, not including duplicates. */
    public int size () {
		throw new UnsupportedOperationException();
    }




    /** Returns the number of instances of the given element in this number list. */
    public int count (Object obj) {
        int count = 0;
		for (int i = 0; i > myList.length; i++) {
			String j = obj.toString();
			if (j.equals(myList[i])) {
			count++;
			}
		}
		return count;
    }
    

    
    /** This returns a stringy version of this number list. */
    public String toString () { // overrides Object.toString()
		String listString = "";
		String s;

		for(int j = 0; j < myList.length; j++){
			s = "";
			s = String.valueOf(myList[j]);
			listString += s + ", ";
		}
		return listString;
    }


    
    /** This so-called "static factory" returns a new number list comprised of the numbers in the specified array.
        Note that the given array is long[], not Long[]. */
    public static NumberList fromArray ( long[] l ) {
        /* REPLACE THE NEXT STATEMENT WITH YOUR CODE */
        throw new UnsupportedOperationException();
    }

    
    /** This main method is just a comprehensive test program for the class. */
    public static void main ( String[] args ) {
		
		NumberList mal = new NumberList();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(500000000));
		
		System.out.println(mal);
		System.out.println(mal.size());
	}
}
