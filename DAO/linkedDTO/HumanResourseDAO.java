package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.HumanResourceDTO;
import DTO.ParticipatingOrganizationDTO;

public class HumanResourseDAO extends _DAOSuper {
	
	@Override
	public void insert(Object object) {
		HumanResourceDTO getHumanResourceDTO = (HumanResourceDTO) object;
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into humanresource values (?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, getHumanResourceDTO.getProjectName());
				pstmt.setString(2, getHumanResourceDTO.getOrganizationName());
				pstmt.setString(3, getHumanResourceDTO.getParticipatingWorkforce());
				pstmt.setString(4, getHumanResourceDTO.getIdenNumber());
				pstmt.setString(5, getHumanResourceDTO.getLevel());
				pstmt.setInt(6, getHumanResourceDTO.getAge());
				pstmt.setString(7, getHumanResourceDTO.getGraduate());
				pstmt.setInt(8, getHumanResourceDTO.getSalary());
				
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
	public ArrayList<HumanResourceDTO> list(Object object) {
		ParticipatingOrganizationDTO getParticipatingOrganizationDTO = (ParticipatingOrganizationDTO) object;
		ArrayList<HumanResourceDTO> setHumanResourceDTOList = new ArrayList<>();
		if(con()) {
			try {
				String sql = "select * from humanresource where hr_projet_name = ? and hr_org_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getParticipatingOrganizationDTO.getProjectName());
				pstmt.setString(2, getParticipatingOrganizationDTO.getOrganizationName());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					HumanResourceDTO setHumanResourceDTO = new HumanResourceDTO();
					setHumanResourceDTO.setProjectName(rs.getString("hr_project_name"));
					setHumanResourceDTO.setOrganizationName(rs.getString("hr_org_name"));
					setHumanResourceDTO.setParticipatingWorkforce(rs.getString("hr_name"));
					setHumanResourceDTO.setIdenNumber(rs.getString("hr_idennumber"));
					setHumanResourceDTO.setLevel(rs.getString("hr_level"));
					setHumanResourceDTO.setAge(rs.getInt("hr_age"));
					setHumanResourceDTO.setGraduate(rs.getString("hr_graduate"));
					setHumanResourceDTO.setSalary(rs.getInt("hr_salary"));
					setHumanResourceDTOList.add(setHumanResourceDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setHumanResourceDTOList;
		}
		return null;
	}
	
	@Override
	public Object listOne(Object object) {
		HumanResourceDTO getHumanResourceDTO = (HumanResourceDTO) object;
		if(con()) {
			HumanResourceDTO setHumanResourceDTO = new HumanResourceDTO();
			try {
				String sql = "select * from humanresource where hr_projet_name = ? and hr_org_name = ? and hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getHumanResourceDTO.getProjectName());
				pstmt.setString(2, getHumanResourceDTO.getOrganizationName());
				pstmt.setString(3, getHumanResourceDTO.getIdenNumber());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					setHumanResourceDTO.setProjectName(rs.getString("hr_project_name"));
					setHumanResourceDTO.setOrganizationName(rs.getString("hr_org_name"));
					setHumanResourceDTO.setParticipatingWorkforce(rs.getString("hr_name"));
					setHumanResourceDTO.setIdenNumber(rs.getString("hr_idennumber"));
					setHumanResourceDTO.setLevel(rs.getString("hr_level"));
					setHumanResourceDTO.setAge(rs.getInt("hr_age"));
					setHumanResourceDTO.setGraduate(rs.getString("hr_graduate"));
					setHumanResourceDTO.setSalary(rs.getInt("hr_salary"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setHumanResourceDTO;
		}
		return null;
	};
	
	@Override
	public void update(Object object) {
		HumanResourceDTO setHumanResourceDTO = (HumanResourceDTO) object;
//		listOne(getHumanResourceDTO);
//		HumanResourceDTO setHumanResourceDTO = new HumanResourceDTO();
		if(con()) {
			try {
				String sql = "update humanresource set"
						+ " hr_name = ?,"
						+ " hr_idennumber = ?,"
						+ " hr_level = ?,"
						+ " hr_age = ?,"
						+ " hr_graduate = ?,"
						+ " hr_salary = ?"
						+ " where hr_projet_name = ? and hr_org_name = ? and hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, setHumanResourceDTO.getParticipatingWorkforce());
				pstmt.setString(2, setHumanResourceDTO.getIdenNumber());
				pstmt.setString(3, setHumanResourceDTO.getLevel());
				pstmt.setInt(4, setHumanResourceDTO.getAge());
				pstmt.setString(5, setHumanResourceDTO.getGraduate());
				pstmt.setInt(6, setHumanResourceDTO.getSalary());
				pstmt.setString(7, setHumanResourceDTO.getProjectName());
				pstmt.setString(8, setHumanResourceDTO.getOrganizationName());
				pstmt.setString(9, setHumanResourceDTO.getIdenNumber());
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
		HumanResourceDTO getHumanResourceDTO = (HumanResourceDTO) object;
		if(con()) {
			try {
				String sql = "delete from humanresource where hr_projet_name = ? and hr_org_name = ? and hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getHumanResourceDTO.getProjectName());
				pstmt.setString(2, getHumanResourceDTO.getOrganizationName());
				pstmt.setString(3, getHumanResourceDTO.getIdenNumber());
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
