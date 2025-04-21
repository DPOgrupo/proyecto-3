package persistencia;

import Empleados.AdministradorEmpleados;
import Empleados.Cajero;
import Venta_de_tiquetes.Cliente;

import java.io.*;
import java.util.*;

public class persistenciaCajeros {

	
	private String rutaArchivo = "data/cajeros.csv";
	private AdministradorEmpleados admin; 

	public persistenciaCajeros(AdministradorEmpleados admin) {
		this.admin = admin; 
	}
	
	public void guardarCajeros() {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
	       
	        System.out.println("Archivo escrito correctamente.");
	        
	        for (Cajero c : admin.getCajeros()) {
                writer.println(String.join(",", 
                     
                    String.valueOf(c.getId()),
                    c.getLogin(),
                    c.getContraseña(), 
                    String.valueOf(c.getDinero())
                   
                ));
            }
	        
	    } catch (IOException e) {
	        System.out.println("Error al escribir el archivo: " + e.getMessage());
	    }
	}
	
	public List<Cajero> cargarCajeros() {
        List<Cajero> cajeros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    int ID = Integer.parseInt(partes[0]);
                    String login = partes[1];
                    String contraseña = partes[2];
                    int dinero = Integer.parseInt(partes[3]);
                    

                    Cajero c = new Cajero( ID, login, contraseña, dinero);
                    cajeros.add(c);
                }
            }
            System.out.println("Clientes cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }

        return cajeros;
    }
	
	
}
