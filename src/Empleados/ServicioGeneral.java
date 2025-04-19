package Empleados;

import AtraccionesYServicio.Atraccion;

public class ServicioGeneral extends Empleado {
    public ServicioGeneral(String login, String contraseña,int dinero) {
        super(login, contraseña, dinero);
    }

    
    public void reparar(Atraccion atraccion) {
    	atraccion.setDisponible(true);
    }
	@Override
	public void cobrar(int precio, int cantidad, Cliente cliente) {		
	}

   
}