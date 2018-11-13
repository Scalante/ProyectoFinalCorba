package Frame;

import AppPackage.AnimationClass;
import LDI.TablaEmpleado;
import ModeloComboBox.Ciudad;
import ModeloComboBox.Departamento;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ruben
 */
public class Empleado extends javax.swing.JInternalFrame {

    //Variables Globales
    private DefaultTableModel modelo;

    //Se realiza una instanciación para que los objetos obtengan todos los metodos de esa libreria(ImageIcon)
    ImageIcon imagenAviso = new ImageIcon(getClass().getResource("/Imagenes/WarningAviso.png"));

    // Defino la variable publica indice, que almacena el indice del JTable.
    public int indiceFila;
    
    public Empleado() {
        initComponents();
        
        //Sirve para que no haga ninguna acción predeterminda a la hora de presionar la x
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        //Llenamos todos los datos que se encuentran en la BD para el ComboBox
        Departamento departamento = new Departamento();

        //Creamos un Objeto para obtener el modelo del comboBox
        DefaultComboBoxModel objDepartamento = new DefaultComboBoxModel(departamento.mostrarDepartamento());
        cmbDepartamento.setModel(objDepartamento);
        
        txtRutaImagen.setEditable(false);
        
        
    }

    //Metodo para cargar las columnas en la tabla
    private void getColumn() {
        modelo = (DefaultTableModel) tblEmpleado.getModel();
        // Cargo las columnas de titulo al Jtable
        modelo.addColumn("Identificación");
        modelo.addColumn("Nombre");
        modelo.addColumn("Departamento");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Direccion");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Estado");
        modelo.addColumn("Url Imagen");
        modelo.addColumn("Imagen");
    }


    //Metodo para cargar los registros en la tabla
    private void cargarTabla(JTable tabla) {
        TablaEmpleado objEmpleado = new TablaEmpleado();
        //Se Identifica el modelo de la JTable
        modelo = (DefaultTableModel) tblEmpleado.getModel();
        ResultSet resultado = objEmpleado.cargarEmpleado();
        
        tabla.setDefaultRenderer(Object.class, new TablaImagen());
        
        try {
            InputStream is;
            ImageIcon foto;
            Object datos[] = new Object[10];
            while (resultado.next()) {
                for (int i = 0; i < 10; i++) {
                    //Importante, el getObject tiene que ser mayor que 0 por ende se coloca el 1
                    if (i == 9) {
                    
                        
                        byte barray[] = resultado.getBytes(10);
                        BufferedImage image = null;
                      
                        image = ImageIO.read(new ByteArrayInputStream(barray));
                        
                        Image img = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
                        
                        ImageIcon icon = new ImageIcon(img);
                        datos[i] = new JLabel(icon);
                        
                    }
                    else {
                        datos[i] = resultado.getObject(i + 1);  
                    }
                }
                modelo.addRow(datos);
                tblEmpleado.setModel(modelo);
                tblEmpleado.setRowHeight(60);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void limpiarCampo() {
        Departamento objDepartamento = new Departamento();
        Ciudad objCiudad = new Ciudad();
        DefaultComboBoxModel modeloDepartamento = new DefaultComboBoxModel(objDepartamento.mostrarDepartamento());
        DefaultComboBoxModel modeloCiudad = new DefaultComboBoxModel(objCiudad.mostrarCiudad(0));
         // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblEmpleado.getModel();

        // Limpio las filas y las columnas de la tabla
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        txtIdentificacion.setText("");
        txtNombreEmpleado.setText("");
        modeloDepartamento.setSelectedItem("*Selecciona*");
        cmbDepartamento.setModel(modeloDepartamento);
        modeloCiudad.setSelectedItem("*Selecciona*");
        cmbCiudad.setModel(modeloCiudad);
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        cmbEstado.setSelectedIndex(0);
        lblFoto.setIcon(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFiltrar = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleado = new javax.swing.JTable();
        lblLimpiar = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        lblActualizar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblFoto = new javax.swing.JLabel();
        lblFiltrar = new javax.swing.JLabel();
        lblDato = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        lblDepartamento = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        cmbDepartamento = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        lblCiudad = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblNombreLaboratorio = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        lblNombreLaboratorio1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSeleccionarImagen = new javax.swing.JButton();
        lblTelefono2 = new javax.swing.JLabel();
        cmbCiudad = new javax.swing.JComboBox<>();
        lblFlechaAbajo = new javax.swing.JLabel();
        lblTituloEmpleado = new javax.swing.JLabel();
        lblFlechaArriba = new javax.swing.JLabel();
        txtRutaImagen = new javax.swing.JTextField();
        lblNombreLaboratorio2 = new javax.swing.JLabel();

        txtFiltrar.setBackground(new java.awt.Color(255, 255, 255));

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

        tblEmpleado = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEmpleado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblEmpleado.getTableHeader().setReorderingAllowed(false);
        tblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblEmpleadoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 380, 160));

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
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 140, 100));

        lblFiltrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        lblFiltrar.setText("Filtrar:");
        getContentPane().add(lblFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, 30));

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
        getContentPane().add(lblDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        txtNombreEmpleado.setBackground(new java.awt.Color(214, 217, 223));
        txtNombreEmpleado.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtNombreEmpleado.setForeground(new java.awt.Color(51, 51, 255));
        txtNombreEmpleado.setBorder(null);
        getContentPane().add(txtNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 120, 20));

        cmbDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDepartamentoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*Selecciona*", "Activo", "Inactivo" }));
        getContentPane().add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 120, -1));

        lblCiudad.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblCiudad.setForeground(new java.awt.Color(0, 0, 0));
        lblCiudad.setText("Ciudad:");
        getContentPane().add(lblCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));

        txtCorreo.setBackground(new java.awt.Color(214, 217, 223));
        txtCorreo.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(51, 51, 255));
        txtCorreo.setBorder(null);
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 120, 20));

        lblNombreLaboratorio.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblNombreLaboratorio.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreLaboratorio.setText("Nombre:");
        getContentPane().add(lblNombreLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        lblTelefono.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono.setText("Correo:");
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 60, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 120, 3));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 120, 4));

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

        txtTelefono.setBackground(new java.awt.Color(214, 217, 223));
        txtTelefono.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(51, 51, 255));
        txtTelefono.setBorder(null);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 120, 20));

        lblTelefono1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblTelefono1.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono1.setText("Estado:");
        getContentPane().add(lblTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 120, 4));

        txtIdentificacion.setBackground(new java.awt.Color(214, 217, 223));
        txtIdentificacion.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtIdentificacion.setForeground(new java.awt.Color(51, 51, 255));
        txtIdentificacion.setBorder(null);
        getContentPane().add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 120, 20));

        lblNombreLaboratorio1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblNombreLaboratorio1.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreLaboratorio1.setText("Url:");
        getContentPane().add(lblNombreLaboratorio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 20, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 120, 3));

        btnSeleccionarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        btnSeleccionarImagen.setToolTipText("Añadir Foto");
        btnSeleccionarImagen.setBorder(null);
        btnSeleccionarImagen.setContentAreaFilled(false);
        btnSeleccionarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionarImagen.setDefaultCapable(false);
        btnSeleccionarImagen.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco2.png"))); // NOI18N
        btnSeleccionarImagen.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco2.png"))); // NOI18N
        btnSeleccionarImagen.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 50, -1));

        lblTelefono2.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblTelefono2.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono2.setText("Telefono:");
        getContentPane().add(lblTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 20));

        getContentPane().add(cmbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 140, -1));

        lblFlechaAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/drop-down-arrow.png"))); // NOI18N
        lblFlechaAbajo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFlechaAbajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFlechaAbajoMouseClicked(evt);
            }
        });
        getContentPane().add(lblFlechaAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 40, 20));

        lblTituloEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Empleados.gif"))); // NOI18N
        getContentPane().add(lblTituloEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, -30, -1, -1));

        lblFlechaArriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caret-arrow-up.png"))); // NOI18N
        lblFlechaArriba.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFlechaArriba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFlechaArribaMouseClicked(evt);
            }
        });
        getContentPane().add(lblFlechaArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, -30, -1, -1));
        getContentPane().add(txtRutaImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 330, 90, -1));

        lblNombreLaboratorio2.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblNombreLaboratorio2.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreLaboratorio2.setText("Identificación:");
        getContentPane().add(lblNombreLaboratorio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

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
        animacion.jTextFieldXLeft(760,650, 10, 5, txtFiltrar);
        //animacion.jTextFieldXRight(650,760, 10, 5, txtFiltrar);
        
        limpiarCampo();
        getColumn();
        cargarTabla(tblEmpleado);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void lblFlechaAbajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFlechaAbajoMouseClicked

        //Programación para que el icono del filtrar, hacer un efecto de aparecer.
        //Instanciación de la libreria AnimatonClass.

        AnimationClass animacion = new AnimationClass();

        //******Filtrar******
        //Sirve para que el campo de txtFiltrar se visualice.

        //El primer parametro es la posición actual del elemento gráfico
        //La segunda es la posición que quiera mover el elemento grafico.
        animacion.jLabelYDown(-30,20, 10, 5, lblTituloEmpleado);
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
        animacion.jLabelYUp(20,-30, 10, 5, lblTituloEmpleado);
        animacion.jLabelYUp(0,-30, 10, 5, lblFlechaArriba);
        animacion.jLabelYDown(-30,0, 10, 5, lblFlechaAbajo);
    }//GEN-LAST:event_lblFlechaArribaMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //********BOTON GUARDAR**********
        
        AnimationClass animacion = new AnimationClass();

        animacion.jTextFieldXRight(650,760, 10, 5, txtFiltrar);
        


        //Validación de cada una de las cajas de Texto (Campos vacios).

        if(txtIdentificacion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, Digita la identificacion del Empleado" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtIdentificacion.requestFocus();
            return;
        }
         //Validar el campo de Nombre de Medicamento.
        if (txtNombreEmpleado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digite el nombre del Empleado" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtNombreEmpleado.requestFocus();
            return;
        }

        //Validar el comboBox de Condicion, estado  del medicamento Sólido, liquido etc.
        if (cmbDepartamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona el Departamento" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbDepartamento.requestFocus();
            return;
        }
        
        //Validar el comboBox de Presentación pastillas, aerosol etc.
        if (cmbCiudad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona la Ciudad" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbCiudad.requestFocus();
            return;
        }
       
        //Validar el campo e Precio de venta.
        if (txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digite la direccion" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtDireccion.requestFocus();
            return;
        }
        //Validar el campo de cantidad del medicamento.
        if (txtCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita el correo electronico" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtCorreo.requestFocus();
            return;
        }
        //Validar el sitio donde se encentra el medicamento en la farmacia
        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Digita el número de telefono" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            txtTelefono.requestFocus();
            return;
        }
        //Validar el comboBox de Presentación pastillas, aerosol etc.
        if (cmbEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona el estado" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            cmbEstado.requestFocus();
            return;
        }
        if (txtRutaImagen.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecciona una imagen ¡Acuda al Botón!" , "¡Aviso!" , JOptionPane.INFORMATION_MESSAGE , imagenAviso);
            btnSeleccionarImagen.requestFocus();
            return;
        }

        try {
            TablaEmpleado objEmpleado = new TablaEmpleado();
        
            Departamento objDepartamento = (Departamento) cmbDepartamento.getSelectedItem();
            Ciudad objCiudad = (Ciudad) cmbCiudad.getSelectedItem();
        
            int identificacion = Integer.parseInt(txtIdentificacion.getText());
            String nombreEmpleado = txtNombreEmpleado.getText();
            int idDepartamento = objDepartamento.getId();
            int idCiudad = objCiudad.getId();
            String direccion = txtDireccion.getText();
            String correo = txtCorreo.getText();
            String telefono = txtTelefono.getText();
            char estado;

            if (cmbEstado.getSelectedIndex() == 1) {
                estado = 'A';
            } else {
                estado = 'I';
            }
            String rutaImagen = txtRutaImagen.getText();

            byte a = (byte) 1 + 1;
            
            
            boolean resultado = objEmpleado.insertarEmpleado(identificacion, nombreEmpleado, idDepartamento, idCiudad, direccion, correo, telefono, estado, rutaImagen , a);
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

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
        // TODO add your handling code here:
        //Creamos nuestra variable archivo en la cual podremos usar todos los metodos de la clase jFileChooser
        JFileChooser archivo = new JFileChooser();
        //Si deseamos crear filtros para la selecion de archivos
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg","jpeg");
        //Si deseas que se muestre primero los filtros usa la linea q esta abajo de esta.
        //archivo.setFileFilter(filtro);
        // Agregamos el Filtro pero cuidado se mostrara despues de todos los archivos
        archivo.addChoosableFileFilter(filtro);
        // Colocamos titulo a nuestra ventana de Seleccion
        archivo.setDialogTitle("Abrir Archivo");
        //Si deseamos que muestre una carpeta predetermina usa la siguiente linea
        File ruta = new File("D:/productos");
        //Le implementamos a nuestro ventana de seleccion
         archivo.setCurrentDirectory(ruta);
         //Abrimos nuestra Ventana de Selccion
        int ventana = archivo.showOpenDialog(null);
        //hacemos comparacion en caso de aprete el boton abrir
        if(ventana == JFileChooser.APPROVE_OPTION)
        {
            //Obtenemos la ruta de nuestra imagen seleccionada
            File file = archivo.getSelectedFile();
            //Lo imprimimos en una caja de texto para ver su ruta
            txtRutaImagen.setText(String.valueOf(file));
            //de cierto modo necesitamos tener la imagen para ello debemos conocer la ruta de dicha imagen
            Image foto= getToolkit().getImage(txtRutaImagen.getText());
            //Le damos dimension a nuestro label que tendra la imagen
            foto= foto.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            //Imprimimos la imagen en el label
            lblFoto.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    private void cmbDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDepartamentoItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            Departamento objDepartamento = (Departamento) cmbDepartamento.getSelectedItem();
            Ciudad ciudad = new Ciudad();
            DefaultComboBoxModel objCiudad = new DefaultComboBoxModel(ciudad.mostrarCiudad(objDepartamento.getId()));
            this.cmbCiudad.setModel(objCiudad);
        }
    }//GEN-LAST:event_cmbDepartamentoItemStateChanged

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
        int dialog = JOptionPane.YES_NO_OPTION;
        //Almacena la opción que el usuario escoja (1 -> no) (0 -> Si).
        int result = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar la ventana?" , "Advertencia" , dialog);
        
        //Si el usuario presiona Si automaticamente se cierra la ventana.
        if (result == 0) {
            MenuAdministrador.btnEmpleado.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void tblEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadoMouseClicked
        /* Evento para cuendo el usuario presione click en cualquier fila de la tabla. 
           Lo que hará ese evento es poner todo los datos que hayan en la tabla en los distintos.
           JtextFiel , JCombobox.
        */
        // Defino el modelo para el JTable
        modelo = (DefaultTableModel) tblEmpleado.getModel();

        // Asigno el elemento seleccionado de la tabla a los respectivos campos del formulario
        try {
            Departamento objDepartamento = new Departamento();
            Ciudad objCiudad = new Ciudad();
            

            //Realizamos una Instanciación para el modelo del comboBox perteneciente a los Departamentos. 
            DefaultComboBoxModel modeloDepartamento = new DefaultComboBoxModel(objDepartamento.mostrarDepartamento());

            //Realizamos una Instanciación para el modelo del comboBox perteneciente a las Ciudades. 
            DefaultComboBoxModel modeloCiudad = new DefaultComboBoxModel(objCiudad.mostrarCiudad(0));
            
            txtIdentificacion.setText(String.valueOf(modelo.getValueAt(tblEmpleado.getSelectedRow(), 0)));
            txtNombreEmpleado.setText(String.valueOf(modelo.getValueAt(tblEmpleado.getSelectedRow(), 1)));

            String departamento = (String) modelo.getValueAt(tblEmpleado.getSelectedRow(), 2);
            modeloDepartamento.setSelectedItem(departamento);
            cmbDepartamento.setModel(modeloDepartamento);


            String ciudad = (String) modelo.getValueAt(tblEmpleado.getSelectedRow(), 3);
            modeloCiudad.setSelectedItem(ciudad);
            cmbCiudad.setModel(modeloCiudad);

            txtDireccion.setText((String) modelo.getValueAt(tblEmpleado.getSelectedRow(), 4));

            txtCorreo.setText((String) modelo.getValueAt(tblEmpleado.getSelectedRow(), 5));
            
            txtTelefono.setText((String) modelo.getValueAt(tblEmpleado.getSelectedRow(), 6));
            
            String estado = (String)modelo.getValueAt(tblEmpleado.getSelectedRow(), 7);
            
            if(estado.equals("A")){
                cmbEstado.setSelectedItem("Activo");
            }
            else{
                cmbEstado.setSelectedItem("Inactivo");
            } 
            
            txtRutaImagen.setText((String) modelo.getValueAt(tblEmpleado.getSelectedRow(), 8));
            
            Image foto = getToolkit().getImage(txtRutaImagen.getText());
            foto= foto.getScaledInstance(100, 100, 1);
            lblFoto.setIcon(new ImageIcon(foto));
            
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrió algo inesperado al momento de seleccionar una fila ¡Por favor, vuelva a intentarlo!");
        }
    }//GEN-LAST:event_tblEmpleadoMouseClicked

    private void tblEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEmpleadoMouseEntered

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampo();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSeleccionarImagen;
    private javax.swing.JComboBox<String> cmbCiudad;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblLimpiar;
    private javax.swing.JLabel lblNombreLaboratorio;
    private javax.swing.JLabel lblNombreLaboratorio1;
    private javax.swing.JLabel lblNombreLaboratorio2;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTelefono2;
    private javax.swing.JLabel lblTituloEmpleado;
    private javax.swing.JTable tblEmpleado;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtRutaImagen;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
