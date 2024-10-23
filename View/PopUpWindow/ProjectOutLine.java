package View.PopUpWindow;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import DAO.linkedDTO.ProjectDAO;
import DTO.ProjectDTO;

public class ProjectOutLine extends JFrame{
	JTextArea detail = new JTextArea("");
	ProjectDAO pDAO = new ProjectDAO();
	ProjectDTO projectDTO = null;
	
	public ProjectOutLine(ProjectDTO pDTO) {
		projectDTO = pDTO;
		
		this.setBounds(250,300,750,165);
		
		String header[] = {"기간","예산","개요"};
		String content[][] = {{String.valueOf(projectDTO.getProjectDate()),String.valueOf(projectDTO.getProjectBudget()),String.valueOf(projectDTO.getProjectOutline())}};
		
		DefaultTableModel model = new DefaultTableModel(content,header);
		
		JTable table = new JTable(model);
		
		table.getColumn("기간").setPreferredWidth(25);
		table.getColumn("예산").setPreferredWidth(50);
		table.getColumn("개요").setPreferredWidth(500);
		table.setRowHeight(100);
		
		JScrollPane sc = new JScrollPane(table);
		
		add(sc);
		
//		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}
