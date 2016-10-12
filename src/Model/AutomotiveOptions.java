//Reyhan Fernando Patia
//CIS 35b
//Final Lab

package Model;

import Model.Automotive;

import java.util.*;

public class AutomotiveOptions 
{
	private LinkedHashMap<String, Automotive> car;

	public AutomotiveOptions()
	{
		super();
		car = new LinkedHashMap<String, Automotive>();
	}

	public AutomotiveOptions(LinkedHashMap<String, Automotive> carOptions) 
	{
		super();
		this.car = carOptions;
	}

	public void setCarOptions(LinkedHashMap<String, Automotive> carOptions) {
		this.car = carOptions;
	}

	public LinkedHashMap<String, Automotive> getCarOptions() 
	{
		return car;
	}

	public Automotive getCarOption(String key)
	{
		return car.get(key);
	}
	
	public void addCarOption(Automotive car) 
	{
		this.car.put(car.getMake() + "-" + car.getModel(), car);
	}

	public void removeCarOption(Automotive cars) 
	{
		car.remove(cars.getMake() + "-" + cars.getModel());
	}

	public int size()
	{
		return car.size();
	}
	
	public String printavailablecar()
	{
		StringBuffer s = new StringBuffer();
		for (Automotive mobile : car.values()) 
		{
			s.append("Car Name: "+ mobile.getName() + "\n");
			s.append("Key: " + mobile.getMake() + "-" + mobile.getModel() + "\n");
		}
		
		return s.toString();
	}
	
	public void printCarOptions() {
		for (Automotive mobile : car.values()) {
			mobile.print();;
		}
	}

}
