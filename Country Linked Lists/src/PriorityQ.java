/**
 * Mimics a priority queue using a doubly linked list to store country objects
 * 
 * @author Shirley Chen
 * @version 03/12/2025
 */
public class PriorityQ
{
	//Class variable declarations
	private Country firstCountry;
	private Country lastCountry;
	
	/**
	 * Constructor to initialize the doubly linked list country priority queue
	 */
	public PriorityQ()
	{
		//Initialize class variables
		firstCountry = null;
		lastCountry = null;
		
	}//end PriorityQ constructor
	
	/**
	 * Inserts a country into the priority queue based on their happiness index with higher happiness indexes given higher priority (at the front of list)
	 * 
	 * @param newCountry The new country to be inserted
	 */
	public void insert(Country newCountry)
	{
		//Check if priority queue is empty
		if(isEmpty())
		{
			//Set first and last country in queue to new country if priority queue is empty
			firstCountry = newCountry;
			firstCountry.setPrevCountry(null);
			lastCountry = newCountry;
			lastCountry.setNextCountry(null);
		}
		else
		{			
			//Check if the new country should be inserted at the beginning of the list 	
			if(firstCountry.getHappinessIndex() < newCountry.getHappinessIndex())
			{
				newCountry.setNextCountry(firstCountry);
				firstCountry.setPrevCountry(newCountry);
				firstCountry = newCountry;
				firstCountry.setPrevCountry(null);
			}
			else
			{
				Country currentCountry = firstCountry;
				
				//Find location in linked list to insert new country
				while((currentCountry.getNextCountry() != null) && (currentCountry.getNextCountry().getHappinessIndex() > newCountry.getHappinessIndex()))
				{
					currentCountry = currentCountry.getNextCountry();
				
				}//end while
				
				//Check if currentCountry country is the last country in the list
				if(currentCountry.getNextCountry() == null)
				{
					lastCountry = newCountry;
					lastCountry.setNextCountry(null);
				}
				else 
				{
					newCountry.setNextCountry(currentCountry.getNextCountry());
					currentCountry.getNextCountry().setPrevCountry(newCountry);
					
				}//end second inner if-else
				
				newCountry.setPrevCountry(currentCountry);
				currentCountry.setNextCountry(newCountry);
				
			}//end first inner if-else
			
		}//end outer if-else
		
	}//end insert
	
	/**
	 * Remove country from priority queue with highest priority (front of the list)
	 * 
	 * @return removedCountry The country that was removed from priority queue
	 */
	public Country remove()
	{
		//Check if priority queue is empty
		if(isEmpty())
		{
			return null;
		}
		
		Country removedCountry = firstCountry;
		
		//Check if the country removed is not the last country in priority queue
		if(removedCountry.getNextCountry() != null)
		{
			firstCountry = removedCountry.getNextCountry();
		}
		else
		{
			firstCountry = null;
			lastCountry = null;
		}
		
		return removedCountry;
	}//end remove
	
	/**
	 * Delete from sorted priority queue countries within a given happiness index interval
	 * 
	 * @param lowVal The lower bound of the interval
	 * @param highVal The upper bound of the interval
	 * @return true or false if any countries were deleted
	 */
	public boolean intervalDelete(double lowVal, double highVal)
	{
		//Check if interval is outside of the range of country happiness indexes in priority queue
		if(firstCountry.getHappinessIndex() < lowVal || lastCountry.getHappinessIndex() > highVal)
		{
			return false;
		}
		
		//Initialize pointer variables
		Country begCountry = firstCountry;
		Country endCountry = lastCountry;
		
		//Find country with highest happiness index within the given interval from the sorted priority queue
		while(begCountry != null && begCountry.getHappinessIndex() > highVal)
		{
			begCountry = begCountry.getNextCountry();
		
		}//end while
		
		//Find country with lowest happiness index within the given interval from the sorted priority queue
		while(endCountry != null && endCountry.getHappinessIndex() < lowVal)
		{
			endCountry = endCountry.getPrevCountry();
		
		}//end while
		
		//Remove countries within the given happiness index interval 
		if(begCountry == firstCountry && endCountry == lastCountry)
		{
			firstCountry = null;
			lastCountry = null;
		}
		else if(begCountry == firstCountry)
		{
			firstCountry = endCountry.getNextCountry();
			firstCountry.setPrevCountry(null);
		}
		else if(endCountry == lastCountry)
		{
			lastCountry = begCountry.getPrevCountry();
			lastCountry.setNextCountry(null);
		}
		else
		{
			begCountry.getPrevCountry().setNextCountry(endCountry.getNextCountry());
			endCountry.getNextCountry().setPrevCountry(begCountry.getPrevCountry());
		}

		return true;
	
	}//end intervalDelete
	
	/**
	 * Prints the priority queue from highest to lowest priority without modifying the queue
	 */
	public void printPriorityQ()
	{
		//Display header
		System.out.println();
		System.out.println("Name                               Capital             GDPPC        APC          HappinessIndex");
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		printCountryList(firstCountry);
		
	}//end printPriorityQ
	
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
		
		country.printCountry();
		printCountryList(country.getNextCountry());
		
	}//end printCountryList
	
	/**
	 * Checks if the stack is empty
	 * 
	 * @return true or false by checking if there is a country in the priority queue
	 */
	public boolean isEmpty()
	{
		return (firstCountry == null);
		
	}//end isEmpty
	
}//end PriorityQ class