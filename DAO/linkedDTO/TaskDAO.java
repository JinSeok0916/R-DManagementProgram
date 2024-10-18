package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.CompanyDTO;
import DTO.TaskDTO;

public class TaskDAO extends _DAOSuper{
	public TaskDAO() {
		init();
	}

	@Override
	public void insert(String projectName, String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into task values (?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				
				System.out.println("업무 명칭을 작성해주세요.");
				String task_name = in.nextLine();
				pstmt.setString(3, task_name);
				
				System.out.println("업무 우선순위를 상, 중, 하 중 하나로 입력하세요.");
				String task_priority = in.nextLine();
				pstmt.setString(4, task_priority);
				
				System.out.println("업무처리에 필요한 기간을 입력하시오.(단, 연구개발 총 기간보다 짧아야 합니다.");
				int task_date = in.nextInt();
				in.nextLine();
				pstmt.setInt(5, task_date);
				
				System.out.println("업무 처리 여부를 입력해주세요.");
				TaskDTO taskDTO = new TaskDTO();
				String task_progress = null;
				if(taskDTO.isTaskProgress() == true) {
					task_progress = "완료";
					pstmt.setString(6, task_progress);
				} else {
					task_progress = "미완료";
					pstmt.setString(6, task_progress);
				}
				
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
	public ArrayList<TaskDTO> list(String projectName, String companyName) {
		ArrayList<TaskDTO> taskDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from task where task_project_name = ?, task_com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					TaskDTO taskDTO = new TaskDTO();
					taskDTO.setCompanyName(rs.getString("task_project_name"));
					taskDTO.setCompanyName(rs.getString("task_com_name"));
					taskDTO.setTaskName(rs.getString("task_name"));
					taskDTO.setTaskPriority(rs.getString("task_priority"));
					taskDTO.setTaskDate(rs.getInt("task_date"));
					taskDTO.setTaskProgress(rs.getBoolean("task_progress"));
					taskDTOList.add(taskDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return taskDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(String projectName, String companyName, String selTaskName) {
		if(con()) {
			TaskDTO taskDTO = new TaskDTO();
			try {
				String sql = "select * from task where task_project_name = ?, task_com_name = ?, task_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				pstmt.setString(3, selTaskName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					taskDTO.setCompanyName(rs.getString("task_project_name"));
					taskDTO.setCompanyName(rs.getString("task_com_name"));
					taskDTO.setTaskName(rs.getString("task_name"));
					taskDTO.setTaskPriority(rs.getString("task_priority"));
					taskDTO.setTaskDate(rs.getInt("task_date"));
					taskDTO.setTaskProgress(rs.getBoolean("task_progress"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return taskDTO;
		}
		return null;
	}
	@Override
	public void update(String projectName, String companyName, String selTaskName) {
		TaskDTO taskDTO = (TaskDTO) listOne(projectName, companyName, selTaskName);
		if (con()) {
			try {
				String sql = "update task set"
						+ " task_name = ?,"
						+ " task_priority = ?,"
						+ " task_date = ?,"
						+ " task_progress = ?"
						+ " where task_project_name = ?, task_com_name = ?, task_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, taskDTO.getTaskName());
				pstmt.setString(2, taskDTO.getTaskPriority());
				pstmt.setInt(3, taskDTO.getTaskDate());
				pstmt.setBoolean(4, taskDTO.isTaskProgress());
				pstmt.setString(5, projectName);
				pstmt.setString(6, companyName);
				pstmt.setString(7, selTaskName);
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
	public void delete(String projectName, String companyName, String delTaskName) {
		if(con()) {
			try {
				String sql = "delete from task where task_project_name = ?, task_com_name = ?, task_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				pstmt.setString(3, delTaskName);
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
