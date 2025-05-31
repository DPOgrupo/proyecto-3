package admin;

import javax.swing.*;
import java.awt.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;

public class VentanaCrearTienda extends JFrame {

    public VentanaCrearTienda(AdministradorAtraccionesYLugares adminAtr) {
        setTitle("VentanaCrearTienda");
        setSize(500, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        setLocationRelativeTo(null);

        JLabel lblJuguetes = new JLabel("Numero de juguetes:");
        JTextField txtJuguetes = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            String txt = txtJuguetes.getText().trim();
            if (txt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Se necesita el numero.");
                return;
            }

            int juguetes = Integer.parseInt(txt);
            adminAtr.crearTienda(juguetes);
            JOptionPane.showMessageDialog(this, "Operación exitosa.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        add(lblJuguetes);
        add(txtJuguetes);
        add(btnAceptar);
        add(btnCancelar);

        setVisible(true);
    }
}
