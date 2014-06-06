package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Window;

public class Controller implements ActionListener {

	private Window window;
	
	public Controller(Window window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == window.getGenerateA()) {
			
		} else if (event.getSource() == window.getGenerateB()) {
			
		} else if (event.getSource() == window.getSign()) {
			if (!window.getaMessage().equals("")) {
				
			} 
			
			if (!window.getbMessage().equals("")) {
				
			} 
		} else if (event.getSource() == window.getVerifySign()) {
			if (!window.getaSignedMessage().equals("")) {
				
			} 
			
			if (!window.getbSignedMessage().equals("")) {
				
			}
		} else if (event.getSource() == window.getInvertRol()) {
			
		} else if (event.getSource() == window.getClear()) {
			clearFields();
		}
	}
	
	private void clearFields() {
		this.window.setNaField("");
		this.window.setEaField("");
		this.window.setDaField("");
		this.window.setNbField("");
		this.window.setEbField("");
		this.window.setDbField("");
		this.window.setaMessage("");
		this.window.setaSignedMessage("");
		this.window.setbMessage("");
		this.window.setbSignedMessage("");
	}
	
}
