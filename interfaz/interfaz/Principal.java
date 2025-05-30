package interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;

import persistencia.*;

public class Principal {
    public static void main(String[] args) {

        MyFrame menu = new MyFrame();
        menu.setTitle("Menú Principal");
        menu.setSize(550, 600);

        MyLabel AventuraMax = new MyLabel();
        AventuraMax.setBackground(new Color(0xBCEDF6));
        AventuraMax.setSize(400, 250);
        ImageIcon logo = new ImageIcon("Adobe Express - file.png");
        AventuraMax.setIcon(logo);

        // Botón Iniciar sesión
        MyButton BIniciarSecion = new MyButton();
        BIniciarSecion.setText("Iniciar Sesión");
        BIniciarSecion.setBounds(150, 350, 200, 50);
        BIniciarSecion.addActionListener(e -> VentanaLogin.mostrar(menu));

        // Botón Crear cuenta
        MyButton BCrearCuenta = new MyButton();
        BCrearCuenta.setText("Crear Cuenta");
        BCrearCuenta.setBounds(150, 450, 200, 50);
        BCrearCuenta.addActionListener(e -> VentanaRegistro.mostrar(menu));

        menu.add(AventuraMax);
        menu.add(BCrearCuenta);
        menu.add(BIniciarSecion);
        menu.setVisible(true);
    }
}
