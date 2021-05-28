package JDBC;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener {
	
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver"; //JDBC드라이버 클래스 이름
	
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/OOP3";  //db url
	
	private static final String DB_USER = "root";
	
	private static final String DB_PASSWORD = "wkdwogus1";
	
	private Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME="dict.props";
	
	public SimpleDictionary() {
		this.add(inputField);
		searchBtn.addActionListener(this);
		this.add(searchBtn);
		addBtn.addActionListener(this);
		this.add(addBtn);
		
		this.setPreferredSize(new Dimension(600, 50));
//		buildDictionaryFromFile();
		
		
		// JDBC 드라이버를 메모리에 적재하기
		// JDBC 드라이버 클래스 이름은 DBMS마다 다르다.
		try {
			Class.forName(JDBC_CLASS_NAME); //메모리에 적재
			buildDictionaryFromDB();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void buildDictionaryFromDB() {
		//데이터베이스에 연결하기
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) { //Connection 객체를 리턴한다.
			String sql = "SELECT * FROM dict";
			PreparedStatement pstmt = con.prepareStatement(sql); //PreparedStatement객체는 실행준비(문법검사, 정당성 검사, 실행계획)가 완료된 SQL 객체
			//Insert, Delete, Update문의 실행은 executeUpdate() 메서드를 호출하고 select문의 실행은 executeQuery()메서드를 호출한다.
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String key = rs.getString(1); //re.getString("kor");
				String value = rs.getString("eng");
				dict.put(key, value);
				dict.put(value, key);
				System.out.println(key + " : " + value);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		 
	}
	
	private void buildDictionaryFromFile() {
		Properties props = new Properties();
		try (FileReader fReader = new FileReader(DIC_FILE_NAME)){
			props.load(fReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<Object> set = props.keySet();
		for (Object key: set) {
			Object value = props.get(key);
			dict.put(key.toString(), value.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		System.out.println("[" + key + "]");
		
		if (key.trim().length() == 0) {
			return;
		}
		
		if (e.getSource() == searchBtn) {
			String value = dict.get(key);
			if (value == null) {
				JOptionPane.showMessageDialog(this, "해당 단어를 찾을 수 없습니다", key, JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == addBtn) {
			String value = JOptionPane.showInputDialog(this, key + "에 대응되는 영어단어를 입력하세요", key);
			if (value == null || value.trim().length() == 0) {
				return;
			}
			dict.put(key,  value);
			dict.put(value, key);
//			addWordToFile(key, value);
			addWordToDB(key, value);
			addWordToDB(value, key);
			JOptionPane.showMessageDialog(this, "영어단어가 추가되었습니다", "성공", JOptionPane.INFORMATION_MESSAGE);
		}
		inputField.requestFocus();
		
	}
	
	private void addWordToDB(String key, String value) {
		/* 드라이버를 메모리에 적재한다. <- 메모리 적재는 한 번만 하면 되고,
		 * 이미 생성자에서 했다.
		 * DB에 연결해서 Connection객체를 반환받는다.
		 * Connection객체에게 PreparedStatement 객체를 요청한다.
		 * PreparedStatement 객체의 executeUpdate() 메서드를 호출해서 DB에 저장한다.
		 */
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "INSERT INTO dict VALUES(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			/*
			 * 실행 준비
			 * 	1. 문법검사
			 * 	2. 정당성검사(테이블, 칼럼 등이 실제로 있는지, 있다면 이 사용자가 레코드를  삽입할 권한이 있는지
			 *  3. 실행계획을 세운다. (execution plan)
			 */
			
			pstmt.setString(1, key);
			pstmt.setString(2, value);
			/* ?자리의 컬럼 데이터 타입에 따라 적절한 setXXX() 메서드를 호출해야 한다.
			 * 예를 들어, 칼럼이 CHAR 또는 VARCHAR타입이면 setString()
			 * 칼럼이 TIMESTAMP타입이면 setDate(), setTimestamp(),
			 * 칼럼이 INT 타입이면 setInt()...
			 */
			pstmt.executeUpdate(); //Insert, Delete, Update문을 실행할 때 호출. 몇개의 로우가 영향을 받는지 반환
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void addWordToFile(String key, String value) {
		try (FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true)) { //두번째 매개변수가 false거나 없으면 덮어쓴다.
			String str = key + "=" + value + "\n" + value + "=" + key + "\n";
			fWriter.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new SimpleDictionary());
		frame.setTitle("나의 한영사전");
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/* 1. DBMS 설치 (MariaDB, Oracle, MySQL, ...)
 * 2. HeidiSQL, MySQL Workbench 등의 DB 클라이언트 프로그램 설치(옵션)
 * 3. HeidiSQL을 통해 DB 서버에 연결하고 내가 사용할 데이터베이스 생성(문자집합 설정 주의)
 * 	  그 데이터베이스 사전 정보를 저장할 테이블 생성
 * 4. JDBC 드라이버를 다운로드 받기
 * 5. 개발환경에 그 드라이버 추가하기
 * 6. JDBC 응용프로그램 작성
 * 	  (1) JDBC 드라이버를 메모리에 적재하기
 * 	  (2) Database 서버와 연결하기. 연결성공하면 Connection객체로 반환된다.
 * 	  (3) Connection객체에게 Statement객체 또는 PreparedStatement객체를 요구
 * 	  (4) PreparedStatement객체를 통해 SQL문 실행 (Insert, Delete, Update, Select)
 * 	  (5) Database 서버와 연결 끊기.
 * 
 * 요즘은 Framework을 많이 이용. Java는 Spring Framework.
 * ORM(Object Relation Mapping) Framework. (Hibernate, MyBatis, Eloquent)
 * 
 */