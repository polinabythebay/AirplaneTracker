/**WHO:Polina Soshnin
 *WHAT: CS 230 Exam 2 Problem 3 
 *WHEN: October 27, 2012
 *MODIFIED: October 31, 2012
 *PURPOSE: Constructs a city object from two strings
 *String code is the airport code for a city, i.e. ANC or JFK
 *String name is the name of the city, i.e. "Anchorage, AK"
 *The Cities.java class uses this class to read in a text file
 *containing cities and airport codes and populates a LinkedList
 *of city objects.
 */

import java.util.*;

public class City {

    //instance variables
    private  String code; //code for the city, ie. ANC or ATL
    private  String name; //name for the city, ie. "Atlanta, GA" or "New York, NY"
    public City(String acode, String aname) {
	this.code=acode;
	this.name=aname;
    }

    public String getCode() {
	return code;
    }
    public String getName() {
	return name;
    }
    public String toString() {
	return code; 
    }

}