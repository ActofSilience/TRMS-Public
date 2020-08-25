package com.hagan.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.hagan.models.UserLogin;
import com.hagan.util.DBConnect;

public class UserLoginServiceImpl implements UserLoginService {
	Connection conn = DBConnect.getConnection();
	@Override
	public UserLogin getUser(String username) {
try {
			
			String sql = "SELECT * FROM benco_emp WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserLogin u = new UserLogin(); 
			
			u.setUsername(rs.getString("USERNAME"));
			u.setPassword(rs.getString("PASSWORD"));
			u.setEmployeeType(rs.getString("EMPLOYEE_TYPE"));
			
			return u; 
			
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	
	
	
}
