package Empleados;

import java.util.ArrayList;
import java.util.List;

import Venta_de_tiquetes.Cliente;

public class Cafeteria extends LugarDeServicio {

    private List<Empleado> cocinerosAsociados;
    private int numeroAlmuerzos;

    public Cafeteria() {
    	
        this.cajerosAsociados = new ArrayList<>();
        this.cocinerosAsociados = new ArrayList<>();
        this.numeroAlmuerzos = 90;
    }

    @Override
    public void setDisponible() {
        if (cajerosAsociados.size() >= 1 && cocinerosAsociados.size() >= 1) {
            disponible = true;
            
        } 
        
        else {
        	
            disponible = false;
        }
    }

    public void setNumeroComidas(int cantidad) {
        this.numeroAlmuerzos = cantidad;
    }

    public void aumentarComidas(int cantidad) {
        numeroAlmuerzos += cantidad;
    }

    public void quitarComidas(int cantidad) {
        if (cantidad > numeroAlmuerzos) {
            System.out.println("No hay suficientes almuerzos para quitar " + cantidad + ", actualmente hay: " + numeroAlmuerzos);
        } 
        else 
        {
            numeroAlmuerzos -= cantidad;
        }
    }

    public void añadirCocinero(Empleado empleado) {
        if (empleado.estaCapacitado("COCINA")) {
        	
            if (!cocinerosAsociados.contains(empleado)) {
                cocinerosAsociados.add(empleado);
                setDisponible();
            }
        }
        else
        {
            System.out.println("El empleado no tiene capacitación en cocina.");
        }
        setDisponible();
    }

    public void quitarCocinero(Empleado empleado) {
    	
        if (cocinerosAsociados.contains(empleado)) {
        	
            cocinerosAsociados.remove(empleado);
            setDisponible();
        }
        setDisponible();
    }


	public List<Empleado> getCocinerosAsociados() {
		return cocinerosAsociados;
	}

	public int getNumeroComidas() {
		return numeroAlmuerzos;
	}
	
	public void venderAlmuerzos(int cantidad, Cliente cliente) {
	    if (!isDisponible()) {
	        System.out.println("Venta fallida: No hay suficientes cajeros o cocineros disponibles.");
	        return;
	    }

	    if (cantidad > numeroAlmuerzos) {
	        System.out.println("No hay suficientes almuerzos para vender " + cantidad + ", actualmente hay: " + numeroAlmuerzos);
	        return;
	    }

	    Empleado cajero = cajerosAsociados.get(0);
	    cajero.cobrar(15, cantidad, cliente); // 15 unidades por almuerzo
	    quitarComidas(cantidad);
	}

    
    
}



