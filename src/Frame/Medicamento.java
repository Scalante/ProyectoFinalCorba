package Frame;

import AppPackage.AnimationClass;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import ModeloComboBox.*;
import java.awt.event.ItemEvent;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import LDI.*;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ruben
 */
public class Medicamento extends javax.swing.JInternalFrame {

    //Variables Globales
    private DefaultTableModel modelo;
    TableRowSorter trs;
    
    //Se realiza una instanciación para que los objetos obtengan todos los metodos de esa libreria(ImageIcon)
    ImageIcon imagenAviso =  new ImageIcon(getClass().getResource("/Imagenes/WarningAviso.png"));
    
    // Defino la variable publica indice, que almacena el indice del JTable.
    public int indiceFila;  
    
    
    public Medicamento() {
  
        initComponents();
        //Sirve para que no haga ninguna acción a la hora de presionar la x
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        //Llenamos todos los datos que se encuentran en la BD para el ComboBox (CondicionMedicamento)
        
        CondicionMedicamento condMedicamento = new CondicionMedicamento();
        
        //Creamos un Objeto para obtener el modelo del comboBox
        DefaultComboBoxModel objCondicion = new DefaultComboBoxModel(condMedicamento.mostraCondicion());
        this.cmbCondicion.setModel(objCondicion);
        
        //Llenamos todos los datos que se encuentran en la BD para el ComboBox (Proveedores)
        
        Proveedores proveedor = new Proveedores();
        
        //Creamos un Objeto para obtener el modelo del comboBox
        DefaultComboBoxModel objProveedor = new DefaultComboBoxModel(proveedor.mostrarProveedor());
        this.cmbLaboratorio.setModel(objProveedor);
        
    }
    
    
    //Metodo para cargar las columnas en la tabla
    private void getColumn(){
        //Modelo de la tabla Medicamentos
        modelo = (DefaultTableModel) tblMedicamento.getModel();
        // Cargo las columnas de titulo al Jtable
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");
        modelo.addColumn("Presentacion");
        modelo.addColumn("Laboratorio"); 
        modelo.addColumn("Precio"); 
        modelo.addColumn("Cantidad"); 
        modelo.addColumn("Fecha Caducidad"); 
        modelo.addColumn("Ubicacion"); 
    }
    
