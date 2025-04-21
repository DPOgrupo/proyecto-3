package PruebasAtracciones;


import AtraccionesYServicio.AtraccionCultural;
import Venta_de_tiquetes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ticketesFuncionanTest {

    AtraccionCultural atraccion;

    @BeforeEach
    void setUp() {
        // Exclusividad mínima: BASICO , Edad mínima: 12
        atraccion = new AtraccionCultural("Museo de Ciencia", "Zona A", "Todo el año",
                40, 2, CategoriaExclusividad.BASICO.ordinal(), 12, "Nublado", "MEDIO");
    }

    @Test
    void testClienteConTiqueteRegularValido() {
        Cliente cliente = new Cliente("cliente", "cliente", "123", 100, 20);
        TiqueteRegular tiquete = new TiqueteRegular(CategoriaExclusividad.FAMILIAR);
        cliente.addTiquete(tiquete);

        assertTrue(atraccion.cumpleRestricciones(cliente));
    }

    @Test
    void testClienteConTiqueteIndividualCorrecto() {
        Cliente cliente = new Cliente("cliente", "cliente", "123", 100, 20);
        TiqueteIndividual tiquete = new TiqueteIndividual(atraccion.getIdAtraccion());
        cliente.addTiquete(tiquete);

        assertTrue(atraccion.cumpleRestricciones(cliente));
    }

    @Test
    void testClienteConTiqueteIndividualIncorrecto() {
        Cliente cliente = new Cliente("cliente", "cliente", "123", 100, 20);
        TiqueteIndividual tiquete = new TiqueteIndividual("otraAtraccion");
        cliente.addTiquete(tiquete);

        assertFalse(atraccion.cumpleRestricciones(cliente));
    }

    @Test
    void testClienteConTiqueteTemporadaFueraDeRango() {
        Cliente cliente = new Cliente("cliente", "cliente", "123", 100, 20);
        LocalDate hoy = LocalDate.now();
        TiqueteTemporada tiquete = new TiqueteTemporada(CategoriaExclusividad.BASICO,
                hoy.minusDays(10), hoy.minusDays(5));
        cliente.addTiquete(tiquete);

        assertFalse(atraccion.cumpleRestricciones(cliente));
    }

    @Test
    void testClienteConTiqueteFastPassValido() {
        Cliente cliente = new Cliente("cliente", "cliente", "123", 100, 20);
        LocalDate hoy = LocalDate.now();
        TiqueteFastPass fastPass = new TiqueteFastPass(hoy.minusDays(4), hoy.minusDays(1));
        cliente.addTiquete(fastPass);

        assertFalse(atraccion.cumpleRestricciones(cliente));
    }


}
