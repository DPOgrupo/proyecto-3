package AtraccionesYServicio;
import Empleados.*;


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
    protected String nivelDeRiesgo;
	private List<Cliente> clientes;
    protected List<Cajero> cajerosAsociados;
    protected List<Cocinero> cocinerosAsociados;
    protected List<ServicioGeneral> serviciosAsociados;
    

    public Atraccion(String nombre,String temporada, String ubicacionFija, String nivelDeRiesgo,int cupoMaximo, int minEmpleadosEncargados, int nivelExclusividad) {
        this.idAtraccion = nombre;
        this.ubicacionFija = ubicacionFija;
        this.cupoMaximo = cupoMaximo;
        this.minEmpleadosEncargados = minEmpleadosEncargados;
        this.nivelExclusividad = nivelExclusividad;
        this.disponible = false;
        this.temporada =temporada; 
        this.nivelDeRiesgo = nivelDeRiesgo;
    	this.clientes = new ArrayList<>();
        this.cajerosAsociados = new ArrayList<>();
        this.cocinerosAsociados = new ArrayList<>();
        this.serviciosAsociados = new ArrayList<>();
        

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
        int total = cajerosAsociados.size() + cocinerosAsociados.size() + serviciosAsociados.size();
        
        if (!danado && estaEnTemporada(LocalDate.now()) && total >= minEmpleadosEncargados)
        	this.disponible = true;
        else 
        	this.disponible = false;
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

    public void añadirCajero(Cajero cajero) {
        if (!cajerosAsociados.contains(cajero)) {
            cajerosAsociados.add(cajero);
            setDisponible();
        }
    }

    public void quitarCajero(Cajero cajero) {
        if (cajerosAsociados.remove(cajero)) {
            setDisponible();
        }
    }

    public void añadirCocinero(Cocinero cocinero) {
        if (!cocinerosAsociados.contains(cocinero)) {
            cocinerosAsociados.add(cocinero);
            setDisponible();
        }
    }

    public void quitarCocinero(Cocinero cocinero) {
        if (cocinerosAsociados.remove(cocinero)) {
            setDisponible();
        }
    }

    public void añadirServicio(ServicioGeneral servicio) {
        if (!serviciosAsociados.contains(servicio)) {
            serviciosAsociados.add(servicio);
            setDisponible();
        }
    }

    public void quitarServicio(ServicioGeneral servicio) {
        if (serviciosAsociados.remove(servicio)) {
            setDisponible();
        }
    }

    public List<Cajero> getCajerosAsociados() {
        return cajerosAsociados;
    }

    public List<Cocinero> getCocinerosAsociados() {
        return cocinerosAsociados;
    }

    public List<ServicioGeneral> getServiciosAsociados() {
        return serviciosAsociados;
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

    
    public String getTemporada() {
        return temporada;
    }

        
    public String getNivelDeRiesgo() {
		return nivelDeRiesgo;
	}
    
    
    
    public String getIdAtraccion() {
		return idAtraccion;
	}
    
    
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	



	public abstract boolean cumpleRestricciones(Venta_de_tiquetes.Cliente cliente); 
}
