package admin;

import javax.swing.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;

public class VentanaCrearTienda {

    public VentanaCrearTienda(AdministradorAtraccionesYLugares adminAtr) {
        JTextField txtJuguetes = new JTextField();

        Object[] campos = {
            "Número de juguetes:", txtJuguetes
        };

        int opcion = JOptionPane.showConfirmDialog(null, campos, "Crear Tienda", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                int juguetes = Integer.parseInt(txtJuguetes.getText().trim());
                adminAtr.crearTienda(juguetes);
                JOptionPane.showMessageDialog(null, "Tienda creada exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida.");
            }
        }
    }
}
