package Venta_de_tiquetes;

public class TiqueteRegular extends Tiquete {

	private boolean usado; 
	private boolean entro; 
	
	
	
	
	public TiqueteRegular() 
	{
		super(CategoriaExclusividad.BASICO);
		this.usado = false;
		this.entro = false; 
	}
	
	public TiqueteRegular(CategoriaExclusividad categoria) 
	{
		super(categoria);
		this.usado = false;
		this.entro = false; 

	}
	
	
	@Override
	public boolean esValidoPara(String idAtraccion) {
	    return !usado; // Mientras no este usado
	}

	
	public void salioDelparque() {
		this.entro = true; 
	}
	
	public boolean Isadentro(){
		return entro;
	}
	
	
	@Override
	public void marcarUsado() {
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

