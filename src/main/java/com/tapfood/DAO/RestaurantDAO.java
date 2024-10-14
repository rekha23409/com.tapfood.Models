package com.tapfood.DAO;

import java.util.ArrayList;

import com.tapfood.Model.Restaurant;

public interface RestaurantDAO {
	public int addRestaurant(Restaurant r);
	public ArrayList<Restaurant> getAllRestaurant();
	public Restaurant getRestaurant(String address );
	public int updateRestaurant(Restaurant r);
	public int deleteRestaurant(String address);


}
