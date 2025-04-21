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
	
    /*public void guardarClientes() {
    	//System.out.println("Clientes encontrados en admin: " + admin.getClientesRegistrados());
    	System.out.println("Guardando clientes en: " + rutaArchivo);
    	System.out.println("Total clientes: " + admin.getClientesRegistrados().size());
    	try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
    		System.out.println("Ruta absoluta del archivo: " + new File(rutaArchivo).getAbsolutePath());
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
            //System.out.println("Clientes encontrados en admin: " + admin.getClientesRegistrados());
        } 
        
        catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }*/
	
	public void guardarClientes() {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
	        writer.println("mondongo");
	        System.out.println("Archivo escrito correctamente.");
	        
	        for (Cliente c : admin.getClientesRegistrados()) {
                writer.println(String.join(",", 
                    c.getLogin(), 
                    c.getNombre(), 
                    c.getContrasena(), 
                    String.valueOf(c.getDinero()), 
                    String.valueOf(c.isRestSalud())
                ));
            }
	        
	    } catch (IOException e) {
	        System.out.println("Error al escribir el archivo: " + e.getMessage());
	    }
	}
    
    

}
	

