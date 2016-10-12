//Reyhan Fernando Patia
//CIS 35b
//Final Lab
package Model;
import java.util.*;

public class Automotive implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String make;
	private String model;
	private String name;
	private float baseprice;
	private ArrayList<OptionSet> optset;
	
	
	//constructor
	public Automotive()
	{
		name = "";
		baseprice = (float) 0.0;
		make = " ";
		model = " ";
		optset = new ArrayList<OptionSet>();
	}
	
	public Automotive(String Name, float price, String m, String n)
	{
		name = Name;
		baseprice = price;
		make = m;
		model = n;
		optset = new ArrayList<OptionSet>();
	}
	
	public Automotive(String Name, float price, String m, String n, ArrayList<OptionSet> o)
	{
		name = Name;
		baseprice = price;
		make = m;
		model = n;
		optset = o;
	}
	
	
	//getter and setter for optionSet
	public String getName() {
		return name;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(float baseprice) {
		this.baseprice = baseprice;
	}

	public ArrayList<OptionSet> getOptset() {
		return optset;
	}

	public void setOptset(ArrayList<OptionSet> optset) {
		this.optset = optset;
	}
	
	public OptionSet getOptionSet(int i)
	{
		return optset.get(i);
	}
	
	public void setOptionSet(int i, OptionSet opt)
	{
		optset.set(i, opt);
	}
	
	public String getOptionSetName(int i)
	{
		return optset.get(i).getName();
	}
	
	public void setOptionSetName(int i, String name)
	{
		optset.get(i).setName(name);
	}
	
	public String getOptionChoice(String name)
	{
		int temp = findOptionSet(name);
		
		return optset.get(temp).getChoice().getName();
	}
	
	public float getOptionChoicePrice(String name)
	{
		int temp = findOptionSet(name);
		
		return optset.get(temp).getChoice().getPrice();
	}
	
	public boolean setOptionChoice(String name, String newname)
	{
		int i = findOptionSet(name);
		
		if(i != -1)
		{
			if(findOption(newname, i) != -1)
			{
				optset.get(i).setChoice(optset.get(i).getOption(newname));
				return true;
			}
			else
				return false;
		}
		else 
			return false;
	}
	
	// calculate final price of the car with all option
	public float getTotalPrice()
	{
		float price = baseprice;
		
		for(OptionSet o: optset)
		{
			price += o.getChoice().getPrice();
		}
		
		return price;
	}
	
	//add optionset to the list
	
	public void addOptionSet(String name, int count)
	{
		optset.add(new OptionSet(name, count));
	}
	
	public void addOption(int i,String name, float price)
	{
		optset.get(i).addOption(name, price);
	}

	public void CreateOptionSet(int i, String optsetname, int size)
	{
		OptionSet s = new OptionSet(optsetname,size);
		optset.set(i, s);
	}
		
	// update optionset
	public boolean updateOptionSetName(String name, String newname)
	{
		int temp = this.findOptionSet(name);
		
		if(temp != -1)
		{
			optset.get(temp).setName(newname);
			return true;
		}
		else
			return false;
			
	}
	
	public boolean updateOptionSet(String name, OptionSet opt)
	{
		int temp = this.findOptionSet(name);
		
		if(temp != -1)
		{
			this.setOptionSet(temp, opt);
			return true;
		}
		else 
			return false;
	}
	
	public boolean updateOptionSets(String name, ArrayList<OptionSet> opt)
	{
		int temp = this.findOptionSet(name);
		
		if(temp != -1)
		{
			this.setOptset(opt);
			return true;
		}
		else 
			return false;
	}
	
	//delete optionset
	public void deleteOptionSets()
	{
		optset = null;
	}
	
	public void deleteOptionSet(int i)
	{
		optset.set(i, null);
	}
	
	//find optionset
	
	public int findOptionSet(String name)
	{
		int index = -1;
		
		for(int i = 0; i < optset.size(); i++)
		{
			if(optset.get(i).getName().equalsIgnoreCase(name))
				index = i;
		}
		
		return index;
	}
	
	// getter setter for option
	
	public int getOptionSize(int i)
	{
		return this.getOptionArray(i).size();
	}
	
	public ArrayList<Option> getOptionArray(int i)
	{
		return optset.get(i).getOpt();
	}
	
	public void setOptionArray(int i, ArrayList<Option> opt)
	{
		optset.get(i).setOpt(opt); 
	}
	
	public void setOption(String name, float price, int optionsetindex, int optionindex)
	{
		optset.get(optionsetindex).setOption(name, price, optionindex);
	}
	
	public void setOption(Option opt, int optionsetindex, int optionindex)
	{
		optset.get(optionsetindex).setOption(opt, optionindex);
	}
	
	public Option getOption(int optionsetindex, String name)
	{
		return optset.get(optionsetindex).getOption(name);
	}	
	
	public String getOptionName(int optionsetindex, int optionindex)
	{
		return optset.get(optionsetindex).getOptionName(optionindex);
	}
	
	public void setOptionName(int optionsetindex, int optionindex, String name)
	{
		optset.get(optionsetindex).setOptionName(optionindex, name);
	}
	
	public float getOptionPrice(String name, int i)
	{
		return optset.get(i).getOptionPrice(name);
	}
	
	public void setOptionPrice(int i, int j, float newprice)
	{
		optset.get(i).setOptionPrice(j, newprice);
	}
	
	// update option
	public void updateOptionPrice(String name, float newPrice, int i)
	{
		optset.get(i).updateOptionPrice(name, newPrice);
	}
	
	public void updateOptionName(String name, String newname, int i)
	{
		optset.get(i).updateOptionName(name, newname);
	}
	
	public boolean updateOption(String name, Option opt, int i)
	{
		int temp = this.findOption(name, i);
		
		if(temp != -1)
		{
			optset.get(i).setOption(opt, temp);
			return true;
		}
		else 
			return false;
	}
	
	public boolean updateOptions(String name, ArrayList<Option> opt)
	{
		int temp = this.findOptionSet(name);
		
		if(temp != -1)
		{
			optset.get(temp).setOpt(opt);
			return true;
		}
		else 
			return false;
	}
	
	// delete option
	public void deleteOptions(int i)
	{
		optset.get(i).deleteOptions();
	}
	
	public void deleteOption(int i, int j)
	{
		optset.get(i).deleteOption(j);
	}
	
	public void deleteOption(int i,Option j)
	{
		optset.get(i).deleteOption(j);
	}
	
	public void deleteOptionSets(int i)
	{
		optset.remove(i);
	}
	
	public void deleteOptionSets(OptionSet i)
	{
		optset.remove(i);
	}
	
	public void deleteAllOptionSets()
	{
		optset.removeAll(optset);
	}
	
	//find option
	public int findOption(String name, int i)
	{
		return optset.get(i).findOption(name);
	}
	
	//print option and optionSet
	public void printOptionSet(int i)
	{
		System.out.print(optset.get(i).print());
	}
	
	public void printOption(int i, int j)
	{
		System.out.print(optset.get(i).getOpt().get(j).print());
	}
	
	public void printAllOption(int i)
	{
		for(Option op : optset.get(i).getOpt())
			System.out.print(op.print());
	}
	
	public String print() {
		
		StringBuffer s = new StringBuffer();
		String newline = "\n";
		s.append("Model:" + name + newline);
		s.append("Base Price:$" + baseprice + newline);
		s.append("\nOptions:\n" + newline);
		for (OptionSet temp : optset) 
		{
			s.append(temp.print() + newline);
		}
		
		s.append("-------End-------" + newline);
		
		return s.toString();
	}
	
	

}
