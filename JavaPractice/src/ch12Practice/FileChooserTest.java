package ch12Practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileChooserTest extends JFrame implements ActionListener {
	private JFileChooser fc;
	private JButton openButton;
	private JButton saveButton;
	
	public FileChooserTest() {
		this.setTitle("파일 선택기 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		
		fc = new JFileChooser();
		
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트입니다.");
		panel.add(label);
		
		openButton = new JButton("파일 오픈");
		openButton.addActionListener(this);
		panel.add(openButton);
		
		saveButton = new JButton("파일 저장");
		saveButton.addActionListener(this);
		panel.add(saveButton);
		
		this.add(panel);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FileChooserTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				System.out.println(file.getAbsolutePath()+" 경로가 선택되었습니다.");
			} else {
				System.out.println("파일이 선택되지 않았습니다.");
			}
		} else if(e.getSource() == saveButton) {
			int returnVal = fc.showSaveDialog(this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				System.out.println(file.getAbsolutePath()+" 경로가 선택되었습니다.");
			} else {
				System.out.println("파일이 선택되지 않았습니다.");
			}
		}
		
	}
}
