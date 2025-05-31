package admin;

import javax.swing.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;

public class VentanaCrearCafeteria {

    public VentanaCrearCafeteria(AdministradorAtraccionesYLugares adminAtr) {
        JTextField txtComidas = new JTextField();

        Object[] campos = {
            "Cantidad de comidas:", txtComidas
        };

        int opcion = JOptionPane.showConfirmDialog(null, campos, "Crear Cafetería", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                int comidas = Integer.parseInt(txtComidas.getText().trim());
                adminAtr.crearCafeteria(comidas);
                JOptionPane.showMessageDialog(null, "Cafetería creada exitosamente.");
            } catch (Exception e) {
            	
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
            }
        }
    }
}
