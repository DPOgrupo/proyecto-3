package Empleados;

import java.util.ArrayList;
import java.util.List;

import Venta_de_tiquetes.Cliente;

public class Tienda extends LugarDeServicio {
	
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

    public void venderTiquetes(int cantidad, Cliente cliente) {
        if (!isDisponible()) {
            System.out.println("Venta fallida: No hay suficientes cajeros disponibles.");
            return;
        }

        if (cantidad > numeroJuguetes) {
            System.out.println("No hay suficientes juguetes para quitar " + cantidad + ", actualmente hay: " + numeroJuguetes);
            return;
        }

        Empleado vendedor = cajerosAsociados.get(0);
        vendedor.cobrar(10, cantidad, cliente);// 10 unidades por almuerzo
        quitarJuguetes(cantidad);
    }

}