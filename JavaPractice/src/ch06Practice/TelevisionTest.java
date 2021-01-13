package ch06Practice;

public class TelevisionTest {

	public static void main(String[] args) {
		Television myTv=new Television();
		myTv.channel=7;
		myTv.volume=9;
		myTv.onOff=true;
		int ch=myTv.getChannel();
		System.out.println("현재 체널은 "+ch+"입니다.");
		myTv.setChannel(11);
		myTv.print();
		
		Television yourTv=new Television();
		yourTv.channel=9;
		yourTv.volume=12;
		yourTv.onOff=true;
		yourTv.print();
		
		Television myTv2=new Television(7,10,true);
		myTv2.print();
		Television yourTv2=new Television(11,20,true);
		yourTv2.print();
	}

}
