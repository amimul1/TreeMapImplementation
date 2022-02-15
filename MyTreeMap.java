/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: MyTreeMap.java
* ASSIGNMENT: Programming Assignment 10 - Generic TreeMap
* COURSE: CSc 210;  Fall 2021
* PURPOSE: This program implements a generic TreeMap using a Binary 
* search tree by making using of binary search tree. It uses recursive methods
* to traverse through the tree to add, remove and adjust the nodes.
*
* USAGE: 
* java MyTreeMap.java
*
* ----------- EXAMPLE COMMANDS -------------
*	MyTreeMap<String, Integer> tmap = new MyTreeMap<>();		
*		tmap.put("Jack", 4237);
*		tmap.put("Jill", 4257);
*		tmap.put("Pat", 3232);
*       tmap.get("Tom"):
*		          -------
*
* The commands shown above are all of the commands that are supported
* by this program. It is assumed that (except for some specific errors), 
* the input is well-formed, and matches the format shown above.
*/
// import statements 

import java.util.HashSet;
//Generic parameterized types 
public class MyTreeMap<K, V> 
{
	//field variables
	BinarySearchTreep<K, V> bst;
	private int size;
	private HashSet<K> keySet;
	/*
	* Constructor which instantiates a BinarySearchTreep object
	*
	*/
	public MyTreeMap() {
		bst = new BinarySearchTreep<>();
		size = 0;
		keySet = new HashSet<K>();
	}
	/*
	* put method puts(associates) the specified value with the 
	* specified key in the map. It is stored in the correct position 
	* by recursing through the binary search tree.
	* @param K, Key a key of generic type K.
	* V value, a value to be associated with the key.
	* @return V value, he previous value associated with key, or 
	* null if there was no mapping for key
	*/		
	public V put(K key, V value){
		if (get(key) == null) {
			size++;
			bst.add(key, value);
			keySet.add(key);
			return null;
		}
		else {
			V previousValue = get(key);
			bst.delete(key);
			bst.add(key, value);
			return previousValue;
		}	
	}
	/*
	* Returns the value to which the specified key is mapped, 
	* or null if this map contains no mapping for the key
	* @param K,key - the key whose associated value is to be returned
	* @return V,the value to which the specified key is mapped, 
	* or null if this map contains no mapping for the key
	*/		
	public V get(K key){
		return bst.get(key);
	}
	/*
	* this method returns the boolean result 
	* if a key is contained in the hash table
	* @param K,key- the key to be checked
	* @return boolean ,the result of the search
	*/
	public boolean containsKey​(K key){
		return bst.containsKey(key);
	}
	/*
	* this method  Returns true if this map maps 
	* a key to the specified value
	* @param V,val - the value whose presence is to be checked
	* @return boolean ,the result of the search
	*/
	public boolean containsValue(V val){
		return bst.containsValue(val);
	}
	/*
	* remove method Removes the mapping for the specified key 
	* from this map if present.	
	* @param K key - whose mapping is to be removed from the map
	* V value, a value to be associated with the key.
	* @return V value, the previous value associated with key, 
	* or null if there was no mapping for key.
	*/		
	public V remove​(K key) {
		if (get(key) != null){
			size--;
			V previousValue = get(key);
			keySet.remove(key);
			bst.delete(key);
			return previousValue;
		}	
		else {
			return null;
		}
	}
	/*
	 * This method prints a representation of the Treemap and the 
	 * by including the keys and values of the nodes of the bst.
	 * @return Void, instead using a print statement.
	 * @param none.
	 */
	public void printTree(){
		bst.print();
	}
	/*
	 * This method returns the string representation of the
	 * TreeMap.
	 * @return String ,the string representation.
	 */
	public String toString(){
		return bst.toString();
	}
	/*
	* this method Returns a Set view of the keys
	*  contained in this map.
	* @param none
	* @return a set of the keys.
	*/
	public java.util.Set<K> keySet(){
		return keySet;
	}
	/*
	* this method Returns the number of key-value 
	* mappings in this map.
	* @param none
	* @return int count ,the count of mappings
	*/
	public int size() {
		return size;
	}
	/*
	* this method Removes all of the mappings from this map.
	* @return  void changed mapping.
	* @param none 
	*/
	public void	clear() {
		bst.clear();
		keySet = new HashSet<K>();
		size = 0;
	}
	/*
	* this method Returns true if this map contains
	*  no key-value mappings.
	* @param none
	* @return boolean ,the result of emptiness
	*/
	public boolean	isEmpty() {
		return (size==0);
	}
}


class BinarySearchTreep<K,V> 
{
	/*
	* A class that creates a node for keeping both the keys and the 
	* values together in a same unit.
	*
	*/
    private class Node
    {    
    	public K key;
        public V value;    
        public Node left;  
        public Node right;  
        //contrcutor of the node class.  
        public Node(K key, V value) 
        {    
    		this.key = key;
    		this.value = value;
    		this.left = null;    
            this.right = null;    
        }    
    }    
    // the root is initialized to null.
    public Node root = null;       

