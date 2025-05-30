package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Menu extends MyFrame {

	Menu(){
		
		//ESTO VA EN OTRO ARCHIVO
				
			    this.setTitle("Menu");
			    this.setSize(550,600);
			    
		        // Cambiar el background del ContentPane
		        //inicioSecion.getContentPane().setBackground(new Color(0xBCEDF6));
			
			    //Label
			    
			    MyLabel AventuraMax = new MyLabel();
			    
			    AventuraMax.setBackground(new Color(0xBCEDF6));
			    AventuraMax.setSize(450,250);
			    ImageIcon logo = new ImageIcon("logo.png");
			    AventuraMax.setIcon(logo);
			    
			    
			    //TEXTO
			    JLabel textoRol = new JLabel("BIENVENIDO");
		        textoRol.setFont(new Font("Arial", Font.CENTER_BASELINE, 35));  
		        textoRol.setForeground(new Color(0x2C3E50));         
		        textoRol.setHorizontalAlignment(JLabel.CENTER);      
		        int textoWidth = 300;
		        int textoHeight = 40;
		                        
		        textoRol.setBounds(125,325, textoWidth, textoHeight);
		        
		        this.add(textoRol);
			    
			    
			    //Botones
			    	
			    MyButton BIniciarSecion = new MyButton();
			    BIniciarSecion.setText("Iniciar Secion");
			    						//x , y ,  tamaño x , tamaño y
				BIniciarSecion.setBounds(175,375,200,50);
				
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
		        BCrearCuenta.setBounds(175,450,200,50);
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
		        
		        
		        
		        
		        this.add(AventuraMax);
			    this.add(BCrearCuenta);
			    this.add(BIniciarSecion);
				this.setVisible(true);
		
		
		
	}
}
