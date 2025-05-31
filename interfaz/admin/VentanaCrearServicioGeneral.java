package admin;

import javax.swing.*;
import java.awt.*;
import Empleados.AdministradorEmpleados;
import persistencia.PersistenciaEmpleados;

public class VentanaCrearServicioGeneral extends JFrame {

    public VentanaCrearServicioGeneral(AdministradorEmpleados adminEmp) {
        setTitle("VentanaCrearServicioGeneral");
        setSize(500, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(null);

        JLabel lblLogin = new JLabel("Login:");
        JTextField txtLogin = new JTextField();
        JLabel lblContraseña = new JLabel("Contraseña:");
        JTextField txtContraseña = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            String login = txtLogin.getText();
            String contraseña = txtContraseña.getText();
            if (login.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Login requerido."); return;
            }
            if (contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Contraseña requerido."); return;
            }
            adminEmp.crearServicioGeneral(login, contraseña);
            PersistenciaEmpleados.cargarEmpleados(adminEmp);

            JOptionPane.showMessageDialog(this, "Operación exitosa.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        add(lblLogin);
        add(txtLogin);
        add(lblContraseña);
        add(txtContraseña);

        add(btnAceptar);
        add(btnCancelar);

        setVisible(true);
    }
}
