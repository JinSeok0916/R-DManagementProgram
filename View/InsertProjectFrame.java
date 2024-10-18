package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import DAO.linkedOther.CreateProjectTableDAO;


public class InsertProjectFrame extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	JLabel title = new JLabel("<html><center>R&D Management Program</center></html>");
	List list = new List();
	JButton checkButton = new JButton("확인");
	JTextArea projectName = new JTextArea();
	JTextField projectDate = new JTextField();
	JTextField projectBudget = new JTextField();
	JTextArea projectOutline = new JTextArea();
	CreateProjectTableDAO DAO = new CreateProjectTableDAO();
	
	public InsertProjectFrame() {
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 프로그램 제목
		title.setBounds(200,25,400,50);
		title.setFont(new Font("나눔명조",Font.BOLD,25));
		panel.add(title);
		
		// 추가할 프로젝트 이름, 기한, 예산, 개요
		projectName.setBounds(160,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		projectDate.setBounds(160,200,400,50);
		projectDate.setFont(new Font("나눔명조",Font.BOLD,15));
		projectDate.setBorder(new LineBorder(Color.black));
		panel.add(projectDate);
		projectBudget.setBounds(160,275,400,50);
		projectBudget.setFont(new Font("나눔명조",Font.BOLD,15));
		projectBudget.setBorder(new LineBorder(Color.black));
		panel.add(projectBudget);
		projectOutline.setBounds(160,350,400,200);
		projectOutline.setFont(new Font("나눔명조",Font.BOLD,15));
		projectOutline.setBorder(new LineBorder(Color.black));
		panel.add(projectOutline);
		
		// 확인 버튼
		checkButton.setBounds(310,600,100,30);
		checkButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(checkButton);
		
		this.add(panel);
		
		checkButton.addActionListener(this);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkButton) {
			// 프로젝트추가 메서드
			DAO.create(projectName.getText());
			
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
}
