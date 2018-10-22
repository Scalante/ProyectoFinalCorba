package Frame;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author Ruben Dario Scalante & Abdruval Collazos.
 */
public class ImagenFondo implements Border{
    
    public BufferedImage back;
    
    public ImagenFondo(){
        
        try {
            URL imagePath = new URL(getClass().getResource("../Imagenes/NombreFarmacia.png").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception e) {
        }
        
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        
        g.drawImage(back, (x + (width - back.getWidth())/2), (y + (height - back.getHeight())/2), null);
        
        
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
        
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
    
    
    
}
