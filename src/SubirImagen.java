
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


/**
 *
 * @author francisco.perdomo
 */
public class SubirImagen extends javax.swing.JFrame {
    int idMascota=0;
    
    public SubirImagen() {
        initComponents();
    }
    public SubirImagen(int idm) {
        initComponents();
        idMascota = idm;
        idlabel.setText(idm+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subir = new javax.swing.JToggleButton();
        imagen1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idlabel = new javax.swing.JLabel();
        lIDMascota = new javax.swing.JLabel();
        listo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        subir.setText("Subir imagen");
        subir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirActionPerformed(evt);
            }
        });

        imagen1.setBackground(new java.awt.Color(255, 255, 255));
        imagen1.setText("      ");
        imagen1.setMaximumSize(new java.awt.Dimension(200, 200));
        imagen1.setMinimumSize(new java.awt.Dimension(200, 200));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Subir Foto de Mascota");

        idlabel.setText("     ");

        lIDMascota.setText("ID Mascota:");

        listo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listo.setForeground(new java.awt.Color(0, 255, 51));
        listo.setText("        ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(lIDMascota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idlabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(subir)
                                .addGap(28, 28, 28)
                                .addComponent(listo))
                            .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lIDMascota)
                    .addComponent(idlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subir)
                    .addComponent(listo))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(imagen1);
        try {
            Connection con = null;
            Class.forName("org.postgresql.Driver").newInstance();
            // Obtiene una conexión a la base de datos
            con = DriverManager.getConnection("jdbc:postgresql://192.168.56.101:5432/postgres","postgres","a");
            if (!con.isClosed()){
                System.out.println("Successfully connected to MySQL server using TCP/IP...");
            }

            File file = fc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            PreparedStatement ps = con.prepareStatement("INSERT INTO imagen VALUES ("+idMascota+", ?)");
            ps.setBinaryStream(1, fis, (int)file.length());
            ps.executeUpdate();
            ps.close();
            PreparedStatement ps2 = con.prepareStatement("SELECT imagen FROM imagen WHERE id = "+idMascota);
            //ps.setString(2, "perro.jpg");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                byte[] imgBytes = rs.getBytes(1);
                imagen1.setIcon(new ImageIcon(imgBytes));
            }
            ps2.close();
            rs.close();
            fis.close();
            listo.setText("Foto agregada correctamente");
            subir.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(SubirImagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SubirImagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubirImagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SubirImagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SubirImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_subirActionPerformed

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
            java.util.logging.Logger.getLogger(SubirImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubirImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubirImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubirImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubirImagen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idlabel;
    private javax.swing.JLabel imagen1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lIDMascota;
    private javax.swing.JLabel listo;
    private javax.swing.JToggleButton subir;
    // End of variables declaration//GEN-END:variables
}
