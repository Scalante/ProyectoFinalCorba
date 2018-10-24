/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frame;

import AppPackage.AnimationClass;

/**
 *
 * @author Ruben
 */
public class Empleado extends javax.swing.JInternalFrame {

    /** Creates new form Empleado */
    public Empleado() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        txtTelefono1 = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreLaboratorio1 = new javax.swing.JTextField();
        lblNombreLaboratorio1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblTelefono2 = new javax.swing.JLabel();
        cmbCiudad1 = new javax.swing.JComboBox<>();
        lblFlechaAbajo = new javax.swing.JLabel();
        lblTituloEmpleado = new javax.swing.JLabel();
        lblFlechaArriba = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoGuardar.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoGuardar2.png"))); // NOI18N
        btnGuardar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoGuardar2.png"))); // NOI18N
        btnGuardar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoGuardar.png"))); // NOI18N
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
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
        getContentPane().add(lblDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        txtNombreLaboratorio.setBackground(new java.awt.Color(214, 217, 223));
        txtNombreLaboratorio.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtNombreLaboratorio.setForeground(new java.awt.Color(51, 51, 255));
        txtNombreLaboratorio.setBorder(null);
        getContentPane().add(txtNombreLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 120, 20));

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 100, -1));

        cmbCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 90, -1));

        lblCiudad.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblCiudad.setForeground(new java.awt.Color(0, 0, 0));
        lblCiudad.setText("Ciudad:");
        getContentPane().add(lblCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));

        txtTelefono.setBackground(new java.awt.Color(214, 217, 223));
        txtTelefono.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(51, 51, 255));
        txtTelefono.setBorder(null);
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 120, 20));

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

        txtTelefono1.setBackground(new java.awt.Color(214, 217, 223));
        txtTelefono1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtTelefono1.setForeground(new java.awt.Color(51, 51, 255));
        txtTelefono1.setBorder(null);
        txtTelefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 120, 20));

        lblTelefono1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblTelefono1.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono1.setText("Estado:");
        getContentPane().add(lblTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 120, 4));

        txtNombreLaboratorio1.setBackground(new java.awt.Color(214, 217, 223));
        txtNombreLaboratorio1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        txtNombreLaboratorio1.setForeground(new java.awt.Color(51, 51, 255));
        txtNombreLaboratorio1.setBorder(null);
        getContentPane().add(txtNombreLaboratorio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 120, 20));

        lblNombreLaboratorio1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblNombreLaboratorio1.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreLaboratorio1.setText("Identificación:");
        getContentPane().add(lblNombreLaboratorio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Capturkla.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 120, 3));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        jButton1.setToolTipText("Añadir Foto");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDefaultCapable(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco2.png"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco2.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Marco.png"))); // NOI18N
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        lblTelefono2.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        lblTelefono2.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefono2.setText("Telefono:");
        getContentPane().add(lblTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 20));

        cmbCiudad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbCiudad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 90, -1));

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
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtTelefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono1ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCiudad;
    private javax.swing.JComboBox<String> cmbCiudad1;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTable jTable1;
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
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTelefono2;
    private javax.swing.JLabel lblTituloEmpleado;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtNombreLaboratorio;
    private javax.swing.JTextField txtNombreLaboratorio1;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    // End of variables declaration//GEN-END:variables

}
