package View.PopUpWindow;

import DAO.linkedDTO.CompanyDAO;
import DTO.CompanyDTO;

public class CompanyDetailCRUD {
	
	CompanyDAO companyDAO = null;
	
	public CompanyDetailCRUD() {
		
	}
	
	public void companyDetail(CompanyDTO cDTO) {
		companyDAO = new CompanyDAO();
	}
	
}
