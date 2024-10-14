package com.tapfood.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfood.DAO.UserDAO;
import com.tapfood.DBUtils.DBUtil;
import com.tapfood.Model.Users;

public class UserDAOimpl implements UserDAO{
	private static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/user";
    private static String username = "root";
    private static String password = "root";

    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;

    private static final String ADD_USER = "insert into `users`(`username`,`email`,"
            + "`phonenumber`,`password`,`address`) "
            + "values(?,?,?,?,?)";

    private static final String SELECT_ALL = "select * from `users`";

    private static final String SELECT_ON_EMAIL = "select * from `users` where `email`=?";
    private static final String UPDATE_ON_EMAIL = "update `users` set `username`=?,`phonenumber`=?,`password`=?,`address`=? where `email`=?";
    private static final String DELETE_ON_EMAIL = "delete from `users` where `email`=?";
    int status = 0;
    ArrayList<Users> userList = new ArrayList<Users>();
    Users users;

    public UserDAOimpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addUsers(Users u) {
        try {
            pstmt = con.prepareStatement(ADD_USER);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPhonenumber());
            pstmt.setString(4, u.getPassword());
            pstmt.setString(5, u.getAddress());
//            pstmt.setString(6, u.getCuurentdate());
//            pstmt.setString(7, u.getLastlogin());

            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, pstmt, null);
        }

        return status;
    }

    @Override
    public ArrayList<Users> getAllUsers() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(SELECT_ALL);
            userList = extractUsersFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        } 

        return userList;
    }

    @Override
    public Users getUser(String email) {
        Users user = null;
        try {
            pstmt = con.prepareStatement(SELECT_ON_EMAIL);
            pstmt.setString(1, email);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                user = new Users(
                        resultSet.getInt("userid"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("phonenumber"),
                        resultSet.getString("password"),
                        resultSet.getString("address")
//                        resultSet.getString("currentdate"),
//                        resultSet.getString("lastlogin")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return user;
    }

    @Override
    public int updateUser(Users u) {
        try {
            pstmt = con.prepareStatement(UPDATE_ON_EMAIL);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPhonenumber());
            pstmt.setString(3, u.getPassword());
            pstmt.setString(4, u.getAddress());
//            pstmt.setString(5, u.getCuurentdate());
//            pstmt.setString(6, u.getLastlogin());
            pstmt.setString(7, u.getEmail());

            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return status;
    }

    @Override
    public int deleteUser(String email) {
        try {
            pstmt = con.prepareStatement(DELETE_ON_EMAIL);
            pstmt.setString(1, email);
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return status;
    }

    public ArrayList<Users> extractUsersFromResultSet(ResultSet resultSet) {
        ArrayList<Users> usersList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                usersList.add(new Users(
                        resultSet.getInt("userid"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("phonenumber"),
                        resultSet.getString("password"),
                        resultSet.getString("address")
//                        resultSet.getString("currentdate"),
//                        resultSet.getString("lastlogin")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    private void closeResources(ResultSet rs, PreparedStatement ps, Statement st) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	

}
