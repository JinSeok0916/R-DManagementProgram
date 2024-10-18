package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.CompanyDTO;
import DTO.CostDTO;

public class CompanyDAO extends _DAOSuper{
	public CompanyDAO() {
		init();
	}

	@Override
	public void insert(String projectName, String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into company values (?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				
				System.out.println("프로젝트 할당 예산을 입력하시오.");
				int com_budget = in.nextInt();
				in.nextLine();
				pstmt.setInt(3, com_budget);
				
				System.out.println("회사 설립 년도를 작성하시오.(0000년)");
				String com_establishment = in.nextLine();
				pstmt.setString(4, com_establishment);
				
				System.out.println("회사 규모를 입력해주세요.('중소기업', '중견기업', '대기업')");
				String com_size = in.nextLine();
				pstmt.setString(5, com_size);
				
				System.out.println("회사 총 사원 수를 입력하시오.");
				int com_employee = in.nextInt();
				in.nextLine();
				pstmt.setInt(6, com_employee);
				
				System.out.println("회사 주소를 입력하시오.");
				String com_address = in.nextLine();
				pstmt.setString(7, com_address);
				
				System.out.println("회사 소개를 간략히 입력하시오.(50자 이내)");
				String com_intro = in.nextLine();
				pstmt.setString(8, com_intro);
				
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
	public ArrayList<CompanyDTO> list(String projectName, String companyName) {
		ArrayList<CompanyDTO> companyDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from company where com_project_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
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
					companyDTOList.add(companyDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return companyDTOList;
		}
		return null;
	}

	@Override
	public Object listOne(String projectName, String companyName, String publicvar) {
		if(con()) {
			CompanyDTO companyDTO = new CompanyDTO();
			try {
				String sql = "select * from company where com_project_name = ?, com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					companyDTO.setProjectName(rs.getString("com_project_name"));
					companyDTO.setCompanyName(rs.getString("com_name"));
					companyDTO.setCompanyBudget(rs.getInt("com_budget"));
					companyDTO.setCompanyEstablishment(rs.getString("com_establishment"));
					companyDTO.setCompanySize(rs.getString("com_size"));
					companyDTO.setTotalEmployee(rs.getInt("com_employee"));
					companyDTO.setCompanyAddress(rs.getString("com_address"));
					companyDTO.setCompanyIntro(rs.getString("com_intro"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return companyDTO;
		}
		return null;
	}
	
	@Override
	public void update(String projectName, String companyName, String publicvar) {
		CompanyDTO cDTO = (CompanyDTO) listOne(projectName, companyName, null);
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
				pstmt.setInt(1, cDTO.getCompanyBudget());
				pstmt.setString(2, cDTO.getCompanyEstablishment());
				pstmt.setString(3, cDTO.getCompanySize());
				pstmt.setInt(4, cDTO.getTotalEmployee());
				pstmt.setString(5, cDTO.getCompanyAddress());
				pstmt.setString(6, cDTO.getCompanyIntro());
				pstmt.setString(7, cDTO.getProjectName());
				pstmt.setString(8, cDTO.getCompanyName());
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
	public void delete(String projectName, String companyName, String publicVar) {
		if(con()) {
			try {
				String sql = "delete from company where com_project_name = ?, com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
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
