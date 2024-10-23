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
import View.StartView.MainFrame;

public class CompanyCRUD extends JFrame implements ActionListener, KeyListener{
	private JPanel panel = new JPanel();
	
	private List list = new List();
	private JButton updateButton = new JButton("확인");
	
	private JTextArea data1 = new JTextArea();
	private JTextArea data2 = new JTextArea();
	private JTextArea data3 = new JTextArea();
	private JTextArea data4 = new JTextArea();
	private JTextArea data5 = new JTextArea();
	private JTextArea data6 = new JTextArea();
	private JTextArea data7 = new JTextArea();
	private JTextArea data8 = new JTextArea();
	private JTextArea data9 = new JTextArea();
	
	private JLabel projectNameTag = new JLabel("프로젝트명");
	private JLabel companyNameTag = new JLabel("회사명");
	
	private JLabel estTag = new JLabel("설립연도");
	private JLabel typeTag = new JLabel("규모");
	private JLabel employeeTag = new JLabel("직원수");
	private JLabel addressTag = new JLabel("주소");
	private JLabel introTag = new JLabel("회사소개");
	
	private JLabel costDateTag = new JLabel("날짜");
	private JLabel costMaterialTag = new JLabel("");
	private JLabel costLaborTag = new JLabel("");
	private JLabel costExpenseTag = new JLabel("");
	private JLabel costTotalTag = new JLabel("총액");
	
	
	private JLabel hrNameTag = new JLabel("이름");
	private JLabel hrIdenNumTag = new JLabel("사번");
	private JLabel hrLevelTag = new JLabel("등급");
	private JLabel hrAgeTag = new JLabel("나이");
	private JLabel hrGraduateTag = new JLabel("학력");
	private JLabel hrSalaryTag = new JLabel("연봉");
	
	private JLabel schDate = new JLabel("날짜");
	private JLabel schTotalDate = new JLabel("총 일수");
	private JLabel schRestDate = new JLabel("남은 일수");
	private JLabel schTotalTask = new JLabel("총 업무");
	private JLabel schCompleteTask = new JLabel("완수한 업무");
	private JLabel schRDFC = new JLabel("잔여 업무 처리 소요 일수");
	private JLabel schRatio = new JLabel("진척도");
	
	private JLabel taskName = new JLabel("업무명");
	private JLabel taskPriority = new JLabel("우선도");
	private JLabel taskDate = new JLabel("업무 처리 필요 일수");
	private JLabel taskProgress = new JLabel("업무 수행 여부");
	
	private ProjectDAO DAO = null;
	
	private ProjectDTO DTO = new ProjectDTO();
	
	MainFrame mainFrame = null;
	
	public CompanyCRUD() {
		updateButton.addActionListener(this);
		data1.addKeyListener(this);
		data2.addKeyListener(this);
		data3.addKeyListener(this);
		data4.addKeyListener(this);
		data5.addKeyListener(this);
		data6.addKeyListener(this);
		data7.addKeyListener(this);
		data8.addKeyListener(this);
		data9.addKeyListener(this);
	}
	
	public void orgInsert(MainFrame mf) {
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
		
		// 등록할 회사 이름, 설립연도, 규모, 직원수, 주소, 개요
		companyNameTag.setBounds(50,125,100,50);
		companyNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(companyNameTag);
		data1.setText("");
		data1.setBounds(175,125,400,50);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		estTag.setBounds(50,200,100,50);
		estTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(estTag);
		data2.setText("");
		data2.setBounds(175,200,400,50);
		data2.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data2.setBorder(new LineBorder(Color.black));
		panel.add(data2);
		
		typeTag.setBounds(50,275,100,50);
		typeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(typeTag);
		data3.setText("");
		data3.setBounds(175,275,400,50);
		data3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data3.setBorder(new LineBorder(Color.black));
		panel.add(data3);
		
		employeeTag.setBounds(50,350,100,50);
		employeeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(employeeTag);
		data4.setText("");
		data4.setBounds(175,350,400,200);
		data4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data4.setBorder(new LineBorder(Color.black));
		panel.add(data4);
		
		addressTag.setBounds(50,350,100,50);
		addressTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(addressTag);
		data5.setText("");
		data5.setBounds(175,350,400,200);
		data5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data5.setBorder(new LineBorder(Color.black));
		panel.add(data5);
		
		introTag.setBounds(50,350,100,50);
		introTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(introTag);
		data6.setText("");
		data6.setBounds(175,350,400,200);
		data6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data6.setBorder(new LineBorder(Color.black));
		panel.add(data6);
		
		// 확인 버튼
		updateButton.setBounds(310,600,100,30);
		updateButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(updateButton);
		
		this.add(panel);
		
		updateButton.setEnabled(false);
		
		this.setVisible(true);
		
		costInsert(mf);
	}
	
