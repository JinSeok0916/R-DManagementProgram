package View.PopUpWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import DAO.linkedDTO.CostDAO;
import DAO.linkedDTO.HumanResourceDAO;
import DAO.linkedDTO.OrganizationDAO;
import DAO.linkedDTO.ParticipatingOrganizationDAO;
import DAO.linkedDTO.ScheduleDAO;
import DAO.linkedDTO.TaskDAO;
import DAO.linkedDTO._DAOSuper;
import DTO.CostDTO;
import DTO.HumanResourceDTO;
import DTO.OrganizationDTO;
import DTO.ParticipatingOrganizationDTO;
import DTO.ProjectDTO;
import DTO.ScheduleDTO;
import DTO.TaskDTO;
import View.StartView.MainFrame;

public class CompanyDetailCRUD extends JFrame implements ActionListener, ItemListener{
	private JPanel panel = new JPanel();
	private JButton porgInsertButton = new JButton("확인");
	private JButton orgInsertButton = new JButton("확인");
	private JButton costInsertButton = new JButton("확인");
	private JButton hrInsertButton = new JButton("확인");
	private JButton schInsertButton = new JButton("확인");
	private JButton taskInsertButton = new JButton("확인");
	
	private JTextArea data1 = new JTextArea();
	private JTextArea data2 = new JTextArea();
	private JTextArea data3 = new JTextArea();
	private JTextArea data4 = new JTextArea();
	private JTextArea data5 = new JTextArea();
	private JTextArea data6 = new JTextArea();
	private JTextArea data7 = new JTextArea();
	private JTextArea data8 = new JTextArea();
	private JTextArea data9 = new JTextArea();
	
	private JLabel projectNameTag = new JLabel("프로젝트명(수정불가)");
	private JLabel orgNameTag = new JLabel("회사명(수정불가)");
	private JLabel budgetTag = new JLabel("예산");
	
	private JLabel estTag = new JLabel("설립연도");
	private JLabel typeTag = new JLabel("규모");
	private JLabel employeeTag = new JLabel("직원수");
	private JLabel addressTag = new JLabel("주소");
	private JLabel introTag = new JLabel("회사소개");
	
	private JLabel costDateTag = new JLabel("날짜");
	private JLabel costMaterialTag = new JLabel("재료비");
	private JLabel costLaborTag = new JLabel("노무비");
	private JLabel costExpenseTag = new JLabel("경비");
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
	private JLabel schCompleteTask = new JLabel("완료한 업무");
	private JLabel schRDFCT = new JLabel("잔여업무 처리소요일수");
	private JLabel schRatio = new JLabel("진척도");
	
	private JLabel taskName = new JLabel("업무명");
	private JLabel taskPriority = new JLabel("우선도");
	private JLabel taskDate = new JLabel("업무처리 필요일수");
	private JLabel taskProgress = new JLabel("업무수행여부(true/false)");
	
	private _DAOSuper DAO = null;
	
	MainFrame mainFrame = null;
	
	List organizationList = new List();
	ArrayList<OrganizationDTO> organizationNameList = null;
	ParticipatingOrganizationDTO porgDTO = null;
	OrganizationDTO orgDTO = null;
	ProjectDTO projectDTO= null;
	Object DTO = null;
	
	int selNum = 0;
	
	public CompanyDetailCRUD(MainFrame mf, Object DTO) {
		mainFrame = mf;
		porgDTO = (ParticipatingOrganizationDTO) DTO;
		
		porgInsertButton.addActionListener(this);
		costInsertButton.addActionListener(this);
		hrInsertButton.addActionListener(this);
		schInsertButton.addActionListener(this);
		taskInsertButton.addActionListener(this);
		organizationList.addItemListener(this);
	}
	
