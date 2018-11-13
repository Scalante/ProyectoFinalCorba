package Frame;

import AppPackage.AnimationClass;
import static Frame.Credencial.tblCredencial;
import static Frame.Credencial.txtCodigo;
import LDI.*;
import ModeloComboBox.*;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class Proveedor extends javax.swing.JInternalFrame {

    //Variables Globales
    private DefaultTableModel modelo;

    //Se realiza una instanciación para que los objetos obtengan todos los metodos de esa libreria(ImageIcon)
    ImageIcon imagenAviso = new ImageIcon(getClass().getResource("/Imagenes/WarningAviso.png"));

    // Defino la variable publica indice, que almacena el indice del JTable.
    public int indiceFila;

    public Proveedor() {
        initComponents();

        //Sirve para que no haga ninguna acción predeterminda a la hora de presionar la x
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        //Llenamos todos los datos que se encuentran en la BD para el ComboBox
        Departamento departamento = new Departamento();

        //Creamos un Objeto para obtener el modelo del comboBox
        DefaultComboBoxModel objDepartamento = new DefaultComboBoxModel(departamento.mostrarDepartamento());
        cmbDepartamento.setModel(objDepartamento);
    }

    //Metodo para cargar las columnas en la tabla
    private void getColumn() {
        modelo = (DefaultTableModel) tblProveedor.getModel();
        // Cargo las columnas de titulo al Jtable
        modelo.addColumn("Rues");
        modelo.addColumn("Nombre");
        modelo.addColumn("Departamento");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
    }

    //Metodo para cargar los registros en la tabla
    private void cargarTabla() {
        TablaProveedor objProveedor = new TablaProveedor();
        //Se Identifica el modelo de la JTable
        modelo = (DefaultTableModel) tblProveedor.getModel();
        ResultSet resultado = objProveedor.cargarProveedor();
        try {
            Object datos[] = new Object[6];
            while (resultado.next()) {
                for (int i = 0; i < 6; i++) {
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
        Departamento objDepartamento = new Departamento();
        Ciudad objCiudad = new Ciudad();
        DefaultComboBoxModel modeloDepartamento = new DefaultComboBoxModel(objDepartamento.mostrarDepartamento());
        DefaultComboBoxModel modeloCiudad = new DefaultComboBoxModel();
         // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblProveedor.getModel();

        // Limpio las filas y las columnas de la tabla
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        txtRues.setText("");
        txtNombreLaboratorio.setText("");
        modeloDepartamento.setSelectedItem("*Selecciona*");
        cmbDepartamento.setModel(modeloDepartamento);
        modeloCiudad.setSelectedItem("*Selecciona*");
        cmbCiudad.setModel(modeloCiudad);
        txtDireccion.setText("");
        txtTelefono.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        lblLimpiar = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblActualizar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblFiltrar = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        lblDato = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        lblDepartamento = new javax.swing.JLabel();
        txtNombreLaboratorio = new javax.swing.JTextField();
        cmbDepartamento = new javax.swing.JComboBox<>();
        cmbCiudad = new javax.swing.JComboBox<>();
        lblCiudad = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblNombreLaboratorio = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblFlechaAbajo = new javax.swing.JLabel();
        lblTituloProveedor = new javax.swing.JLabel();
        lblFlechaArriba = new javax.swing.JLabel();
        txtRues = new javax.swing.JTextField();
        lblNombreLaboratorio1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

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
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, -1, -1));

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
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

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
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, -1, -1));

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
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, -1, -1));

        tblProveedor = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProveedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProveedor.getTableHeader().setReorderingAllowed(false);
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 380, 200));

        lblLimpiar.setBackground(new java.awt.Color(0, 0, 0));
        lblLimpiar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        lblLimpiar.setText("Limpiar");
        getContentPane().add(lblLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, -1, -1));

        lblGuardar.setBackground(new java.awt.Color(0, 0, 0));
        lblGuardar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblGuardar.setForeground(new java.awt.Color(0, 0, 0));
        lblGuardar.setText("Guardar");
        getContentPane().add(lblGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, -1, -1));

        lblBuscar.setBackground(new java.awt.Color(0, 0, 0));
        lblBuscar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(0, 0, 0));
        lblBuscar.setText("Buscar");
        getContentPane().add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));

        lblActualizar.setBackground(new java.awt.Color(0, 0, 0));
        lblActualizar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblActualizar.setForeground(new java.awt.Color(0, 0, 0));
        lblActualizar.setText("Actualizar");
        getContentPane().add(lblActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, -1, -1));

        lblEliminar.setBackground(new java.awt.Color(0, 0, 0));
        lblEliminar.setFont(new java.awt.Font("Decker", 1, 12)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(0, 0, 0));
        lblEliminar.setText("Eliminar");
        getContentPane().add(lblEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, -1, -1));

        lblFiltrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        lblFiltrar.setText("Filtrar:");
        getContentPane().add(lblFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, 30));

        txtFiltrar.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(txtFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 110, 30));

        lblDato.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblDato.setForeground(new java.awt.Color(0, 0, 0));
        lblDato.setText("Datos");
        getContentPane().add(lblDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 380, 320, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, 10));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 10, 360));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, 10, 360));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, 10));

        lblDepartamento.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblDepartamento.setForeground(new java.awt.Color(0, 0, 0));
        lblDepartamento.setText("Departamento:");
        getContentPane().add(lblDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        txtNombreLaboratorio.setBackground(new java.awt.Color(214, 217, 223));
        txtNombreLaboratorio.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtNombreLaboratorio.setForeground(new java.awt.Color(51, 51, 255));
        txtNombreLaboratorio.setBorder(null);
        getContentPane().add(txtNombreLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, 20));

        cmbDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDepartamentoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, -1));

        cmbCiudad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCiudadItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 160, -1));

        lblCiudad.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblCiudad.setForeground(new java.awt.Color(0, 0, 0));
        lblCiudad.setText("Ciudad:");
        getContentPane().add(lblCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));

        txtTelefono.setBackground(new java.awt.Color(214, 217, 223));
        txtTelefono.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(51, 51, 255));
        txtTelefono.setBorder(null);
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, 20));

        lblNombreLaboratorio.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblNombreLaboratorio.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreLaboratorio.setText("Nombre Laboratorio:");
        getContentPane().add(lblNombreLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        lblTelefono.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono.setText("Telefono:");
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 120, 3));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, 4));

        lblDireccion.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(0, 0, 0));
        lblDireccion.setText("Dirección:");
        getContentPane().add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        txtDireccion.setBackground(new java.awt.Color(214, 217, 223));
        txtDireccion.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(51, 51, 255));
        txtDireccion.setBorder(null);
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 120, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 120, 4));

        lblFlechaAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/drop-down-arrow.png"))); // NOI18N
        lblFlechaAbajo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFlechaAbajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFlechaAbajoMouseClicked(evt);
            }
        });
        getContentPane().add(lblFlechaAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 40, 20));

        lblTituloProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedores.gif"))); // NOI18N
        getContentPane().add(lblTituloProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, -30, -1, -1));

        lblFlechaArriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caret-arrow-up.png"))); // NOI18N
        lblFlechaArriba.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFlechaArriba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFlechaArribaMouseClicked(evt);
            }
        });
        getContentPane().add(lblFlechaArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, -30, -1, -1));

        txtRues.setBackground(new java.awt.Color(214, 217, 223));
        txtRues.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtRues.setForeground(new java.awt.Color(51, 51, 255));
        txtRues.setBorder(null);
        getContentPane().add(txtRues, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 120, 20));

        lblNombreLaboratorio1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblNombreLaboratorio1.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreLaboratorio1.setText("Rues:");
        getContentPane().add(lblNombreLaboratorio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, 3));

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
        animacion.jLabelYDown(-30, 20, 10, 5, lblTituloProveedor);
        //animacion.jTextFieldXRight(650,760, 10, 5, txtFiltrar);
        animacion.jLabelYUp(0, -30, 10, 5, lblFlechaAbajo);
        animacion.jLabelYDown(-30, 0, 10, 5, lblFlechaArriba);

    }//GEN-LAST:event_lblFlechaAbajoMouseClicked

    private void lblFlechaArribaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFlechaArribaMouseClicked

        AnimationClass animacion = new AnimationClass();

        //******Filtrar******
        //Sirve para que el campo de txtFiltrar se visualice.
        //El primer parametro es la posición actual del elemento gráfico
        //La segunda es la posición que quiera mover el elemento grafico.
        animacion.jLabelYUp(20, -30, 10, 5, lblTituloProveedor);
        animacion.jLabelYUp(0, -30, 10, 5, lblFlechaArriba);
        animacion.jLabelYDown(-30, 0, 10, 5, lblFlechaAbajo);

    }//GEN-LAST:event_lblFlechaArribaMouseClicked

    private void cmbCiudadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCiudadItemStateChanged

    }//GEN-LAST:event_cmbCiudadItemStateChanged

    private void cmbDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDepartamentoItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            Departamento objDepartamento = (Departamento) cmbDepartamento.getSelectedItem();
            Ciudad ciudad = new Ciudad();
            DefaultComboBoxModel objCiudad = new DefaultComboBoxModel(ciudad.mostrarCiudad(objDepartamento.getId()));
            this.cmbCiudad.setModel(objCiudad);
        }
    }//GEN-LAST:event_cmbDepartamentoItemStateChanged

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        //Programación para cuando el Usuario presione salir.
        int dialog = JOptionPane.YES_NO_OPTION;
        //Almacena la opción que el usuario escoja (1 -> no) (0 -> Si).
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar la ventana?", "Advertencia", dialog);

        //Si el usuario presiona Si automaticamente se cierra la ventana.
        if (result == 0) {
            MenuAdministrador.btnProveedor.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        //********BOTON GUARDAR**********
        AnimationClass animacion = new AnimationClass();

        animacion.jTextFieldXRight(650, 760, 10, 5, txtFiltrar);

        //Validación de cada una de las cajas de Texto (Campos vacios).
        if (txtRues.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita el Rues de la Empresa", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            txtRues.requestFocus();
            return;
        }

        //Validar el campo de Usuario para el Login.
        if (txtNombreLaboratorio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Ingrese el nombre del Laboratorio", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            txtNombreLaboratorio.requestFocus();
            return;
        }
        //Validar el campo de Password para el Login.
        if (cmbDepartamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Seleccione un Departamento", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            cmbDepartamento.requestFocus();
            return;
        }
        //Validar el campo de estado.
        if (cmbCiudad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona una ciudad", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            cmbCiudad.requestFocus();
            return;
        }
        //Validar el campo de estado.
        if (txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Ingrese una direccion", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            txtDireccion.requestFocus();
            return;
        }
        //Validar el campo de estado.
        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Ingrese un telefono", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            txtTelefono.requestFocus();
            return;
        }

        TablaProveedor objProveedor = new TablaProveedor();

        Departamento objDepartamento = (Departamento) cmbDepartamento.getSelectedItem();
        Ciudad objCiudad = (Ciudad) cmbCiudad.getSelectedItem();

        //Declaración de las variables para obtener los valores que se encuentran en las cajas de texto
        int rues = Integer.parseInt(txtRues.getText());
        String nombreLaboratorio = txtNombreLaboratorio.getText();
        int indiceDepartamento = objDepartamento.getId();
        int indiceCiudad = objCiudad.getId();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();

        try {
            boolean resultado = objProveedor.insertarProveedor(rues, nombreLaboratorio, indiceDepartamento, indiceCiudad, direccion, telefono);
            if (resultado == true) {
                JOptionPane.showMessageDialog(null, "Se inserto un nuevo registro.");
                //Utilizamos el objeto para limpiar todos los campos.
                limpiarCampo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrió algo inesperado. ¡Por favor, vuelva a intentarlo!");
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked

        /* Evento para cuendo el usuario presione click en cualquier fila de la tabla. 
           Lo que hará ese evento es poner todo los datos que hayan en la tabla en los distintos.
           JtextFiel , JCombobox.
         */
        // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblProveedor.getModel();

        // Asigno el elemento seleccionado de la tabla a los respectivos campos del formulario
        try {
            Departamento objDepartamento = new Departamento();
            Ciudad objCiudad = new Ciudad();

            //Realizamos una Instanciación para el modelo del comboBox perteneciente a los Departamentos. 
            DefaultComboBoxModel modeloDepartamento = new DefaultComboBoxModel(objDepartamento.mostrarDepartamento());

            txtRues.setText(String.valueOf(modelo.getValueAt(tblProveedor.getSelectedRow(), 0)));
            txtNombreLaboratorio.setText(String.valueOf(modelo.getValueAt(tblProveedor.getSelectedRow(), 1)));

            //A
            String departamento = (String) modelo.getValueAt(tblProveedor.getSelectedRow(), 2);

            modeloDepartamento.setSelectedItem(departamento);
            cmbDepartamento.setModel(modeloDepartamento);

            int var = objDepartamento.getId();

            String ciudad = (String) modelo.getValueAt(tblProveedor.getSelectedRow(), 3);

            //Realizamos una Instanciación para el modelo del comboBox perteneciente a las Ciudades. 
            DefaultComboBoxModel modeloCiudad = new DefaultComboBoxModel(objCiudad.mostrarCiudad(var));
            modeloCiudad.setSelectedItem(ciudad);
            this.cmbCiudad.setModel(modeloCiudad);

            txtDireccion.setText((String) modelo.getValueAt(tblProveedor.getSelectedRow(), 4));

            txtTelefono.setText((String) modelo.getValueAt(tblProveedor.getSelectedRow(), 5));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrió algo inesperado al momento de seleccionar una fila ¡Por favor, vuelva a intentarlo!");
        }
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        //Validación de cada una de las cajas de Texto (Campos vacios).
        if (txtRues.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita el Rues de la Empresa", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            txtRues.requestFocus();
            return;
        }

        //Validar el campo de Usuario para el Login.
        if (txtNombreLaboratorio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Ingrese el nombre del Laboratorio", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            txtNombreLaboratorio.requestFocus();
            return;
        }
        //Validar el campo de estado.
        if (txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Ingrese una direccion", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            txtDireccion.requestFocus();
            return;
        }
        //Validar el campo de estado.
        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Ingrese un telefono", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            txtTelefono.requestFocus();
            return;
        }

        // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblProveedor.getModel();
        //Instaciación de la TablaProveedor para acceder al los metodos del 
        TablaProveedor objProveedor = new TablaProveedor();
        LimpiarCampos limpiar = new LimpiarCampos();

        String departamento = (String) modelo.getValueAt(tblProveedor.getSelectedRow(), 2);
        String ciudad = (String) modelo.getValueAt(tblProveedor.getSelectedRow(), 3);

        //Declaración de las variables para obtener los valores que se encuentran en las cajas de texto
        int rues = Integer.parseInt(txtRues.getText());
        String nombreLaboratorio = txtNombreLaboratorio.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        
        if (cmbDepartamento.getSelectedItem().equals(departamento) && cmbCiudad.getSelectedItem().equals(ciudad)) {

            boolean resultado = objProveedor.actualizarProveedor(rues, nombreLaboratorio, 0, 0, direccion, telefono);
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
            //Instanciacion de la clase Dapratamento, me permite saber que opción se ha seleccionado y con su respectivo Id
            Departamento objDepartamento = (Departamento) cmbDepartamento.getSelectedItem();
            Ciudad objCiudad = (Ciudad) cmbCiudad.getSelectedItem();
            
            int indiceDepartamento = objDepartamento.getId();
            int indiceCiudad = objCiudad.getId();
            
            boolean resultado = objProveedor.actualizarProveedor(rues, nombreLaboratorio, indiceDepartamento, indiceCiudad, direccion, telefono);
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //Saber si la tabla esta vacia esto me permite decirle al Usuario que presione el boton de buscar registros.
        if (tblProveedor.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Presione el botón de Bucar", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            return;
        }

        if (tblProveedor.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila", "¡Aviso!", JOptionPane.INFORMATION_MESSAGE, imagenAviso);
            return;
        }
        // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblProveedor.getModel();
        
        TablaProveedor objProveedor = new TablaProveedor();
        
        try {
             
            // Asigno el indice del elemento seleccionado
            indiceFila = tblProveedor.getSelectedRow();

            // Elimino el registro del JTable
            modelo.removeRow(indiceFila);
   
            
            //Declaración de la vaiable para obtener el valor que se encuentra en la caja de texto correspondiente.
            int rues = Integer.parseInt(txtRues.getText());

            boolean resultado = objProveedor.eliminarProveedor(rues);
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
        limpiarCampo();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCiudad;
    public static javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblDato;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblFlechaAbajo;
    private javax.swing.JLabel lblFlechaArriba;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblLimpiar;
    private javax.swing.JLabel lblNombreLaboratorio;
    private javax.swing.JLabel lblNombreLaboratorio1;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTituloProveedor;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtNombreLaboratorio;
    private javax.swing.JTextField txtRues;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
