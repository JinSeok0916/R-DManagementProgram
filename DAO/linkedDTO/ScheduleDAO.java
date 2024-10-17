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
	public void insert(String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into "+companyName+"_schedule values (?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, companyName);
				
				System.out.println("4자리 숫자(년월)을 입력해주세요.");
				String sch_date = in.nextLine();
				pstmt.setString(2, sch_date);
				
				System.out.println("연구개발에 필요한 총 일수를 입력하시오.");
				int sch_totaldate = in.nextInt();
				in.nextLine();
				pstmt.setInt(3, sch_totaldate);
				
				// "시작일 - 현재일 = 남은 일수"가 되도록할 필요가 있음
				System.out.println("남은 일수를 입력하시오.");
				int sch_restdate = in.nextInt();
				in.nextLine();
				pstmt.setInt(4, sch_restdate);
				
				int totalTaskCount = 0;
				String sql_rf = "select count(*) total_task from "+companyName+"_task";
				PreparedStatement pstmt_rf = con.prepareStatement(sql_rf);
				ResultSet rs_rf = pstmt_rf.executeQuery();
				if(rs_rf.next()) {
					totalTaskCount = rs_rf.getInt("total_task");
				}
				pstmt.setInt(5, totalTaskCount);
				
				int completeTaskCount = 0;
				String sql_rf1 = "select count(*) completeTask from "+companyName+"_task where task_progress = '완료'";
				PreparedStatement pstmt_rf1 = con.prepareStatement(sql_rf1);
				ResultSet rs_rf1 = pstmt_rf1.executeQuery();
				if(rs_rf1.next()) {
					completeTaskCount = rs_rf1.getInt("completeTask");
				}
				pstmt.setInt(6, completeTaskCount);
				
				int requiredDateForCompleteTask = 0;
				String sql_rf2 = "select sum(task_date) requiredDate from "+companyName+"_task where task_progress = '미완료'";
				PreparedStatement pstmt_rf2 = con.prepareStatement(sql_rf2);
				ResultSet rs2 = pstmt_rf2.executeQuery();
				if(rs2.next()) {
					completeTaskCount = rs2.getInt("requiredDate");
				}
				pstmt.setInt(7, requiredDateForCompleteTask);
				
				int requiredDateForCompleteTaskPerRestDate = (requiredDateForCompleteTask / sch_restdate);
				pstmt.setInt(8, requiredDateForCompleteTaskPerRestDate*100 + (requiredDateForCompleteTaskPerRestDate%100)*100);
				
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
	public ArrayList<ScheduleDTO> list(String companyName) {
		ArrayList<ScheduleDTO> schDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from "+companyName+"_schedule";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ScheduleDTO schDTO = new ScheduleDTO();
					schDTO.setCompanyName(rs.getString("sch_com_company"));
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
	public Object listOne(String companyName, String selDate) {
		if(con()) {
			ScheduleDTO schDTO = new ScheduleDTO();
			try {
				String sql = "select * from "+companyName+"_cost where sch_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, selDate);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					schDTO.setCompanyName(rs.getString("sch_com_company"));
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

	public void update(String companyName, int totalDate, int restDate, int totalTaskCount, int completeTaskCount, int requiredDateForCompleteTask, int requiredDateForCompleteTaskPerRestDate, String selDate) {
		if (con()) {
			try {
				String sql = "update "+companyName+"_schedule set"
						+ " sch_totaldate = ?,"
						+ " sch_restdate = ?,"
						+ " sch_totaltask = ?,"
						+ " sch_completetask = ?,"
						+ " sch_requireddateforcompletetask = ?,"
						+ " sch_ratio = ?"
						+ " where sch_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, totalDate);
				pstmt.setInt(2, restDate);
				pstmt.setInt(3, totalTaskCount);
				pstmt.setInt(4, completeTaskCount);
				pstmt.setInt(5, requiredDateForCompleteTask);
				pstmt.setInt(6, requiredDateForCompleteTaskPerRestDate);
				pstmt.setString(7, selDate);
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
	public void delete(String companyName, String delDate) {
		if(con()) {
			try {
				String sql = "delete from "+companyName+"_schedule where sch_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, delDate);
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
