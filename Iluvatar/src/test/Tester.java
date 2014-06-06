package test;

import controller.Controller;
import view.Window;

public class Tester {

	public static void main(String[] args) {
		new Tester();
	}

	public Tester() {
		Window window = new Window();
		Controller controller = new Controller(window);
		window.setController(controller);
	}
}
