package tableViewer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TableViewer extends JFrame implements ActionListener{
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver"; //JDBC����̹� Ŭ���� �̸�
	
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/OOP3";  //db url
	
	private static final String DB_USER = "root";
	
	private static final String DB_PASSWORD = "wkdwogus1";

	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton previousBtn, nextBtn, insertBtn, finishBtn;
	
	private ResultSet rs = null;
	private Connection con = null;
	
	public TableViewer() {
		
		// TableViewer��ü�� ������ ��, DB�� books ���̺��� ���ڵ���� �о� �´�.
		/*
		* 1. �����ͺ��̽��� ����
		* 2. select�� �����ϰ� ��ȯ�� ResultSet��ü�� ������ �־�� ��.
		*/
		try {
			Class.forName(JDBC_CLASS_NAME);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			String sql = "select * from books";;
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("DB ���ῡ ������ �־� ���α׷��� �����մϴ�.");
			System.exit(0);
		}
		
		// �� ������Ʈ�� frame�� �߰��ϱ�
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
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350, 200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TableViewer();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextBtn) {
			try {
				rs.next();
				int bookId = rs.getInt("book_id");
				idField.setText(String.valueOf(bookId));
				String title = rs.getString("title");
				titleField.setText(title);
				String publisher = rs.getString("publisher");
				publisherField.setText(publisher);
				Date year = rs.getDate("year"); //java.sql�� DateŸ���� ��ȯ
				yearField.setText(year.toString());
				int price = rs.getInt("price");
				priceField.setText(String.valueOf(price));
			} catch (Exception err) {
				System.out.println(err.getMessage());
			}
		}
		
	}

}
