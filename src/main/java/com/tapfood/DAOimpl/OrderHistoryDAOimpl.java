package com.tapfood.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DAO.OrderHistoryDAO;
import com.tapfood.DBUtils.DBUtil;
import com.tapfood.Model.OrderHistory;

public class OrderHistoryDAOimpl implements OrderHistoryDAO{

	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	
	private static final String ADD_ORDER="insert into `Orderhistory`(`orderid`,`userid`,"
			+ "`orderdate`,`totalamount`,`status`) "
			+ "values(?,?,?,?,?)";
	
	private static final String SELECT_ALL="select * from `Orderhistory`";
	
	private static final String SELECT_ON_USERID="select * from `Orderhistory` where `orderid`=?";
	private static final String UPDATE_ON_USERID="update `Orderhistory`set `orderid`=?,`userid`=?,`orderdate`=?,`totalamount`=?,`status`=?";
	 private static final String DELETE_ON_ORDERDATE="delete from `Orderhistory` where `orderid`=?";
	int status=0;
	ArrayList<OrderHistory>userList=new ArrayList<OrderHistory>();
	OrderHistory res;
	public OrderHistoryDAOimpl()
	{
		try
		{
			con=DBUtil.myConnect();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public int addOrderhistory(OrderHistory r) {
		try
		{
			pstmt=con.prepareStatement(ADD_ORDER);
			pstmt.setInt(1,r.getOrderid());
			pstmt.setInt(2,r.getUserid());
			pstmt.setString(3,r.getOrderdate());			
			pstmt.setFloat(4,r.getTotalamount());
			pstmt.setString(5,r.getStatus());
			
			status=pstmt.executeUpdate(ADD_ORDER);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	@Override
	public ArrayList<OrderHistory> getAllOrderhistory() {
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			userList=extractOrderitemFromResultSet(resultSet);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userList ;
	}
	
	
	@Override
	public OrderHistory getOrderhistory(int orderid ) {
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_USERID);
			pstmt.setInt(1, orderid);
			
			resultSet=pstmt.executeQuery();
			userList=extractOrderitemFromResultSet(resultSet);
			res=userList.get(0);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
		
		
	}
	@Override
	public int updateOrderhistory(OrderHistory r){
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_USERID);
			pstmt.setInt(1,r.getOrderid());
			pstmt.setInt(2,r.getUserid());			
			pstmt.setString(3,r.getOrderdate());
			pstmt.setFloat(4,r.getTotalamount());
			pstmt.setString(5,r.getStatus());
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int deleteOrderhistory(int orderid){
		try
		{
			con.prepareStatement(DELETE_ON_ORDERDATE);
			pstmt.setInt(1,orderid);
			status=pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	public ArrayList<OrderHistory>extractOrderitemFromResultSet(ResultSet resultSet)
	{
		try {
		while(resultSet.next())
		{
			userList.add(new OrderHistory(resultSet.getInt("orderhistoryid"),
			resultSet.getInt("orderid"),
			resultSet.getInt("userid"),
			resultSet.getString("orderdate"),
			resultSet.getFloat("totalamount"),
			resultSet.getString("status")
			));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
		
	}

}
