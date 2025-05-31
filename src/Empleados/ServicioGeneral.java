package Empleados;

import AtraccionesYServicio.Atraccion;
import Venta_de_tiquetes.Cliente;

public class ServicioGeneral extends Empleado {
    public ServicioGeneral(int ID,String login, String contraseña,int dinero) {
        super( ID,login, contraseña, dinero);
    }
 // Constructor vacío requerido por Gson
    public ServicioGeneral() {
        super(0, "", "", 0);
    }

    public void reparar(Atraccion atraccion) {
    	
    	String tipo = atraccion.getNivelDeRiesgo(); 
        if (!capacitaciones.contains("MANTENIMIENTO_" +tipo)) {
        	
        	
            System.out.println("El empleado no está capacitado para la atracción ");
            return;
            }
        else 
        {
        	atraccion.setDañado(false);
        }
    	
    }
	@Override
	public void cobrar(int precio, int cantidad, Cliente cliente) {		
	}
	public void mantener(Atraccion atraccion) {
		// TODO Auto-generated method stub
		System.out.println("Manteniendo...");
	}
	
}



   
