package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import AtraccionesYServicio.AdministradorAtraccionesYLugares;
import AtraccionesYServicio.*;
import Empleados.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Venta_de_tiquetes.*;

public class PersistenciaAtraccionesYLugares {

    private static final String ARCHIVO_TIENDAS = "data/tiendas.json";
    private static final String ARCHIVO_CAFETERIAS = "data/cafeterias.json";
    private static final String ARCHIVO_MECANICAS = "data/mecanicas.json";
    private static final String ARCHIVO_CULTURALES = "data/culturales.json";
    private static final String ARCHIVO_ESPECTACULOS = "data/espectaculos.json";
    private static final String ARCHIVO_TAQUILLAS = "data/taquillas.json";

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(java.time.LocalDate.class, new persistencia.LocalDateAdapter())
            .setPrettyPrinting()
            .create();

    public PersistenciaAtraccionesYLugares() {}

    public void guardarDatos(AdministradorAtraccionesYLugares admin) {
        try (FileWriter writer1 = new FileWriter(ARCHIVO_TIENDAS);
             FileWriter writer2 = new FileWriter(ARCHIVO_CAFETERIAS);
             FileWriter writer3 = new FileWriter(ARCHIVO_MECANICAS);
             FileWriter writer4 = new FileWriter(ARCHIVO_CULTURALES);
             FileWriter writer5 = new FileWriter(ARCHIVO_ESPECTACULOS);
             FileWriter writer6 = new FileWriter(ARCHIVO_TAQUILLAS)) {

            gson.toJson(admin.getTiendas(), writer1);
            gson.toJson(admin.getCafeterias(), writer2);
            gson.toJson(admin.getMecanicas(), writer3);
            gson.toJson(admin.getCulturales(), writer4);
            gson.toJson(admin.getEspectaculos(), writer5);
            gson.toJson(admin.getTaquillas(), writer6);

            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            throw new RuntimeException("Error guardando datos: " + e.getMessage(), e);
        }
    }

    public void cargarDatos(AdministradorAtraccionesYLugares admin) {
        try (FileReader reader1 = new FileReader(ARCHIVO_TIENDAS);
             FileReader reader2 = new FileReader(ARCHIVO_CAFETERIAS);
             FileReader reader3 = new FileReader(ARCHIVO_MECANICAS);
             FileReader reader4 = new FileReader(ARCHIVO_CULTURALES);
             FileReader reader5 = new FileReader(ARCHIVO_ESPECTACULOS);
             FileReader reader6 = new FileReader(ARCHIVO_TAQUILLAS)) {

            List<Tienda> tiendas = new ArrayList<>(List.of(gson.fromJson(reader1, Tienda[].class)));
            List<Cafeteria> cafeterias = new ArrayList<>(List.of(gson.fromJson(reader2, Cafeteria[].class)));
            List<AtraccionMecanica> mecanicas = new ArrayList<>(List.of(gson.fromJson(reader3, AtraccionMecanica[].class)));
            List<AtraccionCultural> culturales = new ArrayList<>(List.of(gson.fromJson(reader4, AtraccionCultural[].class)));
            List<Espectaculo> espectaculos = new ArrayList<>(List.of(gson.fromJson(reader5, Espectaculo[].class)));
            List<Taquilla> taquillas = new ArrayList<>(List.of(gson.fromJson(reader6, Taquilla[].class)));

            admin.setTiendas(tiendas);
            admin.setCafeterias(cafeterias);
            admin.setMecanicas(mecanicas);
            admin.setCulturales(culturales);
            admin.setEspectaculos(espectaculos);
            admin.setTaquillas(taquillas);

            System.out.println("Datos cargados correctamente.");
        } catch (IOException e) {
            throw new RuntimeException("Error cargando datos: " + e.getMessage(), e);
        }
    }
}
