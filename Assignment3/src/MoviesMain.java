/*README
 * 
 * Class: MoviesMain
 * 
 * Description: The main method finds the file, sets up the empty ArrayList,
 *then calls the readMovies to sort the appropriate categories, then createas
 * binary search tree that keeps count of movies. 
 * 
 * OUTPUT: 
 * In separate file
 * 
 */

import java.util.*;
import java.io.*;
public class MoviesMain {

	public static void main(String[] args) throws Exception {
		
		Scanner outFile = new Scanner(new File("movies.csv"));
		
		outFile.nextLine();
		
		ArrayList <Movies> movies = new ArrayList<>();
		
		while(outFile.hasNextLine()) { 
			movies.add(Movies.readMovie(outFile));
		}
		
		for (Movies movie : movies) { 
			if (movie.getTitle().charAt(0) == '"') {
				movie.setTitle(movie.getTitle().substring(1));
			}
		} // end of enhanced for loop
		
		// creating a Binary Search tree object
		
		MoviesBST movieBST = new MoviesBST();
		
		int count = 0; 
		
		for(Movies movieList : movies) { 
			movieBST.add(movieList);
			count++;
		}
		System.out.println(count + " Movies added into BST\n");
        //bst.printInOrder(bst.root);

        //Uses subSetList in order to print subset between two songs
        System.out.println("The subset of movies between Bug's Life AND Harry Potter and the Sorcerer's Stone (a.k.a. Harry Potter and the Philosopher's Stone) is:");
        ArrayList<Movies> subset = new ArrayList<>();
        subset = movieBST.subList(subset, movieBST.root,"Bug's Life","Harry Potter and the Sorcerer's Stone (a.k.a. Harry Potter and the Philosopher's Stone)");
      
        for(Movies titles : subset){
            System.out.println(titles.getTitle());
        }
        System.out.println();

        System.out.println("The subset of movies between Back to the Future AND Hulk is: ");
        movieBST.printSet(movieBST.root,"Back to the Future","Hulk");

        System.out.println();

        System.out.println("The subset of movies between Toy Story AND WALL·E: ");
        movieBST.printSet(movieBST.root,"Toy Story","WALL·E");

        //print output to file
        printToFile(count,movieBST);

    }

    public static void printToFile(int count, MoviesBST bst)throws Exception{

        //print to file
        PrintStream output = new PrintStream(new FileOutputStream(new File("../output/output.txt")));
        output.println(count + " Movies added into BST\n");

        //Uses subSetList in order to print subset between two songs
        output.println("The subset of movies between Bug's Life AND Harry Potter and the Sorcerer's Stone (a.k.a. Harry Potter and the Philosopher's Stone) is:");
        ArrayList<Movies> subset = new ArrayList<>();
        subset = bst.subList(subset, bst.root,"Bug's Life","Harry Potter and the Sorcerer's Stone (a.k.a. Harry Potter and the Philosopher's Stone)");
        for(Movies titles : subset){
            output.println(titles.getTitle());
        }
        output.println();

        subset.clear();
        output.println("The subset of movies between Back to the Future AND Hulk is: ");
        subset = bst.subList(subset, bst.root,"Back to the Future","Hulk");
        for(Movies titles : subset){
            output.println(titles.getTitle());
        }

        output.println();

        subset.clear();
        output.println("The subset of movies between Toy Story AND WALL·E: ");
        subset = bst.subList(subset, bst.root,"Toy Story","WALL·E");
        for(Movies titles : subset){
            output.println(titles.getTitle());
        }
    

		
	} //end of Main Method

} // end of MoviesMain
