import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * COP 3530: Project 2 - Stacks and PriorityQ Queues
 * <p>
 * Program reads in a country file and saves the data into a double-ended singly linked list implemented stack and doubly linked list priority queue.
 * The user can provide happiness index intervals for deletions in priority queue and print the priority queue.
 * 
 * @author Shirley Chen
 * @version 03/12/2025
 */
public class Project3
{
	/**
	 * Main method 
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args)
	{
		//Local variable declarations
		Scanner scnr = new Scanner(System.in);
		Stack countryStack = new Stack();
		PriorityQ countryPQ = new PriorityQ(); 
		File countryFile = null;
		Scanner fscnr = null;
		int userChoice = 0;
		
		//Display project title
		System.out.println("COP3530 Project 3\n");
		
		do
		{
			//Get file name
			System.out.println("Enter the file name: ");
			String fileName = scnr.next();
			
			//Find file and create file scanner
			try
			{
				countryFile= new File(fileName);
				fscnr = new Scanner(new File(fileName));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not found. Try again.\n");
				continue;
			}//end try-catch
			
		}while (!countryFile.exists()); //end do-while
		
		fscnr.nextLine(); //Skip header line
		
		while(fscnr.hasNext())
		{
			//Reads in each country's data
			String[] line = fscnr.nextLine().split(",");
			String name = line[0];
			String capital = line[1];
			int population = Integer.parseInt(line[2]);
			double gdp = Double.parseDouble(line[3]);
			double area = Double.parseDouble(line[4]);
			double happinessIndex = Double.parseDouble(line[5]);
			
			//Create and push country object onto stack only if its happiness index is greater than 4
			if(happinessIndex >= 4)
			{
				Country country = new Country(name, capital, population, gdp, area, happinessIndex);
				countryStack.push(country);
			}//end if
			
		}//end while
		
		//Print stack of countries
		System.out.println("\nStack Contents:");
		countryStack.printStack();
		
		//Pop countries from stack and insert into priority queue
		while(!(countryStack.isEmpty()))
		{
			Country newCountry = countryStack.pop();
			
			if(newCountry != null)
			{
				countryPQ.insert(newCountry);
			}//end if
			
		}//end while
		
		//Print country priority queue
		System.out.println("\nPriority Queue Contents:");
		countryPQ.printPriorityQ();
		System.out.println();
		
		do
		{
			//Display menu options
			System.out.println("1. Enter a happiness interval for deletions on priority queue\n" + 
								"2. Print the priority queue\n" +
								"3. Exit program\n" +
								"Enter your choice: ");
			
			//Get user menu choice and validate the input
			if(scnr.hasNextInt())
			{ 
				userChoice = scnr.nextInt();
				scnr.nextLine();
					
				if(userChoice >= 1 && userChoice <= 3)
				{
					//Call corresponding methods or end program based on user menu choice
					switch(userChoice)
					{
						case 1: 
							deleteHappinessInterval(countryPQ);
							break;
						case 2:
							countryPQ.printPriorityQ();
							break;		
						default:
							System.out.println("\nHave a good day!\n");	
							
					}//end switch
				}
				else
				{
					System.out.println("Invalid choice. Enter 1-3.");
				}//end first inner if-else
			}
			else
			{
				scnr.next();
				System.out.println("Invalid choice. Enter 1-3.");
			}//end outer if-else
			
			System.out.println();
			
		}while(userChoice != 3); //end outer do-while
		
		//Close scanners
		fscnr.close();
		scnr.close();
		
	}//end main
	
	/**
	 * Request happiness interval to be deleted from user and delete countries within given interval from priority queue
	 * 
	 * @param countryPQ The priority queue containing the countries
	 */
	public static void deleteHappinessInterval(PriorityQ countryPQ)
	{
		//Local variable declarations
		Scanner scnr = new Scanner(System.in);
		double high;
		double low;
		boolean validInterval = false;
		
		//Ask user for interval
		System.out.println("Enter happiness interval like [x,y]: ");
		
		do
		{
			//Read in user interval input and validate input
			String input = scnr.nextLine().trim();
			if(input.startsWith("[") && input.endsWith("]"))
			{
				input = input.substring(1, input.length()-1);
				String[] interval = input.split(",");
			
				try 
				{
					low = Double.parseDouble(interval[0]);
					high = Double.parseDouble(interval[1]);
				
					if(low > high)
					{
						validInterval = false;
						
						System.out.println("Invalid interval, first number must be no bigger than the second: ");
					}
					else
					{
						validInterval = true;
					
						if(countryPQ.intervalDelete(low, high))
						{
							System.out.println("\nCountries in priority queue with happiness values in [" + low + "," + high + "] are deleted.");
						}
						else
						{
							System.out.println("\nNo countries deleted. No countries in priority queue with happiness values [" + low + "," + high + "].");
						
						}//end fourth inner if-else
						
					}//end third inner if-else
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid interval, enter numbers: ");
					continue;
				}//end try-catch
			}
			else
			{
				System.out.println("Enter happiness interval like [x,y]: ");
			}//end second inner if-else
		
		}while(!validInterval); //end inner do-while
		
	}//end deleteHappinessInterval
	
}//end Project3 class