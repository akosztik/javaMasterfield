package NKiralyNo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Vezerek extends JFrame {

	private JPanel contentPane;
	private JPanel table;
	private JTable table_1;
	
	private final int MERET=20;
	private JPanel[][] mezok;
	private int[] megoldas;
	private Idozito idozito;
	private int megoldasMutatao=0;
	
	private boolean lerakhato() {
		boolean lerakhato=true;
		for (int i = 0; i < megoldasMutatao-1; i++) {
			if (utesben(i,megoldas[i],megoldasMutatao,megoldas[megoldasMutatao])) {
				lerakhato=false;
			}
		}
		
		return lerakhato;
	}
	
	private boolean utesben(int x1, int y1, int x2, int y2) {
		return y1==y2 || Math.abs(x1-x2)==Math.abs(y1-y2);
	}

	public void backTrack() {
		
		megoldas[megoldasMutatao]++;
		if(megoldas[megoldasMutatao]>=MERET) {
			megoldas[megoldasMutatao]=-1;
			megoldasMutatao--;
		}else {
			if(lerakhato()) {
				megoldasMutatao++;
			}
		}
		if(megoldasMutatao==MERET) {
			System.out.println("Megoldas");
			idozito.setFuthat(false);
		}
		if(megoldasMutatao==-1) {
			System.out.println("Nincs Megoldas");
			idozito.setFuthat(false);
		}
		megjelenit();
	}

	/**
	 * Create the frame.
	 */
	public Vezerek() {
		
		megoldas=new int[MERET];
		
		for (int i = 0; i < megoldas.length; i++) {
			megoldas[i]=-1;
		}
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JPanel();
		table.setBounds(10, 0, 400, 400);
		contentPane.add(table);
		table.setLayout(null);
		
		tablaGeneral();
		
		
		JButton btnNewButton = new JButton("kl\u00E9p\u00E9s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(420, 359, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnInditas = new JButton("inditas");
		btnInditas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnInditas.setBounds(519, 359, 89, 23);
		contentPane.add(btnInditas);
		
		JButton btnMentes = new JButton("mentes");
		btnMentes.setBounds(618, 359, 89, 23);
		contentPane.add(btnMentes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(453, 44, 218, 204);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "tulajdonsagok"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(119);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(235);
	}

	protected void start() {
		idozito=new Idozito(this);
		idozito.start();
		
	}

	private void tablaGeneral() {
		mezok= new JPanel[MERET][MERET];
		for (int i = 0; i < MERET; i++) {
			for (int j = 0; j < MERET; j++) {
				JPanel panel = new JPanel();
				panel.setBorder(new LineBorder(new Color(0,0,0)));
				panel.setBounds(i*(400/MERET), j*(400/MERET), 400/MERET, 400/MERET);
				table.add(panel);
				mezok[i][j]=panel;
			}
		}
		
		megjelenit();
		validate();
		repaint();
		
		
	}

	private void megjelenit() {
		tableReset();
		for (int i = 0; i < megoldas.length; i++) {
			if(megoldas[i]>-1) {
				mezok[megoldas[i]][i].setBackground(Color.GRAY);
			}
		}
	}

	private void tableReset() {
		for (int i = 0; i < MERET; i++) {
			for (int j = 0; j < MERET; j++) {
				mezok[i][j].setBackground(Color.WHITE);
			}
		}
		
	}
}
