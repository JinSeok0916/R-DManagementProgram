package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.OrganizationDTO;

public class OrganizationDAO extends _DAOSuper {

	@Override
	public void insert(Object object) {
		OrganizationDTO getOrganizationDTO = (OrganizationDTO) object;
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into company values (?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, getOrganizationDTO.getOrganizationName());
				pstmt.setString(2, getOrganizationDTO.getOrganizationEstablishment());
				pstmt.setString(3, getOrganizationDTO.getOrganizationType());
				pstmt.setInt(4, getOrganizationDTO.getOrganizationTotalEmployee());
				pstmt.setString(5, getOrganizationDTO.getOrganizationAddress());
				pstmt.setString(6, getOrganizationDTO.getOrganizationIntro());
				
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
	public ArrayList<OrganizationDTO> list(Object object) {
		ArrayList<OrganizationDTO> setOrganizationDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from organization";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					OrganizationDTO setOrganizationDTO = new OrganizationDTO();
					setOrganizationDTO.setOrganizationName(rs.getString("org_name"));
					setOrganizationDTO.setOrganizationEstablishment(rs.getString("org_establishment"));
					setOrganizationDTO.setOrganizationType(rs.getString("org_type"));
					setOrganizationDTO.setOrganizationTotalEmployee(rs.getInt("org_employee"));
					setOrganizationDTO.setOrganizationAddress(rs.getString("org_address"));
					setOrganizationDTO.setOrganizationIntro(rs.getString("org_intro"));
					setOrganizationDTOList.add(setOrganizationDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setOrganizationDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(Object object) {
		OrganizationDTO getOrganizationDTO = (OrganizationDTO) object;
		if(con()) {
			OrganizationDTO setOrganizationDTO = new OrganizationDTO();
			try {
				String sql = "select * from company where org_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getOrganizationDTO.getOrganizationName());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					setOrganizationDTO.setOrganizationName(rs.getString("org_name"));
					setOrganizationDTO.setOrganizationEstablishment(rs.getString("org_establishment"));
					setOrganizationDTO.setOrganizationType(rs.getString("org_type"));
					setOrganizationDTO.setOrganizationTotalEmployee(rs.getInt("org_employee"));
					setOrganizationDTO.setOrganizationAddress(rs.getString("org_address"));
					setOrganizationDTO.setOrganizationIntro(rs.getString("org_intro"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setOrganizationDTO;
		}
		return null;
	}
	
	@Override
	public void update(Object object) {
		// 수정하려는 DTO 호출
		OrganizationDTO setOrganizationDTO = (OrganizationDTO) object;
		// 수정하려는 DTO 조회
//		listOne(getOrganizationDTO);
		// 수정된 값을 입력받을 DTO 생성
		if (con()) {
			try { 
				String sql = "update organization set"
						+ " org_name = ?,"
						+ " org_establishment = ?,"
						+ " org_type = ?,"
						+ " org_employee = ?,"
						+ " org_address = ?,"
						+ " org_intro = ?"
						+ " where org_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, setOrganizationDTO.getOrganizationName());
				pstmt.setString(2, setOrganizationDTO.getOrganizationEstablishment());
				pstmt.setString(3, setOrganizationDTO.getOrganizationType());
				pstmt.setInt(4, setOrganizationDTO.getOrganizationTotalEmployee());
				pstmt.setString(5, setOrganizationDTO.getOrganizationAddress());
				pstmt.setString(6, setOrganizationDTO.getOrganizationIntro());
				pstmt.setString(7, setOrganizationDTO.getOrganizationName());
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
		OrganizationDTO getOrganizationDTO = (OrganizationDTO) object;
		if(con()) {
			try {
				String sql = "delete from organization where org_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getOrganizationDTO.getOrganizationName());
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
