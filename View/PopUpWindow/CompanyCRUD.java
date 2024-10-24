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

import DAO.linkedDTO.OrganizationDAO;
import DAO.linkedDTO._DAOSuper;
import DTO.OrganizationDTO;
import View.StartView.MainFrame;

public class CompanyCRUD extends JFrame implements ActionListener, ItemListener{
	private JPanel panel = new JPanel();
	
	private JButton orgInsertButton = new JButton("등록·수정");
	private JButton orgDeleteButton = new JButton("삭제");
	
	private JTextArea data1 = new JTextArea();
	private JTextArea data2 = new JTextArea();
	private JTextArea data3 = new JTextArea();
	private JTextArea data4 = new JTextArea();
	private JTextArea data5 = new JTextArea();
	private JTextArea data6 = new JTextArea();
	
	private JLabel orgNameTag = new JLabel("회사명");
	private JLabel estTag = new JLabel("설립연도(0000년00월)");
	private JLabel typeTag = new JLabel("규모(중소·중견·대·공기업)");
	private JLabel employeeTag = new JLabel("직원수");
	private JLabel addressTag = new JLabel("주소");
	private JLabel introTag = new JLabel("회사소개");
	
	List organizationList = new List();
	ArrayList<OrganizationDTO> organizationNameList = null;
	OrganizationDAO DAO = null;
	OrganizationDTO orgDTO = null;
	MainFrame mainFrame = null;
	
	int selNum = 0;
	
	public CompanyCRUD() {
		orgInsertButton.addActionListener(this);
		orgDeleteButton.addActionListener(this);
		organizationList.addItemListener(this);
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
		JLabel title = new JLabel("관리할 회사 이름, 설립연도, 규모, 직원수, 주소, 개요", JLabel.CENTER);
		title.setBounds(0,25,700,25);
		title.setFont(new Font("맑은 고딕",Font.BOLD,25));
		panel.add(title);
		
		// 현재 등록된 회사 리스트
		organizationList.setBounds(50,75,650,150);
		organizationList.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		loadOrganizationList();
		
		// 등록할 회사 이름, 설립연도, 규모, 직원수, 주소, 개요
		orgNameTag.setBounds(50,250,175,25);
		orgNameTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgNameTag);
		data1.setText("");
		data1.setBounds(250,250,450,25);
		data1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data1.setBorder(new LineBorder(Color.black));
		panel.add(data1);
		
		estTag.setBounds(50,300,175,25);
		estTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(estTag);
		data2.setText("");
		data2.setBounds(250,300,450,25);
		data2.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data2.setBorder(new LineBorder(Color.black));
		panel.add(data2);
		
		typeTag.setBounds(50,350,175,25);
		typeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(typeTag);
		data3.setText("");
		data3.setBounds(250,350,450,25);
		data3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data3.setBorder(new LineBorder(Color.black));
		panel.add(data3);
		
		employeeTag.setBounds(50,400,175,25);
		employeeTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(employeeTag);
		data4.setText("");
		data4.setBounds(250,400,450,25);
		data4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data4.setBorder(new LineBorder(Color.black));
		panel.add(data4);
		
		addressTag.setBounds(50,450,175,25);
		addressTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(addressTag);
		data5.setText("");
		data5.setBounds(250,450,450,25);
		data5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data5.setBorder(new LineBorder(Color.black));
		panel.add(data5);
		
		introTag.setBounds(50,500,175,25);
		introTag.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(introTag);
		data6.setText("");
		data6.setBounds(250,500,450,100);
		data6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		data6.setBorder(new LineBorder(Color.black));
		panel.add(data6);
		
		data6.setLineWrap(true);
		
		// 등록·수정 및 삭제 버튼
		orgInsertButton.setBounds(290,625,175,30);
		orgInsertButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgInsertButton);
		orgDeleteButton.setBounds(600,625,100,30);
		orgDeleteButton.setFont(new Font("맑은 고딕",Font.BOLD,15));
		panel.add(orgDeleteButton);
		
		this.add(panel);
		
		this.setVisible(true);
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == orgInsertButton) {
			// 프로젝트추가 메서드
			OrganizationDTO insertDTO = new OrganizationDTO();
			insertDTO.setOrganizationName(data1.getText());
			insertDTO.setOrganizationEstablishment(data2.getText());
			insertDTO.setOrganizationType(data3.getText());
			insertDTO.setOrganizationTotalEmployee(Integer.valueOf(data4.getText()));
			insertDTO.setOrganizationAddress(data5.getText());
			insertDTO.setOrganizationIntro(data6.getText());
			for (int i = 0; i < organizationNameList.size(); i++) {
				if (insertDTO.getOrganizationName().equals(organizationNameList.get(i).getOrganizationName())) {
					DAO.update(insertDTO);
				} else {
					DAO.insert(insertDTO);
				}
			}
			mainFrame.select("ProjectPanel");
			dispose();
		} else if (e.getSource() == orgDeleteButton) {
			OrganizationDTO insertDTO = new OrganizationDTO();
			insertDTO.setOrganizationName(data1.getText());
			insertDTO.setOrganizationEstablishment(data2.getText());
			insertDTO.setOrganizationType(data3.getText());
			insertDTO.setOrganizationTotalEmployee(Integer.valueOf(data4.getText()));
			insertDTO.setOrganizationAddress(data5.getText());
			insertDTO.setOrganizationIntro(data6.getText());
			DAO.delete(insertDTO);
			mainFrame.select("ProjectPanel");
			dispose();
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		selNum = organizationList.getSelectedIndex();
		orgDTO = organizationNameList.get(selNum);
		data1.setText(orgDTO.getOrganizationName());
		data2.setText(orgDTO.getOrganizationEstablishment());
		data3.setText(orgDTO.getOrganizationType());
		data4.setText(String.valueOf(orgDTO.getOrganizationTotalEmployee()));
		data5.setText(orgDTO.getOrganizationAddress());
		data6.setText(orgDTO.getOrganizationIntro());
		this.remove(panel);
		panel.add(data1);
		this.add(panel);
	}
}
