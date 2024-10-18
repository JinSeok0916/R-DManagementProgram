package DTO;

public class HumanResourceDTO {
	private String projectName = null;
	private String companyName = null; // FK(company table, companyName)
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyNameFK) {
		this.companyName = companyNameFK;
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
		return "HumanResourceDTO [companyName=" + companyName + ", participatingWorkforce=" + participatingWorkforce
				+ ", idenNumber=" + idenNumber + ", level=" + level + ", age=" + age + ", graduate=" + graduate
				+ ", salary=" + salary + "]";
	}
	
}
