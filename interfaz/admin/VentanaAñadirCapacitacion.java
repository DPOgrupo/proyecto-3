package admin;

import javax.swing.*;
import Empleados.*;
import AtraccionesYServicio.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaAñadirCapacitacion extends JFrame {

    public VentanaAñadirCapacitacion(AdministradorEmpleados adminEmp, AdministradorAtraccionesYLugares adminAtr) {
        setTitle("Añadir Capacitación");
        setSize(400, 300);
        setLayout(new BorderLayout());

        List<Empleado> empleados = new ArrayList<>();
        empleados.addAll(adminEmp.getCajeros());
        empleados.addAll(adminEmp.getCocineros());
        empleados.addAll(adminEmp.getServicios());

        String[] opciones = new String[empleados.size()];
        for (int i = 0; i < empleados.size(); i++) {
            opciones[i] = empleados.get(i).getLogin();
        }

        JComboBox<String> comboBox = new JComboBox<>(opciones);
        add(comboBox, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        JCheckBox cocina = new JCheckBox("COCINA");
        JCheckBox medio = new JCheckBox("MANTENIMIENTO_MEDIO");
        JCheckBox alto = new JCheckBox("MANTENIMIENTO_ALTO");
        panelBotones.add(cocina);
        panelBotones.add(medio);
        panelBotones.add(alto);
        add(panelBotones, BorderLayout.CENTER);

        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener((ActionEvent e) -> {
            String loginSeleccionado = (String) comboBox.getSelectedItem();
            Empleado empleado = empleados.stream()
                .filter(emp -> emp.getLogin().equals(loginSeleccionado))
                .findFirst()
                .orElse(null);

            if (empleado != null) {
                if (cocina.isSelected()) adminEmp.añadirCapacitacion(empleado, "COCINA");
                if (medio.isSelected()) adminEmp.añadirCapacitacion(empleado, "MANTENIMIENTO_MEDIO");
                if (alto.isSelected()) adminEmp.añadirCapacitacion(empleado, "MANTENIMIENTO_ALTO");
                JOptionPane.showMessageDialog(this, "Capacitaciones añadidas.");
                dispose();
            }
        });

        add(confirmar, BorderLayout.SOUTH);
        setVisible(true);
    }
}