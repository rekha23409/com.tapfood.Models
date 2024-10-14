package com.tapfood.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DAO.OrderitemDAO;
import com.tapfood.DBUtils.DBUtil;
import com.tapfood.Model.Orderitem;

public class OrderitemDAOimpl implements OrderitemDAO{
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	
	private static final String ADD_ORDER="insert into `Orderitem`(`orderid`,`menuid`,"
			+ "`quantity`,`subtotal`) "
			+ "values(?,?,?,?)";
	
	private static final String SELECT_ALL="select * from `Orderitem`";
	
	private static final String SELECT_ON_USERID="select * from `Orderitem` where `orderid`=?";
	private static final String UPDATE_ON_USERID="update `Orderitem`set `orderid`=?,`menuid`=?,`quantity`=?,`subtaotal`=?,";
	 private static final String DELETE_ON_ORDERDATE="delete from `Orderitem` where `orderid`=?";
	int status=0;
	ArrayList<Orderitem>userList=new ArrayList<Orderitem>();
	Orderitem res;
	public OrderitemDAOimpl()
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
	public int addOrderitems(Orderitem r) {
		try
		{
			pstmt=con.prepareStatement(ADD_ORDER);
			pstmt.setInt(1,r.getOrderid());
			pstmt.setInt(2,r.getMenuid());
			pstmt.setInt(3,r.getQuantity());			
			pstmt.setFloat(4,r.getSubtotal());
			
			status=pstmt.executeUpdate(ADD_ORDER);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	@Override
	public ArrayList<Orderitem> getAllOrderitems() {
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
	public Orderitem getOrderitem(int orderid ) {
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
	public int updateOrderitem(Orderitem r) {
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_USERID);
			pstmt.setInt(2,r.getOrderid());
			pstmt.setInt(3,r.getMenuid());			
			pstmt.setInt(4,r.getQuantity());
			pstmt.setFloat(5,r.getSubtotal());
		
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int deleteOrderitem(int orderid){
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
	public ArrayList<Orderitem>extractOrderitemFromResultSet(ResultSet resultSet)
	{
		try {
		while(resultSet.next())
		{
			userList.add(new Orderitem(resultSet.getInt("orderitemid"),
			resultSet.getInt("orderid"),
			resultSet.getInt("menuid"),
			resultSet.getInt("quantity"),
			resultSet.getFloat("subtoatal")
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
