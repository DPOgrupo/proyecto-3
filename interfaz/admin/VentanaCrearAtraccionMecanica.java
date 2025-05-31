package admin;

import javax.swing.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;

public class VentanaCrearAtraccionMecanica {

    public VentanaCrearAtraccionMecanica(AdministradorAtraccionesYLugares adminAtr) {
        JTextField txtNombre = new JTextField();
        JTextField txtTemporada = new JTextField();
        JTextField txtUbicacion = new JTextField();
        JTextField txtRiesgo = new JTextField();
        JTextField txtCupo = new JTextField();
        JTextField txtMinEmp = new JTextField();
        JTextField txtExclu = new JTextField();

        Object[] campos = {
            "Nombre:", txtNombre,
            "Temporada:", txtTemporada,
            "Ubicación:", txtUbicacion,
            "Nivel de riesgo:", txtRiesgo,
            "Cupo máximo:", txtCupo,
            "Mínimo empleados:", txtMinEmp,
            "Nivel exclusividad (1-4):", txtExclu
        };

        int opcion = JOptionPane.showConfirmDialog(null, campos, "Crear Atracción Mecánica", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                String nombre = txtNombre.getText().trim();
                String temporada = txtTemporada.getText().trim();
                String ubicacion = txtUbicacion.getText().trim();
                String riesgo = txtRiesgo.getText().trim();
                int cupo = Integer.parseInt(txtCupo.getText().trim());
                int minEmp = Integer.parseInt(txtMinEmp.getText().trim());
                int exclu = Integer.parseInt(txtExclu.getText().trim());

                adminAtr.crearAtraccionMecanica(nombre, temporada, ubicacion, riesgo, cupo, minEmp, exclu);
                JOptionPane.showMessageDialog(null, "Atracción mecánica creada exitosamente.");
            } catch (Exception e) {
            	
                JOptionPane.showMessageDialog(null, "Error en los datos ingresados.");
            }
        }
    }
}
