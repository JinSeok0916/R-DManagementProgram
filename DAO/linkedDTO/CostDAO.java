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
	public void insert(Object object, String p1, String p2) {
		CostDTO getCostDTO = (CostDTO) object;
		Scanner in = new Scanner(System.in);
		if (con()) {
			try {
				String sql = "insert into cost values (?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, getCostDTO.getProjectName());
				pstmt.setString(2, getCostDTO.getCompanyName());
				pstmt.setString(3, getCostDTO.getDate());
				pstmt.setInt(4, getCostDTO.getMaterialCost());
				pstmt.setInt(5, getCostDTO.getLaborCost());
				pstmt.setInt(6, getCostDTO.getExpenseCost());
				pstmt.setInt(7, getCostDTO.getTotalCost());
				
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
		if (in != null) {
			try {
				in.close();
			} catch (Exception e2) {
			}
		}
	}
	
	@Override
	public void update(Object object) {
		CostDTO getCostDTO = (CostDTO) object;
		listOne(getCostDTO);
		CostDTO setCostDTO = new CostDTO();
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
				pstmt.setString(1, setCostDTO.getDate());
				pstmt.setInt(2, setCostDTO.getMaterialCost());
				pstmt.setInt(3, setCostDTO.getLaborCost());
				pstmt.setInt(4, setCostDTO.getExpenseCost());
				pstmt.setInt(5, setCostDTO.getTotalCost());
				pstmt.setString(6, getCostDTO.getProjectName());
				pstmt.setString(7, getCostDTO.getCompanyName());
				pstmt.setString(8, getCostDTO.getDate());
				
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
		CostDTO getCostDTO = (CostDTO) object;
		if(con()) {
			try {
				String sql = "delete from cost where cost_project_name = ?, cost_com_name = ?, cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getCostDTO.getProjectName());
				pstmt.setString(2, getCostDTO.getCompanyName());
				pstmt.setString(3, getCostDTO.getDate());
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
	public ArrayList<CostDTO> list(Object object) {
		CostDTO getCostDTO = (CostDTO) object;
		ArrayList<CostDTO> setCostDTOList = new ArrayList<>();
		if (con()) {
			try {
				String sql = "select * from cost where cost_project_name = ?, cost_com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getCostDTO.getProjectName());
				pstmt.setString(2, getCostDTO.getCompanyName());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					CostDTO setCostDTO = new CostDTO();
					setCostDTO.setCompanyName(rs.getString("cost_project_company"));
					setCostDTO.setCompanyName(rs.getString("cost_com_company"));
					setCostDTO.setDate(rs.getString("cost_date"));
					setCostDTO.setMaterialCost(rs.getInt("cost_material"));
					setCostDTO.setLaborCost(rs.getInt("cost_labor"));
					setCostDTO.setExpenseCost(rs.getInt("cost_expense"));
					setCostDTO.setTotalCost(rs.getInt("cost_total"));
					setCostDTOList.add(setCostDTO);
				} 
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setCostDTOList;
		}
		return null;
	}
	
	@Override
	public Object listOne(Object object) {
		CostDTO getCostDTO = (CostDTO) object;
		if(con()) {
			CostDTO setCostDTO = new CostDTO();
			try {
				String sql = "select * from cost  where cost_project_name = ?, cost_com_name = ?, cost_date = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, getCostDTO.getProjectName());
				pstmt.setString(2, getCostDTO.getCompanyName());
				pstmt.setString(3, getCostDTO.getDate());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					setCostDTO.setCompanyName(rs.getString("cost_project_company"));
					setCostDTO.setCompanyName(rs.getString("cost_com_company"));
					setCostDTO.setDate(rs.getString("cost_date"));
					setCostDTO.setMaterialCost(rs.getInt("cost_material"));
					setCostDTO.setLaborCost(rs.getInt("cost_labor"));
					setCostDTO.setExpenseCost(rs.getInt("cost_expense"));
					setCostDTO.setTotalCost(rs.getInt("cost_total"));
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			} return setCostDTO;
		}
		return null;
	}

}
