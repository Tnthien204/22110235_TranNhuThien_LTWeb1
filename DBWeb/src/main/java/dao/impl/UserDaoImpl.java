package dao.impl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import configs.DBConnectSQL;
import dao.IUserDao;
import models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
		
	@Override
	public List<UserModel> findAll() {
		String sql = " select * from NhanVien"; 
		
		List<UserModel> list = new ArrayList<>();
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString(4), rs.getString(5)) );
			}
			return list;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM NhanVien WHERE id = " + id + "";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				UserModel user = new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("images"), rs.getString("fullname"));
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO NhanVien(id, username, password, images, fullname) VALUES (?, ?, ?, ?, ?) ";
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImages());
			ps.setString(5, user.getFullname());
			
			ps.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		List<UserModel> list = userDao.findAll();
		for(UserModel user : list)
		{
			System.out.println(user);
		}
	}
	
}