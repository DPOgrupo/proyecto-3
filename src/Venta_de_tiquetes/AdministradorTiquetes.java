package Venta_de_tiquetes;

import java.util.ArrayList;
import java.util.List;

public class AdministradorTiquetes {

	private List<Cliente> clientesRegistrados;
	private Taquilla taquilla; 
	
	
	public AdministradorTiquetes() {
		
		this.clientesRegistrados = new ArrayList<Cliente>();
	}
	
	public void registrarCliente(Cliente cliente) {
		
		clientesRegistrados.add(cliente);
	}
	
	public List<Cliente> getClientesRegistrados() {
		
		return this.clientesRegistrados;
	}
	
	public void setClientesRegistrados(List<Cliente> nuevosClientes) {
		this.clientesRegistrados = nuevosClientes;
	}
}

