package ConexionMysqlCorba;

/**
 *
 * @author Ruben
 */
public class PruebaConexion {
    
    
    public static void main(String[] args) {
        
        ConexionBaseDato cn = new ConexionBaseDato();
        
        
        cn.conectar();
        
        
    }
    
    
}
