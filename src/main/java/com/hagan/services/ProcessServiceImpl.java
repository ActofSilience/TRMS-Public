package com.hagan.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.hagan.models.Process;
import com.hagan.util.DBConnect;

public class ProcessServiceImpl implements ProcessService {
	public static Connection conn = DBConnect.getConnection();

	@Override
	public Process addHeadProcess(Process process) {
		String sql = "UPDATE BENCO_PROCESS SET HEAD_APPROVE = ? , HEAD_REASON = ? WHERE F_ID = ?"; 
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, process.getHeadApprove());
			ps.setString(2,  process.getHeadReason());
			ps.setInt(3, process.getFormId());
			ps.execute(); 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		return null;
	}

	@Override
	public Process addSupProcess(Process process) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
//	@Override
//	public boolean addProcessed(Process process) {
//		try {
//
//		String sql = "INSERT INTO BENCO_PROCESS VALUES(?,?,?,?,?,?)"; 
//		PreparedStatement ps = conn.prepareStatement(sql); 
//		ps.setString(1,  process.getUsername());
//		ps.setInt(2, process.getFormId());
//		ps.setString(3, process.getSupervisorApprove());
//		ps.setString(4,  process.getHeadApprove());
//		ps.setString(5,  process.getSupReason());
//		ps.setString(6, process.getHeadReason());
//		
//		ps.executeQuery(sql); 
//		return true;
//		}catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();}
//		return false;
//	}
//
//	@Override
//	public List<Process> getAllForms(Process forms) {
//		try {
//			String sql = "SELECT * FROM BENCO_REQUEST WHERE USERNAME = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			List<Process> process = new ArrayList<Process>();
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//
//				process.add(new Process(rs.getString("USERNAME"), rs.getInt("F_ID"), rs.getString("SUP_APPROVE"),
//						rs.getString("HEAD_APPROVE"), rs.getString("SUP_REASON"), rs.getString("HEAD_REASON")));
//			}
//			return process;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	@Override
//	public List<Process> getFormsByUser(String username) {
//		try {
//
//			String sql = "SELECT * FROM BENCO_REQUEST WHERE USERNAME = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, username);
//
//			ResultSet rs = ps.executeQuery();
//
//			List<Process> process = new ArrayList<Process>();
//
//			while (rs.next()) {
//
//				process.add(new Process(rs.getString("USERNAME"), rs.getInt("F_ID"), rs.getString("SUP_APPROVE"),
//						rs.getString("HEAD_APPROVE"), rs.getString("SUP_REASON"), rs.getString("HEAD_REASON")));
//			}
//
//			return process;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	@Override
//	public boolean updateProcessSupApprove(Process process) {
//		try {
//			String sql = "UPDATE BENCO_PROCESS SET SUP_APPROVE = 'Approve' WHERE F_ID = ?";
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ps.setInt(1, process.getFormId());
//
//			ps.executeQuery();
//			return true;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return false;
//	}
//	
//	@Override
//	public boolean updateProcessSupReject(Process process) {
//		try {
//			String sql = "UPDATE BENCO_PROCESS SET SUP_APPROVE = 'Reject' WHERE F_ID = ?";
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ps.setInt(1, process.getFormId());
//
//			ps.executeQuery();
//			return true;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return false;
//
//	}
//	
//	
//	@Override
//	public boolean updateProcessHeadReject(Process process) {
//		try {
//			String sql = "UPDATE BENCO_PROCESS SET HEAD_APPROVE = 'Reject' WHERE F_ID = ?";
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ps.setInt(1, process.getFormId());
//
//			ps.executeQuery();
//			return true;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return false;
//
//	}
//	
//	public boolean updateProcessHeadApprove(Process process) {
//		try {
//			String sql = "UPDATE BENCO_PROCESS SET HEAD_APPROVE = 'Approve' WHERE F_ID = ?";
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ps.setInt(1, process.getFormId());
//
//			ps.executeQuery();
//			return true;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return false;
//	}
}