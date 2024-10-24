package DTO;

public class OrganizationDTO {
	private String organizationName = null;
	private String organizationEstablishment = null;
	private String organizationType = null;
	private int organizationTotalEmployee = 0;
	private String organizationAddress = null;
	private String organizationIntro = null;
	
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationEstablishment() {
		return organizationEstablishment;
	}
	public void setOrganizationEstablishment(String organizationEstablishment) {
		this.organizationEstablishment = organizationEstablishment;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public int getOrganizationTotalEmployee() {
		return organizationTotalEmployee;
	}
	public void setOrganizationTotalEmployee(int organizationTotalEmployee) {
		this.organizationTotalEmployee = organizationTotalEmployee;
	}
	public String getOrganizationAddress() {
		return organizationAddress;
	}
	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}
	public String getOrganizationIntro() {
		return organizationIntro;
	}
	public void setOrganizationIntro(String organizationIntro) {
		this.organizationIntro = organizationIntro;
	}
	@Override
	public String toString() {
		return "회사명 = " + organizationName + ", 설립연도 = "
				+ organizationEstablishment + ", 규모 = " + organizationType + ", 직원수 = "
				+ organizationTotalEmployee + ", 주소 = " + organizationAddress + ", 회사소개 = "
				+ organizationIntro;
	}

	
	
}
