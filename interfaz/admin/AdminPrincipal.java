package admin;

import java.awt.Color;

import javax.swing.ImageIcon;

public class AdminPrincipal {

	public AdminPrincipal() {
		// TODO Auto-generated constructor stub
		
		
		
	}
	 public static void mostrar() {
	        MyFrame menu = new MyFrame();
	        menu.setTitle("Menú Principal");
	        menu.setSize(550, 600);

	        MyLabel AventuraMax = new MyLabel();
	        AventuraMax.setBackground(new Color(0xFF392C));

	        AventuraMax.setSize(400, 250);
	        ImageIcon logo = new ImageIcon("logo.png");
	        AventuraMax.setIcon(logo);

	        MyButton BIniciarSecion = new MyButton();
	        BIniciarSecion.setText("Iniciar Sesión");
	        BIniciarSecion.setBounds(150, 350, 200, 50);
	        BIniciarSecion.addActionListener(e -> VentanaLogin.mostrar(menu));

	        
	        menu.add(AventuraMax);
	
	        menu.add(BIniciarSecion);
	        menu.setVisible(true);
	    }






   

    public static void main(String[] args) {
        mostrar();
    }
}