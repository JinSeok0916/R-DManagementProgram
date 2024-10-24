package DTO;

public class HumanResourceDTO {
	private String projectName = null;
	private String organizationName = null; // FK(company table, companyName)
	private String participatingWorkforce = null;
	private String idenNumber = null;
	private String level = null;
	private int age = 0;
	private String graduate = null;
	private int salary = 0;
	
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
	public String getParticipatingWorkforce() {
		return participatingWorkforce;
	}
	public void setParticipatingWorkforce(String participatingWorkforce) {
		this.participatingWorkforce = participatingWorkforce;
	}
	public String getIdenNumber() {
		return idenNumber;
	}
	public void setIdenNumber(String idenNumber) {
		this.idenNumber = idenNumber;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "이름 = " + participatingWorkforce
				+ ", 사번 = " + idenNumber + ", 등급 = " + level + ", 나이  = " + age + ", 학력 = " + graduate
				+ ", 연봉 = " + salary;
	}
	
}
