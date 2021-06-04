package ch18Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.gson.Gson;

public class RemoteJSON {

	public static void main(String[] args) throws Exception {
		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);
		URLConnection con = url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String line = null;
		StringBuffer buffer = new StringBuffer();
		while((line = bufferedReader.readLine()) != null) {
			buffer.append(line);
			System.out.println(line);
		}
		
		bufferedReader.close();
//		Gson gson = new Gson();
//		Person person = gson.fromJson("{ 'name': 'gdhon', 'age': 10, 'graduate': true } ", Person.class);
		
		/*
		 * gson 객체생성 과정.....
		 * Person p = new Person();
		 * p.setName("gdhon");
		 * p.setAge(10);
		 */
//		System.out.println(person.getName());
//		System.out.println(person.getAge());
//		System.out.println(person.isGraduated());
		
		Gson gson = new Gson();
		Post[] posts = gson.fromJson(buffer.toString(), Post[].class);
//		insertIntoDB(posts);
		
		for(Post post : posts) {
			System.out.println("userId: " + post.getUserId() + ", id: " + post.getId());
		}
		
		ArrayList<Post> postList = selectFromDB();	
		
		for (Post post : postList) {
			System.out.println("userId: " + post.getUserId() + ", id: " + post.getId() + ", title: " + post.getTitle() + ", body: " + post.getBody());
		}
	}
	
	private static ArrayList<Post> selectFromDB() throws Exception {
		ArrayList<Post> postList = new ArrayList<>();
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/OOP", "root", "wkdwogus1");
		String sql = "SELECT * FROM posts";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Post post = new Post();
			post.setUserId(rs.getInt("userId"));
			post.setId(rs.getInt("id"));
			post.setTitle(rs.getString("title"));
			post.setBody(rs.getString("body"));
			postList.add(post);
		}
		return postList;
	}
	
	private static void insertIntoDB(Post[] posts) throws Exception {
		// 드라이버 로딩
		// DB서버에 연결하고
		// Connection con = DriverManager.getConnection(...);
		/*
		 * create table posts (
		 * 	userId int,
		 * 	id int primary key,
		 * 	title varchar(50),
		 * 	body text,
		 * );
		 */
		
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/OOP", "root", "wkdwogus1");
		String sql = "INSERT INTO posts(userId, id, title, body) VALUES (?, ?, ?, ?);";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		for (Post post : posts) {
			pstmt.setInt(1, post.getUserId());
			pstmt.setInt(2, post.getId());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getBody());
			pstmt.executeUpdate();
		}
		
		
	}
}

class Person {
	// JavaBean형태로 클래스를 정의
	// 1.private member변수에 대한 public getter와 setter를 가진다.
	// 2.default 생성자를 가진다.
	private String name;
	private int age;
	private boolean graduated;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGraduated() {
		return graduated;
	}
	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}
	
}
