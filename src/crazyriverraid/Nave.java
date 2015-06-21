package crazyriverraid;//paquete del proyecto

//se importan las bibliotecas a utilizar
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

//clase principal Nave
public class Nave {
    private String nave = "player.png";//se inserta la ruta de imagen en un string
    public int posx;//posicion de la nave en x
    public int posy;//posicion de la nave en y
    private int x;//posicion inicial de la nave en x
    private int y;//posicion inicial de la nave en y
    private Image image;

 
    int bx;//posicion de la bala en x
    int by;//posicion de la bala en y
    boolean readyToFire = false;
    public static boolean shot = false;
    public static Rectangle bala;
 
 
 public Nave()
 {        
    ImageIcon image_icon = new ImageIcon(this.getClass().getResource(nave));
    image = image_icon.getImage();
    x = 600;
    y = 400;
     
 }
 
 public static void shoot(){
     if (shot == true){
         bala.y = bala.y - 5;//velocidad de la bala
     }
 }

 public void move()
 {
    if (posx > 0 && x <= 940 - 38)
        x += posx;
    else
    if (posx < 0 && x >= 2)
        x += posx;

    if (posy > 0 && y <= 600 - 50)
        y += posy;
    else
    if (posy < 0 && y >= 2)
        y += posy;

 }
 public int getX()
 {
    return x;
 }
 public int getY()
 {
    return y;
 }
 public Image getImage()
 {
    return image;
 }

 
 public void keyPressed(KeyEvent e)
 {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_SPACE)
    {  
        if (bala == null){
            readyToFire = true;
        }
        if (readyToFire == true){
            by = y;//posicion inicial de la bala en y
            bx = x + 42;//posición inicial de la bala en x
            bala = new Rectangle (bx, by, 3, 5);
            shot = true;
        }
 }
    if (key == KeyEvent.VK_RIGHT)
    {
        posx = 5;
    }
    if (key == KeyEvent.VK_LEFT)
    {
        posx = -5;
    }
    if (key == KeyEvent.VK_UP)
    {
        posy = -5;
    }
    if (key == KeyEvent.VK_DOWN)
    {
        posy = 5;
    }       
    }

 public void keyReleased(KeyEvent e)
 {
 int key = e.getKeyCode();
 
 if (key == KeyEvent.VK_SPACE){
     readyToFire = false;
     if (bala.y <= -10){
         bala = new Rectangle (0,0,0,0);
         shot = false;
         readyToFire = true;
     }
 }
 
 if (key == KeyEvent.VK_RIGHT)
 {
    posx = 0;
 }
 if (key == KeyEvent.VK_LEFT)
 {
    posx = 0;
 }
 if (key == KeyEvent.VK_UP)
 {
    posy = 0;
 }
 if (key == KeyEvent.VK_DOWN)
 {
    posy = 0;
 }      
 }
}