	public void porgInsert(Object DTO) {
		projectDTO = (ProjectDTO) DTO;
		
		panel.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 현재 창
		JLabel title = new JLabel("등록할 프로젝트 이름, 회사 이름, 예산");
		title.setBounds(50,25,700,25);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
		panel.add(title);
		
		organizationList.setBounds(50,75,650,150);
		organizationList.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		loadOrganizationList();
		
		// 등록할 회사 이름, 설립연도, 규모, 직원수, 주소, 개요
		projectNameTag.setBounds(50,250,175,25);
		projectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectNameTag);
		data1.setText(projectDTO.getProjectName());
		data1.setBounds(250,250,400,25);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		orgNameTag.setBounds(50,300,175,25);
		orgNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgNameTag);
		data2.setText("");
		data2.setBounds(250,300,400,25);
		data2.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data2.setBorder(new LineBorder(Color.black));
		panel.add(data2);
		
		budgetTag.setBounds(50,350,175,25);
		budgetTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(budgetTag);
		data3.setText("");
		data3.setBounds(250,350,400,25);
		data3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data3.setBorder(new LineBorder(Color.black));
		panel.add(data3);
		
		// 확인 버튼
		porgInsertButton.setBounds(290,625,175,30);
		porgInsertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(porgInsertButton);
		
		data1.setEnabled(false);
		data2.setEnabled(false);
		
		this.add(panel);
		
		this.setVisible(true);
	}

	public void orgInsert() {
		panel.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 현재 창
		JLabel title = new JLabel("등록할 회사 이름, 설립연도, 규모, 직원수, 주소, 개요", JLabel.CENTER);
		title.setBounds(0,25,700,25);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
		panel.add(title);
		
		// 등록할 회사 이름, 설립연도, 규모, 직원수, 주소, 개요
		orgNameTag.setBounds(50,100,175,25);
		orgNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgNameTag);
		data1.setText(((OrganizationDTO) DTO).getOrganizationName());
		data1.setBounds(250,100,400,25);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		data1.setEnabled(false);
		
		estTag.setBounds(50,150,175,25);
		estTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(estTag);
		data2.setText(((OrganizationDTO) DTO).getOrganizationEstablishment());
		data2.setBounds(250,150,400,25);
		data2.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data2.setBorder(new LineBorder(Color.black));
		panel.add(data2);
		
		typeTag.setBounds(50,200,175,25);
		typeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(typeTag);
		data3.setText(((OrganizationDTO) DTO).getOrganizationType());
		data3.setBounds(250,200,400,25);
		data3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data3.setBorder(new LineBorder(Color.black));
		panel.add(data3);
		
		employeeTag.setBounds(50,250,175,25);
		employeeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(employeeTag);
		data4.setText(String.valueOf(((OrganizationDTO) DTO).getOrganizationTotalEmployee()));
		data4.setBounds(250,250,400,25);
		data4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data4.setBorder(new LineBorder(Color.black));
		panel.add(data4);
		
		addressTag.setBounds(50,300,175,25);
		addressTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(addressTag);
		data5.setText(((OrganizationDTO) DTO).getOrganizationAddress());
		data5.setBounds(250,300,400,25);
		data5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data5.setBorder(new LineBorder(Color.black));
		panel.add(data5);
		
		introTag.setBounds(50,350,175,25);
		introTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(introTag);
		data6.setText(((OrganizationDTO) DTO).getOrganizationIntro());
		data6.setBounds(250,350,400,100);
		data6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data6.setBorder(new LineBorder(Color.black));
		panel.add(data6);
		
		data6.setLineWrap(true);
		
		// 확인 버튼
		orgInsertButton.setBounds(310,625,100,30);
		orgInsertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgInsertButton);
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public void costInsert() {
		panel.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 현재 창
		JLabel title = new JLabel("등록할 예산 이름, 날짜, 재료비, 노무비, 경비, 총액", JLabel.CENTER);
		title.setBounds(165,25,400,25);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
		panel.add(title);
		
		// 등록할 예산 이름, 날짜, 재료비, 노무비, 경비, 총액
		projectNameTag.setBounds(50,100,175,25);
		projectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectNameTag);
		data1.setText(porgDTO.getProjectName());
		data1.setBounds(250,100,400,25);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		orgNameTag.setBounds(50,150,175,25);
		orgNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgNameTag);
		data2.setText(((CostDTO) DTO).getOrganizationName());
		data2.setBounds(250,150,400,25);
		data2.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data2.setBorder(new LineBorder(Color.black));
		panel.add(data2);
		
		data1.setEnabled(false);
		data2.setEnabled(false);
		
		costDateTag.setBounds(50,200,175,25);
		costDateTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costDateTag);
		data3.setText(((CostDTO) DTO).getDate());
		data3.setBounds(250,200,400,25);
		data3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data3.setBorder(new LineBorder(Color.black));
		panel.add(data3);
		
		costMaterialTag.setBounds(50,250,175,25);
		costMaterialTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costMaterialTag);
		data4.setText(String.valueOf(((CostDTO) DTO).getMaterialCost()));
		data4.setBounds(250,250,400,25);
		data4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data4.setBorder(new LineBorder(Color.black));
		panel.add(data4);
		
		costLaborTag.setBounds(50,300,175,25);
		costLaborTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costLaborTag);
		data5.setText(String.valueOf(((CostDTO) DTO).getLaborCost()));
		data5.setBounds(250,300,400,25);
		data5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data5.setBorder(new LineBorder(Color.black));
		panel.add(data5);
		
		costExpenseTag.setBounds(50,350,175,25);
		costExpenseTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costExpenseTag);
		data6.setText(String.valueOf(((CostDTO) DTO).getExpenseCost()));
		data6.setBounds(250,350,400,25);
		data6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data6.setBorder(new LineBorder(Color.black));
		panel.add(data6);
		
		costTotalTag.setBounds(50,400,175,25);
		costTotalTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costTotalTag);
		data7.setText(String.valueOf(((CostDTO) DTO).getTotalCost()));
		data7.setBounds(250,400,400,25);
		data7.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data7.setBorder(new LineBorder(Color.black));
		panel.add(data7);
		
		// 확인 버튼
		costInsertButton.setBounds(310,625,100,30);
		costInsertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(costInsertButton);
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public void hrInsert() {
		panel.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 현재 창
		JLabel title = new JLabel("등록할 직원 프로젝트명, 회사명, 이름, 사번, 등급, 나이, 학력, 연봉", JLabel.CENTER);
		title.setBounds(165,25,400,25);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
		panel.add(title);
		
		// 등록할 직원 프로젝트명, 회사명, 이름, 사번, 등급, 나이, 학력, 연봉
		projectNameTag.setBounds(50,100,175,25);
		projectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectNameTag);
		data1.setText(porgDTO.getProjectName());
		data1.setBounds(250,100,400,25);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		orgNameTag.setBounds(50,150,175,25);
		orgNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgNameTag);
		data2.setText(((HumanResourceDTO) DTO).getOrganizationName());
		data2.setBounds(250,150,400,25);
		data2.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data2.setBorder(new LineBorder(Color.black));
		panel.add(data2);
		
		data1.setEnabled(false);
		data2.setEnabled(false);
		
		hrNameTag.setBounds(50,200,175,25);
		hrNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrNameTag);
		data3.setText(((HumanResourceDTO) DTO).getParticipatingWorkforce());
		data3.setBounds(250,200,400,25);
		data3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data3.setBorder(new LineBorder(Color.black));
		panel.add(data3);
		
		hrIdenNumTag.setBounds(50,250,175,25);
		hrIdenNumTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrIdenNumTag);
		data4.setText(((HumanResourceDTO) DTO).getIdenNumber());
		data4.setBounds(250,250,400,25);
		data4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data4.setBorder(new LineBorder(Color.black));
		panel.add(data4);
		
		hrLevelTag.setBounds(50,300,175,25);
		hrLevelTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrLevelTag);
		data5.setText(((HumanResourceDTO) DTO).getLevel());
		data5.setBounds(250,300,400,25);
		data5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data5.setBorder(new LineBorder(Color.black));
		panel.add(data5);

		hrAgeTag.setBounds(50,350,175,25);
		hrAgeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrAgeTag);
		data6.setText(String.valueOf(((HumanResourceDTO) DTO).getAge()));
		data6.setBounds(250,350,400,25);
		data6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data6.setBorder(new LineBorder(Color.black));
		panel.add(data6);
		
		hrGraduateTag.setBounds(50,400,175,25);
		hrGraduateTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrGraduateTag);
		data7.setText(((HumanResourceDTO) DTO).getGraduate());
		data7.setBounds(250,400,400,25);
		data7.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data7.setBorder(new LineBorder(Color.black));
		panel.add(data7);
		
		hrSalaryTag.setBounds(50,450,175,25);
		hrSalaryTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrSalaryTag);
		data8.setText(String.valueOf(((HumanResourceDTO) DTO).getSalary()));
		data8.setBounds(250,450,400,25);
		data8.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data8.setBorder(new LineBorder(Color.black));
		panel.add(data8);
		
		// 확인 버튼
		hrInsertButton.setBounds(310,625,100,30);
		hrInsertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(hrInsertButton);
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public void schInsert() {
		panel.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 현재 창
		JLabel title = new JLabel("등록할 일정 프로젝트명, 회사명, 날짜, 총일수, 남은일수, 총업무, 완료한 업무, 잔여업무 처리소요일수, 진척도", JLabel.CENTER);
		title.setBounds(165,25,400,25);
		title.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(title);
		
		// 등록할 일정 날짜, 총일수, 남은일수, 총업무, 완료한 업무, 잔여업무 처리소요일수, 진척도
		projectNameTag.setBounds(50,100,175,25);
		projectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectNameTag);
		data1.setText(porgDTO.getProjectName());
		data1.setBounds(250,100,400,25);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		data1.setEnabled(false);
		data2.setEnabled(false);
		
		orgNameTag.setBounds(50,150,175,25);
		orgNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgNameTag);
		data2.setText(String.valueOf(((ScheduleDTO)DTO).getOrganizationName()));
		data2.setBounds(250,150,400,25);
		data2.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data2.setBorder(new LineBorder(Color.black));
		panel.add(data2);
		
		schDate.setBounds(50,200,175,25);
		schDate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(schDate);
		data3.setText(String.valueOf(((ScheduleDTO)DTO).getDate()));
		data3.setBounds(250,200,400,25);
		data3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data3.setBorder(new LineBorder(Color.black));
		panel.add(data3);
		
		schTotalDate.setBounds(50,250,175,25);
		schTotalDate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(schTotalDate);
		data4.setText(String.valueOf(((ScheduleDTO)DTO).getTotalDate()));
		data4.setBounds(250,250,400,25);
		data4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data4.setBorder(new LineBorder(Color.black));
		panel.add(data4);
		
		schRestDate.setBounds(50,300,175,25);
		schRestDate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(schRestDate);
		data5.setText(String.valueOf(((ScheduleDTO)DTO).getRestDate()));
		data5.setBounds(250,300,400,25);
		data5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data5.setBorder(new LineBorder(Color.black));
		panel.add(data5);
		
		schTotalTask.setBounds(50,350,175,25);
		schTotalTask.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(schTotalTask);
		data6.setText(String.valueOf(((ScheduleDTO)DTO).getTotalTaskCount()));
		data6.setBounds(250,350,400,25);
		data6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data6.setBorder(new LineBorder(Color.black));
		panel.add(data6);
		
		schCompleteTask.setBounds(50,400,175,25);
		schCompleteTask.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(schCompleteTask);
		data7.setText(String.valueOf(((ScheduleDTO)DTO).getCompleteTaskCount()));
		data7.setBounds(250,400,400,25);
		data7.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data7.setBorder(new LineBorder(Color.black));
		panel.add(data7);
		
		schRDFCT.setBounds(50,450,175,25);
		schRDFCT.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(schRDFCT);
		data8.setText(String.valueOf(((ScheduleDTO)DTO).getRequiredDateForCompleteTask()));
		data8.setBounds(250,450,400,25);
		data8.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data8.setBorder(new LineBorder(Color.black));
		panel.add(data8);
		
		schRatio.setBounds(50,500,175,25);
		schRatio.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(schRatio);
		data9.setText(String.valueOf(((ScheduleDTO)DTO).getRequiredDateForCompleteTaskPerRestDate()));
		data9.setBounds(250,500,400,25);
		data9.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data9.setBorder(new LineBorder(Color.black));
		panel.add(data9);
		
		// 확인 버튼
		schInsertButton.setBounds(310,625,100,30);
		schInsertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(schInsertButton);
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public void taskInsert() {
		panel.removeAll();
		this.setVisible(false);
		this.setVisible(true);
		
		this.setBounds(250,150,765,765);
		// 패널 나누기
		panel.setLayout(null);
		
		// 현재 창
		JLabel title = new JLabel("등록할 업무 프로젝트명, 회사명, 업무명, 우선도, 업무처리 필요일수, 업무 수행 여부", JLabel.CENTER);
		title.setBounds(165,25,400,25);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
		panel.add(title);
		
		// 등록할 업무 프로젝트명, 회사명, 업무명, 우선도, 업무처리 필요일수, 업무 수행 여부
		projectNameTag.setBounds(50,100,175,25);
		projectNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(projectNameTag);
		data1.setText(porgDTO.getProjectName());
		data1.setBounds(250,100,400,25);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		orgNameTag.setBounds(50,150,175,25);
		orgNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgNameTag);
		data2.setText(((TaskDTO)DTO).getOrganizationName());
		data2.setBounds(250,150,400,25);
		data2.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data2.setBorder(new LineBorder(Color.black));
		panel.add(data2);
		
		data1.setEnabled(false);
		data2.setEnabled(false);
		
		taskName.setBounds(50,200,175,25);
		taskName.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(taskName);
		data3.setText(((TaskDTO)DTO).getTaskName());
		data3.setBounds(250,200,400,25);
		data3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data3.setBorder(new LineBorder(Color.black));
		panel.add(data3);
		
		taskPriority.setBounds(50,250,175,25);
		taskPriority.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(taskPriority);
		data4.setText(((TaskDTO)DTO).getTaskPriority());
		data4.setBounds(250,250,400,25);
		data4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data4.setBorder(new LineBorder(Color.black));
		panel.add(data4);

		taskDate.setBounds(50,300,175,25);
		taskDate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(taskDate);
		data5.setText(String.valueOf(((TaskDTO)DTO).getTaskDate()));
		data5.setBounds(250,300,400,25);
		data5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data5.setBorder(new LineBorder(Color.black));
		panel.add(data5);
		
		taskProgress.setBounds(50,350,175,25);
		taskProgress.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(taskProgress);
		data6.setText(String.valueOf(((TaskDTO)DTO).isTaskProgress()));
		data6.setBounds(250,350,400,25);
		data6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data6.setBorder(new LineBorder(Color.black));
		panel.add(data6);
		
		// 확인 버튼
		taskInsertButton.setBounds(310,625,100,30);
		taskInsertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(taskInsertButton);
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == porgInsertButton) {
			// 프로젝트추가 메서드
			DAO = new ParticipatingOrganizationDAO();
			ParticipatingOrganizationDTO insertDTO = new ParticipatingOrganizationDTO();
			insertDTO.setProjectName(data1.getText());
			insertDTO.setOrganizationName(data2.getText());
			insertDTO.setParticipatingOrganizationBudget(Integer.valueOf(data3.getText()));
			DAO.insert(insertDTO);
			mainFrame.select("CompanyPanel");
			dispose();
		} else if (e.getSource() == orgInsertButton) {
			DAO = new OrganizationDAO();
			OrganizationDTO insertDTO = new OrganizationDTO();
			insertDTO.setOrganizationName(data1.getText());
			insertDTO.setOrganizationEstablishment(data2.getText());
			insertDTO.setOrganizationType(data3.getText());
			insertDTO.setOrganizationTotalEmployee(Integer.valueOf(data4.getText()));
			insertDTO.setOrganizationAddress(data5.getText());
			insertDTO.setOrganizationIntro(data6.getText());
			DAO.insert(insertDTO);
			mainFrame.select("CompanyPanel");
			dispose();
		} else if (e.getSource() == costInsertButton) {
			DAO = new CostDAO();
			CostDTO insertDTO = new CostDTO();
			insertDTO.setProjectName(data1.getText());
			insertDTO.setOrganizationName(data2.getText());
			insertDTO.setDate(data3.getText());
			insertDTO.setMaterialCost(Integer.valueOf(data4.getText()));
			insertDTO.setLaborCost(Integer.valueOf(data5.getText()));
			insertDTO.setExpenseCost(Integer.valueOf(data6.getText()));
			insertDTO.setTotalCost(Integer.valueOf(data7.getText()));
			DAO.insert(insertDTO);
			mainFrame.select("CompanyPanel");
			dispose();
		} else if (e.getSource() == hrInsertButton) {
			DAO = new HumanResourceDAO();
			HumanResourceDTO insertDTO = new HumanResourceDTO();
			insertDTO.setProjectName(data1.getText());
			insertDTO.setOrganizationName(data2.getText());
			insertDTO.setParticipatingWorkforce(data3.getText());
			insertDTO.setIdenNumber(data4.getText());
			insertDTO.setLevel(data5.getText());
			insertDTO.setAge(Integer.valueOf(data6.getText()));
			insertDTO.setGraduate(data7.getText());
			insertDTO.setSalary(Integer.valueOf(data8.getText()));
			DAO.insert(insertDTO);
			mainFrame.select("CompanyPanel");
			dispose();
		} else if (e.getSource() == schInsertButton) {
			DAO = new ScheduleDAO();
			ScheduleDTO insertDTO = new ScheduleDTO();
			insertDTO.setProjectName(data1.getText());
			insertDTO.setOrganizationName(data2.getText());
			insertDTO.setDate(data3.getText());
			insertDTO.setTotalDate(Integer.valueOf(data4.getText()));
			insertDTO.setRestDate(Integer.valueOf(data5.getText()));
			insertDTO.setTotalTaskCount(Integer.valueOf(data6.getText()));
			insertDTO.setCompleteTaskCount(Integer.valueOf(data7.getText()));
			insertDTO.setRequiredDateForCompleteTask(Integer.valueOf(data8.getText()));
			insertDTO.setRequiredDateForCompleteTaskPerRestDate(Integer.valueOf(data9.getText()));
			DAO.insert(insertDTO);
			mainFrame.select("CompanyPanel");
			dispose();
		} else if (e.getSource() == taskInsertButton) {
			DAO = new TaskDAO();
			TaskDTO insertDTO = new TaskDTO();
			insertDTO.setProjectName(data1.getText());
			insertDTO.setOrganizationName(data2.getText());
			insertDTO.setTaskName(data3.getText());
			insertDTO.setTaskPriority(data4.getText());
			insertDTO.setTaskDate(Integer.valueOf(data5.getText()));
			insertDTO.setTaskProgress(Boolean.valueOf(data6.getText()));
			DAO.insert(insertDTO);
			mainFrame.select("CompanyPanel");
			dispose();
		}
	}
	
	public void loadOrganizationList() {
		DAO = new OrganizationDAO();
		organizationList.removeAll();
		organizationNameList = DAO.list(null);
		for (int i = 0; i < organizationNameList.size(); i++) {
			organizationList.add((i+1) + "번 회사 : " + organizationNameList.get(i).getOrganizationName());
		}
		this.add(organizationList);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		selNum = organizationList.getSelectedIndex();
		orgDTO = organizationNameList.get(selNum);
		data2.setText(orgDTO.getOrganizationName());
		this.remove(panel);
		panel.add(data2);
		this.add(panel);
	}
	
	public void selectInsert(int insertNum, Object object) {
		DTO = object;
		System.out.println(DTO.toString());
		if (insertNum == 1) {
			orgInsert();
		} else if (insertNum == 2) {
			costInsert();
		} else if (insertNum == 3) {
			hrInsert();
		} else if (insertNum == 4) {
			schInsert();
		} else if (insertNum == 5) {
			taskInsert();
		}
	}
}
