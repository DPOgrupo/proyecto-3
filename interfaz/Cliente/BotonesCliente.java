package Cliente;

import javax.swing.*;
import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;

public class BotonesCliente extends JPanel {

    private boolean haEntrado = false;

    public BotonesCliente(JFrame frame, Cliente cliente, AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr) {
        setLayout(null);
        setBounds(0, 250, 550, 300);

        // Botón Comprar Tiquete
        MyButton btnComprar = new MyButton();
        btnComprar.setText("Comprar Tiquete");
        btnComprar.setBounds(150, 60, 200, 40);
        btnComprar.addActionListener(e -> AccionesCliente.comprarTiquete(cliente, adminAtr));
        add(btnComprar);

        // Botón Entrar al Parque
        MyButton btnEntrar = new MyButton();
        btnEntrar.setText("Entrar al Parque");
        btnEntrar.setBounds(150, 110, 200, 40);
        add(btnEntrar);

        MyButton btnUsar = new MyButton();
        btnUsar.setText("Usar Tiquete");
        btnUsar.setBounds(150, 160, 200, 40);
        btnUsar.addActionListener(e -> AccionesCliente.usarTiquete(cliente, adminAtr, frame));

        MyButton btnTienda = new MyButton();
        btnTienda.setText("Comprar en Tienda");
        btnTienda.setBounds(150, 210, 200, 40);
        btnTienda.addActionListener(e -> AccionesCliente.comprarEnTienda(cliente, adminAtr, frame));

        MyButton btnCafe = new MyButton();
        btnCafe.setText("Comprar en Cafetería");
        btnCafe.setBounds(150, 260, 200, 40);
        btnCafe.addActionListener(e -> AccionesCliente.comprarEnCafeteria(cliente, adminAtr, frame));

        MyButton btnSalir = new MyButton();
        btnSalir.setText("Salir");
        btnSalir.setBounds(150, 110, 200, 40);
        btnSalir.addActionListener(e -> AccionesCliente.salirYGuardar(frame, adminTiquetes, adminAtr));



        // Acción del botón Entrar al Parque
        btnEntrar.addActionListener(e -> {
            if (!haEntrado) {
                java.util.List<Tiquete> tiquetes = cliente.getTiquetes();

                if (tiquetes.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No tienes tiquetes disponibles.");
                    return;
                }

                Tiquete[] opciones = tiquetes.toArray(new Tiquete[0]);
                Tiquete seleccionado = (Tiquete) JOptionPane.showInputDialog(
                    frame,
                    "Selecciona el tiquete con el que deseas entrar:",
                    "Entrada al Parque",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
                );

                if (seleccionado == null) return;

                boolean permitirEntrada = false;

                if (seleccionado instanceof TiqueteRegular) {
                    TiqueteRegular t = (TiqueteRegular) seleccionado;
                    if (!t.Isadentro()) {
                        permitirEntrada = true;
                        t.salioDelparque();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Este tiquete ya fue usado para entrar.");
                    }

                } else if (seleccionado instanceof TiqueteIndividual) {
                    TiqueteIndividual t = (TiqueteIndividual) seleccionado;
                    if (!t.Isadentro()) {
                        permitirEntrada = true;
                        t.salioDelparque();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Este tiquete ya fue usado para entrar.");
                    }

                } else if (seleccionado instanceof TiqueteFastPass || seleccionado instanceof TiqueteTemporada) {
                    if (seleccionado.esValidoPara("")) {
                        permitirEntrada = true;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Este tiquete no está dentro del rango de fechas.");
                    }
                }

                if (permitirEntrada) {
                    haEntrado = true;

                    remove(btnEntrar);

                    add(btnUsar);
                    add(btnTienda);
                    add(btnCafe);
                    add(btnSalir);

                    revalidate();
                    repaint();
                }
            }
        });

}
}