package tableViewer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TableViewer extends JFrame implements ActionListener{
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver"; //JDBC드라이버 클래스 이름
	
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/OOP3";  //db url
	
	private static final String DB_USER = "root";
	
	private static final String DB_PASSWORD = "wkdwogus1";

	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton previousBtn, nextBtn, insertBtn, finishBtn;
	
	private ResultSet rs = null;
	private Connection con = null;
	
	public TableViewer() {
		
		// TableViewer객체가 생성될 때, DB의 books 테이블의 레코드들을 읽어 온다.
		/*
		* 1. 데이터베이스와 연결
		* 2. select문 실행하고 반환된 ResultSet객체를 가지고 있어야 함.
		*/
		try {
			Class.forName(JDBC_CLASS_NAME);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "select * from books order by book_id desc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("DB 연결에 문제가 있어 프로그램을 종료합니다.");
			System.exit(0);
		}
		
		// 각 컴포넌트를 frame에 추가하기
		this.setLayout(new GridLayout(0, 2));
		
		this.add(new JLabel("ID", JLabel.CENTER));
		idField = new JTextField(10);
		this.add(idField);
		
		this.add(new JLabel("Title", JLabel.CENTER));
		titleField = new JTextField(10);
		this.add(titleField);
		
		this.add(new JLabel("Publisher", JLabel.CENTER));
		publisherField = new JTextField(10);
		this.add(publisherField);
		
		this.add(new JLabel("Year", JLabel.CENTER));
		yearField = new JTextField(10);
		this.add(yearField);
		
		this.add(new JLabel("Price", JLabel.CENTER));
		priceField = new JTextField(10);
		this.add(priceField);
		
		previousBtn = new JButton("Previous");
		previousBtn.addActionListener(this);
		this.add(previousBtn);
		
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(this);
		this.add(insertBtn);
		
		finishBtn = new JButton("Finish");
		finishBtn.addActionListener(this);
		this.add(finishBtn);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setSize(350, 200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TableViewer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == nextBtn || e.getSource() == previousBtn) {
				if (e.getSource() == nextBtn) {
					rs.next();
				} else if (e.getSource() == previousBtn) {
					rs.previous();
				}
				int bookId = rs.getInt("book_id");
				idField.setText(String.valueOf(bookId));
				String title = rs.getString("title");
				titleField.setText(title);
				String publisher = rs.getString("publisher");
				publisherField.setText(publisher);
				Date year = rs.getDate("year"); //java.sql의 Date타입을 반환
				yearField.setText(year.toString());
				int price = rs.getInt("price");
				priceField.setText(String.valueOf(price));
			} else if (e.getSource() == insertBtn) {
				// 이미 연결은 되어 있고..
				// 이미 연결 정보를 가지고 있는 connection객체를 이용해 insert문을 이용해 prepare하고
				// 반환된 PreparedStatement객체를 이용해서 실행요청을 서버에 보낸다.
				
				// Statement 또는 PreparedStatement객체를 사용할 수 있다.
				// 그런데, PreparedStatement객체 사용을 권고한다.
				// 왜냐하면 Statement객체를 사용해 프로그래밍을 잘 못 하면
				// 보안상의 취약점을 만들 수 있다.
				// SQL Injection방법을 사용한 해커의 공격을 받을 수 있다.
				String sql = "INSERT INTO books(title, publisher, year, price) VALUES (?,?,?,?);";
				PreparedStatement pstmt = con.prepareStatement(sql);
				String title = titleField.getText();
				pstmt.setString(1, title);
				String publisher = publisherField.getText();
				pstmt.setString(2, publisher);
				String year = yearField.getText();
				
				// 문자열로부터 java.util.Date객체를 생성할 수 있는
				// simpleDateFormat객체를 생성한다.
				// 이 때, date값을 포맷을 알려준다.
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// 문자열을 parsing해서 java.util.Date객체를 생성한 것으로부터  java.sql.Date객체 생성
//				Date date = new Date(sdf.parse(year).getTime());
				
				pstmt.setDate(3, Date.valueOf(year));
				String price = priceField.getText();
				pstmt.setInt(4, Integer.valueOf(price));
				pstmt.executeUpdate();
				// 실행할 SQL문이 select문인 경우에는 executeQuery메서드를 호출
				// 실행할 SQL문이 insert, delete, 또는 update일 경우에,
				// executeUpdate메소드를 호출
				JOptionPane.showMessageDialog(this, "등록 성공");
				reloading();
			} else if (e.getSource() == finishBtn) {
				System.out.println("프로그램을 종료합니다...");
					con.close();
					this.dispose();
					System.exit(0);
			}
		} catch (Exception err) {
			JOptionPane.showMessageDialog(this, "오류 발생[" + err.getMessage() + "]");
			System.out.println(err.getMessage());
		}
	}
	
	private void reloading() throws Exception {
		String sql = "select * from books order by book_id desc";
		PreparedStatement pstmt = con.prepareStatement(sql);
		rs.close();
		rs = pstmt.executeQuery();
	}

}
