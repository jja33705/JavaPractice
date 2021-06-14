package dictionary;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dictionary extends JFrame implements ActionListener {
	private JTextField textField;
	private JButton searchButton;
	private JButton insertButton;
	
	private Map<String, String> dictionary;
	
	private Connection connection;
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver";
	
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/dictionary";
	
	private static final String DB_USER = "root";
	
	private static final String DB_PASSWORD = "wkdwogus1";
	
	public Dictionary() {
		dictionary = new HashMap<String, String>();
		
		connectToDB();
		
		JPanel panel = new JPanel();
		
		textField = new JTextField(30);
		panel.add(textField);
		
		searchButton = new JButton("검색");
		searchButton.addActionListener(this);
		panel.add(searchButton);
		
		insertButton = new JButton("추가");
		insertButton.addActionListener(this);
		panel.add(insertButton);
		
		this.add(panel);
		
		this.setSize(new Dimension(600, 80));
		
		this.setVisible(true);
	}
	
	private void connectToDB() {
		try {
			Class.forName(JDBC_CLASS_NAME);
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "SELECT * FROM words;";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				dictionary.put(resultSet.getString("kor"), resultSet.getString("eng"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Dictionary();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = textField.getText();
		if(e.getSource() == searchButton) {
			String value = dictionary.get(key);
			if(value == null) {
				JOptionPane.showMessageDialog(this, "해당하는 단어를 찾을 수 없습니다.", key, JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			}
		} else if (e.getSource() == insertButton) {
			try {
				String value = JOptionPane.showInputDialog(this, "key에 해당하는 단어를 입력하세요", key);
				dictionary.put(key, value);
				
				String sql = "INSERT INTO words VALUES(?, ?);";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, value);
				pstmt.setString(2, key);
				pstmt.executeUpdate();
			} catch (SQLException err) {
				err.printStackTrace();
			}
		}
	}
}
