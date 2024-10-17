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


public class InsertFrame extends JFrame implements ActionListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("<html><center>R&D Management Program</center></html>");
	List p1List1 = new List();
	JButton p1btn1 = new JButton("확인");
	JTextField companyName = new JTextField();
	
	int selNum = 0;
	_DAOSuper DAO = null;
	
	public InsertFrame() {
		this.setBounds(325,375,600,300);
		// 패널 나누기
		panel1.setLayout(null);
		
		// 프로그램 제목
		p1Label1.setBounds(140,0,400,50);
		p1Label1.setFont(new Font("나눔명조",Font.BOLD,25));
		panel1.add(p1Label1);
		
		// 추가할 회사 이름
		companyName.setBounds(165,100,250,50);
		companyName.setFont(new Font("나눔명조",Font.BOLD,20));
		panel1.add(companyName);
		
		// 확인 버튼
		p1btn1.setBounds(240,175,100,30);
		p1btn1.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(p1btn1);
		
		this.add(panel1);
		
		p1btn1.addActionListener(this);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1btn1) {
			// DAO의 주소값 변경하기
			DAO = new CreateTableDAO();
			
			// 회사추가 메서드
			DAO.insert(companyName.getText());
			
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
}
