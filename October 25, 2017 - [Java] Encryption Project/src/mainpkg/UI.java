package mainpkg;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UI extends JPanel implements ActionListener {
	private JButton encryptFile;
	private JTextArea logArea;
	private JFileChooser fileChoose;
	private Crypt crypt;

	public UI() {
		super(new BorderLayout());
		//eventlog+filechoose
		logArea = new JTextArea(35,65);
		logArea.setMargin(new Insets(5,5,5,5));
		logArea.setEditable(false);
		JScrollPane logPane = new JScrollPane(logArea);
		fileChoose = new JFileChooser();
		//encrypt button
		encryptFile = new JButton("Decrypt");
		encryptFile.addActionListener(this);
		//layout
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(encryptFile);
		add(buttonPanel,BorderLayout.PAGE_START);
		add(logPane,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent event) {
		crypt = new Crypt();
		if(event.getSource()==encryptFile) { //encrypt button
			int returnVal = fileChoose.showOpenDialog(UI.this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChoose.getSelectedFile();
				Crypt.encrypt(file);
				//logArea.append("[File Open] " + file.getName() + ".\n");
				logArea.append(Crypt.current);
			}else {
				logArea.append("[Canceled Decryption]\n");
			}
			logArea.setCaretPosition(logArea.getDocument().getLength());
		}
	}
	public static void showGUI() {
		JFrame frame = new JFrame("Decrypt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new UI());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
