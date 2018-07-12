package info;

public class InfoMain {

	public static void main(String[] args) {
		InfoGui gui = new InfoGui();
		gui.addLayout();
		gui.addEvent();
		gui.connectToDB();
	}	
}
