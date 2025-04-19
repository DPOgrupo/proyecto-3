package PruebasVentaDeTiquetes;

import Venta_de_tiquetes.CalculadoraDePrecios;
import Venta_de_tiquetes.CategoriaExclusividad;
import Venta_de_tiquetes.UnidadTiempo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraDePreciosTest {

    @Test
    public void testPrecioRegular() {
        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        assertEquals(75000, calc.calcularPrecioRegular(CategoriaExclusividad.ORO, false));
        assertEquals(25000, calc.calcularPrecioRegular(CategoriaExclusividad.FAMILIAR, true));
    }

    @Test
    public void testPrecioIndividual() {
        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        assertEquals(15000, calc.calcularPrecioIndividual(false));
        assertEquals(7500, calc.calcularPrecioIndividual(true));
    }

    @Test
    public void testPrecioTemporada() {
        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        assertEquals(3000000, calc.calcularPrecioTemporada(CategoriaExclusividad.DIAMANTE, UnidadTiempo.MES, 2, false));
        assertEquals(2053125, calc.calcularPrecioTemporada(CategoriaExclusividad.ORO, UnidadTiempo.ANO, 1, true));
    }

    @Test
    public void testPrecioFastPass() {
        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        assertEquals(315000, calc.calcularPrecioFastPass(UnidadTiempo.SEMANA, 3, false));
        assertEquals(360000, calc.calcularPrecioFastPass(UnidadTiempo.ESTACION, 1, true));
    }
}
