package ConexionMysqlCorba;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Ruben
 */
public class ConexionBaseDato {
    
    public Connection conex;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost/bdfarmacityneiva","root","corhuila2018");
            //System.out.println("bien");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ha sucedido un problema inesperado con la conexión");
        }
        return conex;
    }
    
    
}
