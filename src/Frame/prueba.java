
package Frame;
import LDI.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ruben
 */
public class prueba {
    
    
    public static void main(String[] args) throws SQLException {
        
        TablaCredencial obj = new TablaCredencial();
        
        //obj.actualizarCredencial(44, "r", "d", 'x');
        
        //obj.eliminarCredencial(345);
        
        
        /*if (obj.usuarioDuplicado(44)) {
            System.out.println("existe");
        }
        else {
            System.out.println("no");
        }*/
        
        int user = 432;
        String password = "445";
        
        //obj.consultar("SELECT * FROM credenciales WHERE codigo =" + user + "  AND password=" + password + " ");
    }
    
    
}
