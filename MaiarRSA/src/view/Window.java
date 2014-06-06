package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controller;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	
	private JTextField pField;
	private JTextField qField;
	private JTextField nField;
	private JTextField phiField;
	private JTextField eField;
	private JTextField dField;
	private JTextField writtenField;
	private JTextField processedField;
	private JTextField rField;
	
	private JButton primesButton;
	private JButton dataButton;
	private JButton messageButton;
	private JButton clearButton;
	private JButton invertRol;
	
	private JRadioButton java;
	private JRadioButton pari;
	
	private JLabel writtenLabel;
	private boolean encript;
	
	private JMenuBar menu;
	
	public Window() {
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		this.panel3 = new JPanel();
		this.panel4 = new JPanel();
		this.panel5 = new JPanel();
		init();
	}

	private void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 70, 800, 775);
		this.setTitle("RSA Generator");
//		this.setJMenuBar(menu);
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		Dimension d = new Dimension(800, 775);
		this.setMinimumSize(d);
//		this.setMaximumSize(d);
		
		panel1.setLayout(new GridBagLayout());
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 3.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 10, 0, 0);
		this.panel1.setMaximumSize(new Dimension(780, 150));
		//Creates a border from this panel with a title
    	panel1.setBorder(BorderFactory.createTitledBorder("Primes p & q"));
		//Add panel1 to the content pane
		this.getContentPane().add(panel1, constraints);
		//Restart constraints
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel pLabel = new JLabel("p: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel1.add(pLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.pField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 5.0;
		constraints.weighty = 1.0;
		constraints.insets = new Insets(20, 0, 10, 20);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.pField.setEditable(false);
		this.panel1.add(pField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel qLabel = new JLabel("q: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel1.add(qLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.qField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 5.0;
		constraints.weighty = 1.0;
		constraints.insets = new Insets(20, 0, 10, 20);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.qField.setEditable(false);
		this.panel1.add(qField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		panel5.setLayout(new GridBagLayout());
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 0, 0, 10);
		//Creates a border from this panel with a title
    	panel5.setBorder(BorderFactory.createTitledBorder("p & q size"));
		//Add panel1 to the content pane
		this.getContentPane().add(panel5, constraints);
		//Restart constraints
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		rField = new JTextField("10");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 2.0;
		constraints.insets = new Insets(0, 40, 0, 40);
		d = new Dimension(100, 30);
		rField.setSize(d);
		rField.setPreferredSize(d);
		rField.setMinimumSize(d);
		rField.setHorizontalAlignment(0);
		this.panel5.add(rField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		
		panel2.setLayout(new GridBagLayout());
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 10, 0, 10);
		this.panel2.setMaximumSize(new Dimension(780, 150));
		//Creates a border from this panel with a title
    	panel2.setBorder(BorderFactory.createTitledBorder("RSA Data (n, phi, e, d)"));
		//Add panel1 to the content pane
		this.getContentPane().add(panel2, constraints);
		//Restart constraints
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel nLabel = new JLabel("n: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel2.add(nLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.nField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 5.0;
		constraints.weighty = 1.0;
		constraints.insets = new Insets(20, 0, 10, 20);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.nField.setEditable(false);
		this.panel2.add(nField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel phiLabel = new JLabel("phi: ");
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel2.add(phiLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.phiField = new JTextField();
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 5.0;
		constraints.weighty = 1.0;
		constraints.insets = new Insets(20, 0, 10, 20);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.phiField.setEditable(false);
		this.panel2.add(phiField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel eLabel = new JLabel("e: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel2.add(eLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.eField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 5.0;
		constraints.weighty = 1.0;
		constraints.insets = new Insets(20, 0, 10, 20);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.eField.setEditable(false);
		this.panel2.add(eField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel dLabel = new JLabel("d: ");
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel2.add(dLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.dField = new JTextField();
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 5.0;
		constraints.weighty = 1.0;
		constraints.insets = new Insets(20, 0, 10, 20);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.dField.setEditable(false);
		this.panel2.add(dField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		panel3.setLayout(new GridBagLayout());
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 10, 0, 10);
		//Creates a border from this panel with a title
    	panel3.setBorder(BorderFactory.createTitledBorder("Message"));
		//Add panel1 to the content pane
		this.getContentPane().add(panel3, constraints);
		//Restart constraints
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		this.encript = true;
		this.writtenLabel = new JLabel("Insert a message to encript: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel3.add(writtenLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.writtenField = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 5.0;
		constraints.weighty = 4.0;
		constraints.insets = new Insets(0, 0, 10, 20);
		constraints.fill = GridBagConstraints.BOTH;
		this.panel3.add(writtenField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		JLabel processedLabel = new JLabel("The message processed is: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel3.add(processedLabel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.processedField = new JTextField();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 5.0;
		constraints.weighty = 4.0;
		constraints.insets = new Insets(0, 0, 10, 20);
		constraints.fill = GridBagConstraints.BOTH;
		this.processedField.setEditable(false);
		this.panel3.add(processedField, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		panel4.setLayout(new GridBagLayout());
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 10, 0, 10);
		//Creates a border from this panel with a title
    	panel4.setBorder(BorderFactory.createTitledBorder("Actions"));
		//Add panel1 to the content pane
		this.getContentPane().add(panel4, constraints);
		//Restart constraints
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0, 0, 0, 0);
		constraints.fill = GridBagConstraints.NONE;
		
		this.primesButton = new JButton("Generate Primes");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel4.add(primesButton, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.dataButton = new JButton("Generate RSA Data");
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.dataButton.setEnabled(false);
		this.panel4.add(dataButton, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.messageButton = new JButton("Process Message");
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.messageButton.setEnabled(false);
		this.panel4.add(messageButton, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.clearButton = new JButton("Clear All");
		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel4.add(clearButton, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.invertRol = new JButton("Invert Rol");
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.panel4.add(invertRol, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.java = new JRadioButton("Java");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		this.java.setSelected(true);
		this.panel4.add(java, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		this.pari = new JRadioButton("Pari");
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		this.panel4.add(pari, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		
		ButtonGroup group = new ButtonGroup();
		group.add(java);
		group.add(pari);
		
		this.setVisible(true);
	}

	public void setController(Controller controller) {
		this.primesButton.addActionListener(controller);
		this.dataButton.addActionListener(controller);
		this.messageButton.addActionListener(controller);
		this.clearButton.addActionListener(controller);
		this.invertRol.addActionListener(controller);
		this.java.addActionListener(controller);
		this.pari.addActionListener(controller);
	}

	public String getP() {
		return pField.getText();
	}

	public void setpField(String pField) {
		this.pField.setText(pField);
	}

	public String getQ() {
		return qField.getText();
	}

	public void setqField(String qField) {
		this.qField.setText(qField);
	}
	
	public String getR() {
		return rField.getText();
	}
	
	public void setrField(String r) {
		this.rField.setText(r);
	}

	public String getN() {
		return nField.getText();
	}

	public void setnField(String nField) {
		this.nField.setText(nField);
	}

	public String getPhi() {
		return phiField.getText();
	}

	public void setPhiField(String phiField) {
		this.phiField.setText(phiField);
	}

	public String getE() {
		return eField.getText();
	}

	public void seteField(String eField) {
		this.eField.setText(eField);
	}

	public String getD() {
		return dField.getText();
	}

	public void setdField(String dField) {
		this.dField.setText(dField);
	}

	public String getWrittenMessage() {
		return writtenField.getText();
	}

	public void setWrittenField(String writtenField) {
		this.writtenField.setText(writtenField);
	}

	public String getProcessedMessage() {
		return processedField.getText();
	}

	public void setProcessedField(String processedField) {
		this.processedField.setText(processedField);
	}

	public JButton getPrimesButton() {
		return primesButton;
	}

	public JButton getDataButton() {
		return dataButton;
	}
	
	public void setDataButtonEnabled(boolean bool) {
		this.dataButton.setEnabled(bool);
	}

	public JButton getMessageButton() {
		return messageButton;
	}
	
	public void setMessageButtonEnabled(boolean bool) {
		this.messageButton.setEnabled(bool);
	}

	public JButton getClearButton() {
		return clearButton;
	}
	
	public JButton getInvertRol() {
		return this.invertRol;
	}
	
	public void setEncript() {
		if (this.encript) {
			this.writtenLabel.setText("Insert a message to decript: ");
			this.encript = false;
		} else {
			this.writtenLabel.setText("Insert a message to encript: ");
			this.encript = true;
		}
	}

	public JRadioButton getJava() {
		return java;
	}

	public JRadioButton getPari() {
		return pari;
	}
}
