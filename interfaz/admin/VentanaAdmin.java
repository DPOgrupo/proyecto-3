package admin;

import javax.swing.*;
import java.awt.Color;
import javax.swing.ImageIcon;

import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;

public class VentanaAdmin {

    public static void mostrar(Cliente cliente, AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr, AdministradorEmpleados adminEmple) {
        MyFrame frame = new MyFrame();
        frame.setTitle("Menú Cliente - " + cliente.getNombre());
        frame.setSize(550, 600);

        // Logo superior
        MyLabel logo = new MyLabel();
        logo.setBackground(new Color(0xBCEDF6));
        logo.setSize(400, 250);
        logo.setIcon(new ImageIcon("logo.png"));

        // Panel de botones
        BotonesAdmin panel = new BotonesAdmin(frame, cliente, adminTiquetes, adminAtr,adminEmple);

        frame.add(logo);
        frame.add(panel);
        frame.setVisible(true);
    }
}
