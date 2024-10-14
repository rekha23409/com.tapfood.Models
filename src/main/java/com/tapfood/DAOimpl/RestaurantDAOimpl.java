package com.tapfood.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DAO.RestaurantDAO;
import com.tapfood.DBUtils.DBUtil;
import com.tapfood.Model.Restaurant;

public class RestaurantDAOimpl implements RestaurantDAO{
	Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	
	private static final String ADD_USER="insert into `Restaurant`(`restaurantname`,`deliverytime`,"
			+ "`cusiontype`,`address`,`ratings`,`isactive`,`adminid`,`imagepath`) "
			+ "values(?,?,?,?,?,?,?,?)";
	
	private static final String SELECT_ALL="select * from `Restaurant`";
	
	private static final String SELECT_ON_ADDRESS="select * from `Restaurant` where `address`=?";
	private static final String UPDATE_ON_ADDRESS="update `Restaurant`set `restaurantname`=?,`deliverytime`=?,`cusiontype`=?,`address`=?,`ratings`=?,`isactive`=?,`adminid`=?,`imagepath`=? where `address`=?";
	 private static final String DELETE_ON_ADDRESS="delete from `Restaurant` where `address`=?";
	int status=0;
	ArrayList<Restaurant>userList=new ArrayList<Restaurant>();
	Restaurant res;
	public RestaurantDAOimpl()
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
	public int addRestaurant(Restaurant r) {
	    try {
	        pstmt = con.prepareStatement(ADD_USER);
	        pstmt.setString(1, r.getRestaurantname());
	        pstmt.setInt(2, r.getDeliverytime());
	        pstmt.setString(3, r.getCusiontype());
	        pstmt.setString(4, r.getAddress());
	        pstmt.setFloat(5, r.getRatings());
	        pstmt.setString(6, r.getIsactive());
	        pstmt.setInt(7, r.getAdminid());
	        pstmt.setString(8, r.getImagepath());

	        status = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}
//	@Override
//	public ArrayList<Restaurant> getAllRestaurant() {
//		try
//		{
//			stmt=con.createStatement();
//			resultSet=stmt.executeQuery(SELECT_ALL);
//			userList=extractRestuarantFromResultSet(resultSet);
//			
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		return userList ;
//	}
	
	@Override
	public ArrayList<Restaurant> getAllRestaurant() {
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
	public Restaurant getRestaurant(String address) {
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_ADDRESS);
			pstmt.setString(1, address);
			
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
	public int updateRestaurant(Restaurant r) {
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_ADDRESS);
			pstmt.setString(1,r.getRestaurantname());
			pstmt.setInt(2,r.getDeliverytime());
			pstmt.setString(3,r.getCusiontype());			
			pstmt.setString(4,r.getAddress());
			pstmt.setFloat(5,r.getRatings());
			pstmt.setString(6,r.getIsactive());
			pstmt.setInt(7,r.getAdminid());
			pstmt.setString(8,r.getImagepath());
			
			status=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int deleteRestaurant(String address) {
		try
		{
			con.prepareStatement(DELETE_ON_ADDRESS);
			pstmt.setString(1,address);
			status=pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	public ArrayList<Restaurant>extractRestuarantFromResultSet(ResultSet resultSet)
	{
		try {
		while(resultSet.next())
		{
			userList.add(new Restaurant(resultSet.getInt("restaurantid"),
			resultSet.getString("restaurantname"),
			resultSet.getInt("deliverytime"),
			resultSet.getString("cusiontype"),
			resultSet.getString("address"),
			resultSet.getFloat("ratings"),
			resultSet.getString("isactive"),
			resultSet.getInt("adminid"),
			resultSet.getString("imagepath")));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userList;
		
	}
	

}
