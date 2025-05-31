package admin;

import javax.swing.*;
import Empleados.AdministradorEmpleados;

public class VentanaTurnoGlobal extends JFrame {

    public VentanaTurnoGlobal(AdministradorEmpleados adminEmp) {
        setTitle("Cambiar Turno Global");
        setSize(400, 200);
        setLayout(null);

        JLabel label = new JLabel("¿Deseas cambiar el turno global?");
        label.setBounds(50, 30, 300, 30);
        add(label);

        JButton btnCambiar = new JButton("Cambiar Turno");
        btnCambiar.setBounds(120, 80, 150, 40);
        add(btnCambiar);

        btnCambiar.addActionListener(e -> {
            boolean actual = adminEmp.isTurnoGlobalNocturno();
            adminEmp.cambiarTurnoGlobal(!actual);
            JOptionPane.showMessageDialog(this, "Turno global cambiado a " + (!actual ? "Nocturno" : "Diurno"));
            dispose();
        });

        setVisible(true);
    }
}