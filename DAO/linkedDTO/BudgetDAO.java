//package DAO.linkedDTO;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import DTO.BudgetDTO;
//
//public class BudgetDAO extends _DAOSuper {
//	public BudgetDAO() {
//		init();
//	}
//	
//	@Override
//	public void insert(String projectName, String companyName) {
//		Scanner in = new Scanner(System.in);
//		if (con()) {
//			try {
//				String sql = "insert into budget values (?,?,?,?,?)";
//				
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, projectName);
//				pstmt.setString(2, companyName);
//				
//				System.out.println("날짜를 입력하세요.");
//				System.out.println("년도(0000)");
//				String bg_year = in.nextLine();
//				System.out.println("월(00)");
//				String bg_month = in.nextLine();
//				pstmt.setString(3, bg_year + "년" + bg_month + "월");
//				
//				String sql_rf = "select sum(cost_total) totalcost  from cost";
//				PreparedStatement pstmt_rf = con.prepareStatement(sql_rf);
//				ResultSet rs = pstmt_rf.executeQuery();
//				int bg_using = 0;
//				if(rs.next()) {
//					bg_using = rs.getInt("totalcost");
//					pstmt.setInt(4, bg_using);
//					System.out.println("총 사용 금액");
//					System.out.println(bg_using);
//				}
//				
//				String sql_rf1 = "select com_budget from company where com_project_name = ?, com_name = ?";
//				PreparedStatement pstmt_rf1 = con.prepareStatement(sql_rf1);
//				ResultSet rs1 = pstmt_rf1.executeQuery();
//				int bg_total = 0;
//				if(rs1.next()) {
//					bg_total = rs1.getInt("com_budget");
//					pstmt.setInt(5, bg_total - bg_using);
//					System.out.println("예산 잔액");
//					System.out.println(bg_using);
//				}
//				
//				pstmt.executeUpdate();
//				con.commit();
//			} catch (Exception e) {
//			} finally {
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e2) {
//					}
//				}
//			}
//		}
//	}
//
//	@Override
//	public ArrayList<BudgetDTO> list(String projectName, String companyName) {
//		ArrayList<BudgetDTO> bgDTOList = new ArrayList<>();
//		if(con()) {
//			try {
//				String sql = "select * from budget where bdg_project_name = ?, bdg_com_name = ?";
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, projectName);
//				pstmt.setString(2, companyName);
//				ResultSet rs = pstmt.executeQuery();
//				while(rs.next()) {
//					BudgetDTO bgDTO = new BudgetDTO();
//					bgDTO.setProjectName(rs.getString("bdg_project_name"));
//					bgDTO.setCompanyName(rs.getString("bdg_com_name"));
//					bgDTO.setDate(rs.getString("bdg_cost_date"));
//					bgDTO.setUsingTotalCost(rs.getInt("bdg_usingtotalcost"));
//					bgDTO.setRemainedCost(rs.getInt("bdg_remainedcost"));
//					bgDTOList.add(bgDTO);
//				} 
//			} catch (Exception e) {
//			} finally {
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e2) {
//					}
//				}
//			} return bgDTOList;
//		}
//		return null;
//	}
//	
//	@Override
//	public Object listOne(String projectName, String companyName, String selDate) {
//		if(con()) {
//			BudgetDTO bgDTO = new BudgetDTO();
//			try {
//				String sql = "select * from budget where bdg_project_name = ?, bdg_com_name = ?, bdg_cost_date = ?";
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, projectName);
//				pstmt.setString(2, companyName);
//				pstmt.setString(3, selDate);
//				ResultSet rs = pstmt.executeQuery();
//				if(rs.next()) {
//					bgDTO.setProjectName(rs.getString("bdg_project_name"));
//					bgDTO.setCompanyName(rs.getString("bdg_com_name"));
//					bgDTO.setDate(rs.getString("bdg_cost_date"));
//					bgDTO.setUsingTotalCost(rs.getInt("bdg_usingtotalcost"));
//					bgDTO.setRemainedCost(rs.getInt("bdg_remainedcost"));
//				}
//			} catch (Exception e) {
//			} finally {
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e2) {
//					}
//				}
//			} return bgDTO;
//		}
//		return null;
//	}
//
//	@Override
//	// cost 수정 시 같이 수행될 필요가 있음
//	public void update(String companyName, String selDate) {
//		if (con()) {
//			try {
//				String sql = "update budget set"
//						+ " bdg_usingtotalcost = ?,"
//						+ " bdg_remainedcost = ?"
//						+ " where bdg_cost_date = ?";
//				
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setInt(1, budgetAllocated);
//				
//				String sql_rf = "select sum(cost_total) totalcost  from "+companyName+"_cost";
//				PreparedStatement pstmt_rf = con.prepareStatement(sql_rf);
//				ResultSet rs = pstmt_rf.executeQuery();
//				int bg_using = 0;
//				if(rs.next()) {
//					bg_using = rs.getInt("totalcost");
//					pstmt.setInt(2, bg_using);
//					System.out.println(bg_using);
//				}
//				
//				pstmt.setInt(3, budgetAllocated - bg_using);
//				pstmt.setString(4, selDate);
//				
//				pstmt.executeUpdate();
//				con.commit();
//			} catch (Exception e) {
//			} finally {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
//	public void delete(String companyName, String delDate) {
//		if(con()) {
//			try {
//				String sql = "delete from "+companyName+"_budget where bdg_cost_date = ?";
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, delDate);
//				pstmt.executeUpdate();
//				con.commit();
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if(con != null) {
//						con.close();
//					}
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		}
//	}
//
//}
