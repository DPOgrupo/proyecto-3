package empleado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;
import persistencia.PersistenciaEmpleados;

public class VentanaMostrarEmpleado {
    
    public static void mostrarCajero(Cajero cajero, AdministradorEmpleados adminEmpleados, 
                                   AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr) {
        JFrame frame = new MyFrame();
        frame.setTitle("Panel de Cajero - " + cajero.getLogin());
        frame.setLayout(new BorderLayout());
        
        // Panel de información del empleado
        JPanel panelInfo = new JPanel(new GridLayout(4, 2, 10, 5));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información del Cajero"));
        panelInfo.add(new JLabel("ID:"));
        panelInfo.add(new JLabel(String.valueOf(cajero.getId())));
        panelInfo.add(new JLabel("Login:"));
        panelInfo.add(new JLabel(cajero.getLogin()));
        panelInfo.add(new JLabel("Dinero:"));
        panelInfo.add(new JLabel("$" + cajero.getDinero()));
        panelInfo.add(new JLabel("Capacitaciones:"));
        panelInfo.add(new JLabel(cajero.getCapacitaciones().toString()));
        
        // Panel de acciones
        JPanel panelAcciones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones"));
        
        JButton btnVenderTiquete = new JButton("Vender Tiquete");
        JButton btnAsignarLugar = new JButton("Asignar a Lugar de Servicio");
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        
        panelAcciones.add(btnVenderTiquete);
        panelAcciones.add(btnAsignarLugar);
        panelAcciones.add(btnCerrarSesion);
        
        // Eventos de botones
        btnVenderTiquete.addActionListener(e -> mostrarVentaTickets(cajero, adminTiquetes, adminAtr));
        
        btnAsignarLugar.addActionListener(e -> mostrarAsignacionLugar(cajero, adminAtr));
        
        btnCerrarSesion.addActionListener(e -> {
            PersistenciaEmpleados.guardarEmpleados(adminEmpleados);
            frame.dispose();
            VentanaLogin.mostrar(new MyFrame());
        });
        
        frame.add(panelInfo, BorderLayout.NORTH);
        frame.add(panelAcciones, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    public static void mostrarCocinero(Cocinero cocinero, AdministradorEmpleados adminEmpleados, 
                                     AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr) {
        JFrame frame = new MyFrame();
        frame.setTitle("Panel de Cocinero - " + cocinero.getLogin());
        frame.setLayout(new BorderLayout());
        
        // Panel de información del empleado
        JPanel panelInfo = new JPanel(new GridLayout(4, 2, 10, 5));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información del Cocinero"));
        panelInfo.add(new JLabel("ID:"));
        panelInfo.add(new JLabel(String.valueOf(cocinero.getId())));
        panelInfo.add(new JLabel("Login:"));
        panelInfo.add(new JLabel(cocinero.getLogin()));
        panelInfo.add(new JLabel("Dinero:"));
        panelInfo.add(new JLabel("$" + cocinero.getDinero()));
        panelInfo.add(new JLabel("Capacitaciones:"));
        panelInfo.add(new JLabel(cocinero.getCapacitaciones().toString()));
        
        // Panel de acciones
        JPanel panelAcciones = new JPanel(new GridLayout(4, 1, 10, 10));
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones"));
        
        JButton btnVenderTiquete = new JButton("Vender Tiquete");
        JButton btnCocinar = new JButton("Cocinar en Cafeterías");
        JButton btnAsignarLugar = new JButton("Asignar a Lugar de Servicio");
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        
        panelAcciones.add(btnVenderTiquete);
        panelAcciones.add(btnCocinar);
        panelAcciones.add(btnAsignarLugar);
        panelAcciones.add(btnCerrarSesion);
        
        // Eventos de botones
        btnVenderTiquete.addActionListener(e -> mostrarVentaTickets(cocinero, adminTiquetes, adminAtr));
        
        btnCocinar.addActionListener(e -> mostrarCocinar(cocinero, adminAtr));
        
        btnAsignarLugar.addActionListener(e -> mostrarAsignacionLugar(cocinero, adminAtr));
        
        btnCerrarSesion.addActionListener(e -> {
            PersistenciaEmpleados.guardarEmpleados(adminEmpleados);
            frame.dispose();
            VentanaLogin.mostrar(new MyFrame());
        });
        
        frame.add(panelInfo, BorderLayout.NORTH);
        frame.add(panelAcciones, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    public static void mostrarServicioGeneral(ServicioGeneral servicio, AdministradorEmpleados adminEmpleados, 
                                            AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr) {
        JFrame frame = new MyFrame();
        frame.setTitle("Panel de Servicio General - " + servicio.getLogin());
        frame.setLayout(new BorderLayout());
        
        // Panel de información del empleado
        JPanel panelInfo = new JPanel(new GridLayout(4, 2, 10, 5));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información del Empleado"));
        panelInfo.add(new JLabel("ID:"));
        panelInfo.add(new JLabel(String.valueOf(servicio.getID())));
        panelInfo.add(new JLabel("Login:"));
        panelInfo.add(new JLabel(servicio.getLogin()));
        panelInfo.add(new JLabel("Dinero:"));
        panelInfo.add(new JLabel("$" + servicio.getDinero()));
        panelInfo.add(new JLabel("Capacitaciones:"));
        panelInfo.add(new JLabel(servicio.getCapacitaciones().toString()));
        
        // Panel de acciones
        JPanel panelAcciones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones"));
        
        JButton btnMantener = new JButton("Mantener Atracciones");
        JButton btnAsignarLugar = new JButton("Asignar a Lugar de Servicio");
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        
        panelAcciones.add(btnMantener);
        panelAcciones.add(btnAsignarLugar);
        panelAcciones.add(btnCerrarSesion);
        
        // Eventos de botones
        btnMantener.addActionListener(e -> mostrarMantenimiento(servicio, adminAtr));
        
        btnAsignarLugar.addActionListener(e -> mostrarAsignacionLugar(servicio, adminAtr));
        
        btnCerrarSesion.addActionListener(e -> {
            PersistenciaEmpleados.guardarEmpleados(adminEmpleados);
            frame.dispose();
            VentanaLogin.mostrar(new MyFrame());
        });
        
        frame.add(panelInfo, BorderLayout.NORTH);
        frame.add(panelAcciones, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    private static void mostrarVentaTickets(Cajero cajero, AdministradorTiquetes adminTiquetes, 
                                          AdministradorAtraccionesYLugares adminAtr) {
        JFrame ventaFrame = new JFrame("Venta de Tiquetes");
        ventaFrame.setSize(400, 300);
        ventaFrame.setLayout(new GridLayout(5, 2, 10, 10));
        
        // Selección de cliente
        JComboBox<Cliente> comboClientes = new JComboBox<>();
        for (Cliente c : adminTiquetes.getClientesRegistrados()) {
            comboClientes.addItem(c);
        }
        
        // Selección de atracción
        JComboBox<Atraccion> comboAtracciones = new JComboBox<>();
      
        
        JSpinner spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        
        ventaFrame.add(new JLabel("Cliente:"));
        ventaFrame.add(comboClientes);
        ventaFrame.add(new JLabel("Atracción:"));
        ventaFrame.add(comboAtracciones);
        ventaFrame.add(new JLabel("Cantidad:"));
        ventaFrame.add(spinnerCantidad);
        
        JButton btnVender = new JButton("Vender");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnVender.addActionListener(e -> {
            Cliente cliente = (Cliente) comboClientes.getSelectedItem();
            Atraccion atraccion = (Atraccion) comboAtracciones.getSelectedItem();
            int cantidad = (Integer) spinnerCantidad.getValue();
            
            if (cliente != null && atraccion != null) {
                JOptionPane.showMessageDialog(ventaFrame, "Venta realizada exitosamente");
                ventaFrame.dispose();
            }
        });
        
        btnCancelar.addActionListener(e -> ventaFrame.dispose());
        
        ventaFrame.add(btnVender);
        ventaFrame.add(btnCancelar);
        ventaFrame.setVisible(true);
    }
    
    private static void mostrarCocinar(Cocinero cocinero, AdministradorAtraccionesYLugares adminAtr) {
        JFrame cocinarFrame = new JFrame("Cocinar en Cafeterías");
        cocinarFrame.setSize(300, 200);
        cocinarFrame.setLayout(new GridLayout(3, 1, 10, 10));
        
        JComboBox<Cafeteria> comboCafeterias = new JComboBox<>();
        for (Cafeteria c : adminAtr.getCafeterias()) {
            comboCafeterias.addItem(c);
        }
        
        cocinarFrame.add(new JLabel("Seleccionar Cafetería:"));
        cocinarFrame.add(comboCafeterias);
        
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton btnCocinar = new JButton("Cocinar");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnCocinar.addActionListener(e -> {
            Cafeteria cafeteria = (Cafeteria) comboCafeterias.getSelectedItem();
            if (cafeteria != null) {
                cocinero.cocinar(cafeteria);
                JOptionPane.showMessageDialog(cocinarFrame, "Cocinando en " + cafeteria.toString());
                cocinarFrame.dispose();
            }
        });
        
        btnCancelar.addActionListener(e -> cocinarFrame.dispose());
        
        panelBotones.add(btnCocinar);
        panelBotones.add(btnCancelar);
        cocinarFrame.add(panelBotones);
        cocinarFrame.setVisible(true);
    }
    
    private static void mostrarMantenimiento(ServicioGeneral servicio, AdministradorAtraccionesYLugares adminAtr) {
        JFrame mantenimientoFrame = new JFrame("Mantenimiento de Atracciones");
        mantenimientoFrame.setSize(300, 200);
        mantenimientoFrame.setLayout(new GridLayout(3, 1, 10, 10));
        
        JComboBox<Atraccion> comboAtracciones = new JComboBox<>();
        
        mantenimientoFrame.add(new JLabel("Seleccionar Atracción:"));
        mantenimientoFrame.add(comboAtracciones);
        
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton btnMantener = new JButton("Mantener");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnMantener.addActionListener(e -> {
            Atraccion atraccion = (Atraccion) comboAtracciones.getSelectedItem();
            if (atraccion != null) {
                servicio.mantener(atraccion);
                JOptionPane.showMessageDialog(mantenimientoFrame, "Mantenimiento realizado en " + atraccion.toString());
                mantenimientoFrame.dispose();
            }
        });
        
        btnCancelar.addActionListener(e -> mantenimientoFrame.dispose());
        
        panelBotones.add(btnMantener);
        panelBotones.add(btnCancelar);
        mantenimientoFrame.add(panelBotones);
        mantenimientoFrame.setVisible(true);
    }
    
    private static void mostrarAsignacionLugar(Empleado empleado, AdministradorAtraccionesYLugares adminAtr) {
        JFrame asignacionFrame = new JFrame("Asignar a Lugar de Servicio");
        asignacionFrame.setSize(400, 250);
        asignacionFrame.setLayout(new GridLayout(4, 2, 10, 10));
        
        String[] tiposLugar = {"Taquilla", "Cafetería"};
        JComboBox<String> comboTipos = new JComboBox<>(tiposLugar);
        JComboBox<LugarDeServicio> comboLugares = new JComboBox<>();
        
        // Actualizar lugares según el tipo seleccionado
        comboTipos.addActionListener(e -> {
            comboLugares.removeAllItems();
            String tipoSeleccionado = (String) comboTipos.getSelectedItem();
            if ("Taquilla".equals(tipoSeleccionado)) {
                for (Taquilla t : adminAtr.getTaquillas()) {
                    comboLugares.addItem(t);
                }
            } else if ("Cafetería".equals(tipoSeleccionado)) {
                for (Cafeteria c : adminAtr.getCafeterias()) {
                    comboLugares.addItem(c);
                }
            }
        });
        
        // Inicializar con taquillas
        for (Taquilla t : adminAtr.getTaquillas()) {
            comboLugares.addItem(t);
        }
        
        asignacionFrame.add(new JLabel("Tipo de Lugar:"));
        asignacionFrame.add(comboTipos);
        asignacionFrame.add(new JLabel("Lugar:"));
        asignacionFrame.add(comboLugares);
        
        JButton btnAsignar = new JButton("Asignar");
        JButton btnQuitar = new JButton("Quitar");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnAsignar.addActionListener(e -> {
            LugarDeServicio lugar = (LugarDeServicio) comboLugares.getSelectedItem();
            if (lugar != null && empleado != null) {
                if (empleado instanceof Cajero) {
                    lugar.añadirCajero((Cajero) empleado);
                } else if (empleado instanceof Cocinero) {
                    lugar.añadirCocinero((Cocinero) empleado);
                } else if (empleado instanceof ServicioGeneral) {
                    lugar.añadirServicio((ServicioGeneral) empleado);
                }
                JOptionPane.showMessageDialog(asignacionFrame, "Empleado asignado correctamente");
                asignacionFrame.dispose();
            }
        });
        
        btnQuitar.addActionListener(e -> {
            LugarDeServicio lugar = (LugarDeServicio) comboLugares.getSelectedItem();
            if (lugar != null && empleado != null) {
                if (empleado instanceof Cajero) {
                    lugar.quitarCajero((Cajero) empleado);
                } else if (empleado instanceof Cocinero) {
                    lugar.quitarCocinero((Cocinero) empleado);
                } else if (empleado instanceof ServicioGeneral) {
                    lugar.quitarServicio((ServicioGeneral) empleado);
                }
                JOptionPane.showMessageDialog(asignacionFrame, "Empleado removido correctamente");
                asignacionFrame.dispose();
            }
        });
        
        btnCancelar.addActionListener(e -> asignacionFrame.dispose());
        
        asignacionFrame.add(btnAsignar);
        asignacionFrame.add(btnQuitar);
        asignacionFrame.add(btnCancelar);
        asignacionFrame.setVisible(true);
    }
}