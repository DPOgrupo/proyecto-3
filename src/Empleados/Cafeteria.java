package Empleados;

import java.util.List;
import Venta_de_tiquetes.Cliente;

public class Cafeteria extends LugarDeServicio {

    private int numeroAlmuerzos;

    public Cafeteria() {
        super();
        this.numeroAlmuerzos = 90;
    }

    @Override
    public void setDisponible() {
        this.disponible = !cajerosAsociados.isEmpty() && !cocinerosAsociados.isEmpty();
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
        } else {
            numeroAlmuerzos -= cantidad;
        }
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

        Cajero cajero = cajerosAsociados.get(0); 
        cajero.cobrar(15, cantidad, cliente); // 15 unidades por almuerzo
        quitarComidas(cantidad);
    }

    public List<Cocinero> getCocinerosAsociados() {
        return cocinerosAsociados;
    }

    public List<Cajero> getCajerosAsociados() {
        return cajerosAsociados;
    }
}
