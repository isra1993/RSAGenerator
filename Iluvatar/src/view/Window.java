package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	
	private JTextField naField;
	private JTextField eaField;
	private JTextField daField;
	private JTextField nbField;
	private JTextField ebField;
	private JTextField dbField;
	private JTextField aMessage;
//	private JTextField aSignedMessage;
	private JTextField bMessage;
	private JTextField bSignedMessage;
	
	private JButton generateA;
	private JButton generateB;
	private JButton sign;
	private JButton verifySign;
	private JButton invertRol;
	private JButton clear;
	
	private JLabel aLabel;
	private JLabel bSignedLabel;
	private JLabel bLabel;
	
	private boolean inverted;
	
	public Window() {
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		this.panel3 = new JPanel();
		this.inverted = false;
		init();
	}
	
	private void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 70, 800, 775);
		this.setTitle("Maiar RSA Generator");
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		Dimension d = new Dimension(800, 775);
		this.setMinimumSize(d);
		
		this.panel1.setLayout(new GridBagLayout());
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 10, 0, 0);
		//Creates a border from this panel with a title
    	panel1.setBorder(BorderFactory.createTitledBorder("User A"));
		//Add panel1 to the content pane
		this.getContentPane().add(panel1, constraints);
		//Restart constraints
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel naLabel = new JLabel("Na: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		this.panel1.add(naLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.naField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 3.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 0, 0, 20);
		this.naField.setEditable(false);
		this.panel1.add(naField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		JLabel eaLabel = new JLabel("Ea: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		this.panel1.add(eaLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.eaField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 3.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 0, 0, 20);
		this.eaField.setEditable(false);
		this.panel1.add(eaField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		JLabel daLabel = new JLabel("Da: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		this.panel1.add(daLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.daField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 3.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 0, 0, 20);
		this.daField.setEditable(false);
		this.panel1.add(daField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		this.generateA = new JButton("Generate");
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel1.add(generateA, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.panel2.setLayout(new GridBagLayout());
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 0, 0, 10);
		//Creates a border from this panel with a title
    	panel2.setBorder(BorderFactory.createTitledBorder("User B"));
		//Add panel1 to the content pane
		this.getContentPane().add(panel2, constraints);
		//Restart constraints
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel nbLabel = new JLabel("Nb: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		this.panel2.add(nbLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.nbField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 3.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 0, 0, 20);
		this.nbField.setEditable(false);
		this.panel2.add(nbField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		JLabel ebLabel = new JLabel("Eb: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		this.panel2.add(ebLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.ebField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 3.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 0, 0, 20);
		this.ebField.setEditable(false);
		this.panel2.add(ebField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		JLabel dbLabel = new JLabel("Db: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		this.panel2.add(dbLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.dbField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 3.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 0, 0, 20);
		this.dbField.setEditable(false);
		this.panel2.add(dbField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		this.generateB = new JButton("Generate");
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel2.add(generateB, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.panel3.setLayout(new GridBagLayout());
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 2.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 10, 0, 10);
		//Creates a border from this panel with a title
    	panel3.setBorder(BorderFactory.createTitledBorder("Messages"));
		//Add panel1 to the content pane
		this.getContentPane().add(panel3, constraints);
		//Restart constraints
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		aLabel = new JLabel("User A message: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.1;
		this.panel3.add(aLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.aMessage = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 4;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 10, 0, 10);
		this.panel3.add(aMessage, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		bLabel = new JLabel("User B message: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.1;
		this.panel3.add(bLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.bMessage = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 10, 0, 10);
		this.panel3.add(bMessage, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		bSignedLabel = new JLabel("User B signed message: ");
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.1;
		this.panel3.add(bSignedLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.bSignedMessage = new JTextField();
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0, 10, 0, 10);
		this.bSignedMessage.setEditable(true);
		this.panel3.add(bSignedMessage, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		this.sign = new JButton("Sign");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel3.add(sign, constraints);
		
		this.verifySign = new JButton("Verify Sign");
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel3.add(verifySign, constraints);
		
		this.invertRol = new JButton("Invert Rol");
		constraints.gridx = 2;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel3.add(invertRol, constraints);
		
		this.clear = new JButton("Clear");
		constraints.gridx = 3;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel3.add(clear, constraints);
		
		this.setVisible(true);
	}
	
	public void setController(Controller controller) {
		this.generateA.addActionListener(controller);
		this.generateB.addActionListener(controller);
		this.sign.addActionListener(controller);
		this.verifySign.addActionListener(controller);
		this.invertRol.addActionListener(controller);
		this.clear.addActionListener(controller);
	}

	public String getNa() {
		return naField.getText();
	}

	public void setNaField(String naField) {
		this.naField.setText(naField);
	}

	public String getEa() {
		return eaField.getText();
	}

	public void setEaField(String eaField) {
		this.eaField.setText(eaField);
	}

	public String getDa() {
		return daField.getText();
	}

	public void setDaField(String daField) {
		this.daField.setText(daField);
	}

	public String getNb() {
		return nbField.getText();
	}

	public void setNbField(String nbField) {
		this.nbField.setText(nbField);
	}

	public String getEb() {
		return ebField.getText();
	}

	public void setEbField(String ebField) {
		this.ebField.setText(ebField);
	}

	public String getDb() {
		return dbField.getText();
	}

	public void setDbField(String dbField) {
		this.dbField.setText(dbField);
	}

	public String getaMessage() {
		return aMessage.getText();
	}

	public void setaMessage(String aMessage) {
		this.aMessage.setText(aMessage);
	}

	public String getbMessage() {
		return bMessage.getText();
	}

	public void setbMessage(String bMessage) {
		this.bMessage.setText(bMessage);
	}

	public String getbSignedMessage() {
		return bSignedMessage.getText();
	}

	public void setbSignedMessage(String bSignedMessage) {
		this.bSignedMessage.setText(bSignedMessage);
	}

	public JButton getGenerateA() {
		return generateA;
	}

	public JButton getGenerateB() {
		return generateB;
	}

	public JButton getSign() {
		return sign;
	}

	public JButton getVerifySign() {
		return verifySign;
	}

	public JButton getInvertRol() {
		return invertRol;
	}

	public JButton getClear() {
		return clear;
	}
	
	public void setInvert() {
		if (this.inverted) {
			this.inverted = false;
			this.aLabel.setText("User A message: ");
			this.bLabel.setText("User B message: ");
			this.bSignedLabel.setText("User B signed message: ");
		} else {
			this.inverted = true;
			this.aLabel.setText("User B message: ");
			this.bLabel.setText("User A message: ");
			this.bSignedLabel.setText("User A signed message: ");
		}
	}
}
