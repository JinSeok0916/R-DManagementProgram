package DAO.linkedDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

public class _DAOSuper {
	public String userName = "root";
	public String password = "11111111";
	public String url = "jdbc:mariadb://192.168.0.12:3306/rndproject";
	public String driverName = "org.mariadb.jdbc.Driver";
	public Connection con = null;
	
	// 드라이버 로드 코드
	public void init() {
		try {
			Class.forName(driverName);
			System.out.println("마리아 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
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
	public void insert(String projectName, String companyName) {
		
	}
	public ArrayList list(String projectName, String companyName) {
		return null;
	}
	public Object listOne(String projectName, String companyName, String publicVar) {
		return null;
	}
	public void update(String projectName, String companyName, String publicvar) {
		
	}
	public void delete(String projectName, String companyName, String publicVar) {
		
	}
}
