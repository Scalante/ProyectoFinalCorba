package Frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Ruben
 */
public class ValidacionCajaTexto {

    public void validarSoloLetra(JTextField txtCampo) {
        
        txtCampo.addKeyListener(new KeyAdapter(){
            
           public  void KeyTyped(KeyEvent e){
               char c = e.getKeyChar();
               if (Character.isDigit(c)) {
                   e.consume();
               }
           }
        });
    }
    
    
    public void validarSoloNumero(JTextField txtCampo) {
        
        txtCampo.addKeyListener(new KeyAdapter(){
            
           public  void KeyTyped(KeyEvent e){
               char c = e.getKeyChar();
               if (Character.isLetter(c)) {
                   e.consume();
               }
           }
        });
    }





    
}
