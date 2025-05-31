package admin;

import javax.swing.*;
import Empleados.AdministradorEmpleados;
import persistencia.PersistenciaEmpleados;

public class VentanaCrearCocinero {

    public VentanaCrearCocinero(AdministradorEmpleados adminEmp) {
        JTextField login = new JTextField();
        JPasswordField pass = new JPasswordField();

        Object[] campos = {
            "Login:", login,
            "Contraseña:", pass
        };

        int opcion = JOptionPane.showConfirmDialog(null, campos, "Crear Cocinero", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            String user = login.getText();
            String pwd = new String(pass.getPassword());

            if (user.isEmpty() || pwd.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
                return;
            }

            adminEmp.crearCocinero(user, pwd);
            PersistenciaEmpleados.cargarEmpleados(adminEmp);
            JOptionPane.showMessageDialog(null, "Cocinero creado exitosamente.");
        }
    }
}