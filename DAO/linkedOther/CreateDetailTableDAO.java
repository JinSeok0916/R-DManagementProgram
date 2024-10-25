package DAO.linkedOther;

import java.sql.PreparedStatement;

public class CreateDetailTableDAO extends _DAOSuper {
	public CreateDetailTableDAO() {
		create();
	}
	
	// 입력값은 숫자로 하고 출력 시 문자로 받는것 고민 필요....
	@Override
	public void create() {
		if (con()) {
			PreparedStatement pstmt = null;
			try {
				String sqlParticipatingOrganization = "create table if not exists participatingorganization ("
						+ "porg_project_name varchar(30),"
						+ "porg_org_name varchar(30),"
						+ "porg_budget bigint(12),"
						+ "constraint porg_project_name foreign key (porg_project_name) references project (project_name),"
						+ "constraint porg_org_name foreign key (porg_org_name) references organization (org_name)"
						+ ")";
				pstmt = con.prepareStatement(sqlParticipatingOrganization);
				pstmt.executeUpdate();
				
				String sqlCost = "create table if not exists cost ("
						+ "cost_project_name varchar(30),"
						+ "cost_org_name varchar(30),"
						+ "cost_date varchar(10) primary key,"
						+ "cost_material bigint(12),"
						+ "cost_labor bigint(12),"
						+ "cost_expense bigint(12),"
						+ "cost_total bigint(12),"
						+ "constraint cost_project_name foreign key (cost_project_name) references project (project_name),"
						+ "constraint cost_org_name foreign key (cost_org_name) references organization (org_name)"
						+ ")";
				pstmt = con.prepareStatement(sqlCost);
				pstmt.executeUpdate();
				con.commit();
				
				String sqlSchedule = "create table if not exists schedule ("
						+ "sch_project_name varchar(30),"
						+ "sch_org_name varchar(30),"
						+ "sch_date varchar(10),"
						+ "sch_totaldate int(4),"
						+ "sch_restdate int(4),"
						+ "sch_totaltask int(3),"
						+ "sch_completetask int(3),"
						+ "sch_requireddateforcompletetask int(4),"
						+ "sch_ratio int(3),"
						+ "constraint sch_project_name foreign key (sch_project_name) references project (project_name),"
						+ "constraint sch_org_name foreign key (sch_org_name) references organization (org_name)"
						+ ")";
				pstmt = con.prepareStatement(sqlSchedule);
				pstmt.executeUpdate();
				
				String sqlTask = "create table if not exists task ("
						+ "task_project_name varchar(30),"
						+ "task_org_name varchar(30),"
						+ "task_name varchar(20) primary key,"
						+ "task_priority varchar(2) check (task_priority in ('상', '중', '하')),"
						+ "task_date int(4),"
						+ "task_progress varchar(6) check (task_progress in ('완료', '미완료')),"
						+ "constraint task_project_name foreign key (task_project_name) references project (project_name),"
						+ "constraint task_org_name foreign key (task_org_name) references organization (org_name)"
						+ ")";
				pstmt = con.prepareStatement(sqlTask);
				pstmt.executeUpdate();
				
				String sqlHumanResource = "create table if not exists humanresource ("
						+ "hr_project_name varchar(30),"
						+ "hr_org_name varchar(30),"
						+ "hr_name varchar(8),"
						+ "hr_idennumber varchar(13) primary key,"
						+ "hr_level varchar(4) check(hr_level in ('초급', '중급', '고급')),"
						+ "hr_age int(3),"
						+ "hr_graduate varchar(8),"
						+ "hr_salary int(10),"
						+ "constraint hr_project_name foreign key (hr_project_name) references project (project_name),"
						+ "constraint hr_org_name foreign key (hr_org_name) references organization (org_name))";
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
