package LDI;
import LDI.Credenciales.CredencialPOA;
import ConexionMysqlCorba.ConexionBaseDato;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Ruben
 */
public class TablaCredencial extends CredencialPOA{
    
    //Instanciación de la clase ConexionBaseDato
    ConexionBaseDato objConect = new ConexionBaseDato();    
    
    
    @Override
    public boolean insertarCredencial(int codigo, String user, String password, char estado) {
        boolean resultado = false;
        try {
            String sql = "insert into credenciales (codigo,user,password,estado) values ('"+codigo+"','"+user+"','"+password+"','"+estado+"')";
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if(valor>0){
                resultado = true;
            }
            //Se cierran las conexiones
            objConect.conex.close();
            st.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, el código o el usuario ya se encuentran registrados. ¡Por favor, vuelva a intentarlo!" + e.getMessage()); 
        }        
        return resultado; 
    }

    @Override
    public boolean actualizarCredencial(int codigo, String user, String password, char estado) {
       boolean resultado = false;
        try {
            String sql = "UPDATE credenciales SET user = '"+user+"', password = '"+password+"', estado = '"+estado+"' where codigo = '"+codigo+"' ";
            //Se realiza la conexión con la base de datos
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if(valor>0){
                resultado = true;
            }
            //Se cierran las conexiones.
            objConect.conex.close();
            st.close();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al actualizar. "+e);
        }        
        return resultado;
    }

    @Override
    public boolean eliminarCredencial(int codigo) {
        boolean resultado = false;
        try {
            String sql = "Delete from credenciales where codigo = " +codigo;
            //Se realiza la conexión con la base de datos
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if(valor>0){
                resultado = true;
            }
            //Se cierran las conexiones.
            objConect.conex.close();
            st.close();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al eliminar. "+e.getMessage());
        }        
        return resultado;
    }

    @Override
    public String consultarCredencial(int codigo) {
        String resultado = "";
        
        try {
            
            String sqlConsultar = "Select * from credenciales where codigo = " + codigo;
            //Se realiza la conexión con la base de datos
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            ResultSet rs = st.executeQuery(sqlConsultar);
            
            while (rs.next()) {                
                resultado += rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ResultSet cargarCredencial(){
        
       ResultSet resultado = null;
       
        try {
            String sqlConsultar = "Select codigo, user, password, estado from credenciales";
            //Se realiza la conexión con la base de datos
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            resultado = st.executeQuery(sqlConsultar);
           
            //Cerrar las conexiones.
            //st.close();
            //objConect.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
       return resultado;
    }
    
    public int verificar(String sql){
        
       ResultSet resultado = null;
       int valido = 0;
       
        try {
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            resultado = st.executeQuery(sql);            
            
            if (resultado.next()) {
                
                valido = 1; //Si el usuario se encuentra en la base de datos e ingresa los datos correctamente la variable  
                 //resultado obtendrá el valor de 1 pero se interpretará como *True* 
            }    
            
            st.close();
            objConect.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
       return valido;
    }
    
    

    
}
