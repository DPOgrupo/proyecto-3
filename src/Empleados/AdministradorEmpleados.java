
package Empleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import AtraccionesYServicio.Atraccion;

public class AdministradorEmpleados {
	
	private String login;
	private String contraseña;
	private int contadorDeID;
    private List<Empleado> empleados;

    public AdministradorEmpleados(String login, String contraseña) {
        this.login = login;
        this.contraseña = contraseña;
        empleados = new ArrayList<>();
        contadorDeID = 0;
    }

    
    public String getContraseña() {
        return contraseña;
    }
    
    public String getLogin() {
        return login;
    }

    public boolean verificarContraseña(String clave) {
    	
        return contraseña.equals(clave);
        
    }

    public void crearCocinero(String login, String contraseña) {
    	
    	contadorDeID += 1;
        Cocinero cocinero = new Cocinero(contadorDeID,login, contraseña, 0);
        empleados.add(cocinero);
    }

    public void crearCajero(String login, String contraseña) {
    	
    	contadorDeID += 1;
        Cajero cajero = new Cajero(contadorDeID,login, contraseña, 0);
        empleados.add(cajero);
    }

    public void crearServicioGeneral(String login, String contraseña) {
    	
    	contadorDeID += 1;
        ServicioGeneral servicio = new ServicioGeneral(contadorDeID,login, contraseña, 0);
        empleados.add(servicio);
    }
    

    public void añadirCapacitacion(Empleado empleado, String nuevaCapacitacion) {
        empleado.añadirCapacitacion(nuevaCapacitacion);
    }

    public Turno crearTurnos(boolean turnoNocturno, LugarDeServicio lugar) {
        Turno turno = new Turno(LocalDate.now(), turnoNocturno);
        turno.setLugar(lugar);
        return turno;
    }
    
    public Turno crearTurno(boolean turnoNocturno, Atraccion lugar) {
        Turno turno = new Turno(LocalDate.now(), turnoNocturno);
        turno.setLugar(lugar);
        return turno;
    }


    public void cambiarTurno(Empleado empleado, Turno turno) {
        empleado.añadirTurno(turno);
    }


    public void cambiarCocineroACajero(Empleado empleado, Cafeteria cafeteria) {
        if (empleado instanceof Cocinero) {
            if (cafeteria.getCocinerosAsociados().contains(empleado)) {
                cafeteria.quitarCocinero(empleado); // Lo saca como cocinero
                cafeteria.añadirEmpleado(empleado); // Lo agrega como cajero usando método heredado
                
                System.out.println("Empleado cambiado de Cocinero a Cajero en la Cafetería.");
            } else {
                System.out.println("El empleado no está asociado como cocinero en esta cafetería.");
            }
        } else {
            System.out.println("El empleado no es un Cocinero.");
        }
    }
    public void mostrarTurnoDeEmpleado(Empleado empleado) {
        for (Turno turno : empleado.getTurnoAsignado(LocalDate.now())) //Turnos de hoy
        
        {
        	String tipoTurno;
        	if (turno.isTurnoNocturno()) {
        	    tipoTurno = "Nocturno";
        	} else {
        	    tipoTurno = "Diurno";
        	}
            
            System.out.println("Fecha: " + turno.getFecha() + ", Turno: " + tipoTurno + ", Lugar: " + turno.getLugar());
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
