package PruebasEmpleados;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.zxing.WriterException;

import Empleados.*;
import Venta_de_tiquetes.*;

public class VentaCajeroTest {

    @Test
    public void testVentaEnTiendaConCajero() {
        Cliente cliente = new Cliente("cliente", "usuario", "1234", 1000,18);
        Cajero cajero = new Cajero(1, "cajero", "clave", 0);

        Tienda tienda = new Tienda();
        tienda.setNumeroJuguetes(10);
        tienda.añadirCajero(cajero);

        tienda.venderTiquetes(2, cliente);

        assertEquals(980, cliente.getDinero()); // 2 juguetes * 10
        assertEquals(8, tienda.getNumeroJuguetes());
    }

    @Test
    public void testVentaEnCafeteriaConCocineroYCajero() {
        Cliente cliente = new Cliente("cliente", "usuario", "1234", 500,18);
        Cajero cajero = new Cajero(1, "cajero", "clave", 0);
        Cocinero cocinero = new Cocinero(3, "cook", "clave", 0);

        Cafeteria cafeteria = new Cafeteria();
        cafeteria.setNumeroComidas(5);
        cafeteria.añadirCajero(cajero);
        cafeteria.añadirCocinero(cocinero);

        cafeteria.venderAlmuerzos(2, cliente);

        assertEquals(470, cliente.getDinero()); // 2 almuerzos * 15
        assertEquals(3, cafeteria.getNumeroComidas());
    }

    @Test
    public void testVentaEnTaquillaConCliente() throws FondosInsuficientesException, WriterException, IOException {
        Cliente cliente = new Cliente("cliente", "usuario", "1234", 100000, 18);
        Taquilla taquilla = new Taquilla();
        Cajero cajero = new Cajero(1, "taquillero", "clave", 0);
        taquilla.añadirCajero(cajero);

        taquilla.venderTiqueteRegular(cliente, CategoriaExclusividad.ORO, false);

        List<Tiquete> tiquetes = cliente.getTiquetes();
        assertFalse(tiquetes.isEmpty());
        assertTrue(tiquetes.get(0) instanceof TiqueteRegular);
        assertTrue(cliente.getDinero() < 100000);
    }
    
    @Test
    public void testVentaFallidaPorFaltaDeCajeroEnTienda() {
        Cliente cliente = new Cliente("cliente", "1234", "clave", 500, 18);
        Tienda tienda = new Tienda();
        tienda.setNumeroJuguetes(5); // Tiene juguetes pero nadie para vender

        tienda.venderTiquetes(2, cliente);

        assertEquals(500, cliente.getDinero());
        assertEquals(5, tienda.getNumeroJuguetes());
    }

    @Test
    public void testVentaFallidaPorFaltaDeCocineroEnCafeteria() {
        Cliente cliente = new Cliente("cliente", "1234", "clave", 500, 18);
        Cafeteria cafeteria = new Cafeteria();
        Cajero cajero = new Cajero(1, "cajero", "clave", 0);
        cafeteria.setNumeroComidas(5);
        cafeteria.añadirCajero(cajero); // Falta cocinero

        cafeteria.venderAlmuerzos(1, cliente);

        assertEquals(500, cliente.getDinero());
        assertEquals(5, cafeteria.getNumeroComidas());
    }

    @Test
    public void testVentaFallidaPorFaltaDeJuguetes() {
        Cliente cliente = new Cliente("cliente", "1234", "clave", 300, 18);
        Cajero cajero = new Cajero(1, "cajero", "clave", 0);
        Tienda tienda = new Tienda();
        tienda.setNumeroJuguetes(1); 
        tienda.añadirCajero(cajero);

        tienda.venderTiquetes(3, cliente); // Pide más de lo que hay

        assertEquals(300, cliente.getDinero());
        assertEquals(1, tienda.getNumeroJuguetes());
    }

    @Test
    public void testVentaFallidaPorFaltaDeComidas() {
        Cliente cliente = new Cliente("cliente", "1234", "clave", 200, 18);
        Cajero cajero = new Cajero(1, "cajero", "clave", 0);
        Cocinero cocinero = new Cocinero(2, "cocinero", "clave", 0);

        Cafeteria cafeteria = new Cafeteria();
        cafeteria.setNumeroComidas(2);
        cafeteria.añadirCajero(cajero);
        cafeteria.añadirCocinero(cocinero);

        cafeteria.venderAlmuerzos(5, cliente); // Pide más de lo que hay

        assertEquals(200, cliente.getDinero());
        assertEquals(2, cafeteria.getNumeroComidas());
    }
    
}
