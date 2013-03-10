/**WHO: Polina Soshnin
 *WHAT: CS230 Exam 2 Problem 3
 *WHEN: October 27, 2012
 *MODIFIED: n/a
 *PURPOSE: creates GraphNode objects used to construct a graph
 *
 *Flight objects stored in the flights linkedlist are implemented
 *as GraphNodes in constructing a network (graph) or flight information
*/

import java.util.*;

public class GraphNode {

  // new class to store information about the label and neighbors
  // of a node of a graph to be searched
  
  // instance variables

  private String label;
  private LinkedList<String> neighbors;

  // constructor
  
    //name is going to be getHomeCity
    //GetDestinationCity is going to be a neighbor
  public GraphNode (String name, LinkedList<String> neighborList) {
    label = name;
    neighbors = neighborList;
  }

  // instance methods
  
  public String getLabel () {
    return label;
  }

  public LinkedList<String> getNeighbors () {
    return neighbors;
  }

  public String toString () {
    return label;
  }

}
