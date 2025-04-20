package Empleados;

import java.util.ArrayList;
import java.util.List;

public abstract class LugarDeServicio {
	
    protected boolean disponible;
    protected List<Empleado> cajerosAsociados;

    
    public LugarDeServicio() {
    	
        cajerosAsociados = new ArrayList<>();
        disponible = false;
    }

    public abstract void setDisponible();

    public List<Empleado> getCajeros() {
    	
        return cajerosAsociados;
        
    }
    public void añadirEmpleado(Empleado empleado) {
    	
        if (!cajerosAsociados.contains(empleado)) {
        	
            cajerosAsociados.add(empleado);
            setDisponible();
        } 
        
        else {
        	
            System.out.println("El empleado ya está asociado como cajero.");
        }
    }

    public void quitarEmpleado(Empleado empleado) {
        if (cajerosAsociados.contains(empleado)) {
        	
            cajerosAsociados.remove(empleado);
        } 
        
        else {
        	
            System.out.println("El empleado no está asociado como cajero.");
        }
        setDisponible();
    }

    public boolean isDisponible() {
    	
        return disponible;
        
    }
}