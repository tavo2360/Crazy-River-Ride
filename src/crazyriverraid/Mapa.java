package crazyriverraid;//paquete del proyecto

//se importan las bibliotecas a utilizar
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//clase principal
public class Mapa extends JPanel implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    private Timer timer;//se asigna un timer a una variable
    private Nave nave;//se asigna una nave a una variable
    private String escenario = "fondo1.png";//se asigna un escenario a una variable y se especifica su ruta
    private String lateral = "panel.jpg";//se asigna un panel lateral a una variable y se especifica su ruta
    
    //se establecen variables ImageIcon
    ImageIcon image_icon;
    ImageIcon image_icon2;

    //constructor
    public Mapa(){

        addKeyListener(new TAdapter());//se añade un KeyListener
        setFocusable(true);
        setBackground(Color.GRAY);//se asigna color gris a la pantalla
        setDoubleBuffered(true);

        //se crean nuevos ImageIcon
        image_icon = new ImageIcon(this.getClass().getResource(escenario));
        image_icon2 = new ImageIcon(this.getClass().getResource(lateral));

        nave = new Nave();//se crea una nave
        timer = new Timer(5, this);// se crea un timer
        timer.start();//se inicia el timer        
    }
    
    //metodo paint que dibuja objetos en pantalla
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(image_icon.getImage(), 0, 0, this);        
        g2d.drawImage(nave.getImage(), nave.getX(), nave.getY(), this);//se dibuja la nave
        //g2d.drawImage(image_icon2.getImage(), 1050, 0, this);  

        if (Nave.shot){
            g.setColor(Color.BLACK);//se define el color del disparo en negro
            g.fillRect(Nave.bala.x, Nave.bala.y, Nave.bala.width, Nave.bala.height);//se dibuja un rectangulo correspondiente a la bala
        }
    
    //Toolkit.getDefaultToolkit().sync();
    //g.dispose(); //no se para q sirve y al parecer no afecta en nada  
    }

    //metodo actionPerformed
    public void actionPerformed(ActionEvent e){
        nave.move();//se accede al movimiento de la nava
        repaint();//se actualiza la imagen
        Nave.shoot();
    }

    private class TAdapter extends KeyAdapter{

    public void keyReleased(KeyEvent e){
        nave.keyReleased(e);
    }
    public void keyPressed(KeyEvent e){
        nave.keyPressed(e);
    }
    }
}
