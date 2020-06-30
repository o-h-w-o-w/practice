package nov30;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class UI extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -5145050822199635016L;
	
	private JButton performAction, exit;
	private JTextArea outputDisplay;

	public UI() {
		super(new BorderLayout());
		/* [JTextArea] */
		outputDisplay = new JTextArea(10, 35);
		outputDisplay.setEditable(false);
		outputDisplay.setMargin(new Insets(2,2,2,2));
		/* [JButtons] */
		// JButton Objects
		performAction = new JButton("Calculate");
		exit = new JButton("Exit");
		// JButton Action Listeners
		performAction.addActionListener(this);
		exit.addActionListener(this);
		/* [Radio Buttons] */
		// JRadioButton Objects
		JRadioButton addButton = new JRadioButton("Addition");
		JRadioButton subtractButton = new JRadioButton("Subtraction");
		JRadioButton compareButton = new JRadioButton("Compare");
		// ButtonGroup 
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(addButton);
		buttonGroup.add(subtractButton);
		buttonGroup.add(compareButton);
		addButton.addItemListener(new HandlerClass(addButton));
		subtractButton.addItemListener(new HandlerClass(subtractButton));
		compareButton.addItemListener(new HandlerClass(compareButton));
		// Radio Button Action Listeners
		addButton.addActionListener(this);
		subtractButton.addActionListener(this);
		compareButton.addActionListener(this);
		
		/* [Add to Frame] */
		// JPanel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(performAction);
		buttonPanel.add(exit);
		buttonPanel.add(addButton);
		buttonPanel.add(subtractButton);
		buttonPanel.add(compareButton);
		
		
		add(buttonPanel,BorderLayout.PAGE_START);
		add(outputDisplay,BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent event) {
	//	if(event.getSource()==//this would be the button)
		if(event.getSource()==performAction) {
			Main main = new Main();
			ItemHan
		//	}
		}else if(event.getSource()==exit) {

			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				// User Selects Yes Option
				JOptionPane.showMessageDialog(null, "Exiting Program.");
				System.exit(0);
			}else {
				// User Selects No Option
				JOptionPane.showMessageDialog(null, "Returning to program.");
			}
		}
	}
	private class HandlerClass implements ItemListener{
		
		public HandlerClass()
		public void itemStateChanged(ItemEvent event) {
			
		}
		
	}
	public static void showGUI() {
		JFrame frame = new JFrame("Quick Maths");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new UI());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}