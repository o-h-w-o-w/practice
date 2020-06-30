/* Julian Mayugba
 * Java Programming CLass
 * Professor A
 * 9/21/17
 * This program will calculate the slope from point A to point B.
*/
import javax.swing.JOptionPane;

public class SlopeCalc {

	public static void main(String[] args) {
		//intro
		JOptionPane.showMessageDialog(null, "This program will calculate the slope from point A to point B");
		//var decl
		double xP1 = 0, xP2 = 0, yP1 = 0, yP2 = 0, slope = 0;
		//point 1
		xP1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the first point's x-coor: "));
		yP1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the first point's y-coor: "));
		//point 2
		xP2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second point's x-coor: "));
		yP2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second point's y-coor: "));	
		//slope calc
		slope = (yP2 - yP1) / (xP2 - xP1);
		JOptionPane.showMessageDialog(null, slope);
		
	}
}