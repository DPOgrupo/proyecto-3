package persistencia;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.Tiquete;
import Venta_de_tiquetes.TiqueteFastPass;
import Venta_de_tiquetes.TiqueteIndividual;
import Venta_de_tiquetes.TiqueteRegular;
import Venta_de_tiquetes.TiqueteTemporada;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaClientes {

	private static final String RUTA_ARCHIVO = "clientes.json";
    private final Gson gson;

    public PersistenciaClientes() {
        gson = new GsonBuilder()
        	    .registerTypeAdapter(java.time.LocalDate.class, new persistencia.LocalDateAdapter())
                .setPrettyPrinting()
                .create();
    }

    public void guardarClientes(List<Cliente> clientes) {
        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO)) {
            gson.toJson(clientes, writer);
            System.out.println("Clientes guardados correctamente en " + RUTA_ARCHIVO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> cargarClientes() {
        try (FileReader reader = new FileReader(RUTA_ARCHIVO)) {
            Type tipoLista = new TypeToken<ArrayList<Cliente>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("el pepe");
            return new ArrayList<>(); // retornar lista vacía si falla
        }
    }
}