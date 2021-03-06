package NKiralyNo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;

public class Vezerek extends JFrame {

	private JPanel contentPane;
	private JPanel table;
	private JTable table_1;
	
	private int MERET;
	private JPanel[][] mezok;
	private int[] megoldas;
	private Idozito idozito;
	private int megoldasMutatao=0;
	private JSpinner spinner;
	private int megoldasSzamlalo=0;
	private long start;
	private JCheckBox chckbxForwardcheking;
	private boolean[][] foglaltsag;
	private JButton btnMutat;
	
	private void init() {
		
		tablaTakarit();
		MERET=((Integer)spinner.getValue()).intValue();
		megoldas=new int[MERET];
		foglaltsag = new boolean[MERET][MERET];
		
		for (int i = 0; i < megoldas.length; i++) {
			megoldas[i]=-1;
		}
		tablaGeneral();
		megoldasMutatao=0;
		megoldasSzamlalo=0;
	}
	private void tablaTakarit() {
		Component[] panelek=table.getComponents();
		for (int i = 0; i < panelek.length; i++) {
			panelek[i]=null;
		}
		table.repaint();
		
	}
	private boolean lerakhato() {
		boolean lerakhato=true;
		for (int i = 0; i <= megoldasMutatao-1; i++) {
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
			foglalasFelszab();
			megoldasMutatao--;
			
		}else {
			if(lerakhato() && forwardChecking()) {
				
				megoldasMutatao++;
			}
		}
		if(megoldasMutatao==MERET) {
			megoldasSzamlalo++;
			System.out.println("Megoldasszam: "+megoldasSzamlalo);
			Object[] ujSor=new Object[2];
			ujSor[0]=megoldasSzamlalo;
			ujSor[1]="";
			for (int i = 0; i < megoldas.length; i++) {
				ujSor[1]+=megoldas[i]+",";
			}
			((DefaultTableModel)table_1.getModel()).addRow(ujSor);
			//idozito.setFuthat(false);
			megoldasMutatao--;
		}
		if(megoldasMutatao==-1) {
			if(megoldasMutatao==0) {
				System.out.println("Nincs Megoldas");
			}
			idozito.setFuthat(false);
			long stop= Calendar.getInstance().getTimeInMillis();
			System.out.println("Futasi ido: "+ (stop-start));
		}
		megjelenit();
	}

	private boolean forwardChecking() {
		if (!chckbxForwardcheking.isSelected()) {
			return true;
		}
		boolean vanHely=false;
		for (int i = 0; i < megoldasMutatao+1; i++) {
			boolean mindTrue=true;
			for (int j = 0; j < foglaltsag.length; j++) {
				if(!foglaltsag[i][j]) {
					mindTrue=false;
				}
			}
			if (mindTrue) {
				vanHely=false;
			}
		}
		if (vanHely) {
			foglalas(megoldasMutatao);
		}
	
		
		return vanHely;
	}
	private void foglalas(int megoldasMutatao2) {
		for (int i = 0; i < foglaltsag.length; i++) {
			for (int j = megoldasMutatao2+1; j < foglaltsag.length; j++) {
				if(utesben(megoldasMutatao2,megoldas[megoldasMutatao2],i,j)) {
					foglaltsag[i][j]=true;
				}
			}
		}
		
	}
	private void foglalasFelszab() {
		foglaltsag=new boolean[MERET][MERET];
		for (int i = 0; i <= megoldasMutatao-1; i++) {
			foglalas(i);
			
		}
	}
	private void eredmenyFileba() {
		try {
			FileWriter fw= new FileWriter("eredmeny.txt");
			PrintWriter pw =new PrintWriter(fw);
			int sorok=table_1.getModel().getRowCount();
			for (int i = 0; i < sorok; i++) {
				pw.println(table_1.getModel().getValueAt(i,0)+" "+table_1.getModel().getValueAt(i, 1));
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * Create the frame.
	 */
	public Vezerek() {
		
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
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(8, 2, 50, 1));
		spinner.setBounds(420, 11, 78, 23);
		contentPane.add(spinner);
		
		init();
		
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
		btnMentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eredmenyFileba();
			}
		});
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
		
		chckbxForwardcheking = new JCheckBox("forwardCheking");
		chckbxForwardcheking.setBounds(416, 299, 97, 23);
		contentPane.add(chckbxForwardcheking);
		
		btnMutat = new JButton("mutat");
		btnMutat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backTrack();
			}
		});
		btnMutat.setBounds(519, 299, 89, 23);
		contentPane.add(btnMutat);
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(119);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(235);
	}

	protected void start() {
		init();
		idozito=new Idozito(this);
		idozito.start();
		start=Calendar.getInstance().getTimeInMillis();
}

	private void tablaGeneral() {
		mezok= new JPanel[MERET][MERET];
		for (int i = 0; i < MERET; i++) {
			for (int j = 0; j < MERET; j++) {
				JPanel panel = new JPanel();
				panel.setBorder(new LineBorder(new Color(0,0,0)));
				panel.setBounds(i*(400/MERET), j*(400/MERET), 400/MERET, 400/MERET);
				JLabel label=new JLabel("x");//folytatni illetve a megjelen�tbe setvisible a foglaltsagon
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
