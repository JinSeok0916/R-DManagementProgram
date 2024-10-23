package DAO.linkedOther;

import java.sql.PreparedStatement;

public class CreateBasicTableDAO extends _DAOSuper{
	public CreateBasicTableDAO() {
		init();
		create();
	}
	
	// 입력값은 숫자로 하고 출력 시 문자로 받는것 고민 필요....
	@Override
	public void create() {
		if (con()) {
			PreparedStatement pstmt = null;
			try {
				String sqlProject = "create table if not exists project ("
						+ "project_name varchar(30) primary key,"
						+ "project_date int(4),"
						+ "project_budget int(12),"
						+ "project_outline varchar(100)"
						+ ")";
				pstmt = con.prepareStatement(sqlProject);
				pstmt.executeUpdate();
				
				String sqlOrganization = "create table if not exists organization ("
						+ "org_name varchar(30) primary key,"
						+ "org_establishment varchar(10),"
						+ "org_type varchar(8) check(com_size in ('중소기업', '중견기업', '대기업', '공기업', '산학협력')),"
						+ "org_employee int(5),"
						+ "org_address varchar(40),"
						+ "org_intro varchar(100)"
						+ ")";
				pstmt = con.prepareStatement(sqlOrganization);
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
