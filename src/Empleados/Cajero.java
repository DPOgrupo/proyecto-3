package Empleados;

import AtraccionesYServicio.Atraccion;
import Venta_de_tiquetes.Cliente;

public class Cajero extends Empleado {
	
	
    public Cajero(int ID,String login, String contraseña, int dinero) {
        super(ID,login, contraseña, dinero);
    }

    // Constructor vacío requerido por Gson
    public Cajero() {
        super(0, "", "", 0); 
    }

	@Override
    public void cobrar(int precio, int cantidad, Cliente cliente) {
		
        int total = precio * cantidad;
        
        int dineroCliente = cliente.getDinero();

        if (dineroCliente >= total) {
        	
            cliente.setDinero(cliente.getDinero() - precio*cantidad);
            
            this.dinero += total;
            
            System.out.println("Compra realizada. Total: $" + total);
            
        } 
        else {
        	
            System.out.println("El cliente no tiene suficiente dinero. Tiene: $" + dineroCliente);
            
        }
    }
	public int getId() {
		return this.ID;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] getSalario() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
