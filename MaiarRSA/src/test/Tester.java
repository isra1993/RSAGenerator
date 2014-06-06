package test;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Arrays;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import model.RSAController;
import model.RSAInterface;
import model.RSAPari;
import view.Window;
import controller.Controller;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException,
			InterruptedException, InvocationTargetException {
		new Tester();
	}

	public Tester() throws InterruptedException, InvocationTargetException {
		SwingUtilities.invokeAndWait(new Runnable() {

			@Override
			public void run() {
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
				RSAInterface rsa = new RSAPari();
				RSAController rsac = new RSAController(rsa);
				Controller controller = new Controller(window, rsac);
				window.setController(controller);
			}

		});

	}
}