	public void costInsert(MainFrame mf) {
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
		
		// 등록할 예산 이름, 기한, 예산, 개요
		costProjectNameTag.setBounds(50,125,100,50);
		costProjectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costProjectNameTag);
		data1.setText("");
		data1.setBounds(175,125,400,50);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		costOrgNameTag.setBounds(50,200,100,50);
		costOrgNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costOrgNameTag);
		costOrgName.setText("");
		costOrgName.setBounds(175,200,400,50);
		costOrgName.setFont(new Font("맑은 고딕",Font.BOLD,15));
		costOrgName.setBorder(new LineBorder(Color.black));
		panel.add(costOrgName);
		
		costDateTag.setBounds(50,275,100,50);
		costDateTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costDateTag);
		costDate.setText("");
		costDate.setBounds(175,275,400,50);
		costDate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		costDate.setBorder(new LineBorder(Color.black));
		panel.add(costDate);
		
		costMaterialTag.setBounds(50,350,100,50);
		costMaterialTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costMaterialTag);
		costMaterial.setText("");
		costMaterial.setBounds(175,350,400,200);
		costMaterial.setFont(new Font("맑은 고딕",Font.BOLD,15));
		costMaterial.setBorder(new LineBorder(Color.black));
		panel.add(costMaterial);
		
		costLaborTag.setBounds(50,350,100,50);
		costLaborTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costLaborTag);
		costLabor.setText("");
		costLabor.setBounds(175,350,400,200);
		costLabor.setFont(new Font("맑은 고딕",Font.BOLD,15));
		costLabor.setBorder(new LineBorder(Color.black));
		panel.add(costLabor);
		
		costExpenseTag.setBounds(50,350,100,50);
		costExpenseTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costExpenseTag);
		costExpense.setText("");
		costExpense.setBounds(175,350,400,200);
		costExpense.setFont(new Font("맑은 고딕",Font.BOLD,15));
		costExpense.setBorder(new LineBorder(Color.black));
		panel.add(costExpense);
		
		costTotalTag.setBounds(50,350,100,50);
		costTotalTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costTotalTag);
		costTotal.setText("");
		costTotal.setBounds(175,350,400,200);
		costTotal.setFont(new Font("맑은 고딕",Font.BOLD,15));
		costTotal.setBorder(new LineBorder(Color.black));
		panel.add(costTotal);
		
		// 확인 버튼
		updateButton.setBounds(310,600,100,30);
		updateButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(updateButton);
		
		this.add(panel);
		
		updateButton.setEnabled(false);
		
		this.setVisible(true);
	}
	
	public void hrInsert(MainFrame mf) {
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
		
		// 등록할 직원 프로젝트명, 회사명, 이름, 사번, 등급, 나이, 졸업, 연봉
		hrProjectNameTag.setBounds(50,125,100,50);
		hrProjectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrProjectNameTag);
		hrProjectName.setText("");
		hrProjectName.setBounds(175,125,400,50);
		hrProjectName.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hrProjectName.setBorder(new LineBorder(Color.black));
		panel.add(hrProjectName);
		
		hrCompanyNameTag.setBounds(50,200,100,50);
		hrCompanyNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrCompanyNameTag);
		hrCompanyName.setText("");
		hrCompanyName.setBounds(175,200,400,50);
		hrCompanyName.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hrCompanyName.setBorder(new LineBorder(Color.black));
		panel.add(hrCompanyName);
		
		hrNameTag.setBounds(50,275,100,50);
		hrNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrNameTag);
		hrName.setText("");
		hrName.setBounds(175,275,400,50);
		hrName.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hrName.setBorder(new LineBorder(Color.black));
		panel.add(hrName);
		
		hrIdenNumTag.setBounds(50,350,100,50);
		hrIdenNumTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrIdenNumTag);
		hrIdenNum.setText("");
		hrIdenNum.setBounds(175,350,400,200);
		hrIdenNum.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hrIdenNum.setBorder(new LineBorder(Color.black));
		panel.add(hrIdenNum);
		
		hrLevelTag.setBounds(50,350,100,50);
		hrLevelTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrLevelTag);
		hrLevel.setText("");
		hrLevel.setBounds(175,350,400,200);
		hrLevel.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hrLevel.setBorder(new LineBorder(Color.black));
		panel.add(hrLevel);

		hrAgeTag.setBounds(50,350,100,50);
		hrAgeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrAgeTag);
		hrAge.setText("");
		hrAge.setBounds(175,350,400,200);
		hrAge.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hrAge.setBorder(new LineBorder(Color.black));
		panel.add(hrAge);
		
		hrGraduateTag.setBounds(50,350,100,50);
		hrGraduateTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrGraduateTag);
		hrGraduate.setText("");
		hrGraduate.setBounds(175,350,400,200);
		hrGraduate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hrGraduate.setBorder(new LineBorder(Color.black));
		panel.add(hrGraduate);
		
		hrSalaryTag.setBounds(50,350,100,50);
		hrSalaryTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrSalaryTag);
		hrSalary.setText("");
		hrSalary.setBounds(175,350,400,200);
		hrSalary.setFont(new Font("맑은 고딕",Font.BOLD,15));
		hrSalary.setBorder(new LineBorder(Color.black));
		panel.add(hrSalary);
		
		// 확인 버튼
		insertButton.setBounds(310,600,100,30);
		insertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(insertButton);
		
		this.add(panel);
		
		insertButton.setEnabled(false);
		
		this.setVisible(true);
	}
	
	public void scheduleInsert(MainFrame mf) {
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
		
		estTag.setBounds(50,200,100,50);
		estTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(estTag);
		est.setText("");
		est.setBounds(175,200,400,50);
		est.setFont(new Font("맑은 고딕",Font.BOLD,15));
		est.setBorder(new LineBorder(Color.black));
		panel.add(est);
		
		typeTag.setBounds(50,275,100,50);
		typeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(typeTag);
		type.setText("");
		type.setBounds(175,275,400,50);
		type.setFont(new Font("맑은 고딕",Font.BOLD,15));
		type.setBorder(new LineBorder(Color.black));
		panel.add(type);
		
		employeeTag.setBounds(50,350,100,50);
		employeeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(employeeTag);
		employee.setText("");
		employee.setBounds(175,350,400,200);
		employee.setFont(new Font("맑은 고딕",Font.BOLD,15));
		employee.setBorder(new LineBorder(Color.black));
		panel.add(employee);
		
		// 확인 버튼
		insertButton.setBounds(310,600,100,30);
		insertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(insertButton);
		
		this.add(panel);
		
		insertButton.setEnabled(false);
		
		this.setVisible(true);
	}
	
	public void taskInsert(MainFrame mf) {
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
		
		estTag.setBounds(50,200,100,50);
		estTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(estTag);
		est.setText("");
		est.setBounds(175,200,400,50);
		est.setFont(new Font("맑은 고딕",Font.BOLD,15));
		est.setBorder(new LineBorder(Color.black));
		panel.add(est);
		
		typeTag.setBounds(50,275,100,50);
		typeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(typeTag);
		type.setText("");
		type.setBounds(175,275,400,50);
		type.setFont(new Font("맑은 고딕",Font.BOLD,15));
		type.setBorder(new LineBorder(Color.black));
		panel.add(type);
		
		employeeTag.setBounds(50,350,100,50);
		employeeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(employeeTag);
		employee.setText("");
		employee.setBounds(175,350,400,200);
		employee.setFont(new Font("맑은 고딕",Font.BOLD,15));
		employee.setBorder(new LineBorder(Color.black));
		panel.add(employee);
		
		// 확인 버튼
		insertButton.setBounds(310,600,100,30);
		insertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(insertButton);
		
		this.add(panel);
		
		insertButton.setEnabled(false);
		
		this.setVisible(true);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == insertProjectName || e.getSource() == est || e.getSource() == type || e.getSource() == employee) {
			insertButton.setEnabled(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateButton) {
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
}
