package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.ProjectDTO;
import DTO.TaskDTO;

public class ProjectDAO extends _DAOSuper{
	public ProjectDAO() {
		init();
	}

	@Override
	public void insert(String projectName, String publicvar) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into project values (?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, projectName);
				
				System.out.println("프로젝트 총 기간을 입력하세요.");
				int project_date = in.nextInt();
				in.nextLine();
				pstmt.setInt(2, project_date);
				
				System.out.println("프로젝트 총 예산을 입력하세요.");
				int project_budget = in.nextInt();
				in.nextLine();
				pstmt.setInt(3, project_budget);
				
				System.out.println("프로젝트 개요를 50자 내로 작성하세요.");
				String project_outline = in.nextLine();
				pstmt.setString(4, project_outline);
				
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
	public ArrayList<ProjectDTO> list(String projectName, String companyName) {
		ArrayList<ProjectDTO> projectDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from project";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ProjectDTO projectDTO = new ProjectDTO();
					projectDTO.setProjectName(rs.getString("project_name"));
					projectDTO.setProjectDate(rs.getInt("project_date"));
					projectDTO.setProjectBudget(rs.getInt("project_budget"));
					projectDTO.setProjectOutline(rs.getString("project_outline"));
					projectDTOList.add(projectDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return projectDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(String projectName, String companyName, String publicVar) {
		if(con()) {
			ProjectDTO projectDTO = new ProjectDTO();
			try {
				String sql = "select * from project where project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					projectDTO.setProjectName(rs.getString("project_name"));
					projectDTO.setProjectDate(rs.getInt("project_date"));
					projectDTO.setProjectBudget(rs.getInt("project_budget"));
					projectDTO.setProjectOutline(rs.getString("project_outline"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return projectDTO;
		}
		return null;
	}

	@Override
	public void update(String projectName, String companyName, String publicvar) {
		ProjectDTO projectDTO = (ProjectDTO) listOne(projectName, null, null);
		if (con()) {
			try {
				String sql = "update project set"
						+ " project_name = ?,"
						+ " project_date = ?,"
						+ " project_budget = ?,"
						+ " project_outline = ?"
						+ " where project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectDTO.getProjectName());
				pstmt.setInt(2, projectDTO.getProjectDate());
				pstmt.setInt(3, projectDTO.getProjectBudget());
				pstmt.setString(4, projectDTO.getProjectOutline());
				pstmt.setString(5, projectName);
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
	public void delete(String projectName, String companyName, String publicvar) {
		if(con()) {
			try {
				String sql = "delete from project where project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
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
