package com.hagan.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hagan.models.Employee;
import com.hagan.util.DBConnect;

public class EmployeeServiceImpl implements EmployeeService {
	Connection conn = DBConnect.getConnection();

	@Override
	public Employee getEmployee(String username) {
		try {

			String sql = "SELECT * FROM benco_emp WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = new Employee();

				e.setUsername(rs.getString("USERNAME"));
				e.setPassword(rs.getString("PASSWORD"));
				e.setRole(rs.getString("EMPLOYEE_TYPE"));

				return e;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}
}
