package com.tapfood.Model;

public class Ordertable {
	private int orderid;
	private int restaurantid;
	private int userid;
	private String orderdate;
	private float totalamount;
	private String status;
	private String paymentmode;
	
	public Ordertable()
	{
		super();
	}
	
	public Ordertable(int restaurantid, int userid, String orderdate, float totalamount, String status,
			String paymentmode) {
		super();
		this.restaurantid = restaurantid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	public Ordertable(int orderid, int restaurantid, int userid, String orderdate, float totalamount, String status,
			String paymentmode) {
		super();
		this.orderid = orderid;
		this.restaurantid = restaurantid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentmode = paymentmode;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public float getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayemntmode() {
		return paymentmode;
	}
	public void setPayemntmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	
	

}
