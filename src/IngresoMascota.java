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
        Fondo = new javax.swing.JPanel();
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
        lFondo = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Fondo.setLayout(null);

        resultado.setColumns(20);
        resultado.setRows(5);
        jScrollPane1.setViewportView(resultado);

        Fondo.add(jScrollPane1);
        jScrollPane1.setBounds(10, 384, 641, 96);

        insertar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        insertar.setText("Ingresar Mascota");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        Fondo.add(insertar);
        insertar.setBounds(150, 350, 129, 23);

        listar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        listar.setText("Listar Mascotas");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        Fondo.add(listar);
        listar.setBounds(194, 486, 129, 23);

        nombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        nombre.setText("nombre");
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        Fondo.add(nombre);
        nombre.setBounds(134, 51, 200, 20);

        idmascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        idmascota.setText("nroChip");
        Fondo.add(idmascota);
        idmascota.setBounds(133, 229, 200, 20);

        descripcion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        descripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        descripcion.setText("descripcion");
        Fondo.add(descripcion);
        descripcion.setBounds(134, 132, 200, 86);

        try {
            fechanac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechanac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechanac.setText("01/01/2017");
        fechanac.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        fechanac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechanacActionPerformed(evt);
            }
        });
        Fondo.add(fechanac);
        fechanac.setBounds(134, 104, 79, 20);

        rutvet.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        rutvet.setText("rutvet");
        Fondo.add(rutvet);
        rutvet.setBounds(130, 290, 200, 20);

        cidueño.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        cidueño.setText("cidueño");
        cidueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidueñoActionPerformed(evt);
            }
        });
        Fondo.add(cidueño);
        cidueño.setBounds(133, 261, 200, 20);

        lidmascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lidmascota.setForeground(new java.awt.Color(0, 78, 150));
        lidmascota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lidmascota.setText("Nro Chip");
        Fondo.add(lidmascota);
        lidmascota.setBounds(51, 232, 78, 14);

        lnombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lnombre.setForeground(new java.awt.Color(0, 78, 150));
        lnombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lnombre.setText("Nombre");
        Fondo.add(lnombre);
        lnombre.setBounds(52, 54, 78, 14);

        ldescripcion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        ldescripcion.setForeground(new java.awt.Color(0, 78, 150));
        ldescripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ldescripcion.setText("Descripción");
        Fondo.add(ldescripcion);
        ldescripcion.setBounds(44, 132, 78, 14);

        lfechanac.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lfechanac.setForeground(new java.awt.Color(0, 78, 150));
        lfechanac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lfechanac.setText("Fecha Nacimiento");
        Fondo.add(lfechanac);
        lfechanac.setBounds(10, 107, 120, 14);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 78, 150));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("RUT Veterinaria");
        Fondo.add(jLabel1);
        jLabel1.setBounds(35, 290, 94, 14);

        lcidueño.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lcidueño.setForeground(new java.awt.Color(0, 78, 150));
        lcidueño.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lcidueño.setText("CI Dueño");
        Fondo.add(lcidueño);
        lcidueño.setBounds(41, 264, 88, 14);

        Titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 78, 150));
        Titulo.setText("Ingresar Mascota");
        Fondo.add(Titulo);
        Titulo.setBounds(134, 11, 206, 29);

        lerrorci.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrorci.setForeground(new java.awt.Color(255, 0, 0));
        lerrorci.setText("          ");
        Fondo.add(lerrorci);
        lerrorci.setBounds(337, 264, 30, 14);

        lerrormascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrormascota.setForeground(new java.awt.Color(255, 0, 0));
        lerrormascota.setText("          ");
        Fondo.add(lerrormascota);
        lerrormascota.setBounds(337, 232, 30, 14);

        lerrorvet.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrorvet.setForeground(new java.awt.Color(255, 0, 0));
        lerrorvet.setText("          ");
        Fondo.add(lerrorvet);
        lerrorvet.setBounds(337, 290, 30, 14);

        tipoAnimal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        tipoAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perro", "Gato" }));
        tipoAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAnimalActionPerformed(evt);
            }
        });
        Fondo.add(tipoAnimal);
        tipoAnimal.setBounds(134, 78, 79, 20);

        raza.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        raza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Labrador", "Huskie", "Chihuahua" }));
        Fondo.add(raza);
        raza.setBounds(219, 78, 87, 20);

        agregarImagen.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        agregarImagen.setText("Quiere agregar foto de la mascota?");
        Fondo.add(agregarImagen);
        agregarImagen.setBounds(130, 320, 223, 23);

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoMasc.jpg"))); // NOI18N
        lFondo.setText("   ");
        Fondo.add(lFondo);
        lFondo.setBounds(0, 0, 660, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
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
    private javax.swing.JPanel Fondo;
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
    private javax.swing.JLabel lFondo;
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
