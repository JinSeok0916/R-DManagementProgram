package DTO;

public class CostDTO {
	private String companyName = null; // FK(company table, companyName)
	private int budgetAllocated = 0;
	private int budgetUsed = 0; // FK(detailcost table, totalCost)
	private int budgetRemained = 0;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyNameFK) {
		this.companyName = companyNameFK;
	}
	public int getBudgetAllocated() {
		return budgetAllocated;
	}
	public void setBudgetAllocated(int budgetAllocated) {
		this.budgetAllocated = budgetAllocated;
	}
	public int getBudgetUsed() {
		return budgetUsed;
	}
	public void setBudgetUsed(int budgetUsed) {
		this.budgetUsed = budgetUsed;
	}
	public int getBudgetRemained() {
		return budgetRemained;
	}
	public void setBudgetRemained(int budgetRemained) {
		this.budgetRemained = budgetRemained;
	}
}