    /* This methods compares the two keys and 
    returns +1 if key 'a' > key 'b'
    returns  0 if key 'a' = key 'b'
    returns -1 if key 'a' < key 'b'
    @param K a the first key
    @param K b the second key
    */
    private int compare(K a, K b){
    	return ((Comparable<K>)a).compareTo(b);
    }  
    /* This methods compares the two values and 
    returns +1 if key 'a' > key 'b'
    returns  0 if key 'a' = key 'b'
    returns -1 if key 'a' < key 'b'
    @param V a the first value
    @param V b the second value
    */
    private int compareVal(V a, V b){
    	return ((Comparable<V>)a).compareTo(b);
    }
	/*
	* add method adds a node of the specified key and value in
	* in the right position of the bst 
	* It is stored in the correct position 
	* by recursing through the binary search tree.
	* @param K, Key a key of generic type K.
	* V value, a value to be associated with the key.
	*/	
    
    public void add(K key, V value) {
        root = addRecur(root, key, value);
    }

    private Node addRecur(Node curr, K key, V value) {
        if (curr == null) 
            return new Node(key, value);

        if (compare(key, curr.key) < 0)
            curr.left = addRecur(curr.left, key, value);
        else if (compare(key, curr.key) > 0) 
            curr.right = addRecur(curr.right, key, value);
        else
            return curr;

        return curr;
    }    
	/*
	* Returns the value to which the specified key is mapped, 
	* or null if this map contains no mapping for the key contains 
	* a helper recursive method getRecur.
	* @param K,key - the key whose associated value is to be returned
	* @return V,the value to which the specified key is mapped, 
	* or null if this map contains no mapping for the key
	*/	
    public V get(K key) {
        return getRecur(root, key);
    }
		
    private V getRecur(Node curr, K key) {
        if (curr == null)
            return null;
        if (compare(key, curr.key) == 0)
            return curr.value;
        // recursive call
        return compare(key, curr.key) < 0 ? getRecur(curr.left, key) : getRecur(curr.right, key);
    } 
    
	/*
	* this method returns the boolean result 
	* if a key is contained in the Tree
	* Contains a recursive helper method
	* @param K,key- the key to be checked
	* @return boolean ,the result of the search
	*/
    public boolean containsKey(K key) {
        return containsRecur(root, key);
    }
	/*
	* this method is a recursive helper method 
	* which traverses through the tree and finds 
	* if a key is contained in the hash table
	* @param K,key- the key to be checked
	* Node curr - the current node.
	*/
    private boolean containsRecur(Node curr, K key) {
        if (curr == null)
            return false;
        if (compare(key, curr.key) == 0)
            return true;
        return compare(key, curr.key) < 0 ? containsRecur(curr.left, key) : containsRecur(curr.right, key);
    }
	/*
	* this method returns the boolean result 
	* if a value is contained in the Tree
	* Contains a recursive helper method
	* @param V,val- the key to be checked
	* @return boolean ,the result of the search
	*/
    public boolean containsValue(V val) {
        return containsValRecur(root, val);
    }
	/*
	* this method is a recursive helper method 
	* which traverses through the tree and finds 
	* if a values is contained in the hash table
	* @param V,val- the key to be checked
	* Node curr - the current node.
	*/
    private boolean containsValRecur(Node curr, V val) {
        if (curr == null)
            return false;
        if (compareVal(val, curr.value) == 0)
            return true;
        return compareVal(val, curr.value) < 0 ? containsValRecur(curr.left, val) : containsValRecur(curr.right, val);
    } 
    
	/*
	* delete method Removes the mapping for the specified key 
	* from this map if present. It has a recursive helper 
	* method to traverse and find the specific node 
	* and adjust the nodes of the bst afterwards.	
	* @param K key - whose mapping is to be deleted from the map
	*/	
    
    public void delete(K key) {
        root = deleteRecur(root, key);
    }   
    private Node deleteRecur(Node curr, K key) {
    	//  if the key not in tree
        if (curr == null)  
            return null;

        if  (compare(curr.key,key) == 0) {
        	// remove this node
        
        	if (curr.left == null && curr.right == null)
        	    return null;
        	else if (curr.right == null) 
        		// replace this node with left child
        	    return curr.left;
        	else if (curr.left == null) 
        		// replace this node with right child
        	    return curr.right;
        	else
        	{
        		//finding the max node.
        		Node n = maxNode(curr.left);
        		curr.key = n.key;
        		curr.value = n.value;
        		curr.left = deleteRecur(curr.left, n.key);
        		return curr;
        	}
        }
        else
        {
        	if  (compare(key,curr.key) < 0)//(key < curr.key) 
        		curr.left = deleteRecur(curr.left, key);
        	else
        		curr.right = deleteRecur(curr.right, key);

        	return curr;
        }
    } 
 	/*
  	* This  method returns the max node of the bst or any 
  	* sub tree.	
  	* @param Node root of the tree 
  	*/	
    private Node maxNode(Node root) {
    	//ternary operator
        return root.right == null ? root : maxNode(root.right);
    } 
    /*
	 * This recursive method traverses the tree in order  and 
	 * prints the  keys and values of the nodes of the bst.
	 * @return Void, instead using a print statement.
	 * @param none.
	 */
    public void traverseInOrder(Node node) {
        if (node != null) {
        	//recursive 
            traverseInOrder(node.left);
            System.out.println(node.key + ", " + node.value);
            traverseInOrder(node.right);
        }
    }  
	/*
	 * This method prints a representation of the Treemap by the 
	 * printing the  keys and values of the nodes of the bst.
	 * traversing in order.
	 * @return Void, instead using a print statement.
	 * @param none.
	 */
    public void print() {    
    	traverseInOrder(root);
    }
	/*
	* this method Removes all of nodes by setting the 
	* rot reference of the bst to null.
	* @return  void changed mapping.
	* @param none 
	*/
    public void clear() {
    	root = null;
    }

}