    //Metodo para cargar los registros en la tabla
    private void cargarTabla() {
        TablaMedicamento objMedicamento = new TablaMedicamento();
        //Se Identifica el modelo de la JTable
        modelo = (DefaultTableModel) tblMedicamento.getModel();
        ResultSet resultado = objMedicamento.cargarMedicamento();
        try {
            Object datos[] = new Object[9];
            while (resultado.next()) {
                for (int i = 0; i < 9; i++) {
                    //Importante, el getObject tiene que ser mayor que 0 por ende se coloca el 1
                    datos[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
     private void limpiarCampo() {
         
        CondicionMedicamento objCondicion = new CondicionMedicamento();
        Presentacion objPresentacion = new Presentacion();
        Proveedores objProveedor = new Proveedores();
        
        
        //Realizamos una Instanciación para el modelo del comboBox perteneciente a la Condicion del medicamento. 
        DefaultComboBoxModel modeloCondicion = new DefaultComboBoxModel(objCondicion.mostraCondicion());
        //Realizamos una Instanciación para el modelo del comboBox perteneciente a la Presentacion del medicamento. 
        DefaultComboBoxModel modeloPresentacion = new DefaultComboBoxModel(objPresentacion.mostrarPresentacion(0));
            
        //Realizamos una Instanciación para el modelo del comboBox perteneciente a los nombres de los Proveedores. 
        DefaultComboBoxModel modeloProveedor = new DefaultComboBoxModel(objProveedor.mostrarProveedor());
         
        
         // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblMedicamento.getModel();

        // Limpio las filas y las columnas de la tabla
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        txtCodigoMedicamento.setText("");
        txtNombreMedicamento.setText("");
        
        modeloCondicion.setSelectedItem("*Selecciona*");
        cmbCondicion.setModel(modeloCondicion);
        
        modeloCondicion.setSelectedItem("*Selecciona*");
        cmbPresentacion.setModel(modeloPresentacion);
        
        
        modeloCondicion.setSelectedItem("*Selecciona*");
        cmbLaboratorio.setModel(modeloProveedor);
        
        txtPrecioVenta.setText("");
        txtCantidad.setText("");
        dateFechaCaducidad.setCalendar(null);
        txtUbicacion.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblGuardar = new javax.swing.JLabel();
        lblGuardar1 = new javax.swing.JLabel();
        lblGuardar2 = new javax.swing.JLabel();
        lblGuardar3 = new javax.swing.JLabel();
        lblGuardar4 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigoMedicamento = new javax.swing.JTextField();
        cmbCondicion = new javax.swing.JComboBox<>();
        cmbPresentacion = new javax.swing.JComboBox<>();
        cmbLaboratorio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        dateFechaCaducidad = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        lblCodigo1 = new javax.swing.JLabel();
        txtNombreMedicamento = new javax.swing.JTextField();
        lblCodigo2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblFiltrar = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        lblFlechaAbajo = new javax.swing.JLabel();
        lblTituloMedicamento = new javax.swing.JLabel();
        lblFlechaArriba = new javax.swing.JLabel();
        lblDato = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicamento = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoGuardar.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoGuardar2.png"))); // NOI18N
        btnGuardar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoGuardar2.png"))); // NOI18N
        btnGuardar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoGuardar.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar.png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar2.png"))); // NOI18N
        btnActualizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar2.png"))); // NOI18N
        btnActualizar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar2.png"))); // NOI18N
        btnBuscar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar2.png"))); // NOI18N
        btnBuscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar2.png"))); // NOI18N
        btnEliminar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar2.png"))); // NOI18N
        btnEliminar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, -1, -1));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar.png"))); // NOI18N
        btnLimpiar.setBorder(null);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar2.png"))); // NOI18N
        btnLimpiar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar2.png"))); // NOI18N
        btnLimpiar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiar.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, -1, -1));

        lblGuardar.setBackground(new java.awt.Color(0, 0, 0));
        lblGuardar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblGuardar.setForeground(new java.awt.Color(0, 0, 0));
        lblGuardar.setText("Limpiar");
        getContentPane().add(lblGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, -1, -1));

        lblGuardar1.setBackground(new java.awt.Color(0, 0, 0));
        lblGuardar1.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblGuardar1.setForeground(new java.awt.Color(0, 0, 0));
        lblGuardar1.setText("Guardar");
        getContentPane().add(lblGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        lblGuardar2.setBackground(new java.awt.Color(0, 0, 0));
        lblGuardar2.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblGuardar2.setForeground(new java.awt.Color(0, 0, 0));
        lblGuardar2.setText("Buscar");
        getContentPane().add(lblGuardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, -1));

        lblGuardar3.setBackground(new java.awt.Color(0, 0, 0));
        lblGuardar3.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblGuardar3.setForeground(new java.awt.Color(0, 0, 0));
        lblGuardar3.setText("Actualizar");
        getContentPane().add(lblGuardar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        lblGuardar4.setBackground(new java.awt.Color(0, 0, 0));
        lblGuardar4.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblGuardar4.setForeground(new java.awt.Color(0, 0, 0));
        lblGuardar4.setText("Eliminar");
        getContentPane().add(lblGuardar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, -1, -1));

        lblCodigo.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(0, 0, 0));
        lblCodigo.setText("Presentación:");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        txtCodigoMedicamento.setBackground(new java.awt.Color(214, 217, 223));
        txtCodigoMedicamento.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtCodigoMedicamento.setForeground(new java.awt.Color(51, 51, 255));
        txtCodigoMedicamento.setBorder(null);
        getContentPane().add(txtCodigoMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 120, 20));

        cmbCondicion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCondicionItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 110, -1));

        getContentPane().add(cmbPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 110, -1));

        getContentPane().add(cmbLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 120, -1));

        jLabel2.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Laboratorio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));

        txtPrecioVenta.setBackground(new java.awt.Color(214, 217, 223));
        txtPrecioVenta.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtPrecioVenta.setForeground(new java.awt.Color(51, 51, 255));
        txtPrecioVenta.setBorder(null);
        getContentPane().add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 120, 20));

        jLabel3.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        txtCantidad.setBackground(new java.awt.Color(214, 217, 223));
        txtCantidad.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(51, 51, 255));
        txtCantidad.setBorder(null);
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, 20));
        getContentPane().add(dateFechaCaducidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fecha Caducidad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 30));

        jLabel6.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Ubicación:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 20));

        txtUbicacion.setBackground(new java.awt.Color(214, 217, 223));
        txtUbicacion.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtUbicacion.setForeground(new java.awt.Color(51, 51, 255));
        txtUbicacion.setBorder(null);
        getContentPane().add(txtUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 120, 20));

        lblCodigo1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblCodigo1.setForeground(new java.awt.Color(0, 0, 0));
        lblCodigo1.setText("Código:");
        getContentPane().add(lblCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        txtNombreMedicamento.setBackground(new java.awt.Color(214, 217, 223));
        txtNombreMedicamento.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtNombreMedicamento.setForeground(new java.awt.Color(51, 51, 255));
        txtNombreMedicamento.setBorder(null);
        getContentPane().add(txtNombreMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 120, 20));

        lblCodigo2.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblCodigo2.setForeground(new java.awt.Color(0, 0, 0));
        lblCodigo2.setText("Nombre Medicamento:");
        getContentPane().add(lblCodigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jLabel7.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Precio de Venta:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 120, 3));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 120, 4));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 120, 4));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 120, 4));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, 4));

        lblFiltrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        lblFiltrar.setText("Filtrar:");
        getContentPane().add(lblFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, 30));

        txtFiltrar.setBackground(new java.awt.Color(153, 153, 153));
        txtFiltrar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        txtFiltrar.setForeground(new java.awt.Color(0, 0, 255));
        getContentPane().add(txtFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 110, 30));

        lblFlechaAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/drop-down-arrow.png"))); // NOI18N
        lblFlechaAbajo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFlechaAbajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFlechaAbajoMouseClicked(evt);
            }
        });
        getContentPane().add(lblFlechaAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 40, 20));

        lblTituloMedicamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Medicamentos.gif"))); // NOI18N
        getContentPane().add(lblTituloMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, -30, -1, -1));

        lblFlechaArriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caret-arrow-up.png"))); // NOI18N
        lblFlechaArriba.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFlechaArriba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFlechaArribaMouseClicked(evt);
            }
        });
        getContentPane().add(lblFlechaArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, -30, -1, -1));

        lblDato.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblDato.setForeground(new java.awt.Color(0, 0, 0));
        lblDato.setText("Datos");
        getContentPane().add(lblDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 10));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 330, 10));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 10, 360));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 10, 360));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 260, 10));

        tblMedicamento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMedicamento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblMedicamento.getTableHeader().setReorderingAllowed(false);
        tblMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedicamento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 370, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        //Programación para que el icono del filtrar, hacer un efecto de aparecer.
        //Instanciación de la libreria AnimatonClass.
        AnimationClass animacion = new AnimationClass();

        //******Filtrar******
        //Sirve para que el campo de txtFiltrar se visualice.
        //El primer parametro es la posición actual del elemento gráfico
        //La segunda es la posición que quiera mover el elemento grafico.
        animacion.jTextFieldXLeft(760, 650, 10, 5, txtFiltrar);
        
        limpiarCampo();
        getColumn();
        cargarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void lblFlechaAbajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFlechaAbajoMouseClicked
        
        //Programación para que el icono del filtrar, hacer un efecto de aparecer.        
        //Instanciación de la libreria AnimatonClass.     
        
        AnimationClass animacion = new AnimationClass();
        
        //******Filtrar******
        //Sirve para que el campo de txtFiltrar se visualice.

        //El primer parametro es la posición actual del elemento gráfico
        //La segunda es la posición que quiera mover el elemento grafico.
        animacion.jLabelYDown(-30,20, 10, 5, lblTituloMedicamento);
        //animacion.jTextFieldXRight(650,760, 10, 5, txtFiltrar);
        animacion.jLabelYUp(0,-30, 10, 5, lblFlechaAbajo);
        animacion.jLabelYDown(-30,0, 10, 5, lblFlechaArriba);
        
        
        
    }//GEN-LAST:event_lblFlechaAbajoMouseClicked

    private void lblFlechaArribaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFlechaArribaMouseClicked
        
        AnimationClass animacion = new AnimationClass();
        
        
        //******Filtrar******
        //Sirve para que el campo de txtFiltrar se visualice.

        //El primer parametro es la posición actual del elemento gráfico
        //La segunda es la posición que quiera mover el elemento grafico.
        animacion.jLabelYUp(20,-30, 10, 5, lblTituloMedicamento);
        animacion.jLabelYUp(0,-30, 10, 5, lblFlechaArriba);
        animacion.jLabelYDown(-30,0, 10, 5, lblFlechaAbajo);
        
    }//GEN-LAST:event_lblFlechaArribaMouseClicked

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        int dialog = JOptionPane.YES_NO_OPTION;
        //Almacena la opción que el usuario escoja (1 -> no) (0 -> Si).
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar la ventana?" , "Advertencia" , dialog);
        
        //Si el usuario presiona Si automaticamente se cierra la ventana.
        if (result == 0) {
            MenuAdministrador.btnMedicamento.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        //********BOTON GUARDAR**********
        
        AnimationClass animacion = new AnimationClass();

        animacion.jTextFieldXRight(650,760, 10, 5, txtFiltrar);
        


        //Validación de cada una de las cajas de Texto (Campos vacios).

        if(txtCodigoMedicamento.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, Digita el código para el medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtCodigoMedicamento.requestFocus();
            return;
        }
         //Validar el campo de Nombre de Medicamento.
        if (txtNombreMedicamento.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digite el nombre del medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtNombreMedicamento.requestFocus();
            return;
        }

        //Validar el comboBox de Condicion, estado  del medicamento Sólido, liquido etc.
        if (cmbCondicion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona la condición del medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbCondicion.requestFocus();
            return;
        }
        
        //Validar el comboBox de Presentación pastillas, aerosol etc.
        if (cmbPresentacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona la Presentacion del medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbPresentacion.requestFocus();
            return;
        }
        //Validar el comboBox Laboratorio.
        if (cmbLaboratorio.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona el laboratorio al que pertenece el medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbLaboratorio.requestFocus();
            return;
        }
        //Validar el campo e Precio de venta.
        if (txtPrecioVenta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digite el precio de venta" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtPrecioVenta.requestFocus();
            return;
        }
        //Validar el campo de cantidad del medicamento.
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita la cantidad de medicamentos" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtCantidad.requestFocus();
            return;
        }
        //Validar la fecha de caducidad del medicamento
        if (dateFechaCaducidad.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita una fecha de caducidad" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            dateFechaCaducidad.requestFocus();
            return;
        }
        //Validar el sitio donde se encentra el medicamento en la farmacia
        if (txtUbicacion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita el sitio donde se va a colocar el medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtUbicacion.requestFocus();
            return;
        }
        
        TablaMedicamento objMedicamento = new TablaMedicamento();
        
        CondicionMedicamento objCondicion = (CondicionMedicamento) cmbCondicion.getSelectedItem();
        Presentacion objPresentacion = (Presentacion) cmbPresentacion.getSelectedItem();
        Proveedores objProveedor = (Proveedores) cmbLaboratorio.getSelectedItem();
        
        int codigoMedicamento =  Integer.parseInt(txtCodigoMedicamento.getText());
        String nombreMedicamento = txtNombreMedicamento.getText();
        int idCondicion = objCondicion.getId();
        int idPresentacion = objPresentacion.getId();
        int idLaboratorio = objProveedor.getId();
        int precioVenta = Integer.parseInt(txtPrecioVenta.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int year = dateFechaCaducidad.getCalendar().get(Calendar.YEAR);
        int mes = dateFechaCaducidad.getCalendar().get(Calendar.MARCH);
        int dia = dateFechaCaducidad.getCalendar().get(Calendar.DAY_OF_MONTH);
        String fecha = String.valueOf(dia+"-"+mes+"-"+year);
        String ubicacion = txtUbicacion.getText();
        
        try {
            boolean resultado = objMedicamento.insertarMedicamento(codigoMedicamento, nombreMedicamento, idCondicion, idPresentacion, idLaboratorio, precioVenta, cantidad, fecha, ubicacion);
            if(resultado == true){
                JOptionPane.showMessageDialog(null, "Se inserto un nuevo registro.");
                //Utilizamos el metodo(limpiar) creado en la parte superior del código para limpiar todos los campos.
                limpiarCampo();
            }else{
                JOptionPane.showMessageDialog(null, "Error al insertar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrió algo inesperado. ¡Por favor, vuelva a intentarlo!");
        }
        
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbCondicionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCondicionItemStateChanged
        
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            CondicionMedicamento condMedicamento = (CondicionMedicamento) cmbCondicion.getSelectedItem();
            Presentacion presMedicamento = new Presentacion();
            DefaultComboBoxModel cmbPresentacion = new DefaultComboBoxModel(presMedicamento.mostrarPresentacion(condMedicamento.getId()));
            this.cmbPresentacion.setModel(cmbPresentacion);
        }
    }//GEN-LAST:event_cmbCondicionItemStateChanged

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //********BOTON ACTUALIZAR**********
        
        AnimationClass animacion = new AnimationClass();

        animacion.jTextFieldXRight(650,760, 10, 5, txtFiltrar);
        
        //Saber si la tabla esta vacia esto me permite decirle al Usuario que presione el boton de buscar registros.
        if(tblMedicamento.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Por favor, Presione el botón de Bucar" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso );
            return;
        }

        if (tblMedicamento.getSelectedRow()== -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso );
            return;
        }

        //Validación de cada una de las cajas de Texto (Campos vacios).

        if(txtCodigoMedicamento.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, Digita el código para el medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtCodigoMedicamento.requestFocus();
            return;
        }
         //Validar el campo de Nombre de Medicamento.
        if (txtNombreMedicamento.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digite el nombre del medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtNombreMedicamento.requestFocus();
            return;
        }

        //Validar el comboBox de Condicion, estado  del medicamento Sólido, liquido etc.
        if (cmbCondicion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona la condición del medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbCondicion.requestFocus();
            return;
        }
        
        //Validar el comboBox de Presentación pastillas, aerosol etc.
        if (cmbPresentacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona la Presentacion del medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbPresentacion.requestFocus();
            return;
        }
        //Validar el comboBox Laboratorio.
        if (cmbLaboratorio.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona el laboratorio al que pertenece el medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbLaboratorio.requestFocus();
            return;
        }
        //Validar el campo e Precio de venta.
        if (txtPrecioVenta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digite el precio de venta" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtPrecioVenta.requestFocus();
            return;
        }
        //Validar el campo de cantidad del medicamento.
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita la cantidad de medicamentos" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtCantidad.requestFocus();
            return;
        }
        //Validar la fecha de caducidad del medicamento
        if (dateFechaCaducidad.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita una fecha de caducidad" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            dateFechaCaducidad.requestFocus();
            return;
        }
        //Validar el sitio donde se encentra el medicamento en la farmacia
        if (txtUbicacion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita el sitio donde se va a colocar el medicamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtUbicacion.requestFocus();
            return;
        }
        
        // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblMedicamento.getModel();
        //Instaciación de la TablaProveedor para acceder al los metodos del 
        TablaMedicamento objMedicamento = new TablaMedicamento();

        String condicionMedicamento = (String) modelo.getValueAt(tblMedicamento.getSelectedRow(), 2);
        String presentacion = (String) modelo.getValueAt(tblMedicamento.getSelectedRow(), 3);
        String nombreLaboratorio = (String) modelo.getValueAt(tblMedicamento.getSelectedRow(), 4);

        //Declaración de las variables para obtener los valores que se encuentran en las cajas de texto
        int codigoMedicamento = Integer.parseInt(txtCodigoMedicamento.getText());
        String nombreMedicamento = txtNombreMedicamento.getText();
        int precioVenta = Integer.parseInt(txtPrecioVenta.getText());
        int cantidad =  Integer.parseInt(txtCantidad.getText());
        
        int year = dateFechaCaducidad.getCalendar().get(Calendar.YEAR);
        int mes = dateFechaCaducidad.getCalendar().get(Calendar.MARCH);
        int dia = dateFechaCaducidad.getCalendar().get(Calendar.DAY_OF_MONTH);
        String fecha = String.valueOf(dia+"-"+mes+"-"+year);
        String ubicacion = txtUbicacion.getText();
        
        if (cmbCondicion.getSelectedItem().equals(condicionMedicamento) && cmbPresentacion.getSelectedItem().equals(presentacion) && cmbLaboratorio.getSelectedItem().equals(nombreLaboratorio)) {

            boolean resultado = objMedicamento.actualizarMedicamento(codigoMedicamento, nombreMedicamento, 0, 0, 0, precioVenta, cantidad, fecha, ubicacion);
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, "La información se actualizó correctamente.");
                
                //Se realiza la limpieza al JTable, y de los campos
                limpiarCampo();
                //Mostramos las columnas (La informacion que identifica a cada tabla en la BD)
                getColumn();
                //Actualizamos la tabla (Buscamos todos los registros)
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        } else {
            //Instanciacion de las clases pertenecientes al Package ModeloComboBox, me permite saber que opción se ha seleccionado y con su respectivo Id
            CondicionMedicamento objCondicion = (CondicionMedicamento) cmbCondicion.getSelectedItem();
            Presentacion objPresentacion = (Presentacion) cmbPresentacion.getSelectedItem();
            Proveedores objProveedor = (Proveedores) cmbLaboratorio.getSelectedItem();
            
            int indiceCondicion = objCondicion.getId();
            int indicePresentacion = objPresentacion.getId();
            int indiceLaboratorio = objProveedor.getId();
            
            boolean resultado = objMedicamento.actualizarMedicamento(codigoMedicamento, nombreMedicamento, indiceCondicion, indicePresentacion, indiceLaboratorio, precioVenta, cantidad, fecha, ubicacion);
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, "La información se actualizó correctamente.");
               
                //Se realiza la limpieza al JTable y las cajas de texto
                limpiarCampo();
                //Mostramos las columnas (La informacion que identifica a cada tabla en la BD)
                getColumn();
                //Actualizamos la tabla (Buscamos todos los registros)
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
            }
        }
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedicamentoMouseClicked
          /* Evento para cuendo el usuario presione click en cualquier fila de la tabla. 
           Lo que hará ese evento es poner todo los datos que hayan en la tabla en los distintos.
           JtextFiel , JCombobox.
         */
        // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblMedicamento.getModel();

        // Asigno el elemento seleccionado de la tabla a los respectivos campos del formulario
        try {
            CondicionMedicamento objCondicion = new CondicionMedicamento();
            Presentacion objPresentacion = new Presentacion();
            Proveedores objProveedor = new Proveedores();

            //Realizamos una Instanciación para el modelo del comboBox perteneciente a la Condicion del medicamento. 
            DefaultComboBoxModel modeloCondicion = new DefaultComboBoxModel(objCondicion.mostraCondicion());
            //Realizamos una Instanciación para el modelo del comboBox perteneciente a la Presentacion del medicamento. 
            DefaultComboBoxModel modeloPresentacion = new DefaultComboBoxModel(objPresentacion.mostrarPresentacion(0));
            
            //Realizamos una Instanciación para el modelo del comboBox perteneciente a los nombres de los Proveedores. 
            DefaultComboBoxModel modeloProveedor = new DefaultComboBoxModel(objProveedor.mostrarProveedor());
            
            //****Cargue de los datos que se encuentran en la tabla a cada uno de los los elemntos graficos TextField,Combobox...etc* 
            
            txtCodigoMedicamento.setText(String.valueOf(modelo.getValueAt(tblMedicamento.getSelectedRow(), 0)));
            txtNombreMedicamento.setText(String.valueOf(modelo.getValueAt(tblMedicamento.getSelectedRow(), 1)));

            String condicion = (String) modelo.getValueAt(tblMedicamento.getSelectedRow(), 2);
            String presentacion = (String) modelo.getValueAt(tblMedicamento.getSelectedRow(), 3);
            String nombreProveedor = (String) modelo.getValueAt(tblMedicamento.getSelectedRow(), 4);

            modeloCondicion.setSelectedItem(condicion);
            cmbCondicion.setModel(modeloCondicion);
            
            modeloPresentacion.setSelectedItem(presentacion);
            cmbPresentacion.setModel(modeloPresentacion);
            
            
            modeloProveedor.setSelectedItem(nombreProveedor);
            cmbLaboratorio.setModel(modeloProveedor);
            

            txtPrecioVenta.setText(String.valueOf(modelo.getValueAt(tblMedicamento.getSelectedRow(), 5)));
            txtCantidad.setText(String.valueOf(modelo.getValueAt(tblMedicamento.getSelectedRow(), 6)));
            
            //Cargamos la fecha que se encuentre en la Jtable al JDatechooser
                
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            String fecha = String.valueOf(modelo.getValueAt(tblMedicamento.getSelectedRow(), 7));
            Date dateValue = null;
            try {
                dateValue = date.parse(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(Medicamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            dateFechaCaducidad.setDate(dateValue);
            
            txtUbicacion.setText(String.valueOf(modelo.getValueAt(tblMedicamento.getSelectedRow(), 8)));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrió algo inesperado al momento de seleccionar una fila ¡Por favor, vuelva a intentarlo!");
        }
    }//GEN-LAST:event_tblMedicamentoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         //Saber si la tabla esta vacia esto me permite decirle al Usuario que presione el boton de buscar registros.
        if (tblMedicamento.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Presione el botón de Bucar", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            return;
        }

        if (tblMedicamento.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            return;
        }
        // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblMedicamento.getModel();
        
        TablaMedicamento objMedicamento = new TablaMedicamento();
        
        try {
             
            // Asigno el indice del elemento seleccionado
            indiceFila = tblMedicamento.getSelectedRow();

            // Elimino el registro del JTable
            modelo.removeRow(indiceFila);
   
            
            //Declaración de la vaiable para obtener el valor que se encuentra en la caja de texto correspondiente.
            int codigoMedicamento = Integer.parseInt(txtCodigoMedicamento.getText());

            boolean resultado = objMedicamento.eliminarMedicamento(codigoMedicamento, 0 , 0 , 0);
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, "Se Eliminó el registro correctamente.");
                limpiarCampo();
                //Mostramos las columnas (La informacion que identifica a cada tabla en la BD)
                getColumn();
                //Actualizamos la tabla (Buscamos todos los registros)
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrió algo inesperado ¡Por favor, vuelva a intentarlo!" + e);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       //Acudimos al método limpiar, nos permite limpiar todos los componentes gráficos
        limpiarCampo();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCondicion;
    private javax.swing.JComboBox<String> cmbLaboratorio;
    private javax.swing.JComboBox<String> cmbPresentacion;
    private com.toedter.calendar.JDateChooser dateFechaCaducidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblDato;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblFlechaAbajo;
    private javax.swing.JLabel lblFlechaArriba;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblGuardar1;
    private javax.swing.JLabel lblGuardar2;
    private javax.swing.JLabel lblGuardar3;
    private javax.swing.JLabel lblGuardar4;
    private javax.swing.JLabel lblTituloMedicamento;
    public static javax.swing.JTable tblMedicamento;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoMedicamento;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtNombreMedicamento;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
