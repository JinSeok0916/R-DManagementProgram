package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mariadb.jdbc.internal.com.read.dao.Results;


public class HumanResourseDAO extends DAOSuper implements _DBDAO{
	public HumanResourseDAO() {
		init();
	}
	
	// insert문 - 미완
	public void insert() {
		if (con()) {
			try {
				String sql = "insert into ? values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, "1");
				ps.setString(2, "1");
				ps.setString(3, "1");
				ps.setString(4, "1");
				ps.setString(5, "1");
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
	
	// 검색하기 - 미완
	@Override
	public void searchNum(int Num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchName(String Name) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
