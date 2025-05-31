package empleado;
import java.awt.Color;
import javax.swing.ImageIcon;
import persistencia.*;

public class MenuEmpleado {
    public static void mostrar() {
        MyFrame menu = new MyFrame();
        menu.setTitle("Sistema de Empleados - AventuraMax");
        menu.setSize(550, 600);
        
        MyLabel AventuraMax = new MyLabel();
        AventuraMax.setBackground(new Color(0xBCEDF6));
        AventuraMax.setSize(400, 250);
        ImageIcon logo = new ImageIcon("logo.png");
        AventuraMax.setIcon(logo);
        
        MyButton BIniciarSesion = new MyButton();
        BIniciarSesion.setText("Iniciar Sesión");
        BIniciarSesion.setBounds(150, 350, 200, 50);
        BIniciarSesion.addActionListener(e -> VentanaLogin.mostrar(menu));
        
        
        
        menu.add(AventuraMax);
        menu.add(BIniciarSesion);
      
        menu.setVisible(true);
    }
    
    public static void main(String[] args) {
        mostrar();
    }
}
