package View.PopUpWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.linkedDTO.ProjectDAO;
import DTO.ProjectDTO;
import View.Panel.ProjectPanel;
import View.StartView.MainFrame;

public class ProjectCRUD extends JFrame implements ActionListener, KeyListener{
	private JPanel panel = new JPanel();
	
	private List list = new List();
	private JButton insertButton = new JButton("확인");
	private JButton updateButton = new JButton("확인");
	
	private JLabel projectNameTag = new JLabel("프로젝트 명");
	private JTextArea insertProjectName = new JTextArea();
	private JLabel projectDateTag = new JLabel("프로젝트 기한");
	private JTextField insertProjectDate = new JTextField();
	private JLabel projectBudgetTag = new JLabel("프로젝트 예산");
	private JTextField insertProjectBudget = new JTextField();
	private JLabel projectOutlineTag = new JLabel("프로젝트 개요");
	private JTextArea insertProjectOutline = new JTextArea();
	
	private ProjectDAO DAO = null;
	
	private ProjectDTO DTO = new ProjectDTO();
	
	MainFrame mainFrame = null;
	
	public ProjectCRUD() {
		// 리스너 등록
		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		insertProjectName.addKeyListener(this);
		insertProjectDate.addKeyListener(this);
		insertProjectBudget.addKeyListener(this);
		insertProjectOutline.addKeyListener(this);
	}
	
	public void projectInsert(MainFrame mf) {
		mainFrame = mf;
		
		panel.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 현재 창
		JLabel title = new JLabel("신규 사업 등록", JLabel.CENTER);
		title.setBounds(165,25,400,50);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
		panel.add(title);
		
		// 등록할 프로젝트 이름, 기한, 예산, 개요
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectNameTag);
		insertProjectName.setText("");
		insertProjectName.setBounds(175,125,400,50);
		insertProjectName.setFont(new Font("맑은 고딕",Font.BOLD,15));
		insertProjectName.setBorder(new LineBorder(Color.black));
		panel.add(insertProjectName);
		
		projectDateTag.setBounds(50,200,100,50);
		projectDateTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectDateTag);
		insertProjectDate.setText("");
		insertProjectDate.setBounds(175,200,400,50);
		insertProjectDate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		insertProjectDate.setBorder(new LineBorder(Color.black));
		panel.add(insertProjectDate);
		
		projectBudgetTag.setBounds(50,275,100,50);
		projectBudgetTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectBudgetTag);
		insertProjectBudget.setText("");
		insertProjectBudget.setBounds(175,275,400,50);
		insertProjectBudget.setFont(new Font("맑은 고딕",Font.BOLD,15));
		insertProjectBudget.setBorder(new LineBorder(Color.black));
		panel.add(insertProjectBudget);
		
		projectOutlineTag.setBounds(50,350,100,50);
		projectOutlineTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectOutlineTag);
		insertProjectOutline.setText("");
		insertProjectOutline.setBounds(175,350,400,200);
		insertProjectOutline.setFont(new Font("맑은 고딕",Font.BOLD,15));
		insertProjectOutline.setBorder(new LineBorder(Color.black));
		panel.add(insertProjectOutline);
		
		// 확인 버튼
		insertButton.setBounds(310,600,100,30);
		insertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(insertButton);
		
		this.add(panel);
		
		insertButton.setEnabled(false);
		
		this.setVisible(true);
	}
	
	public void projectUpdate(ProjectDTO project, MainFrame mf) {
		mainFrame = mf;
		
		panel.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		
		DTO.setProjectName(project.getProjectName());
		DTO.setProjectDate(project.getProjectDate());
		DTO.setProjectBudget(project.getProjectBudget());
		DTO.setProjectOutline(project.getProjectOutline());
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 현재 창
		JLabel title = new JLabel("기존 사업 수정", JLabel.CENTER);
		title.setBounds(165,25,400,50);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
		panel.add(title);
		
		// 등록할 프로젝트 이름, 기한, 예산, 개요
		projectNameTag.setBounds(50,125,100,50);
		projectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectNameTag);
		insertProjectName.setText(DTO.getProjectName());
		insertProjectName.setBounds(175,125,400,50);
		insertProjectName.setFont(new Font("맑은 고딕",Font.BOLD,15));
		insertProjectName.setBorder(new LineBorder(Color.black));
		panel.add(insertProjectName);
		insertProjectName.setEnabled(false);
		
		projectDateTag.setBounds(50,200,100,50);
		projectDateTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectDateTag);
		insertProjectDate.setText(String.valueOf(DTO.getProjectDate()));
		insertProjectDate.setBounds(175,200,400,50);
		insertProjectDate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		insertProjectDate.setBorder(new LineBorder(Color.black));
		panel.add(insertProjectDate);
		
		projectBudgetTag.setBounds(50,275,100,50);
		projectBudgetTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectBudgetTag);
		insertProjectBudget.setText(String.valueOf(DTO.getProjectBudget()));
		insertProjectBudget.setBounds(175,275,400,50);
		insertProjectBudget.setFont(new Font("맑은 고딕",Font.BOLD,15));
		insertProjectBudget.setBorder(new LineBorder(Color.black));
		panel.add(insertProjectBudget);
		
		projectOutlineTag.setBounds(50,350,100,50);
		projectOutlineTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectOutlineTag);
		insertProjectOutline.setText(DTO.getProjectOutline());
		insertProjectOutline.setBounds(175,350,400,200);
		insertProjectOutline.setFont(new Font("맑은 고딕",Font.BOLD,15));
		insertProjectOutline.setBorder(new LineBorder(Color.black));
		panel.add(insertProjectOutline);
		
		// 확인 버튼
		updateButton.setBounds(310,600,100,30);
		updateButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(updateButton);
		
		this.add(panel);
		
		updateButton.setEnabled(false);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == insertButton) {
			// 프로젝트추가 메서드
			DAO = new ProjectDAO();
			ProjectDTO insertDTO = new ProjectDTO();
			insertDTO.setProjectName(insertProjectName.getText());
			insertDTO.setProjectDate(Integer.valueOf(insertProjectDate.getText()));
			insertDTO.setProjectBudget(Integer.valueOf(insertProjectBudget.getText()));
			insertDTO.setProjectOutline(insertProjectOutline.getText());
			DAO.insert(insertDTO, null, null);
			dispose();
			mainFrame.select("ProjectPanel");
		} else if (e.getSource() == updateButton) {
			DAO = new ProjectDAO();
			ProjectDTO updateDTO = new ProjectDTO();
			updateDTO.setProjectName(insertProjectName.getText());
			updateDTO.setProjectDate(Integer.valueOf(insertProjectDate.getText()));
			updateDTO.setProjectBudget(Integer.valueOf(insertProjectBudget.getText()));
			updateDTO.setProjectOutline(insertProjectOutline.getText());
			DAO.update(updateDTO);
			dispose();
			mainFrame.select("ProjectPanel");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == insertProjectName || e.getSource() == insertProjectDate || e.getSource() == insertProjectBudget || e.getSource() == insertProjectOutline) {
			insertButton.setEnabled(true);
			updateButton.setEnabled(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
