/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexion;
import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static javax.swing.text.html.HTML.Attribute.ID;

/**
 *
 * @author user
 */
public class Nuevo_Usuario extends javax.swing.JFrame {

    String nombre, username, contraseña, nivel;

    /**
     * Creates new form Nuevo_Usuario
     */
    public Nuevo_Usuario() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Logo Final.png")));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(638, 474);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_nivel = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_contraseña = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        etiketa_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nivel:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Eras Demi ITC", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nuevo Usuario.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre completo del usuario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre para iniciar secion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        cmb_nivel.setBackground(new java.awt.Color(0, 0, 0));
        cmb_nivel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmb_nivel.setForeground(new java.awt.Color(255, 255, 255));
        cmb_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Medio" }));
        getContentPane().add(cmb_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 170, 40));

        jLabel5.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo usuario1.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo usuario.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 234, 140, -1));

        txt_contraseña.setBackground(new java.awt.Color(0, 0, 0));
        txt_contraseña.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        txt_contraseña.setForeground(new java.awt.Color(255, 255, 255));
        txt_contraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contraseña.setToolTipText("");
        txt_contraseña.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 260, 60));

        txt_nombre.setBackground(new java.awt.Color(0, 0, 0));
        txt_nombre.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setToolTipText("");
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 320, 60));

        txt_username.setBackground(new java.awt.Color(0, 0, 0));
        txt_username.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setToolTipText("");
        txt_username.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 200, 60));

        etiketa_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_NU.png"))); // NOI18N
        getContentPane().add(etiketa_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 638, 474));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nombre = txt_nombre.getText().trim();
        contraseña = txt_contraseña.getText().trim();
        username = txt_username.getText().trim();
        nivel = cmb_nivel.getSelectedItem().toString();

        if (nombre.equals("") && contraseña.equals("") && username.equals("")) {
            JOptionPane.showMessageDialog(null, "si deseas insertar un usuario deves llenar los cmpos");
        } else {
            try {

                java.sql.Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("INSERT INTO usuarios values (?,?,?,?,?)");
                pst.setInt(1, 0);
                pst.setString(2, nombre);
                pst.setString(3, username);
                pst.setString(4, contraseña);
                pst.setString(5, nivel);

                pst.executeUpdate();
                cn.close();
                JOptionPane.showMessageDialog(null, " El usuario " + username + " se inserto correctamente ");
                this.dispose();

            } catch (Exception e) {
                System.err.println("error");
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Nuevo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nuevo_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_nivel;
    private javax.swing.JLabel etiketa_Fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_contraseña;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
