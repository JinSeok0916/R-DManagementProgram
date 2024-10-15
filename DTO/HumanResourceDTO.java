package DTO;

public class HumanResourceDTO {
	private String participatingWorkforce = null;
	private int age = 0;
	private String graduate = null;
	private String gender = null;
	private int salary = 0;
	public String getParticipatingWorkforce() {
		return participatingWorkforce;
	}
	public void setParticipatingWorkforce(String participatingWorkforce) {
		this.participatingWorkforce = participatingWorkforce;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
