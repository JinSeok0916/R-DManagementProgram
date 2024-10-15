package DAO;

import java.sql.Connection;

public class DAOSuper {
	public String userName = "root";
	public String password = "11111111";
	public String url = "jdbc:mariadb://localhost:3306/r&dmanagementprogram";
	public String driverName = "org.mariadb.jdbc.Driver";
	public Connection con = null;
}
