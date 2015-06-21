package crazyriverraid;//paquete del proyecto

//se importan las bibliotecas a utilizar
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//clase principal
public class CrazyRiverRaid extends JFrame{

 private static final long serialVersionUID = 1L;

 //constructor
 public CrazyRiverRaid()
 {
 add(new Mapa());//crear nuevo mapa
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//establecer X de salida
 setSize(1300, 600);//dimensiones de la pantalla    
 setLocationRelativeTo(null);
 setTitle("CrazyRiverRaid");//titulo de la ventana
 setResizable(false);//cambio de tamaño de pantalla bloqueado
 setVisible(true);//hacer visible
 
 }
 //metodo main 
 public static void main(String[] args)
 {
     CrazyRiverRaid crazyRiverRaid = new CrazyRiverRaid();
 }

}