//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package Model;

import java.util.*;

public class OptionSet implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Option> opt;
	private Option choice;
	
	OptionSet()
	{
		name = "";
		opt = null;
	}
	
	OptionSet(String Name)
	{
		name = Name;
		opt = null;
	}
	
	OptionSet(String names, int size)
	{
		name = names;
		opt = new ArrayList<Option>(size);	
	}
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected ArrayList<Option> getOpt() {
		return opt;
	}
	protected void setOpt(ArrayList<Option> opt) {
		this.opt = opt;
	}
	protected String getOptionName(int index)
	{
		return opt.get(index).getName();
	}
	protected void setOptionName(int index, String name)
	{
		opt.get(index).setName(name);
	}
	
	public Option getChoice() {
		return choice;
	}

	public void setChoice(Option choice) {
		this.choice = choice;
	}

	public void addOption(String name, float price)
	{
		opt.add(new Option(name, price));
	}
	
	protected int findOption(String name)
	{
		int temp = -1;
		
		for(int i = 0; i < opt.size(); i++)
		{
			if( opt.get(i).getName().equalsIgnoreCase(name))
				temp = i;
		}
		
		return temp;
	}
	protected float getOptionPrice(String name)
	{
		int temp = this.findOption(name);
		
		if(temp != -1)
			return opt.get(temp).getPrice();
		else
			return temp;

	}
	protected void setOptionPrice(int i, float newprice)
	{
		opt.get(i).setPrice(newprice);
	}
	
	protected void setOption(String Name, float price, int i)
	{
		if(opt.get(i) == null)
		{	
			Option temp = new Option(Name,price);
			opt.set(i, temp);
		}
		else
		{
			opt.get(i).setName(Name);
			opt.get(i).setPrice(price);
		}
	}
	
	protected void setOption(Option op, int i)
	{
		opt.set(i, op);
	}
	
	protected Option getOption(String name)
	{
		int index = this.findOption(name);
		
		if(index != -1)
			return opt.get(index);
		else 
			return null;
	}
	
	protected void updateOptionPrice(String name, float newPrice)
	{
		
		int temp = this.findOption(name);
		
		opt.get(temp).setPrice(newPrice);
			
	}
	
	protected void updateOptionName(String name, String newname)
	{
		int temp = this.findOption(name);
		
		opt.get(temp).setName(newname);
	}
	
	// Remove method for the l
	protected void deleteOptions()
	{
		 opt.removeAll(opt);
	}
	
	protected void deleteOption(int i)
	{
		opt.remove(i);
	}
	
	protected void deleteOption(Option i)
	{
		opt.remove(i);
	}
	
	protected String print() {
		StringBuffer s = new StringBuffer();
		String newline = "\n";
		s.append(this.name + newline);
		for (Option o : this.getOpt()) {
			s.append(o.print() + newline);
		}
		return s.toString();
	}

}

class Option implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private float price;
	
	Option()
	{
		name = "";
		price = (float) 0.0;
	}
	
	Option(String newname, float newprice)
	{
		setName(newname);
		setPrice(newprice);
	}
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected float getPrice() {
		return price;
	}
	protected void setPrice(float price) {
		this.price = price;
	}
	
	protected String print()
	{
		StringBuffer s = new StringBuffer();
		s.append(name + ": $" + price);
		return s.toString();
	}
	
}