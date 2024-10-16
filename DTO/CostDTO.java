package DTO;

public class CostDTO {
	private String date = null; // PK, 년월(총 4자리 숫자)
	private int materialCost = 0;
	private int laborCost = 0;
	private int expenseCost = 0;
	private int totalCost = 0; // budget 의 총 지출에 반영
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
}
