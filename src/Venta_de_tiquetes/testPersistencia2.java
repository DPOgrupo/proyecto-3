
package Venta_de_tiquetes;

import java.util.ArrayList;
import java.util.List;


import Venta_de_tiquetes.AdministradorTiquetes;
import Venta_de_tiquetes.Cliente;
import persistencia.*;

public class testPersistencia2 {

    public static void main(String[] args) {
        AdministradorTiquetes admin = new AdministradorTiquetes();

        PersistenciaClientes persistencia = new PersistenciaClientes(admin);
        List<Cliente> listaClientes = persistencia.cargarClientes();
        
        admin.setClientesRegistrados(listaClientes);

        // Mostrar los clientes cargados
        System.out.println("\n--- CLIENTES CARGADOS DESDE CSV ---");
        System.out.println(admin.getClientesRegistrados().size());
        for (Cliente cliente : admin.getClientesRegistrados()) {
            System.out.println("Login: " + cliente.getLogin() + " | Nombre: " + cliente.getNombre() + 
                               " | Dinero: $" + cliente.getDinero() + " | Restricción salud: " + cliente.isRestSalud());
        }
        
    }
}
