package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mariadb.jdbc.internal.com.read.dao.Results;

import DTO.CostDTO;


public class ScheduleDAO extends DAOSuper implements _DBDAO{
	private String userName = "root";
	private String password = "11111111";
	private String url = "jdbc:mariadb://localhost:3306/r&dmanagementprogram";
	private String driverName = "org.mariadb.jdbc.Driver";
	private Connection con = null;
	
	public ScheduleDAO() {
		init();
	}
	
	// 테이블 생성 - 미완
	public void create() {
		if (con()) {
			try {
				String sql = "create table ?(?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(0, sql);
				ps.setString(0, sql);
				ps.setString(0, sql);
				ps.setString(0, sql);
				ps.executeUpdate();
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// insert문 - 미완
	public void insert() {
		if (con()) {
			try {
				String sql = "in";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeUpdate();
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
	
	// update문 - 미완
	public void update() {
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
	
	// delete문 - 미완
	public void delete() {
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
	public void list() {
		
	}
	
	// 간략 리스트 보기 - 미완
	public void simpleList() {
		if (con()) {
			try {
				String sql = "";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeUpdate();
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
	public void insert(String companyName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CostDTO> list(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CostDTO listOne(String companyName, int selDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int simpleList(String companyName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(String companyName, int selDate, int cost_material, int cost_labor, int cost_expense) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String companyName) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
