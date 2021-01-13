package ch06Practice;

import java.util.ArrayList;

public class GameCharacter {
	private ArrayList<GameItem> list=new ArrayList<>();
	
	public class GameItem{
		private String name;
		private int type;
		private int price;
		public int getPrice() {
			return price;
		}
		@Override
		public String toString() {
			return "GameItem {name="+name+", type="+type+", price="+price+"]";
		}
	}
	public void add(String name, int type, int price) {
		GameItem gameItem=new GameItem();
		gameItem.name=name;
		gameItem.type=type;
		gameItem.price=price;
		list.add(gameItem);
	}
	public void print() {
		int total=0;
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			total+=list.get(i).getPrice();
		}
		System.out.println(total);
	}
}
