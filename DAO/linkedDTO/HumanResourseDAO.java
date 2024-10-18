package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.HumanResourceDTO;

public class HumanResourseDAO extends _DAOSuper {
	public HumanResourseDAO() {
		init();
	}
	
	@Override
	public void insert(String projectName, String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into humanresource values (?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				
				System.out.println("참여 인력 이름");
				String hr_name = in.nextLine();
				pstmt.setString(3, hr_name);
				
				System.out.println("참여 인력 사원번호");
				String hr_idennumber = in.nextLine();
				pstmt.setString(4, hr_idennumber);
				
				System.out.println("참여 인력 레벨");
				String hr_level = in.nextLine();
				pstmt.setString(5, hr_level);
				
				System.out.println("참여 인력 나이");
				int hr_age = in.nextInt();
				in.nextLine();
				pstmt.setInt(6, hr_age);
				
				System.out.println("참여 인력 학력");
				String hr_graduate = in.nextLine();
				pstmt.setString(7, hr_graduate);
				
				System.out.println("참여 인력 나이");
				int hr_salary = in.nextInt();
				in.nextLine();
				pstmt.setInt(8, hr_salary);
				
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
	public ArrayList<HumanResourceDTO> list(String projectName, String companyName) {
		ArrayList<HumanResourceDTO> hrDTOList = new ArrayList<>();
		if(con()) {
			try {
				String sql = "select * from humanresource where hr_projet_name = ?, hr_com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					HumanResourceDTO hrDTO = new HumanResourceDTO();
					hrDTO.setProjectName(rs.getString("hr_project_name"));
					hrDTO.setCompanyName(rs.getString("hr_com_name"));
					hrDTO.setParticipatingWorkforce(rs.getString("hr_name"));
					hrDTO.setIdenNumber(rs.getString("hr_idennumber"));
					hrDTO.setLevel(rs.getString("hr_level"));
					hrDTO.setAge(rs.getInt("hr_age"));
					hrDTO.setGraduate(rs.getString("hr_graduate"));
					hrDTO.setSalary(rs.getInt("hr_salary"));
					hrDTOList.add(hrDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return hrDTOList;
		}
		return null;
	}
	
	@Override
	public Object listOne(String projectName, String companyName, String selIdenNum) {
		if(con()) {
			HumanResourceDTO hrDTO = new HumanResourceDTO();
			try {
				String sql = "select * from humanresource where hr_projet_name = ?, hr_com_name = ?, hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				pstmt.setString(3, selIdenNum);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					hrDTO.setProjectName(rs.getString("hr_project_name"));
					hrDTO.setCompanyName(rs.getString("hr_com_name"));
					hrDTO.setParticipatingWorkforce(rs.getString("hr_name"));
					hrDTO.setIdenNumber(rs.getString("hr_idennumber"));
					hrDTO.setLevel(rs.getString("hr_level"));
					hrDTO.setAge(rs.getInt("hr_age"));
					hrDTO.setGraduate(rs.getString("hr_graduate"));
					hrDTO.setSalary(rs.getInt("hr_salary"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return hrDTO;
		}
		return null;
	};
	
	@Override
	public void update(String projectName, String companyName, String selIdenNum) {
		HumanResourceDTO hrDTO = (HumanResourceDTO) listOne(projectName, companyName, selIdenNum);
		if (con()) {
			try {
				String sql = "update humanresource set"
						+ " hr_name = ?,"
						+ " hr_idennumber = ?,"
						+ " hr_level = ?,"
						+ " hr_age = ?,"
						+ " hr_graduate = ?,"
						+ " hr_salary = ?"
						+ " where hr_projet_name = ?, hr_com_name = ?, hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, hrDTO.getParticipatingWorkforce());
				pstmt.setString(2, hrDTO.getIdenNumber());
				pstmt.setString(3, hrDTO.getLevel());
				pstmt.setInt(4, hrDTO.getAge());
				pstmt.setString(5, hrDTO.getGraduate());
				pstmt.setInt(6, hrDTO.getSalary());
				pstmt.setString(7, projectName);
				pstmt.setString(8, companyName);
				pstmt.setString(9, selIdenNum);
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
	public void delete(String projectName, String companyName, String delIdenNum) {
		if(con()) {
			try {
				String sql = "delete from humanresource where hr_projet_name = ?, hr_com_name = ?, hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				pstmt.setString(3, delIdenNum);
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
