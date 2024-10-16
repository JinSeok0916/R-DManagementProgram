package View;

import java.awt.Color;
import java.awt.Font;
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

public class OverviewFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("R&D Management");
	JLabel p1Label3 = new JLabel("Program");
	JButton p1Label2 = new JButton();
	JLabel logo = new JLabel("");
	String outline = "<html><center>연구개발 프로세스를 설계 및 주도하고 <br>"
					+"연구개발 조직을 관리하며 <br>"
					+"혁신에 참여하는 다른 그룹이나 부서로의 <br>"
					+"새로운 노하우와 기술이 <br>"
					+"원활하게 이전되도록하는 <br>"
					+"관리 목적의 프로그램</center></html>";
	public OverviewFrame() {
		this.setBounds(200,75,865,890);
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(220,50,1000,100);
		p1Label1.setFont(new Font("나눔명조",Font.BOLD,50));
		panel1.add(p1Label1);
		p1Label3.setBounds(320,75,1000,200);
		p1Label3.setFont(new Font("나눔명조",Font.BOLD,50));
		panel1.add(p1Label3);
		
		p1Label2.setText(outline);
		p1Label2.setBounds(125,250,600,400);
		p1Label2.setBorder(new LineBorder(Color.black));
		p1Label2.setFont(new Font("나눔명조",Font.PLAIN,30));
		panel1.add(p1Label2);
		
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		panel1.add(logo);
		this.add(panel1);
		
		p1Label2.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == p1Label2) {
			this.setVisible(false);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			new MainFrame();
		}
		
	}
	
	
	
	
	
	
}
