package Prototype;
// dùng để clone ra những thằng có đặc điểm hơi giống nhau

class Computer implements Cloneable {
	private String os;
	private String office;
	private String antiVirus;
	private String browser;
	private String others;
	
	public Computer(String os, String office, String antiVirus, String browser, String others) {
		super();
		this.os = os;
		this.office = office;
		this.antiVirus = antiVirus;
		this.browser = browser;
		this.others = others;
	}
	
	@Override
	protected Computer clone() {
		try {
			return (Computer) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		return "Computer [os=" + os + ", office=" + office + ", antiVirus=" + antiVirus + ", browser=" + browser
				+ ", others=" + others + "]";
	}
	
	public void setOthers(String others) {
		this.others = others;
	}
}

public class Prototype {
	public static void main(String[] args) {
		Computer com1 = new Computer("window10", "word", "BKAV", "Chrome", "Eclipse");
		System.out.println(com1);
		Computer com2 = com1.clone();
		com2.setOthers("Hello darkness");
		System.out.println(com2);
	}
}
