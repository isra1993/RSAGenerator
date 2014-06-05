package test;

import java.io.FileNotFoundException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.RSAInterface;
import model.RSAPari;
import view.Window;
import controller.Controller;

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
		RSAInterface rsa = new RSAPari();
		Controller controller = new Controller(window, rsa);
		window.setController(controller);
	}
}
