
package Venta_de_tiquetes;

public class prueba {

    public static void main(String[] args) {
        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        // Pruebas con diferentes combinaciones
        System.out.println("Precio regular (Oro, no empleado): " + calc.calcularPrecioRegular(CategoriaExclusividad.ORO, false));
        System.out.println("Precio regular (Familiar, empleado): " + calc.calcularPrecioRegular(CategoriaExclusividad.FAMILIAR, true));

        System.out.println("Precio individual (no empleado): " + calc.calcularPrecioIndividual(false));
        System.out.println("Precio individual (empleado): " + calc.calcularPrecioIndividual(true));

        System.out.println("Precio temporada (Diamante, 2 meses, no empleado): " + 
            calc.calcularPrecioTemporada(CategoriaExclusividad.DIAMANTE, UnidadTiempo.MES, 2, false));

        System.out.println("Precio temporada (Oro, 1 año, empleado): " + 
            calc.calcularPrecioTemporada(CategoriaExclusividad.ORO, UnidadTiempo.ANO, 1, true));

        System.out.println("Precio fastpass (3 semanas, no empleado): " + 
            calc.calcularPrecioFastPass(UnidadTiempo.SEMANA, 3, false));

        System.out.println("Precio fastpass (1 estación, empleado): " + 
            calc.calcularPrecioFastPass(UnidadTiempo.ESTACION, 1, true));
    }
}
