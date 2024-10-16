package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mariadb.jdbc.internal.com.read.dao.Results;

import DTO.CostDTO;

public class ScheduleDAO extends DAOSuper{
	
	public ScheduleDAO() {
		init();
	}
	
}
