package View;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.linkedDTO.CompanyDAO;
import DAO.linkedOther.CreateTableCompanyDAO;
import DAO.linkedOther.SummaryListDAO;
import DTO.CompanyDTO;
import DTO.ProjectDTO;

public class CompanyFrame extends JFrame{
	JPanel panel = null;
	JButton mainButton = new JButton("R&D Management Program");
	List companyList = new List();
	JButton insertButton = new JButton("회사추가");
	JButton detailButton = new JButton("상세설정");
	JButton deleteButton = new JButton("회사삭제");
	JButton backButton = new JButton("←");
	JButton closeButton = new JButton("Ⅹ");
	JLabel logo = new JLabel();
	CompanyDAO cDAO = new CompanyDAO();
	SummaryListDAO unlinkedDAO = new SummaryListDAO();
	int selNum = 0;
	String projectName = null;
	String companyName = null;
	ArrayList<CompanyDTO> companyNameList = null;
	
	public void setCompanyFrame(String pN, JPanel panel1) {
		projectName = pN;
		panel = panel1;
		
		// 패널 설정
		panel.setLayout(null);
		
		// 기본 설정 버튼
		mainButton.setBounds(175,135,400,40);
		mainButton.setFont(new Font("나눔명조",Font.BOLD,25));
		panel.add(mainButton);
		backButton.setBounds(575,135,50,40);
		backButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(backButton);
		closeButton.setBounds(625,135,50,40);
		closeButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(closeButton);
		
		// DB에서 꺼낸 리스트 입력
		companyList.setBounds(175,175,500,450);
		companyList.setFont(new Font("나눔명조",Font.PLAIN,25));
		loadCompanyList();
		
		// 회사추가 상세설정 회사삭제 버튼 생성
		insertButton.setBounds(175,625,167,50);
		insertButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(insertButton);
		detailButton.setBounds(342,625,167,50);
		detailButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(detailButton);
		deleteButton.setBounds(509,625,166,50);
		deleteButton.setFont(new Font("나눔명조",Font.BOLD,15));
		panel.add(deleteButton);
		
	}
	
	// 회사이름 리스트 띄우기
	public void loadCompanyList() {
		companyList.removeAll();
		companyNameList = cDAO.list(projectName);
		for (int i = 0; i < companyNameList.size(); i++) {
			companyList.add(companyNameList.get(i).toString());
		}
		panel.add(companyList);
	}
	
	
}
