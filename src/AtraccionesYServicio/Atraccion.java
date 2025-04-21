package AtraccionesYServicio;


import Empleados.Empleado;
import Venta_de_tiquetes.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Atraccion extends AtraccionOEspectaculo {
    protected String ubicacionFija; 
    protected int cupoMaximo; 
    protected int minEmpleadosEncargados;
    protected int nivelExclusividad; // Basico, Familiar, Oro, Diamante--> 0,1,2,3
    protected boolean danado; 
    protected List<Empleado> empleados;
    protected String nivelDeRiesgo;
	private List<Cliente> clientes;
    

    public Atraccion(String nombre,String temporada, String ubicacionFija, String nivelDeRiesgo,int cupoMaximo, int minEmpleadosEncargados, int nivelExclusividad) {
        this.idAtraccion = nombre;
        this.ubicacionFija = ubicacionFija;
        this.cupoMaximo = cupoMaximo;
        this.minEmpleadosEncargados = minEmpleadosEncargados;
        this.nivelExclusividad = nivelExclusividad;
        this.disponible = false;
        this.empleados = new ArrayList<>();
        this.temporada =temporada; 
        this.nivelDeRiesgo = nivelDeRiesgo;
    	this.clientes = new ArrayList<>();

    }

    public boolean isDisponible() {
        return disponible;
    }
    
    public boolean estaEnTemporada(LocalDate fecha) {
        int mes = fecha.getMonthValue();

        if (temporada.equals("TODO_EL_ANO")) {
            return true;
        } 
        
        else if (temporada.equals("INVIERNO")) {
        	
            return mes == 12 || mes == 1 || mes == 2;
        } 
        else if (temporada.equals("PRIMAVERA")) {
        	
            return mes == 3 || mes == 4 || mes == 5;
        } 
        else if (temporada.equals("VERANO")) {
        	
            return mes == 6 || mes == 7 || mes == 8;
        } 
        else if (temporada.equals("OTONO")) {
        	
            return mes == 9 || mes == 10 || mes == 11;
        }

        return false;
    }

    
    
    
    public void setDisponible() {
    	
    	
        if (empleados.size() >= minEmpleadosEncargados && !danado && estaEnTemporada(LocalDate.now())) {
            disponible = true;
        } else {
            disponible = false;
        }
    }
    
    
    public boolean añadirCliente(Cliente cliente) {


        if (clientes.size() < cupoMaximo) {
        	
            if (!cumpleRestricciones(cliente)) {
            	
                System.out.println("El cliente no cumple con las restricciones para ingresar.");
                return false;
            }
            clientes.add(cliente);
            
            return true;
        } 
        else 
        {
            System.out.println("No hay cupo disponible.");
            return false;
        }
    }
    
    public boolean quitarCliente(Cliente cliente) {
        return clientes.remove(cliente);
    }
    
    public void vaciarClientes() {
        clientes.clear();
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
    
    public boolean getDañado() {
        return danado;
    }

    public String getUbicacionFija() {
        return ubicacionFija;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public int getMinEmpleadosEncargados() {
        return minEmpleadosEncargados;
    }

    public int getNivelExclusividad() {
        return nivelExclusividad;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    public String getTemporada() {
        return temporada;
    }

        
    public String getNivelDeRiesgo() {
		return nivelDeRiesgo;
	}
    
    
	public List<Cliente> getClientes() {
		return clientes;
	}



	public abstract boolean cumpleRestricciones(Venta_de_tiquetes.Cliente cliente); 
}
