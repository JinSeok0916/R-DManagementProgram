package DTO;

public class CostDTO {
	private int budgetAllocated = 0;
	private int budgetUsed = 0;
	private int budgetRemained = 0;
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
