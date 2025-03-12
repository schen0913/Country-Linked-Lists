/**
 * Mimics a stack using a double-ended singly linked list to store country objects
 * 
 * @author Shirley Chen
 * @version 03/12/2025
 */
public class Stack 
{
	//Class variable declarations
	private Country topCountry;
	private Country bottomCountry;
	
	/**
	 * Constructor ton initialize the double-ended linked list country stack
	 */
	public Stack()
	{
		//Initialize class variables
		topCountry = null;
		bottomCountry = null;
		
	}//end Stack constructor
	
	/**
	 * Pushes a new country onto the stack (front of linked list)
	 * 
	 * @param newCountry The new country to be added to the stack
	 */
	public void push(Country newCountry)
	{
		//Check if stack/linked list is empty
		if(isEmpty())
		{
			topCountry = newCountry;
			bottomCountry = newCountry;
		}
		else
		{
			newCountry.setNextCountry(topCountry);
			topCountry = newCountry;
		}
		
	}//end push
	
	/**
	 * Pops and returns a country off the stack (front of linked list)
	 * 
	 * @return removedCountry The country that was removed from stack
	 */
	public Country pop()
	{
		Country removedCountry = topCountry;
		
		//Check if there is another country after
		if(topCountry.getNextCountry() != null)
		{
			topCountry = topCountry.getNextCountry();
		}
		else 
		{
			topCountry = null;
			bottomCountry = null;
		}
	
		return removedCountry;
	
	}//end pop
	
	/**
	 * Prints the stack from top to bottom without modifying
	 */
	public void printStack()
	{		
		//Display header
		System.out.println();
		System.out.println("Name                               Capital             GDPPC        APC          HappinessIndex");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		printCountryList(topCountry);
			
	}//end printStack
	
	/**
	 * Recursive method to print the data of each country in list without modifying
	 * 
	 * @param country The country in list with data to be printed
	 */
	private void printCountryList(Country country)
	{
		if(country == null)
		{
			return;
		}
		else
		{
			country.printCountry();
			printCountryList(country.getNextCountry());
			
		}//end if-else
		
	}//end printCountryList
	
	/**
	 * Checks if the stack is empty
	 * 
	 * @return true or false by checking if there is a country at the top of the stack
	 */
	public boolean isEmpty()
	{
		return (topCountry == null);
		
	}//end isEmpty
	
}//end Stack class