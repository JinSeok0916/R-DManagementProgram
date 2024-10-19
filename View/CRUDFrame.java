package View;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.linkedDTO._DAOSuper;

public class CRUDFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel = new JPanel();
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
	
	JLabel logo = new JLabel("");
	int selNum = 0;
	_DAOSuper DAO = null;
	String projectName = null;
	
	public CRUDFrame(String pN, String cN) {
		projectName = pN;
		
		
		// 창 크기 및 위치 조절
		this.setBounds(200,75,865,890);
		
		// 패널 설정
		panel.setLayout(null);
		
		// 기본 버튼 설정
		mainButton.setBounds(175,135,400,40);
		mainButton.setFont(new Font("나눔명조",Font.BOLD,25));
		panel.add(mainButton);
		backButton.setBounds(575,135,50,40);
		panel.add(backButton);
		closeButton.setBounds(625,135,50,40);
		panel.add(closeButton);
		
		// 리스트 만들기
		detailList.setBounds(175,215,500,410);
		detailList.setFont(new Font("나눔명조",Font.PLAIN,25));
		panel.add(detailList);
		
		// 원하는 리스트 설정 버튼
		companyButton.setBounds(175,175,125,40);
		companyButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(companyButton);
		humanResourseButton.setBounds(300,175,125,40);
		humanResourseButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(humanResourseButton);
		costButton.setBounds(425,175,125,40);
		costButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(costButton);
		scheduleButton.setBounds(550,175,125,40);
		scheduleButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(scheduleButton);
		
		// 수정 삭제 추가 버튼 설정
		updateButton.setBounds(175,625,250,50);
		updateButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(updateButton);
		deleteButton.setBounds(425,625,250,50);
		deleteButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(deleteButton);
		insertButton.setBounds(175,675,500,50);
		insertButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(insertButton);

		// 바탕 로고 설정
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		panel.add(logo);
		this.add(panel);
		
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateButton) {
			// 선택 수정 메서드
			
		} else if (e.getSource() == deleteButton) {
			// 선택 삭제 메서드
			
		} else if (e.getSource() == insertButton) {
			// 추가 메서드
			
		} else if (e.getSource() == backButton) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			new ManageFrame(projectName);
		} else if (e.getSource() == closeButton) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} else if (e.getSource() == mainButton) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			new MainFrame();
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

	public void itemStateChanged(ItemEvent e) {
	}
}
