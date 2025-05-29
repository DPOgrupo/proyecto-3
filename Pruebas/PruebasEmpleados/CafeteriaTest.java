package PruebasEmpleados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Empleados.Cafeteria;
import Empleados.Cocinero;
import Empleados.Cajero;

public class CafeteriaTest {

    @Test
    public void cocinarDebeAumentarNumeroDeAlmuerzos() {
        Cafeteria cafeteria = new Cafeteria();
        assertEquals(0, cafeteria.getNumeroComidas());

        cafeteria.aumentarComidas(3);
        assertEquals(3, cafeteria.getNumeroComidas());
    }


    @Test
    public void cafeteriaDebeEstarDisponibleSiTieneCocineroYCajero() {
        Cafeteria cafeteria = new Cafeteria();
        Cajero cajero = new Cajero(1,"cajero", "1234", 0);
        Cocinero cocinero = new Cocinero(1,"cocinero", "abcd", 0);
        cocinero.añadirCapacitacion("COCINA");

        assertFalse(cafeteria.isDisponible());

        cafeteria.añadirCajero(cajero);
        assertFalse(cafeteria.isDisponible());

        cafeteria.añadirCocinero(cocinero);
        assertTrue(cafeteria.isDisponible());
    }

    @Test
    public void cafeteriaNoDebeEstarDisponibleSiFaltaCocinero() {
        Cafeteria cafeteria = new Cafeteria();
        Cajero cajero = new Cajero(1,"cajero", "1234", 0);

        cafeteria.añadirCajero(cajero);
        assertFalse(cafeteria.isDisponible());
    }

    @Test
    public void cafeteriaNoDebeEstarDisponibleSiFaltaCajero() {
        Cafeteria cafeteria = new Cafeteria();
        Cocinero cocinero = new Cocinero(1,"cocinero", "abcd", 0);
        cocinero.añadirCapacitacion("COCINA");

        cafeteria.añadirCocinero(cocinero);
        assertFalse(cafeteria.isDisponible());
    }
} 

