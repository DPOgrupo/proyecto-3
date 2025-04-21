package PruebasAtracciones;

import Empleados.*;
import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdministradorTest {

    private AdministradorEmpleados adminEmp;
    private AdministradorAtraccionesYLugares adminAtr;
    private AtraccionMecanica montanaRusa;
    private Cajero cajero;
    private Cliente clienteValido;
    private Cliente clienteInvalido;
    private TiqueteRegular tiquete1;
    
    @BeforeEach
    public void setUp() {
        adminEmp = new AdministradorEmpleados("admin", "1234");
        adminEmp.crearCajero("cajero1", "abc");

        adminAtr = new AdministradorAtraccionesYLugares();
        adminAtr.crearAtraccionMecanica("Montaña Rusa", "PRIMAVERA", "Zona A", "ALTO", 3, 1, 1);
        montanaRusa = adminAtr.getMecanicas().get(0);

        cajero = adminEmp.getCajeros().get(0);
        montanaRusa.añadirEmpleado(cajero);
        montanaRusa.setDisponible();

        clienteValido = new Cliente("Carlos", "carlosLogin", "pass123", 500, 15);
        clienteInvalido = new Cliente("Lucía", "luciaLogin", "pass456", 300, 10);
        tiquete1 = new TiqueteRegular(CategoriaExclusividad.ORO);
        clienteValido.addTiquete(tiquete1);
    }

    @Test
    public void testCajeroEnLista() {
        List<Cajero> cajeros = adminEmp.getCajeros();
        assertTrue(cajeros.contains(cajero));
    }

    @Test
    public void testAtraccionDisponibleConMinimoEmpleados() {
    	
    	assertTrue(montanaRusa.estaEnTemporada(LocalDate.now()));
    	assertTrue(!montanaRusa.getDañado());
        assertTrue(montanaRusa.isDisponible());
    }

    @Test
    public void testClienteValidoPuedeEntrar() {
        assertTrue(montanaRusa.añadirCliente(clienteValido));
    }

    @Test
    public void testClienteInvalidoNoPuedeEntrar() {
        assertFalse(montanaRusa.añadirCliente(clienteInvalido));
    }

    @Test
    public void testQuitarCliente() {
        montanaRusa.añadirCliente(clienteValido);
        assertTrue(montanaRusa.quitarCliente(clienteValido));
        assertFalse(montanaRusa.getClientes().contains(clienteValido));
    }

    @Test
    public void testVaciarAtraccion() {
        montanaRusa.añadirCliente(clienteValido);
        montanaRusa.vaciarClientes();
        assertEquals(0, montanaRusa.getClientes().size());
    }
    
    
    @Test
    public void testRepararAtraccionAlta() {
        // Creamos una atracción dañada con nivel de riesgo ALTO
        adminAtr.crearAtraccionMecanica("Torre del Terror", "VERANO", "Zona B", "MEDIO", 2, 1, 2);
        AtraccionMecanica torre = adminAtr.getMecanicas().get(1);
        torre.setDañado(true);
        assertTrue(torre.getDañado());

        // Creamos empleado de servicio general con capacitación adecuada
        ServicioGeneral tecnico = new ServicioGeneral(10, "servicio1", "clave", 0);
        tecnico.añadirCapacitacion("MANTENIMIENTO_ALTO");

        // Reparación
        tecnico.reparar(torre);

        // Validación
        assertFalse(torre.getDañado(), "La atracción debería estar reparada");
    }

}
