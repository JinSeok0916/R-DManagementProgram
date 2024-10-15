package DTO;

public class TaskDTO {
	private String companyName = null; // FK(company table, companyName)
	private String taskNamePK = null;
	private int taskDate = 0;
	private boolean taskProgress = null != null;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyNameFK) {
		this.companyName = companyNameFK;
	}
	public String getTaskNamePK() {
		return taskNamePK;
	}
	public void setTaskNamePK(String taskNamePK) {
		this.taskNamePK = taskNamePK;
	}
	public int getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(int taskDate) {
		this.taskDate = taskDate;
	}
	public boolean isTaskProgress() {
		return taskProgress;
	}
	public void setTaskProgress(boolean taskProgress) {
		this.taskProgress = taskProgress;
	}
}