package com.tapfood.DAO;

import java.util.ArrayList;

import com.tapfood.Model.Users;

public interface UserDAO {
	public int addUsers(Users u);
	public ArrayList<Users> getAllUsers();
	public Users getUser(String email);
	public int updateUser(Users u);
	public int deleteUser(String email);
}
