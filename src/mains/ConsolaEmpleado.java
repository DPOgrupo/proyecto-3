package mains;

import Empleados.*;
import persistencia.PersistenciaEmpleados;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsolaEmpleado {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            AdministradorEmpleados adminEmp = new AdministradorEmpleados("admin", "123");

            PersistenciaEmpleados.cargarEmpleados(adminEmp);

            System.out.println("=== INGRESO DE EMPLEADO ===");

            System.out.print("Ingrese su login: ");
            String login = reader.readLine();
            System.out.print("Ingrese su contraseña: ");
            String contraseña = reader.readLine();

            Empleado empleado = buscarEmpleado(adminEmp, login, contraseña);

            if (empleado == null) {
                System.out.println("Credenciales incorrectas o usuario no encontrado.");
                return;
            }

            System.out.println("Bienvenido " + empleado.getLogin() + "!");

            int opcion = -1;
            while (opcion != 0) {
                System.out.println("\n--- MENÚ EMPLEADO ---");
                System.out.println("1. Ver turnos asignados");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1 -> mostrarTurnosEmpleado(empleado);
                    case 0 -> System.out.println("Sesión finalizada.");
                }
            }

        } catch (IOException e) {
            System.err.println("Error en la consola del empleado: " + e.getMessage());
        }
    }

    private static Empleado buscarEmpleado(AdministradorEmpleados adminEmp, String login, String contraseña) {
        List<Empleado> todos = new ArrayList<>();
        todos.addAll(adminEmp.getCajeros());
        todos.addAll(adminEmp.getCocineros());
        todos.addAll(adminEmp.getServicios());

        for (Empleado cadaEmpleado : todos) {
            if (cadaEmpleado.getLogin().equals(login) && cadaEmpleado.verificarContraseña(contraseña)) {
                return cadaEmpleado;
            }
        }
        return null;
    }

    private static void mostrarTurnosEmpleado(Empleado empleado) {
        List<Turno> turnos = empleado.getTurnosAsignados();

        if (turnos.isEmpty()) {
            System.out.println("No tiene turnos asignados.");
            return;
        }

        System.out.println("Turnos asignados:");
        for (Turno cadaTurno : turnos) {
            String tipoTurno = cadaTurno.isTurnoNocturno() ? "Nocturno" : "Diurno";
            System.out.println("Fecha: " + cadaTurno.getFecha() + " | Turno: " + tipoTurno + " | Lugar: " + cadaTurno.getLugar());
        }
    }
}
