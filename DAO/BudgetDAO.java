package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BudgetDAO extends DAOSuper {
	public BudgetDAO() {
		init();
	}

	@Override
	public void insert(String companyName) {
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
				int bg_allocated = in.nextInt();
				in.nextLine();
				pstmt.setInt(3, bg_allocated);
				
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
				int bg_remained = bg_allocated - bg_using;
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
	public ArrayList list(String companyName) {
		return null;
	}

	@Override
	public Object listOne(String companyName, int selDate) {
		return null;
	}

	@Override
	public void simpleList(String companyName) {
	}

	public void update(String companyName, String selDate, int bdg_budgetallocated) {
		if (con()) {
			try {
				String sql = "update "+companyName+"_budget set"
						+ " bdg_budgetallocated = ?,"
						+ " bdg_usingtotalcost = ?,"
						+ " bdg_remainedcost = ?,"
						+ " where bdg_cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bdg_budgetallocated);
				
				String sql_rf = "select sum(cost_total) totalcost  from "+companyName+"_cost";
				PreparedStatement pstmt_rf = con.prepareStatement(sql_rf);
				ResultSet rs = pstmt_rf.executeQuery();
				int bg_using = 0;
				if(rs.next()) {
					bg_using = rs.getInt("totalcost");
					pstmt.setInt(2, bg_using);
					System.out.println(bg_using);
				}
				
				pstmt.setInt(3, bdg_budgetallocated - bg_using);
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
	@Override
	public void delete(String companyName) {
		// TODO Auto-generated method stub
		super.delete(companyName);
	}

}
