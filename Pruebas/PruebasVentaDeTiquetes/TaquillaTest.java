package PruebasVentaDeTiquetes;

import Venta_de_tiquetes.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaquillaTest {

    @Test
    public void testCompraDeTiquetesConDineroSuficiente() {
        Cliente cliente = new Cliente("Santiago Rojas", "Yago", "Lucas1226", 1152500);
        Taquilla taquilla = new Taquilla();

        try {
            taquilla.venderTiqueteRegular(cliente, CategoriaExclusividad.FAMILIAR, false);
            taquilla.venderTiqueteIndividual(cliente, "ATR123", false);
            taquilla.venderTiqueteTemporada(cliente, CategoriaExclusividad.ORO, UnidadTiempo.SEMANA, 2, false);
            taquilla.venderTiqueteFastPass(cliente, UnidadTiempo.MES, 1, false);

            assertEquals("Santiago Rojas", cliente.getNombre());
            assertTrue(cliente.getDinero() >= 0);
            assertEquals(4, cliente.getTiquetes().size());
        } catch (FondosInsuficientesException e) {
            fail("No se esperaba excepción: " + e.getMessage());
        }
    }

    @Test
    public void testCompraConFondosInsuficientes() {
        Cliente cliente = new Cliente("Ana", "123", "clave", 100); // Muy poco dinero
        Taquilla taquilla = new Taquilla();

        assertThrows(FondosInsuficientesException.class, () -> {
            taquilla.venderTiqueteTemporada(cliente, CategoriaExclusividad.DIAMANTE, UnidadTiempo.MES, 2, false);
        });
    }
}
