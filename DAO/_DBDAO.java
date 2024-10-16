package DAO;

import java.util.ArrayList;

import DTO.CostDTO;

public interface _DBDAO {
	
	public void insert(String companyName);
	public ArrayList<CostDTO> list(String companyName);
	public CostDTO listOne(String companyName, int selDate);
	public int simpleList(String companyName);
	public void update(String companyName, String selDate, int cost_material, int cost_labor, int cost_expense);
	public void delete(String companyName);
	
}
