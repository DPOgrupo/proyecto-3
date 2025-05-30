package ventaDeTiquetes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import AtraccionesYServicio.AdministradorAtraccionesYLugares;
import AtraccionesYServicio.Atraccion;
import Cliente.MyButton;
import Cliente.MyFrame;
import Venta_de_tiquetes.*;

public class VentanaComprarIndividual extends MyFrame {

    public VentanaComprarIndividual(Cliente cliente, Taquilla taquilla, AdministradorAtraccionesYLugares adminAtr) {
        setTitle("Comprar Tiquete Individual");
        setSize(400, 200);
        setLayout(new FlowLayout());

    	List<Atraccion> atracciones = new ArrayList<>();
        atracciones.addAll(adminAtr.getMecanicas());
        atracciones.addAll(adminAtr.getCulturales());
        
        String[] opciones = new String[atracciones.size()];

        for (int i = 0; i < atracciones.size(); i++) {
            opciones[i] = atracciones.get(i).getIdAtraccion();
        }

        JComboBox<String> comboBox = new JComboBox<>(opciones);

        MyButton comprar = new MyButton();
        comprar.setText("Comprar");

        comprar.addActionListener(e -> {
            try {
                String seleccion = (String) comboBox.getSelectedItem();
                taquilla.venderTiqueteIndividual(cliente, seleccion, false);
                JOptionPane.showMessageDialog(this, "Tiquete individual comprado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(new JLabel("Seleccione atracción:"));
        add(comboBox);
        add(comprar);

        setVisible(true);
    }
}
