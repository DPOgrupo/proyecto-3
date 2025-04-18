package Venta_de_tiquetes;

import java.time.LocalDate;

public class Taquilla {

	private CalculadoraDePrecios calc = new CalculadoraDePrecios(); 
	
	public void venderTiqueteRegular(Cliente cliente, CategoriaExclusividad categoria, boolean empleado) 
			 throws FondosInsuficientesException{
		
		// Calcular Precio del Tiquete 
		int precio = calc.calcularPrecioRegular(categoria, empleado);
		
		// Crear Tiquete 
		Tiquete tic = new TiqueteRegular(categoria); 
		
		// Cobrar al cliente &  Asociar  Tiquete al Cliente.
		procesarVenta(cliente, precio, tic);
		
		}
	
	public void venderTiqueteIndividual(Cliente cliente, String idAtraccion, boolean empleado) 
			 throws FondosInsuficientesException{
		
		// Calcular precio del Tiquete
		int precio = calc.calcularPrecioIndividual(empleado);
		
		// Crear el Tiquete. 
		Tiquete tic = new TiqueteIndividual(idAtraccion);
		
		// Cobrar al cliente &  Asociar  Tiquete al Cliente.
		procesarVenta(cliente, precio, tic);
		
		}
	
	public void venderTiqueteTemporada(Cliente cliente, CategoriaExclusividad categoria, UnidadTiempo unidad, int cantidad, boolean empleado ) 
			throws FondosInsuficientesException{
		
		// Calcular precio del Tiquete
		int precio = calc.calcularPrecioTemporada(categoria, unidad, cantidad, empleado);
		
		// Crear Tiquete. 
		LocalDate inicio = LocalDate.now();
		LocalDate fin = calcularFechaFin(inicio, unidad, cantidad);
		
		Tiquete tic = new TiqueteTemporada(categoria, inicio, fin);
		
		// Cobrar al cliente &  Asociar  Tiquete al Cliente.
		procesarVenta(cliente, precio, tic);
		
		}
	
	public void venderTiqueteFastPass(Cliente cliente, UnidadTiempo unidad, int cantidad, boolean empleado) 
			throws FondosInsuficientesException{
		
		// Calcular precio del Tiquete
		int precio = calc.calcularPrecioFastPass(unidad, cantidad, empleado);
		
		// Crear Tiquete. 
		LocalDate inicio = LocalDate.now();
	    LocalDate fin = calcularFechaFin(inicio, unidad, cantidad);
		
	    Tiquete tic = new TiqueteFastPass(inicio, fin);
	    
	    // Cobrar al cliente &  Asociar  Tiquete al Cliente.
	    procesarVenta(cliente, precio, tic);
	}
	
	public void cobrar(Cliente cliente, int precio) throws FondosInsuficientesException {
		
		// revisar si el cliente tiene plata. 
		if (cliente.getDinero() < precio) {
			
			throw new FondosInsuficientesException("El cliente no cuenta con el dinero suficiente. Tiene: $" + cliente.getDinero() + ", requiere: $" + precio);
			
		}
				
		// restar el precio
		cliente.setDinero(cliente.getDinero() - precio);
		
	}
	
	public LocalDate calcularFechaFin(LocalDate inicio, UnidadTiempo unidad, int cantidad) {
		
		return switch (unidad) {
        case DIA -> inicio.plusDays(cantidad);
        case SEMANA -> inicio.plusWeeks(cantidad);
        case MES -> inicio.plusMonths(cantidad);
        case ESTACION -> inicio.plusMonths(3L * cantidad);
        case ANO -> inicio.plusYears(cantidad);
		};
		
	}
	
	 public void procesarVenta(Cliente cliente, int precio, Tiquete tiquete) throws FondosInsuficientesException {
	        cobrar(cliente, precio);
	        cliente.addTiquete(tiquete);
	    }
}
