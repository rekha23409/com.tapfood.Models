package com.tapfood.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DAO.OrderTableDAO;
import com.tapfood.DBUtils.DBUtil;
import com.tapfood.Model.Ordertable;

public class OrdertableDAOimpl implements OrderTableDAO {
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	
	private static final String ADD_ORDER="insert into `Ordertable`(`restaurantid`,`userid`,"
			+ "`orderdate`,`totalamount`,`status`,`paymentmode`) "
			+ "values(?,?,?,?,?,?)";
	
	private static final String SELECT_ALL="select * from `Ordertable`";
	
	private static final String SELECT_ON_USERID="select * from `Ordertable` where `userid`=?";
	private static final String UPDATE_ON_USERID="update `Ordertable`set `restaurantid`=?,`userid`=?,`orderdate`=?,`toatalamount`=?,`status`=?,`paymentmode`=?";
	 private static final String DELETE_ON_ORDERDATE="delete from `Ordertable` where `orderdate`=?";
	int status=0;
	ArrayList<Ordertable>userList=new ArrayList<Ordertable>();
	Ordertable res;
	public OrdertableDAOimpl()
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
	public int addOrders(Ordertable r) {
		try
		{
			pstmt=con.prepareStatement(ADD_ORDER);
			pstmt.setInt(1,r.getRestaurantid());
			pstmt.setInt(2,r.getUserid());
			pstmt.setString(3,r.getOrderdate());			
			pstmt.setFloat(4,r.getTotalamount());
			pstmt.setString(5,r.getStatus());
			pstmt.setString(6,r.getPayemntmode());
			
			status=pstmt.executeUpdate(ADD_ORDER);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	@Override
	public ArrayList<Ordertable> getAllOrders() {
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			userList=extractRestuarantFromResultSet(resultSet);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return userList ;
	}
	
	
	@Override
	public Ordertable getOrdertable(int userid ) {
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_USERID);
			pstmt.setInt(1, userid);
			
			resultSet=pstmt.executeQuery();
			userList=extractRestuarantFromResultSet(resultSet);
			res=userList.get(0);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
		
		
	}
	@Override
	public int updateOrders(Ordertable r) {
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_USERID);
			pstmt.setInt(1,r.getRestaurantid());
			pstmt.setInt(2,r.getUserid());
			pstmt.setString(3,r.getOrderdate());			
			pstmt.setFloat(4,r.getTotalamount());
			pstmt.setString(5,r.getStatus());
			pstmt.setString(6,r.getPayemntmode());
		
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int deleteOrders(String orderdate) {
		try
		{
			con.prepareStatement(DELETE_ON_ORDERDATE);
			pstmt.setString(1,orderdate);
			status=pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	public ArrayList<Ordertable>extractRestuarantFromResultSet(ResultSet resultSet)
	{
		try {
		while(resultSet.next())
		{
			userList.add(new Ordertable(resultSet.getInt("orderid"),
			resultSet.getInt("restauranid"),
			resultSet.getInt("userid"),
			resultSet.getString("orderdate"),
			resultSet.getFloat("totalamount"),
			resultSet.getString("status"),
			resultSet.getString("paymentmode")
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
