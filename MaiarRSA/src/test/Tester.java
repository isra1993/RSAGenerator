package test;

import java.io.FileNotFoundException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.RSAGenerator;
import controller.Controller;
import view.Window;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		new Tester();
	}

	public Tester() {
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if (info.getName() == "Nimbus") {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (Throwable e) {
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
