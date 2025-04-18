package Venta_de_tiquetes;

public class TiqueteIndividual extends Tiquete {

	private String atraccionAsosiada;
	
	public TiqueteIndividual(String atraccionAsosiada) {
		super(CategoriaExclusividad.BASICO);
		this.atraccionAsosiada = atraccionAsosiada; 
	}

}
