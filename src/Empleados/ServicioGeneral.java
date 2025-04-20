package Empleados;

import AtraccionesYServicio.Atraccion;
import Venta_de_tiquetes.Cliente;

public class ServicioGeneral extends Empleado {
    public ServicioGeneral(int ID,String login, String contraseña,int dinero) {
        super( ID,login, contraseña, dinero);
    }

    
    public void reparar(Atraccion atraccion) {
    	atraccion.setDañado(false);
    }
	@Override
	public void cobrar(int precio, int cantidad, Cliente cliente) {		
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



   
