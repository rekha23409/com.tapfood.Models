package com.tapfood.DAO;

import java.util.ArrayList;

import com.tapfood.Model.OrderHistory;

public interface OrderHistoryDAO {
	public int addOrderhistory(OrderHistory r);
	public ArrayList<OrderHistory> getAllOrderhistory();
	public OrderHistory getOrderhistory(int orderid );
	public int updateOrderhistory(OrderHistory r);
	public int deleteOrderhistory(int orderid);

}
