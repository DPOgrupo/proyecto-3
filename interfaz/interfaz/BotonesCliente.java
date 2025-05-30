package interfaz;

import javax.swing.*;
import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;

public class BotonesCliente extends JPanel {

    public BotonesCliente(JFrame frame, Cliente cliente, AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr) {
        setLayout(null);
        setBounds(0, 250, 550, 300); // Ajusta para que quede debajo del logo

        // Botón Comprar Tiquete
        MyButton btnComprar = new MyButton();
        btnComprar.setText("Comprar Tiquete");
        btnComprar.setBounds(150, 60, 200, 40);
        btnComprar.addActionListener(e -> AccionesCliente.comprarTiquete(cliente, adminAtr));

        // Botón Usar Tiquete
        MyButton btnUsar = new MyButton();
        btnUsar.setText("Usar Tiquete");
        btnUsar.setBounds(150, 110, 200, 40);
        btnUsar.addActionListener(e -> AccionesCliente.usarTiquete(cliente, adminAtr, frame));

        // Botón Tienda
        MyButton btnTienda = new MyButton();
        btnTienda.setText("Comprar en Tienda");
        btnTienda.setBounds(150, 160, 200, 40);
        btnTienda.addActionListener(e -> AccionesCliente.comprarEnTienda(cliente, adminAtr, frame));

        // Botón Cafetería
        MyButton btnCafe = new MyButton();
        btnCafe.setText("Comprar en Cafetería");
        btnCafe.setBounds(150, 210, 200, 40);
        btnCafe.addActionListener(e -> AccionesCliente.comprarEnCafeteria(cliente, adminAtr, frame));

        // Botón Salir
        MyButton btnSalir = new MyButton();
        btnSalir.setText("Salir");
        btnSalir.setBounds(150, 260, 200, 40);
        btnSalir.addActionListener(e -> AccionesCliente.salirYGuardar(frame, adminTiquetes, adminAtr));

        add(btnComprar);
        add(btnUsar);
        add(btnTienda);
        add(btnCafe);
        add(btnSalir);
    }
}
