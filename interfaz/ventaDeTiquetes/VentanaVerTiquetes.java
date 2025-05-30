package ventaDeTiquetes;

import javax.swing.*;

import Cliente.MyFrame;

import java.awt.*;
import java.io.File;
import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.Tiquete;

public class VentanaVerTiquetes extends MyFrame {

    public VentanaVerTiquetes(Cliente cliente) {
        setTitle("Mis Tiquetes");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel que contendrá los tiquetes (con layout vertical)
        JPanel panelTiquetes = new JPanel();
        panelTiquetes.setLayout(new BoxLayout(panelTiquetes, BoxLayout.Y_AXIS));
        panelTiquetes.setBackground(Color.WHITE);

        for (Tiquete t : cliente.getTiquetes()) {
            String id = t.getId(); // Asegúrate que esto funcione
            JLabel label = new JLabel("Tiquete ID: " + id);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            File qrFile = new File("QR/" + id + ".png");
            if (qrFile.exists()) {
                ImageIcon icon = new ImageIcon(qrFile.getAbsolutePath());
                JLabel qrLabel = new JLabel(icon);
                qrLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                panelTiquetes.add(Box.createRigidArea(new Dimension(0, 10)));
                panelTiquetes.add(label);
                panelTiquetes.add(qrLabel);
            } else {
                JLabel notFound = new JLabel("QR no encontrado para: " + id);
                notFound.setForeground(Color.RED);
                notFound.setAlignmentX(Component.CENTER_ALIGNMENT);
                panelTiquetes.add(notFound);
            }
        }

        // Scroll pane con el panel de tiquetes
        JScrollPane scrollPane = new JScrollPane(panelTiquetes);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // suaviza el scroll

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
