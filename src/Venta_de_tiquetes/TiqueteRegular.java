package Venta_de_tiquetes;

public class TiqueteRegular extends Tiquete {

	private boolean usado; 
	
	
	
	public TiqueteRegular() 
	{
		super(CategoriaExclusividad.BASICO);
		this.usado = false; 
	}
	
	public TiqueteRegular(CategoriaExclusividad categoria) 
	{
		super(categoria);
		this.usado = false; 
	}
	
	
	@Override
	public boolean esValidoPara(String idAtraccion) {
	    return !usado; // Mientras no este usado
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

