package com.tapfood.Model;

public class Users {
	private int userid;
	private String username;
	private String email;
	private String phonenumber;
	private String password;
	private String address;
//	private String cuurentdate;
//	private String lastlogin;
	
	public Users()
	{
		super();
	}
	public Users(String username, String email, String phonenumber, String password, String address) {
	super();
		
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
//		this.cuurentdate = cuurentdate;
//		this.lastlogin = lastlogin;
	}
	public Users(int userid,String username, String email, String phonenumber, String password, String address) {
	super();
		this.userid=userid;
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
//		this.cuurentdate = cuurentdate;
//		this.lastlogin = lastlogin;
	}
	
	
	public Users(String username) {
		super();
		this.username = username;
//		this.email = email;
//		this.phonenumber = phonenumber;
//		this.password = password;
//		this.address = address;
//		this.cuurentdate = cuurentdate;
//		this.lastlogin = lastlogin;
	}
	
		public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public String getCuurentdate() {
//		return cuurentdate;
//	}
//	public void setCuurentdate(String cuurentdate) {
//		this.cuurentdate = cuurentdate;
//	}
//	public String getLastlogin() {
//		return lastlogin;
//	}
//	public void setLastlogin(String lastlogin) {
//		this.lastlogin = lastlogin;
//	}

}
