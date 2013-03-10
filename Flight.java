/**WHO:Polina Soshnin
 *WHAT: CS 230 Exam 2 Problem 3
 *WHEN: October 27, 2012
 *MODIFIED: October 31, 2012
 *PURPOSE: Constructs a flight object from three strings
 *and an integer
 *String homeCity refers to the airport code of the origin city
 *String destinationCity refers to the airport code of
 *the destination city
 *String flightNum refers to the number ID of the flight
 *Integer price refers to the cost of the flight
 *
 *The Flights.java class uses this class to read in a text file
 *containing information about flights and populates a LinkedList
 *of flight objects. 
 */

import java.util.*;

public class Flight {

    //instance variables
    private  String homeCity;
    private  String destinationCity; 
    private String flightNum;
    private int price;
    
    public Flight(String aHome, String aDestination, String aNum, 
		  int aprice) {
	this.homeCity=aHome;
	this.destinationCity=aDestination;
	this.flightNum=aNum;
	this.price=aprice;
	
    }

    public String getHomeCity() {
	return homeCity;
    }

    public String getDestinationCity() {
	return destinationCity;
    }

    public String getFlightNum() {
	return flightNum;
    }
    
    public int getPrice() {
	return price;
    }
    
   
    public String toString() {
	String s="";
	s="WA"+flightNum+" from "+getHomeCity()+" to "+getDestinationCity();
	return s;
    }   
}