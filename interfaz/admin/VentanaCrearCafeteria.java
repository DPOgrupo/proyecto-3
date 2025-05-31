package admin;

import javax.swing.*;
import java.awt.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;

public class VentanaCrearCafeteria extends JFrame {

    public VentanaCrearCafeteria(AdministradorAtraccionesYLugares adminAtr) {
        setTitle("VentanaCrearCafeteria");
        setSize(500, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        setLocationRelativeTo(null);

        JLabel lblComidas = new JLabel("Comidas:");
        JTextField txtComidas = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            String txt = txtComidas.getText().trim();
            if (txt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Comidas requerido.");
                return;
            }

            int comidas = Integer.parseInt(txt);
            adminAtr.crearCafeteria(comidas);
            JOptionPane.showMessageDialog(this, "Operación exitosa.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        add(lblComidas);
        add(txtComidas);
        add(btnAceptar);
        add(btnCancelar);

        setVisible(true);
    }
}
