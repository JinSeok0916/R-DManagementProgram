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
	public void insert(String projectName, String companyName) {
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into cost values (?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				
				System.out.println("날짜를 입력하세요.");
				System.out.println("년도(0000)");
				String cost_year = in.nextLine();
				System.out.println("월(00)");
				String cost_month = in.nextLine();
				pstmt.setString(3, cost_year + "년" + cost_month + "월");
				
				System.out.println("원 단위로 입력해주세요.");
				int cost_material = in.nextInt();
				in.nextLine();
				pstmt.setInt(4, cost_material);
				
				System.out.println("원 단위로 입력해주세요.");
				int cost_labor = in.nextInt();
				in.nextLine();
				pstmt.setInt(5, cost_labor);
				
				System.out.println("원 단위로 입력해주세요.");
				int cost_expense = in.nextInt();
				in.nextLine();
				pstmt.setInt(6, cost_expense);
				
				System.out.println("이번달 총 사용 금액");
				int cost_total = cost_material + cost_labor + cost_expense;
				pstmt.setInt(7, cost_total);
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
	
	@Override
	public void update(String projectName, String companyName, String selDate) {
		CostDTO cDTO = (CostDTO) listOne(projectName, companyName, selDate);
		if (con()) {
			try {
				String sql = "update cost set"
						+ " cost_date = ?,"
						+ " cost_material = ?,"
						+ " cost_labor = ?,"
						+ " cost_expense = ?,"
						+ " cost_total = ?"
						+ " where cost_project_name = ?, cost_com_name = ?, cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cDTO.getDate());
				pstmt.setInt(2, cDTO.getMaterialCost());
				pstmt.setInt(3, cDTO.getLaborCost());
				pstmt.setInt(4, cDTO.getExpenseCost());
				pstmt.setInt(5, cDTO.getMaterialCost() + cDTO.getLaborCost() + cDTO.getExpenseCost());
				pstmt.setString(6, projectName);
				pstmt.setString(7, companyName);
				pstmt.setString(8, selDate);
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
	public void delete(String projectName, String companyName, String delDate) {
		if(con()) {
			try {
				String sql = "delete from cost where cost_project_name = ?, cost_com_name = ?, cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				pstmt.setString(3, delDate);
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
	
	@Override
	public ArrayList<CostDTO> list(String projectName, String companyName) {
		ArrayList<CostDTO> costDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from cost where cost_project_name = ?, cost_com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					CostDTO costDTO = new CostDTO();
					costDTO.setCompanyName(rs.getString("cost_project_company"));
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
	
	@Override
	public Object listOne(String projectName, String companyName, String selDate) {
		if(con()) {
			CostDTO costDTO = new CostDTO();
			try {
				String sql = "select * from cost  where cost_project_name = ?, cost_com_name = ?, cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				pstmt.setString(3, selDate);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					costDTO.setCompanyName(rs.getString("cost_project_company"));
					costDTO.setCompanyName(rs.getString("cost_com_company"));
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

}
