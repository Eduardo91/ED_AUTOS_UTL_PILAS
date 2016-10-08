package ed_pilas_autos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class vista extends javax.swing.JFrame {

    Pila_Auto estacionamiento1 = new Pila_Auto();
    Pila_Auto estacionamiento2 = new Pila_Auto();
    DefaultTableModel mitabla;

    public vista() {
        initComponents();

    }

    public void limpiar() {
        jTextFieldPlaca.setText(null);
        jTextFieldMarca.setText(null);
        jTextFieldModelo.setText(null);
        jTextFieldHoraEntrada.setText(null);        
        jTextFieldCostoPorHora.setText(null);
        jTextFieldPlaca.requestFocus();
    }

    public void agregar() {
        ClassAuto au = new ClassAuto();
        au.setPlaca(Integer.parseInt(jTextFieldPlaca.getText()));
        au.setMarca(jTextFieldMarca.getText());
        au.setModelo(jTextFieldModelo.getText());
        au.setHoraEntrada(Integer.parseInt(jTextFieldHoraEntrada.getText()));
        au.setCostoPorHora(Double.parseDouble(jTextFieldCostoPorHora.getText()));
        estacionamiento1.push(au);
        jLabelMensaje.setText("AUTO CON PLACAS " + estacionamiento1.cima.info.getPlaca() + " INGRESADO AL ESTACIONAMIENTO 1");
    }

    public void sacarAuto() {
        if (!estacionamiento1.vacia()) {
            int ValB;
            int valorCima;
            do {
                ValB = Integer.parseInt(jTextFieldSacar.getText());
                valorCima = estacionamiento1.cima.info.getPlaca();
                if (valorCima != ValB) {
                    estacionamiento2.push(estacionamiento1.cima.info);
                    estacionamiento1.pop();
                }
                if (valorCima == ValB) {
                    jTextFieldPlaca.setText(String.valueOf(estacionamiento1.cima.info.getPlaca()));
                    jTextFieldMarca.setText(estacionamiento1.cima.info.getMarca());
                    jTextFieldModelo.setText(estacionamiento1.cima.info.getModelo());
                    jTextFieldHoraEntrada.setText(String.valueOf(estacionamiento1.cima.info.getHoraEntrada()));
                    jTextFieldCostoPorHora.setText(String.valueOf(estacionamiento1.cima.info.getCostoPorHora()));
                    
                    int horaEntrada=Integer.parseInt(jTextFieldHoraEntrada.getText());
                    double costo=Double.parseDouble(jTextFieldCostoPorHora.getText());
                    int horaSalida = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA HORA DE SALIDA"));
                    int totalHoras = horaSalida - horaEntrada;
                    
                    double superTotal=totalHoras*costo;
                    jTextFieldTotal.setText(String.valueOf(superTotal));
                    JOptionPane.showMessageDialog(null, "EL TOTAL A PAGAR ES"+superTotal);
                    JOptionPane.showMessageDialog(null, "SE SACARA EL AUTO CON PLACAS:" + estacionamiento1.cima.info.getPlaca());
                    estacionamiento1.pop();
                    limpiar();
                }
            } while (ValB != valorCima);
        } else {
            JOptionPane.showMessageDialog(null, "No hay autos en el estacionamiento 1");
        }
    }
    public void imprimirEstacionamiento1EnTexArea(){
        jTextAreaEstacionamiento1.setText(null);
        jTextAreaEstacionamiento1.append(String.valueOf(estacionamiento1.cima.info.getPlaca())+
                    "   "+estacionamiento1.cima.info.getMarca()+"   "
                         +estacionamiento1.cima.info.getModelo()+"  "
                         +estacionamiento1.cima.info.getHoraEntrada()+" "
                        +estacionamiento1.cima.info.getCostoPorHora()+"\n");
            estacionamiento1.cima=estacionamiento1.cima.anterior;
    }
    public void imprimirEstacionamiento2EnTexArea(){
        jTextAreaEstacionamiento1.setText(null);
        jTextAreaEstacionamiento1.append(String.valueOf(estacionamiento2.cima.info.getPlaca())+
                    "   "+estacionamiento2.cima.info.getMarca()+"   "
                         +estacionamiento2.cima.info.getModelo()+"  "
                         +estacionamiento2.cima.info.getHoraEntrada()+" "
                        +estacionamiento2.cima.info.getCostoPorHora()+"\n");
            estacionamiento2.cima=estacionamiento2.cima.anterior;
    }
    public void mostrarAutosDeEstacionamiento1() {
        if (!estacionamiento1.vacia()){
            System.out.println("AUTOS DE ESTACIONAMIENTO 1");
            estacionamiento1.imprimir();
            System.out.println();
        } else {
            jLabelMensaje.setText("EL ESTACIONAMIENTO 1 ESTA VACIO");
        }
    }
    public void regresarAuutos(){
        if (!estacionamiento2.vacia()) {
                        do {
                            estacionamiento1.push(estacionamiento2.cima.info);
                            estacionamiento2.pop();
                        } while (!estacionamiento2.vacia());
                    }else{
                        JOptionPane.showMessageDialog(null, "NO AUTOS QUE REGRESAR");
                    }
    }
    public void mostrarAutosEstacionamiento2() {
        if (!estacionamiento2.vacia()) {
            System.out.println("AUTOS DE ESTACIONAMIENTO 2");
            estacionamiento2.imprimir();
        } else {
            jLabelMensaje.setText("EL ESTACIONAMIENTO 2 ESTA VACIO");
        }
    }
    public void limpiarTodo(){
        if (!estacionamiento1.vacia()){
                        do {
                            estacionamiento1.pop();
                        } while (!estacionamiento1.vacia());
                    if (!estacionamiento2.vacia()) {
                         do {
                            estacionamiento2.pop();
                        } while (!estacionamiento2.vacia());
                           
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"LOS ESTACIONAMIENTOS ESTAN VACIOS");
                    } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldPlaca = new javax.swing.JTextField();
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldHoraEntrada = new javax.swing.JTextField();
        jTextFieldCostoPorHora = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jTextFieldSacar = new javax.swing.JTextField();
        jButtonSacar = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabelMensaje = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextFieldTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEstacionamiento1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);
        jPanel1.add(jTextFieldPlaca);
        jTextFieldPlaca.setBounds(20, 20, 160, 30);
        jPanel1.add(jTextFieldMarca);
        jTextFieldMarca.setBounds(20, 80, 160, 30);
        jPanel1.add(jTextFieldModelo);
        jTextFieldModelo.setBounds(20, 140, 160, 30);
        jPanel1.add(jTextFieldHoraEntrada);
        jTextFieldHoraEntrada.setBounds(20, 200, 160, 30);
        jPanel1.add(jTextFieldCostoPorHora);
        jTextFieldCostoPorHora.setBounds(20, 270, 160, 30);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregar);
        jButtonAgregar.setBounds(20, 330, 160, 30);
        jPanel1.add(jTextFieldSacar);
        jTextFieldSacar.setBounds(240, 320, 110, 30);

        jButtonSacar.setText("Sacar");
        jButtonSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSacar);
        jButtonSacar.setBounds(360, 320, 100, 30);

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegresar);
        jButtonRegresar.setBounds(710, 320, 120, 30);

        jButton1.setText("Sacar todo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(840, 320, 120, 30);

        jLabelMensaje.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabelMensaje.setForeground(new java.awt.Color(0, 204, 204));
        jLabelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensaje.setOpaque(true);
        jPanel1.add(jLabelMensaje);
        jLabelMensaje.setBounds(20, 420, 940, 40);

        jButton2.setText("MostrarE1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(470, 320, 110, 30);

        jButton3.setText("MostrarE2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(590, 320, 110, 30);

        jTextFieldTotal.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jTextFieldTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldTotal);
        jTextFieldTotal.setBounds(20, 480, 150, 50);

        jTextAreaEstacionamiento1.setColumns(20);
        jTextAreaEstacionamiento1.setRows(5);
        jScrollPane1.setViewportView(jTextAreaEstacionamiento1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(240, 20, 700, 120);

        jLabel1.setText("PLACAS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 0, 110, 15);

        jLabel2.setText("MARCA");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 60, 130, 15);

        jLabel3.setText("MODELO");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 120, 160, 15);

        jLabel4.setText("HORA ENTRADA");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 180, 140, 15);

        jLabel6.setText("COSTO POR HORA");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 250, 150, 15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        //AGREGAR
        try {
            agregar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Erroe en agregar\n" + e);
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // REGRESAR
        regresarAuutos();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // MOSTAR E1
        try {
            mostrarAutosDeEstacionamiento1();
        } catch (Exception e){
            System.out.println("Error al mostrar E1\n" + e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // MOSTRAR E2;
        try {
            mostrarAutosEstacionamiento2();
        } catch (Exception e) {System.out.println("Error en mostrar E2\n"+e);}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // SACAR TODO
        try {
        limpiarTodo();    
        } catch (Exception e) {System.out.println("Error en sacar todo");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacarActionPerformed
        // SACAR AUTO
        try {
            int valorBuscado = Integer.parseInt(jTextFieldSacar.getText());
            sacarAuto();
        } catch (Exception e) {
            System.out.println("Error en sacar auto\n" + e);
        }
    }//GEN-LAST:event_jButtonSacarActionPerformed

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
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonSacar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextAreaEstacionamiento1;
    private javax.swing.JTextField jTextFieldCostoPorHora;
    private javax.swing.JTextField jTextFieldHoraEntrada;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPlaca;
    private javax.swing.JTextField jTextFieldSacar;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
