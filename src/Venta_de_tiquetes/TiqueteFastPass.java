package Venta_de_tiquetes;

import java.time.LocalDate;

public class TiqueteFastPass extends Tiquete {

	
	private LocalDate fechaInicio;
    private LocalDate fechaFin;

	
    public TiqueteFastPass(LocalDate fInicio, LocalDate fFin) {
		super(CategoriaExclusividad.BASICO);
		this.fechaInicio = fInicio; 
		this.fechaFin = fFin; 
		
	}

}
