package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.ProjectDTO;

public class ProjectDAO extends _DAOSuper{
	public ProjectDAO() {
		init();
	}

	@Override
	public void insert(Object object, String p1, String p2) {
		ProjectDTO getProjectDTO = (ProjectDTO) object;
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into project values (?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, getProjectDTO.getProjectName());
				pstmt.setInt(2, getProjectDTO.getProjectDate());
				pstmt.setLong(3, getProjectDTO.getProjectBudget());
				pstmt.setString(4, getProjectDTO.getProjectOutline());
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
	public ArrayList<ProjectDTO> list(Object object) {
//		null 입력받도록 설정해야한다.
//		ProjectDTO getProjectDTO = (ProjectDTO) object;
		ArrayList<ProjectDTO> setProjectDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from project";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ProjectDTO setProjectDTO = new ProjectDTO();
					setProjectDTO.setProjectName(rs.getString("project_name"));
					setProjectDTO.setProjectDate(rs.getInt("project_date"));
					setProjectDTO.setProjectBudget(rs.getLong("project_budget"));
					setProjectDTO.setProjectOutline(rs.getString("project_outline"));
					setProjectDTOList.add(setProjectDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setProjectDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(Object object) {
//		ProjectDTO getProjectDTO = (ProjectDTO) object;
		if(con()) {
			ProjectDTO setProjectDTO = new ProjectDTO();
			try {
				String sql = "select * from project where project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setObject(1, object);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					setProjectDTO.setProjectName(rs.getString("project_name"));
					setProjectDTO.setProjectDate(rs.getInt("project_date"));
					setProjectDTO.setProjectBudget(rs.getInt("project_budget"));
					setProjectDTO.setProjectOutline(rs.getString("project_outline"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setProjectDTO;
		}
		return null;
	}

	@Override
	public void update(Object object1, Object object2) {
		ProjectDTO getProjectDTO = (ProjectDTO) object1;
//		listOne(getProjectDTO);
		ProjectDTO setProjectDTO = (ProjectDTO) object2;
		if (con()) {
			try {
				String sql = "update project set"
						+ " project_name = ?,"
						+ " project_date = ?,"
						+ " project_budget = ?,"
						+ " project_outline = ?"
						+ " where project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, setProjectDTO.getProjectName());
				pstmt.setInt(2, setProjectDTO.getProjectDate());
				pstmt.setLong(3, setProjectDTO.getProjectBudget());
				pstmt.setString(4, setProjectDTO.getProjectOutline());
				pstmt.setString(5, getProjectDTO.getProjectName());
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
		ProjectDTO getProjectDTO = (ProjectDTO) object;
		if(con()) {
			try {
				String sql = "delete from project where project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getProjectDTO.getProjectName());
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
