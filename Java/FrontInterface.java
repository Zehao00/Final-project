import java.util.Scanner;

public class FrontInterface 
{

	public static void main(String[] args) 
	{
		System.out.print("Welcome to this bus management system!!!" + "\n" + "\n");
		System.out.print("Please enter a number to select a functionality :" + "\n");
		System.out.print("Finding shortest paths(1)" + "\n");
		System.out.print("Searching for a bus stop(2)" + "\n");
		System.out.print("Searching for all trips with a given arrival time(3)" + "\n");
		
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
					
				}
				else if(choice == 2)
				{
					System.out.print("Searching for a bus stop" + "\n");
					while( choice != 0 )
					{
						SearchingTrips tree = new SearchingTrips("stops.txt");
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
