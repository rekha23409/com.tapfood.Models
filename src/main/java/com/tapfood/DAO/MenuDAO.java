package com.tapfood.DAO;

import java.util.ArrayList;
import java.util.List;

import com.tapfood.Model.Menu;

public interface MenuDAO {
	public int addMenu(Menu m);
	public ArrayList<Menu> getAllMenu();
	public List<Menu> getMenu(int restaurantid);
	public int updateMenu(Menu m);
	public int deleteMenu(int menuid);
	Menu getMenue(int menuid);

}
