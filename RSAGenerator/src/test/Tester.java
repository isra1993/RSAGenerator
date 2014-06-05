package test;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import model.RSAGenerator;
import controller.Controller;
import view.Window;

public class Tester {
	public static void main(String[] args) {
		new Tester();
	}
	
	public Tester() {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if (info.getName() == "Nimbus") {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			}
		}
		
		Window window = new Window();
		RSAGenerator rsa = new RSAGenerator();
		
		Controller controller = new Controller(window, rsa);
		
		window.setController(controller);
	}
}
