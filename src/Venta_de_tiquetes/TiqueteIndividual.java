package Venta_de_tiquetes;

public class TiqueteIndividual extends Tiquete {

	private String atraccionAsosiada;
	private boolean usado;
	
	
	public TiqueteIndividual(String atraccionAsosiada) {
		super(CategoriaExclusividad.BASICO);
		this.atraccionAsosiada = atraccionAsosiada; 
		this.usado = false;
	}
	
	@Override
	public boolean esValidoPara(String idAtraccion) {
	    return this.atraccionAsosiada.equals(idAtraccion);
	}

	@Override
	public void marcarUsado() {
	    this.usado = true;
	}

	@Override
	public boolean estaUsado() {
	    return usado;
	}

}
