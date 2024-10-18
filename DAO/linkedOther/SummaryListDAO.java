package DAO.linkedOther;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SummaryListDAO extends _DAOSuper {
	public SummaryListDAO() {
		init();
	}
	public int budget(String projectName, String companyName) {
		int allocatedBudget = 0;
		if (con()) {
			try {
				String sql = "select bdg_budgetallocated from budget where bdg_project_name = ?, bdg_com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					allocatedBudget = rs.getInt("lastmonth_avg");
					return allocatedBudget;
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			}
		}
		return 0;
	}
	public int humanResource(String projectName, String companyName) {
		int totalParticipants = 0;
		if (con()) {
			try {
				String sql = "select count(*) total_participants from humanresource where hr_project_name = ?, hr_com_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, projectName);
				pstmt.setString(2, companyName);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					totalParticipants = rs.getInt("total_participants");
				}
			} catch (Exception e) {
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (Exception e2) {
					}
				}
			}
			return totalParticipants;
		}
		return 0;
	}
}
