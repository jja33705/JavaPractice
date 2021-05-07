package dictionary;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener {
	
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	
	private Map<String, String> dict = new HashMap<>();
	
	public SimpleDictionary() {
		this.add(inputField);
		searchBtn.addActionListener(this);
		this.add(searchBtn);
		addBtn.addActionListener(this);
		this.add(addBtn);
		
		this.setPreferredSize(new Dimension(600, 50));
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
			JOptionPane.showMessageDialog(this, "영어단어가 추가되었습니다", "성공", JOptionPane.INFORMATION_MESSAGE);
		}
		inputField.requestFocus();
		
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
