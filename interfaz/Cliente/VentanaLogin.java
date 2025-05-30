package Cliente;

import javax.swing.*;

import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import persistencia.PersistenciaAtraccionesYLugares;
import persistencia.PersistenciaClientes;

public class VentanaLogin {

    public static void mostrar(MyFrame frameAnterior) {
        JFrame loginFrame = new MyFrame();
        loginFrame.setTitle("Iniciar Sesión");

        JTextField espacioLogin = new JTextField();
        JPasswordField espacioContraseña = new JPasswordField();

        Object[] mensaje = {
            "Login:", espacioLogin,
            "Contraseña:", espacioContraseña
        };
        
        
        //mostrar caja de seleccion
        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Iniciar sesión", JOptionPane.OK_CANCEL_OPTION);

        //si acepta
        if (opcion == JOptionPane.OK_OPTION) {
            String login = espacioLogin.getText();
            String pass = new String(espacioContraseña.getPassword());
            

            PersistenciaClientes persistClientes = new PersistenciaClientes();
            PersistenciaAtraccionesYLugares persistAtr = new PersistenciaAtraccionesYLugares();

            AdministradorTiquetes adminTiquetes = new AdministradorTiquetes();
            adminTiquetes.setClientesRegistrados(persistClientes.cargarClientes());

            AdministradorAtraccionesYLugares adminAtr = new AdministradorAtraccionesYLugares();
            persistAtr.cargarDatos(adminAtr);
            
            //asegurar una taquilla
            if (adminAtr.getTaquillas().isEmpty()) {
                adminAtr.crearTaquilla();
            }

            Cliente cliente = null;
            for (Cliente c : adminTiquetes.getClientesRegistrados()) {
                if (c.getLogin().equals(login) && c.getContrasena().equals(pass)) {
                    cliente = c;
                }
            }

            if (cliente != null) {
                loginFrame.dispose();
                frameAnterior.dispose();
                VentanaCliente.mostrar(cliente, adminTiquetes, adminAtr);
            } else {
                JOptionPane.showMessageDialog(null, "login o contraseña incorrecta.");
            }
        }
    }
}
