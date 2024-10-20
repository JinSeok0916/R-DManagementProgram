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
	JLabel title = new JLabel();
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
	CompanyDAO cDAO = new CompanyDAO();
	
	public InsertCompanyFrame(String pName, CompanyFrame cFrame, Frame frame1) {
		frame = frame1;
		projectName = pName;
		companyFrame = cFrame;
		this.setBounds(325,0,600,700);
		// 패널 나누기
		panel.setLayout(null);
		
		// 프로젝트 제목
		title.setText(projectName);
		System.out.println(projectName);
		title.setBounds(150,25,400,50);
		title.setFont(new Font("나눔명조",Font.BOLD,25));
		panel.add(title);
		
		// 회사 이름
		companyNameTag.setBounds(35,100,100,25);
		companyNameTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(companyNameTag);
		companyName.setBounds(135,100,350,25);
		companyName.setFont(new Font("나눔명조",Font.BOLD,15));
		companyName.setBorder(new LineBorder(Color.black));
		panel.add(companyName);
		
		companyBudgetTag.setBounds(35,150,100,25);
		companyBudgetTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(companyBudgetTag);
		companyBudget.setBounds(135,150,350,25);
		companyBudget.setFont(new Font("나눔명조",Font.BOLD,15));
		companyBudget.setBorder(new LineBorder(Color.black));
		panel.add(companyBudget);
		
		companyEstablishmentTag.setBounds(35,200,100,25);
		companyEstablishmentTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(companyEstablishmentTag);
		companyEstablishment.setBounds(135,200,350,25);
		companyEstablishment.setFont(new Font("나눔명조",Font.BOLD,15));
		companyEstablishment.setBorder(new LineBorder(Color.black));
		panel.add(companyEstablishment);
		
		companySizeTag.setBounds(35,250,100,25);
		companySizeTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(companySizeTag);
		companySize.setBounds(135,250,350,25);
		companySize.setFont(new Font("나눔명조",Font.BOLD,15));
		companySize.setBorder(new LineBorder(Color.black));
		panel.add(companySize);
		
		totalEmployeeTag.setBounds(35,300,100,25);
		totalEmployeeTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(totalEmployeeTag);
		totalEmployee.setBounds(135,300,350,25);
		totalEmployee.setFont(new Font("나눔명조",Font.BOLD,15));
		totalEmployee.setBorder(new LineBorder(Color.black));
		panel.add(totalEmployee);
		
		companyAddressTag.setBounds(35,350,100,25);
		companyAddressTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(companyAddressTag);
		companyAddress.setBounds(135,350,350,25);
		companyAddress.setFont(new Font("나눔명조",Font.BOLD,15));
		companyAddress.setBorder(new LineBorder(Color.black));
		panel.add(companyAddress);
		
		companyIntroTag.setBounds(35,400,100,25);
		companyIntroTag.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(companyIntroTag);
		companyIntro.setBounds(135,400,350,150);
		companyIntro.setFont(new Font("나눔명조",Font.BOLD,15));
		companyIntro.setBorder(new LineBorder(Color.black));
		panel.add(companyIntro);
		
		// 확인 버튼
		checkButton.setBounds(240,575,100,30);
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
			cDAO.insert(DTO, projectName, null);
			companyFrame.companyList.add(DTO.toString());
			dispose();
		}
	}
}
