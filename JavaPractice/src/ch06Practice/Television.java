package ch06Practice;
public class Television {
	int channel;
	int volume;
	boolean onOff;
	public Television() {
	}
	public Television(int channel, int volume, boolean onOff) {
		this.channel=channel;
		this.volume=volume;
		this.onOff=onOff;
	}
	void print() {
		System.out.println("채널은 "+channel+"이고 볼륨은 "+volume+"입니다.");
	}
	int getChannel() {
		return channel;
	}
	void setChannel(int ch) {
		channel=ch;
	}
}
