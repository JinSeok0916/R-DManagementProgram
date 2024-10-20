package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.CompanyDTO;

public class CompanyDAO extends _DAOSuper {
	public CompanyDAO() {
		init();
	}

//	@Override
	public void insert(Object object, String p1, String p2) {
		CompanyDTO getCompanyDTO = (CompanyDTO) object;
		if (con()) {
			try {
				String sql = "insert into company values (?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, p1);
				pstmt.setString(2, getCompanyDTO.getCompanyName());
				pstmt.setInt(3, getCompanyDTO.getCompanyBudget());
				pstmt.setString(4, getCompanyDTO.getCompanyEstablishment());
				pstmt.setString(5, getCompanyDTO.getCompanySize());
				pstmt.setInt(6, getCompanyDTO.getTotalEmployee());
				pstmt.setString(7, getCompanyDTO.getCompanyAddress());
				pstmt.setString(8, getCompanyDTO.getCompanyIntro());
				
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
	public ArrayList<CompanyDTO> list(Object object) {
		ArrayList<CompanyDTO> setCompanyDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from company where com_project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setObject(1, object);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					CompanyDTO companyDTO = new CompanyDTO();
					companyDTO.setProjectName(rs.getString("com_project_name"));
					companyDTO.setCompanyName(rs.getString("com_name"));
					companyDTO.setCompanyBudget(rs.getInt("com_budget"));
					companyDTO.setCompanyEstablishment(rs.getString("com_establishment"));
					companyDTO.setCompanySize(rs.getString("com_size"));
					companyDTO.setTotalEmployee(rs.getInt("com_employee"));
					companyDTO.setCompanyAddress(rs.getString("com_address"));
					companyDTO.setCompanyIntro(rs.getString("com_intro"));
					setCompanyDTOList.add(companyDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setCompanyDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(Object object) {
		CompanyDTO getCompanyDTO = (CompanyDTO) object;
		if(con()) {
			CompanyDTO setCompanyDTO = new CompanyDTO();
			try {
				String sql = "select * from company where com_project_name = ?, com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getCompanyDTO.getProjectName());
				pstmt.setString(2, getCompanyDTO.getCompanyName());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					setCompanyDTO.setProjectName(rs.getString("com_project_name"));
					setCompanyDTO.setCompanyName(rs.getString("com_name"));
					setCompanyDTO.setCompanyBudget(rs.getInt("com_budget"));
					setCompanyDTO.setCompanyEstablishment(rs.getString("com_establishment"));
					setCompanyDTO.setCompanySize(rs.getString("com_size"));
					setCompanyDTO.setTotalEmployee(rs.getInt("com_employee"));
					setCompanyDTO.setCompanyAddress(rs.getString("com_address"));
					setCompanyDTO.setCompanyIntro(rs.getString("com_intro"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setCompanyDTO;
		}
		return null;
	}
	
	@Override
	public void update(Object object) {
		// 수정하려는 DTO 호출
		CompanyDTO getCompanyDTO = (CompanyDTO) object;
		// 수정하려는 DTO 조회
		listOne(getCompanyDTO);
		// 수정된 값을 입력받을 DTO 생성
		CompanyDTO setCompanyDTO = new CompanyDTO();
		if (con()) {
			try { 
				String sql = "update company set"
						+ " com_budget = ?,"
						+ " com_establishment = ?,"
						+ " com_size = ?,"
						+ " com_employee = ?,"
						+ " com_address = ?,"
						+ " com_intro = ?"
						+ " where com_project_name = ?, com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, setCompanyDTO.getCompanyBudget());
				pstmt.setString(2, setCompanyDTO.getCompanyEstablishment());
				pstmt.setString(3, setCompanyDTO.getCompanySize());
				pstmt.setInt(4, setCompanyDTO.getTotalEmployee());
				pstmt.setString(5, setCompanyDTO.getCompanyAddress());
				pstmt.setString(6, setCompanyDTO.getCompanyIntro());
				pstmt.setString(7, getCompanyDTO.getProjectName());
				pstmt.setString(8, getCompanyDTO.getCompanyName());
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
		CompanyDTO getCompanyDTO = (CompanyDTO) object;
		if(con()) {
			try {
				String sql = "delete from company where com_project_name = ?, com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getCompanyDTO.getProjectName());
				pstmt.setString(2, getCompanyDTO.getCompanyName());
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
