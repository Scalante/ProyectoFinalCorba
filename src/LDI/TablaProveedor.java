package LDI;
import ConexionMysqlCorba.ConexionBaseDato;
import LDI.Proveedores.ProveedorPOA;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class TablaProveedor extends ProveedorPOA{

    //Instanciación de la clase ConexionBaseDato
    ConexionBaseDato objConect = new ConexionBaseDato(); 
    private String sentencia; 
    
    @Override
    public boolean insertarProveedor(int rues, String nombre, int idDepartamento, int idCiudad, String direccion, String telefono) {
        boolean resultado = false;
        try {
            String sql = "insert into proveedores (rues,nombre,prv_departamento_id,ciudad_id,direccion,telefono) values ('"+rues+"','"+nombre+"','"+idDepartamento+"','"+idCiudad+"','"+direccion+"','"+telefono+"')";
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
    public boolean actualizarProveedor(int rues, String nombre, int idDepartamento, int idCiudad, String direccion, String telefono) {
        boolean resultado = false;
        try {
            
            if (idDepartamento == 0 && idCiudad == 0) {
                
               sentencia = "UPDATE proveedores SET nombre = '"+nombre+"', direccion = '"+direccion+"', telefono = '"+telefono+"' WHERE rues = '"+rues+"' ";   
            }
            else {
                sentencia = "UPDATE proveedores SET nombre = '"+nombre+"', prv_departamento_id = '"+idDepartamento+"', ciudad_id = '"+idCiudad+"', direccion = '"+direccion+"', telefono = '"+telefono+"' WHERE rues = '"+rues+"' ";
            }
            
            //Se realiza la conexión con la base de datos
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            int valor = st.executeUpdate(sentencia);
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
    public boolean eliminarProveedor(int rues) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM proveedores WHERE rues =" + rues;
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
           JOptionPane.showMessageDialog(null, "Error al eliminar. ru"+e.getMessage());
        }        
        return resultado;
    }
   
    @Override
    public String consultarProveedor(int rues) {
       String resultado = "";
        
        try {
            
            String sqlConsultar = "Select * from credenciales where codigo = " + rues;
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
    
    public ResultSet cargarProveedor(){
        
       ResultSet resultado = null;
       
        try {
            String sqlConsultar = "SELECT P.rues, nombre, D.descripcion, C.descripcion, P.direccion , P.telefono "
                    + " FROM departamento D, ciudad C , proveedores P "
                    + "WHERE P.prv_departamento_id = D.idDepartamento AND P.ciudad_id = C.idCiudad";
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

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
