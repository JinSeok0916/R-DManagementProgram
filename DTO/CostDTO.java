package DTO;

public class CostDTO {
	private String projectName = null;
	private String companyName = null;
	private String date = null; // PK, 년월(총 4자리 숫자)
	private int materialCost = 0;
	private int laborCost = 0;
	private int expenseCost = 0;
	private int totalCost = materialCost + laborCost + expenseCost; // budget 의 총 지출에 반영
	
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
	public int getMaterialCost() {
		return materialCost;
	}
	public void setMaterialCost(int materialCost) {
		this.materialCost = materialCost;
	}
	public int getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(int laborCost) {
		this.laborCost = laborCost;
	}
	public int getExpenseCost() {
		return expenseCost;
	}
	public void setExpenseCost(int expenseCost) {
		this.expenseCost = expenseCost;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "CostDTO [companyName=" + companyName + ", date=" + date + ", materialCost=" + materialCost
				+ ", laborCost=" + laborCost + ", expenseCost=" + expenseCost + ", totalCost=" + totalCost + "]";
	}
	
}
