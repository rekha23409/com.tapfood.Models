package com.tapfood.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DAO.MenuDAO;
import com.tapfood.DBUtils.DBUtil;
import com.tapfood.Model.Menu;

public class MenuDAOimpl implements MenuDAO{

	private DBUtil con;
	private Connection connection;
	private PreparedStatement pstmt;
	private static final String ADD_MENU=
			"insert into Menu(restaurantid,menuname,price,description,isavailable,imagepath)"+
					"values(?,?,?,?,?,?)";
	private static final String SELECT_ALL="select * from Menu WHERE restaurantid=?";
	private static final String SELECT_ON_RESTUARANTID="SELECT * FROM Menu WHERE restaurantid=?";
	private static final String UPDATE_ON_MENUID="UPDATE Menu SET restaurantid=?,menuname=?,price=?,description=?,isavailable=?,imagepath=? where menuid=?";
	private static final String DELETE_ON_MENUID="DELETE from Menu where menuid=?";
	private static final String SELECT_MENU_BY_ID="SELECT * FROM Menu WHERE menuid=?";
	ArrayList<Menu> userList=new ArrayList<Menu>();
	private Statement stmt;
	private ResultSet res;
	private Menu menu;
	private ArrayList<Menu> menuList;
	public MenuDAOimpl() {
		try {
			con=DBUtil.getDBUtils();
			connection=con.myConnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int addMenu(Menu m) {
		try {
			pstmt=connection.prepareStatement(ADD_MENU);
			pstmt.setInt(1, m.getMenuid());
			pstmt.setInt(2,m.getRestaurantid());
			pstmt.setString(3, m.getMenuname());
			pstmt.setFloat(4,m.getPrice());
			pstmt.setString(5, m.getDescription());
			pstmt.setString(6, m.getIsavailable());
			pstmt.setString(7,m.getImagepath());
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Menu> getAllMenu() {
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(SELECT_ALL); 
			userList=extractUserFromResultSet( res); 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userList;
	}

	@Override
	public ArrayList<Menu> getMenu(int restaurantid) {
		try {
			pstmt=connection.prepareStatement(SELECT_ON_RESTUARANTID);
			pstmt.setInt(1, restaurantid);
			res=pstmt.executeQuery();
			menuList=extractUserFromResultSet(res);
//			menu=userList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}
	
	@Override
	public Menu getMenue(int menuid) {
	    Menu menu = null;
	    try {
	        pstmt = connection.prepareStatement(SELECT_MENU_BY_ID);
	        pstmt.setInt(1, menuid);
	        res = pstmt.executeQuery();
	        if (res.next()) {
	            menu = new Menu(
	                res.getInt("menuid"),
	                res.getInt("restaurantid"),
	                res.getString("menuname"),
	                res.getFloat("price"),
	                res.getString("description"),
	                res.getString("isavailable"),
	                res.getString("imagepath")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return menu;
	}

	

	@Override
	public int updateMenu(Menu m) {
		try {	
			pstmt=connection.prepareStatement(UPDATE_ON_MENUID);
			pstmt.setInt(1, m.getMenuid());
			pstmt.setInt(2,m.getRestaurantid());
			pstmt.setString(3, m.getMenuname());
			pstmt.setFloat(4,m.getPrice());
			pstmt.setString(5, m.getDescription());
			pstmt.setString(6, m.getIsavailable());
			pstmt.setString(7,m.getImagepath());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMenu(int menuid) {
		try {
			pstmt=connection.prepareStatement(DELETE_ON_MENUID);
			pstmt.setInt(1,menuid);
			return pstmt.executeUpdate();	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	ArrayList<Menu> extractUserFromResultSet(ResultSet res) {
		try {
			while(res.next()) {
				userList.add(new Menu(res.getInt("menuid"),
						res.getInt("restaurantid"),
						res.getString("menuName"),
						res.getFloat("price"),
						res.getString("description"),
						res.getString("isavailable"),
						res.getString("imagepath")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	

}