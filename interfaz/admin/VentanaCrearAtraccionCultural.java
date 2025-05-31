package admin;

import javax.swing.*;
import java.awt.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;

public class VentanaCrearAtraccionCultural extends JFrame {

    public VentanaCrearAtraccionCultural(AdministradorAtraccionesYLugares adminAtr) {
        setTitle("VentanaCrearAtraccionCultural");
        setSize(500, 600);
        setLayout(new GridLayout(11, 2, 10, 10));
        setLocationRelativeTo(null);

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblTemporada = new JLabel("Temporada:");
        JTextField txtTemporada = new JTextField();
        JLabel lblUbicacion = new JLabel("Ubicación:");
        JTextField txtUbicacion = new JTextField();
        JLabel lblClima = new JLabel("Clima:");
        JTextField txtClima = new JTextField();
        JLabel lblMinemp = new JLabel("Numero minimo de empleados:");
        JTextField txtMinemp = new JTextField();
        JLabel lblExclu = new JLabel("Exclusividad (1 a 4):");
        JTextField txtExclu = new JTextField();
        JLabel lblEdad = new JLabel("Edad mínima:");
        JTextField txtEdad = new JTextField();
        JLabel lblCupo = new JLabel("Cupo:");
        JTextField txtCupo = new JTextField();
        JLabel lblRiesgo = new JLabel("Restriccion de clima:");
        JTextField txtRiesgo = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        btnAceptar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String temporada = txtTemporada.getText().trim();
            String ubicacion = txtUbicacion.getText().trim();
            String clima = txtClima.getText().trim();
            int minEmp = Integer.parseInt(txtMinemp.getText().trim());
            int exclu = Integer.parseInt(txtExclu.getText().trim());
            int edad = Integer.parseInt(txtEdad.getText().trim());
            int cupo = Integer.parseInt(txtCupo.getText().trim());
            String riesgo = txtRiesgo.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre requerido."); return;
            }
            if (temporada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Temporada requerida."); return;
            }
            if (ubicacion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ubicación requerida."); return;
            }
            if (clima.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Clima requerido."); return;
            }
            if (riesgo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Riesgo requerido."); return;
            }
            if (exclu < 1 || exclu > 4) {
                JOptionPane.showMessageDialog(this, "Exclusividad debe estar entre 1 y 4."); return;
            }

            adminAtr.crearAtraccionCultural(nombre, temporada, ubicacion, clima, minEmp, exclu, edad, cupo, riesgo);
            JOptionPane.showMessageDialog(this, "Atracción cultural creada con éxito.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        add(lblNombre); add(txtNombre);
        add(lblTemporada); add(txtTemporada);
        add(lblUbicacion); add(txtUbicacion);
        add(lblClima); add(txtClima);
        add(lblMinemp); add(txtMinemp);
        add(lblExclu); add(txtExclu);
        add(lblEdad); add(txtEdad);
        add(lblCupo); add(txtCupo);
        add(lblRiesgo); add(txtRiesgo);
        add(btnAceptar); add(btnCancelar);

        setVisible(true);
    }
}
