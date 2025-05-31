package admin;

import java.awt.Component;

import javax.swing.*;
import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;

public class BotonesAdmin extends JPanel {

    public BotonesAdmin(JFrame frame, Cliente cliente, AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr, AdministradorEmpleados adminEmp) {
        setLayout(null);
        setBounds(0, 250, 550, 500);

        MyButton btnGestionarEmpleados = new MyButton();
        btnGestionarEmpleados.setText("Gestionar Empleados");
        btnGestionarEmpleados.setBounds(50, 100, 200, 40);
        add(btnGestionarEmpleados);

        MyButton btnCrearLugares = new MyButton();
        btnCrearLugares.setText("Crear Lugares");
        btnCrearLugares.setBounds(300, 100, 200, 40);
        add(btnCrearLugares);

     //EMPLEADOS
        MyButton btnCrearEmpleados = new MyButton();
        btnCrearEmpleados.setText("Crear Empleados");
        btnCrearEmpleados.setBounds(50, 100, 200, 40);
        btnCrearEmpleados.setVisible(false);
        add(btnCrearEmpleados);

        MyButton btnModificarEmpleado = new MyButton();
        btnModificarEmpleado.setText("Modificar Empleado");
        btnModificarEmpleado.setBounds(300, 100, 200, 40);
        btnModificarEmpleado.setVisible(false);
        add(btnModificarEmpleado);

        MyButton btnAñadirCapacitacion = new MyButton();
        btnAñadirCapacitacion.setText("Añadir Capacitación");
        btnAñadirCapacitacion.setBounds(50, 100, 200, 40);
        btnAñadirCapacitacion.setVisible(false);
        add(btnAñadirCapacitacion);

        MyButton btnAñadirTurno = new MyButton();
        btnAñadirTurno.setText("Añadir Turno");
        btnAñadirTurno.setBounds(300, 100, 200, 40);
        btnAñadirTurno.setVisible(false);
        add(btnAñadirTurno);

        MyButton btnCambioTurnoGlobal = new MyButton();
        btnCambioTurnoGlobal.setText("Cambio Turno Global");
        btnCambioTurnoGlobal.setBounds(175, 160, 200, 40);
        btnCambioTurnoGlobal.setVisible(false);
        add(btnCambioTurnoGlobal);

     // CREAR EMPLEADOS
        MyButton btnCrearCajero = new MyButton();
        btnCrearCajero.setText("Crear Cajero");
        btnCrearCajero.setBounds(175, 100, 200, 40);
        btnCrearCajero.setVisible(false);
        add(btnCrearCajero);

        MyButton btnCrearCocinero = new MyButton();
        btnCrearCocinero.setText("Crear Cocinero");
        btnCrearCocinero.setBounds(175, 150, 200, 40);
        btnCrearCocinero.setVisible(false);
        add(btnCrearCocinero);

        MyButton btnCrearServicioGeneral = new MyButton();
        btnCrearServicioGeneral.setText("Crear Servicio General");
        btnCrearServicioGeneral.setBounds(175, 200, 200, 40);
        btnCrearServicioGeneral.setVisible(false);
        add(btnCrearServicioGeneral);

        //CREAR LUGARES
        MyButton btnCrearMontañaRusa = new MyButton();
        btnCrearMontañaRusa.setText("Crear Montaña Rusa");
        btnCrearMontañaRusa.setBounds(50, 100, 200, 40);
        btnCrearMontañaRusa.setVisible(false);
        add(btnCrearMontañaRusa);

        MyButton btnCrearAtraccionCultural = new MyButton();
        btnCrearAtraccionCultural.setText("Crear Atracción Cultural");
        btnCrearAtraccionCultural.setBounds(300, 100, 200, 40);
        btnCrearAtraccionCultural.setVisible(false);
        add(btnCrearAtraccionCultural);

        MyButton btnCrearTienda = new MyButton();
        btnCrearTienda.setText("Crear Tienda");
        btnCrearTienda.setBounds(50, 160, 200, 40);
        btnCrearTienda.setVisible(false);
        add(btnCrearTienda);

        MyButton btnCrearCafeteria = new MyButton();
        btnCrearCafeteria.setText("Crear Cafetería");
        btnCrearCafeteria.setBounds(300, 160, 200, 40);
        btnCrearCafeteria.setVisible(false);
        add(btnCrearCafeteria);

        
        MyButton btnSalir = new MyButton();
        btnSalir.setText("Salir");
        btnSalir.setBounds(175, 220, 200, 40);
        btnSalir.setVisible(false);
        btnSalir.addActionListener(e -> AccionesAdmin.salirYGuardar(frame, adminTiquetes, adminAtr,adminEmp));
        add(btnSalir);
        
        //boton devolverse
        
        MyButton btnVolverMenu = new MyButton();
        btnVolverMenu.setText("Volver al Menú");
        btnVolverMenu.setBounds(175, 270, 200, 40);
        btnVolverMenu.setVisible(false);
        add(btnVolverMenu);


//al presionar
        btnGestionarEmpleados.addActionListener(e -> {
            btnGestionarEmpleados.setVisible(false);
            btnCrearLugares.setVisible(false);

            btnCrearEmpleados.setVisible(true);
            btnModificarEmpleado.setVisible(true);
            btnVolverMenu.setVisible(true); 
            btnSalir.setVisible(true); 


        });

        btnCrearEmpleados.addActionListener(e -> {
            btnCrearEmpleados.setVisible(false);
            btnModificarEmpleado.setVisible(false);
            btnSalir.setVisible(false); 

            


            btnCrearCajero.setVisible(true);
            btnCrearCocinero.setVisible(true);
            btnCrearServicioGeneral.setVisible(true);
            btnVolverMenu.setVisible(true); 
        });
        btnModificarEmpleado.addActionListener(e -> {
            btnCrearEmpleados.setVisible(false);
            btnModificarEmpleado.setVisible(false);

            btnAñadirCapacitacion.setVisible(true);
            btnAñadirTurno.setVisible(true);
            btnCambioTurnoGlobal.setVisible(true);
            btnSalir.setVisible(true);
            btnVolverMenu.setVisible(true); 
        });
        
       

        btnCrearLugares.addActionListener(e -> {
            btnGestionarEmpleados.setVisible(false);
            btnCrearLugares.setVisible(false);

            btnCrearMontañaRusa.setVisible(true);
            btnCrearAtraccionCultural.setVisible(true);
            btnCrearTienda.setVisible(true);
            btnCrearCafeteria.setVisible(true);
            btnSalir.setVisible(true);
            btnVolverMenu.setVisible(true); 
        });
        
        btnVolverMenu.addActionListener(e -> {
            for (Component c : getComponents()) {
            	
            	//quitar menos los del menu
                if (c instanceof MyButton && c != btnGestionarEmpleados && c != btnCrearLugares) {
                    c.setVisible(false);
                }
            }

            btnGestionarEmpleados.setVisible(true);
            btnCrearLugares.setVisible(true);
        });
        
        btnCrearCajero.addActionListener(e -> new VentanaCrearCajero(adminEmp));
        btnCrearCocinero.addActionListener(e -> new VentanaCrearCocinero(adminEmp));
        btnCrearServicioGeneral.addActionListener(e -> new VentanaCrearServicioGeneral(adminEmp));

        btnCrearCafeteria.addActionListener(e -> new VentanaCrearCafeteria(adminAtr));
        btnCrearTienda.addActionListener(e -> new VentanaCrearTienda(adminAtr));
        btnCrearMontañaRusa.addActionListener(e -> new VentanaCrearAtraccionMecanica(adminAtr));
        btnCrearAtraccionCultural.addActionListener(e -> new VentanaCrearAtraccionCultural(adminAtr));

        btnAñadirCapacitacion.addActionListener(e -> new VentanaAñadirCapacitacion(adminEmp, adminAtr));
        btnAñadirTurno.addActionListener(e -> new VentanaAsignarTurno(adminEmp, adminAtr));
        btnCambioTurnoGlobal.addActionListener(e -> new VentanaTurnoGlobal(adminEmp));

        

    }
}
