import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FrontInterface 
{

	public static void main(String[] args) 
	{
		System.out.print("Welcome to this bus management system!!!" + "\n" + "\n");
		System.out.print("Please enter a number to select a functionality :" + "\n");
		System.out.print("Finding shortest paths(1)" + "\n");
		System.out.print("Searching for a bus stop(2)" + "\n");
		System.out.print("Searching for all trips with a given arrival time(3)" + "\n");
		System.out.print("Quit(0)" + "\n");
		
		int choice = 0;
		boolean quit = false;
		
		do
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			
			if(input.hasNextInt())
			{
				choice = input.nextInt();
				input.nextLine();
				System.out.print("\n");
				
				if(choice == 1)
				{	
					System.out.print("Finding shortest paths" + "\n");
					while( choice != 0 )
					{
						System.out.print("Please enter two bus stop :" + "\n");
						if(input.hasNextInt())
					    {
					    	int start = input.nextInt();
					    	if(start != 0)
					    	{
					    		int end = input.nextInt();
					    		
					    		EdgeWeightedDigraph theGraph = new EdgeWeightedDigraph(12478);
					    		String file = "transfers.txt";
					    		theGraph.readData(file, theGraph);
					    		ShortestPaths path = new ShortestPaths(theGraph, start);
					    		List<DirectedEdge> pathList = new Stack<DirectedEdge>();
					    		pathList = path.pathTo(end);
					    		
					    		if(path.hasPath(end))
					    		{
					    			for (int i = pathList.size()-1; i >= 0; i--) 
					    			{
					                    System.out.print(pathList.get(i) + "\n");
					                }
					    			System.out.print("\n");
					    		}
					    		else
					    		{
					    			System.out.print("No path exists between these stop" + "\n\n");
					    		}
					    	}
					    	else
					    	{
					    		choice = 0;
					    	}
					    }
					    else if(input.hasNext())
					    {
					    	System.out.print("Input error" + "\n\n");
					    	input.nextLine();
					    }
					}
					System.out.print("\n" + "Please enter a number to select a functionality again:" + "\n");
				}
				else if(choice == 2)
				{
					System.out.print("Searching for a bus stop" + "\n");
					while( choice != 0 )
					{
						SearchingBusStop tree = new SearchingBusStop("stops.txt");
					    System.out.print("Please enter a bus stop name :" + "\n");
					    if(input.hasNextInt())
					    {
					    	choice = input.nextInt();
					    	if(choice != 0)
					    	{
					    		System.out.print("Input error!" + "\n");
					    	}
					    }
					    else if(input.hasNext())
					    {
					    	String theName = input.nextLine();
					    	tree.StopInformation(theName).forEach((Stop) -> 
					    	{
								System.out.print(Stop + "\n");
							});
					    }
					}
					
					System.out.print("\n" + "Please enter a number to select a functionality again:" + "\n");
				}
				else if(choice == 3)
				{
					System.out.print("Searching for the trips" + "\n");
					while( choice != 0 )
					{
                        System.out.print("Please enter a arrival time:" + "\n");
					    if(input.hasNextInt())
					    {
					    	choice = input.nextInt();
					    	if(choice != 0)
					    	{
					    		System.out.print("Input error!" + "\n\n");
					    	}
					    }
					    else if(input.hasNext())
					    {
					    	List<String> stop = new LinkedList<String>();
						    List<String> time = new LinkedList<String>();
						    SearchingTrips trips = new SearchingTrips();
						    trips.readTime("stop_times.txt", stop, time);
						    List<String> info = new LinkedList<String>();
						    info = trips.result("stops.txt");
					    	String theTime = input.nextLine();
					    	StringBuilder theInput = new StringBuilder();
					    	theInput.append(theTime);
					    	String first = theInput.substring(0,1);
					    	if(!Character.isDigit(first.charAt(0)))
					    	{
					    		System.out.print("Please enter a correct time!!\n");
					    	}
					    	
					    	else
					    	{
					    	for(int i = 0; i < time.size(); i++)
					    	{
					    		if(time.get(i).trim().equals(theTime))
					    		{
					    			String[] id = stop.get(i).split(",");
					    			
					    			for(int j = 0; j < info.size(); j++)
					    			{
					    				String[] dataSet = info.get(j).split(",");
					    				if(dataSet[0].equals(id[1]))
					    				{
					    					 StringBuilder name = new StringBuilder();
					    					 name.append(dataSet[2]);
					    					 if(name.substring(0, 2).equals("WB") || name.substring(0, 2).equals("EB") || name.substring(0, 2).equals("NB") || name.substring(0, 2).equals("SB")) 
					    					 {
					    						 String prefix = name.substring(0, 2);
					    		    			 name.delete(0, 3);
					    		    			 name.append(" " + prefix);
					    		    	     }
					    		    	    	
					    		    	     if(name.substring(0, 8).equals("FLAGSTOP"))
					    		    	     {
					    		    	    	 String prefix = name.substring(0, 11);
					    		    	    	 name.delete(0, 12);
					    		    	    	 name.append(" " + prefix);
					    		    	     }
					    		    	     
					    		    	     String theStop = name.toString();
					    					 System.out.print(theStop + "\n" + "stop_id : " + dataSet[0] + "\n" + "stop_code : " + dataSet[1]
					    							 + "\n" + "stop_desc : " + dataSet[3] + "\n" + "stop_lat : " + dataSet[4] + "\n"
					    							 + "stop_lon : " + dataSet[5] + "\n" + "zone_id : " + dataSet[6] + "\n" + "location_type : " + dataSet[8] + "\n\n");
					    				}
					    			}
					    		} 
					    	}
					    	}
					    }
					}
					System.out.print("\n" + "Please enter a number to select a functionality again:" + "\n");
				}
				else if(choice == 0)
				{
					quit = true;
				}
			}
			else
			{
				System.out.print("Input error!" + "\n" + "Please enter a number :" + "\n");
			}
			
		}while((choice != 0) || (quit == false));
		
		System.out.print("Goodbye!");
	}

}
