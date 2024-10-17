package DAO.linkedOther;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SummaryDAO extends _DAOSuper {
	public SummaryDAO() {
		init();
	}
	public int budget(String companyName) {
		int allocatedBudget = 0;
		if (con()) {
			try {
				String sql = "select bdg_budgetallocated from "+companyName+"_budget";
				PreparedStatement pstmt = con.prepareStatement(sql);
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
	public int humanResource(String companyName) {
		int totalParticipants = 0;
		if (con()) {
			try {
				String sql = "select count(*) total_participants from "+companyName+"_humanresource";
				PreparedStatement pstmt = con.prepareStatement(sql);
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
