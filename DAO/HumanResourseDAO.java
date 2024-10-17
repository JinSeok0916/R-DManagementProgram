package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.HumanResourceDTO;

public class HumanResourseDAO extends DAOSuper {
	public HumanResourseDAO() {
		init();
	}
	public void insert(String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into "+companyName+"_humanresource values (?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, companyName);
				
				System.out.println("참여 인력 사원번호");
				String hr_idennumber = in.nextLine();
				pstmt.setString(2, hr_idennumber);
				
				System.out.println("참여 인력 이름");
				String hr_name = in.nextLine();
				pstmt.setString(3, hr_name);
				
				System.out.println("참여 인력 레벨");
				String hr_level = in.nextLine();
				pstmt.setString(4, hr_level);
				
				System.out.println("참여 인력 나이");
				int hr_age = in.nextInt();
				in.nextLine();
				pstmt.setInt(5, hr_age);
				
				System.out.println("참여 인력 학력");
				String hr_graduate = in.nextLine();
				pstmt.setString(6, hr_graduate);
				
				System.out.println("참여 인력 나이");
				int hr_salary = in.nextInt();
				in.nextLine();
				pstmt.setInt(7, hr_salary);
				
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
	public ArrayList list(String companyName) {
		ArrayList<HumanResourceDTO> hrDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from "+companyName+"_humanresource";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					HumanResourceDTO hrDTO = new HumanResourceDTO();
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
	};
	public Object listOne(String companyName, int selIdenNum) {
		if(con()) {
			HumanResourceDTO hrDTO = new HumanResourceDTO();
			try {
				String sql = "select * from "+companyName+"_humanresource where hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, selIdenNum);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
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
	public void simpleList(String companyName) {
		int totalParticipants = 0;
		if (con()) {
			try {
				String sql = "select count(*) total_participants from "+companyName+"_humanresource";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					totalParticipants = rs.getInt("total_participants");
				}
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
	};
	public void update(String companyName, String hr_name, String hr_level, int hr_age, String hr_graduate, int hr_salary, String hr_idennumber) {
		if (con()) {
			try {
				String sql = "update "+companyName+"_humanresource set"
						+ " hr_name = ?,"
						+ " hr_level = ?,"
						+ " hr_age = ?,"
						+ " hr_graduate = ?"
						+ " hr_salary = ?"
						+ " where hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, hr_name);
				pstmt.setString(2, hr_level);
				pstmt.setInt(3, hr_age);
				pstmt.setString(4, hr_graduate);
				pstmt.setInt(5, hr_salary);
				pstmt.setString(6, hr_idennumber);
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
	};
	public void delete(String companyName, String delIdenNum) {
		if(con()) {
			try {
				String sql = "delete from "+companyName+"_humanresource where hr_idennumber = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, delIdenNum);
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
