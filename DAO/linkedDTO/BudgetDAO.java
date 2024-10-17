package DAO.linkedDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.BudgetDTO;

public class BudgetDAO extends _DAOSuper {
	public BudgetDAO() {
		init();
	}

	public void insert(String companyName, int budgetAllocated) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into "+companyName+"_budget values (?,?,?,?,?)";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, companyName);
				System.out.println("입력 년월(00년00월)");
				String bg_date = in.nextLine();
				pstmt.setString(2, bg_date);
				
				System.out.println("할당 예산액");
				pstmt.setInt(3, budgetAllocated);
				
				System.out.println("총 사용 금액");
				String sql_rf = "select sum(cost_total) totalcost  from "+companyName+"_cost";
				PreparedStatement pstmt_rf = con.prepareStatement(sql_rf);
				ResultSet rs = pstmt_rf.executeQuery();
				int bg_using = 0;
				if(rs.next()) {
					bg_using = rs.getInt("totalcost");
					pstmt.setInt(4, bg_using);
					System.out.println(bg_using);
				}
				
				System.out.println("예산 잔액");
				int bg_remained = budgetAllocated - bg_using;
				pstmt.setInt(5, bg_remained);
				
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
	public ArrayList<BudgetDTO> list(String companyName) {
		ArrayList<BudgetDTO> bgDTOList = new ArrayList<>();
		if(con()) {
			try {
				String sql = "select * from "+companyName+"_budget";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					BudgetDTO bgDTO = new BudgetDTO();
					bgDTO.setCompanyName(rs.getString("bdg_com_name"));
					bgDTO.setDate(rs.getString("bdg_cost_date"));
					bgDTO.setBudgetAllocated(rs.getInt("bdg_budgetallocated"));
					bgDTO.setUsingTotalCost(rs.getInt("bdg_usingtotalcost"));
					bgDTO.setRemainedCost(rs.getInt("bdg_remainedcost"));
					bgDTOList.add(bgDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return bgDTOList;
		}
		return null;
	}

	public Object listOne(String companyName, String selDate) {
		if(con()) {
			BudgetDTO bgDTO = new BudgetDTO();
			try {
				String sql = "select * from "+companyName+"_budget where bdg_cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, selDate);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					bgDTO.setCompanyName(rs.getString("bdg_com_name"));
					bgDTO.setDate(rs.getString("bdg_cost_date"));
					bgDTO.setBudgetAllocated(rs.getInt("bdg_budgetallocated"));
					bgDTO.setUsingTotalCost(rs.getInt("bdg_usingtotalcost"));
					bgDTO.setRemainedCost(rs.getInt("bdg_remainedcost"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return bgDTO;
		}
		return null;
	}



	public void update(String companyName, String selDate, int budgetAllocated) {
		if (con()) {
			try {
				String sql = "update "+companyName+"_budget set"
						+ " bdg_budgetallocated = ?,"
						+ " bdg_usingtotalcost = ?,"
						+ " bdg_remainedcost = ?,"
						+ " where bdg_cost_date = ?";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, budgetAllocated);
				
				String sql_rf = "select sum(cost_total) totalcost  from "+companyName+"_cost";
				PreparedStatement pstmt_rf = con.prepareStatement(sql_rf);
				ResultSet rs = pstmt_rf.executeQuery();
				int bg_using = 0;
				if(rs.next()) {
					bg_using = rs.getInt("totalcost");
					pstmt.setInt(2, bg_using);
					System.out.println(bg_using);
				}
				
				pstmt.setInt(3, budgetAllocated - bg_using);
				pstmt.setString(4, selDate);
				
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
				String sql = "delete from "+companyName+"_budget where bdg_cost_date = ?";
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

}
