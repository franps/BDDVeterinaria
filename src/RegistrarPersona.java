
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author francisco.perdomo
 */
public class RegistrarPersona extends javax.swing.JFrame {
    BaseDeDatos1 bdd = new BaseDeDatos1();
    
    public RegistrarPersona() {
        initComponents();
    }

   public boolean chequeoDatos(){
        boolean respuesta = true;
        limpiarErrores();
        try {  
            if (ci.getText().compareTo("")==0) {
                lerrci.setText("Este campo no puede ser vacío");
                respuesta = false;
            }
            if (nom.getText().compareTo("")==0) {
                lerrnom.setText("Este campo no puede ser vacío");
                respuesta = false;
            }             
            if (tel.getText().compareTo("")==0) {
                lerrtel.setText("Este campo no puede ser vacío");
                respuesta = false;
            }             
            if (dir.getText().compareTo("")==0) {
                lerrdir.setText("Este campo no puede ser vacío");
                respuesta = false;
            } 
            if (respuesta){
                ResultSet rs = bdd.enviarConsulta("SELECT ci FROM Persona WHERE ci="+ci.getText());
                if (rs.next()) {
                    lerrci.setText("Ya existe un usuario con esa CI");
                    respuesta = false;
                }      
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    } 
    
    public void limpiarErrores(){
        lerrci.setText("     ");
        lerrnom.setText("     ");
        lerrtel.setText("     ");
        lerrdir.setText("     ");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        titulo = new javax.swing.JLabel();
        ci = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        telalt = new javax.swing.JTextField();
        dir = new javax.swing.JTextField();
        lci = new javax.swing.JLabel();
        lnom = new javax.swing.JLabel();
        ltel = new javax.swing.JLabel();
        ltelalt = new javax.swing.JLabel();
        ldir = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lerrci = new javax.swing.JLabel();
        lerrtel = new javax.swing.JLabel();
        lerrnom = new javax.swing.JLabel();
        lerrdir = new javax.swing.JLabel();
        ast = new javax.swing.JLabel();
        ast1 = new javax.swing.JLabel();
        ast2 = new javax.swing.JLabel();
        ast3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        titulo.setText("Registrar Persona");

        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });

        telalt.setText(" ");

        dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirActionPerformed(evt);
            }
        });

        lci.setText("CI:");

        lnom.setText("Nombre:");

        ltel.setText("Teléfono:");

        ltelalt.setText("Teléfono alt:");

        ldir.setText("Dirección:");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lerrci.setForeground(new java.awt.Color(255, 0, 0));

        lerrtel.setForeground(new java.awt.Color(255, 0, 0));

        lerrnom.setForeground(new java.awt.Color(255, 0, 0));

        lerrdir.setForeground(new java.awt.Color(255, 0, 0));

        ast.setForeground(new java.awt.Color(255, 0, 0));
        ast.setText("*");

        ast1.setForeground(new java.awt.Color(255, 0, 0));
        ast1.setText("*");

        ast2.setForeground(new java.awt.Color(255, 0, 0));
        ast2.setText("*");

        ast3.setForeground(new java.awt.Color(255, 0, 0));
        ast3.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lci)
                                    .addComponent(lnom)
                                    .addComponent(ltel)
                                    .addComponent(ldir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ast)
                                    .addComponent(ast1)
                                    .addComponent(ast2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ast3, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ltelalt)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(telalt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ci, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lerrnom, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(lerrci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lerrdir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lerrtel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lci)
                    .addComponent(lerrci, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnom)
                            .addComponent(ast1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ltel)
                                .addComponent(ast2))
                            .addComponent(lerrtel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telalt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ltelalt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ldir)
                                .addComponent(ast3))
                            .addComponent(lerrdir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lerrnom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        chequeoDatos();
        bdd.enviarConsulta("insert into persona (ci,nombre,telefono,telefonoalternativo,direccion) values("
            + ci.getText()+",'"
            + nom.getText()+"',"
            + tel.getText()+","
            + telalt.getText()+",'"
            + dir.getText()
            + "')");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ast;
    private javax.swing.JLabel ast1;
    private javax.swing.JLabel ast2;
    private javax.swing.JLabel ast3;
    private javax.swing.JTextField ci;
    private javax.swing.JTextField dir;
    private javax.swing.JButton jButton1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lci;
    private javax.swing.JLabel ldir;
    private javax.swing.JLabel lerrci;
    private javax.swing.JLabel lerrdir;
    private javax.swing.JLabel lerrnom;
    private javax.swing.JLabel lerrtel;
    private javax.swing.JLabel lnom;
    private javax.swing.JLabel ltel;
    private javax.swing.JLabel ltelalt;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField tel;
    private javax.swing.JTextField telalt;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
