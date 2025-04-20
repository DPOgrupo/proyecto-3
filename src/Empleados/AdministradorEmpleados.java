
package Empleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import AtraccionesYServicio.Atraccion;

public class AdministradorEmpleados {
	
	private String login;
	private String contraseña;
	private int contadorDeID;
	private List<Cajero> cajeros;
	private List<Cocinero> cocineros;
	private List<ServicioGeneral> servicios;


	public AdministradorEmpleados(String login, String contraseña) {
	    this.login = login;
	    this.contraseña = contraseña;
	    this.cajeros = new ArrayList<>();
	    this.cocineros = new ArrayList<>();
	    this.servicios = new ArrayList<>();
	    
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
        contadorDeID++;
        Cocinero cocinero = new Cocinero(contadorDeID, login, contraseña, 0);
        cocineros.add(cocinero);
    }

    public void crearCajero(String login, String contraseña) {
        contadorDeID++;
        Cajero cajero = new Cajero(contadorDeID, login, contraseña, 0);
        cajeros.add(cajero);
    }

    public void crearServicioGeneral(String login, String contraseña) {
        contadorDeID++;
        ServicioGeneral servicio = new ServicioGeneral(contadorDeID, login, contraseña, 0);
        servicios.add(servicio);
    }

    

    public void añadirCapacitacion(Empleado empleado, String nuevaCapacitacion) {
        empleado.añadirCapacitacion(nuevaCapacitacion);
    }

    public Turno crearTurno(LocalDate fecha, boolean turnoNocturno, LugarDeServicio lugar) {//fecha cualquiera
        Turno turno = new Turno(fecha, turnoNocturno);
        turno.setLugar(lugar);
        return turno;
    }

    public Turno crearTurno(LocalDate fecha, boolean turnoNocturno, Atraccion lugar) {
        Turno turno = new Turno(fecha, turnoNocturno);
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

    
    public List<Cajero> getCajeros() {
		return cajeros;
	}


	public List<Cocinero> getCocineros() {
		return cocineros;
	}


	public List<ServicioGeneral> getServicios() {
		return servicios;
	}


	public void cambioDeTurno(Empleado empleado, boolean turnoNocturno) {
        LocalDate hoy = LocalDate.now();
        Turno turnoAnterior = null;
        Turno turnoAhora = null;
        List<Turno> turnosHoy = empleado.getTurnoAsignado(hoy);

        if (turnoNocturno) {
            // Si es nocturno, buscamos el diurno de hoy (anterior)
            for (Turno t : turnosHoy) {
                if (!t.isTurnoNocturno()) {
                    turnoAnterior = t;
                }
                if (t.isTurnoNocturno()) {
                    turnoAhora = t;
                }
            }
        } else {
            // Si es diurno, buscamos el diurno de hoy (actual)
            for (Turno t : turnosHoy) {
                if (!t.isTurnoNocturno()) {
                    turnoAhora = t;
                }
            }

            // Y buscamos el turno nocturno más reciente anterior a hoy (anterior)
            for (Turno t : empleado.getTurnosAsignados()) {
                if (t.getFecha().isBefore(hoy) && t.isTurnoNocturno()) {
                    if (turnoAnterior == null || t.getFecha().isAfter(turnoAnterior.getFecha())) {
                        turnoAnterior = t;
                    }
                }
            }
        }

        // 1. Quitar del lugar anterior
        if (turnoAnterior != null) {
            Object lugarAnterior = turnoAnterior.getLugar();

            if (turnoAnterior.getQueSoy().equals("LugarDeServicio")) {
                LugarDeServicio lugar = (LugarDeServicio) lugarAnterior;
                if (lugar instanceof Cafeteria && empleado instanceof Cocinero) {
                    ((Cafeteria) lugar).quitarCocinero(empleado);
                } else {
                    lugar.quitarEmpleado(empleado);
                }

            } else if (turnoAnterior.getQueSoy().equals("Atraccion")) {
                ((Atraccion) lugarAnterior).quitarEmpleado(empleado);
            }

            empleado.getTurnosAsignados().remove(turnoAnterior);
        } else {
            System.out.println("No se encontró un turno anterior para hacer el cambio.");
        }

        // 2. Añadir al nuevo lugar
        if (turnoAhora != null) {
            Object lugarAhora = turnoAhora.getLugar();

            if (turnoAhora.getQueSoy().equals("LugarDeServicio")) {
                LugarDeServicio lugar = (LugarDeServicio) lugarAhora;
                if (lugar instanceof Cafeteria && empleado instanceof Cocinero) {
                    ((Cafeteria) lugar).añadirCocinero(empleado);
                } else {
                    lugar.añadirEmpleado(empleado);
                }

            } else if (turnoAhora.getQueSoy().equals("Atraccion")) {
                ((Atraccion) lugarAhora).añadirEmpleado(empleado);
            }

        } else {
            System.out.println("No se encontró un turno actual para realizar el cambio.");
        }
    }

    public void cambiarTurnoGlobal(boolean turnoNocturno) {
        for (Cajero cajero : cajeros) {
        	
            cambioDeTurno(cajero, turnoNocturno);
        }
        for (Cocinero cocinero : cocineros) {
        	
            cambioDeTurno(cocinero, turnoNocturno);
        }
        for (ServicioGeneral servicio : servicios) {
        	
            cambioDeTurno(servicio, turnoNocturno);
        }
    }

    	

}
