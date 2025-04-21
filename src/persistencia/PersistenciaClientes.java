package persistencia;

import java.io.*;
import java.util.*;
import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.AdministradorTiquetes;

public class PersistenciaClientes {

	private static final String rutaArchivo = "clientes.csv";
	private AdministradorTiquetes admin; 

	
    public void guardarClientes() {
        
    	try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Cliente c : admin.getClientesRegistrados()) {
                writer.println(String.join(",", 
                    c.getLogin(), 
                    c.getNombre(), 
                    c.getContrasena(), 
                    String.valueOf(c.getDinero()), 
                    String.valueOf(c.isRestSalud())
                ));
            }
            System.out.println("Clientes guardados correctamente.");
        } 
        
        catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }
    
    public void cargarClientes() {
        
    	List<Cliente> clientes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String login = partes[0];
                    String nombre = partes[1];
                    String contrasena = partes[2];
                    int dinero = Integer.parseInt(partes[3]);
                    boolean restSalud = Boolean.parseBoolean(partes[4]);

                    Cliente c = new Cliente(login, nombre, contrasena, dinero, restSalud);
                    clientes.add(c);
                }
            }
            System.out.println("Clientes cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }

        admin.setClientesRegistrados(clientes);
    }

}
	

