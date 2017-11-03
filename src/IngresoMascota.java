/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

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
        lerrorvet.setText("     ");
    }
    
    private void llenarComboBoxes(int i){
        raza.removeItemAt(2);
        raza.removeItemAt(1);
        raza.removeItemAt(0);
        if (i==0){
            raza.insertItemAt("Labrador", 0);
            raza.insertItemAt("Husky", 1);
            raza.insertItemAt("Chihuahua", 2);
        }
        else {
            raza.insertItemAt("Persa", 0);
            raza.insertItemAt("Siamés", 1);
            raza.insertItemAt("Snowshoe", 2);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        insertar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        idmascota = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextField();
        fechanac = new javax.swing.JFormattedTextField();
        rutvet = new javax.swing.JTextField();
        cidueño = new javax.swing.JTextField();
        lidmascota = new javax.swing.JLabel();
        lnombre = new javax.swing.JLabel();
        ldescripcion = new javax.swing.JLabel();
        lfechanac = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lcidueño = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        lerrorci = new javax.swing.JLabel();
        lerrormascota = new javax.swing.JLabel();
        lerrorvet = new javax.swing.JLabel();
        tipoAnimal = new javax.swing.JComboBox<>();
        raza = new javax.swing.JComboBox<>();
        agregarImagen = new javax.swing.JCheckBox();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

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

        idmascota.setText("nroChip");

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

        rutvet.setText("rutvet");

        cidueño.setText("cidueño");
        cidueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidueñoActionPerformed(evt);
            }
        });

        lidmascota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lidmascota.setText("Nro Chip");

        lnombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lnombre.setText("Nombre");

        ldescripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ldescripcion.setText("Descripción");

        lfechanac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lfechanac.setText("Fecha Nacimiento");

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

        lerrorvet.setForeground(new java.awt.Color(255, 0, 0));
        lerrorvet.setText("          ");

        tipoAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perro", "Gato" }));
        tipoAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAnimalActionPerformed(evt);
            }
        });

        raza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Labrador", "Huskie", "Chihuahua" }));

        agregarImagen.setText("Quiere agregar foto de la mascota?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ldescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(Titulo))
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tipoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(raza, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lcidueño, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lidmascota, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rutvet)
                                .addComponent(cidueño, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(idmascota, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregarImagen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lerrorci)
                            .addComponent(lerrorvet)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lerrormascota))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(insertar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Titulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnombre))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lfechanac)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ldescripcion)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lerrormascota)
                        .addGap(18, 18, 18)
                        .addComponent(lerrorci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lerrorvet))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idmascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lidmascota))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cidueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lcidueño))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rutvet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(agregarImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            int razas = (tipoAnimal.getSelectedIndex()+1)*(raza.getSelectedIndex()+1)-1;
            ResultSet rs = bdd.enviarConsulta("INSERT INTO mascota (idmascota, nombre, descripcion, fechanacimiento, id_raza, rut_veterinaria) VALUES "
                        + "("+ idmascota.getText() +","
                        + "'"+ nombre.getText() +"',"
                        + "'"+ descripcion.getText() +"',"
                        + "'"+ fechanac.getText() +"',"
                        +  razas +","
                        + rutvet.getText() +");");
            rs = bdd.enviarConsulta("INSERT INTO dueñomascota(ci_dueño,id_mascota) VALUES ("
                    + cidueño.getText() + ","
                    + idmascota.getText() +");");
            limpiarErrores();
            imprimirResultados(rs, 1);
            if (agregarImagen.isSelected()){
                int id = Integer.parseInt(idmascota.getText());
                System.out.println("Creando la ventana con el id: "+id);
                new SubirImagen(id).setVisible(true);
            }
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

    private void tipoAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAnimalActionPerformed
        llenarComboBoxes(tipoAnimal.getSelectedIndex());
    }//GEN-LAST:event_tipoAnimalActionPerformed

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
    private javax.swing.JCheckBox agregarImagen;
    private javax.swing.JTextField cidueño;
    private javax.swing.JTextField descripcion;
    private javax.swing.JFormattedTextField fechanac;
    private javax.swing.JTextField idmascota;
    private javax.swing.JButton insertar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lcidueño;
    private javax.swing.JLabel ldescripcion;
    private javax.swing.JLabel lerrorci;
    private javax.swing.JLabel lerrormascota;
    private javax.swing.JLabel lerrorvet;
    private javax.swing.JLabel lfechanac;
    private javax.swing.JLabel lidmascota;
    private javax.swing.JButton listar;
    private javax.swing.JLabel lnombre;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> raza;
    private javax.swing.JTextArea resultado;
    private javax.swing.JTextField rutvet;
    private javax.swing.JComboBox<String> tipoAnimal;
    // End of variables declaration//GEN-END:variables
}
