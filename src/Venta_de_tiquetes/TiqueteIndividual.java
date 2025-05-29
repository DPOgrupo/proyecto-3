package Venta_de_tiquetes;

import java.time.LocalDate;

public class TiqueteIndividual extends Tiquete {

	private String atraccionAsosiada;
	private boolean usado;
	
    public TiqueteIndividual() {
		super(CategoriaExclusividad.BASICO);
		this.atraccionAsosiada = ""; 
		this.usado = false;
	}
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
	@Override
	public String generarContenidoQR() {
	    return "ID:" + getId() + "|Tipo:Regular|Fecha:No hay fecha";
	}

}
