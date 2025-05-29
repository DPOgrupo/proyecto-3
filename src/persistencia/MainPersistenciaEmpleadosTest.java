
package persistencia;

import Empleados.*;

import java.util.List;
import java.util.ArrayList;

public class MainPersistenciaEmpleadosTest {

    public static void main(String[] args) {
        AdministradorEmpleados admin = new AdministradorEmpleados("admin", "123");

        // Crear empleados de prueba
        admin.crearCajero("cajero1", "pass1");
        admin.crearCocinero("cocinero1", "pass2");
        admin.crearServicioGeneral("servicio1", "pass3");


        // Guardar
        PersistenciaEmpleados.guardarEmpleados(admin);

        // Nuevo administrador para cargar
        AdministradorEmpleados adminCargado = new AdministradorEmpleados("admin", "123");
        PersistenciaEmpleados.cargarEmpleados(adminCargado);

        // Mostrar resultados
        adminCargado.getCajeros().forEach(c -> System.out.println("Cajero: " + c.getLogin()));
        adminCargado.getCocineros().forEach(c -> System.out.println("Cocinero: " + c.getLogin()));
        adminCargado.getServicios().forEach(s -> System.out.println("Servicio: " + s.getLogin()));
    }
}
