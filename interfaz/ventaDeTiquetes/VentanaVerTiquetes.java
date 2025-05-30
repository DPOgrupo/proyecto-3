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

        JPanel panelTiquetes = new JPanel();
        panelTiquetes.setLayout(new BoxLayout(panelTiquetes, BoxLayout.Y_AXIS));
        panelTiquetes.setBackground(Color.WHITE);

        for (Tiquete cadaTiquete : cliente.getTiquetes()) {
            String id = cadaTiquete.getId();
            String queSoy = cadaTiquete.getCategoria().toString();

            JPanel filaTiquete = new JPanel();
            filaTiquete.setLayout(new BoxLayout(filaTiquete, BoxLayout.X_AXIS));
            filaTiquete.setBackground(Color.WHITE);
            filaTiquete.setAlignmentX(Component.CENTER_ALIGNMENT);

            File qrFile = new File("QR/" + id + ".png");
            if (qrFile.exists()) {
                ImageIcon icon = new ImageIcon(qrFile.getAbsolutePath());
                JLabel qrLabel = new JLabel(icon);

             // Caja café
                JPanel cajaTiquete = new JPanel();
                cajaTiquete.setPreferredSize(new Dimension(200, 100));
                cajaTiquete.setBackground(new Color(139, 69, 19)); 
                cajaTiquete.setLayout(new BorderLayout());

                // marca del parque
                JLabel textoTiquete = new JLabel("AventuraMax", SwingConstants.CENTER);
                textoTiquete.setForeground(Color.WHITE);
                textoTiquete.setFont(new Font("Consolas", Font.BOLD, 35));
                cajaTiquete.add(textoTiquete, BorderLayout.NORTH);

                // ID
                JLabel textoTiquete1 = new JLabel("Categoria: " + queSoy, SwingConstants.CENTER);
                textoTiquete1.setForeground(Color.WHITE);
                textoTiquete1.setFont(new Font("Consolas", Font.PLAIN, 14));
                cajaTiquete.add(textoTiquete1, BorderLayout.CENTER);


                

                filaTiquete.add(Box.createRigidArea(new Dimension(10, 0)));
                filaTiquete.add(qrLabel);
                filaTiquete.add(Box.createRigidArea(new Dimension(10, 0)));
                filaTiquete.add(cajaTiquete);
                filaTiquete.add(Box.createRigidArea(new Dimension(10, 0)));

                panelTiquetes.add(Box.createRigidArea(new Dimension(0, 20)));
                panelTiquetes.add(new JLabel("Tiquete ID: " + id));
                panelTiquetes.add(filaTiquete);
            } else {
                JLabel notFound = new JLabel("QR no encontrado para: " + id);
                notFound.setForeground(Color.RED);
                notFound.setAlignmentX(Component.CENTER_ALIGNMENT);
                panelTiquetes.add(notFound);
            }
        }

        JScrollPane scrollPane = new JScrollPane(panelTiquetes);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
