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
	private JButton searchBtn = new JButton("�˻�");
	private JButton addBtn = new JButton("�߰�");
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver"; //JDBC����̹� Ŭ���� �̸�
	
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
		
		
		// JDBC ����̹��� �޸𸮿� �����ϱ�
		// JDBC ����̹� Ŭ���� �̸��� DBMS���� �ٸ���.
		try {
			Class.forName(JDBC_CLASS_NAME); //�޸𸮿� ����
			buildDictionaryFromDB();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void buildDictionaryFromDB() {
		//�����ͺ��̽��� �����ϱ�
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) { //Connection ��ü�� �����Ѵ�.
			String sql = "SELECT * FROM dict";
			PreparedStatement pstmt = con.prepareStatement(sql); //PreparedStatement��ü�� �����غ�(�����˻�, ���缺 �˻�, �����ȹ)�� �Ϸ�� SQL ��ü
			//Insert, Delete, Update���� ������ executeUpdate() �޼��带 ȣ���ϰ� select���� ������ executeQuery()�޼��带 ȣ���Ѵ�.
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
				JOptionPane.showMessageDialog(this, "�ش� �ܾ ã�� �� �����ϴ�", key, JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == addBtn) {
			String value = JOptionPane.showInputDialog(this, key + "�� �����Ǵ� ����ܾ �Է��ϼ���", key);
			if (value == null || value.trim().length() == 0) {
				return;
			}
			dict.put(key,  value);
			dict.put(value, key);
//			addWordToFile(key, value);
			addWordToDB(key, value);
			addWordToDB(value, key);
			JOptionPane.showMessageDialog(this, "����ܾ �߰��Ǿ����ϴ�", "����", JOptionPane.INFORMATION_MESSAGE);
		}
		inputField.requestFocus();
		
	}
	
	private void addWordToDB(String key, String value) {
		/* ����̹��� �޸𸮿� �����Ѵ�. <- �޸� ����� �� ���� �ϸ� �ǰ�,
		 * �̹� �����ڿ��� �ߴ�.
		 * DB�� �����ؼ� Connection��ü�� ��ȯ�޴´�.
		 * Connection��ü���� PreparedStatement ��ü�� ��û�Ѵ�.
		 * PreparedStatement ��ü�� executeUpdate() �޼��带 ȣ���ؼ� DB�� �����Ѵ�.
		 */
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "INSERT INTO dict VALUES(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			/*
			 * ���� �غ�
			 * 	1. �����˻�
			 * 	2. ���缺�˻�(���̺�, Į�� ���� ������ �ִ���, �ִٸ� �� ����ڰ� ���ڵ带  ������ ������ �ִ���
			 *  3. �����ȹ�� �����. (execution plan)
			 */
			
			pstmt.setString(1, key);
			pstmt.setString(2, value);
			/* ?�ڸ��� �÷� ������ Ÿ�Կ� ���� ������ setXXX() �޼��带 ȣ���ؾ� �Ѵ�.
			 * ���� ���, Į���� CHAR �Ǵ� VARCHARŸ���̸� setString()
			 * Į���� TIMESTAMPŸ���̸� setDate(), setTimestamp(),
			 * Į���� INT Ÿ���̸� setInt()...
			 */
			pstmt.executeUpdate(); //Insert, Delete, Update���� ������ �� ȣ��. ��� �ο찡 ������ �޴��� ��ȯ
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void addWordToFile(String key, String value) {
		try (FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true)) { //�ι�° �Ű������� false�ų� ������ �����.
			String str = key + "=" + value + "\n" + value + "=" + key + "\n";
			fWriter.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new SimpleDictionary());
		frame.setTitle("���� �ѿ�����");
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/* 1. DBMS ��ġ (MariaDB, Oracle, MySQL, ...)
 * 2. HeidiSQL, MySQL Workbench ���� DB Ŭ���̾�Ʈ ���α׷� ��ġ(�ɼ�)
 * 3. HeidiSQL�� ���� DB ������ �����ϰ� ���� ����� �����ͺ��̽� ����(�������� ���� ����)
 * 	  �� �����ͺ��̽� ���� ������ ������ ���̺� ����
 * 4. JDBC ����̹��� �ٿ�ε� �ޱ�
 * 5. ����ȯ�濡 �� ����̹� �߰��ϱ�
 * 6. JDBC �������α׷� �ۼ�
 * 	  (1) JDBC ����̹��� �޸𸮿� �����ϱ�
 * 	  (2) Database ������ �����ϱ�. ���Ἲ���ϸ� Connection��ü�� ��ȯ�ȴ�.
 * 	  (3) Connection��ü���� Statement��ü �Ǵ� PreparedStatement��ü�� �䱸
 * 	  (4) PreparedStatement��ü�� ���� SQL�� ���� (Insert, Delete, Update, Select)
 * 	  (5) Database ������ ���� ����.
 * 
 * ������ Framework�� ���� �̿�. Java�� Spring Framework.
 * ORM(Object Relation Mapping) Framework. (Hibernate, MyBatis, Eloquent)
 * 
 */