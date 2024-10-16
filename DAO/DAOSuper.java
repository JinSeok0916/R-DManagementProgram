package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOSuper {
	public String userName = "root";
	public String password = "11111111";
	public String url = "jdbc:mariadb://localhost:3306/rndproject";
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
}
