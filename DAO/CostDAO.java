package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.CostDTO;


public class CostDAO extends DAOSuper implements _DBDAO{
	public CostDAO() {
		init();
	}
	
	
	@Override
	public void insert(String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into "+companyName+"_cost values (?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
//				System.out.println("4자리 숫자(년월)을 입력해주세요.");
				int cost_date = in.nextInt();
				in.nextLine();
				pstmt.setInt(1, cost_date);
//				System.out.println("원 단위로 입력해주세요.");
				int cost_material = in.nextInt();
				in.nextLine();
				pstmt.setInt(2, cost_material);
//				System.out.println("원 단위로 입력해주세요.");
				int cost_labor = in.nextInt();
				in.nextLine();
				pstmt.setInt(3, cost_labor);
//				System.out.println("원 단위로 입력해주세요.");
				int cost_expense = in.nextInt();
				in.nextLine();
				pstmt.setInt(4, cost_expense);
				int cost_total = cost_material + cost_labor + cost_expense;
				pstmt.setInt(5, cost_total);
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
	public void update(String companyName, int selDate, int cost_material, int cost_labor, int cost_expense) {
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
				pstmt.setInt(5, selDate);
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
	
	// delete문 - 미완
	public void delete(String companyName) {
		if (con()) {
			try {
				String sql = "";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
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
	
	
	// 리스트 보기 - 미완
	public ArrayList<CostDTO> list(String companyName) {
		ArrayList<CostDTO> costDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from "+companyName+"_cost";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					CostDTO costDTO = new CostDTO();
					costDTO.setDate(rs.getInt("cost_date"));
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
	
	public CostDTO listOne(String companyName, int selDate) {
		if(con()) {
			CostDTO costDTO = new CostDTO();
			try {
				String sql = "select * from "+companyName+"_cost where cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, selDate);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					costDTO.setDate(rs.getInt("cost_date"));
					costDTO.setMaterialCost(rs.getInt("cost_material"));
					costDTO.setLaborCost(rs.getInt("cost_labor"));
					costDTO.setExpenseCost(rs.getInt("cost_expense"));
					costDTO.setTotalCost(rs.getInt("cost_total"));
				}
			} catch (Exception e) {
				// TODO: handle exception
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
	
	// 간략 리스트 보기 - 미완
	public int simpleList(String companyName) {
		int avgTotal = 0;
		if (con()) {
			try {
				String sql = "select avg(cost_total) lastmonth_avg from "+companyName+"_cost";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					avgTotal = rs.getInt("lastmonth_avg");
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return avgTotal;
		} return 0;
	}

}
