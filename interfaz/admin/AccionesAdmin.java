package admin;

import javax.swing.*;

import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;
import persistencia.*;
import ventaDeTiquetes.VentanaVentaTiquetes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccionesAdmin {

    public static void comprarTiquete(Cliente cliente, AdministradorAtraccionesYLugares adminAtr) {
        Taquilla taquilla = adminAtr.getTaquillas().get(0);
        new VentanaVentaTiquetes(cliente, taquilla, adminAtr);
    }

    public static void usarTiquete(Cliente cliente, AdministradorAtraccionesYLugares adminAtr, JFrame parent) {
        
    	//lista todas las atracciones
    	List<Atraccion> atracciones = new ArrayList<>();
        atracciones.addAll(adminAtr.getMecanicas());
        atracciones.addAll(adminAtr.getCulturales());
    


        if (atracciones.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "No hay atracciones disponibles.");
            return;
        }

        //iterar por cada atraccion
        String[] opciones = new String[atracciones.size()];
        for (int i = 0; i < atracciones.size(); i++) {
            opciones[i] = atracciones.get(i).getIdAtraccion();
        }

        JComboBox<String> comboBox = new JComboBox<>(opciones);
        
        //mostral panel de seleccion
        int resultado = JOptionPane.showConfirmDialog(parent, comboBox, "Seleccione una atracción", JOptionPane.OK_CANCEL_OPTION);

        if (resultado == JOptionPane.OK_OPTION) {
            String seleccion = (String) comboBox.getSelectedItem();

        if (seleccion != null) {
            for (Atraccion a : atracciones) {
                if (a.getIdAtraccion().equals(seleccion)) {
                    if (a.cumpleRestricciones(cliente)) {
                        JOptionPane.showMessageDialog(parent, "¡Te montaste en " + seleccion + "!");
                    } else {
                        JOptionPane.showMessageDialog(parent, "No puedes ingresar.");
                    }
                    break;
                }
            }
        }
    }
    }

    public static void comprarEnTienda(Cliente cliente, AdministradorAtraccionesYLugares adminAtr, JFrame parent) {
        List<Tienda> tiendas = adminAtr.getTiendas();
        
        if (tiendas.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "No hay tiendas.");
            return;
        }

        String[] opciones = new String[tiendas.size()];
        for (int i = 0; i < tiendas.size(); i++) {
            opciones[i] = "Tienda: " + tiendas.get(i).getNumeroJuguetes() + " juguetes";
        }

        int seleccion = JOptionPane.showOptionDialog(parent, "Seleccione tienda:", "Tiendas",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);


        if (seleccion >= 0) {
            String input = JOptionPane.showInputDialog("¿Cuántos juguetes desea?");
            try {
                int cantidad = Integer.parseInt(input);
                tiendas.get(seleccion).venderTiquetes(cantidad, cliente);
                JOptionPane.showMessageDialog(parent, "Compra realizada.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, "Error en la cantidad.");
            }
        }
    }

    public static void comprarEnCafeteria(Cliente cliente, AdministradorAtraccionesYLugares adminAtr, JFrame parent) {
        //lista de cafeterias
    	List<Cafeteria> cafeterias = adminAtr.getCafeterias();
        
        if (cafeterias.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "No hay cafeterías.");
            return;
        }
        //recorrer cada cafeteira
        String[] opciones = new String[cafeterias.size()];
        for (int i = 0; i < cafeterias.size(); i++) {
            opciones[i] = "Cafetería: " + cafeterias.get(i).getNumeroComidas() + " comidas";
        }

        int seleccion = JOptionPane.showOptionDialog(parent, "Seleccione cafetería:", "Cafeterías",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);


        if (seleccion >= 0) {
            String input = JOptionPane.showInputDialog("¿Cuántos almuerzos desea?");
            try {
                int cantidad = Integer.parseInt(input);
                cafeterias.get(seleccion).venderAlmuerzos(cantidad, cliente);
                JOptionPane.showMessageDialog(parent, "Compra realizada.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, "Error en la cantidad.");
            }
        }
    }

    public static void salirYGuardar(JFrame frame, AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr, AdministradorEmpleados adminEmp) {
        PersistenciaClientes persistClientes = new PersistenciaClientes();
        PersistenciaAtraccionesYLugares persistAtr = new PersistenciaAtraccionesYLugares();

        persistClientes.guardarClientes(adminTiquetes.getClientesRegistrados());
        persistAtr.guardarDatos(adminAtr);
        PersistenciaEmpleados.guardarEmpleados(adminEmp);



        JOptionPane.showMessageDialog(frame, "Datos correctamente guardados.");
        frame.dispose();
    }
    
   


}
