package DAO.linkedDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class _DAOSuper {
	public String userName = "root";
	public String password = "11111111";
	public String url = "jdbc:mariadb://192.168.0.12:3306/rndproject";
	public String driverName = "org.mariadb.jdbc.Driver";
	public Connection con = null;
	
	// 커넥션 가져오는 공통 코드 
	public boolean con() {
		try {
			con = DriverManager.getConnection(url, userName, password);
			if (con != null) {
				System.out.println("커넥션 자원 획득 성공");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public void insert(Object object) {
		
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList list(Object object) {
		return null;
	}
	public Object listOne(Object object) {
		return null;
	}
	public void update(Object object) {
		
	}
	public void delete(Object object) {
		
	}

}
