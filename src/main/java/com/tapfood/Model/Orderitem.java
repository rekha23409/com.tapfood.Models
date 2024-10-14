package com.tapfood.Model;

public class Orderitem {
	private int orderitemid;
	private int orderid;
	private int menuid;
	private int quantity;
	private float subtotal;
	
	public Orderitem()
	{
		super();
	}
	
	public Orderitem(int orderid, int menuid, int quantity, float subtotal) {
		super();
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}


	public Orderitem(int orderitemid, int orderid, int menuid, int quantity, float subtotal) {
		super();
		this.orderitemid = orderitemid;
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public int getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}


}
