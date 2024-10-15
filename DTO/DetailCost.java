package DTO;

public class DetailCost {
	private int date = 0; // PK
	private int materialCost = 0;
	private int laborCost = 0;
	private int indirectCost = 0;
	private int totalCost = 0;
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
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
	public int getIndirectCost() {
		return indirectCost;
	}
	public void setIndirectCost(int indirectCost) {
		this.indirectCost = indirectCost;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
}
