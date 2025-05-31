package admin;

import javax.swing.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;

public class VentanaCrearAtraccionCultural {

    public VentanaCrearAtraccionCultural(AdministradorAtraccionesYLugares adminAtr) {
        JTextField txtNombre = new JTextField();
        JTextField txtTemporada = new JTextField();
        JTextField txtUbicacion = new JTextField();
        JTextField txtClima = new JTextField();
        JTextField txtMinEmp = new JTextField();
        JTextField txtExclu = new JTextField();
        JTextField txtEdad = new JTextField();
        JTextField txtCupo = new JTextField();
        JTextField txtRiesgo = new JTextField();

        Object[] campos = {
            "Nombre:", txtNombre,
            "Temporada:", txtTemporada,
            "Ubicación:", txtUbicacion,
            "Clima:", txtClima,
            "Mínimo empleados:", txtMinEmp,
            "Exclusividad (1-4):", txtExclu,
            "Edad mínima:", txtEdad,
            "Cupo máximo:", txtCupo,
            "Nivel de riesgo:", txtRiesgo
        };

        int opcion = JOptionPane.showConfirmDialog(null, campos, "Crear Atracción Cultural", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                String nombre = txtNombre.getText().trim();
                String temporada = txtTemporada.getText().trim();
                String ubicacion = txtUbicacion.getText().trim();
                String clima = txtClima.getText().trim();
                
                int minEmp = Integer.parseInt(txtMinEmp.getText().trim());
                int exclu = Integer.parseInt(txtExclu.getText().trim());
                int edad = Integer.parseInt(txtEdad.getText().trim());
                int cupo = Integer.parseInt(txtCupo.getText().trim());
                String riesgo = txtRiesgo.getText().trim();

                adminAtr.crearAtraccionCultural(nombre, temporada, ubicacion, clima, minEmp, exclu, edad, cupo, riesgo);
                
                JOptionPane.showMessageDialog(null, "Atracción cultural creada exitosamente.");
            } catch (Exception e) {
            	
                JOptionPane.showMessageDialog(null, "Error en los datos ingresados.");
            }
        }
    }
}
