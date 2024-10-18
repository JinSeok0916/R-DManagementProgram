package DTO;

public class ScheduleDTO {
	private String projectName = null;
	private String companyName = null; // FK(company table, companyName)
	private String date = null;
	private int totalDate = 0; // 연구개발에 필요한 총 기간(일)
	private int restDate = 0;
	private int totalTaskCount = 0;
	private int completeTaskCount = 0;
	private int requiredDateForCompleteTask = 0;
	private int requiredDateForCompleteTaskPerRestDate = 0; // 100이 넘으면, 일정 조정이 필요하다는 것을 의미함으로 GUI 에서 하이라이트 필요
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotalDate() {
		return totalDate;
	}
	public void setTotalDate(int totalDate) {
		this.totalDate = totalDate;
	}
	public int getRestDate() {
		return restDate;
	}
	public void setRestDate(int restDate) {
		this.restDate = restDate;
	}
	public int getTotalTaskCount() {
		return totalTaskCount;
	}
	public void setTotalTaskCount(int totalTaskCount) {
		this.totalTaskCount = totalTaskCount;
	}
	public int getCompleteTaskCount() {
		return completeTaskCount;
	}
	public void setCompleteTaskCount(int completeTaskCount) {
		this.completeTaskCount = completeTaskCount;
	}
	public int getRequiredDateForCompleteTask() {
		return requiredDateForCompleteTask;
	}
	public void setRequiredDateForCompleteTask(int requiredDateForCompleteTask) {
		this.requiredDateForCompleteTask = requiredDateForCompleteTask;
	}
	public int getRequiredDateForCompleteTaskPerRestDate() {
		return requiredDateForCompleteTaskPerRestDate;
	}
	public void setRequiredDateForCompleteTaskPerRestDate(int requiredDateForCompleteTaskPerRestDate) {
		this.requiredDateForCompleteTaskPerRestDate = requiredDateForCompleteTaskPerRestDate;
	}

}
