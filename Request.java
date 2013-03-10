/**WHO:Polina Soshnin
 *WHAT: CS 230 Exam 2 Problem 3
 *WHEN: October 27, 2012
 *MODIFIED: October 31, 2012
 *PURPOSE: Constructs a request object from two strings
 *String cityLeaving refers to the city requested to leave
 *String cityArriving refers to the city request to go to
 *This class makes a request, really simply 
 *String from a request from
 *String from a request to
 *
 *The Requests.java class uses this class to read in a text file 
 *containing requests and populates a LinkedList of those
 *request objects. 
 */

import java.util.*;

public class Request {

    //instance variables
   private  String cityLeaving; 
    private  String cityArriving; 

    public Request(String cityFrom, String cityTo) {
	this.cityLeaving=cityFrom;
	this.cityArriving=cityTo;

    }

    public String getCityLeaving() {
	return cityLeaving;
    }

    public String getCityArriving() {
	return cityArriving;
    }
    
    public String toString() {
	String s= "";
	s= "for flight between "+getCityLeaving()+" and "+getCityArriving();
	return s;

    }   
}