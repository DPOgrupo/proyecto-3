package Empleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    protected String login;
    protected String contraseña;
    protected List<String> capacitaciones;
    protected List<Turno> turnosAsignados;
    protected int dinero;

    
    public Empleado(String login, String contraseña, int dinero) {
        this.login = login;
        this.contraseña = contraseña;
        this.dinero = dinero;
        this.capacitaciones = new ArrayList<>();
        this.turnosAsignados = new ArrayList<>();
    }
    
    public abstract void cobrar(int precio, int cantidad, Cliente cliente);


    public int getDinero() { 
    	
    	return dinero; 
    }
    
    
    
    public String getLogin() { 
    	
    	return login; 
    }
    
	public String getContraseña() {
		return contraseña;
	}
    
	public List<Turno> getTurnoAsignado(LocalDate fecha) {
		
	    List<Turno> resultado = new ArrayList<>();

	    for (Turno turno : turnosAsignados) {
	    	
	        if (turno.getFecha().equals(fecha)) {
	            resultado.add(turno);
	        }
	    }

	    return resultado;
	}
	
	
	


    public List<String> getCapacitaciones() {
    	
		return capacitaciones;
		
	}

	public void setDinero(int cantidad) { 
    	
    	this.dinero = cantidad; 
    }

	public void setLogin(String login) {
		
		this.login = login;
		
	}

	
	public void setContraseña(String contraseña) {
		
		this.contraseña = contraseña;
		
	}
    
    public boolean verificarContraseña(String clave) {
    	
        return contraseña.equals(clave);
        
    }

    
    public void quitarDinero(int cantidad) {
    	
    	
        if (cantidad > dinero) {
            System.out.println("No hay suficiente dinero, unicamente hay:" + dinero +"pesos.");
            
        }
        else {
        	
            dinero -= cantidad;
        }
    }
    
    
    public void añadirCapacitacion(String nuevaCapacitacion) {
     	
        if (!capacitaciones.contains(nuevaCapacitacion)) {
        	
            capacitaciones.add(nuevaCapacitacion);
        }
    }

    
    public boolean estaCapacitado(String capacidad) {
    	
        return capacitaciones.contains(capacidad);
    }
    
    
    public void añadirTurno(Turno nuevoTurno) {
    	
    	Turno elTurno = null;
        for (Turno cadaTurno : turnosAsignados) {
        	
            if (cadaTurno.getFecha().equals(nuevoTurno.getFecha()) && cadaTurno.isTurnoNocturno() == nuevoTurno.isTurnoNocturno()) {
                
                
                elTurno = cadaTurno;
                
            }
        }
        turnosAsignados.remove(elTurno);
        turnosAsignados.add(nuevoTurno);
    }



    


    
    
}