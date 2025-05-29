package persistencia;

import AtraccionesYServicio.*;
import Empleados.*;

public class MainPersistenciaAtraccionesTest {

    public static void main(String[] args) {
        AdministradorAtraccionesYLugares admin = new AdministradorAtraccionesYLugares();

        // Crear datos de prueba
        admin.crearTienda(50);
        admin.crearCafeteria(30);
        admin.crearAtraccionMecanica("Rueda", "Verano", "Zona A", "ALTO", 20, 2, 1);
        admin.crearAtraccionCultural("Museo", "Todo el año", "Zona B", "MEDIO", 10, 1, 0, 8, "Lluvia");
        admin.crearTaquilla();

        // Guardar
        PersistenciaAtraccionesYLugares persistencia = new PersistenciaAtraccionesYLugares();
        persistencia.guardarDatos(admin);

        // Nuevo administrador para cargar
        AdministradorAtraccionesYLugares adminCargado = new AdministradorAtraccionesYLugares();
        persistencia.cargarDatos(adminCargado);

        // Mostrar resultados
        adminCargado.getTiendas().forEach(t -> System.out.println("Tienda con " + t.getNumeroJuguetes() + " juguetes."));
        adminCargado.getCafeterias().forEach(c -> System.out.println("Cafetería con " + c.getNumeroComidas() + " comidas."));
        adminCargado.getMecanicas().forEach(a -> System.out.println("Atracción mecánica: " + a.getIdAtraccion()));
        adminCargado.getCulturales().forEach(a -> System.out.println("Atracción cultural: " + a.getIdAtraccion()));
        adminCargado.getTaquillas().forEach(t -> System.out.println("Taquilla cargada."));
    }
}
