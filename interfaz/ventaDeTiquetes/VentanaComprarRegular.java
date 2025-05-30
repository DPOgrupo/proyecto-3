package ventaDeTiquetes;

import javax.swing.*;

import Cliente.MyButton;
import Cliente.MyFrame;

import java.awt.*;
import Venta_de_tiquetes.*;

public class VentanaComprarRegular extends MyFrame {

    public VentanaComprarRegular(Cliente cliente, Taquilla taquilla) {
        setTitle("Comprar Tiquete Regular");
        setSize(400, 200);
        setLayout(new FlowLayout());

        String[] categorias = {"BASICO", "FAMILIAR", "ORO", "DIAMANTE"};
        JComboBox<String> combo = new JComboBox<>(categorias);

        MyButton comprar = new MyButton();
        comprar.setText("Comprar");

        comprar.addActionListener(e -> {
            try {
                String seleccion = (String) combo.getSelectedItem();
                CategoriaExclusividad cat = CategoriaExclusividad.valueOf(seleccion);
                taquilla.venderTiqueteRegular(cliente, cat, false);
                JOptionPane.showMessageDialog(this, "Tiquete regular comprado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(new JLabel("Seleccione categoría:"));
        add(combo);
        add(comprar);

        setVisible(true);
    }
}
