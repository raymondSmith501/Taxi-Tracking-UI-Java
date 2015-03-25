/**NewTaxiUI is a user interface to input and display data from the 
 * UpgradedTaxi class
 * 
 * @author Raymond Smith
 */
 package edu.trident.Smith.Assignment4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


public class NewTaxiUI extends JFrame implements MaintenanceAlert, ActionListener, ItemListener
{

	static final long serialVersionUID = 1L;
	 
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	private JMenu mgmnt = new JMenu("Management");
	private JMenu driver = new JMenu("Driver");
	private JMenu createMenu = new JMenu("Create");
	private JMenu serviceMenu = new JMenu("Service");
	private JRadioButtonMenuItem create = new JRadioButtonMenuItem("Create Taxi");
	private JRadioButtonMenuItem  recordTrip = new JRadioButtonMenuItem("Record Trip");
	private JRadioButtonMenuItem addGas = new JRadioButtonMenuItem("Add Gas");
	private JRadioButtonMenuItem gasAvail = new JRadioButtonMenuItem("Report Gas Available");
	private JRadioButtonMenuItem miAvail = new JRadioButtonMenuItem("Report Miles Available");
	private JRadioButtonMenuItem milesDriven = new JRadioButtonMenuItem("Report Miles Driven");
	private JRadioButtonMenuItem earnings = new JRadioButtonMenuItem("Report Gross Earnings");
	private JRadioButtonMenuItem reset = new JRadioButtonMenuItem("Reset");
	private JRadioButtonMenuItem service = new JRadioButtonMenuItem("Service");
	private JRadioButtonMenuItem netEarnings = new JRadioButtonMenuItem("Report Net Earnings");
	private ButtonGroup bGroup = new ButtonGroup();
	private JButton ok = new JButton("OK");
	private JTextField field1 = new JTextField(30);
	private JTextField field2 = new JTextField(30);
	private JLabel label1 = new JLabel("Enter amount of gas in tank");
	private JLabel label2 = new JLabel("Create Taxi");
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	UpgradedTaxi taxi1 = null;
	DecimalFormat currency = new DecimalFormat("$###,###.00");
	DecimalFormat gallons = new DecimalFormat("##.00gal");
	DecimalFormat mileage = new DecimalFormat("##,###.00mi");
	
	
/**
 * Constructor for the NewTaxiUI class 	
 */
	public NewTaxiUI()
	{
		super("Acme Taxi Co");
		setSize(WIDTH, HEIGHT);
		JMenuBar mainBar = new JMenuBar();
		setJMenuBar(mainBar);
		mainBar.add(createMenu);
		mainBar.add(driver);
		mainBar.add(mgmnt);
		mainBar.add(serviceMenu);
		createMenu.setMnemonic('C');
		driver.setMnemonic('D');
		mgmnt.setMnemonic('M');
		serviceMenu.setMnemonic('S');
		createMenu.add(create);
		driver.add(recordTrip);
		driver.add(addGas);
		driver.add(gasAvail);
		driver.add(miAvail);
		mgmnt.add(milesDriven);
		mgmnt.add(earnings);
		mgmnt.add(netEarnings);
		mgmnt.add(reset);
		bGroup.add(create);
		bGroup.add(recordTrip);
		bGroup.add(addGas);
		bGroup.add(gasAvail);
		bGroup.add(miAvail);
		bGroup.add(milesDriven);
		bGroup.add(earnings);
		bGroup.add(netEarnings);
		bGroup.add(reset);
		bGroup.add(service);		 
		serviceMenu.add(service);
		setLayout(new GridLayout(3,1,5,5));
		panel1.add(label1);
		panel1.add(field1);
		panel2.add(label2);
		panel2.add(field2);
		panel3.add(ok);
		add(panel1);
		add(panel2);
		add(panel3);
		create.addItemListener(this);
		recordTrip.addItemListener(this);
		addGas.addItemListener(this);
		gasAvail.addItemListener(this);
		miAvail.addItemListener(this);
		milesDriven.addItemListener(this);
		earnings.addItemListener(this);
		netEarnings.addItemListener(this);
		reset.addItemListener(this);
		service.addItemListener(this);
		ok.addActionListener(this);
		driver.setEnabled(false);
		mgmnt.setEnabled(false);
		serviceMenu.setEnabled(false);
		label1.setVisible(false);
		label2.setVisible(false);
		field1.setVisible(false);
		field2.setVisible(false);
		ok.setVisible(false);
		setVisible(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}/*End NewTaxiUI*/
	
	/**
	 * Interface alert for when the taxi's service miles exceeds 100
	 * 
	 */
	public void maintenanceNeeded(String title, String msg)
	{	
		new UIManager();
		UIManager.put("Panel.background", Color.RED);
		JLabel label = new JLabel(msg);  
        label.setFont(new Font("serif", Font.PLAIN, 20));
		JOptionPane.showMessageDialog(null, label, title,JOptionPane.WARNING_MESSAGE, null);
	}/*End maintenanceNeeded*/
	
	/**
	 * Performs specified action when button pressed
	 */
	public void actionPerformed(ActionEvent e)
	{
		if (create.isSelected())
		{
			createTaxi();
		}
		else if (recordTrip.isSelected())
		{
			record();
		}
		else if (addGas.isSelected())
		{
			adGs();
		}
		else if (gasAvail.isSelected())
		{
			availGas();
		}
		else if (miAvail.isSelected())
		{
			availMi();
		}
		else if (milesDriven.isSelected())
		{
			drivenMi();
		}
		else if (earnings.isSelected())
		{
			earn();
		}
		else if (netEarnings.isSelected())
		{
			netEarnings();
		}
		else if (reset.isSelected())
		{
			res();
		}
		else if (service.isSelected())
		{
			service();
		}		
	}/*End actionPerformed*/

	/**
	 * Changes window based on which radio button is selected
	 */
	public void itemStateChanged(ItemEvent i) 
	{
		Object source = i.getItem();
		if(source == create)
		{	label1.setText("Enter amount of gas in tank");
			label2.setText("Create Taxi");
			label1.setVisible(true);
			label2.setVisible(true);
			field1.setVisible(true);
			ok.setVisible(true);
		}				
		else if(source == recordTrip)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Enter miles");
			label2.setText("");
			field1.setVisible(true);
			field2.setVisible(false);
		}		
		else if(source == addGas)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Enter amount of gas added");
			label2.setText("Enter cost of gas per gallon");
			field1.setVisible(true);
			field2.setVisible(true);
		}		
		else if(source == gasAvail)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Gas in Tank currently");
			label2.setText("");
			field1.setVisible(false);
			field2.setVisible(false);
		}
		else if (source == miAvail)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Miles available to drive with current gas level");
			label2.setText("");
			field1.setVisible(false);
			field2.setVisible(false);
		}
		else if(source == milesDriven)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Total Miles Driven");
			label2.setText("");
			field1.setVisible(false);
			field2.setVisible(false);
		}
		else if(source == earnings)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Total fares earned");
			label2.setText("");
			field1.setVisible(false);
			field2.setVisible(false);
		}
		else if(source == netEarnings)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Earnings minus operation costs");
			label2.setText("");	
			field1.setVisible(false);
			field2.setVisible(false);
		}	
		else if(source == reset)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Will reset miles driven, fares earned and operation costs");
			label2.setText("");
			field1.setVisible(false);
			field2.setVisible(false);
		}		
		else if(source == service)
		{
			field1.setText("");
			field2.setText("");
			label1.setText("Service Vehicle");
			label2.setText("Will cost $25");
			field1.setVisible(false);
			field2.setVisible(false);			
		}
		
	}/*End itemStateChanged*/
	
	/**
	 * Creates a UpgradedTaxi object and enables the rest of the choices
	 */
	public void createTaxi()
	{
		if (field1.getText().isEmpty())
		{
			label2.setText("Please enter a number value for gas in tank");
		}
		else
		{
			double startGas = Double.parseDouble(field1.getText());
			taxi1 = new UpgradedTaxi(startGas, this);
			taxi1.setMaintenanceAlert(this);
			createMenu.setEnabled(false);
			driver.setEnabled(true);
			mgmnt.setEnabled(true);
			serviceMenu.setEnabled(true);
			recordTrip.setSelected(true);
		}/*End if textfield is empty*/
	}/*End createTaxi*/
	
	/**
	 * Records a trip by inputting the distance and displaying the fare cost
	 * 
	 **/
	public void record()
	{
		double fare;
		if (field1.getText().isEmpty())
		{
			label2.setText("Please enter a number value for miles of the trip");
		}
		else
		{
			double miles = Double.parseDouble(field1.getText());
			fare = taxi1.record(miles);
			if(fare == -1.00)
			{
				label2.setText("Not enough Miles Available");
			}
			else if(fare == -2.00)
			{
				label2.setText("Enter a positive number above 0");
			}
			else if(fare == -5)
			{
				label2.setText("Cannot accept fares!! Must service Taxi!!");
			}
			else
			{
				label1.setText("The total fare is:  ");
				field1.setText(currency.format(fare));
			}
		}
	}/*End record*/
	
	/**
	 * Adds gas to the taxi.  Inputs gallons added and price/gal.  
	 * Displays amount of gas added and total cost of gas added.
	 */
	public void adGs()
	{
		int allowed;
		if (field1.getText().isEmpty() || field2.getText().isEmpty())
		{
			if(field1.getText().isEmpty())
			{
				label1.setText("Please enter a number value for the amount of gas added");
			}
			
			if(field2.getText().isEmpty())
			{
				label2.setText("Please enter a number value for the price of gas/gal");
			}
		}
		else
		{
			double gas = Double.parseDouble(field1.getText());
			double cost = Double.parseDouble(field2.getText());
			double tank = taxi1.getGas();
			allowed = taxi1.adGas(gas, cost);
			if (allowed == 1)
			{
				field1.setText(gallons.format(gas) + " were added");
				field2.setText("The total cost was " + currency.format(cost * gas));
			}
			else if (allowed == 0)
			{
				field1.setText("Too much gas! Only " + gallons.format((Taxi.TANK - tank)) 
								+ " were added.");
				field2.setText("The total cost was " + currency.format((cost * (Taxi.TANK - tank))));
			}
			else 
			{
				field1.setText("Please enter a postive number!");
			
			}/*End if for if gas was allowed to be put in and how much*/
		}//End if for if a textfield is empty
		
	}/*End adGs*/
	
	/**
	 * Displays amount of gas in the tank
	 * @return none
	 */
	public void availGas()
	{
		double gas = taxi1.getGas();
		label2.setText(gallons.format(gas));
	}/*End availGas*/
	
	/**
	 * Displays the amount of miles left on the current tank
	 * @return none
	 */
	public void availMi()
	{
		double miles = taxi1.getMilesAvail();
		label2.setText(mileage.format(miles));
	}/*End availMi*/
	
	/**
	 * Displays total number of miles driven by Taxi since last reset
	 * @return none
	 */
	public void drivenMi()
	{
		double miles = taxi1.getMilesDriven();
		label2.setText(mileage.format(miles));
	}/*End drivenMi*/
	
	/**
	 * Displays total of all fares since last reset
	 * @return none
	 */
	public void earn()
	{ 
		double earnings = taxi1.getEarnings();
		
		label2.setText(currency.format(earnings));
	}/*End earn*/
	
	/**
	 * Resets all values for earnings, and miles driven
	 * @return none
	 */
	public void res()
	{
		taxi1.reset();
		label2.setText("Values are now reset to 0");
	}/*End res*/
	
	/**
	 * Displays net earnings 
	 */
	public void netEarnings()
	{
		double net = taxi1.netEarns();
		label2.setText(currency.format(net));		
	}/*End netEarnings*/
	
	/**
	 * Services the taxi for a cost of $25
	 * 
	 */
	public void service()
	{
		int serviced = taxi1.service();
		if(serviced == 1)
		{
			label2.setText("Service complete.  You may accept fares.");		
		}
		else
		{
			label2.setText("You may not service Taxi until needed!");
		}
	}/*Ends service*/
	
}/*End NewTaxiUI*/
