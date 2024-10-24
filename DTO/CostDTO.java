package DTO;

public class CostDTO {
	private String projectName = null;
	private String organizationName = null;
	private String date = null; // PK, 년월(총 4자리 숫자)
	private long materialCost = 0;
	private long laborCost = 0;
	private long expenseCost = 0;
	private long totalCost = materialCost + laborCost + expenseCost; // budget 의 총 지출에 반영
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(long materialCost) {
		this.materialCost = materialCost;
	}
	public long getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(long laborCost) {
		this.laborCost = laborCost;
	}
	public long getExpenseCost() {
		return expenseCost;
	}
	public void setExpenseCost(long expenseCost) {
		this.expenseCost = expenseCost;
	}
	public long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "날짜 = " + date + ", 재료비 = " + materialCost
				+ ", 노무비 = " + laborCost + ", 경비 = " + expenseCost + ", 총액 = " + totalCost;
	}
	
}
