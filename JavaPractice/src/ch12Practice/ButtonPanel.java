package ch12Practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel implements ActionListener {
	public static final int[][] PIZZA_PRICE = {{12000, 18000, 24000}, {13000, 19000,25000}, {14000, 20000, 26000}} ;
	public static final int[] TOPPING_PRICE = {1000, 1000, 2000, 3000};
	private TypePanel typePanel;
	private ToppingPanel toppingPanel;
	private SizePanel sizePanel;
	private JButton orderButton;
	private JButton cancleButton;
	private JTextField costField; 
	
	public ButtonPanel(TypePanel typePanel, ToppingPanel toppingPanel, SizePanel sizePanel) {
		this.typePanel = typePanel;
		this.toppingPanel = toppingPanel;
		this.sizePanel = sizePanel;
		
		orderButton = new JButton("주문");
		orderButton.addActionListener(this);
		this.add(orderButton);
		cancleButton = new JButton("취소");
		cancleButton.addActionListener(this);
		this.add(cancleButton);
		JLabel label = new JLabel("가격");
		this.add(label);
		costField = new JTextField(5);
		costField.setEditable(false);
		this.add(costField);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == orderButton) {
			int price = PIZZA_PRICE[typePanel.getType()][sizePanel.getPizzaSize()];
			for(int i = 0; i < TOPPING_PRICE.length; i++) {
				if(toppingPanel.getTopping()[i]) {
					price += TOPPING_PRICE[i];
				}
			}
			costField.setText(String.valueOf(price));
		} else if(e.getSource() == cancleButton) {
			costField.setText(null);
		}
	}
}
