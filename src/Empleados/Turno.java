package Empleados;

import java.time.LocalDate;

import AtraccionesYServicio.Atraccion;

public class Turno {
    private boolean turnoNocturno;
    private LocalDate fecha;
    private transient Object lugar;  //para que no haga un loop en la persistencia
    private String queSoy;
    private String idLugar;

    public Turno(LocalDate fecha, boolean turnoNocturno) {
        this.fecha = fecha;
        this.turnoNocturno = turnoNocturno;
        this.idLugar = "";
    }

    public Turno() {
        this.fecha = LocalDate.now();
        this.turnoNocturno = false;
        this.idLugar = "";
    }

    public void setLugar(Cafeteria lugar) {
        this.lugar = lugar;
        this.queSoy = "Cafeteria";
        this.idLugar = "Cafeteria_" + lugar.getNumeroComidas();
    }

    public void setLugar(Tienda lugar) {
        this.lugar = lugar;
        this.queSoy = "Tienda";
        this.idLugar = "Tienda_" + lugar.getNumeroJuguetes();
    }

    public void setLugar(Atraccion lugar) {
        this.lugar = lugar;
        this.queSoy = "Atraccion";
        this.idLugar = lugar.getIdAtraccion();

    }

    public String getQueSoy() {
        return queSoy;
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
    
    // recuperar lugar
    
    public String getIdLugar() {
        return idLugar;
    }
    

}
