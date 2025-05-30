package ventaDeTiquetes;

import javax.swing.*;

import Cliente.MyButton;
import Cliente.MyFrame;

import java.awt.*;
import Venta_de_tiquetes.*;

public class VentanaComprarFastPass extends MyFrame {

    public VentanaComprarFastPass(Cliente cliente, Taquilla taquilla) {
        setTitle("Comprar Tiquete FastPass");
        setSize(400, 200);
        setLayout(new FlowLayout());

        String[] unidades = {"DIA", "SEMANA", "MES", "ESTACION", "ANO"};
        JComboBox<String> comboUnidad = new JComboBox<>(unidades);
        JTextField campoCantidad = new JTextField(5);

        MyButton comprar = new MyButton();
        comprar.setText("Comprar");

        comprar.addActionListener(e -> {
            try {
                UnidadTiempo unidad = UnidadTiempo.valueOf((String) comboUnidad.getSelectedItem());
                int cantidad = Integer.parseInt(campoCantidad.getText());

                taquilla.venderTiqueteFastPass(cliente, unidad, cantidad, false);
                JOptionPane.showMessageDialog(this, "Tiquete FastPass comprado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(new JLabel("Unidad de tiempo:"));
        add(comboUnidad);
        add(new JLabel("Cantidad:"));
        add(campoCantidad);
        add(comprar);

        setVisible(true);
    }
}
