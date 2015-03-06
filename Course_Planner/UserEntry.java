package cs320.model;

public class UserEntry
{
	int uid;
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	String username,password,re_password,fname,lname;

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRe_password() {
		return re_password;
	}

	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) 
	{
		this.lname = lname;
	}
	
	public UserEntry(Integer uid,String username, String password, String re_password,
			String fname, String lname)
	{
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.re_password = re_password;
		this.fname = fname;
		this.lname = lname;
	}
	
}
