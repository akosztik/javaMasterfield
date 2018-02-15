package Client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JList listParticipant;
	private JTextField message;
	private JTextArea textAreaChat;
	private Socket sock;


	/**
	 * Create the frame.
	 */
	public ClientFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				netWrite("exits:"+userName.getText());
				dispose();
			}
		});
		setTitle("Chat");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 290, 216);
		contentPane.add(scrollPane);
		
		textAreaChat = new JTextArea();
		textAreaChat.setEditable(false);
		scrollPane.setViewportView(textAreaChat);
		
		message = new JTextField();
		message.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		message.setEnabled(false);
		message.setBounds(10, 227, 280, 34);
		contentPane.add(message);
		message.setColumns(10);
		
		JButton btnKlds = new JButton("k\u00FCld\u00E9s");
		btnKlds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sendMessage();
			}
		});
		btnKlds.setBounds(323, 233, 89, 23);
		contentPane.add(btnKlds);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(303, 22, 65, 14);
		contentPane.add(lblNickname);
		
		userName = new JTextField();
		userName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userName.getText().length()>0) {
					message.setEnabled(true);
					userName.setEditable(false);
					message.requestFocus();
				}
			}
		});
		userName.setBounds(303, 47, 121, 17);
		contentPane.add(userName);
		userName.setColumns(10);
		
		listParticipant = new JList();
		listParticipant.setBounds(303, 104, 121, 112);
		contentPane.add(listParticipant);
		
		JLabel lblActive = new JLabel("Participant");
		lblActive.setBounds(303, 75, 95, 18);
		contentPane.add(lblActive);
		repaint();
		userName.requestFocus();
		netRead();
		
		
	}


	private void netRead() {
		try {
			sock=new Socket("localhost",1035);
			InputStreamReader isr=null;
			isr = new InputStreamReader(sock.getInputStream());
			BufferedReader br= new BufferedReader(isr);
			while(true) {
				//System.out.println(br.readLine());
				String text=br.readLine();
				textAreaChat.append(text+"\n");
				String[] textParts=text.split(":");
				
				DefaultListModel dfm=null;
				try {
				dfm=(DefaultListModel)listParticipant.getModel();
				}catch (Exception e){
					dfm=new DefaultListModel();
					listParticipant.setModel(dfm);
				}
				if(!dfm.contains(textParts[0]) && !dfm.contains(textParts[0])) {
					(dfm).addElement(textParts[0]);
				}
				if (textParts[1]=="exits") {
					(dfm).removeElement(textParts[0]);
				}
				
			}
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		
	}
	public void netWrite(String text) {
		try {
			OutputStream os = sock.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println(text);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void sendMessage() {
		netWrite(userName.getText()+": "+message.getText());
		message.setText("");
		message.requestFocus();
	}
}
