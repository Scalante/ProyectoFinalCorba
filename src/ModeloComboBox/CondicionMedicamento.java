package ModeloComboBox;

import java.util.Vector;
import  ConexionMysqlCorba.*;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Ruben Dario Scalnate Rojas
 */
public class CondicionMedicamento {
    
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString()
    {
        return this.nombre;
    }
    
    ConexionBaseDato conexion = new ConexionBaseDato();
    
    //Sirve para agregar los valores al ComboBox
    //Permite agregar el id y lo tome como su indice y su nombre como valor visible al Usuario
    public Vector<CondicionMedicamento> mostraCondicion(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexx = (Connection) conexion.conectar();
        
        Vector<CondicionMedicamento> datos = new Vector<CondicionMedicamento>();
        CondicionMedicamento dat = null;
        
        try {
            String sql = "SELECT * FROM condicionmedicamento";
            ps = conexx.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //Creamos una instanciacion de la misma clase
            //Me permite que el objeto dat pueda acceder a todos los atributos, metodos
            dat = new CondicionMedicamento();
            //Le enviamos el 0 porque el ComboBox si index es el 0 inicialmente
            dat.setId(0);
            dat.setNombre("*Selecciona*");
            //Agregamos el id, nombre al vector
            datos.add(dat);
            
            
            while (rs.next()) {                
                
                dat = new CondicionMedicamento();
                dat.setId(rs.getInt("id"));
                dat.setNombre(rs.getString("descripcion"));
                datos.add(dat);
                
            }
            
            //Cerramos la conexion con la base de datos
            rs.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, a ocurrido en Erro" + ex.getMessage());
        }
        
        return datos;
        
    }
    
    
}
