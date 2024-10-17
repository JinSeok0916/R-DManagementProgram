package DAO.linkedOther;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreateTableDAO extends _DAOSuper {
	public CreateTableDAO() {
		init();
		Scanner in = new Scanner(System.in);
		System.out.println("회사 이름을 입력하시오.");
		create(in.nextLine());
	}
	
	// 입력값은 숫자로 하고 출력 시 문자로 받는것 고민 필요....
	public void create(String companyName) {
		if (con()) {
			PreparedStatement pstmt = null;
			try {
				String sqlCompany = "create table "+companyName+"_company ("
						+ "com_name varchar(30) primary key,"
						+ "com_establishment varchar(10),"
						+ "com_size varchar(8) check(com_size in ('중소기업', '중견기업', '대기업')),"
						+ "com_employee int(5),"
						+ "com_address varchar(40),"
						+ "com_intro varchar(100)"
						+ ")";
				pstmt = con.prepareStatement(sqlCompany);
				pstmt.executeUpdate();
				
				String sqlCost = "create table "+companyName+"_cost ("
						+ "cost_com_name varchar(30)"
						+ "cost_date varchar(10) primary key,"
						+ "cost_material int(12),"
						+ "cost_labor int(12),"
						+ "cost_expense int(12),"
						+ "cost_total int(12)"
						+ "constraint cost_com_name_"+companyName+" foreign key (cost_com_name) references "+companyName+"_company (com_name),"
						+ ")";
				pstmt = con.prepareStatement(sqlCost);
				pstmt.executeUpdate();
				con.commit();
				
				String sqlBudget = "create table "+companyName+"_budget ("
						+ "bdg_com_name varchar(30),"
						+ "bdg_cost_date varchar(8),"
						+ "bdg_budgetallocated int(12),"
						+ "bdg_usingtotalcost int(12),"
						+ "bdg_remainedcost int(12),"
						+ "constraint bdg_com_name_"+companyName+" foreign key (bdg_com_name) references "+companyName+"_company (com_name),"
						+ "constraint bdg_cost_date_"+companyName+" foreign key (bdg_cost_date) references "+companyName+"_cost (cost_date)"
						+ ")";
				pstmt = con.prepareStatement(sqlBudget);
				pstmt.executeUpdate();
				
				String sqlSchedule = "create table "+companyName+"_schedule ("
						+ "sch_com_name varchar(30),"
						+ "sch_totaldate int(4),"
						+ "sch_restdate int(4),"
						+ "sch_totaltask int(3),"
						+ "sch_completetask int(3),"
						+ "sch_requireddateforcompletetask int(4),"
						+ "sch_ratio int(3),"
						+ "constraint sch_com_name_"+companyName+" foreign key (sch_com_name) references "+companyName+"_company (com_name)"
						+ ")";
				pstmt = con.prepareStatement(sqlSchedule);
				pstmt.executeUpdate();
				
				String sqlTask = "create table "+companyName+"_task ("
						+ "task_com_name varchar(30),"
						+ "task_name varchar(20),"
						+ "task_priority varchar(2) check (task_priority in ('상', '중', '하')),"
						+ "task_date int(4),"
						+ "task_progress varchar(6) check (task_progress in ('완료', '미완료')),"
						+ "constraint task_com_name_"+companyName+" foreign key (task_com_name) references "+companyName+"_company (com_name)"
						+ ")";
				pstmt = con.prepareStatement(sqlTask);
				pstmt.executeUpdate();
				
				String sqlHumanResource = "create table "+companyName+"_humanresource ("
						+ "hr_com_name varchar(30),"
						+ "hr_name varchar(8),"
						+ "hr_idennumber varchar(13) unique,"
						+ "hr_level varchar(4) check(hr_level in ('초급', '중급', '고급')),"
						+ "hr_age int(3),"
						+ "hr_graduate varchar(8),"
						+ "hr_salary int(10),"
						+ "constraint hr_com_name_"+companyName+" foreign key (hr_com_name) references "+companyName+"_company (com_name))";
				pstmt = con.prepareStatement(sqlHumanResource);
				pstmt.executeUpdate();
				con.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
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
}
