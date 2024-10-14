package com.tapfood.DAO;

import java.util.ArrayList;

import com.tapfood.Model.Orderitem;

public interface OrderitemDAO {

	public int addOrderitems(Orderitem r);
	public ArrayList<Orderitem> getAllOrderitems();
	public Orderitem getOrderitem(int orderid );
	public int updateOrderitem(Orderitem r);
	public int deleteOrderitem(int order);

}
