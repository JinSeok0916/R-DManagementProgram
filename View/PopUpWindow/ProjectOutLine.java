package View.PopUpWindow;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.linkedDTO.ProjectDAO;
import DTO.ProjectDTO;

public class ProjectOutLine extends JFrame{
	JPanel panel = new JPanel();
	JTextArea detail = new JTextArea("");
	ProjectDAO pDAO = new ProjectDAO();
	String projectName = null;
	
	public ProjectOutLine(String pN) {
		projectName = pN;
		
		this.setBounds(450,300,400,200);
		
		panel.setLayout(null);
		panel.setBounds(0,0,500,520);
		panel.setAlignmentX(CENTER_ALIGNMENT);
		
		detail.append(" - "+ loadProjectOutline());
		detail.setBounds(0,0,400,200);
		detail.setLineWrap(true);
		detail.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		detail.setEnabled(false);
		panel.add(detail);
		
		this.add(panel);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private String loadProjectOutline() {
		ProjectDTO DTO = (ProjectDTO) pDAO.listOne(projectName);
		String text = DTO.getProjectOutline();
		return text;
	}
	
}
