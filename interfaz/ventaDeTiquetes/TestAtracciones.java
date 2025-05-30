package ventaDeTiquetes;

import AtraccionesYServicio.AdministradorAtraccionesYLugares;
import Venta_de_tiquetes.Cliente;
import Venta_de_tiquetes.Taquilla;

public class TestAtracciones {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("santiago", "santiagoTilin", "111", 9990000, 20, false);
        AdministradorAtraccionesYLugares admiAtr = new AdministradorAtraccionesYLugares();
        admiAtr.crearTaquilla();
        Taquilla taquilla = admiAtr.getTaquillas().get(0);

        new VentanaVentaTiquetes(cliente, taquilla, admiAtr);
    }
}
