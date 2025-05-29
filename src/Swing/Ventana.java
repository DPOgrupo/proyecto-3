package Swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Ventana extends JFrame {

		private static JTabbedPane tabbedPane;
		private static JPanel panel1;
		private static JPanel panel2;
		private static JPanel panel3;
		private static JPanel panel4;
		
		public static void main(String[] args) {
			
			
			Ventana ventana = new Ventana();
			ventana.setSize(500,500);
			ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
			tabbedPane = new JTabbedPane();
			panel1 = new JPanel();
			
			
			JLabel lbl = new JLabel("This is a text");
			JButton btn1 = new JButton("Press meeeeee");
			
			btn1.addActionListener(new ActionListener() {		
			
				@Override
				public void actionPerformed(ActionEvent e) {
					JDialog dialog = new JDialog ();
					JPanel innerPane = new JPanel();
					
					JLabel lbl = new JLabel("Hi , this is a popup");
					
					innerPane.add(lbl);
					
					dialog.add(innerPane);
					dialog.setSize(200,200);
					dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					
					dialog.setVisible(true);
				}
			});
			panel1.add(lbl);
			panel1.add(btn1);
			
			panel2 = new JPanel();
			panel3 = new JPanel();
			panel4 = new JPanel();
			
			tabbedPane.add("Tab 1" , panel1);
			tabbedPane.add("Tab 2" , panel2);
			tabbedPane.add("Tab 3" , panel3);
			tabbedPane.add("Tab 4" , panel4);
			
			ventana.add(tabbedPane);
			ventana.setVisible(true);
			
		}		
}