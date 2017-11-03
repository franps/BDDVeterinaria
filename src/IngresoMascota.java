/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francisco.perdomo
 */
public class IngresoMascota extends javax.swing.JFrame {
    BaseDeDatos1 bdd = new BaseDeDatos1();
    public IngresoMascota() {
        
        initComponents();
    }
    
    public void imprimirResultados(ResultSet rs, int tipocons){
        try {
            String res="";
            if (tipocons ==0 && rs!=null){
                while (rs.next()) {
                    res += rs.getString(1)+ ", " 
                          +rs.getString(2)+ ", "
                          +rs.getString(3)+ ", "
                          +rs.getString(4)+ ", "
                          +rs.getString(5)+ ", "
                          +rs.getString(6)+ "\n";
                }
            }else{
                res = "Listo" ;
            }
            resultado.setText(res);
        } catch (SQLException ex) {
            Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean chequeoDatos(){
        boolean respuesta = true;
        limpiarErrores();
        try {      
            ResultSet rs = bdd.enviarConsulta("SELECT ci FROM Persona WHERE ci="+cidueño.getText());
            if (!rs.next()) {
                lerrorci.setText("Ese usuario no está en el sistema");
                respuesta = false;
            }
            rs = bdd.enviarConsulta("SELECT idmascota FROM Mascota WHERE idmascota="+idmascota.getText());
            if (rs.next()) {
                lerrormascota.setText("Ya hay una mascota con ese id");
                respuesta = false;
            }  
            rs = bdd.enviarConsulta("SELECT idraza FROM Raza WHERE idraza="+idraza.getText());
            if (!rs.next()) {
                lerrorraza.setText("No existe una raza con ese id");
                respuesta = false;
            } 
            rs = bdd.enviarConsulta("SELECT rut FROM Veterinaria WHERE rut="+rutvet.getText());
            if (!rs.next()) {
                lerrorvet.setText("No existe una veterinaria con ese RUT");
                respuesta = false;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    } 
    
    public void limpiarErrores(){
        lerrorci.setText("     ");
        lerrormascota.setText("     ");
        lerrorraza.setText("     ");
        lerrorvet.setText("     ");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        insertar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        idmascota = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextField();
        fechanac = new javax.swing.JFormattedTextField();
        idraza = new javax.swing.JTextField();
        rutvet = new javax.swing.JTextField();
        cidueño = new javax.swing.JTextField();
        lidmascota = new javax.swing.JLabel();
        lnombre = new javax.swing.JLabel();
        ldescripcion = new javax.swing.JLabel();
        lfechanac = new javax.swing.JLabel();
        lidraza = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lcidueño = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        lerrorci = new javax.swing.JLabel();
        lerrormascota = new javax.swing.JLabel();
        lerrorraza = new javax.swing.JLabel();
        lerrorvet = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        resultado.setColumns(20);
        resultado.setRows(5);
        jScrollPane1.setViewportView(resultado);

        insertar.setText("Ingresar Mascota");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });

        listar.setText("Listar Mascotas");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });

        nombre.setText("nombre");
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        idmascota.setText("idmascota");

        descripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        descripcion.setText("descripcion");

        try {
            fechanac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechanac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechanac.setText("01/01/2017");
        fechanac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechanacActionPerformed(evt);
            }
        });

        idraza.setText("idraza");

        rutvet.setText("rutvet");

        cidueño.setText("cidueño");
        cidueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidueñoActionPerformed(evt);
            }
        });

        lidmascota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lidmascota.setText("ID Mascota");

        lnombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lnombre.setText("Nombre");

        ldescripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ldescripcion.setText("Descripción");

        lfechanac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lfechanac.setText("Fecha Nacimiento");

        lidraza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lidraza.setText("ID Raza");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("RUT Veterinaria");

        lcidueño.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lcidueño.setText("CI Dueño");

        Titulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Titulo.setText("Ingresar Mascota");

        lerrorci.setForeground(new java.awt.Color(255, 0, 0));
        lerrorci.setText("          ");

        lerrormascota.setForeground(new java.awt.Color(255, 0, 0));
        lerrormascota.setText("          ");

        lerrorraza.setForeground(new java.awt.Color(255, 0, 0));
        lerrorraza.setText("          ");

        lerrorvet.setForeground(new java.awt.Color(255, 0, 0));
        lerrorvet.setText("          ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lidraza, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ldescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(idraza, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lidmascota, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Titulo)
                                            .addComponent(idmascota, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lcidueño, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(insertar)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(rutvet)
                                                .addComponent(cidueño, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lerrorci)
                                    .addComponent(lerrormascota)
                                    .addComponent(lerrorraza)
                                    .addComponent(lerrorvet)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lidmascota)
                    .addComponent(idmascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lerrormascota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idraza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lidraza)
                    .addComponent(lerrorraza))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lfechanac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ldescripcion)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lcidueño)
                    .addComponent(lerrorci))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutvet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lerrorvet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertar)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        ResultSet rs = bdd.enviarConsulta("SELECT * FROM mascota;");
        imprimirResultados(rs, 0);
    }//GEN-LAST:event_listarActionPerformed

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        boolean chequeo = chequeoDatos();
        if (chequeo){
            ResultSet rs = bdd.enviarConsulta("INSERT INTO mascota (idmascota, nombre, descripcion, fechanacimiento, id_raza, rut_veterinaria) VALUES "
                        + "("+ idmascota.getText() +","
                        + "'"+ nombre.getText() +"',"
                        + "'"+ descripcion.getText() +"',"
                        + "'"+ fechanac.getText() +"',"
                        + idraza.getText() +","
                        + rutvet.getText() +");");
            rs = bdd.enviarConsulta("INSERT INTO dueñomascota(ci_dueño,id_mascota) VALUES ("
                    + cidueño.getText() + ","
                    + idmascota.getText() +");");
            limpiarErrores();
            imprimirResultados(rs, 1);
        }


    }//GEN-LAST:event_insertarActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void fechanacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechanacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechanacActionPerformed

    private void cidueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidueñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidueñoActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoMascota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField cidueño;
    private javax.swing.JTextField descripcion;
    private javax.swing.JFormattedTextField fechanac;
    private javax.swing.JTextField idmascota;
    private javax.swing.JTextField idraza;
    private javax.swing.JButton insertar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lcidueño;
    private javax.swing.JLabel ldescripcion;
    private javax.swing.JLabel lerrorci;
    private javax.swing.JLabel lerrormascota;
    private javax.swing.JLabel lerrorraza;
    private javax.swing.JLabel lerrorvet;
    private javax.swing.JLabel lfechanac;
    private javax.swing.JLabel lidmascota;
    private javax.swing.JLabel lidraza;
    private javax.swing.JButton listar;
    private javax.swing.JLabel lnombre;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextArea resultado;
    private javax.swing.JTextField rutvet;
    // End of variables declaration//GEN-END:variables
}
