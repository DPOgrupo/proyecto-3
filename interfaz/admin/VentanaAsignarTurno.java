package admin;

import javax.swing.*;
import Empleados.*;
import AtraccionesYServicio.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentanaAsignarTurno extends JFrame {

    public VentanaAsignarTurno(AdministradorEmpleados adminEmp, AdministradorAtraccionesYLugares adminAtr) {
        setTitle("Asignar Turno a Empleado");
        setSize(500, 400);
        setLayout(new GridLayout(6, 1));

        List<Empleado> empleados = new ArrayList<>();
        empleados.addAll(adminEmp.getCajeros());
        empleados.addAll(adminEmp.getCocineros());
        
        empleados.addAll(adminEmp.getServicios());

        String[] opciones = new String[empleados.size()];
        for (int i = 0; i < empleados.size(); i++) {
        	
            opciones[i] = empleados.get(i).getLogin();
        }

        JComboBox<String> comboEmpleado = new JComboBox<>(opciones);
        add(new JLabel("Selecciona un empleado:"));
        add(comboEmpleado);

        JCheckBox esNocturno = new JCheckBox("Turno Nocturno");
        add(esNocturno);

        JRadioButton rAtraccion = new JRadioButton("Atracción");
        JRadioButton rServicio = new JRadioButton("Lugar de Servicio");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rAtraccion);
        
        grupo.add(rServicio);

        add(rAtraccion);
        add(rServicio);

        JButton confirmar = new JButton("Asignar");
        confirmar.addActionListener((ActionEvent e) -> {
            String login = (String) comboEmpleado.getSelectedItem();
            Empleado empleado = empleados.stream()
                    .filter(emp -> emp.getLogin().equals(login))
                    .findFirst()
                    .orElse(null);

            boolean turnoNoche = esNocturno.isSelected();
            Turno turno = null;

            if (rAtraccion.isSelected()) {
                List<Atraccion> atrs = new ArrayList<>();
                atrs.addAll(adminAtr.getMecanicas());
                atrs.addAll(adminAtr.getCulturales());
                if (!atrs.isEmpty()) {
                    Atraccion atraccion = atrs.get(0); // por defecto el primero
                    turno = adminEmp.crearTurno(LocalDate.now(), turnoNoche, atraccion);
                }
            } else if (rServicio.isSelected()) {
                if (!adminAtr.getTiendas().isEmpty()) {
                    turno = adminEmp.crearTurno(LocalDate.now(), turnoNoche, adminAtr.getTiendas().get(0));
                } else if (!adminAtr.getCafeterias().isEmpty()) {
                    turno = adminEmp.crearTurno(LocalDate.now(), turnoNoche, adminAtr.getCafeterias().get(0));
                }
            }

            if (empleado != null && turno != null) {
                adminEmp.cambiarTurno(empleado, turno);
                JOptionPane.showMessageDialog(this, "Turno asignado correctamente.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al asignar turno.");
            }
        });
        add(confirmar);
        setVisible(true);
    }
}