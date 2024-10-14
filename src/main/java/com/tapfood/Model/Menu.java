package com.tapfood.Model;

public class Menu {
	private int menuid;
	private int restaurantid;
	private String menuname;
	private float price;
	private String description ;
	private String isavailable;
	private String imagepath;
	
	public Menu()
	{
		super();
	}
	public Menu(int restaurantid, String menuname, float price, String description, String isavailable, String imagepath) {
		super();
		this.restaurantid = restaurantid;
		this.menuname = menuname;
		this.price = price;
		this.description = description;
		this.isavailable = isavailable;
		this.imagepath = imagepath;
	}


	public Menu(int menuid, int restaurantid, String menuname, float price, String description, String isavailable,
			String imagepath) {
		super();
		this.menuid = menuid;
		this.restaurantid = restaurantid;
		this.menuname = menuname;
		this.price = price;
		this.description = description;
		this.isavailable = isavailable;
		this.imagepath = imagepath;
	}


	public int getMenuid() {
		return menuid;
	}


	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}


	public int getRestaurantid() {
		return restaurantid;
	}


	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}


	public String getMenuname() {
		return menuname;
	}


	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIsavailable() {
		return isavailable;
	}


	public void setIsavailable(String isavailable) {
		this.isavailable = isavailable;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", restaurantid=" + restaurantid + ", menuname=" + menuname + ", price="
				+ price + ", description=" + description + ", isavilable=" + isavailable + ", imagepath=" + imagepath
				+ "]";
	}
	
	
	
	

}
