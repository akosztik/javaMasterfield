package awt;

import java.awt.*;
import java.awt.event.*;

public class Ablak extends Frame implements WindowListener, ActionListener{

	private TextField input;
	
	public Ablak() throws HeadlessException {
		setVisible(true);
		setSize(300,200);
		this.addWindowListener(this);
		Button gomb= new Button("Kil�p�s");
		Panel southPanel=new Panel();
		southPanel.setLayout(new FlowLayout());
		southPanel.add(gomb);
		add(southPanel,BorderLayout.SOUTH);
		gomb.addActionListener(this);
		
		Panel northPanel=new Panel();
		northPanel.setLayout(new FlowLayout());
		add(northPanel,BorderLayout.NORTH);
		input= new TextField(30);
		northPanel.add(input);
		input.addActionListener(this);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose(); //nincs oszt�lymegsz�ntetes -destruktor
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		setTitle("t�lc�n voltam");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass().getSimpleName().equals("TextField")) {
			setTitle(input.getText());
			input.setText("");
			input.requestFocus();
		}else {
			dispose();
		}
		
	}
	

}
