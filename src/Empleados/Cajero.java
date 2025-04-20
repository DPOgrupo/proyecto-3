package Empleados;

import AtraccionesYServicio.Atraccion;
import Venta_de_tiquetes.Cliente;

public class Cajero extends Empleado {
	
	
    public Cajero(int ID,String login, String contraseña, int dinero) {
        super(ID,login, contraseña, dinero);
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


	
	public void añadirTurno(Turno nuevoTurno) {
	    if ("Atraccion".equals(nuevoTurno.getQueSoy())) {
	        Atraccion atraccion = (Atraccion) nuevoTurno.getLugar();
	        String tipo = atraccion.getNivelDeRiesgo(); 

	        if (capacitaciones.contains("MANTENIMIENTO" +tipo)) {
	            System.out.println("El empleado no está capacitado para la atracción ");
	            return;
	        }
	    }

	    Turno elTurno = null;
	    for (Turno cadaTurno : turnosAsignados) {
	        if (cadaTurno.getFecha().equals(nuevoTurno.getFecha()) && cadaTurno.isTurnoNocturno() == nuevoTurno.isTurnoNocturno())
	        {
	            elTurno = cadaTurno;
	        }
	    }

	    turnosAsignados.remove(elTurno);
	    turnosAsignados.add(nuevoTurno);
	}
}
