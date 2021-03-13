package ch12Practice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SizePanel extends JPanel implements ActionListener {
	int size = 0;
	JRadioButton small, medium, large;
	
	public SizePanel() {
		this.setLayout(new GridLayout(3, 1));
		small = new JRadioButton("Small", true);
		small.addActionListener(this);
		medium = new JRadioButton("Medium");
		medium.addActionListener(this);
		large = new JRadioButton("Large");
		large.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(small);
		group.add(medium);
		group.add(large);
		
		this.setBorder(BorderFactory.createTitledBorder("Á¾·ù"));
		
		this.add(small);
		this.add(medium);
		this.add(large);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == small) {
			size = 0;
		} else if(e.getSource() == medium) {
			size = 1;
		} else if(e.getSource() == large) {
			size = 2;
		}
	}
}
