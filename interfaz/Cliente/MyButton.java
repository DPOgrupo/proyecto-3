package Cliente;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyButton extends JButton {
	public MyButton(){
		
		this.setBounds(200,100,200,50);
		
		this.setText("Boton");
		this.setFocusable(false);
		
		//Color
		this.setBackground(new Color(0x4E71FF));
		//Borde
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setFont(new Font("Comic Sans", Font.BOLD , 15) );	
	}
}
	

