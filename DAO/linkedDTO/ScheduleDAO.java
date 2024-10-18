package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.ScheduleDTO;

public class ScheduleDAO extends _DAOSuper{
	
	public ScheduleDAO() {
		init();
	}

	@Override
	public void insert(String projectName, String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into schedule values (?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				
				System.out.println("날짜를 입력하세요.");
				System.out.println("년도(0000)");
				String cost_year = in.nextLine();
				System.out.println("월(00)");
				String cost_month = in.nextLine();
				pstmt.setString(3, cost_year + "년" + cost_month + "월");
				
				int totalDate = 0;
				String sql_rf0 = "select project_date from project";
				PreparedStatement pstmt_rf0 = con.prepareStatement(sql_rf0);
				ResultSet rs_rf0 = pstmt_rf0.executeQuery();
				if(rs_rf0.next()) {
					totalDate = rs_rf0.getInt("project_date");
				}
				pstmt.setInt(4, totalDate);
				
				// "시작일 - 현재일 = 남은 일수"가 되도록할 필요가 있음
				System.out.println("남은 일수를 입력하시오.");
				int sch_restdate = in.nextInt();
				in.nextLine();
				pstmt.setInt(5, sch_restdate);
				
				int totalTaskCount = 0;
				String sql_rf = "select count(*) total_task from task where task_project_name = ?, task_com_name = ?";
				PreparedStatement pstmt_rf = con.prepareStatement(sql_rf);
				pstmt_rf.setString(1, projectName);
				pstmt_rf.setString(2, companyName);
				ResultSet rs_rf = pstmt_rf.executeQuery();
				if(rs_rf.next()) {
					totalTaskCount = rs_rf.getInt("total_task");
				}
				pstmt.setInt(6, totalTaskCount);
				
				int completeTaskCount = 0;
				String sql_rf1 = "select count(*) completeTask from task where task_project_name = ?, task_com_name = ?, task_progress = '완료'";
				PreparedStatement pstmt_rf1 = con.prepareStatement(sql_rf1);
				pstmt_rf1.setString(1, projectName);
				pstmt_rf1.setString(2, companyName);
				ResultSet rs_rf1 = pstmt_rf1.executeQuery();
				if(rs_rf1.next()) {
					completeTaskCount = rs_rf1.getInt("completeTask");
				}
				pstmt.setInt(7, completeTaskCount);
				
				int requiredDateForCompleteTask = 0;
				String sql_rf2 = "select sum(task_date) requiredDate from task where task_project_name = ?, task_com_name = ?, task_progress = '미완료'";
				PreparedStatement pstmt_rf2 = con.prepareStatement(sql_rf2);
				pstmt_rf2.setString(1, projectName);
				pstmt_rf2.setString(2, companyName);
				ResultSet rs2 = pstmt_rf2.executeQuery();
				if(rs2.next()) {
					completeTaskCount = rs2.getInt("requiredDate");
				}
				pstmt.setInt(8, requiredDateForCompleteTask);
				
				int requiredDateForCompleteTaskPerRestDate = (requiredDateForCompleteTask / sch_restdate);
				pstmt.setInt(9, requiredDateForCompleteTaskPerRestDate*100 + (requiredDateForCompleteTaskPerRestDate%100)*100);
				
				pstmt.executeUpdate();
				con.commit();
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			}
		}
	}

	@Override
	public ArrayList<ScheduleDTO> list(String projectName, String companyName) {
		ArrayList<ScheduleDTO> schDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from schedule where sch_project_name = ?, sch_com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ScheduleDTO schDTO = new ScheduleDTO();
					schDTO.setProjectName(rs.getString("sch_project_name"));
					schDTO.setCompanyName(rs.getString("sch_com_name"));
					schDTO.setDate(rs.getString("sch_date"));
					schDTO.setTotalDate(rs.getInt("sch_totaldate"));
					schDTO.setRestDate(rs.getInt("sch_restdate"));
					schDTO.setTotalTaskCount(rs.getInt("sch_totaltask"));
					schDTO.setCompleteTaskCount(rs.getInt("sch_completetask"));
					schDTO.setRequiredDateForCompleteTask(rs.getInt("sch_requireddateforcompletetask"));
					schDTO.setRequiredDateForCompleteTaskPerRestDate(rs.getInt("sch_ratio"));
					schDTOList.add(schDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return schDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(String projectName, String companyName, String selDate) {
		if(con()) {
			ScheduleDTO schDTO = new ScheduleDTO();
			try {
				String sql = "select * from schedule where sch_project_name = ?, sch_com_name = ?, sch_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				pstmt.setString(3, selDate);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					schDTO.setProjectName(rs.getString("sch_project_name"));
					schDTO.setCompanyName(rs.getString("sch_com_name"));
					schDTO.setDate(rs.getString("sch_date"));
					schDTO.setTotalDate(rs.getInt("sch_totaldate"));
					schDTO.setRestDate(rs.getInt("sch_restdate"));
					schDTO.setTotalTaskCount(rs.getInt("sch_totaltask"));
					schDTO.setCompleteTaskCount(rs.getInt("sch_completetask"));
					schDTO.setRequiredDateForCompleteTask(rs.getInt("sch_requireddateforcompletetask"));
					schDTO.setRequiredDateForCompleteTaskPerRestDate(rs.getInt("sch_ratio"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return schDTO;
		}
		return null;
	}
	
	@Override
	public void update(String projectName, String companyName, String selDate) {
		ScheduleDTO schDTO = (ScheduleDTO) listOne(projectName, companyName, selDate);
		if (con()) {
			try {
				String sql = "update schedule set"
						+ " sch_totaldate = ?,"
						+ " sch_restdate = ?,"
						+ " sch_totaltask = ?,"
						+ " sch_completetask = ?,"
						+ " sch_requireddateforcompletetask = ?,"
						+ " sch_ratio = ?"
						+ " where sch_project_name = ?, sch_com_name = ?, sch_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, schDTO.getDate());
				pstmt.setInt(2, schDTO.getTotalDate());
				pstmt.setInt(3, schDTO.getRestDate());
				pstmt.setInt(4, schDTO.getTotalTaskCount());
				pstmt.setInt(5, schDTO.getCompleteTaskCount());
				pstmt.setInt(6, schDTO.getRequiredDateForCompleteTask());
				pstmt.setInt(7, schDTO.getRequiredDateForCompleteTaskPerRestDate());
				pstmt.setString(8, projectName);
				pstmt.setString(9, companyName);
				pstmt.setString(10, selDate);
//				System.out.println(pstmt);
				pstmt.executeUpdate();
				con.commit();
			} catch (Exception e) {
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(String projectName, String companyName, String delDate) {
		if(con()) {
			try {
				String sql = "delete from schedulewhere sch_project_name = ?, sch_com_name = ?, sch_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				pstmt.setString(3, delDate);
				pstmt.executeUpdate();
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}	
	}
	
}
