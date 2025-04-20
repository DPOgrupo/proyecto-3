package PruebasEmpleados;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import Empleados.*;
import AtraccionesYServicio.*;

public class CambioDeTurnoTest {

	@Test
	public void testSoloTurnoDiurnoHoy() {
	    AdministradorEmpleados admin = new AdministradorEmpleados("admin", "pass");
	    Cajero cajero = new Cajero(2, "lucas", "abcd", 0);
	    Tienda tienda = new Tienda();

	    Turno turnoDiurno = new Turno(LocalDate.now(), false);
	    turnoDiurno.setLugar(tienda);
	    cajero.añadirTurno(turnoDiurno);

	    admin.cambioDeTurno(cajero, false); // aplicar turno diurno

	    assertTrue(tienda.getCajeros().contains(cajero));
	}

	
	@Test
	public void testSoloTurnoNocturnoHoy() {
	    AdministradorEmpleados admin = new AdministradorEmpleados("admin", "pass");
	    Cajero cajero = new Cajero(3, "ana", "5678", 0);
	    Tienda tienda = new Tienda();

	    Turno turnoNocturno = new Turno(LocalDate.now(), true);
	    turnoNocturno.setLugar(tienda);
	    cajero.añadirTurno(turnoNocturno);

	    admin.cambioDeTurno(cajero, true); // aplicar turno nocturno

	    assertTrue(tienda.getCajeros().contains(cajero));
	}

	
	@Test
	public void testTurnoNocturnoAnteriorYDiurnoHoy() {
	    AdministradorEmpleados admin = new AdministradorEmpleados("admin", "pass");
	    Cajero cajero = new Cajero(4, "mario", "pppp", 0);
	    Tienda tiendaVieja = new Tienda();
	    Tienda tiendaNueva = new Tienda();

	    LocalDate ayer = LocalDate.now().minusDays(1);
	    Turno turnoNocturnoAyer = new Turno(ayer, true);
	    turnoNocturnoAyer.setLugar(tiendaVieja);
	    cajero.añadirTurno(turnoNocturnoAyer);
	    tiendaVieja.añadirEmpleado(cajero);

	    Turno turnoDiurnoHoy = new Turno(LocalDate.now(), false);
	    turnoDiurnoHoy.setLugar(tiendaNueva);
	    cajero.añadirTurno(turnoDiurnoHoy);

	    admin.cambioDeTurno(cajero, false); // pasa a turno diurno

	    assertFalse(tiendaVieja.getCajeros().contains(cajero));
	    assertTrue(tiendaNueva.getCajeros().contains(cajero));
	}

	
	@Test
	public void testCocineroAsignadoCorrectamenteACafeteria() {
	    AdministradorEmpleados admin = new AdministradorEmpleados("admin", "adminpass");
	    Cafeteria cafeteria = new Cafeteria();
	    Cocinero cocinero = new Cocinero(5, "leo", "cook", 0);

	    Turno turnoDiurno = new Turno(LocalDate.now(), false);
	    turnoDiurno.setLugar(cafeteria);
	    cocinero.añadirTurno(turnoDiurno);

	    admin.cambioDeTurno(cocinero, false); // aplicar turno diurno

	    assertTrue(cafeteria.getCocinerosAsociados().contains(cocinero));
	    assertFalse(cafeteria.getCajeros().contains(cocinero));
	}


	
    @Test
    public void testCambioDeTurnoConTurnosDeHoy() {
        // Crear administrador
        AdministradorEmpleados admin = new AdministradorEmpleados("admin", "admin123");

        // Crear lugares
        Tienda tienda = new Tienda();
        Cafeteria cafeteria = new Cafeteria();

        // Crear empleado
        Cajero cajero = new Cajero(1, "usuario1", "1234", 0);

        // Crear turnos para hoy
        LocalDate hoy = LocalDate.now();
        Turno turnoDiurno = new Turno(hoy, false);  // diurno
        Turno turnoNocturno = new Turno(hoy, true); // nocturno
        
        turnoDiurno.setLugar(tienda);
        turnoNocturno.setLugar(cafeteria);
        // Asignar ambos turnos al empleado
        cajero.añadirTurno(turnoDiurno);
        cajero.añadirTurno(turnoNocturno);

        // Simular PRIMER cambio de turno (entra turno diurno, no hay turno anterior)
        admin.cambioDeTurno(cajero, false);  // es turno diurno

        // Verificar que está en la tienda (diurno)
        assertTrue(tienda.getCajeros().contains(cajero));
        assertFalse(cafeteria.getCajeros().contains(cajero));

        // Cambio de turno a nocturno
        admin.cambioDeTurno(cajero, true); // es turno nocturno

        // Verificar que fue removido de tienda y añadido a cafetería
        assertFalse(tienda.getCajeros().contains(cajero));
        assertTrue(cafeteria.getCajeros().contains(cajero));
    }
}

