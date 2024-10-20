package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.linkedDTO.ProjectDAO;
import DTO.ProjectDTO;


public class InsertProjectFrame extends JFrame implements ActionListener, KeyListener{
	private JPanel panel = new JPanel();
	JLabel title = new JLabel("<html><center>R&D Management Program</center></html>");
	List list = new List();
	JButton checkButton = new JButton("확인");
	JLabel projectNameTag = new JLabel("프로젝트 명");
	JTextArea projectName = new JTextArea();
	JLabel projectDateTag = new JLabel("프로젝트 기한");
	JTextField projectDate = new JTextField();
	JLabel projectBudgetTag = new JLabel("프로젝트 예산");
	JTextField projectBudget = new JTextField();
	JLabel projectOutlineTag = new JLabel("프로젝트 개요");
	JTextArea projectOutline = new JTextArea();
	ProjectDAO DAO = new ProjectDAO();
	ProjectFrame projectFrame = null;
	Frame frame = null;
	
	public InsertProjectFrame(ProjectFrame pFrame, Frame frame1) {
		projectFrame = pFrame;
		frame = frame1;
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 프로그램 제목
		title.setBounds(220,25,400,50);
		title.setFont(new Font("나눔명조",Font.BOLD,25));
		panel.add(title);
		
		// 등록할 프로젝트 이름, 기한, 예산, 개요
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectNameTag);
		projectName.setBounds(175,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		
		projectDateTag.setBounds(50,200,100,50);
		projectDateTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectDateTag);
		projectDate.setBounds(175,200,400,50);
		projectDate.setFont(new Font("나눔명조",Font.BOLD,15));
		projectDate.setBorder(new LineBorder(Color.black));
		panel.add(projectDate);
		
		projectBudgetTag.setBounds(50,275,100,50);
		projectBudgetTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectBudgetTag);
		projectBudget.setBounds(175,275,400,50);
		projectBudget.setFont(new Font("나눔명조",Font.BOLD,15));
		projectBudget.setBorder(new LineBorder(Color.black));
		panel.add(projectBudget);
		
		projectOutlineTag.setBounds(50,350,100,50);
		projectOutlineTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectOutlineTag);
		projectOutline.setBounds(175,350,400,200);
		projectOutline.setFont(new Font("나눔명조",Font.BOLD,15));
		projectOutline.setBorder(new LineBorder(Color.black));
		panel.add(projectOutline);
		
		// 확인 버튼
		checkButton.setBounds(310,600,100,30);
		checkButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(checkButton);
		
		this.add(panel);
		
		checkButton.addActionListener(this);
		projectName.addKeyListener(this);
		projectDate.addKeyListener(this);
		projectBudget.addKeyListener(this);
		projectOutline.addKeyListener(this);
		
		this.setVisible(true);
		
		checkButton.setEnabled(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkButton) {
			// 프로젝트추가 메서드
			ProjectDTO DTO = new ProjectDTO();
			DTO.setProjectName(projectName.getText());
			DTO.setProjectDate(Integer.valueOf(projectDate.getText()));
			DTO.setProjectBudget(Integer.valueOf(projectBudget.getText()));
			DTO.setProjectOutline(projectOutline.getText());
			DAO.insert(DTO, null, null);
			projectFrame.projectList.add(DTO.toString());
			dispose();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == projectName || e.getSource() == projectDate || e.getSource() == projectBudget || e.getSource() == projectOutline) {
			checkButton.setEnabled(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
