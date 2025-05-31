package Swing;




import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

import Cliente.MenuCliente;
import Empleado.MenuEmpleado;
import Empleado.VentanaLogin;

public class Principal {
    public static void main(String[] args) {
        // Inicialización del menú principal
        MyFrame menuPrincipal = new MyFrame();
        menuPrincipal.setTitle("Menu Principal");
        menuPrincipal.setSize(600, 650);
        menuPrincipal.getContentPane().setBackground(new Color(0xD0DDD0));
        menuPrincipal.setLayout(null);
        
        // Logo del menú
        MyLabel menulogo = new MyLabel();
        Border border = BorderFactory.createLineBorder(new Color(0x291392), 8);
        menulogo.setBorder(border);
        int labelWidth = 325;
        int labelHeight = 300;
        menulogo.setSize(labelWidth, labelHeight);
        int frameWidth = 600;
        int x = (frameWidth - labelWidth) / 2;
        int y = 30;
        menulogo.setBounds(x, y, labelWidth, labelHeight);
        ImageIcon imagenMenu = new ImageIcon("MenuLogo.png");
        menulogo.setIcon(imagenMenu);
        
        // Texto de rol
        JLabel textoRol = new JLabel("¿Cómo deseas ingresar?");
        textoRol.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));  
        textoRol.setForeground(new Color(0x2C3E50));         
        textoRol.setHorizontalAlignment(JLabel.CENTER);      
        int textoWidth = 300;
        int textoHeight = 40;
        int textoX = (frameWidth - textoWidth) / 2;          
        int textoY = y + labelHeight + 20;                  
        textoRol.setBounds(textoX, textoY, textoWidth, textoHeight);

        // Botón Cliente
        MyButton BCliente = new MyButton();
        BCliente.setText("Cliente");
        BCliente.setBounds(100, 400, 200, 50);
        BCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MenuCliente.mostrar(); 
            }
        });
        
        // Botón Empleado
        MyButton BEmpleado = new MyButton();
        BEmpleado.setText("Empleado");
        BEmpleado.setBounds(325, 400, 200, 50);
        BEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear menú personalizado para empleado
            	
            	
                MyFrame menuEmpleado = new MyFrame();
            
                menuEmpleado.setTitle("Menu Empleado");
                menuEmpleado.setSize(550, 600);
                menuEmpleado.setLayout(null);

		        menuEmpleado.getContentPane().setBackground(new Color(0xfcfbfc));
                
                // Imagen del empleado
                MyLabel imagenEmpleado = new MyLabel();
                
                Border border = BorderFactory.createLineBorder(new Color (78, 22 , 23) , 0);
                imagenEmpleado.setBorder(border);
                
                imagenEmpleado.setBounds(130, 50, 300, 300); // Posición y tamaño definidos
                ImageIcon logoEmpleado = new ImageIcon("empleadoImagen.png");
                imagenEmpleado.setIcon(logoEmpleado);
                
                //BOTON EMPELADO INICIAR SECION
                MyButton BIniciarSecion = new MyButton();
			    BIniciarSecion.setText("Iniciar Secion");
			    						//x , y ,  tamaño x , tamaño y
				BIniciarSecion.setBounds(180,370,200,50);

				BIniciarSecion.setBackground(new Color(0xFF392C));
				
			    //Accion Iniciar Secion
		        BIniciarSecion.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	MenuEmpleado.mostrar();
		            		
		            }
		        });
                
                
                
                // Agregar componentes y mostrar
		        menuEmpleado.add(BIniciarSecion);
                menuEmpleado.add(imagenEmpleado);
                menuEmpleado.setVisible(true);
            }
        });
        
        // Botón Administrador
        MyButton BAdmin = new MyButton();
        BAdmin.setText("Administrador");
        BAdmin.setBounds(210, 500, 200, 50);
        BAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame menuAdmin = new MyFrame();
                menuAdmin.setTitle("Menu Administrador");
                
                menuAdmin.setSize(550, 600);
                menuAdmin.setLayout(null);

                menuAdmin.getContentPane().setBackground(new Color(0xE6763C));
                
                // Imagen del admin
                MyLabel imagenAdmin = new MyLabel();
                
                Border border = BorderFactory.createLineBorder(new Color (78, 22 , 23) , 10);
                imagenAdmin .setBorder(border);
                
                imagenAdmin .setBounds(130, 50, 300, 300); // Posición y tamaño definidos
                ImageIcon logoAdmin = new ImageIcon("empleadoImagen.png");
                imagenAdmin .setIcon(logoAdmin);
                
                //BOTON EMPELADO INICIAR SECION
                MyButton BIniciarSecion = new MyButton();
			    BIniciarSecion.setText("Iniciar Secion");
			    						//x , y ,  tamaño x , tamaño y
				BIniciarSecion.setBounds(170,400,215,65);

				BIniciarSecion.setBackground(new Color(0xFF392C));
				
			    //Accion Iniciar Secion
		        BIniciarSecion.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            		MyFrame frameIniciar = new MyFrame();
		            		frameIniciar.setSize(500,500);
		            		frameIniciar.setVisible(true);
		            		frameIniciar.setTitle("Iniciar Secion");
		            }
		        });
               
                // Agregar componentes y mostrar
		        menuAdmin.add(BIniciarSecion);
                menuAdmin.add(imagenAdmin);
                menuAdmin.setVisible(true);                
            }
        });
        
        // Agregar todos los componentes al frame principal
        menuPrincipal.add(menulogo);
        menuPrincipal.add(textoRol);
        menuPrincipal.add(BCliente);
        menuPrincipal.add(BEmpleado);
        menuPrincipal.add(BAdmin);
        menuPrincipal.setVisible(true);
    }
}