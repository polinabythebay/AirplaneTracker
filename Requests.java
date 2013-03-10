/**WHO:Polina Soshnin
 *WHAT: CS230 Exam 2 Problem 3
 *WHEN: October 27, 2012
 *MODIFIED: October 31, 2012
 *PURPOSE: Reads in a text file containing information 
 *about flight requests and their corresponding origin and 
 *destination airport codes
 *Constructs a linkedlist of request objects containing 
 *information about each flight request
 *
 *The StackSearch.java class uses this class to determine if 
 *the flight request can be matched to a path that exists
 *between two cities. 
 */

import java.io.*;    
import java.util.*;  
import java.net.*; 

public class Requests {

    //instance variables
    //a linked list of cities, each having a code and a name 
    LinkedList<Request> requests;
    
    public Requests(String fileName) { 

        requests= new LinkedList<Request>();
	populateRequestLL(fileName); 
	//populates a LinkedList of Request objects by reading in text
	//with Request information with the given filename	
    }

    /**reads in a file containing information about requests,
     *constructs request objects from each line
     *and stores those objects in a linkedlist
    */

    public void populateRequestLL (String txtFileName) {

	try{
	    Scanner reader= new Scanner(new File(txtFileName));
	    String line="";
	    while(reader.hasNext()) { //continue until we reach end of file
		//reads next line of input and prints it out
		line=reader.nextLine(); //next line is a string
		String[] split= line.split(" "); 
		//splits the given line into an array by space
		
		Request aRequest = new Request(split[0], split[1]); 
		requests.add(aRequest); //add request to requests linkedlist
	    }
	    reader.close();
	} catch (FileNotFoundException E) {
	    System.out.println("This file has no requests in it. Please try again.");
	}
    }

    public LinkedList<Request> getRequestLL() {
	return requests;
    }

    /**This method matches a request code with its city name 
     *and returns this flight information
     */

    public static String matchRequestsCityCodes(String s1, String s2) {
	Cities cityLL= new Cities("cities.txt"); //creates a cities LL
	int i=0;
	String s="for flight between ";

	for(i=0; i<cityLL.getCityLL().size(); i++) {
	    
	    if(cityLL.getCityLL().get(i).getCode().equals(s1))
		{
		    s=s+Cities.getCityLL().get(i).getName();
		    //get city leaving request

		}
	}
	for(i=0; i<cityLL.getCityLL().size(); i++) {
	    
	    if(cityLL.getCityLL().get(i).getCode().equals(s2))
		{
		    s=s+" and "+Cities.getCityLL().get(i).getName();
		    //get city arriving request
		}
	}
	return s;
    }

    public int size() {
	return requests.size();
    }
    
}