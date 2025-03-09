/**
 * Sets, stores, returns, and prints a country's data
 * 
 * @author Shirley Chen
 * @version 03/09/2025
 */
public class Country 
{
	//Class variable declarations
	private Country prevCountry;
	private Country nextCountry;
	private String name;
	private String capital;
	private int population;
	private double gdp;
	private double area;
	private double happinessIndex;
	
	/**
	 * Constructor to initialize the country's data
	 * 
	 * @param name The country's name
	 * @param capital The country's capital
	 * @param population The country's population
	 * @param gdp The country's GDP
	 * @param area The country's area
	 * @param happinessIndex The country's happiness index
	 */
	public Country(String name, String capital, int population, double gdp, double area, double happinessIndex)
	{
		//Initialize country variables
		this.prevCountry = null;
		this.nextCountry = null;
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.gdp = gdp;
		this.area = area;
		this.happinessIndex = happinessIndex;
	
	}//end Country constructor
	
	/**
	 * Returns the reference to the previous country in the linked list
	 * 
	 * @return prevCountry The previous country in linked list
	 */
	public Country getPrevCountry() {
		return prevCountry;
	
	}//end getPrevCountry

	/**
	 * Sets reference to the previous country in the linked list
	 * 
	 * @return prevCountry The previous country in linked list
	 */
	public void setPrevCountry(Country prevCountry) {
		this.prevCountry = prevCountry;
	
	}//end setPrevCountry

	/**
	 * Returns the reference to the next country in the linked list
	 * 
	 * @return nextCountry The next country in linked list
	 */
	public Country getNextCountry() {
		return nextCountry;
	
	}//end getNextCountry

	/**
	 * Sets reference to the next country in the linked list
	 * 
	 * @return nextCountry The next country in linked list
	 */
	public void setNextCountry(Country nextCountry) {
		this.nextCountry = nextCountry;
	
	}//end setNextCountry

	/**
	 * Returns country's name
	 * 
	 * @return name The country's name
	 */
	public String getName() 
	{
		return name;
	
	}//end getName
	
	/**
	 * Sets country's name
	 * 
	 * @param name The country's name
	 */
	public void setName(String name) 
	{
		this.name = name;
	
	}//end setName
	
	/**
	 * Returns country's capital
	 * 
	 * @return capital The country's capital
	 */
	public String getCapital() 
	{
		return capital;
	
	}//end getCapital

	/**
	 * Sets the country's capital
	 * 
	 * @param capital The country's capital
	 */
	public void setCapital(String capital) 
	{
		this.capital = capital;
	
	}//end setCapital

	/**
	 * Returns the country's population
	 * 
	 * @return population The country's population
	 */
	public int getPopulation() 
	{
		return population;
	
	}//end getPopulation

	/**
	 * Sets the country's population
	 * 
	 * @param population The country's population
	 */
	public void setPopulation(int population) 
	{
		this.population = population;
	
	}//end setPopulation

	/**
	 * Returns the country's GDP
	 * 
	 * @return gdp The country's GDP
	 */
	public double getGdp() 
	{
		return gdp;
	
	}//end getGdp

	/**
	 * Sets the country's GDP
	 * 
	 * @param gdp The country's GDP
	 */
	public void setGdp(double gdp) 
	{
		this.gdp = gdp;
	
	}//end setGdp

	/**
	 * Returns the country's area
	 * 
	 * @return area The country's area
	 */
	public double getArea() 
	{
		return area;
	
	}//end getArea

	/**
	 * Sets the country's area
	 * 
	 * @param area The country's area
	 */
	public void setArea(double area) 
	{
		this.area = area;
	
	}//end setArea

	/**
	 * Returns the country's happiness index
	 * 
	 * @return happinessIndex The country's happiness index
	 */
	public double getHappinessIndex() 
	{
		return happinessIndex;
	
	}//end getHappinessIndex

	/**
	 * Sets the country's happiness index
	 * 
	 * @param happinessIndex The country's happiness index
	 */
	public void setHappinessIndex(double happinessIndex) 
	{
		this.happinessIndex = happinessIndex;
	
	}//end setHappinessIndex
	
	/**
	 * Prints the country's data
	 */
	public void printCountry()
	{
		System.out.printf("%-35s%-20s%-13.3f%-13.6f%-14.3f\n", name, capital, gdp/population, area/population, happinessIndex);
	
	}//end printCountry

}//end Country class