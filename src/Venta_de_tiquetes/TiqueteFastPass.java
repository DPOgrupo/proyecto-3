package Venta_de_tiquetes;

import java.time.LocalDate;

public class TiqueteFastPass extends Tiquete {

	
	private LocalDate fechaInicio;
    private LocalDate fechaFin;

	
    
    public TiqueteFastPass() {
		super(CategoriaExclusividad.BASICO);
		this.fechaInicio = LocalDate.now();
		this.fechaFin = LocalDate.now();
	}

	public TiqueteFastPass(LocalDate fInicio, LocalDate fFin) {
		super(CategoriaExclusividad.BASICO);
		this.fechaInicio = fInicio; 
		this.fechaFin = fFin; 
		
	}
    
	@Override
	public boolean esValidoPara(String idAtraccion) {
		
	    return !LocalDate.now().isBefore(fechaInicio) && !LocalDate.now().isAfter(fechaFin);
	}

	@Override
	public void marcarUsado() {
		
	}

	@Override
	public boolean estaUsado() {
		return false;
	}

}
