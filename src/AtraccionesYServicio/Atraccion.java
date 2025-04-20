package AtraccionesYServicio;

import java.util.List;

import Empleados.Empleado;

public class Atraccion extends AtraccionOEspectaculo{
	
	private String ubicacionFija; 
	private int cupoMaximo; 
	private int minEmpleadosEncargados;
	private int nivelExclusividad; 
	private boolean danado; 
	private List<Empleado> empleados;
	
	
	
	

	public Atraccion() {
		
		this.disponible = false;
	}




	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}




    public void añadirEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
        }
    }

    public void quitarEmpleado(Empleado empleado) {
        if (empleados.contains(empleado)) {
            empleados.remove(empleado);
        }
    }





}
