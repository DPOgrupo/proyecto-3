package Venta_de_tiquetes;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

	
	
	private String login; 
	private String nombre;
	private String contrasena; 
	private List<Tiquete> tiquetesDeCliente;
	private int dinero; 
	
	public Cliente(String nombre, String login, String contrasena, int dimero) {
        this.nombre = nombre; 
		this.login = login;
        this.tiquetesDeCliente= new ArrayList<Tiquete>();
        this.dinero = dimero; 
    }
	
	public int getDinero() {
		return this.dinero;
	}
	
	public void setDinero(int dinero) {
		this.dinero = dinero; 
	}
	
	public void addTiquete(Tiquete tic) {
		this.tiquetesDeCliente.add(tic);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Tiquete> getTiquetes(){
		return this.tiquetesDeCliente;
	}
}

