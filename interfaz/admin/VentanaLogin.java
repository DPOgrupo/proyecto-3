package admin;

import javax.swing.*;

import AtraccionesYServicio.*;
import Empleados.AdministradorEmpleados;
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
            
            AdministradorEmpleados adminEmple = new AdministradorEmpleados(login, pass); 
            
            AdministradorTiquetes adminTiq = new AdministradorTiquetes(); 
            
            // verificar credenciales

            Cliente c = new Cliente(); 
            System.out.print(login);
            System.out.print(pass);
            if ((login.trim().equals("admin")) && (pass.trim().equals("123"))) {
                loginFrame.dispose();
                frameAnterior.dispose();
                VentanaAdmin.mostrar(c, adminTiquetes, adminAtr);
            } else {
                JOptionPane.showMessageDialog(null, "login o contraseña incorrecta.");
            }
        }
    }
}
