package bookViewer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookViewer extends JFrame implements ActionListener {
	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton nextBtn, previouesBtn, insertBtn, finishBtn;
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver";
	
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/java";
	
	private static final String DB_USER = "root";
	
	private static final String DB_PASSWORD = "wkdwogus1";
	
	private Connection connection;
	
	private ResultSet resultSet;
	
	public BookViewer() {
		connectToDB();
		try {
			resultSet = getResultSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setLayout(new GridLayout(0, 2, 5, 5));
	
		this.add(new JLabel("ID", JLabel.CENTER));
		idField = new JTextField(20);
		this.add(idField);
		
		this.add(new JLabel("Title", JLabel.CENTER));
		titleField = new JTextField(20);
		this.add(titleField);
		
		this.add(new JLabel("Publisher", JLabel.CENTER));
		publisherField = new JTextField(20);
		this.add(publisherField);
		
		this.add(new JLabel("Year", JLabel.CENTER));
		yearField = new JTextField(20);
		this.add(yearField);
		
		this.add(new JLabel("Price", JLabel.CENTER));
		priceField = new JTextField(20);
		this.add(priceField);
		
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);
		
		previouesBtn = new JButton("Previoues");
		previouesBtn.addActionListener(this);
		this.add(previouesBtn);
		
		insertBtn = new JButton("삽입");
		insertBtn.addActionListener(this);
		this.add(insertBtn);
		
		finishBtn = new JButton("종료");
		finishBtn.addActionListener(this);
		this.add(finishBtn);
		
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void connectToDB() {
		try {
			Class.forName(JDBC_CLASS_NAME);
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ResultSet getResultSet() throws Exception {
		String sql = "SELECT * FROM books ORDER BY id DESC;";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	public static void main(String[] args) {
		new BookViewer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextBtn) {
			try {
				if (resultSet.next()) {
					idField.setText(String.valueOf(resultSet.getInt(1)));
					titleField.setText(resultSet.getString(2));
					publisherField.setText(resultSet.getString(3));
					Date year = resultSet.getDate(4);
					yearField.setText(year.toString());
					priceField.setText(String.valueOf(resultSet.getInt(5)));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == previouesBtn) {
			try {
				if (resultSet.previous()) {
					idField.setText(String.valueOf(resultSet.getInt(1)));
					titleField.setText(resultSet.getString(2));
					publisherField.setText(resultSet.getString(3));
					Date year = resultSet.getDate(4);
					yearField.setText(year.toString());
					priceField.setText(String.valueOf(resultSet.getInt(5)));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == insertBtn) {
			String sql = "INSERT INTO books(title, publisher, year, price) VALUES(?, ?, ?, ?);";
			try {
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, titleField.getText());
				pstmt.setString(2, publisherField.getText());
				pstmt.setDate(3, Date.valueOf(yearField.getText()));
				pstmt.setInt(4, Integer.parseInt(priceField.getText()));
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, "책 등록 성공", "성공", JOptionPane.INFORMATION_MESSAGE);
				resultSet = getResultSet();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == finishBtn) {
			try {
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
