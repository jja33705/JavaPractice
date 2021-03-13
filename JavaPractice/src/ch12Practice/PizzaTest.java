package ch12Practice;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PizzaTest extends JFrame {
	private TypePanel typePanel;
	private ToppingPanel toppingPanel;
	private SizePanel sizePanel;
	
	public PizzaTest() {
		this.setSize(350, 250);
		this.setTitle("피자 주문");
		
		WelcomePanel welcomePanel = new WelcomePanel();
		this.add(welcomePanel, BorderLayout.NORTH);

		typePanel = new TypePanel();
		this.add(typePanel, BorderLayout.WEST);
		
		toppingPanel = new ToppingPanel();
		this.add(toppingPanel, BorderLayout.CENTER);
		
		sizePanel = new SizePanel();
		this.add(sizePanel, BorderLayout.EAST);
		
		ButtonPanel buttonPanel = new ButtonPanel(typePanel, toppingPanel, sizePanel);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new PizzaTest();
	}
}
