package ventaDeTiquetes;

import javax.swing.*;
import java.awt.*;
import Venta_de_tiquetes.*;
import interfaz.MyButton;
import interfaz.MyFrame;

public class VentanaComprarTemporada extends MyFrame {

    public VentanaComprarTemporada(Cliente cliente, Taquilla taquilla) {
        setTitle("Comprar Tiquete Temporada");
        setSize(400, 250);
        setLayout(new FlowLayout());

        String[] categorias = {"BASICO", "FAMILIAR", "ORO", "DIAMANTE"};
        String[] unidades = {"DIA", "SEMANA", "MES", "ESTACION", "ANO"};

        JComboBox<String> comboCat = new JComboBox<>(categorias);
        JComboBox<String> comboUnidad = new JComboBox<>(unidades);
        JTextField campoCantidad = new JTextField(5);

        MyButton comprar = new MyButton();
        comprar.setText("Comprar");

        comprar.addActionListener(e -> {
            try {
                CategoriaExclusividad cat = CategoriaExclusividad.valueOf((String) comboCat.getSelectedItem());
                UnidadTiempo unidad = UnidadTiempo.valueOf((String) comboUnidad.getSelectedItem());
                int cantidad = Integer.parseInt(campoCantidad.getText());

                taquilla.venderTiqueteTemporada(cliente, cat, unidad, cantidad, false);
                JOptionPane.showMessageDialog(this, "Tiquete de temporada comprado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        add(new JLabel("Categoría:"));
        add(comboCat);
        add(new JLabel("Unidad de tiempo:"));
        add(comboUnidad);
        add(new JLabel("Cantidad:"));
        add(campoCantidad);
        add(comprar);

        setVisible(true);
    }
}
