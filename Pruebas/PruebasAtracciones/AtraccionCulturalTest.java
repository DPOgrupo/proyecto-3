package PruebasAtracciones;


import AtraccionesYServicio.AtraccionCultural;
import Venta_de_tiquetes.CategoriaExclusividad;
import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.Tiquete;
import Venta_de_tiquetes.TiqueteRegular;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtraccionCulturalTest {

    AtraccionCultural atraccion;
    int edadMinima = 10;

    @BeforeEach
    void setUp() {
        atraccion = new AtraccionCultural("Sala de Historia","Zona C","Invierno",30,2,CategoriaExclusividad.BASICO.ordinal(),edadMinima,"Nieve","BAJO");
    }

    @Test
    void testClienteConEdadSuficiente() {
        Cliente cliente = new Cliente("cliente", "cliente", "clave", 500, 15);
        Tiquete tiquete = new TiqueteRegular(CategoriaExclusividad.ORO);
        cliente.addTiquete(tiquete);

        assertTrue(atraccion.cumpleRestricciones(cliente));
    }

    @Test
    void testClienteConEdadInsuficiente() {
        Cliente cliente = new Cliente("cliente", "cliente", "clave", 300, 9);
        Tiquete tiquete = new TiqueteRegular(CategoriaExclusividad.BASICO);
        cliente.addTiquete(tiquete);

        assertFalse(atraccion.cumpleRestricciones(cliente));
    }

    @Test
    void testClienteConEdadExactaMinima() {
        Cliente cliente = new Cliente("cliente", "cliente", "clave", 300, 10);
        Tiquete tiquete = new TiqueteRegular(CategoriaExclusividad.BASICO);
        cliente.addTiquete(tiquete);

        assertTrue(atraccion.cumpleRestricciones(cliente));
    }

    @Test
    void testTiqueteYaUsado() {
        Cliente cliente = new Cliente("cliente", "cliente", "clave", 300, 90);
        Tiquete tiquete = new TiqueteRegular(CategoriaExclusividad.BASICO);
        cliente.addTiquete(tiquete);

        assertTrue(atraccion.cumpleRestricciones(cliente));

        assertFalse(atraccion.cumpleRestricciones(cliente));//no deberia funcionar
    }
}
