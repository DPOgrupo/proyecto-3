package Empleados;

import java.time.LocalDate;

import AtraccionesYServicio.Atraccion;

public class Turno {
    private boolean turnoNocturno;
    private LocalDate fecha;
    private Object lugar;  // Puede ser Atraccion o LugarDeServicio o None (osea mantenimiento o limpieza)

    public Turno(LocalDate fecha, boolean turnoNocturno) {
        this.fecha = fecha;
        this.turnoNocturno = turnoNocturno;
    }

    public void setLugar(LugarDeServicio lugar) {
    	
        this.lugar = lugar;
    }
    
    public void setLugar(Atraccion lugar) {
    	
        this.lugar = lugar;
    }


    public Object getLugar() {
    	
        return lugar;
    }

    public LocalDate getFecha() {
    	
        return fecha;
    }

    public boolean isTurnoNocturno() {
    	
        return turnoNocturno;
    }
}