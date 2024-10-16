package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CompanyDAO extends DAOSuper{
	Scanner in = new Scanner(System.in);
	private String companyName = in.nextLine();
	public CompanyDAO() {
		init();
	}
	
	// 드라이버 로드 코드
	private void init() {
		try {
			Class.forName(driverName);
			System.out.println("마리아 드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션 가져오는 공통 코드
	private boolean con() {
		try {
			con = DriverManager.getConnection(url, userName, password);
			if (con != null) {
				System.out.println("커넥션 자원 획득 성공");
			} else
			return true;	// 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 테이블 생성 - 미완
	public void create() {
		if (con()) {
			try {
				String sql = 
						"create table company_? ("
						+ "com_name varchar(30) primary key,"
						+ "com_size varchar(8) check(com_size in ('중소기업', '중견기업', '대기업')),"
						+ "com_employee int(5),"
						+ "com_location varchar(40)"
						+ ");"
						+ "create table cost_? ("
						+ "cost_date varchar(8) primary key,"
						+ "cost_material int(12),"
						+ "cost_labor int(12),"
						+ "cost_expense int(12),"
						+ "cost_total int(12)"
						+ ");"
						+ "create table budget_? ("
						+ "bdg_com_name varchar(30),"
						+ "bdg_cost_date varchar(8),"
						+ "bdg_budgetallocated int(12),"
						+ "bdg_usingtotalcost int(12),"
						+ "bdg_remainedcost int(12),"
						+ "constraint bdg_com_name_? foreign key (bdg_com_name_?) references company_? (com_name),"
						+ "constraint bdg_cost_date_? foreign key (bdg_cost_date_?) references cost_? (cost_date)"
						+ ");"
						+ "create table schedule_? ("
						+ "sch_com_name varchar(30),"
						+ "sch_totaldate int(4),"
						+ "sch_restdate int(4),"
						+ "sch_totaltask int(3),"
						+ "sch_completetask int(3),"
						+ "sch_requireddateforcompletetask int(4),"
						+ "sch_ratio int(3),"
						+ "constraint sch_com_name_? foreign key (sch_com_name_?) references company_? (com_name)"
						+ ");"
						+ "create table task_? ("
						+ "task_com_name varchar(30),"
						+ "task_name varchar(20),"
						+ "task_priority varchar(2) check (task_priority in ('상', '중', '하')),"
						+ "task_date int(4),"
						+ "task_progress varchar(6) check (task_progress in ('완료', '미완료')),"
						+ "constraint task_com_name_? foreign key (task_com_name_?) references company_? (com_name)"
						+ ");"
						+ "create table humanresource_? ("
						+ "hr_com_name varchar(30),"
						+ "hr_name varchar(8),"
						+ "hr_level varchar(4) check(hr_level in ('초급', '중급', '고급')),"
						+ "hr_age int(3),"
						+ "hr_graduate varchar(8),"
						+ "hr_salary int(10),"
						+ "constraint hr_com_name_? foreign key (hr_com_name_?) references company_? (com_name))";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, companyName);
				ps.setString(2, companyName);
				ps.setString(3, companyName);
				ps.setString(4, companyName);
				ps.setString(5, companyName);
				ps.setString(6, companyName);
				ps.setString(7, companyName);
				ps.setString(8, companyName);
				ps.setString(9, companyName);
				ps.setString(10, companyName);
				ps.setString(11, companyName);
				ps.setString(12, companyName);
				ps.setString(13, companyName);
				ps.setString(14, companyName);
				ps.setString(15, companyName);
				ps.setString(16, companyName);
				ps.setString(17, companyName);
				ps.setString(18, companyName);
				ps.setString(19, companyName);
				ps.setString(20, companyName);
				ps.setString(21, companyName);
				ps.executeUpdate();
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
