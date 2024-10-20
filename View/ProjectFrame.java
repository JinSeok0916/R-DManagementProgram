package View;

import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.linkedDTO.ProjectDAO;
import DTO.ProjectDTO;



public class ProjectFrame extends JFrame{
	private JPanel panel = null;
	JLabel title1 = new JLabel("R&D Management");
	JLabel title2 = new JLabel("Program");
	List projectList = new List();
	JButton outlineButton = new JButton("사업개요");
	JButton companyButton = new JButton("참여기업관리");
	JButton insertProjectButton = new JButton("사업등록");
	ProjectDAO pDAO = new ProjectDAO();
	
	int selNum = 0;
	ArrayList<ProjectDTO> projectNameList = pDAO.list(null);
	
	public void setProjectFrame(JPanel panel1) {
		this.panel = panel1;
		// 메인 패널 Layout 설정
		panel.setLayout(null);
		
		// 프로그램 제목
		title1.setBounds(220,50,1000,100);
		title1.setFont(new Font("나눔명조",Font.BOLD,50));
		panel.add(title1);
		title2.setBounds(320,125,1000,75);
		title2.setFont(new Font("나눔명조",Font.BOLD,50));
		panel.add(title2);
		
		
		// 리스트 목록
		projectList.setBounds(175,200,500,425);
		projectList.setFont(new Font("나눔명조",Font.BOLD,20));
		loadProjectList();
		
		// 버튼 등록
		insertProjectButton.setBounds(175,625,500,50);
		insertProjectButton.setFont(new Font("나눔명조",Font.BOLD,20));
		panel.add(insertProjectButton);
		outlineButton.setBounds(175,675,250,50);
		outlineButton.setFont(new Font("나눔명조",Font.BOLD,20));
		panel.add(outlineButton);
		companyButton.setBounds(425,675,250,50);
		companyButton.setFont(new Font("나눔명조",Font.BOLD,20));
		panel.add(companyButton);
		
	}
	
	
	// 프로젝트 리스트 띄우기
	public void loadProjectList() {
		projectList.removeAll();
		for (int i = 0; i < projectNameList.size(); i++) {
			projectList.add(projectNameList.get(i).toString());
		}
		panel.add(projectList);
	}
		
		
}
