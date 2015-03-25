/**
 * UpgradedTaxi extends the Taxi class adding in abilities to track need 
 * for service, operating costs, and gas costs.  Also the ability to return 
 * net earnings and service the vehicle
 * 
 * @author Raymond Smith
 */
package edu.trident.Smith.Assignment4;

public class UpgradedTaxi extends Taxi 
{

	private double serviceMiles;
	private double operCost;
	private MaintenanceAlert alert = null;
	
	/**
	 * Constructor for UpgradedTaxi class
	 * @param startFuel
	 * @param ui1
	 */
	public UpgradedTaxi(double startFuel, NewTaxiUI ui1)
	{
		super();
		if(startFuel >= TANK)
		{
			gas = TANK;
		}
		else
		{
			gas = startFuel;
		}
		
		milesAvail = gas * MPG;
		serviceMiles = 0.0;
		operCost = 0.0;
	}/*End UpgradedTaxi*/
	
	/**
	 * Set the alert to be able to be called
	 * @param m
	 */
	public void setMaintenanceAlert(MaintenanceAlert m)
	{
		alert = m;
	}/*End setMaintenanceAlert*/
	/**
	 * Records trips taken and returns fares
	 * @param miles
	 * @return fare
	 */
	public double record(double miles)
	{
		double fare;
		if (serviceMiles < 100)
		{
			fare = recordTrip(miles);
		
			if (fare > 0 )
			{				
			serviceMiles += miles;
			}/*End if to only add service miles if miles available*/
			
			if(serviceMiles >= 100)
			{
				if (alert != null)
				{
					String serviceNeed = "<html><b><u>You must service the Taxi after finishing this fare!</u></b></html>";
					String title = "NEED SERVICE";					
					alert.maintenanceNeeded(title, serviceNeed);
				}
			}/*End if to call maintenance alert*/
		}	
		else
		{
			fare = -5.0;
		}/*End if service miles are over 100 miles*/		
		return fare;		
	}/*End record*/
	
	/**
	 * Adds gas to the car and records cost of gas
	 * @param fill
	 * @param price
	 * @return allowed
	 */
	public int adGas(double fill, double price)
	{
		double cost;
		if((fill + gas) >= TANK)
		{
			cost = (TANK-gas)*price;
		}
		else
		{
			 cost = fill * price;
		}
		int allowed = addGas(fill);
		operCost += cost;
		
		return allowed;
	}/*End adGas*/
	
	/**
	 * Resets Fares earned, miles driven and operating costs
	 */
	public void res()
	{
		reset();
		operCost = 0.0;
	}/*End res*/
	
	/**
	 * Returns net earnings 
	 * @return net
	 */
	public double netEarns()
	{
		double net = earnings - operCost;
		
		return net;
	}/*End netEarns*/
	
	/**
	 * service vehicle
	 * @return serviced
	 */
	public int service()
	{
		int serviced;
		if (serviceMiles >= 100)
		{
			serviceMiles = 0.0;
			operCost += 25.0;
			serviced = 1;
		}
		else
		{
			serviced = -1;
		}
		
		return serviced;
	}/*End service*/
	
	/**
	 * get the number of service miles
	 * @return serviceMiles
	 */
	public double getServiceMiles()
	{
		return serviceMiles;
	}/*End getServiceMiles*/
	
	
}/*End UpgradedTaxi*/
