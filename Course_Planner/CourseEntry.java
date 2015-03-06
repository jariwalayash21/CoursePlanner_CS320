package cs320.model;

public class CourseEntry
{
	Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	String course_no;
	String course_name;
	String[] course_pre;
	

	public CourseEntry()
	{
		
	}
	
	public CourseEntry(Integer id,String course_no, String course_name,String[] course_pre)
	{
		this.id = id;
		this.course_no = course_no;
		this.course_name = course_name;
		this.course_pre = course_pre;
	}

	public String[] getCourse_pre()
	{
		return course_pre;
	}

	public void setCourse_pre(String[] course_pre)
	{
		this.course_pre = course_pre;
	}

	public String getCourse_no() 
	{
		return course_no;
	}

	public void setCourse_no(String course_no) 
	{
		this.course_no = course_no;
	}

	public String getCourse_name() 
	{
		return course_name;
	}

	public void setCourse_name(String course_name) 
	{
		this.course_name = course_name;
	}


	
	
}
