package View.Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.StartView.MainFrame;

public class MainPanel extends JPanel implements ActionListener{
	JButton startButton = null;
	MainFrame mainFrame = null;
	String projectName = null;
	
	JLabel logo = new JLabel("",JLabel.CENTER);
	
	public MainPanel(MainFrame mf) {
		mainFrame = mf;
		JLabel title = new JLabel("R&D Management Program");
		startButton = new JButton("시작");
		// 패널 기본세팅
		this.setLayout(null);

		// 패널 크기 설정
		this.setBounds(0,0,800,800);
		
		this.setBackground(new Color(255,255,255,0));
		
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		// 프로그램 제목
		title.setBounds(195,150,500,50);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title);
		
		// 시작 버튼
		startButton.setBounds(340,500,200,50);
		startButton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		this.add(startButton);
		
		loadLogo();
		
		startButton.addActionListener(this);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			mainFrame.select("ProjectPanel");
		}
	}
	
	public void loadLogo() {
		logo.setBounds(15,40,850,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		this.add(logo);
	}
}
