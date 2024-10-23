package View.StartView;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DAO.linkedOther.CreateBasicTableDAO;
import DAO.linkedOther.CreateDetailTableDAO;
import View.Panel.CompanyDetailPanel;
import View.Panel.CompanyPanel;
import View.Panel.MainPanel;
import View.Panel.ProjectPanel;

public class MainFrame extends JFrame{
	CreateBasicTableDAO CBTDAO = new CreateBasicTableDAO();
	CreateDetailTableDAO CDTDAO = new CreateDetailTableDAO();
	MainPanel mainPanel = new MainPanel(this);
	ProjectPanel projectPanel = new ProjectPanel(this);
	CompanyPanel companyPanel = new CompanyPanel(this);
	CompanyDetailPanel companyDetailPanel = new CompanyDetailPanel(this);
	JLabel logo = new JLabel("",JLabel.CENTER);
	
	public MainFrame() {
		select("MainPanel");
		
		this.setBounds(200,50,900,920);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void select(String panel) {
		if (panel.equals("MainPanel")) {
			this.remove(mainPanel);
			this.remove(projectPanel);
			this.remove(companyPanel);
			this.remove(companyDetailPanel);
			this.setVisible(false);
			this.setVisible(true);
			this.add(mainPanel);
		} else if (panel.equals("ProjectPanel")) {
			this.remove(mainPanel);
			this.remove(projectPanel);
			this.remove(companyPanel);
			this.remove(companyDetailPanel);
			projectPanel.loadProjectList();
			projectPanel.loadLogo();
			this.setVisible(false);
			this.setVisible(true);
			this.add(projectPanel);
		} else if (panel.equals("CompanyPanel")) {
			companyPanel.setProjectDTO(projectPanel.getProjectDTO());
			this.remove(mainPanel);
			this.remove(projectPanel);
			this.remove(companyPanel);
			this.remove(companyDetailPanel);
			companyPanel.loadParticipatingOrganization();
			companyPanel.loadLogo();
			this.setVisible(false);
			this.setVisible(true);
			this.add(companyPanel);
		} else if (panel.equals("CompanyDetailPanel")) {
			companyDetailPanel.setParticipatingOrganizationDTO(companyPanel.getParticipatingOrganizationDTO());
			this.remove(mainPanel);
			this.remove(projectPanel);
			this.remove(companyPanel);
			this.remove(companyDetailPanel);
			this.setVisible(false);
			this.setVisible(true);
			this.add(companyDetailPanel);
		} else if (panel.equals("Close")) {
			dispose();
		}
	}
	
//	public void loadLogo() {
//		logo.setBounds(15,40,850,800);
//		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
//		this.add(logo);
//	}
}
