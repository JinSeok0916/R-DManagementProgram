package View;

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


public class ManageFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JButton mainButton = new JButton("<html><center>R&D Management Program</center></html>");
	List simpleList = new List();
	JButton insertButton = new JButton("회사추가");
	JButton detailButton = new JButton("상세설정");
	JButton deleteButton = new JButton("회사삭제");
	JButton backButton = new JButton("←");
	JButton closeButton = new JButton("Ⅹ");
	JLabel logo = new JLabel("");
	
	public ManageFrame() {
		this.setBounds(200,75,865,890);
		// 패널 나누기
		panel1.setLayout(null);
		mainButton.setBounds(175,135,400,40);
		mainButton.setFont(new Font("나눔명조",Font.BOLD,25));
		panel1.add(mainButton);
		simpleList.setBounds(175,175,500,450);
		simpleList.setFont(new Font("나눔명조",Font.PLAIN,25));
		panel1.add(simpleList);
		insertButton.setBounds(175,625,167,50);
		insertButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(insertButton);
		detailButton.setBounds(342,625,167,50);
		detailButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(detailButton);
		deleteButton.setBounds(509,625,166,50);
		deleteButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(deleteButton);
		backButton.setBounds(575,135,50,40);
		backButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(backButton);
		closeButton.setBounds(625,135,50,40);
		closeButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel1.add(closeButton);
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		panel1.add(logo);
		this.add(panel1);
		
		mainButton.addActionListener(this);
		insertButton.addActionListener(this);
		detailButton.addActionListener(this);
		deleteButton.addActionListener(this);
		backButton.addActionListener(this);
		closeButton.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertButton) {
			new InsertFrame();
		} else if (e.getSource() == detailButton) {
			new CRUDFrame();
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} else if (e.getSource() == deleteButton) {
//			new DeleteFrame();
		} else if (e.getSource() == backButton) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			new MainFrame();
		} else if (e.getSource() == closeButton) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} else if (e.getSource() == mainButton) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			new MainFrame();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
