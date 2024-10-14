package com.tapfood.Model;

public class OrderHistory {
	private int orderhistoryid;
	private int orderid;
	private int userid;
	private String orderdate;
	private float totalamount;
	private String status;
	
	public OrderHistory()
	{
		super();
	}
	public OrderHistory(int orderid, int userid, String orderdate, float totalamount, String status) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.status = status;
	}

	public OrderHistory(int orderhistoryid, int orderid, int userid, String orderdate, float totalamount,
			String status) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.orderid = orderid;
		this.userid = userid;
		this.orderdate = orderdate;
		this.totalamount = totalamount;
		this.status = status;
	}
	public int getOrderhistoryid() {
		return orderhistoryid;
	}
	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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
	
	

}
