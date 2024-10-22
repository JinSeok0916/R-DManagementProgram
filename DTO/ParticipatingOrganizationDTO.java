package DTO;

public class ParticipatingOrganizationDTO {
	private String projectName = null;
	private String organizationName = null;
	private long participatingOrganizationBudget = 0;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public long getParticipatingOrganizationBudget() {
		return participatingOrganizationBudget;
	}
	public void setParticipatingOrganizationBudget(long participatingOrganizationBudget) {
		this.participatingOrganizationBudget = participatingOrganizationBudget;
	}
	@Override
	public String toString() {
		return "ParticipatingOrganizationDTO [projectName=" + projectName + ", OrganizationName=" + organizationName
				+ ", participatingOrganizationBudget=" + participatingOrganizationBudget + "]";
	}
	
}
