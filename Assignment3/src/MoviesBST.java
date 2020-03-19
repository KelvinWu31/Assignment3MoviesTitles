/* README 
 * 
 * Class: MoviesBST
 * 
 * Description: MoviesBST is used to sort all movie titles into alphabetical 
 * order using the data structures binary trees. It would use the movies class
 * to set and get all the moviesTitles and then sort them. Using the printSets 
 * method, it will call on itself recursively to print out all the childs into
 * alphabetical order.
 * 
 */
import java.util.*; 

public class MoviesBST {
	 Movies root; 
	
	
	private Movies recursiveAdd (Movies tree, Movies add) { 

		if (tree == null) {
			tree = add; 
		}
		else if (tree.compareTo(add) == 0) { 
			return tree; 
		}
		else if (tree.compareTo(add) < 0) { 
			tree.rightChild = recursiveAdd(tree.rightChild, add);
		}
		else if (tree.compareTo(add) > 0) { 
			tree.leftChild = recursiveAdd(tree.leftChild, add);
		}
		return tree;
		
	}
	
	public Movies printInOrder(Movies root) { 
		if (root == null) { 
			return null;
		}
		 
			printInOrder(root.leftChild);
			System.out.println(root.getTitle());
			printInOrder(root.rightChild);
			return null;
		
	}
	
	public void add(Movies add) { 
		root = recursiveAdd(root, add); 
	}
	
	public ArrayList<Movies> subList (ArrayList<Movies> array, Movies root, String start, String end) { 
		
		if (root == null) { 
			return array; 
		}
		 if(root.getTitle().compareToIgnoreCase(start) >= 0 && root.getTitle().compareToIgnoreCase(end) <= 0){
	            subList(array, root.leftChild,start,end);
	            array.add(root);
	            subList(array, root.rightChild,start,end);
	        }
	        //root is less than start
	        if(root.getTitle().compareToIgnoreCase(start) <= -1){
	            subList(array, root.rightChild,start,end);
	        }
	        //root is greater than end
	        if(root.getTitle().compareToIgnoreCase(end) >= 1){
	            subList(array, root.leftChild,start,end);
	        }

	        return array; 
	} // subList method that returns an ArrayList of movies bounded by 2 songs.
		
	public void printSet(Movies root, String start, String end){

        //case 1 root == null
        if(root == null){
            return;
        }
        //root is between bounds
        if(root.getTitle().compareToIgnoreCase(start) >= 0 && root.getTitle().compareToIgnoreCase(end) <= 0){
            printSet(root.leftChild,start,end);
            System.out.println(root.getTitle());
            printSet(root.rightChild, start, end);
        }
        
        // if root is less than start, then recursive call this method with the right child as parameter
        if(root.getTitle().compareToIgnoreCase(start) <= -1){
            printSet(root.rightChild , start, end);
        }
       
        //root is greater than end, then recursive call this method with the left child as parameter
        if(root.getTitle().compareToIgnoreCase(end) >= 1){
            printSet(root.leftChild, start, end);
        }

    }
	
}
