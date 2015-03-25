/**
 * Taxi operates a Taxi cab and tracks miles driven, gas in tank and fares earned
 * Allows for adding of gas and calculation of fares for given mileage
 * 
 * @author Raymond
 */
package edu.trident.Smith.Assignment4;


public class Taxi 
{

	protected final double MPG = 17.8;
	protected final double FARE_PER_MILE = 0.585;
	public static final double TANK = 22.9;
	protected double gas;
	protected double milesDriven;
	protected double milesAvail;
	protected double earnings;
	
	/**
	 * Constructor for Taxi
	 * 
	 */
	public Taxi()
	{
		gas = TANK;
		milesDriven = 0.0;
		milesAvail = MPG * TANK;
		earnings = 0.0;
	}
	
	/**
	 * Records the trip taken according to the miles and calculates the fare for trip
	 * Totals the fare and miles with totals thus far
	 * @param miles
	 * @return fare
	 */
	public double recordTrip(double miles)
	{
		double fare;
		if (miles > 0)
		{
			
			if (miles < milesAvail)
			{
				gas -= (miles/MPG);
				milesDriven += miles;
				milesAvail = gas * MPG;
				fare  = 2.00 + (miles * FARE_PER_MILE);
				earnings += fare;				
			}
			else
			{
				fare = -1.0;
			}/*End if enough miles available*/
		}
		else
			{
				fare = -2.0;
			}/*End if miles are above 0*/
		
		return Math.ceil(fare*100)/100;
		
		
	}/*End recordTrip*/
	
	/**
	 * Add gas to the gas tank and update amount of gas
	 * Return amount of gas added 
	 * 
	 * @param fill
	 * @return allowed
	 */
	public int addGas(double fill)
	{
		int allowed;
		if (fill > 0)
		{
			if (TANK >= fill + gas)
			{
				gas += fill;
				milesAvail = gas * MPG;
				allowed = 1;
			}
			else
			{
				gas = TANK;
				milesAvail = gas*MPG;
				allowed = 0;
			}/*End if gas to be filled is too much*/
		}
		else
		{ 
			allowed = -1;
		}
		return allowed;
	}/*End addGas*/
	
	/**
	 * Returns the amount of gas in tank
	 * @return gas
	 */
	public double getGas()
	{
		return gas;
	}/*End getGas*/
	
	/**
	 * Returns amount miles driven since last reset
	 * @return milesDriven
	 */
	public double getMilesDriven()
	{
		return milesDriven;
	}/*End getMilesDriven*/
	
	/**
	 * Returns miles available on the current tank of gas
	 * @return milesAvail
	 */
	public double getMilesAvail()
	{
		return milesAvail;
	}/*End  getMilesAvail*/
	
	/**
	 * Returns earnings since last reset
	 * @return earnings
	 */
	public double getEarnings()
	{
		return earnings;
	}/*End getEarnings*/
	
	/**
	 * Reset milesDriven and earnings to 0
	 * @return none
	 */
	public void reset()
	{
		milesDriven = 0.0;
		earnings = 0.0;
	}/*End reset*/
	
}/*End Taxi class*/
