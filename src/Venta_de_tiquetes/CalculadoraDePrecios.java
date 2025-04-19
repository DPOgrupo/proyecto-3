package Venta_de_tiquetes;

import java.util.HashMap;
import java.util.Map;

public class CalculadoraDePrecios {

	
	   private double precioBaseRegular;
	   private double precioBaseIndividual;
	   private double precioBaseFastPass;
	   
	   private double descuentoParaEmpleados; 
	   private double hernando;

	   private Map<CategoriaExclusividad, Double> multiplicadorExclusividad;
	   private Map<UnidadTiempo, Double> descuentoPorDuracion;
	
	   public CalculadoraDePrecios() {
	        precioBaseRegular = 50000;
	        precioBaseIndividual = 15000;
	        precioBaseFastPass = 20000;
	        
	        descuentoParaEmpleados = 0.50; 

	        multiplicadorExclusividad = new HashMap<>();
	        multiplicadorExclusividad.put(CategoriaExclusividad.BASICO, 0.2);
	        multiplicadorExclusividad.put(CategoriaExclusividad.FAMILIAR, 1.0);
	        multiplicadorExclusividad.put(CategoriaExclusividad.ORO, 1.5);
	        multiplicadorExclusividad.put(CategoriaExclusividad.DIAMANTE, 2.0);

	        descuentoPorDuracion = new HashMap<>();
	        descuentoPorDuracion.put(UnidadTiempo.DIA, 1.0);
	        descuentoPorDuracion.put(UnidadTiempo.SEMANA, 0.75);
	        descuentoPorDuracion.put(UnidadTiempo.MES, 0.5);
	        descuentoPorDuracion.put(UnidadTiempo.ESTACION, 0.4);
	        descuentoPorDuracion.put(UnidadTiempo.ANO, 0.3);
	    }
	   
	   public int calcularPrecioRegular(CategoriaExclusividad categoria, boolean empleado) {
		   Double p = precioBaseRegular * multiplicadorExclusividad.get(categoria);
		   
		   if (empleado){
			   p = p * this.descuentoParaEmpleados; 
		   }
		   return (int) Math.round(p); 
	       
	        
	    }
	   
	   public int calcularPrecioIndividual(boolean empleado) {
	        Double p =  precioBaseIndividual;
	        
	        if (empleado){
				   p = p * this.descuentoParaEmpleados; 
			   }
			   return (int) Math.round(p); 
	    }
	   
	   public int calcularPrecioTemporada(CategoriaExclusividad categoria, UnidadTiempo unidad, int cantidad, boolean empleado) {
	        if (cantidad <= 0) {
	            throw new IllegalArgumentException("La cantidad de unidades debe ser mayor a cero.");
	        }
	        double precioBaseTotal = calcularPrecioRegular(categoria, empleado) * (estimarCantidadDias(unidad) * cantidad);
	        
	        
	        double precioConDescuento =  precioBaseTotal * descuentoPorDuracion.get(unidad);
	        
	        if (empleado) {
	        	
	        	precioConDescuento = precioConDescuento * this.descuentoParaEmpleados;
	        }
	        
	        return (int) Math.round(precioConDescuento); 
	    }
	   
	   
	   public int calcularPrecioFastPass(UnidadTiempo unidad, int cantidad, boolean empleado) {
	        
		   	if (cantidad <= 0) {
	            throw new IllegalArgumentException("La cantidad de unidades debe ser mayor a cero.");
	        }
	        double base = precioBaseFastPass * (estimarCantidadDias(unidad) * cantidad);
	        
	        
	        base = base * descuentoPorDuracion.get(unidad);
	        
	        if (empleado) {
	        	
	        	base = base * this.descuentoParaEmpleados;
	        }
	        
	        return (int) Math.round(base);
	        
	    }
	   
	   private int estimarCantidadDias(UnidadTiempo duracion) {
	        return switch (duracion) {
	            case DIA -> 1;
	            case SEMANA -> 7;
	            case MES -> 30;
	            case ESTACION -> 90;
	            case ANO -> 365;
	        };
	        
	    }

}
