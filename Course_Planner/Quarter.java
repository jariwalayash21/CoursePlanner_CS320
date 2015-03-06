package cs320.model;

import java.util.ArrayList;
import java.util.List;

public class Quarter 
{
	String name;
	List<CourseEntry> courses = new ArrayList<CourseEntry>();

	public List<CourseEntry> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntry> courses) {
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Quarter(String name, List<CourseEntry> courses)
	{
		this.name = name;
		this.courses = courses;
		
	}
	 public Quarter (String name){
		 this.name=name;
	 }
	
}
