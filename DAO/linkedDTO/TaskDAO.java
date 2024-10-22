package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.ParticipatingOrganizationDTO;
import DTO.TaskDTO;

public class TaskDAO extends _DAOSuper{
	public TaskDAO() {
		init();
	}

	@Override
	public void insert(Object object, String projectName, String companyName) {
		TaskDTO getTaskDTO = (TaskDTO) object;
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into task values (?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, getTaskDTO.getProjectName());
				pstmt.setString(2, getTaskDTO.getOrganizationName());
				pstmt.setString(3, getTaskDTO.getTaskName());
				pstmt.setString(4, getTaskDTO.getTaskPriority());
				pstmt.setInt(5, getTaskDTO.getTaskDate());
				
				String task_progress = null;
				if(getTaskDTO.isTaskProgress() == true) {
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
		if (in != null) {
			try {
				in.close();
			} catch (Exception e2) {
			}
		}
	}

	@Override
	public ArrayList<TaskDTO> list(Object object) {
		ParticipatingOrganizationDTO getParticipatingOrganizationDTO = (ParticipatingOrganizationDTO) object;
		ArrayList<TaskDTO> setTaskDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from task where task_project_name = ? and task_org_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getParticipatingOrganizationDTO.getProjectName());
				pstmt.setString(2, getParticipatingOrganizationDTO.getOrganizationName());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					TaskDTO setTaskDTO = new TaskDTO();
					setTaskDTO.setProjectName(rs.getString("task_project_name"));
					setTaskDTO.setOrganizationName(rs.getString("task_org_name"));
					setTaskDTO.setTaskName(rs.getString("task_name"));
					setTaskDTO.setTaskPriority(rs.getString("task_priority"));
					setTaskDTO.setTaskDate(rs.getInt("task_date"));
					setTaskDTO.setTaskProgress(rs.getBoolean("task_progress"));
					setTaskDTOList.add(setTaskDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setTaskDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(Object object) {
		TaskDTO getTaskDTO = (TaskDTO) object;
		if(con()) {
			TaskDTO setTaskDTO = new TaskDTO();
			try {
				String sql = "select * from task where task_project_name = ? and task_com_name = ? and task_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getTaskDTO.getProjectName());
				pstmt.setString(2, getTaskDTO.getOrganizationName());
				pstmt.setString(3, getTaskDTO.getTaskName());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					setTaskDTO.setProjectName(rs.getString("task_project_name"));
					setTaskDTO.setOrganizationName(rs.getString("task_org_name"));
					setTaskDTO.setTaskName(rs.getString("task_name"));
					setTaskDTO.setTaskPriority(rs.getString("task_priority"));
					setTaskDTO.setTaskDate(rs.getInt("task_date"));
					setTaskDTO.setTaskProgress(rs.getBoolean("task_progress"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setTaskDTO;
		}
		return null;
	}
	@Override
	public void update(Object object) {
		TaskDTO setTaskDTO = (TaskDTO) object;
//		listOne(getTaskDTO);
//		TaskDTO setTaskDTO = new TaskDTO();
		if (con()) {
			try {
				String sql = "update task set"
						+ " task_name = ?,"
						+ " task_priority = ?,"
						+ " task_date = ?,"
						+ " task_progress = ?"
						+ " where task_project_name = ? and task_com_name = ? and task_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, setTaskDTO.getTaskName());
				pstmt.setString(2, setTaskDTO.getTaskPriority());
				pstmt.setInt(3, setTaskDTO.getTaskDate());
				pstmt.setBoolean(4, setTaskDTO.isTaskProgress());
				pstmt.setString(5, setTaskDTO.getProjectName());
				pstmt.setString(6, setTaskDTO.getOrganizationName());
				pstmt.setString(7, setTaskDTO.getTaskName());
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
		TaskDTO getTaskDTO = (TaskDTO) object;
		if(con()) {
			try {
				String sql = "delete from task where task_project_name = ? and task_org_name = ? and task_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getTaskDTO.getProjectName());
				pstmt.setString(2, getTaskDTO.getOrganizationName());
				pstmt.setString(3, getTaskDTO.getTaskName());
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
