package ventaDeTiquetes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import AtraccionesYServicio.AdministradorAtraccionesYLugares;
import Venta_de_tiquetes.*;
import interfaz.MyButton;
import interfaz.MyFrame;

public class VentanaVentaTiquetes extends MyFrame {

    public VentanaVentaTiquetes(Cliente cliente, Taquilla taquilla, AdministradorAtraccionesYLugares adminAtr) {
        setTitle("Compra de Tiquetes");
        setSize(400, 400);
        setLayout(new GridLayout(5, 1));

        String[] opciones = {
            "Tiquete Regular",
            "Tiquete Individual",
            "Tiquete Temporada",
            "Tiquete FastPass",
            "Ver mis Tiquetes"
        };

        for (String texto : opciones) {
            MyButton btn = new MyButton();
            btn.setText(texto);
            add(btn);

            btn.addActionListener(e -> {
                switch (texto) {
                    case "Tiquete Regular" -> new VentanaComprarRegular(cliente, taquilla);
                    case "Tiquete Individual" -> new VentanaComprarIndividual(cliente, taquilla, adminAtr);
                    case "Tiquete Temporada" -> new VentanaComprarTemporada(cliente, taquilla);
                    case "Tiquete FastPass" -> new VentanaComprarFastPass(cliente, taquilla);
                    case "Ver mis Tiquetes" -> new VentanaVerTiquetes(cliente);
                }
            });
        }

        setVisible(true);
    }
}
