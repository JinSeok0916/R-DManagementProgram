package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.linkedDTO.ProjectDAO;
import DTO.ProjectDTO;

public class OverviewFrame extends JFrame implements ActionListener{
	private JPanel panel1 = new JPanel();
	JLabel title1 = new JLabel("R&D Management");
	JLabel title2 = new JLabel("Program");
	JButton mainButton = new JButton();
	JLabel logo = new JLabel();
	String outline = null;
	ProjectDAO pDAO = new ProjectDAO();
	Frame mainFrame = null;
	
	public OverviewFrame(String projectName) {
		this.setBounds(200,75,865,890);
		// 패널 나누기
		panel1.setLayout(null);
		
		title1.setBounds(220,50,1000,100);
		title1.setFont(new Font("나눔명조",Font.BOLD,50));
		panel1.add(title1);
		title2.setBounds(320,75,1000,200);
		title2.setFont(new Font("나눔명조",Font.BOLD,50));
		panel1.add(title2);
		
		ProjectDTO pDTO = (ProjectDTO) pDAO.listOne(projectName);
		outline = pDTO.getProjectOutline();
		mainButton.setText(outline);
		mainButton.setBounds(125,250,600,400);
		mainButton.setFont(new Font("나눔명조",Font.PLAIN,30));
		panel1.add(mainButton);
		
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		panel1.add(logo);
		this.add(panel1);
		
		mainButton.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainButton) {
			dispose();
		}
		
	}
	
	
	
	
	
	
}
