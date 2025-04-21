
package Venta_de_tiquetes;

import java.util.ArrayList;
import java.util.List;


import Venta_de_tiquetes.AdministradorTiquetes;
import Venta_de_tiquetes.Cliente;
import persistencia.*;

public class TestPersistencia {

    public static void main(String[] args) {
        AdministradorTiquetes admin = new AdministradorTiquetes();

        // Crear algunos clientes de prueba
        Cliente c1 = new Cliente("Santiago Rojas", "Yago", "1234", 250000, 20, false);
        Cliente c2 = new Cliente("Juan Jose", "Reytilin69", "abcd", 180000, 21, true);
        Cliente c3 = new Cliente("Sandra Ana", "Analbel", "clave666", 300000, 16, false);
        List<Cliente> listaDeClientes = new ArrayList<Cliente>();
        
        listaDeClientes.add(c1);
        listaDeClientes.add(c2);
        listaDeClientes.add(c3);
        
        admin.setClientesRegistrados(listaDeClientes);

        // Guardar clientes
        PersistenciaClientes persistencia = new PersistenciaClientes(admin);
        persistencia.guardarClientes();

        
    }
}
