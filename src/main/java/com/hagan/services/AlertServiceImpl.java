package com.hagan.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hagan.util.DBConnect;
import com.hagan.models.Alert;

public class AlertServiceImpl implements AlertService {
	public static Connection conn = DBConnect.getConnection();
	@Override
	public Alert getBalance(Alert balance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alert getStatus(Alert status) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Alert> getForms(Alert alert) {
		try {

			String sql = "SELECT * FROM BENCO_ALERT";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Alert> alerts = new ArrayList<Alert>();

			while (rs.next()) {

				alerts.add(new Alert(rs.getString("USERNAME"), rs.getInt("F_ID"), rs.getInt("AMOUNT"), rs.getInt("BALANCE"),
						rs.getString("STATUS")));

			}

			return alerts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Alert> getFormsByUser(String username) {
		try {

			String sql = "SELECT * FROM BENCO_ALERT WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();

			List<Alert> alerts = new ArrayList<Alert>();

			while (rs.next()) {

				alerts.add(new Alert(rs.getString("USERNAME"), rs.getInt("F_ID"), rs.getInt("AMOUNT"), rs.getInt("BALANCE"),
						rs.getString("STATUS")));

			}

			return alerts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
