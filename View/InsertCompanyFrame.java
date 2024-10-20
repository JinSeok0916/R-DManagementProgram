package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.linkedDTO.CompanyDAO;
import DAO.linkedDTO._DAOSuper;
import DTO.CompanyDTO;


public class InsertCompanyFrame extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	Frame frame = new Frame();
	JLabel title = new JLabel("R&D Management Program");
	List list = new List();
	JButton checkButton = new JButton("확인");
	JLabel companyNameTag = new JLabel("회사명");
	JTextField companyName = new JTextField();
	JLabel companyBudgetTag = new JLabel("예산");
	JTextField companyBudget = new JTextField();
	JLabel companyEstablishmentTag = new JLabel("설립연도");
	JTextField companyEstablishment = new JTextField();
	JLabel companySizeTag = new JLabel("규모");
	JTextField companySize = new JTextField();
	JLabel totalEmployeeTag = new JLabel("직원수");
	JTextField totalEmployee = new JTextField();
	JLabel companyAddressTag = new JLabel("주소");
	JTextField companyAddress = new JTextField();
	JLabel companyIntroTag = new JLabel("개요");
	JTextArea companyIntro = new JTextArea();
	String projectName = null;
	CompanyFrame companyFrame = null;
	
	int selNum = 0;
	_DAOSuper DAO = null;
	
	public InsertCompanyFrame(String pName, CompanyFrame cFrame, Frame frame1) {
		frame = frame1;
		projectName = pName;
		companyFrame = cFrame;
		this.setBounds(325,375,600,300);
		// 패널 나누기
		panel.setLayout(null);
		
		// 프로젝트 이름
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectNameTag);
		projectName.setBounds(175,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectNameTag);
		projectName.setBounds(175,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectNameTag);
		projectName.setBounds(175,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectNameTag);
		projectName.setBounds(175,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectNameTag);
		projectName.setBounds(175,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectNameTag);
		projectName.setBounds(175,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(projectNameTag);
		projectName.setBounds(175,125,400,50);
		projectName.setFont(new Font("나눔명조",Font.BOLD,15));
		projectName.setBorder(new LineBorder(Color.black));
		panel.add(projectName);
		
		// 추가할 회사 이름
		companyName.setBounds(165,100,250,50);
		companyName.setFont(new Font("나눔명조",Font.BOLD,20));
		panel.add(companyName);
		
		// 확인 버튼
		checkButton.setBounds(240,175,100,30);
		checkButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(checkButton);
		
		this.add(panel);
		
		checkButton.addActionListener(this);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkButton) {
			// 프로젝트추가 메서드
			CompanyDTO DTO = new CompanyDTO();
			DTO.setCompanyName(companyName.getText());
			DTO.setCompanyBudget(Integer.parseInt(companyBudget.getText()));
			DTO.setCompanyEstablishment(companyEstablishment.getText());
			DTO.setCompanySize(companySize.getText());
			DTO.setTotalEmployee(Integer.parseInt(totalEmployee.getText()));
			DTO.setCompanyAddress(companyAddress.getText());
			DTO.setCompanyIntro(companyIntro.getText());
			DAO.insert(DTO, projectName, null);
			companyFrame.companyList.add(DTO.toString());
			dispose();
		}
	}
}
