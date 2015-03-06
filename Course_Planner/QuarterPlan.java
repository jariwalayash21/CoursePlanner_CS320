package cs320.model;

import java.util.ArrayList;
import java.util.List;

public class QuarterPlan 
{
	List<Quarter> courses = new ArrayList<Quarter>();


	public QuarterPlan(ArrayList<Quarter> quarters)
	{
		this.courses = quarters;
	}
	
}
