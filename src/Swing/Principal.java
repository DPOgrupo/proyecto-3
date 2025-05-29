package Swing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;

public class Principal {

	public static void main(String[ ] args) {

		//inicioSecion
		MyFrame menu = new MyFrame();
	    menu.setTitle("Menu");
	    menu.setSize(550,600);
	    
        // Cambiar el background del ContentPane
        //inicioSecion.getContentPane().setBackground(new Color(0xBCEDF6));
	
	    //Label
	    
	    MyLabel AventuraMax = new MyLabel();
	    
	    AventuraMax.setBackground(new Color(0xBCEDF6));
	    AventuraMax.setSize(400,250);
	    ImageIcon logo = new ImageIcon("Adobe Express - file.png");
	    AventuraMax.setIcon(logo);
	    
	    
	    
	    //Botones
	    	
	    MyButton BIniciarSecion = new MyButton();
	    BIniciarSecion.setText("Iniciar Secion");
	    						//x , y ,  tamaño x , tamaño y
		BIniciarSecion.setBounds(150,350,200,50);
		
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
        
        //CrearCuenta
        MyButton BCrearCuenta = new MyButton();
        BCrearCuenta.setText("Crear Cuenta");
        BCrearCuenta.setBounds(150,450,200,50);
        BCrearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
                
            }
        });
        
        
        /*
        //Boton Mapa
        MyButton BMapa = new MyButton();
        BMapa.setText("MAPA");
        BMapa.setBounds(150,550,200,50);
        BMapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear frame para el mapa
                JFrame frameMapa = new JFrame("Mapa");
                frameMapa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                // Crear label con la imagen
                JLabel labelMapa = new JLabel();
                ImageIcon imagenMapa = new ImageIcon("mapa1.png");
                labelMapa.setIcon(imagenMapa);
                
                // El frame se ajusta al tamaño de la imagen
                frameMapa.add(labelMapa);
                frameMapa.pack(); // Ajusta automáticamente el tamaño
                frameMapa.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                frameMapa.setVisible(true);
            }
        });
        */
        
        
        
        
        menu.add(AventuraMax);
        
	    menu.add(BCrearCuenta);
	    menu.add(BIniciarSecion);
		menu.setVisible(true);
	}
}