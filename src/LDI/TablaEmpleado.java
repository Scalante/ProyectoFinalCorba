package LDI;
import ConexionMysqlCorba.ConexionBaseDato;
import LDI.Empleados.*;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class TablaEmpleado extends EmpleadoPOA {
    //Instanciación de la clase ConexionBaseDato
    ConexionBaseDato objConect = new ConexionBaseDato(); 
    
    private String sentencia; 
    @Override
    public boolean insertarEmpleado(int identificacion, String nombre, int idDepartamento, int idCiudad, String direcion, String correo, String telefono, char estado, String urlImagen, byte imagen) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO empleado (identificacion,nombre,emp_departamento_id,emp_ciudad_id,direccion,correo,telefono, estado, urlImagen,imagen) values (?,?,?,?,?,?,?,?,?,?)";
            objConect.conectar();
            PreparedStatement pst = objConect.conex.prepareStatement(sql);
            
            FileInputStream  archivofoto;
            
            pst.setInt(1, identificacion);
            pst.setString(2, nombre);
            pst.setInt(3, idDepartamento);
            pst.setInt(4, idCiudad);
            pst.setString(5, direcion);
            pst.setString(6, correo);
            pst.setString(7, telefono);
            pst.setString(8, String.valueOf(estado));
            pst.setString(9, urlImagen);
            
            //Convierte una url a cadena de bytes (0 y 1)
            archivofoto = new FileInputStream(urlImagen);
            //SetBinaryStream permite almacenar cantidad de bytes en la base de datos
            pst.setBinaryStream(10, archivofoto);
            
            int valor = pst.executeUpdate();
            
            if(valor>0){
                resultado = true;
            }
            //Se cierran las conexiones
            objConect.conex.close();
            pst.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, el código o el usuario ya se encuentran registrados. ¡Por favor, vuelva a intentarlo!" + e.getMessage()); 
        }        
        return resultado; 
    }

    @Override
    public boolean actualizarEmpleado(int identificacion, String nombre, int idDepartamento, int idCiudad, String direcion, String correo, String telefono, char estado, String urlImagen, byte imagen) {
        boolean resultado = false;
        try {
            
            if (idDepartamento == 0 && idCiudad == 0) {
                
               sentencia = "UPDATE empleado SET nombre = ? , direccion = ?, correo = ?, telefono = ?, estado=?, urlImagen=?,imagen=? WHERE identificacion = ?";  
            }
            else {
                sentencia = "UPDATE empleado SET nombre = ? , emp_departamento_id = ?, emp_ciudad_id = ?, direccion = ?, correo = ?, telefono = ?, estado=?, urlImagen=?,imagen=? WHERE identificacion = ?";
            }
            
            //Se realiza la conexión con la base de datos
            objConect.conectar();
             PreparedStatement pst = objConect.conex.prepareStatement(sentencia);
            
             
            FileInputStream  archivofoto;
            
            
            if (idDepartamento == 0 && idCiudad == 0){
                pst.setString(1, nombre);
                pst.setString(2, direcion);
                pst.setString(3, correo);
                pst.setString(4, telefono);
                pst.setString(5, String.valueOf(estado));
                pst.setString(6, urlImagen);
                
                //Convierte una url a cadena de bytes (0 y 1)
                archivofoto = new FileInputStream(urlImagen);
                //SetBinaryStream permite almacenar cantidad de bytes en la base de datos
                pst.setBinaryStream(7, archivofoto);
                pst.setInt(8,identificacion);
            }
            else {
                pst.setString(1, nombre);
                pst.setInt(2, idDepartamento);
                pst.setInt(3, idCiudad);
                pst.setString(4, direcion);
                pst.setString(5, correo);
                pst.setString(6, telefono);
                pst.setString(7, String.valueOf(estado));
                pst.setString(8, urlImagen);
                //Convierte una url a cadena de bytes (0 y 1)
                archivofoto = new FileInputStream(urlImagen);
                //SetBinaryStream permite almacenar cantidad de bytes en la base de datos
                pst.setBinaryStream(9, archivofoto);
                pst.setInt(10,identificacion);
            }
            
            int valor = pst.executeUpdate();
 
            if(valor>0){
                resultado = true;
            }
            //Se cierran las conexiones.
            objConect.conex.close();
            pst.close();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al actualizar. "+e);
        }        
        return resultado;
    }

    @Override
    public boolean eliminarEmpleado(int identificacion) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM empleado WHERE identificacion =" + identificacion;
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
           JOptionPane.showMessageDialog(null, "Error al eliminar."+e.getMessage());
        }        
        return resultado;
    }

    @Override
    public String consultarEmpleado(int identificacion) {
        String resultado = "";
        
        try {
            
            String sqlConsultar = "Select * from credenciales where codigo = " + identificacion;
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

    public ResultSet cargarEmpleado(){
        
       ResultSet resultado = null;
       
        try {
            String sqlConsultar = "SELECT E.identificacion, E.nombre, D.descripcion, C.descripcion, E.direccion , E.correo, E.telefono, E.estado, E.urlImagen, E.imagen" +
                                  " FROM departamento D, ciudad C , empleado E" +
                                  " WHERE E.emp_departamento_id = D.idDepartamento AND E.emp_ciudad_id = C.idCiudad";
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
