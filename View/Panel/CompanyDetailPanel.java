package View.Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.StartView.MainFrame;

public class CompanyDetailPanel extends JPanel implements ActionListener, ItemListener {
	JButton mainButton = new JButton("<html><center>R&D Management Program</center></html>");
	List detailList = new List();
	JButton updateButton = new JButton("선택수정");
	JButton deleteButton = new JButton("선택삭제");
	JButton insertButton = new JButton("추가");
	JButton backButton = new JButton("←");
	JButton closeButton = new JButton("Ⅹ");
	JButton companyButton = new JButton("회사정보");
	JButton humanResourseButton = new JButton("인력");
	JButton costButton = new JButton("예산");
	JButton scheduleButton = new JButton("일정");
	String projectName = null;
	String companyName = null;
	MainFrame mainFrame = null;
	
	JLabel logo = new JLabel("",JLabel.CENTER);

	public CompanyDetailPanel(MainFrame mf) {
		mainFrame = mf;
		// 패널 설정
		this.setLayout(null);
		
		this.setBounds(0,0,800,800);
		
		this.setBackground(new Color(255,255,255,0));
		
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		// 기본 버튼 설정
		mainButton.setBounds(175,135,400,40);
		mainButton.setFont(new Font("나눔명조",Font.BOLD,25));
		this.add(mainButton);
		backButton.setBounds(575,135,50,40);
		this.add(backButton);
		closeButton.setBounds(625,135,50,40);
		this.add(closeButton);
		
		// 리스트 만들기
		detailList.setBounds(175,215,500,410);
		detailList.setFont(new Font("나눔명조",Font.PLAIN,25));
		this.add(detailList);
		
		// 원하는 리스트 설정 버튼
		companyButton.setBounds(175,175,125,40);
		companyButton.setFont(new Font("나눔명조",Font.BOLD,15));
		this.add(companyButton);
		humanResourseButton.setBounds(300,175,125,40);
		humanResourseButton.setFont(new Font("나눔명조",Font.BOLD,15));
		this.add(humanResourseButton);
		costButton.setBounds(425,175,125,40);
		costButton.setFont(new Font("나눔명조",Font.BOLD,15));
		this.add(costButton);
		scheduleButton.setBounds(550,175,125,40);
		scheduleButton.setFont(new Font("나눔명조",Font.BOLD,15));
		this.add(scheduleButton);
		
		// 수정 삭제 추가 버튼 설정
		updateButton.setBounds(175,625,250,50);
		updateButton.setFont(new Font("나눔명조",Font.BOLD,15));
		this.add(updateButton);
		deleteButton.setBounds(425,625,250,50);
		deleteButton.setFont(new Font("나눔명조",Font.BOLD,15));
		this.add(deleteButton);
		insertButton.setBounds(175,675,500,50);
		insertButton.setFont(new Font("나눔명조",Font.BOLD,15));
		this.add(insertButton);
		
		loadLogo();
		
		// 버튼 리스너 설정
		mainButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		insertButton.addActionListener(this);
		backButton.addActionListener(this);
		closeButton.addActionListener(this);
		companyButton.addActionListener(this);
		humanResourseButton.addActionListener(this);
		costButton.addActionListener(this);
		scheduleButton.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateButton) {
			// 선택 수정 메서드
			
		} else if (e.getSource() == deleteButton) {
			// 선택 삭제 메서드
			
		} else if (e.getSource() == insertButton) {
			// 추가 메서드
			
		} else if (e.getSource() == backButton) {

		} else if (e.getSource() == closeButton) {

		} else if (e.getSource() == mainButton) {

		} else if (e.getSource() == companyButton) {
			// 회사정보 리스트 메서드
			
		} else if (e.getSource() == humanResourseButton) {
			// 인력정보 리스트 메서드
			
		} else if (e.getSource() == costButton) {
			// 예산정보 리스트 메서드
			
		} else if (e.getSource() == scheduleButton) {
			// 일정정보 리스트 메서드
			
		}
	}
	
	void loadLogo() {
		logo.setBounds(15,40,850,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		this.add(logo);
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
