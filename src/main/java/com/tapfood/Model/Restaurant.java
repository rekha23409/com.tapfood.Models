package com.tapfood.Model;

public class Restaurant {
	private int restaurantid;
	private String restaurantname;
	private int deliverytime;
	private String cusiontype;
	private String address;
	private float ratings;
	private String isactive;
	private int adminid;
	private String imagepath;
	
	public Restaurant()
	{
		super();
	}
	
	public Restaurant( String restaurantname, int deliverytime, String cusiontype, String address,
			float ratings, String isactive, int adminid, String imagepath) {
		super();
		this.restaurantname = restaurantname;
		this.deliverytime = deliverytime;
		this.cusiontype = cusiontype;
		this.address = address;
		this.ratings = ratings;
		this.isactive = isactive;
		this.adminid = adminid;
		this.imagepath = imagepath;
	}
	public Restaurant(int restaurantid, String restaurantname, int deliverytime, String cusiontype, String address,
			float ratings, String isactive, int adminid, String imagepath) {
		super();
		this.restaurantid = restaurantid;
		this.restaurantname = restaurantname;
		this.deliverytime = deliverytime;
		this.cusiontype = cusiontype;
		this.address = address;
		this.ratings = ratings;
		this.isactive = isactive;
		this.adminid = adminid;
		this.imagepath = imagepath;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public int getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}

	public String getCusiontype() {
		return cusiontype;
	}

	public void setCusiontype(String cuisiontype) {
		this.cusiontype = cuisiontype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getImagepath() {
		return imagepath;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantid=" + restaurantid + ", restaurantname=" + restaurantname + ", deliverytime="
				+ deliverytime + ", cusiontype=" + cusiontype + ", address=" + address + ", ratings=" + ratings
				+ ", isactive=" + isactive + ", adminid=" + adminid + ", imagepath=" + imagepath + "]";
	}

	public void setImagepath(String imapath) {
		this.imagepath = imapath;
	}
	
	

}
