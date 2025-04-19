package AtraccionesYServicio;

import java.util.List;

import Empleados.Empleado;

public class Atraccion extends AtraccionOEspectaculo{
	
	private String ubicacionFija; 
	private int cupoMaximo; 
	private int minEmpleadosEncargados;
	private int nivelExclusividad; 
	private boolean danado; 
	private List<Empleado> Empleados;
	
	
	
	

	public Atraccion() {
		
		this.disponible = false;
	}




	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}





}
