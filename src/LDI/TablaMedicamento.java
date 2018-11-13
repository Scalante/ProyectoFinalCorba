package LDI;
import ConexionMysqlCorba.ConexionBaseDato;
import LDI.Medicamentos.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Ruben
 */
public class TablaMedicamento extends MedicamentoPOA{

    //Instanciación de la clase ConexionBaseDato
    ConexionBaseDato objConect = new ConexionBaseDato(); 
    
    private String sql = ""; 
    
    @Override
    public boolean insertarMedicamento(int codigo, String nombre, int idCondicion, int idPresentacion, int ruesLab, int precioVenta, int cantidad, String fechaCaducidad, String ubicacion) {
        boolean resultado = false;
        try {
           String sql = "INSERT INTO medicamentos (codigo,nombre,condicion_id,presentacion_id,ruesLab,precioVenta,cantidad,fechaCaducidad,ubicacion) VALUES ('"+codigo+"','"+nombre+"','"+idCondicion+"','"+idPresentacion+"','"+ruesLab+"','"+precioVenta+"','"+cantidad+"','"+fechaCaducidad+"','"+ubicacion+"')";
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
    public boolean actualizarMedicamento(int codigo, String nombre, int idCondicion, int idPresentacion, int ruesLab, int precioVenta, int cantidad, String fechaCaducidad, String ubicacion) {
       boolean resultado = false;
        try {
            
            if (idCondicion == 0 && idPresentacion == 0 && ruesLab == 0) {
                
                sql = "UPDATE medicamentos SET nombre = '"+nombre+"' , precioVenta = '"+precioVenta+"' , cantidad = '"+cantidad+"', fechaCaducidad = '"+fechaCaducidad+"', ubicacion = '"+ubicacion+"' WHERE codigo = '"+codigo+"' ";
            }
            else {
                sql = "UPDATE medicamentos SET nombre = '"+nombre+"', condicion_id = '"+idCondicion+"', presentacion_id = '"+idPresentacion+"' , ruesLab = '"+ruesLab+"' , precioVenta = '"+precioVenta+"', cantidad = '"+cantidad+"', fechaCaducidad = '"+fechaCaducidad+"', ubicacion = '"+ubicacion+"' WHERE codigo = '"+codigo+"' ";
            }
            
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
    public boolean eliminarMedicamento(int codigo, int idCondicion, int idPresentacion, int ruesLab) {
        boolean resultado = false;
        try {
            
            sql = "DELETE FROM medicamentos WHERE codigo =" + codigo;
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
    public String consultarMedicamento(int codigo) {
        String resultado = "";
        
        try {
            
            //String sqlConsultar = "Select * from credenciales where codigo = " + rues;
            //Se realiza la conexión con la base de datos
            objConect.conectar();
            Statement st = objConect.conex.createStatement();
            ResultSet rs = st.executeQuery("p");
            
            while (rs.next()) {                
                resultado += rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        return resultado;
    }
    
    public ResultSet cargarMedicamento(){
        
       ResultSet resultado = null;
       
        try {
            String sqlConsultar = "SELECT M.codigo, M.nombre, CM.descripcion, PRE.descripcion, PRV.nombre, M.precioVenta, M.cantidad, M.fechaCaducidad, M.ubicacion"
                    + " FROM medicamentos M, condicionmedicamento CM, presentacion PRE, proveedores PRV" 
                    + " WHERE M.condicion_id = CM.id AND M.presentacion_id = PRE.id AND M.ruesLab = PRV.rues";
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
