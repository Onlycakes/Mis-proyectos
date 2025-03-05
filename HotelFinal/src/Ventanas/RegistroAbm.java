
package Ventanas;
import DAO.PasajerosDao;
import Entities.Pasajeros;
import Excepciones.DuplicateEntryException;
import Excepciones.NotFoundException;
import businessLogic.Validator;
import data.ConexionBDD;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PasajerosTableModel;

public class RegistroAbm extends javax.swing.JFrame {
private Long dni, telefono;
private String nombresStr, apellidosStr, dniStr, telefonoStr, mailStr;
private static PasajerosTableModel tablaPasajeros;
private PasajerosDao pasajerosDao;
private Pasajeros pasajeroNuevo;
private Pasajeros pasajeroEdit; 


    public RegistroAbm() throws SQLException {
       initComponents();
         Connection connection = null;
        try {
            connection = ConexionBDD.getConnection(); 
            pasajerosDao = new PasajerosDao(connection);          
            tablaPasajeros = new PasajerosTableModel((ArrayList<Pasajeros>) pasajerosDao.listAll());
             
            } catch (SQLException e) {
            Logger.getLogger(Pasajeros.class.getName()).log(Level.SEVERE, null, e);
         
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close(); 
            }
           jTable1.setModel(tablaPasajeros);  
    }
         
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        personLbl = new javax.swing.JLabel();
        nombreLbl = new javax.swing.JLabel();
        apellidoLbl = new javax.swing.JLabel();
        NombreTextF = new javax.swing.JTextField();
        apellidoTextF = new javax.swing.JTextField();
        dniLbl = new javax.swing.JLabel();
        mailLbl = new javax.swing.JLabel();
        dniTextF = new javax.swing.JTextField();
        mailTextF = new javax.swing.JTextField();
        GuardarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        telefonoLbl = new javax.swing.JLabel();
        telefonoTextF = new javax.swing.JTextField();
        nuevoButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido", "Dni", "Mail", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        personLbl.setText("Registro");

        nombreLbl.setText("Nombre");

        apellidoLbl.setText("Apellido");

        NombreTextF.setToolTipText("Nombre a mostrar");

        dniLbl.setText("DNI");

        mailLbl.setText("Mail");

        GuardarButton.setText("Agregar");
        GuardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        telefonoLbl.setText("Telefono");

