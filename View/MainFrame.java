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

import DTO.ProjectDTO;

public class MainFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel = new JPanel();
	JLabel title1 = new JLabel("R&D Management");
	JLabel title2 = new JLabel("Program");
	List list = new List();
	JButton outlineButton = new JButton("사업개요");
	JButton manageButton = new JButton("참여기업관리");
	JButton insertProjectButton = new JButton("사업등록");
	JLabel logo = new JLabel();
	int selNum = 0;
	ProjectDTO project = null;
	
	public MainFrame() {
		this.setBounds(200,75,865,890);
		
		// 패널 설정
		panel.setLayout(null);
		
		// 프로그램 제목
		title1.setBounds(220,50,1000,100);
		title1.setFont(new Font("나눔명조",Font.BOLD,50));
		panel.add(title1);
		title2.setBounds(320,125,1000,75);
		title2.setFont(new Font("나눔명조",Font.BOLD,50));
		panel.add(title2);
		
		// 리스트 목록
		list.setBounds(175,200,500,425);
		list.setFont(new Font("나눔명조",Font.BOLD,20));
		panel.add(list);
		
		// 버튼 등록
		insertProjectButton.setBounds(175,625,500,50);
		insertProjectButton.setFont(new Font("나눔명조",Font.BOLD,20));
		panel.add(insertProjectButton);
		outlineButton.setBounds(175,675,250,50);
		outlineButton.setFont(new Font("나눔명조",Font.BOLD,20));
		panel.add(outlineButton);
		manageButton.setBounds(425,675,250,50);
		manageButton.setFont(new Font("나눔명조",Font.BOLD,20));
		panel.add(manageButton);
		
		// 바탕로고
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		panel.add(logo);
		this.add(panel);
		
		// 리스너 등록
		insertProjectButton.addActionListener(this);
		outlineButton.addActionListener(this);
		manageButton.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertProjectButton) {
			new InsertProjectFrame();
		} else if (e.getSource() == outlineButton) {
			new OverviewFrame();
			this.setVisible(false);
		} else if (e.getSource() == manageButton) {
			new ManageFrame(project.getProjectName());
			this.setVisible(false);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		selNum = list.getSelectedIndex();
		
	}
}
