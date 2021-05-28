package JDBC;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class GameScoreManager extends JFrame implements ActionListener {
	private JTextField nameField, scoreField;
	private JButton submitButton;
	private MyTableModel model;
	private JTable table;
	
	public GameScoreManager() {
		this.setTitle("명예의 전당");
		this.setSize(600, 300);
		
		model = new MyTableModel();
		model.fillTable();
		
		JLabel label = new JLabel("명예의 전당", JLabel.CENTER);
		label.setFont(new Font("SansSerif", Font.PLAIN, 30));
		this.add(label, BorderLayout.NORTH);
		
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setPreferredSize(new Dimension(500, 200));
		this.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("이름"));
		nameField = new JTextField(10);
		panel.add(nameField);
		panel.add(new JLabel("점수"));
		scoreField = new JTextField(10);
		panel.add(scoreField);
		submitButton = new JButton("점수 제출");
		submitButton.addActionListener(this);
		panel.add(submitButton);
		this.add(panel, BorderLayout.SOUTH);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameScoreManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameField.getText();
		String score = scoreField.getText();
		
		try (Connection con = makeConnection()) {
			String sql = "INSERT INTO gamescore VALUES (?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, score);
			
			pstmt.executeUpdate();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		
		model.fillTable();
		
	}
	class MyTableModel extends AbstractTableModel {
		private String[] columnNames = {"이름", "점수"};
		private static final int ROWS = 10;
		private static final int COLS = 2;
		Object[][] data = new String[ROWS][COLS];
		
		@Override
		public int getRowCount() {
			return data.length;
		}
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}
		
		public void fillTable() {
			try(Connection con = makeConnection()) {
				String sql = "SELECT * FROM gamescore ORDER BY score DESC LIMIT " + ROWS;
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				int row = 0;
				while (rs.next()) {
					data[row][0] = rs.getString("name");
					data[row][1] = rs.getString("score");
					System.out.println(Arrays.toString(data[row]));
					row++;
				}
				this.fireTableDataChanged();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		@Override
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			this.fireTableCellUpdated(row, col);
		}
		
		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
	
	public static Connection makeConnection() throws Exception {
		String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver"; //JDBC드라이버 클래스 이름
		
		String DB_URL = "jdbc:mariadb://localhost:3306/OOP3";  //db url
		
		String DB_USER = "root";
		
		String DB_PASSWORD = "wkdwogus1";
		
		Class.forName(JDBC_CLASS_NAME);
		System.out.println("드라이버 적재 성공");
		
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		System.out.println("데이터베이스 연결 성공");
		
		return con;
	}
}
