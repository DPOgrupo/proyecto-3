package Venta_de_tiquetes;

import java.util.UUID;

public abstract class Tiquete {

    private CategoriaExclusividad categoria; 
    protected String id; 

    public Tiquete() {
        this.id = generarIdUnico();
    }

    public Tiquete(CategoriaExclusividad categoria) {
        this.categoria = categoria; 
        this.id = generarIdUnico();
    }

    public CategoriaExclusividad getCategoria() {
        return categoria;
    }

    public String getId() {
        return id;
    }

    private String generarIdUnico() {
        return UUID.randomUUID().toString(); 
    }

    public abstract boolean esValidoPara(String idAtraccion);
    public abstract void marcarUsado();
    public abstract boolean estaUsado();
    public abstract String generarContenidoQR();  
}