        nuevoButton.setText("Nuevo");

        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Reservas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(editarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(eliminarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                    .addComponent(nuevoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(GuardarButton)
                                .addGap(30, 30, 30)
                                .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(personLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 491, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombreLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addComponent(apellidoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dniLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mailLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NombreTextF, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(apellidoTextF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(dniTextF)
                            .addComponent(mailTextF)
                            .addComponent(telefonoTextF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(personLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLbl)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoLbl)
                    .addComponent(apellidoTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniLbl)
                    .addComponent(dniTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailLbl)
                    .addComponent(mailTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefonoTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoLbl))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarButton)
                    .addComponent(cancelarButton))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(nuevoButton)
                        .addGap(18, 18, 18)
                        .addComponent(editarButton)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarButton)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            ReservasAbm res = new ReservasAbm();
            res.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void GuardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarButtonActionPerformed
        
        if (!validarCampos()) {
        return; 
    }
    try {
        cargaPasajero();
    } catch (DuplicateEntryException ex) {
        Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
    }      
        
    }//GEN-LAST:event_GuardarButtonActionPerformed

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
       
    Long id;
    Connection conexion;
    PasajerosDao pasDao;
    int fila = jTable1.getSelectedRow();
    if (fila >= 0) {
        try {
            conexion = ConexionBDD.getConnection();
            pasDao = new PasajerosDao(conexion);
            pasajeroEdit = pasDao.listAll().get(fila);
            id=pasajeroEdit.getIdPasajero();
            setCampos(pasajeroEdit);

            editarButton.setText("Guardar"); 
            GuardarButton.setEnabled(false);
            
                
                editarButton.addActionListener(new ActionListener() {//
                @Override//
                public void actionPerformed(ActionEvent e) {
                    if (editarButton.getText().equals("Guardar")) {
                        if (!validarCampos()) {
                            return;
                        }
                        try {   
                            pasajeroEdit=modificaPasajero(); 
                            if (pasajeroEdit == null) {
                                return; 
                            }
                            if (pasajeroEdit.validaDni(pasajeroEdit.getDni())&&pasajeroEdit.validaTelefono(pasajeroEdit.getTelefono())
                            &&pasajeroEdit.validaEmail(pasajeroEdit.getEmail())) {
                   
                            pasDao.pasajeroDuplicado(pasajeroEdit.getNombre(), pasajeroEdit.getApellido(), pasajeroEdit.getDni(), id);
        
                            String idS = String.valueOf(id);
                            int idL = Integer.parseInt(idS);
                            pasDao.update(pasajeroEdit, idL);
                            
                             List <Pasajeros> actual = new ArrayList <> (pasDao.listAll());
                             tablaPasajeros = new PasajerosTableModel ((ArrayList<Pasajeros>) actual);
                             jTable1.setModel(tablaPasajeros);
                            
                            JOptionPane.showMessageDialog(null, "Pasajero exitosamente actualizado");
                            limpiarCampos();}
                            else JOptionPane.showMessageDialog(null, "Error");
                        } catch (DuplicateEntryException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
                
                        } catch (NotFoundException  ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            try {
                                if (conexion != null && !conexion.isClosed()) {
                                    conexion.close();
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    GuardarButton.setEnabled(true);
                    editarButton.setText("Modificar");    
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    }//GEN-LAST:event_editarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed

        PasajerosDao pasDaoE;
        Connection connection= null;
        Pasajeros pasajeroD;
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
        try {
               connection = ConexionBDD.getConnection(); 
               pasDaoE = new PasajerosDao(connection);
               pasajeroD = pasDaoE.listAll().get(fila);
               Long idL=pasajeroD.getIdPasajero();
               String idS = String.valueOf(idL);
               int idI = Integer.parseInt(idS);
               pasDaoE.deshabilitarPasajero(idI);
               
               List <Pasajeros> actual = new ArrayList <> (pasDaoE.listAll());
               tablaPasajeros = new PasajerosTableModel ((ArrayList<Pasajeros>) actual);
               jTable1.setModel(tablaPasajeros);
               JOptionPane.showMessageDialog(this, "Pasajero eliminado.");
              
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this, ex.getMessage());
               Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
           } catch (NotFoundException ex) {
               JOptionPane.showMessageDialog(this, ex.getMessage());
               Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
           }    
             finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }   } catch (SQLException ex) {
                    Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
                }
        } 
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    
    private boolean validarCampos() { 
    if (!Validator.isValidName(NombreTextF) || !Validator.isValidName(apellidoTextF)) {
        JOptionPane.showMessageDialog(this, "Campos nombres y/o apellidos inválidos.");
        return false;
    }
    return validaPasajero(); 
}
    private boolean notNull (String str) {
        if (str == null ||  str.isEmpty()){
            
        return false;}
        
    return true;
}    
     private boolean validaPasajero () {
         
        nombresStr = NombreTextF.getText();
        apellidosStr = apellidoTextF.getText();
        dniStr= dniTextF.getText().trim();
        telefonoStr= telefonoTextF.getText().trim();
        mailStr = mailTextF.getText().trim();
        
        if (!notNull(nombresStr) || !notNull(apellidosStr) || !notNull(dniStr) || !notNull(telefonoStr) || !notNull(mailStr)) {
            JOptionPane.showMessageDialog (this, "Los campos del pasajero no pueden estar vacios"); 
        return false;}
        
        return true;
    }
    
    private void cargaPasajero () throws DuplicateEntryException {
        Connection conexion = null;
        PasajerosDao pasajeroDao;
      try {
        try {
            dni = Long.valueOf(dniStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "DNI no es válido");
            return; 
        }
        try {
            telefono = Long.valueOf(telefonoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Teléfono no es válido");
            return; 
        }
        pasajeroNuevo = new Pasajeros(nombresStr, apellidosStr, dni, telefono, mailStr);
        pasajeroNuevo.save();
        JOptionPane.showMessageDialog(this, "Pasajero exitosamente cargado");
        limpiarCampos();

    } catch (IllegalArgumentException e) {
        
        JOptionPane.showMessageDialog(this, e.getMessage());
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage());
    }
       finally{
        try {
            conexion = ConexionBDD.getConnection(); 
            pasajeroDao= new PasajerosDao(conexion);
            List <Pasajeros> actual = new ArrayList <> (pasajeroDao.listAll());
            tablaPasajeros = new PasajerosTableModel ((ArrayList<Pasajeros>) actual);
            jTable1.setModel(tablaPasajeros);
           
        } catch (SQLException e) {
            Logger.getLogger(Pasajeros.class.getName()).log(Level.SEVERE, null, e);
         
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) { 
                    conexion.close();
                } 
            } catch (SQLException ex) {
                Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    } 
    
    private Pasajeros modificaPasajero () { 
      Pasajeros pasajeroMod;
    try {
        long doc = Long.valueOf(dniStr);
        long tel = Long.valueOf(telefonoStr);
        
        pasajeroMod = new Pasajeros(nombresStr, apellidosStr, doc, tel, mailStr);

        if (!pasajeroMod.validaDni(doc) || !pasajeroMod.validaTelefono(tel) || !pasajeroMod.validaEmail(mailStr)) {
            JOptionPane.showMessageDialog(this, "DNI debe tener 8 dígitos. Teléfono debe tener 10 u 11 dígitos. Email debe tener @ y terminar en .com");
            return null; 
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "DNI o teléfono no son válidos.");
        return null;
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Campos inválidos: " + e.getMessage());
        return null; 
    }

    return pasajeroMod;
}
    
    
    private void limpiarCampos() {
        NombreTextF.setText("");
        apellidoTextF.setText("");
        dniTextF.setText("");
        telefonoTextF.setText("");
        mailTextF.setText("");
    }
     
     
    private void setCampos (Pasajeros p) {
        NombreTextF.setText(p.getNombre());
        apellidoTextF.setText(p.getApellido());
        dniTextF.setText(String.valueOf(p.getDni()));
        telefonoTextF.setText(String.valueOf(p.getTelefono()));
        mailTextF.setText(p.getEmail());
    }
    
    
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
            java.util.logging.Logger.getLogger(RegistroAbm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAbm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAbm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAbm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RegistroAbm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(RegistroAbm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuardarButton;
    private javax.swing.JTextField NombreTextF;
    private javax.swing.JLabel apellidoLbl;
    private javax.swing.JTextField apellidoTextF;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel dniLbl;
    private javax.swing.JTextField dniTextF;
    private javax.swing.JButton editarButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel mailLbl;
    private javax.swing.JTextField mailTextF;
    private javax.swing.JLabel nombreLbl;
    private javax.swing.JButton nuevoButton;
    private javax.swing.JLabel personLbl;
    private javax.swing.JLabel telefonoLbl;
    private javax.swing.JTextField telefonoTextF;
    // End of variables declaration//GEN-END:variables
}
