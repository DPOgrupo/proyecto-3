package AtraccionesYServicio;

import java.time.LocalDate;

public class Espectaculo extends AtraccionOEspectaculo {

    private String ubicacionNoFija;
    private String horarios; // 
    private LocalDate fechaEspecifica;

    public Espectaculo(String nombre, String temporada, String ubicacionNoFija, String horarios, LocalDate fechaEspecifica) {
        this.idAtraccion = nombre;
        this.temporada = temporada;
        this.ubicacionNoFija = ubicacionNoFija;
        this.horarios = horarios;
        this.fechaEspecifica = fechaEspecifica;
        this.disponible = false;
        setDisponible(); // se calcula en base a la fecha
    }

    public void setDisponible() {
        LocalDate hoy = LocalDate.now();

        if (hoy.isEqual(fechaEspecifica)) {
            this.disponible = true;
        } else {
            this.disponible = false;
        }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getUbicacionNoFija() {
        return ubicacionNoFija;
    }

    public String getHorarios() {
        return horarios;
    }

    public LocalDate getFechaEspecifica() {
        return fechaEspecifica;
    }

    public String getIdAtraccion() {
        return idAtraccion;
    }

    public String getTemporada() {
        return temporada;
    }
}
