package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.ParticipatingOrganizationDTO;
import DTO.ProjectDTO;

public class ParticipatingOrganizationDAO extends _DAOSuper{

	@Override
	public void insert(Object object) {
		ParticipatingOrganizationDTO getparticipatingOrganizationDTO = (ParticipatingOrganizationDTO) object;
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into participatingorganization values (?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, getparticipatingOrganizationDTO.getProjectName());
				pstmt.setString(2, getparticipatingOrganizationDTO.getOrganizationName());
				pstmt.setLong(3, getparticipatingOrganizationDTO.getParticipatingOrganizationBudget());
				
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
	public ArrayList<ParticipatingOrganizationDTO> list(Object object) {
		ProjectDTO getProjectDTO = (ProjectDTO) object;
		ArrayList<ParticipatingOrganizationDTO> setParticipatingOrganizationDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from participatingorganization where porg_project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getProjectDTO.getProjectName());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ParticipatingOrganizationDTO setParticipatingOrganizationDTO = new ParticipatingOrganizationDTO();
					setParticipatingOrganizationDTO.setProjectName(rs.getString("porg_project_name"));
					setParticipatingOrganizationDTO.setOrganizationName(rs.getString("porg_org_name"));
					setParticipatingOrganizationDTO.setParticipatingOrganizationBudget(rs.getLong("porg_budget"));
					setParticipatingOrganizationDTOList.add(setParticipatingOrganizationDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setParticipatingOrganizationDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(Object object) {
		ParticipatingOrganizationDTO getParticipatingOrganizationDTO = (ParticipatingOrganizationDTO) object;
		if(con()) {
			ParticipatingOrganizationDTO setParticipatingOrganizationDTO = new ParticipatingOrganizationDTO();
			try {
				String sql = "select * from company where porg_project_name = ? and porg_org_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getParticipatingOrganizationDTO.getProjectName());
				pstmt.setString(2, getParticipatingOrganizationDTO.getOrganizationName());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					setParticipatingOrganizationDTO.setProjectName(rs.getString("porg_project_name"));
					setParticipatingOrganizationDTO.setOrganizationName(rs.getString("porg_org_name"));
					setParticipatingOrganizationDTO.setParticipatingOrganizationBudget(rs.getLong("porg_budget"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setParticipatingOrganizationDTO;
		}
		return null;
	}
	
	@Override
	public void update(Object object) {
		// 수정하려는 DTO 호출
		ParticipatingOrganizationDTO setParticipatingOrganizationDTO = (ParticipatingOrganizationDTO) object;
		// 수정하려는 DTO 조회
//		listOne(getOrganizationDTO);
		// 수정된 값을 입력받을 DTO 생성
		if (con()) {
			try { 
				String sql = "update organization set"
						+ " porg_budget = ?,"
						+ " where porg_project_name = ? and porg_org_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setLong(1, setParticipatingOrganizationDTO.getParticipatingOrganizationBudget());
				pstmt.setString(2, setParticipatingOrganizationDTO.getProjectName());
				pstmt.setString(3, setParticipatingOrganizationDTO.getOrganizationName());
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
		ParticipatingOrganizationDTO getParticipatingOrganizationDTO = (ParticipatingOrganizationDTO) object;
		if(con()) {
			try {
				String sql = "delete from organization where porg_project_name = ? and porg_org_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getParticipatingOrganizationDTO.getProjectName());
				pstmt.setString(2, getParticipatingOrganizationDTO.getOrganizationName());
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
