package DTO;

public class ScheduleDTO {
	private String companyName = null; // FK(company table, companyName)
	private int totalSchedule = 0;
	private int restSchedule = 0;
	private String taskName = null; // FK(task table, taskName)
	private int taskComplete = 0;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyNameFK) {
		this.companyName = companyNameFK;
	}
	public int getTotalSchedule() {
		return totalSchedule;
	}
	public void setTotalSchedule(int totalSchedule) {
		this.totalSchedule = totalSchedule;
	}
	public int getRestSchedule() {
		return restSchedule;
	}
	public void setRestSchedule(int restSchedule) {
		this.restSchedule = restSchedule;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getTaskComplete() {
		return taskComplete;
	}
	public void setTaskComplete(int taskComplete) {
		this.taskComplete = taskComplete;
	}

}
