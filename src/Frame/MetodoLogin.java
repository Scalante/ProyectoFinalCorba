package Frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class MetodoLogin {
    
    /*
    Esta Clase, sirve para verificar que el User y Password digitadas por el Usuario
    Efectivamente se encuentra en la base de datos.
    */
    
    //Sólo me permite tipos Enteros
//    public int verificar() {
//        
//        
//        int resultado = 0; //Esta variable se le da el valor de 0 porque el método es de tipo entero pero se interpreta como *False*
//        
//        ResultSet resultadoConsulta = null;
//        
//        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
//        
//        try{
//            
//            //Se declaran dos variables para obtener lo que el Usuario digite.
//            String user = ventanaPrincipal.txtUser.getText();
//            String password = String.valueOf(ventanaPrincipal.txtPassword.getPassword());
//            
//            //Se realiza una instanciación para llamar la Clase(ConexionBaseDato).
//            ConexionBaseDato claseConexionBaseDato = new ConexionBaseDato();
//            
//            //Se realiza la conexión con la Base de Datos
//            claseConexionBaseDato.conexion();
//
//            /*Se llama al método leer que se especificó en la clase (ConexionBaseDato) para utilizarlo
//              en una sentencia sql la cual fue select(buscar, seleccionar).
//            */  
//            
//            if (iniciarSesion == 1) {
//                resultadoConsulta = claseConexionBaseDato.leer("SELECT * FROM iniciarsesionsupervisor WHERE cedula=" + cedulaSupervisor + "  AND password=" + clave + " ");
//            }
//            else {
//                resultadoConsulta = claseConexionBaseDato.leer("SELECT * FROM iniciarsesionadministrador WHERE cedula=" + cedulaSupervisor + "  AND password=" + clave + " ");
//            }
//            
//            if (resultadoConsulta.next()) {
//                
//                resultado = 1; //Si el usuario se encuentra en la base de datos e ingresa los datos correctamente la variable  
//                               //resultado obtendrá el valor de 1 pero se interpretará como *True* 
//            }                      
//        }catch(SQLException ex){
//            //Si falla algo en el Try entrará al catch y me dirá cual fue el el error que se presentó sin reventarse el programa
//            JOptionPane.showMessageDialog(null, ex, "¡Error de conexión", JOptionPane.ERROR_MESSAGE);
//        }
//        finally {
//            
//            try {
//                //Cuándo todo se haya ejecutado satisfactoriamente se procede a cerrar la conexión con la Base de Datos
//                resultadoConsulta.close();
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, ex, "¡Error de desconexión", JOptionPane.ERROR_MESSAGE);
//            } 
//        }
//        
//        return resultado; 
//    }



}
