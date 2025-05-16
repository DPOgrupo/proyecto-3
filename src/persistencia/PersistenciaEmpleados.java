package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Empleados.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PersistenciaEmpleados {

    private static final String CAJEROS_FILE = "data/cajeros.json";
    private static final String COCINEROS_FILE = "data/cocineros.json";
    private static final String SERVICIOS_FILE = "data/servicios.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void guardarEmpleados(AdministradorEmpleados admin) {
        try (Writer writer1 = new FileWriter(CAJEROS_FILE);
             Writer writer2 = new FileWriter(COCINEROS_FILE);
             Writer writer3 = new FileWriter(SERVICIOS_FILE)) {

            gson.toJson(admin.getCajeros(), writer1);
            gson.toJson(admin.getCocineros(), writer2);
            gson.toJson(admin.getServicios(), writer3);

            System.out.println("Empleados guardados correctamente.");
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar los empleados: " + e.getMessage(), e);
        }
    }

    public static void cargarEmpleados(AdministradorEmpleados admin) {
        try {
            if (Files.exists(Paths.get(CAJEROS_FILE))) {
                try (Reader reader1 = new FileReader(CAJEROS_FILE)) {
                    List<Cajero> cajeros = Arrays.asList(gson.fromJson(reader1, Cajero[].class));
                    admin.setCajeros(cajeros);
                }
            }

            if (Files.exists(Paths.get(COCINEROS_FILE))) {
                try (Reader reader2 = new FileReader(COCINEROS_FILE)) {
                    List<Cocinero> cocineros = Arrays.asList(gson.fromJson(reader2, Cocinero[].class));
                    admin.setCocineros(cocineros);
                }
            }

            if (Files.exists(Paths.get(SERVICIOS_FILE))) {
                try (Reader reader3 = new FileReader(SERVICIOS_FILE)) {
                    List<ServicioGeneral> servicios = Arrays.asList(gson.fromJson(reader3, ServicioGeneral[].class));
                    admin.setServicios(servicios);
                }
            }

            System.out.println("Empleados cargados correctamente.");
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar los empleados: " + e.getMessage(), e);
        }
    }
}
