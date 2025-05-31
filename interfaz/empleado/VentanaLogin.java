package empleado;
import javax.swing.*;
import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;
import persistencia.PersistenciaEmpleados;
import persistencia.PersistenciaAtraccionesYLugares;

public class VentanaLogin {
    public static void mostrar(MyFrame frameAnterior) {
        JFrame loginFrame = new MyFrame();
        loginFrame.setTitle("Iniciar Sesión");
        
        // Crear campos de entrada
        JTextField espacioLogin = new JTextField();
        JPasswordField espacioContraseña = new JPasswordField();
        
        // Crear combo box para tipo de usuario
        String[] tiposUsuario = {"Cajero", "Cocinero", "Servicio General"};
        JComboBox<String> comboTipoUsuario = new JComboBox<>(tiposUsuario);
        
        Object[] mensaje = {
            "Tipo de Usuario:", comboTipoUsuario,
            "Login:", espacioLogin,
            "Contraseña:", espacioContraseña
        };
        
        // Mostrar caja de selección
        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Iniciar sesión", JOptionPane.OK_CANCEL_OPTION);
        
        // Si acepta
        if (opcion == JOptionPane.OK_OPTION) {
            String login = espacioLogin.getText();
            String pass = new String(espacioContraseña.getPassword());
            String tipoUsuario = (String) comboTipoUsuario.getSelectedItem();
            
            // Validar campos vacíos
            if (login.trim().isEmpty() || pass.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
                mostrar(frameAnterior); // Volver a mostrar la ventana
                return;
            }
            
            // Cargar persistencia
            PersistenciaAtraccionesYLugares persistAtr = new PersistenciaAtraccionesYLugares();
            AdministradorTiquetes adminTiquetes = new AdministradorTiquetes();
            AdministradorAtraccionesYLugares adminAtr = new AdministradorAtraccionesYLugares();
            AdministradorEmpleados adminEmpleados = new AdministradorEmpleados();
            
            // Cargar datos
            persistAtr.cargarDatos(adminAtr);
            PersistenciaEmpleados.cargarEmpleados(adminEmpleados);
            
            // Asegurar una taquilla
            if (adminAtr.getTaquillas().isEmpty()) {
                adminAtr.crearTaquilla();
            }
            
            boolean loginExitoso = false;
            
            switch (tipoUsuario) {
                case "Cajero":
                    Cajero cajero = validarCajero(login, pass, adminEmpleados);
                    if (cajero != null) {
                        loginExitoso = true;
                        loginFrame.dispose();
                        frameAnterior.dispose();
                        VentanaMostrarEmpleado.mostrarCajero(cajero, adminEmpleados, adminTiquetes, adminAtr);
                    }
                    break;
                    
                case "Cocinero":
                    Cocinero cocinero = validarCocinero(login, pass, adminEmpleados);
                    if (cocinero != null) {
                        loginExitoso = true;
                        loginFrame.dispose();
                        frameAnterior.dispose();
                        VentanaMostrarEmpleado.mostrarCocinero(cocinero, adminEmpleados, adminTiquetes, adminAtr);
                    }
                    break;
                    
                case "Servicio General":
                    ServicioGeneral servicio = validarServicioGeneral(login, pass, adminEmpleados);
                    if (servicio != null) {
                        loginExitoso = true;
                        loginFrame.dispose();
                        frameAnterior.dispose();
                        VentanaMostrarEmpleado.mostrarServicioGeneral(servicio, adminEmpleados, adminTiquetes, adminAtr);
                    }
                    break;
            }
            
            if (!loginExitoso) {
                JOptionPane.showMessageDialog(null, "Login o contraseña incorrecta para el tipo de usuario seleccionado.");
                mostrar(frameAnterior); // Volver a mostrar la ventana para otro intento
            }
        }
    }
    
    private static Cajero validarCajero(String login, String pass, AdministradorEmpleados adminEmpleados) {
        for (Cajero c : adminEmpleados.getCajeros()) {
            if (c.getLogin().equals(login) && c.getContraseña().equals(pass)) {
                return c;
            }
        }
        return null;
    }
    
    private static Cocinero validarCocinero(String login, String pass, AdministradorEmpleados adminEmpleados) {
        for (Cocinero c : adminEmpleados.getCocineros()) {
            if (c.getLogin().equals(login) && c.getContraseña().equals(pass)) {
                return c;
            }
        }
        return null;
    }
    
    private static ServicioGeneral validarServicioGeneral(String login, String pass, AdministradorEmpleados adminEmpleados) {
        for (ServicioGeneral s : adminEmpleados.getServicios()) {
            if (s.getLogin().equals(login) && s.getContraseña().equals(pass)) {
                return s;
            }
        }
        return null;
    }
}
