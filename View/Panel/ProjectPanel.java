package View.Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.linkedDTO.ProjectDAO;
import DTO.ProjectDTO;
import View.PopUpWindow.ProjectCRUD;
import View.PopUpWindow.ProjectOutLine;
import View.StartView.MainFrame;

public class ProjectPanel extends JPanel implements ActionListener, ItemListener{
	List projectList = new List();
	JButton mainButton = new JButton("R&D Management Program");
	JButton backButton = new JButton("←");
	JButton closeButton = new JButton("Ⅹ");
	JButton outlineButton = new JButton("사업개요");
	JButton companyButton = new JButton("참여기업관리");
	JButton insertProjectButton = new JButton("사업등록");
	JButton updateProjectButton = new JButton("사업수정");
	JButton deleteProjectButton = new JButton("사업삭제");
	private ProjectDTO projectDTO = null;
	int selNum = 0;
	MainFrame mainFrame = null;
	ProjectCRUD projectCRUD = null;
	
	ProjectDAO pDAO = null;
	ArrayList<ProjectDTO> projectNameList = null;
	
	JLabel logo = new JLabel("",JLabel.CENTER);
//	int cnt = 0;
//	int cnt1 = 0;
	public ProjectPanel(MainFrame mf) {
//		cnt1++;
//		System.out.println("패널 로드 : " + cnt1);
		mainFrame = mf;
		
		this.setLayout(null);
		
		this.setBounds(0,0,800,800);
		
		this.setBackground(new Color(255,255,255,0));
		
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		// 리스트 목록
		projectList.setBounds(175,200,500,425);
		projectList.setFont(new Font("맑은 고딕",Font.BOLD,20));
		
//		loadProjectList();
		
		// 기본 설정 버튼
		mainButton.setBounds(175,160,400,40);
		mainButton.setFont(new Font("맑은 고딕",Font.BOLD,25));
		this.add(mainButton);
		backButton.setBounds(575,160,50,40);
		backButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		this.add(backButton);
		closeButton.setBounds(625,160,50,40);
		closeButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		this.add(closeButton);
		
		// 버튼 등록
		insertProjectButton.setBounds(175,625,167,50);
		insertProjectButton.setFont(new Font("맑은 고딕",Font.BOLD,20));
		this.add(insertProjectButton);
		updateProjectButton.setBounds(342,625,166,50);
		updateProjectButton.setFont(new Font("맑은 고딕",Font.BOLD,20));
		this.add(updateProjectButton);
		deleteProjectButton.setBounds(508,625,167,50);
		deleteProjectButton.setFont(new Font("맑은 고딕",Font.BOLD,20));
		this.add(deleteProjectButton);
		outlineButton.setBounds(175,675,250,50);
		outlineButton.setFont(new Font("맑은 고딕",Font.BOLD,20));
		this.add(outlineButton);
		companyButton.setBounds(425,675,250,50);
		companyButton.setFont(new Font("맑은 고딕",Font.BOLD,20));
		this.add(companyButton);
		
//		loadLogo();
		
		updateProjectButton.setEnabled(false);
		deleteProjectButton.setEnabled(false);
		outlineButton.setEnabled(false);
		companyButton.setEnabled(false);
		
		insertProjectButton.addActionListener(this);
		updateProjectButton.addActionListener(this);
		deleteProjectButton.addActionListener(this);
		outlineButton.addActionListener(this);
		companyButton.addActionListener(this);
		mainButton.addActionListener(this);
		backButton.addActionListener(this);
		closeButton.addActionListener(this);
		projectList.addItemListener(this);
		
		this.setVisible(true);
		
	}
	
	public void loadProjectList() {
//		cnt++;
//		System.out.println("리스트 로드 : "+cnt);
		pDAO = new ProjectDAO();
		projectList.removeAll();
		projectNameList = pDAO.list(null);
		for (int i = 0; i < projectNameList.size(); i++) {
			projectList.add(projectNameList.get(i).toString());
		}
		this.add(projectList);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == companyButton) {
			mainFrame.select("CompanyPanel");
		} else if (e.getSource() == insertProjectButton) {
			projectCRUD = new ProjectCRUD();
			projectCRUD.projectInsert(mainFrame);
		} else if (e.getSource() == updateProjectButton) {
			projectCRUD = new ProjectCRUD();
			projectCRUD.projectUpdate(projectNameList.get(selNum), mainFrame);
		} else if (e.getSource() == deleteProjectButton) {
			pDAO.delete(projectNameList.get(selNum));
			mainFrame.select("ProjectPanel");
		} else if (e.getSource() == outlineButton) {
			new ProjectOutLine(projectDTO);
		} else if (e.getSource() == backButton) {
			mainFrame.select("MainPanel");
		} else if (e.getSource() == closeButton) {
			mainFrame.select("Close");
		} else if (e.getSource() == mainButton) {
			mainFrame.select("MainPanel");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		projectDTO = new ProjectDTO();
		selNum = projectList.getSelectedIndex();
		System.out.println(selNum);
		projectNameList = pDAO.list(null);
		System.out.println(projectNameList.toString());
		projectDTO = projectNameList.get(selNum);
		System.out.println(projectDTO.toString());
		updateProjectButton.setEnabled(true);
		deleteProjectButton.setEnabled(true);
		outlineButton.setEnabled(true);
		companyButton.setEnabled(true);
	}
	
	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public void loadLogo() {
		logo.setBounds(15,40,850,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		this.add(logo);
	}
}

//		String header[] = {"Name", "Date", "Budget"};
//		String contents[][] = {{"1", "1", "1"},
//							   {"1", "1", "1"}};
//		JTable projectList = new JTable(contents,header);
//		JScrollPane scrollpane = new JScrollPane(projectList);
//		mainFrame.add(scrollpane);