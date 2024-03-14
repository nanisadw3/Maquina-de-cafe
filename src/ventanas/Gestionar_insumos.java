/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Gestionar_insumos extends javax.swing.JFrame {
    public static  int ID_insumo = 0;
    int bandera_mes = 0;
    int bandera_año = 0;
    int bandera_dia = 0;
    String user;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Gestionar_ingresos
     */
    public Gestionar_insumos() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Logo Final.png")));
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        user = Log_in.user;
        setTitle("Registro ingresos - Secion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

        etiketa_Año.setVisible(false);
        etiketa_Mes.setVisible(false);
        etiketa_dia.setVisible(false);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from insumos");
            ResultSet rs = pst.executeQuery();

            tabla_Ingresos = new JTable(model);
            jScroll_ingresos.setViewportView(tabla_Ingresos);

            model.addColumn(" ");
            model.addColumn("Insumo");
            model.addColumn("Dia");
            model.addColumn("Mes");
            model.addColumn("Año");
            model.addColumn("Precio");
            
            while (rs.next()) {
                Object[] fila = new Object[6];

                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                model.addRow(fila);

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("error al llenar la tabla" + e);
            JOptionPane.showMessageDialog(null, "error al mostrar informacion, porfavor contacta al administrador ");
        }
        
        tabla_Ingresos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent  e){
            //filas
            int fila_point = tabla_Ingresos.rowAtPoint(e.getPoint());
            //columnas
            int columna_poin = 0;
            
            if(fila_point >-1){
                ID_insumo = (int)model.getValueAt(fila_point, columna_poin);
                Informacion_insumo mensajero = new Informacion_insumo();
                mensajero.setVisible(true);
                
                       
            }
        }
        });
        

        //colocar imagen de fondo
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        boton_buscar = new javax.swing.JButton();
        jScroll_ingresos = new javax.swing.JScrollPane();
        tabla_Ingresos = new javax.swing.JTable();
        txt_mes = new javax.swing.JTextField();
        txt_año = new javax.swing.JTextField();
        txt_dia = new javax.swing.JTextField();
        etiketa_dia = new javax.swing.JLabel();
        etiketa_Mes = new javax.swing.JLabel();
        etiketa_Año = new javax.swing.JLabel();
        boton_editar = new javax.swing.JButton();
        boton_editar1 = new javax.swing.JButton();
        boton_editar2 = new javax.swing.JButton();
        botton_Minimisar = new javax.swing.JButton();
        boton_Cerrar = new javax.swing.JButton();
        etiketa_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(107, 52, 36));
        jLabel3.setText("Insumos Registrados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        boton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        boton_buscar.setContentAreaFilled(false);
        boton_buscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar1.jpg.png"))); // NOI18N
        boton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 80, 70));

        tabla_Ingresos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScroll_ingresos.setViewportView(tabla_Ingresos);

        getContentPane().add(jScroll_ingresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 820, 290));

        txt_mes.setEditable(false);
        txt_mes.setBackground(new java.awt.Color(198, 123, 99));
        txt_mes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_mes.setForeground(new java.awt.Color(255, 255, 255));
        txt_mes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mes.setText("Mes");
        getContentPane().add(txt_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 100, 40));

        txt_año.setEditable(false);
        txt_año.setBackground(new java.awt.Color(198, 123, 99));
        txt_año.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_año.setForeground(new java.awt.Color(255, 255, 255));
        txt_año.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_año.setText("Año");
        getContentPane().add(txt_año, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 120, 40));

        txt_dia.setEditable(false);
        txt_dia.setBackground(new java.awt.Color(198, 123, 99));
        txt_dia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_dia.setForeground(new java.awt.Color(255, 255, 255));
        txt_dia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dia.setText("Dia");
        getContentPane().add(txt_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 40));

        etiketa_dia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        etiketa_dia.setForeground(new java.awt.Color(165, 86, 55));
        etiketa_dia.setText("Dia:");
        getContentPane().add(etiketa_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        etiketa_Mes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        etiketa_Mes.setForeground(new java.awt.Color(165, 86, 55));
        etiketa_Mes.setText("Mes:");
        getContentPane().add(etiketa_Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        etiketa_Año.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        etiketa_Año.setForeground(new java.awt.Color(165, 86, 55));
        etiketa_Año.setText("Año:");
        getContentPane().add(etiketa_Año, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        boton_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/palomita.png"))); // NOI18N
        boton_editar.setContentAreaFilled(false);
        boton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 80, 70));

        boton_editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/palomita.png"))); // NOI18N
        boton_editar1.setContentAreaFilled(false);
        boton_editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editar1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_editar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 80, 70));

        boton_editar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/palomita.png"))); // NOI18N
        boton_editar2.setContentAreaFilled(false);
        boton_editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editar2ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_editar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 70));

        botton_Minimisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimisar.png"))); // NOI18N
        botton_Minimisar.setContentAreaFilled(false);
        botton_Minimisar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimisar2.png"))); // NOI18N
        botton_Minimisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botton_MinimisarActionPerformed(evt);
            }
        });
        getContentPane().add(botton_Minimisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 50, 50));

        boton_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        boton_Cerrar.setContentAreaFilled(false);
        boton_Cerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar2.png"))); // NOI18N
        boton_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 60, 50));

        etiketa_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_GG.png"))); // NOI18N
        getContentPane().add(etiketa_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editarActionPerformed
        bandera_mes = 4;
        ImageIcon tache = new ImageIcon("src/imagenes/tache.png");
        boton_editar.setIcon(tache);

        txt_mes.setEditable(true);

        etiketa_Mes.setVisible(true);

        txt_mes.setText("");
    }//GEN-LAST:event_boton_editarActionPerformed

    private void boton_editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar1ActionPerformed
        bandera_año++;
        ImageIcon tache = new ImageIcon("src/imagenes/tache.png");
        boton_editar1.setIcon(tache);
        txt_año.setEditable(true);
        etiketa_Año.setVisible(true);
        txt_año.setText("");
    }//GEN-LAST:event_boton_editar1ActionPerformed

    private void boton_editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar2ActionPerformed
        bandera_dia = 2;
        ImageIcon tache = new ImageIcon("src/imagenes/tache.png");
        boton_editar2.setIcon(tache);
        txt_dia.setEditable(true);
        etiketa_dia.setVisible(true);
        txt_dia.setText("");

    }//GEN-LAST:event_boton_editar2ActionPerformed

    private void boton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscarActionPerformed
        String buscar_dia, buscar_año,buscar_mes;
        buscar_dia = txt_dia.getText().trim();
        buscar_año = txt_año.getText().trim();
        buscar_mes = txt_mes.getText().trim();
                
        model.setRowCount(0);
        model.setColumnCount(0); 
        
        if (bandera_año == 0 && bandera_dia == 0 && bandera_mes == 0) {
            JOptionPane.showMessageDialog(null, "para buscar nesecitas llenar los campos");
        } else if (bandera_dia == 2 && bandera_año == 0 && bandera_mes == 0) {
            try {
              Connection cn = Conexion.conectar();
              PreparedStatement pst = cn.prepareStatement(
                      "select * from insumos where dia = '" + buscar_dia + "'");
              ResultSet rs = pst.executeQuery();
              tabla_Ingresos = new JTable(model);
            jScroll_ingresos.setViewportView(tabla_Ingresos);
              
             model.addColumn(" ");
            model.addColumn("Insumo");
            model.addColumn("Dia");
            model.addColumn("Mes");
            model.addColumn("Año");
            model.addColumn("Precio");
              
            while(rs.next()){
                Object []fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            
            cn.close();
            
            } catch (SQLException ex) {
                System.err.println("error al buscar el dia");
            }
            
            maus();
            
        }else if (bandera_año == 1  && bandera_dia == 0 && bandera_mes == 0){
            
            try {
              Connection cn = Conexion.conectar();
              PreparedStatement pst = cn.prepareStatement(
                      "select * from insumos where año = '" + buscar_año + "'");
              ResultSet rs = pst.executeQuery();
              tabla_Ingresos = new JTable(model);
            jScroll_ingresos.setViewportView(tabla_Ingresos);
              
             model.addColumn(" ");
            model.addColumn("Insumo");
            model.addColumn("Dia");
            model.addColumn("Mes");
            model.addColumn("Año");
            model.addColumn("Precio");
              
            while(rs.next()){
                Object []fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            
            cn.close();
            
            } catch (SQLException ex) {
                System.err.println("error al buscar el año");
            }
             maus();
        }else if (bandera_mes == 4 && bandera_año == 0 && bandera_dia == 0){
            try {
              Connection cn = Conexion.conectar();
              PreparedStatement pst = cn.prepareStatement(
                      "select * from insumos where mes = '" + buscar_mes + "'");
              ResultSet rs = pst.executeQuery();
              tabla_Ingresos = new JTable(model);
            jScroll_ingresos.setViewportView(tabla_Ingresos);
              
             model.addColumn(" ");
            model.addColumn("Insumo");
            model.addColumn("Dia");
            model.addColumn("Mes");
            model.addColumn("Año");
            model.addColumn("Precio");
              
            while(rs.next()){
                Object []fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            
            cn.close();
            
            } catch (SQLException ex) {
                System.err.println("error al buscar el mes");
            }
             maus();
        }else if(bandera_año == 1 && bandera_mes == 4 && bandera_dia == 0){
            
             try {
              Connection cn = Conexion.conectar();
              PreparedStatement pst = cn.prepareStatement(
                      "select * from insumos where año = '" + buscar_año + "' and mes = '" + buscar_mes + "'");
              ResultSet rs = pst.executeQuery();
              tabla_Ingresos = new JTable(model);
            jScroll_ingresos.setViewportView(tabla_Ingresos);
              
             model.addColumn(" ");
            model.addColumn("Insumo");
            model.addColumn("Dia");
            model.addColumn("Mes");
            model.addColumn("Año");
            model.addColumn("Precio");
              
            while(rs.next()){
                Object []fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            
            cn.close();
            
            } catch (SQLException ex) {
                
                System.err.println("error al buscar el mes y año");
            }
        maus();
        }else if(bandera_año == 1 && bandera_mes == 4 && bandera_dia == 2){
            
             try {
              Connection cn = Conexion.conectar();
              PreparedStatement pst = cn.prepareStatement(
                      "select * from insumos where año = '" + buscar_año + "' and mes = '" + buscar_mes + "'" + "and dia = '" + buscar_dia + "'");
              ResultSet rs = pst.executeQuery();
              tabla_Ingresos = new JTable(model);
            jScroll_ingresos.setViewportView(tabla_Ingresos);
              
             model.addColumn(" ");
            model.addColumn("Insumo");
            model.addColumn("Dia");
            model.addColumn("Mes");
            model.addColumn("Año");
            model.addColumn("Precio");
              
            while(rs.next()){
                Object []fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            
            cn.close();
            
            } catch (SQLException ex) {
                
                System.err.println("error al buscar el mes y año y dia");
            }
              maus();
        }else if(bandera_año == 1 && bandera_mes == 0 && bandera_dia == 2){
            
             try {
              Connection cn = Conexion.conectar();
              PreparedStatement pst = cn.prepareStatement(
                      "select * from insumos where año = '" + buscar_año + "' and dia = '" + buscar_dia + "'");
              ResultSet rs = pst.executeQuery();
              tabla_Ingresos = new JTable(model);
            jScroll_ingresos.setViewportView(tabla_Ingresos);
              
             model.addColumn(" ");
            model.addColumn("Insumo");
            model.addColumn("Dia");
            model.addColumn("Mes");
            model.addColumn("Año");
            model.addColumn("Precio");
              
            while(rs.next()){
                Object []fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            
            cn.close();
            
            } catch (SQLException ex) {
                
                System.err.println("error al buscar el dia y año");
            }
              maus();
        }else if(bandera_año == 0 && bandera_mes == 4 && bandera_dia == 2){
            
             try {
              Connection cn = Conexion.conectar();
              PreparedStatement pst = cn.prepareStatement(
                      "select * from insumos where dia = '" + buscar_dia + "' and mes = '" + buscar_mes + "'");
              ResultSet rs = pst.executeQuery();
              tabla_Ingresos = new JTable(model);
            jScroll_ingresos.setViewportView(tabla_Ingresos);
              
             model.addColumn(" ");
            model.addColumn("Insumo");
            model.addColumn("Dia");
            model.addColumn("Mes");
            model.addColumn("Año");
            model.addColumn("Precio");
              
            while(rs.next()){
                Object []fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            
            cn.close();
            
            } catch (SQLException ex) {
                
                System.err.println("error al buscar el mes y dia");
            }
              maus();
        }else{
            JOptionPane.showMessageDialog(null, "error");
        }
    }//GEN-LAST:event_boton_buscarActionPerformed

    private void botton_MinimisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botton_MinimisarActionPerformed
        this.setState(Log_in.ICONIFIED);
    }//GEN-LAST:event_botton_MinimisarActionPerformed

    private void boton_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_boton_CerrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gestionar_insumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionar_insumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionar_insumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionar_insumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_insumos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Cerrar;
    private javax.swing.JButton boton_buscar;
    private javax.swing.JButton boton_editar;
    private javax.swing.JButton boton_editar1;
    private javax.swing.JButton boton_editar2;
    private javax.swing.JButton botton_Minimisar;
    private javax.swing.JLabel etiketa_Año;
    private javax.swing.JLabel etiketa_Fondo;
    private javax.swing.JLabel etiketa_Mes;
    private javax.swing.JLabel etiketa_dia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScroll_ingresos;
    private javax.swing.JTable tabla_Ingresos;
    private javax.swing.JTextField txt_año;
    private javax.swing.JTextField txt_dia;
    private javax.swing.JTextField txt_mes;
    // End of variables declaration//GEN-END:variables

    public void maus(){
        tabla_Ingresos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent  e){
            //filas
            int fila_point = tabla_Ingresos.rowAtPoint(e.getPoint());
            //columnas
            int columna_poin = 0;
            
            if(fila_point >-1){
                ID_insumo = (int)model.getValueAt(fila_point, columna_poin);
                Informacion_insumo mensajero = new Informacion_insumo();
                mensajero.setVisible(true);
                
                       
            }
        }
        });
    }
}
