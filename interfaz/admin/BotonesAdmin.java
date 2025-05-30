package admin;

import javax.swing.*;
import AtraccionesYServicio.*;
import Venta_de_tiquetes.*;
import Empleados.*;

public class BotonesAdmin extends JPanel {



    public BotonesAdmin(JFrame frame, Cliente cliente, AdministradorTiquetes adminTiquetes, AdministradorAtraccionesYLugares adminAtr) {
        setLayout(null);
        setBounds(0, 250, 550, 300);


        //BOTONES ADMIN
        
        //Primera Vista 
        
        // Botón Gestionar Empleados
        MyButton btnGestionarEmpleados = new MyButton();
        btnGestionarEmpleados.setText("Gestionar Empleados");
        btnGestionarEmpleados.setBounds(50, 160, 200, 40);
        //btnGestionarEmpleados.addActionListener(e -> AccionesAdmin.gestionarEmpleados(adminEmple));
        add(btnGestionarEmpleados);

        // Botón Gestionar Atracciones
        MyButton btnGestionarAtracciones = new MyButton();
        btnGestionarAtracciones.setText("Gestionar Atracciones");
        btnGestionarAtracciones.setBounds(300, 160, 200, 40);
        //btnGestionarAtracciones.addActionListener(e -> AccionesAdmin.gestionarAtracciones(adminAtr));
        add(btnGestionarAtracciones);

        // Botón Crear Lugares
        MyButton btnCrearLugares = new MyButton();
        btnCrearLugares.setText("Crear Lugares");
        btnCrearLugares.setBounds(175, 220, 200, 40);
        //btnCrearLugares.addActionListener(e -> AccionesAdmin.crearLugares(adminAtr));
        add(btnCrearLugares);
        
        // Segunda Vista 
        
        // Botón Crear Empleados
        MyButton btnCrearEmpleados = new MyButton();
        btnCrearEmpleados.setText("Crear Empleados");
        btnCrearEmpleados.setBounds(50, 270, 200, 40);
        add(btnCrearEmpleados);
        btnCrearEmpleados.setVisible(false);
        
        

        // Botón Modificar Empleado
        MyButton btnModificarEmpleado = new MyButton();
        btnModificarEmpleado.setText("Modificar Empleado");
        btnModificarEmpleado.setBounds(300, 270, 200, 40);
        //add(btnModificarEmpleado);
        
        
        // Tercera vista 
        
        
        // Botón Crear Cajero
        MyButton btnCrearCajero = new MyButton();
        btnCrearCajero.setText("Crear Cajero");
        btnCrearCajero.setBounds(50, 320, 200, 40);
        //btnCrearCajero.addActionListener(e -> adminEmple.crearCajero());
        //add(btnCrearCajero);

        // Botón Crear Cocinero
        MyButton btnCrearCocinero = new MyButton();
        btnCrearCocinero.setText("Crear Cocinero");
        btnCrearCocinero.setBounds(300, 320, 200, 40);
        //btnCrearCocinero.addActionListener(e -> adminEmple.crearCocinero());
        
        // Botón Crear Empleado Servicio General
        MyButton btnCrearServicioGeneral = new MyButton();
        btnCrearServicioGeneral.setText("Crear Servicio General");
        btnCrearServicioGeneral.setBounds(175, 370, 200, 40);
        //btnCrearServicioGeneral.addActionListener(e -> adminEmple.crearEmpleadoServicioGeneral());
        
        
        
        
        MyButton btnSalir = new MyButton();
        btnSalir.setText("Salir");
        btnSalir.setBounds(150, 110, 200, 40);
        btnSalir.addActionListener(e -> AccionesAdmin.salirYGuardar(frame, adminTiquetes, adminAtr));

     

        // Acción del boton Gestianor Empleados
        btnGestionarEmpleados.addActionListener(e -> {
        	remove(btnGestionarEmpleados);
        	remove(btnGestionarAtracciones);
        	remove(btnCrearLugares);
            //add(btnCrearEmpleados);
            add(btnModificarEmpleado);
        	add(btnSalir);
        	btnCrearEmpleados.setVisible(true);

            revalidate();
            repaint();
            
                
            
        });
        
     // Acción del boton Crear Empleados
        btnCrearEmpleados.addActionListener(e -> {
        	remove(btnGestionarEmpleados);
        	remove(btnGestionarAtracciones);
        	remove(btnCrearLugares);
        	add(btnCrearServicioGeneral);
            add(btnCrearCocinero);
            add(btnCrearCajero);
            add(btnSalir);

            revalidate();
            repaint();
        });
        
     

}
}