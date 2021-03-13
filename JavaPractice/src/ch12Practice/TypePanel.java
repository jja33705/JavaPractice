package ch12Practice;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TypePanel extends JPanel implements ActionListener {
	private int type = 0;
	private JRadioButton combo;
	private JRadioButton potato;
	private JRadioButton bulgogi;
	
	public TypePanel() {
		this.setLayout(new GridLayout(3, 1));
		combo = new JRadioButton("combo", true);
		combo.addActionListener(this);
		potato = new JRadioButton("potato");
		potato.addActionListener(this);
		bulgogi = new JRadioButton("bulgogi");
		bulgogi.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(combo);
		group.add(potato);
		group.add(bulgogi);
		
		this.setBorder(BorderFactory.createTitledBorder("Á¾·ù"));
		
		this.add(combo);
		this.add(potato);
		this.add(bulgogi);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == combo) {
			type = 0;
		} else if(e.getSource() == potato) {
			type = 1;
		} else if(e.getSource() == bulgogi) {
			type = 2;
		}
	}
	
	public int getType() {
		return type;
	}
}
