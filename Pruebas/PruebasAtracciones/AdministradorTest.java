package PruebasAtracciones;

import Empleados.*;
import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdministradorTest {

    private AdministradorEmpleados adminEmpleado;
    private AdministradorAtraccionesYLugares adminAtracciones;
    private AtraccionMecanica montanaRusa;
    private Cajero cajero;
    private Cliente clienteValido;
    private Cliente clienteInvalido;

    @BeforeEach
    public void setUp() {
        adminEmpleado = new AdministradorEmpleados("admin", "1234");
        adminEmpleado.crearCajero("cajero1", "abc");

        adminAtracciones = new AdministradorAtraccionesYLugares();
        adminAtracciones.crearAtraccionMecanica("Montaña Rusa", "VERANO", "Zona A", "ALTO", 3, 1, 1);
        montanaRusa = adminAtracciones.getMecanicas().get(0);

        cajero = adminEmpleado.getCajeros().get(0);
        montanaRusa.añadirEmpleado(cajero);
        montanaRusa.setDisponible();

        clienteValido = new Cliente("Carlos", "carlosLogin", "pass123", 500, 15);
        clienteInvalido = new Cliente("Lucía", "luciaLogin", "pass456", 300, 10);
    }

    @Test
    public void testCajeroEnLista() {
        List<Cajero> cajeros = adminEmpleado.getCajeros();
        assertTrue(cajeros.contains(cajero), "El cajero debería estar en la lista de empleados");
    }

    @Test
    public void testAtraccionDisponibleConMinimoEmpleados() {
        assertTrue(montanaRusa.isDisponible(), "La atracción debería estar disponible con el mínimo de empleados");
    }

    @Test
    public void testClienteValidoPuedeEntrar() {
        assertTrue(montanaRusa.añadirCliente(clienteValido), "Cliente válido debería poder entrar a la atracción");
    }

    @Test
    public void testClienteInvalidoNoPuedeEntrar() {
        assertFalse(montanaRusa.añadirCliente(clienteInvalido), "Cliente inválido no debería poder entrar (edad mínima)");
    }

    @Test
    public void testQuitarCliente() {
        montanaRusa.añadirCliente(clienteValido);
        assertTrue(montanaRusa.quitarCliente(clienteValido), "Debería poder quitar cliente existente");
        assertFalse(montanaRusa.getClientes().contains(clienteValido), "Cliente ya no debería estar en la atracción");

    }

    @Test
    public void testVaciarAtraccion() {
        montanaRusa.añadirCliente(clienteValido);
        montanaRusa.vaciarClientes();
        assertEquals(0, montanaRusa.getClientes().size(), "La atracción debería estar vacía");
    }
}
