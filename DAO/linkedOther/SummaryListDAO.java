package DAO.linkedOther;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SummaryListDAO extends _DAOSuper {
	public SummaryListDAO() {
		init();
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
