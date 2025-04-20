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
	private String nivelDeRiesgo; //ALTO, MEDIO
	
	
	
	

	public Atraccion() {
		
		this.disponible = false;
	}


    public boolean isDisponible() {
    	
        return disponible;
        
    }

    
    public void setDisponible() {
        if (empleados.size() >= minEmpleadosEncargados && !danado)
        {
            disponible = true;
            
        } 
        
        else {
        	
            disponible = false;
            
        }
    }



    public void añadirEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
            
            setDisponible();
        }
    }

    public void quitarEmpleado(Empleado empleado) {
        if (empleados.contains(empleado)) {
            empleados.remove(empleado);
            
            setDisponible();
        }
    }


	public void setDañado(boolean estado) {
		this.danado = estado;
		
	}


	public String getNivelDeRiesgo() {
		return nivelDeRiesgo;
	}







}
