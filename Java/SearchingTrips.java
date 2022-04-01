import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SearchingTrips 
{
	public SearchingTrips()
	{
		
	}
	
	
    public void readTime(String file, List<String> stop, List<String> time) 
    {	
    	  String fileName = file;
    	  
    	  try
    	  {
    		  File timer = new File(fileName);
    		  Scanner scanner = new Scanner(timer);
      	      String[] data = scanner.nextLine().trim().split(",");
      	      
      	      while(scanner.hasNextLine())
      	      {
      	    	  data = scanner.nextLine().trim().split(",");
      	    	  StringBuilder arrivalTime = new StringBuilder();
      	    	  arrivalTime.append(data[1]);
      	    	  String[] theTime = data[1].trim().split(":");
      	    	  String alTime = arrivalTime.toString();
      	    	  String info = alTime + "," + data[3];
      	    	  
      	    	  if((Integer.parseInt(theTime[0]) >= 0) && (Integer.parseInt(theTime[0]) <= 23) && (Integer.parseInt(theTime[1]) >= 0) 
      	    		   && (Integer.parseInt(theTime[1]) <= 59) && (Integer.parseInt(theTime[2]) >= 0) && (Integer.parseInt(theTime[2]) <= 59))
      	    	  {
      	    		   time.add(alTime);
      	    		   stop.add(info);
      	    	  }
      	      }
      	      scanner.close();
    	  }catch(Exception e) {return;}
    }
    
    
    public List<String> result(String fileName)
    {
    	List<String> stopList = new LinkedList<String>();
    	
    	try
    	{
    		File file = new File(fileName);
  		    Scanner scanner = new Scanner(file);
    	    String data = scanner.nextLine();
    	    
    	    while(scanner.hasNextLine())
    	    {
    	    	data = scanner.nextLine();
    	    	stopList.add(data);
    	    }
    	    scanner.close();
    	}catch(Exception e) {};
    	
    	return stopList;
    }
}