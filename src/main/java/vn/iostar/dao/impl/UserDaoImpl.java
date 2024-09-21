package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBConnectMySQL;
import vn.iostar.configs.DBConnectSQL;
import vn.iostar.controllers.models.UserModel;
import vn.iostar.dao.IUserDao;

public class UserDaoImpl implements IUserDao{

	public UserModel findByUsername(String username) {
		String sql = "select * from users where username =?";
		try {
			Connection conn= new DBConnectMySQL().getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			UserModel user = new UserModel();
			while(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public UserModel findById(int id) {
		String sql = "select * from users where id =?";
		try {
			Connection conn= new DBConnectMySQL().getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			UserModel user = new UserModel();
			while(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users ";
		List<UserModel> list = new ArrayList();
		try {
			Connection conn= new DBConnectMySQL().getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			UserModel user = new UserModel();
			while(rs.next()) {
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				list.add(user);
				return list;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		 try {
			 IUserDao userDao = new UserDaoImpl();
			 System.out.println(userDao.findByUsername("huy"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
}
