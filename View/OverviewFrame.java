package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class OverviewFrame extends JFrame implements ActionListener, ItemListener{
	private JPanel panel1 = new JPanel();
	JLabel p1Label1 = new JLabel("        R&D Management Program");
	
	public OverviewFrame() {
		this.setBounds(200,200,500,500);
		// 패널 나누기
		panel1.setLayout(null);
		p1Label1.setBounds(150,0,200,25);
		p1Label1.setBorder(new LineBorder(Color.black));
		panel1.add(p1Label1);
		this.add(panel1);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
