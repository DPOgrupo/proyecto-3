package admin;

import javax.swing.*;
import java.awt.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;

public class VentanaCrearAtraccionMecanica extends JFrame {

    public VentanaCrearAtraccionMecanica(AdministradorAtraccionesYLugares adminAtr) {
        setTitle("VentanaCrearAtraccionMecanica");
        setSize(500, 500);
        setLayout(new GridLayout(9, 2, 10, 10));
        setLocationRelativeTo(null);

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblTemporada = new JLabel("Temporada:");
        JTextField txtTemporada = new JTextField();
        JLabel lblUbicacion = new JLabel("Ubicacion:");
        JTextField txtUbicacion = new JTextField();
        JLabel lblRiesgo = new JLabel("Riesgo:");
        JTextField txtRiesgo = new JTextField();
        JLabel lblCupo = new JLabel("Cupo:");
        JTextField txtCupo = new JTextField();
        JLabel lblMinemp = new JLabel("Numero minimo de empleados:");
        JTextField txtMinemp = new JTextField();
        JLabel lblExclu = new JLabel("Exclusividad (1 a 4):");
        JTextField txtExclu = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String temporada = txtTemporada.getText().trim();
            String ubicacion = txtUbicacion.getText().trim();
            String riesgo = txtRiesgo.getText().trim();

            int cupo = Integer.parseInt(txtCupo.getText().trim());
            int minEmp = Integer.parseInt(txtMinemp.getText().trim());
            int exclu = Integer.parseInt(txtExclu.getText().trim());

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre requerido."); return;
            }
            if (temporada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Temporada requerida."); return;
            }
            if (ubicacion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ubicación requerida."); return;
            }
            if (riesgo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Riesgo requerido."); return;
            }
            if (exclu < 1 || exclu > 4) {
                JOptionPane.showMessageDialog(this, "Exclusividad debe ser un número entre 1 y 4."); return;
            }

            adminAtr.crearAtraccionMecanica(nombre, temporada, ubicacion, riesgo, cupo, minEmp, exclu);
            JOptionPane.showMessageDialog(this, "Atracción mecánica creada con éxito.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        add(lblNombre); add(txtNombre);
        add(lblTemporada); add(txtTemporada);
        add(lblUbicacion); add(txtUbicacion);
        add(lblRiesgo); add(txtRiesgo);
        add(lblCupo); add(txtCupo);
        add(lblMinemp); add(txtMinemp);
        add(lblExclu); add(txtExclu);
        add(btnAceptar); add(btnCancelar);

        setVisible(true);
    }
}
