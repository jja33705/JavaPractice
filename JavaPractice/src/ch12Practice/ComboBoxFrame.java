package ch12Practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame implements ActionListener{
	
	private String[] animal = {"dog", "lion", "tiger"};
	private JComboBox animalList;
	private JLabel label;
	
	public ComboBoxFrame() {
		this.setTitle("콤보 박스");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 500);
		
		animalList = new JComboBox(animal);
		animalList.setSelectedIndex(0);
		animalList.addActionListener(this);
		animalList.setEditable(true);
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		changePicture(animal[animalList.getSelectedIndex()]);
		
		this.add(animalList, BorderLayout.NORTH);
		this.add(label, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private void changePicture(String name) {
		boolean isExit = false;
		ImageIcon icon = new ImageIcon(name + ".gif");
		label.setIcon(icon);
		for(int i = 0; i < animal.length; i++) {
			if(name.equals(animal[i])) {
				isExit = true;
				break;
			}
		}
		if(isExit == false) {
			label.setText("이미지가 발견되지 않았습니다.");
		} else {
			label.setText(null);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		String name = (String)cb.getSelectedItem();
		boolean isExit = false;
		for(int i = 0; i < animalList.getItemCount(); i++) {
			if(name.equals(animalList.getItemAt(i))) {
				isExit = true;
				break;
			}
		}
		if(isExit == false) {
			animalList.addItem(name);
		}
		changePicture(name);
	}
	
	public static void main(String[] args) {
		new ComboBoxFrame();
	}

}
