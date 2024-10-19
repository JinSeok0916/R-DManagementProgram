package View;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.linkedOther.CreateTableDAO;
import DAO.linkedOther._DAOSuper;


public class InsertCompanyFrame extends JFrame implements ActionListener{
	private JPanel panel = new JPanel();
	JLabel title = new JLabel("<html><center>R&D Management Program</center></html>");
	List list = new List();
	JButton checkButton = new JButton("확인");
	JTextField companyName = new JTextField();
	
	int selNum = 0;
	_DAOSuper DAO = null;
	
	public InsertCompanyFrame(String projectName) {
		this.setBounds(325,375,600,300);
		// 패널 나누기
		panel.setLayout(null);
		
		// 프로그램 제목
		title.setBounds(140,0,400,50);
		title.setFont(new Font("나눔명조",Font.BOLD,25));
		panel.add(title);
		
		// 프로젝트 이름
		JLabel projectTitle = new JLabel(projectName);
		projectTitle.setBounds(140,0,400,50);
		projectTitle.setFont(new Font("나눔명조",Font.BOLD,25));
		panel.add(projectTitle);
		
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
			// DAO의 주소값 변경하기
			DAO = new CreateTableDAO();
			
			// 회사추가 메서드
			DAO.create(companyName.getText());
			
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
}
