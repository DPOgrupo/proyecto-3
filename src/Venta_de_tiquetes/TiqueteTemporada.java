package Venta_de_tiquetes;

import java.time.LocalDate;

public class TiqueteTemporada extends Tiquete {
	
	
	private LocalDate fechaInicio;
    private LocalDate fechaFin;

	public TiqueteTemporada(CategoriaExclusividad categoria, LocalDate fInicio, LocalDate fFin) {
		super(categoria);
		this.fechaInicio = fInicio; 
		this.fechaFin = fFin; 
		
	}

}
