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
        montanaRusa.añadirCajero(cajero);
        montanaRusa.setDisponible();

        clienteValido = new Cliente("cliente", "cliente", "clave", 500, 15);
        clienteInvalido = new Cliente("cliente", "cliente", "clave", 300, 10);
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
    public void testRepararAtraccionMediaAlta() {

    	adminAtr.crearAtraccionMecanica("Torre del Terror", "VERANO", "Zona B", "MEDIO", 2, 1, 2);
        AtraccionMecanica torre = adminAtr.getMecanicas().get(1);
        torre.setDañado(true);
        assertTrue(torre.getDañado());
        ServicioGeneral tecnico = new ServicioGeneral(10, "servicio1", "clave", 0);
        tecnico.añadirCapacitacion("MANTENIMIENTO_ALTA");

        tecnico.reparar(torre);


        assertTrue(torre.getDañado(), "La atracción debería estar reparada");
    }
    
    @Test
    public void testRepararAtraccionAlta() {

    	adminAtr.crearAtraccionMecanica("Torre del Terror", "VERANO", "Zona B", "MEDIO", 2, 1, 2);
        AtraccionMecanica torre = adminAtr.getMecanicas().get(1);
        torre.setDañado(true);
        assertTrue(torre.getDañado());
        ServicioGeneral tecnico = new ServicioGeneral(10, "servicio1", "clave", 0);
        tecnico.añadirCapacitacion("MANTENIMIENTO_MEDIO");

        tecnico.reparar(torre);


        assertFalse(torre.getDañado(), "La atracción debería estar reparada");
    }

}
