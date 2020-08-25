package com.hagan.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hagan.models.Alert;
import com.hagan.models.Form;
import com.hagan.util.DBConnect;

public class FormServiceImpl implements FormService {
	public static Connection conn = DBConnect.getConnection();

	@Override
	public Form getForm(Form formId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Form> getFormsByName(String username) {
		try {

			String sql = "SELECT * FROM BENCO_ALERT WHERE USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			List<Form> form = new ArrayList<Form>();

			while (rs.next()) {

				form.add(new Form(rs.getInt("F_ID"), rs.getString("USERNAME"), rs.getString("E_TYPE"),
						rs.getInt("E_COST"), rs.getString("E_GRADE"), rs.getString("E_DATE"), rs.getInt("AMT"),
						rs.getString("GRADE"), rs.getString("STATUS"), rs.getString("E_DESC"), rs.getString("FILES"),
						rs.getString("TIME_SUBMITTED"), rs.getInt("AMT_ADD")));

			}

			return form;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Form sendForm(Form form) {
		try {

			String sql = "CALL add_form(?,?,?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);

//			( USERNAME VARCHAR2, E_TYPE VARCHAR2, E_COST number, E_GRADE VARCHAR2, E_DATE VARCHAR2, AMT NUMBER, GRADE VARCHAR2, STATUS VARCHAR2, E_DESC VARCHAR2, FILES BLOB, TIME_SUBMITTED TIMESTAMP, AMT_ADD number)

			cs.setString(1, form.getUsername());
			cs.setString(2, form.getEventType());
			cs.setInt(3, form.getEventCost());
			cs.setString(4, form.getGradeFormat());
			cs.setString(5, form.getEventDate());
			cs.setInt(6, form.getAmount());
			cs.setString(7, form.getGrade());
			cs.setString(8, form.getStatus());
			cs.setString(9, form.getDescription());			
			cs.setInt(10, form.getAmountAdd());
			cs.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return form;

	}

	@Override
	public boolean updateFinalGrade(Form form) {
		try {
			String sql = "UPDATE BENCO_REQUEST SET GRADE = ? WHERE F_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, form.getGrade());
			ps.setInt(2,  form.getFormId());
			

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}
	
	public List<Form> getAllPendingForms() {
		try {

			String sql = "SELECT * FROM BENCO_ALERT WHERE STATUS = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Pending");

			ResultSet rs = ps.executeQuery();

			List<Form> allforms = new ArrayList<Form>();

			while (rs.next()) {

				allforms.add(new Form(rs.getInt("F_ID"), rs.getString("USERNAME"), rs.getString("E_TYPE"),
						rs.getInt("E_COST"), rs.getString("E_GRADE"), rs.getString("E_DATE"), rs.getInt("AMT"),
						rs.getString("GRADE"), rs.getString("STATUS"), rs.getString("E_DESC"), rs.getString("FILES"),
						rs.getString("TIME_SUBMITTED"), rs.getInt("AMT_ADD")));

			}

			return allforms;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
}
}