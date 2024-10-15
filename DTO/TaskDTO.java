package DTO;

public class TaskDTO {
	private String companyName = null; // FK(company table, companyName)
	private String taskName = null;
	private String taskPriority = null;
	private int taskDate = 0;
	private boolean taskProgress = null != null;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
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