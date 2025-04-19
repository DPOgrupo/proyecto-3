package Empleados;

import java.util.ArrayList;
import java.util.List;

public class Tienda extends LugarDeServicio {
	
    private List<Empleado> cajerosAsociados;
    private int numeroJuguetes;

    public Tienda() {
    	
        this.cajerosAsociados = new ArrayList<>();
        this.numeroJuguetes = 99;
    }

    @Override
    public void setDisponible() {
        if (cajerosAsociados.size() >= 1)
        {
            disponible = true;
            
        } 
        
        else {
        	
            disponible = false;
            
        }
    }

    

    public int getNumeroJuguetes() {
		return numeroJuguetes;
	}
    


	public void setNumeroJuguetes(int cantidad) {
    	
        this.numeroJuguetes = cantidad;
        
    }
	
    public void aumentarJuguetes(int cantidad) {
    	numeroJuguetes += cantidad;
    }
    
    public void quitarJuguetes(int cantidad) {
    	
        if (cantidad > numeroJuguetes) {
            System.out.println("No hay suficientes juguetes para quitar " + cantidad + ", unicamente hay:" +numeroJuguetes +"juguetes.");
            
        }
        else {
        	
            numeroJuguetes -= cantidad;
        }
    }

    
}
