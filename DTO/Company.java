package DTO;

public class Company {
	private String companyNamePK = null;
	private String companySize = null;
	private int totalEmployee = 0;
	private String loaction = null;
	public String getCompanyNamePK() {
		return companyNamePK;
	}
	public void setCompanyNamePK(String companyNamePK) {
		this.companyNamePK = companyNamePK;
	}
	public String getCompanySize() {
		return companySize;
	}
	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}
	public int getTotalEmployee() {
		return totalEmployee;
	}
	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}
	public String getLoaction() {
		return loaction;
	}
	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
}
