package persistencia;

import Venta_de_tiquetes.*;
import persistencia.PersistenciaClientes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainPersistenciaClientesTest {

	public static void main(String[] args) {
        PersistenciaClientes persistencia = new PersistenciaClientes();

        // Crear lista de clientes simple
        List<Cliente> clientes = new ArrayList<>();
        Cliente c1 = new Cliente("Santiago Rojas", "Yago", "Lucas1226", 300000, 18);
        clientes.add(c1);
        
        // Guardar clientes
        persistencia.guardarClientes(clientes);

        // Cargar clientes
        List<Cliente> cargados = persistencia.cargarClientes();
        for (Cliente c : cargados) {
            System.out.println(c.getLogin() + " - " + c.getNombre());
        }
    }
}
