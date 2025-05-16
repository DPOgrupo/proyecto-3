package persistencia;

import java.io.*;
import com.google.gson.*;
import java.util.*;
import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.AdministradorTiquetes;
import com.google.gson.*;
public class PersistenciaClientes {

	
	private String rutaArchivo = "data/clientes.csv";
	private AdministradorTiquetes admin; 

	public PersistenciaClientes(AdministradorTiquetes admin) {
		this.admin = admin; 
	}
	
    
	Gson gson = new Gson();
	public void guardarClientes() {
	    
    
    
	}
	
}
