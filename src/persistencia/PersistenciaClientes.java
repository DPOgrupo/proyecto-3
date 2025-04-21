package persistencia;

import java.io.*;
import java.util.*;
import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.AdministradorTiquetes;

public class PersistenciaClientes {

	
	private String rutaArchivo = "data/clientes.csv";
	private AdministradorTiquetes admin; 

	public PersistenciaClientes(AdministradorTiquetes admin) {
		this.admin = admin; 
	}
	
    
	
	public void guardarClientes() {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
	       
	        System.out.println("Archivo escrito correctamente.");
	        
	        for (Cliente c : admin.getClientesRegistrados()) {
                writer.println(String.join(",", 
                     
                    c.getNombre(),
                    c.getLogin(),
                    c.getContrasena(), 
                    String.valueOf(c.getDinero()),
                    String.valueOf(c.getEdad()),
                    String.valueOf(c.isRestSalud())
                ));
            }
	        
	    } catch (IOException e) {
	        System.out.println("Error al escribir el archivo: " + e.getMessage());
	    }
	}
	
	public List<Cliente> cargarClientes() {
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
                    int edad = Integer.parseInt(partes[4]);
                    boolean restSalud = Boolean.parseBoolean(partes[5]);

                    Cliente c = new Cliente(login, nombre, contrasena, dinero, edad, restSalud);
                    clientes.add(c);
                }
            }
            System.out.println("Clientes cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }

        return clientes;
    }
    
    

}
	

