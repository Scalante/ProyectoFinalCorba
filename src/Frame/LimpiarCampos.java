package Frame;

import static Frame.Credencial.tblCredencial;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class LimpiarCampos {
    
    public void limpiarCampoCredencial(){
        //Instanciación del Jframe credencial para obtener todos los atributos(componentes gráficos) y metodos. 
        
        Credencial.txtCodigo.setText("");
        Credencial.txtClave.setText("");
        Credencial.cmbEstado.setSelectedIndex(0);
        Credencial.cmbUsuario.setSelectedIndex(0);
    }
    
    public void limpiarTabla(){
        // Defino el modelo para el JTable
        DefaultTableModel modelo = (DefaultTableModel) tblCredencial.getModel();
        
        // Limpio las filas y las columnas de la tabla
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
         
    }
    
    
}
