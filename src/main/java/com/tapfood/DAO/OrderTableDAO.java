package com.tapfood.DAO;

import java.util.ArrayList;

import com.tapfood.Model.Ordertable;

public interface OrderTableDAO {
	public int addOrders(Ordertable r);
	public ArrayList<Ordertable> getAllOrders();
	public Ordertable getOrdertable(int userid );
	public int updateOrders(Ordertable r);
	public int deleteOrders(String orderdate);}
