package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.linkedDTO.CompanyDAO;
import DAO.linkedDTO.ProjectDAO;
import DAO.linkedOther.SummaryListDAO;
import DTO.CompanyDTO;
import DTO.ProjectDTO;

public class Frame extends JFrame implements ActionListener, ItemListener{
	// 패널 및 구성 요소 선언
	JPanel panel = new JPanel();
	JLabel logo = new JLabel();
	
	// DAO 및 DTO사용을 위한 선언
	ProjectDAO pDAO = new ProjectDAO();
	CompanyDAO cDAO = new CompanyDAO();
	SummaryListDAO slDAO = new SummaryListDAO();
	
	// 그 외 멤버변수 선언
	int frameNum = 0;
	int selNum = 0;
	String projectName = null;
	String companyName = null;
	
	// 새로운 Frame 을 만들지 않고 기존 Frame 에서 화면을 교체하기 위한 각 프레임의 주소 선언
	ProjectFrame projectFrame = new ProjectFrame();
	CompanyFrame companyFrame = new CompanyFrame();
	DetailFrame detailFrame = new DetailFrame();
	Object Frame = null;
	
	ArrayList<Object> frameList = new ArrayList<>();
	
	public void projectFrame() {
		frameNum = 1;
		frameList.add(projectFrame);
		frameList.add(companyFrame);
		frameList.add(detailFrame);
		// 창 크기 및 위치 조절
		this.setBounds(200,75,865,890);
		
		// 패널 초기화
		panel.removeAll();
		
		// 메인 패널 Layout 설정
		panel.setLayout(null);
		
		projectFrame.setProjectFrame(panel);
		loadLogo();
		
		// 모든 Frame 리스너 등록
		
		projectFrame.insertProjectButton.addActionListener(this);
		projectFrame.outlineButton.addActionListener(this);
		projectFrame.companyButton.addActionListener(this);
		projectFrame.projectList.addItemListener(this);
		
		if (projectName == null) {
			projectFrame.outlineButton.setEnabled(false);
		}
		
		this.add(panel);
		this.repaint();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void companyFrame() {
		frameNum = 2;
		// 패널 초기화
		panel.removeAll();
		
		// 메인 패널 Layout 설정
		panel.setLayout(null);
		
		companyFrame.setCompanyFrame(projectName, panel);
		loadLogo();
		
		// 모든 Frame 리스너 등록
		companyFrame.mainButton.addActionListener(this);
		companyFrame.insertButton.addActionListener(this);
		companyFrame.detailButton.addActionListener(this);
		companyFrame.deleteButton.addActionListener(this);
		companyFrame.backButton.addActionListener(this);
		companyFrame.closeButton.addActionListener(this);
		this.add(panel);
		this.repaint();
	}
	
	public void detailFrame() {
		// 패널 초기화
		panel.removeAll();
		
		// 메인 패널 Layout 설정
		panel.setLayout(null);
		
		detailFrame.setDetailFrame(projectName, companyName, panel);
		loadLogo();
		
		// 모든 Frame 리스너 등록
		detailFrame.mainButton.addActionListener(this);
		detailFrame.updateButton.addActionListener(this);
		detailFrame.deleteButton.addActionListener(this);
		detailFrame.insertButton.addActionListener(this);
		detailFrame.backButton.addActionListener(this);
		detailFrame.closeButton.addActionListener(this);
		detailFrame.companyButton.addActionListener(this);
		detailFrame.humanResourseButton.addActionListener(this);
		detailFrame.costButton.addActionListener(this);
		detailFrame.scheduleButton.addActionListener(this);
		
		this.add(panel);
		this.repaint();
	}
	
	// 리스트 클릭 시 이벤트
	public void itemStateChanged(ItemEvent e) {
		if (frameNum == 1) {
			selNum = projectFrame.projectList.getSelectedIndex();
			projectFrame.projectNameList = pDAO.list(null);
			projectName = projectFrame.projectNameList.get(selNum).getProjectName();
			projectFrame.outlineButton.setEnabled(true);
		} else if (frameNum == 2) {
			selNum = companyFrame.companyList.getSelectedIndex();
			companyName = companyFrame.companyNameList.get(selNum).getCompanyName();
		}
	}
	
	// 각 버튼의 동작 메서드
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == projectFrame.insertProjectButton) {
			new InsertProjectFrame(projectFrame, this);
		} else if (e.getSource() == projectFrame.outlineButton) {
			new OverviewFrame(projectName);
		} else if (e.getSource() == projectFrame.companyButton) {
			panel.removeAll();
			companyFrame();
		} else if (e.getSource() == companyFrame.insertButton) {
			new InsertCompanyFrame(projectName, companyFrame, this);
		} else if (e.getSource() == companyFrame.detailButton) {
			new DetailFrame();
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			dispose();
		} else if (e.getSource() == companyFrame.deleteButton) {
			// 회사 삭제 메서드
			
		} else if (e.getSource() == companyFrame.backButton) {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			projectFrame();
		} else if (e.getSource() == companyFrame.closeButton) {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			dispose();
		} else if (e.getSource() == companyFrame.mainButton) {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			projectFrame();
		}
	}
	
	
	// 로고 띄우기
	public void loadLogo() {
		logo.setBounds(25,25,800,800);
		logo.setIcon(new ImageIcon("src/LogoNewNew2.png"));
		panel.add(logo);
		this.add(panel);
	}

}
