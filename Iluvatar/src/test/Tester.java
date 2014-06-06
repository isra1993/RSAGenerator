package test;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.RSAInterface;
import model.RSAJava;
import controller.Controller;
import view.Window;

public class Tester {

	public static void main(String[] args) {
		new Tester();
	}

	public Tester() {
		for (LookAndFeelInfo info : UIManager
				.getInstalledLookAndFeels()) {
			if (info.getName() == "Nimbus") {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
		Window window = new Window();
		RSAInterface algorithm = new RSAJava();
		Controller controller = new Controller(window,algorithm);
		window.setController(controller);
	}
}
