package DAO.linkedOther;

import java.sql.PreparedStatement;

public class CreateProjectTableDAO extends _DAOSuper{
	public CreateProjectTableDAO() {
		init();
		create();
	}
	
	// 입력값은 숫자로 하고 출력 시 문자로 받는것 고민 필요....
	@Override
	public void create() {
		if (con()) {
			PreparedStatement pstmt = null;
			try {
				String sqlProject = "create table project ("
						+ "project_name varchar(30) primary key,"
						+ "project_date int(4),"
						+ "project_budget int(12),"
						+ "project_outline varchar(100)"
						+ ")";
				pstmt = con.prepareStatement(sqlProject);
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
