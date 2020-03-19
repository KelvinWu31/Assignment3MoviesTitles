/* README
 * 
 * Class:Movies
 * 
 * Description: The class Movies has five parts: constructor that reads in the data, 
 * setters & getters to allow for other classes to call upon the data and a readScanner 
 * method that breaks down the data that is being read in into movieID, title, genres and 
 * release year. It also contains a toString method that allows the user to print out the 
 * movie title and compareTo Method that MoviesBST class can call to compare left and right
 * childs to sort into alphabetical order.
 * 
 */
import java.util.*;

public class Movies implements Comparable <Movies> {
	
	private String title;
	private int releaseYear; 
	public Movies leftChild; 
	public Movies rightChild; 
	private String[] genres; 
	private int movieID; 
	
	public Movies(int movieID, String title, int releaseYear, String[] genres) { 
		this.movieID = movieID; 
		this.title = title; 
		this.releaseYear = releaseYear; 
		this.genres = genres;
		
	}
	
	// sets the title using a Movies Constructor
	public Movies(String title) { 
		this.title = title; 
	}
	
	// sets the title using a setter method
	public void setTitle (String title) { 
		this.title = title; 
	}
	
	public String getTitle() { 
		return title;
	}
	
	public int releaseYear () { 
		return releaseYear; 
	}
	
	public int getMovieID(){
        return movieID;
    }
	
	public String[] getGenres(){
		return genres;
	}
	
	 public static Movies readMovie (Scanner in){
	        if(!(in.hasNextLine()))
	            return null;
	        String input = in.nextLine();
	        //retrieves movieID by creating substring up to first comma
	        
	        String inputID = input.substring(0,input.indexOf(','));
	        
	        int ID = Integer.parseInt(inputID);
	        //removes the substring that was taken out
	        
	        input = input.substring(input.indexOf(',')+1);
	        //retrieves the movie title from the second comma

	        String titleTest = input.substring(0, input.lastIndexOf(","));
	        String title;
	        int releaseDate = 0000;
	        if(!titleTest.contains("(")){
	            title = titleTest;
	            input = input.substring(input.lastIndexOf(",")+1);
	        }
	        else {
	            boolean correctSpot = false;
	            int parenthesis = input.indexOf('(');
	            while (!correctSpot) {
	                if (Character.isDigit(input.charAt(parenthesis + 1)) && Character.isDigit(input.charAt(parenthesis + 2)) && Character.isDigit(input.charAt(parenthesis + 3)) && Character.isDigit(input.charAt(parenthesis + 4))) {
	                    correctSpot = true;
	                } else {
	                    parenthesis = input.indexOf('(', parenthesis + 1);
	                }
	            }
	            title = input.substring(0, parenthesis - 1);
	            //deletes substring that was taken out
	        
	            input = input.substring(parenthesis + 1);
	            //retrieves movie's releaseYear
	            
	            String release = input.substring(0 , input.indexOf(')'));
	            
	            //should there if be two dates, then retrieves the first
	            if(release.contains("–")) {
	                release = release.substring(0, 4);
	            }
	            releaseDate = Integer.parseInt(release);
	            //removes substring that was taken out
	            input = input.substring(input.indexOf(')')+2);
	        }

	        //retrieves movie genres and stores into array of strings 
	        
	        String [] genres = new String[1];
	        if(input.contains("no genres"))
	        	    genres[0] = " ";
	        else if (!(input.contains("|")))
	            genres[0] = input;
	        else
	            genres = input.split("\\|");
	        return new Movies (ID, title, releaseDate, genres);
	    }
	 public String toString () { 
		 return title + " " + releaseYear; 
	 }
	 
	 @Override
	 public int compareTo(Movies other) { 
		 return title.compareToIgnoreCase(other.title);
	 }
}
