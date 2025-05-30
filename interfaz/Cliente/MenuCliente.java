package Cliente;

import java.awt.Color;
import javax.swing.ImageIcon;
import persistencia.*;

public class MenuCliente {

    public static void mostrar() {
        MyFrame menu = new MyFrame();
        menu.setTitle("Menú Principal");
        menu.setSize(550, 600);

        MyLabel AventuraMax = new MyLabel();
        AventuraMax.setBackground(new Color(0xBCEDF6));
        AventuraMax.setSize(400, 250);
        ImageIcon logo = new ImageIcon("logo.png");
        AventuraMax.setIcon(logo);

        MyButton BIniciarSecion = new MyButton();
        BIniciarSecion.setText("Iniciar Sesión");
        BIniciarSecion.setBounds(150, 350, 200, 50);
        BIniciarSecion.addActionListener(e -> VentanaLogin.mostrar(menu));

        MyButton BCrearCuenta = new MyButton();
        BCrearCuenta.setText("Crear Cuenta");
        BCrearCuenta.setBounds(150, 450, 200, 50);
        BCrearCuenta.addActionListener(e -> VentanaRegistro.mostrar(menu));

        menu.add(AventuraMax);
        menu.add(BCrearCuenta);
        menu.add(BIniciarSecion);
        menu.setVisible(true);
    }

    public static void main(String[] args) {
        mostrar();
    }
}
