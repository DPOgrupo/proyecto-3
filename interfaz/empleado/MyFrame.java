package empleado;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    ImageIcon logo = new ImageIcon("logo.png");
    
    protected MyFrame(){
        //Titulo
        //this.setTitle("Una ventana durisima");
        this.setIconImage(logo.getImage());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        //Tamaño
        this.setSize(500,500);
        
        // Centrar en la pantalla
        this.setLocationRelativeTo(null);
    }
}