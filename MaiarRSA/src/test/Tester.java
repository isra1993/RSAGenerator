package test;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.freemonad.paridroid.PariNative;

import model.RSAGenerator;
import controller.Controller;
import view.Window;

public class Tester {
//	static {
//	
//	}

	public static void main(String[] args) throws FileNotFoundException {
//		PariNative.paridroidInit();
//		// System.out.println(PariNative.paridroidEval("3*2"));
//		System.out.println(PariNative
//				.loadLibray("/home/runix/git/RSAGenerator/MaiarRSA/pari.gp"));
//		System.out.println(PariNative
//				.paridroidEval("generateRSAPair(10,10,10)"));
		new Tester();
		// RSAGenerator rsa = new RSAGenerator();
		// rsa.getNumbers(2);
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
