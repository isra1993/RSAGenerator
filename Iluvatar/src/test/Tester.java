package test;

import model.RSAInterface;
import model.RSAJava;
import controller.Controller;
import view.Window;

public class Tester {

	public static void main(String[] args) {
		new Tester();
	}

	public Tester() {
		Window window = new Window();
		RSAInterface algorithm = new RSAJava();
		Controller controller = new Controller(window,algorithm);
		window.setController(controller);
	}
}
