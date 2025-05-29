
package Empleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import AtraccionesYServicio.AdministradorAtraccionesYLugares;
import AtraccionesYServicio.Atraccion;

public class AdministradorEmpleados {
	
	private String login;
	private String contraseña;
	private int contadorDeID;
	private List<Cajero> cajeros;
	private List<Cocinero> cocineros;
	private List<ServicioGeneral> servicios;
	private boolean turnoGlobalNocturno;


	public AdministradorEmpleados(String login, String contraseña) {
	    this.login = login;
	    this.contraseña = contraseña;
	    this.cajeros = new ArrayList<>();
	    this.cocineros = new ArrayList<>();
	    this.servicios = new ArrayList<>();
	    this.turnoGlobalNocturno = false;
	    
	    contadorDeID = 0;
	}

    
    public String getContraseña() {
        return contraseña;
    }
    
    public String getLogin() {
        return login;
    }
    
    

    public boolean isTurnoGlobalNocturno() {
		return turnoGlobalNocturno;
	}


	public void setTurnoGlobalNocturno(boolean turnoGlobalNocturno) {
		this.turnoGlobalNocturno = turnoGlobalNocturno;
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

    public Turno crearTurno(LocalDate fecha, boolean turnoNocturno, Cafeteria cafeteria) {
        Turno turno = new Turno(fecha, turnoNocturno);
        turno.setLugar(cafeteria);
        return turno;
    }

    public Turno crearTurno(LocalDate fecha, boolean turnoNocturno, Tienda tienda) {
        Turno turno = new Turno(fecha, turnoNocturno);
        turno.setLugar(tienda);
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

    
    public void setCajeros(List<Cajero> cajeros) {
		this.cajeros = cajeros;
	}


	public void setCocineros(List<Cocinero> cocineros) {
		this.cocineros = cocineros;
	}


	public List<Cajero> getCajeros() {
		return cajeros;
	}


	public void setServicios(List<ServicioGeneral> servicios) {
		this.servicios = servicios;
	}


	public List<Cocinero> getCocineros() {
		return cocineros;
	}


	public List<ServicioGeneral> getServicios() {
		return servicios;
	}


	public void cambioDeTurno(Empleado empleado, boolean turnoNocturno) {
		System.out.println(empleado);
	    LocalDate hoy = LocalDate.now();
	    Turno turnoAnterior = null;
	    Turno turnoActual = null;

	    List<Turno> turnosHoy = empleado.getTurnoAsignado(hoy);

	    for (Turno t : turnosHoy) {
	        if (t.isTurnoNocturno() == turnoNocturno) {
	            turnoActual = t;
	        } else {
	            turnoAnterior = t;
	        }
	    }
	    if (!turnoNocturno && turnoAnterior == null) {
	        for (Turno t : empleado.getTurnosAsignados()) {
	            if (t.isTurnoNocturno() && t.getFecha().isBefore(hoy)) {
	                if (turnoAnterior == null || t.getFecha().isAfter(turnoAnterior.getFecha())) {
	                    turnoAnterior = t;
	                }
	            }
	        }
	    }
	    // Quitar del lugar anterior
	    if (turnoAnterior != null) {
	        Object lugarAnterior = turnoAnterior.getLugar();
	        String tipo = turnoAnterior.getQueSoy();
	        //ver si es lugar de servicio o atraccion 
		        if ("Tienda".equals(tipo) || "Cafeteria".equals(tipo)) {
	            LugarDeServicio lugar = (LugarDeServicio) lugarAnterior;

	            if (empleado instanceof Cajero cajero) {
	                lugar.quitarCajero(cajero);
	            } else if (empleado instanceof Cocinero cocinero) {
	                lugar.quitarCocinero(cocinero);
	            } else if (empleado instanceof ServicioGeneral servicio) {
	                lugar.quitarServicio(servicio);
	            }

	        } else if ("Atraccion".equals(tipo)) {
	            Atraccion atraccion = (Atraccion) lugarAnterior;

	            if (empleado instanceof Cajero cajero) {
	                atraccion.quitarCajero(cajero);
	            } else if (empleado instanceof Cocinero cocinero) {
	                atraccion.quitarCocinero(cocinero);
	            } else if (empleado instanceof ServicioGeneral servicio) {
	                atraccion.quitarServicio(servicio);
	            }
	        }
	        empleado.getTurnosAsignados().remove(turnoAnterior);

	    } else {
	        System.out.println("No se encontró un turno anterior para hacer el cambio.");
	    }

	    // Añadir al nuevo lugar
	    if (turnoActual != null) {
	        Object lugarActual = turnoActual.getLugar();
	        String tipo = turnoActual.getQueSoy();
	        System.out.println(turnoActual.getLugar());
	        //ver si es lugar de servicio o atraccion 
	        if ("Tienda".equals(tipo) || "Cafeteria".equals(tipo)) {
	            LugarDeServicio lugar = (LugarDeServicio) lugarActual;

	            if (empleado instanceof Cajero cajero) {
	                lugar.añadirCajero(cajero);
	            } else if (empleado instanceof Cocinero cocinero) {
	                lugar.añadirCocinero(cocinero);
	            } else if (empleado instanceof ServicioGeneral servicio) {
	                lugar.añadirServicio(servicio);
	            }

	        } else if ("Atraccion".equals(tipo)) {
	            Atraccion atraccion = (Atraccion) lugarActual;

	            if (empleado instanceof Cajero cajero) {
	                atraccion.añadirCajero(cajero);
	                
	                System.out.println(atraccion.getCajerosAsociados()+"rah");
	            } else if (empleado instanceof Cocinero cocinero) {
	                atraccion.añadirCocinero(cocinero);
	                System.out.println(atraccion.getCocinerosAsociados()+"rahh");
	            } else if (empleado instanceof ServicioGeneral servicio) {
	                atraccion.añadirServicio(servicio);
	                System.out.println(atraccion.getServiciosAsociados()+"rahhh");
	            }
	        }

	    } else {
	        System.out.println("No se encontró un turno actual para realizar el cambio.");
	    }

	    System.out.println("Turno reasignado correctamente.");
	}




    public void cambiarTurnoGlobal(boolean turnoNocturno) {
    	
    	setTurnoGlobalNocturno(turnoNocturno);
    	
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
    
    // recuperar lugares por el transient en turno (lugar)
    public void reconectarTurnosConLugares(AdministradorAtraccionesYLugares adminAtr) {
        for (Cajero cajero : cajeros) {
        	restaurarTurnos(cajero, adminAtr);
        }
        for (Cocinero cocinero : cocineros) {
        	restaurarTurnos(cocinero, adminAtr);
        }
        for (ServicioGeneral servicio : servicios) {
        	restaurarTurnos(servicio, adminAtr);
        }
    }

    private void restaurarTurnos(Empleado empleado, AdministradorAtraccionesYLugares adminAtr) {
        for (Turno turno : empleado.getTurnosAsignados()) {
            String tipo = turno.getQueSoy();
            String id = turno.getIdLugar();

            if (tipo == null || id == null) continue;

            switch (tipo) {
                case "Tienda" -> {
                    for (Tienda cadaTienda : adminAtr.getTiendas()) {
                        if (("Tienda_" + cadaTienda.getNumeroJuguetes()).equals(id)) {
                            turno.setLugar(cadaTienda);
                            break;
                        }
                    }
                }
                case "Cafeteria" -> {
                    for (Cafeteria cadaCafeteria : adminAtr.getCafeterias()) {
                        if (("Cafeteria_" + cadaCafeteria.getNumeroComidas()).equals(id)) {
                            turno.setLugar(cadaCafeteria);
                            break;
                        }
                    }
                }
                case "Atraccion" -> {
                    for (Atraccion cadaAtraccion : adminAtr.getMecanicas()) {
                        if (cadaAtraccion.getIdAtraccion().equals(id)) {
                            turno.setLugar(cadaAtraccion);
                            break;
                        }
                    }
                    for (Atraccion cadaAtraccion : adminAtr.getCulturales()) {
                        if (cadaAtraccion.getIdAtraccion().equals(id)) {
                            turno.setLugar(cadaAtraccion);
                            break;
                        }
                    }
                }
            }
        }
    }


    	

}
