package admin;

import javax.swing.*;
import Empleados.AdministradorEmpleados;

public class VentanaTurnoGlobal {

    public VentanaTurnoGlobal(AdministradorEmpleados adminEmp) {
        boolean turnoActual = adminEmp.isTurnoGlobalNocturno();

        String turnoStr = "";
        String turnoNuevo = "";

        if (turnoActual) {
            turnoStr = "Nocturno";
            turnoNuevo = "Diurno";
        } else {
            turnoStr = "Diurno";
            turnoNuevo = "Nocturno";
        }

        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "El turno actual global es: " + turnoStr + ".\n¿Deseas cambiar a turno " + turnoNuevo + "?",
                "Cambiar Turno Global",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            adminEmp.cambiarTurnoGlobal(!turnoActual);
            JOptionPane.showMessageDialog(null, "Turno global cambiado a " + turnoNuevo + ".");
        }
    }
}
