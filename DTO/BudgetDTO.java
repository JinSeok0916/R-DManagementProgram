package DTO;

public class BudgetDTO {
	private String companyName = null; // FK(company table, companyName)
	private int date = 0; // FK(detailcost table, date)
	private int budgetAllocated = 0;
	private int usingTotalCost = 0;
	private int remainedCost = 0;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyNameFK) {
		this.companyName = companyNameFK;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getBudgetAllocated() {
		return budgetAllocated;
	}
	public void setBudgetAllocated(int budgetAllocated) {
		this.budgetAllocated = budgetAllocated;
	}
	public int getUsingTotalCost() {
		return usingTotalCost;
	}
	public void setUsingTotalCost(int usingTotalCost) {
		this.usingTotalCost = usingTotalCost;
	}
	public int getRemainedCost() {
		return remainedCost;
	}
	public void setRemainedCost(int remainedCost) {
		this.remainedCost = remainedCost;
	}
	System.out.println("꺄악");
}
