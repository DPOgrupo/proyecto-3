/**
 * 
 */
/**
 * 
 */
module Proyecto1Entrega2 {
	requires org.junit.jupiter.api;
	requires com.google.gson;
	requires com.google.zxing;
	requires com.google.zxing.javase;
    opens Empleados to com.google.gson;
    opens AtraccionesYServicio to com.google.gson;
    opens Venta_de_tiquetes to com.google.gson;
    opens persistencia to com.google.gson;
    
}



