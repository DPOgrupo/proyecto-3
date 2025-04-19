package Prueba;

import Empleados.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import Empleados.Cajero;


public class EmpleadoTest {
	
	@Test
    public void testAñadirCapacitacion() {
        Empleado empleado1 = new Cajero("usuario", "1234", 0);
        empleado1.añadirCapacitacion("COCINA");
        assertFalse(!empleado1.estaCapacitado("COCINA"));
    }
    
	@Test
	public void noDebeAñadirCapacitacionDuplicada() {
		
	    Empleado empleado1 = new Cajero("usuario", "1234", 0);
	    empleado1.añadirCapacitacion("COCINA");
	    empleado1.añadirCapacitacion("COCINA");
	    assertEquals(1, empleado1.getCapacitaciones().size());
	}
	
	
    @Test
    public void testVerificarContraseñaCorrecta() {
        Empleado empleado1 = new Cajero("usuario", "1234", 0);
        assertTrue(empleado1.verificarContraseña("1234"));
        
    }
    

    @Test
    public void testCrearTurnoYReemplazoSiEsIgual() {
        Empleado empleado1 = new Cajero("usuario", "1234", 0);
        LocalDate fecha = LocalDate.of(2025, 4, 20);

        //dos turnos con igual fecha y turno diurno
        Turno turno1 = new Turno(fecha, false);
        Turno turno2 = new Turno(fecha, false); 

        empleado1.añadirTurno(turno1);
        assertEquals(1, empleado1.getTurnoAsignado(fecha).size());

        empleado1.añadirTurno(turno2);
        List<Turno> turnos = empleado1.getTurnoAsignado(fecha);
        assertEquals(1, turnos.size());
        assertEquals(turno2, turnos.get(0));
    }
    
    
    @Test
    public void testDevolverTurnosCorrectamente() {
        Empleado empleado1 = new Cajero("user1", "pass", 0);
        
        LocalDate fecha1 = LocalDate.of(2025, 4, 20);
        LocalDate fecha2 = LocalDate.of(2025, 4, 21);

        Turno turno1 = new Turno(fecha1, false);
        Turno turno2 = new Turno(fecha1, true);
        Turno turno3 = new Turno(fecha2, false);

        empleado1.añadirTurno(turno1);
        empleado1.añadirTurno(turno2);
        empleado1.añadirTurno(turno3);

        assertEquals(2, empleado1.getTurnoAsignado(fecha1).size());
        assertEquals(1, empleado1.getTurnoAsignado(fecha2).size());
    }
}
