/**WHO: Polina Soshnin
 *WHAT: CS230 Exam 2 Problem 3
 *WHEN: October 27, 2012
 *MODIFIED: October 31, 2012
 *PURPOSE: Create a network of available flights to and from a list
 *of cities, and evaluate a list of flight requests to determine if 
 *there is a path between the requests. If so, prints out an 
 *iterinary and total cost.
 *Uses Flights, Flight, Cities, City, Requests, Request Classes 
 *as well as reads in information from the cities, flights, and 
 *requests text files
 */
 
import java.util.*;

public class StackSearch {

  // code to implement the search for a path between two nodes of a graph

  public static LinkedList<String> makeList (String S) {
    // creates a LinkedList from the characters of S, with each node of 
    // the list containing a String of one character
    LinkedList<String> L = new LinkedList<String>();
    for (int i = 0; i < S.length(); i++) 
      L.add(S.substring(i, i+1));
    return L;
  }
    /**creates a graph of graphnodes, each node representing 
     *a city and pointing to a flight available from it to 
     *a destination city
     */

    public static LinkedList<GraphNode> makeGraph () {
 // creates a LinkedList that stores information about a sample graph
 // to be searched
 LinkedList<GraphNode> graph = new LinkedList<GraphNode>();
 //for loop through entire city LL, creating a graphnode for each city
 //and adding a neighborlist for each corresponding city 
 Cities acity= new Cities("cities.txt"); 
 Flights aflight= new Flights("flights.txt");
 int i=0;
 for(i=0; i<acity.getCityLL().size();i++){
     String s=acity.getCityLL().get(i).getCode();
     LinkedList<String> aNeighborList= aflight.listofNeighbors(i);
     graph.add(new GraphNode(s, aNeighborList));
     //creates a graph of graphnodes, each node representing 
     //a city and pointing to an available flight between it 
     //and its destination city        
 }
 return graph;
    }
    /**Given a graph label, returns list of neighbors
     */
    public static LinkedList<String> getNeighborList (String label, LinkedList<GraphNode> graph) {
 // given the label for a node of the graph, returns list of neighbors
 GraphNode node;
 for (int i = 0; i < graph.size(); i++) {
     node = graph.get(i);
     if ((node.getLabel()).equals(label))
  return node.getNeighbors();
 }
 return new LinkedList<String>();
    }

    /*returns true if a string is contained in a String linkedlist
     */

    public static boolean isMember (String S, LinkedList<String> L) {
 
 for (int i = 0; i < L.size(); i++)
     if (L.get(i).equals(S))
  return true;
 return false;
    }

    /**Removes nodes of the neighbor list whose contents are
     *contained in the visited list
     */
    public static void removeVisitedNeighbors (LinkedList<String> neighbors, 
          LinkedList<String> visited) {
   int i = 0;
 while (i < neighbors.size()) {
     if (isMember(neighbors.get(i), visited))
  neighbors.remove(i);
     else
  i++;
 }
    }

    public static void searchGraph (LinkedList<GraphNode> graph, String start, 
      String goal) {
 // finds a path in the graph from the start node to the goal node, 
 // using the depth-first search strategy
 String current = start;                  // current node during search
 LinkedList<String> visited = new LinkedList<String>();   
 // list of visited nodes
 visited.add(start);
 LinkedList<String> neighbors = new LinkedList<String>(); 
 // list of neighboring nodes
 Stack<String> pathStack = new Stack<String>();           
 // stores the current path
 pathStack.push(start);                         
 // through the graph
 while (!current.equals(goal)) {      // while the goal is not reached..
     // get the neighbors of the current node
     neighbors = getNeighborList(current, graph);
     // remove neighbors that have already been visited
     removeVisitedNeighbors(neighbors, visited);
     if (neighbors.isEmpty()) { // no new nodes can be reached,
  //and if stack is empty then we can conclude that there is no path      
  pathStack.pop(); 
                 // so back-up the search to
  if(!pathStack.empty()){
      current = pathStack.peek();     // a previous node
  }else{
      current=goal; 
      //we make current equal to goal to end while loop
      System.out.println("Request for flight between "+Flights.connectCodestoName(start)+" and "+Flights.connectCodestoName(goal)+":"+"\n"+
      "Sorry, there is no connection between these two cities at this point.");}
     } else {   // proceed to a new node of the graph
  current = neighbors.get(0);
  pathStack.push(current);
  visited.add(current);
     } 
   }
    
 if(!pathStack.empty()){ //if we found a path, print out the itinerary
     System.out.println(printPathStack(pathStack,start, goal));
 }
    }

    /**If there is/are flights between two request cities, prints out
     *itinerary and price 
     */

    public static String printPathStack(Stack<String> aPathStack, String aStart, String aGoal){
 Stack<String> tempStack= new Stack<String>();
 String s ="Itinerary "+Requests.matchRequestsCityCodes(aStart, aGoal)+":"; 
 int n=0;
 int totalPrice=0;
 while(!aPathStack.empty()) {
     String s1= aPathStack.pop();
     tempStack.push(s1);
     n++;
 } //spills contenst of stack into temp
 while(n>1){
     String s3= tempStack.pop(); //gets code for first leg of journey
     String s4= tempStack.peek(); //gets code for second leg of journey
     s=s+"\n"+Flights.matchFlightsCityCodes(s3, s4);
     totalPrice=totalPrice+Flights.connectCodestoFlightCost(s3, s4);
     n--; //when n=1, there is one left and you do not go further
 } 
 s=s+"\n"+"Total cost: $"+totalPrice;
 return s;
    }

    //NOTE:
    //Bug #1: Successful itineraries print out but when an
    //unsuccessful itinerary is printed out, all subsequent 
    //itineraries are printed out as unsuccessful, regardless
    //of whether they are successful or not.In other words, DESTRUCTIVE! D':

    public static void main (String[] args) {
 LinkedList<GraphNode> graph = makeGraph();
 
 int i=0;
 Requests aRequest= new Requests("requests.txt");
 for(i=0; i<aRequest.size(); i++){
     String s1=aRequest.getRequestLL().get(i).getCityLeaving();
     String s2=aRequest.getRequestLL().get(i).getCityArriving();
     searchGraph(graph, s1, s2);
     System.out.println("*****");
 }
    }

}
