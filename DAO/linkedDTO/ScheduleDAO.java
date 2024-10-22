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
	public void insert(Object object, String p1, String p2) {
		Scanner in = new Scanner(System.in);
		ScheduleDTO getScheduleDTO = (ScheduleDTO) object;
		if (con()) {
			try {
				String sql = "insert into schedule values (?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, getScheduleDTO.getProjectName());
				pstmt.setString(2, getScheduleDTO.getCompanyName());
				pstmt.setString(3, getScheduleDTO.getDate());
				
				// 입력값을 받지 못하도록 설정
				int totalDate = 0;
				String sql_rf0 = "select project_date from project";
				PreparedStatement pstmt_rf0 = con.prepareStatement(sql_rf0);
				ResultSet rs_rf0 = pstmt_rf0.executeQuery();
				if(rs_rf0.next()) {
					totalDate = rs_rf0.getInt("project_date");
				}
				pstmt.setInt(4, totalDate);
				
				// "시작일 - 현재일 = 남은 일수"가 되도록할 필요가 있음
				pstmt.setInt(5, getScheduleDTO.getRestDate());
				
				// 입력값을 받지 못하도록 설정
				int totalTaskCount = 0;
				String sql_rf = "select count(*) total_task from task where task_project_name = ?, task_com_name = ?";
				PreparedStatement pstmt_rf = con.prepareStatement(sql_rf);
				pstmt_rf.setString(1, getScheduleDTO.getProjectName());
				pstmt_rf.setString(2, getScheduleDTO.getCompanyName());
				ResultSet rs_rf = pstmt_rf.executeQuery();
				if(rs_rf.next()) {
					totalTaskCount = rs_rf.getInt("total_task");
				}
				pstmt.setInt(6, totalTaskCount);
				
				// 입력값을 받지 못하도록 설정
				int completeTaskCount = 0;
				String sql_rf1 = "select count(*) completeTask from task where task_project_name = ?, task_com_name = ?, task_progress = '완료'";
				PreparedStatement pstmt_rf1 = con.prepareStatement(sql_rf1);
				pstmt_rf1.setString(1, getScheduleDTO.getProjectName());
				pstmt_rf1.setString(2, getScheduleDTO.getCompanyName());
				ResultSet rs_rf1 = pstmt_rf1.executeQuery();
				if(rs_rf1.next()) {
					completeTaskCount = rs_rf1.getInt("completeTask");
				}
				pstmt.setInt(7, completeTaskCount);
				
				// 입력값을 받지 못하도록 설정
				int requiredDateForCompleteTask = 0;
				String sql_rf2 = "select sum(task_date) requiredDate from task where task_project_name = ?, task_com_name = ?, task_progress = '미완료'";
				PreparedStatement pstmt_rf2 = con.prepareStatement(sql_rf2);
				pstmt_rf2.setString(1, getScheduleDTO.getProjectName());
				pstmt_rf2.setString(2, getScheduleDTO.getCompanyName());
				ResultSet rs2 = pstmt_rf2.executeQuery();
				if(rs2.next()) {
					completeTaskCount = rs2.getInt("requiredDate");
				}
				pstmt.setInt(8, requiredDateForCompleteTask);
				
				int requiredDateForCompleteTaskPerRestDate = (requiredDateForCompleteTask / getScheduleDTO.getRestDate())*100;
				pstmt.setInt(9, requiredDateForCompleteTaskPerRestDate + requiredDateForCompleteTaskPerRestDate%100);
				
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
		if (in != null) {
			try {
				in.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public ArrayList<ScheduleDTO> list(Object object) {
		ScheduleDTO getScheduleDTO = (ScheduleDTO) object;
		ArrayList<ScheduleDTO> setScheduleDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from schedule where sch_project_name = ?, sch_com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getScheduleDTO.getProjectName());
				pstmt.setString(2, getScheduleDTO.getCompanyName());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ScheduleDTO setScheduleDTO = new ScheduleDTO();
					setScheduleDTO.setProjectName(rs.getString("sch_project_name"));
					setScheduleDTO.setCompanyName(rs.getString("sch_com_name"));
					setScheduleDTO.setDate(rs.getString("sch_date"));
					setScheduleDTO.setTotalDate(rs.getInt("sch_totaldate"));
					setScheduleDTO.setRestDate(rs.getInt("sch_restdate"));
					setScheduleDTO.setTotalTaskCount(rs.getInt("sch_totaltask"));
					setScheduleDTO.setCompleteTaskCount(rs.getInt("sch_completetask"));
					setScheduleDTO.setRequiredDateForCompleteTask(rs.getInt("sch_requireddateforcompletetask"));
					setScheduleDTO.setRequiredDateForCompleteTaskPerRestDate(rs.getInt("sch_ratio"));
					setScheduleDTOList.add(setScheduleDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setScheduleDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(Object object) {
		ScheduleDTO getScheduleDTO = (ScheduleDTO) object;
		if(con()) {
			ScheduleDTO setScheduleDTO = new ScheduleDTO();
			try {
				String sql = "select * from schedule where sch_project_name = ?, sch_com_name = ?, sch_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getScheduleDTO.getProjectName());
				pstmt.setString(2, getScheduleDTO.getCompanyName());
				pstmt.setString(3, getScheduleDTO.getDate());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					setScheduleDTO.setProjectName(rs.getString("sch_project_name"));
					setScheduleDTO.setCompanyName(rs.getString("sch_com_name"));
					setScheduleDTO.setDate(rs.getString("sch_date"));
					setScheduleDTO.setTotalDate(rs.getInt("sch_totaldate"));
					setScheduleDTO.setRestDate(rs.getInt("sch_restdate"));
					setScheduleDTO.setTotalTaskCount(rs.getInt("sch_totaltask"));
					setScheduleDTO.setCompleteTaskCount(rs.getInt("sch_completetask"));
					setScheduleDTO.setRequiredDateForCompleteTask(rs.getInt("sch_requireddateforcompletetask"));
					setScheduleDTO.setRequiredDateForCompleteTaskPerRestDate(rs.getInt("sch_ratio"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setScheduleDTO;
		}
		return null;
	}
	
	@Override
	public void update(Object object1, Object object2) {
		ScheduleDTO getScheduleDTO = (ScheduleDTO) object1;
		listOne(getScheduleDTO);
		ScheduleDTO setscheduleDTO = new ScheduleDTO();
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
				pstmt.setString(1, setscheduleDTO.getDate());
				pstmt.setInt(2, setscheduleDTO.getTotalDate());
				pstmt.setInt(3, setscheduleDTO.getRestDate());
				pstmt.setInt(4, setscheduleDTO.getTotalTaskCount());
				pstmt.setInt(5, setscheduleDTO.getCompleteTaskCount());
				pstmt.setInt(6, setscheduleDTO.getRequiredDateForCompleteTask());
				pstmt.setInt(7, setscheduleDTO.getRequiredDateForCompleteTaskPerRestDate());
				pstmt.setString(8, getScheduleDTO.getProjectName());
				pstmt.setString(9, getScheduleDTO.getCompanyName());
				pstmt.setString(10, getScheduleDTO.getDate());
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
	public void delete(Object object) {
		ScheduleDTO getScheduleDTO = (ScheduleDTO) object;
		if(con()) {
			try {
				String sql = "delete from schedulewhere sch_project_name = ?, sch_com_name = ?, sch_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getScheduleDTO.getProjectName());
				pstmt.setString(2, getScheduleDTO.getCompanyName());
				pstmt.setString(3, getScheduleDTO.getDate());
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
