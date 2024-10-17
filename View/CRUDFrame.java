package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import DAO._DBDAO;

public class CRUDFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JButton mainButton = new JButton("<html><center>R&D Management Program</center></html>");
	List detailList = new List();
	JButton updateButton = new JButton("선택수정");
	JButton deleteButton = new JButton("선택삭제");
	JButton insertButton = new JButton("추가");
	JButton backButton = new JButton("←");
	JButton closeButton = new JButton("Ⅹ");
	JButton companyButton = new JButton("회사정보");
	JButton humanResourseButton = new JButton("인력");
	JButton costButton = new JButton("자금");
	JButton scheduleButton = new JButton("일정");
	
	JLabel logo = new JLabel("");
	int selNum = 0;
	_DBDAO DAO = null;
	
	public CRUDFrame() {
		this.setBounds(200,75,865,890);
		// 패널 나누기
		panel1.setLayout(null);
		mainButton.setBounds(175,135,400,40);
		mainButton.setFont(new Font("나눔명조",Font.BOLD,25));
		panel1.add(mainButton);
		detailList.setBounds(175,215,500,410);
		detailList.setFont(new Font("나눔명조",Font.PLAIN,25));
		panel1.add(detailList);
		updateButton.setBounds(175,625,250,50);
		updateButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(updateButton);
		deleteButton.setBounds(425,625,250,50);
		deleteButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(deleteButton);
		insertButton.setBounds(175,675,500,50);
		insertButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(insertButton);
		backButton.setBounds(575,135,50,40);
		panel1.add(backButton);
		closeButton.setBounds(625,135,50,40);
		panel1.add(closeButton);
		companyButton.setBounds(175,175,125,40);
		companyButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(companyButton);
		humanResourseButton.setBounds(300,175,125,40);
		humanResourseButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(humanResourseButton);
		costButton.setBounds(425,175,125,40);
		costButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(costButton);
		scheduleButton.setBounds(550,175,125,40);
		scheduleButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(scheduleButton);
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		panel1.add(logo);
		this.add(panel1);
		
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
			new ManageFrame();
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
			// 비용정보 리스트 메서드
			
		} else if (e.getSource() == scheduleButton) {
			// 일정정보 리스트 메서드
			
		}
	}

	public void itemStateChanged(ItemEvent e) {
		selNum = detailList.getSelectedIndex();
	}
}
