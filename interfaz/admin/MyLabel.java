package admin;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

public class MyLabel extends JLabel {
	//ImageIcon image = new ImageIcon("bart.png");
	//EL BORDE
	Border border = BorderFactory.createLineBorder(new Color (78, 22 , 23) , 5);
	
	MyLabel(){
	
		
		//LABEL Bart sentado
		//this.setText("Bart sentao");
		
		//this.setSize(300, 300); // Cambiar de 250,250 a 300,300
	    this.setBounds(50, 50, 300, 300);
	    
	    //Poner la imagen
		//this.setIcon(image);
		
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.TOP);
		
		
		this.setForeground(new Color (250,250,250));
		//this.setBackground(new Color (123,50,250));
		this.setOpaque(true);
		
		this.setBorder(border);
		this.setVerticalAlignment(JLabel.CENTER);	
		this.setHorizontalAlignment(JLabel.CENTER);	
		
	}
}
