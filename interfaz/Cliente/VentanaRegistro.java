package Cliente;

import javax.swing.*;

import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import persistencia.PersistenciaAtraccionesYLugares;
import persistencia.PersistenciaClientes;

public class VentanaRegistro {

    public static void mostrar(MyFrame frameAnterior) {
        JFrame registroFrame = new MyFrame();
        registroFrame.setTitle("Crear Cuenta");

        JTextField espacioNombre = new JTextField();
        JTextField espacioLogin = new JTextField();
        JPasswordField espacioContraseña = new JPasswordField();
        JTextField espacioDinero = new JTextField();
        JTextField espacioEdad = new JTextField();
        
        //condiocion medica cajita
        JCheckBox cajita = new JCheckBox("Tiene restricción médica");

        Object[] mensaje = {
            "Nombre:", espacioNombre,
            "Login:", espacioLogin,
            "Contraseña:", espacioContraseña,
            "Dinero disponible:", espacioDinero,
            "Edad:", espacioEdad,
            cajita
        };

        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Registro", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            try {
                String nombre = espacioNombre.getText();
                String login = espacioLogin.getText();
                String pass = new String(espacioContraseña.getPassword());
                int dinero = Integer.parseInt(espacioDinero.getText());
                int edad = Integer.parseInt(espacioEdad.getText());
                boolean rest = cajita.isSelected();

                //crear cliente
                Cliente cliente = new Cliente(nombre, login, pass, dinero, edad, rest);

                PersistenciaClientes persistClientes = new PersistenciaClientes();
                PersistenciaAtraccionesYLugares persistAtr = new PersistenciaAtraccionesYLugares();

                AdministradorTiquetes adminTiquetes = new AdministradorTiquetes();
                adminTiquetes.setClientesRegistrados(persistClientes.cargarClientes());
                //guardar
                adminTiquetes.registrarCliente(cliente);

                AdministradorAtraccionesYLugares adminAtr = new AdministradorAtraccionesYLugares();
                
                //guardar de una?
                persistAtr.cargarDatos(adminAtr);

                if (adminAtr.getTaquillas().isEmpty()) {
                    adminAtr.crearTaquilla();
                }

                JOptionPane.showMessageDialog(null, "Registro exitoso.");
                registroFrame.dispose();
                frameAnterior.dispose();
                VentanaCliente.mostrar(cliente, adminTiquetes, adminAtr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Corrige los datos ingresados.");
            }
        }
    }
}
