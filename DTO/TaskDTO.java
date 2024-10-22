package DTO;

public class TaskDTO {
	private String projectName = null;
	private String organizationName = null; // FK(company table, companyName)
	private String taskName = null;
	private String taskPriority = null;
	private int taskDate = 0;
	private boolean taskProgress = null != null; // 업무 처리 완료 여부
	
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
	@Override
	public String toString() {
		return "TaskDTO [projectName=" + projectName + ", organizationName=" + organizationName + ", taskName="
				+ taskName + ", taskPriority=" + taskPriority + ", taskDate=" + taskDate + ", taskProgress="
				+ taskProgress + "]";
	}
	
}