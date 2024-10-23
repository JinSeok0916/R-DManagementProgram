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

import DAO.linkedDTO.ParticipatingOrganizationDAO;
import DTO.ParticipatingOrganizationDTO;
import DTO.ProjectDTO;
import View.PopUpWindow.CompanyCRUD;
import View.StartView.MainFrame;

public class CompanyPanel extends JPanel implements ActionListener, ItemListener{
	List participatingOrganizationList = new List();
	JButton mainButton = new JButton("R&D Management Program");
	JButton backButton = new JButton("←");
	JButton closeButton = new JButton("Ⅹ");
	JButton insertButton = new JButton("회사추가");
	JButton detailButton = new JButton("상세설정");
	JButton deleteButton = new JButton("회사삭제");
	ParticipatingOrganizationDAO poDAO = null;
	private ProjectDTO projectDTO = null;
	private ParticipatingOrganizationDTO participatingOrganizationDTO = null;
	int selNum = 0;
	ArrayList<ParticipatingOrganizationDTO> participatingOrganizationNameList = null;
	MainFrame mainFrame = null;
	
	JLabel logo = new JLabel("",JLabel.CENTER);
	
	public CompanyPanel(MainFrame mf) {
		mainFrame = mf;
		// 패널 설정
		this.setLayout(null);
		
		this.setBounds(0,0,800,800);
		
		this.setBackground(new Color(255,255,255,0));
		
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		// 기본 설정 버튼
		mainButton.setBounds(175,135,400,40);
		mainButton.setFont(new Font("맑은 고딕",Font.BOLD,25));
		this.add(mainButton);
		backButton.setBounds(575,135,50,40);
		backButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		this.add(backButton);
		closeButton.setBounds(625,135,50,40);
		closeButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		this.add(closeButton);
		
		// DB에서 꺼낸 리스트 입력
		participatingOrganizationList.setBounds(175,175,500,450);
		participatingOrganizationList.setFont(new Font("맑은 고딕",Font.BOLD,20));
		
		// 회사추가 상세설정 회사삭제 버튼 생성
		insertButton.setBounds(175,625,167,50);
		insertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		this.add(insertButton);
		detailButton.setBounds(342,625,167,50);
		detailButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		this.add(detailButton);
		deleteButton.setBounds(509,625,166,50);
		deleteButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		this.add(deleteButton);
		
		insertButton.addActionListener(this);
		detailButton.addActionListener(this);
		deleteButton.addActionListener(this);
		mainButton.addActionListener(this);
		backButton.addActionListener(this);
		closeButton.addActionListener(this);
		participatingOrganizationList.addItemListener(this);
		
		this.setVisible(true);
	}

	public void loadParticipatingOrganization() {
		poDAO = new ParticipatingOrganizationDAO();
		participatingOrganizationList.removeAll();
		participatingOrganizationNameList = poDAO.list(projectDTO);
		System.out.println(participatingOrganizationNameList.toString());
		for (int i = 0; i < participatingOrganizationNameList.size(); i++) {
			participatingOrganizationList.add(participatingOrganizationNameList.get(i).toString());
		}
		this.add(participatingOrganizationList);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		selNum = participatingOrganizationList.getSelectedIndex();
		participatingOrganizationDTO = participatingOrganizationNameList.get(selNum);
		System.out.println(participatingOrganizationDTO.getProjectName());
		System.out.println(participatingOrganizationDTO.getOrganizationName());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertButton) {
			new CompanyCRUD().orgInsert(mainFrame);;
		} else if (e.getSource() == detailButton) {
			mainFrame.select("CompanyDetailPanel");
		} else if (e.getSource() == deleteButton) {
			poDAO.delete(participatingOrganizationNameList.get(selNum));
			mainFrame.select("CompanyPanel");
		} else if (e.getSource() == backButton) {
			mainFrame.select("ProjectPanel");
		} else if (e.getSource() == closeButton) {
			mainFrame.select("Close");
		} else if (e.getSource() == mainButton) {
			mainFrame.select("MainPanel");
		}
	}

	public ProjectDTO getProjectDTO() {
		return projectDTO;
	}

	public void setProjectDTO(ProjectDTO projectDTO) {
		this.projectDTO = projectDTO;
	}

	public ParticipatingOrganizationDTO getParticipatingOrganizationDTO() {
		return participatingOrganizationDTO;
	}

	public void setParticipatingOrganizationDTO(ParticipatingOrganizationDTO participatingOrganizationDTO) {
		this.participatingOrganizationDTO = participatingOrganizationDTO;
	}

	public void loadLogo() {
		logo.setBounds(15,40,850,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		this.add(logo);
	}
}
