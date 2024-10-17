package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.CostDTO;

public class CostDAO extends _DAOSuper {
	public CostDAO() {
		init();
	}
	
	
	@Override
	public void insert(String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into "+companyName+"_cost values (?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, companyName);
				
				System.out.println("4자리 숫자(년월)을 입력해주세요.");
				String cost_date = in.nextLine();
				pstmt.setString(2, cost_date);
				
				System.out.println("원 단위로 입력해주세요.");
				int cost_material = in.nextInt();
				in.nextLine();
				pstmt.setInt(3, cost_material);
				
				System.out.println("원 단위로 입력해주세요.");
				int cost_labor = in.nextInt();
				in.nextLine();
				pstmt.setInt(4, cost_labor);
				
				System.out.println("원 단위로 입력해주세요.");
				int cost_expense = in.nextInt();
				in.nextLine();
				pstmt.setInt(5, cost_expense);
				
				System.out.println("이번달 총 사용 금액");
				int cost_total = cost_material + cost_labor + cost_expense;
				pstmt.setInt(6, cost_total);
				System.out.println(cost_total);
				
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
	
	public void update(String companyName, String selDate, int cost_material, int cost_labor, int cost_expense) {
		if (con()) {
			try {
				String sql = "update "+companyName+"_cost set"
						+ " cost_material = ?,"
						+ " cost_labor = ?,"
						+ " cost_expense = ?,"
						+ " cost_total = ?"
						+ " where cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cost_material);
				pstmt.setInt(2, cost_labor);
				pstmt.setInt(3, cost_expense);
				pstmt.setInt(4, cost_material + cost_labor + cost_expense);
				pstmt.setString(5, selDate);
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
	
	public void delete(String companyName, String delDate) {
		if(con()) {
			try {
				String sql = "delete from "+companyName+"_cost where cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, delDate);
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
	
	public ArrayList<CostDTO> list(String companyName) {
		ArrayList<CostDTO> costDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from "+companyName+"_cost";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					CostDTO costDTO = new CostDTO();
					costDTO.setCompanyName(rs.getString("cost_com_company"));
					costDTO.setDate(rs.getString("cost_date"));
					costDTO.setMaterialCost(rs.getInt("cost_material"));
					costDTO.setLaborCost(rs.getInt("cost_labor"));
					costDTO.setExpenseCost(rs.getInt("cost_expense"));
					costDTO.setTotalCost(rs.getInt("cost_total"));
					costDTOList.add(costDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return costDTOList;
		}
		return null;
	}
	
	public Object listOne(String companyName, String selDate) {
		if(con()) {
			CostDTO costDTO = new CostDTO();
			try {
				String sql = "select * from "+companyName+"_cost where cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, selDate);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					costDTO.setCompanyName(rs.getString("cost_com_name"));
					costDTO.setDate(rs.getString("cost_date"));
					costDTO.setMaterialCost(rs.getInt("cost_material"));
					costDTO.setLaborCost(rs.getInt("cost_labor"));
					costDTO.setExpenseCost(rs.getInt("cost_expense"));
					costDTO.setTotalCost(rs.getInt("cost_total"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return costDTO;
		}
		return null;
	}
	
//	public void simpleList(String companyName) {
//		int avgTotal = 0;
//		if (con()) {
//			try {
//				String sql = "select avg(cost_total) lastmonth_avg from "+companyName+"_cost";
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//				if(rs.next()) {
//					avgTotal = rs.getInt("lastmonth_avg");
//				}
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

}
