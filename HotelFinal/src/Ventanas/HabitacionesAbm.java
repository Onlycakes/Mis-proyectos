
package Ventanas;

import DAO.HabitacionesDao;
import Entities.Habitaciones;
import Excepciones.DuplicateEntryException;
import Excepciones.NotFoundException;
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
import models.HabitacionesTableModel;


public class HabitacionesAbm extends javax.swing.JFrame {
private int nroCamasDobles, nroCamaSimples, nroHabitacion;
private Double precio;
private String camasDobles, camaSimples, precioHab, nroHab;
private static HabitacionesTableModel tablaHabitacion;
private HabitacionesDao habitacionesDao;
private Habitaciones habitacion;

    public HabitacionesAbm() throws SQLException {
        initComponents();
        
        Connection connection = null;
        try {
            connection = ConexionBDD.getConnection(); 
            habitacionesDao = new HabitacionesDao(connection);
            tablaHabitacion = new HabitacionesTableModel((ArrayList<Habitaciones>) habitacionesDao.listAll());
        //        tableHabitacionAbm.setModel(tablaHabitacion);  
        } catch (SQLException e) {
            Logger.getLogger(Habitaciones.class.getName()).log(Level.SEVERE, null, e);
         
        } finally {
            if (connection != null && !connection.isClosed()) { 
                connection.close(); 
            }
        tableHabitacionAbm.setModel(tablaHabitacion);  
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHabitacionAbm = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        TextFieldPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TextFieldNroHabitacion = new javax.swing.JTextField();
        ComboBoxCamasSimples = new javax.swing.JComboBox<>();
        ComboBoxCamasDobles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Habitacion");

        jLabel2.setText("Camas simples");

        jLabel3.setText("Camas dobles");

        jLabel4.setText("Precio");

        tableHabitacionAbm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Simples", "Dobles", "Precio", "Numero"
            }
        ));
        jScrollPane1.setViewportView(tableHabitacionAbm);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        TextFieldPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPrecioActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero");

        TextFieldNroHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldNroHabitacionActionPerformed(evt);
            }
        });

        ComboBoxCamasSimples.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        ComboBoxCamasSimples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCamasSimplesActionPerformed(evt);
            }
        });

        ComboBoxCamasDobles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        ComboBoxCamasDobles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCamasDoblesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(TextFieldNroHabitacion))
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ComboBoxCamasDobles, javax.swing.GroupLayout.Alignment.LEADING, 0, 132, Short.MAX_VALUE)
                        .addComponent(ComboBoxCamasSimples, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBoxCamasSimples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxCamasDobles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextFieldNroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(33, 33, 33)
                        .addComponent(btnModificar)
                        .addGap(32, 32, 32)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    dispose();       
    }//GEN-LAST:event_btnSalirActionPerformed

    private void ComboBoxCamasSimplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCamasSimplesActionPerformed
          
    }//GEN-LAST:event_ComboBoxCamasSimplesActionPerformed

    private void ComboBoxCamasDoblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCamasDoblesActionPerformed
        
    }//GEN-LAST:event_ComboBoxCamasDoblesActionPerformed

    private void TextFieldPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldPrecioActionPerformed
       
    }//GEN-LAST:event_TextFieldPrecioActionPerformed

    private void TextFieldNroHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldNroHabitacionActionPerformed
        
    }//GEN-LAST:event_TextFieldNroHabitacionActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        boolean b;
        b=validaHabitacion();
        if(b){
    try {
        cargaHabitacion(); 
       
    } catch (DuplicateEntryException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception e) {  
        JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage());
        Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, e);
    }
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
 
    int id;
    Connection conexion;
    HabitacionesDao habDao;
    int fila = tableHabitacionAbm.getSelectedRow(); 
    if (fila >= 0) {
        try {
            conexion = ConexionBDD.getConnection();
            habDao = new HabitacionesDao(conexion);
            habitacion = habDao.listAll().get(fila);
            id=habitacion.getIdHabitacion();
            setCampos(habitacion);
 
            btnModificar.setText("Guardar");
            btnAgregar.setEnabled(false);
            
            btnModificar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (btnModificar.getText().equals("Guardar")) {
                        
                            if(!validaHabitacion())
                            return;
                            try {
                            habDao.habitacionDuplicadaMod(habitacion.getNroHabitacion(), habitacion.getIdHabitacion());
                            habitacion = modificaHabitacion();
                                
                            if (habitacion==null)
                                return;
                            if (!habitacion.valida()){
                            JOptionPane.showMessageDialog(null, "La habitación no puede contener 0 camas");
                            return;
                            }  
                            // habDao.habitacionDuplicadaMod(habitacion.getNroHabitacion(), habitacion.getIdHabitacion()); 
                             habDao.update(habitacion, id);
                             
                             List <Habitaciones> actual = new ArrayList <> (habDao.listAll());
                             tablaHabitacion = new HabitacionesTableModel ((ArrayList<Habitaciones>) actual);
                             tableHabitacionAbm.setModel(tablaHabitacion);
                             JOptionPane.showMessageDialog(null, "Habitación exitosamente actualizada");
                             limpiarCampos(); 
                            } catch (NotFoundException | DuplicateEntryException  ex) {  
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
                            return;
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        finally {
                            try {
                                if (conexion != null && !conexion.isClosed()) {
                                    conexion.close();
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }                
                    }
                    btnAgregar.setEnabled(true);
                   btnModificar.setText("Modificar"); 
                }
            });
           
          } catch (SQLException ex) {
            Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }  
    }          
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Habitaciones h;
        HabitacionesDao habDaoE;
        Connection connection= null;
        
        int fila = tableHabitacionAbm.getSelectedRow();
        if (fila >= 0) {
        try {
               connection = ConexionBDD.getConnection(); 
               habDaoE = new HabitacionesDao(connection);
               h = habDaoE.listAll().get(fila);
               int id=h.getIdHabitacion();           
               
               habDaoE.deshabilitarHabitacion(id);
               
               List <Habitaciones> actual = new ArrayList <> (habDaoE.listAll());
               tablaHabitacion = new HabitacionesTableModel ((ArrayList<Habitaciones>) actual);
               tableHabitacionAbm.setModel(tablaHabitacion);
               JOptionPane.showMessageDialog(this, "Habitación eliminada."); 
              
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this, ex.getMessage());
               Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
           } catch (NotFoundException ex) {
               JOptionPane.showMessageDialog(this, ex.getMessage());
               Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
           }    
             finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }   } catch (SQLException ex) {
                    Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
                }
        } 
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private boolean notNull (String str) {
            if (str == null ||  str.isEmpty()){
            
            return false;}
        
    return true;
}
    
    private boolean validaHabitacion () {
        camaSimples = (String) ComboBoxCamasSimples.getSelectedItem();
        nroCamaSimples = Integer.parseInt (camaSimples);
        
        camasDobles = (String) ComboBoxCamasDobles.getSelectedItem();
        nroCamasDobles = Integer.parseInt (camasDobles);
        
        precioHab = TextFieldPrecio.getText().trim();
        
        nroHab = TextFieldNroHabitacion.getText().trim();
    
        if (!notNull(precioHab)|| !notNull(nroHab)) {
        JOptionPane.showMessageDialog (this, "Los campos de la Habitacion no pueden estar vacios"); 
        return false;
              }
        return true;
    }
    
    private void cargaHabitacion () throws DuplicateEntryException {
        Connection conexion = null;
        Habitaciones habitacionNueva = null;
        HabitacionesDao habDao;
        try {
            precio = Double.valueOf(precioHab);
            nroHabitacion = Integer.parseInt(nroHab); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio o Número de habitación no son válidos");
            return; 
        }
        habitacionNueva = new Habitaciones(nroCamaSimples, nroCamasDobles, precio, nroHabitacion);
        if (!habitacionNueva.valida()){
            JOptionPane.showMessageDialog(this, "La habitación no puede contener 0 camas");
            return; 
        }
        habitacionNueva.save();
        JOptionPane.showMessageDialog(this, "Habitación exitosamente creada");   
        limpiarCampos();
        
        try {
            conexion = ConexionBDD.getConnection(); 
            habDao = new HabitacionesDao(conexion);
            List <Habitaciones> actual = new ArrayList <> (habDao.listAll());
            tablaHabitacion = new HabitacionesTableModel ((ArrayList<Habitaciones>) actual);
            tableHabitacionAbm.setModel(tablaHabitacion);
           
        } catch (SQLException e) {
            Logger.getLogger(Habitaciones.class.getName()).log(Level.SEVERE, null, e);
         
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) { 
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HabitacionesAbm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
    private Habitaciones modificaHabitacion () throws DuplicateEntryException {
        Habitaciones habitacionMod=null;
        try {
        precio = Double.valueOf(precioHab);
        nroHabitacion = Integer.parseInt(nroHab);
        habitacionMod = new Habitaciones(nroCamaSimples, nroCamasDobles, precio, nroHabitacion);
        }
        catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, "Campos invalidos");
    }
        return habitacionMod;
    }


     private void limpiarCampos() {
        ComboBoxCamasSimples.setSelectedIndex(0);  
        ComboBoxCamasDobles.setSelectedIndex(0);  
        TextFieldPrecio.setText("");
        TextFieldNroHabitacion.setText("");
    }
     
     
    private void setCampos (Habitaciones h) {
        
        ComboBoxCamasSimples.setSelectedIndex(h.getCantCamasSimples());  
        ComboBoxCamasDobles.setSelectedIndex(h.getCantCamasDobles());  
        TextFieldPrecio.setText(String.valueOf(h.getPrecioPorDia()));
        TextFieldNroHabitacion.setText(String.valueOf(h.getNroHabitacion()));
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCamasDobles;
    private javax.swing.JComboBox<String> ComboBoxCamasSimples;
    private javax.swing.JTextField TextFieldNroHabitacion;
    private javax.swing.JTextField TextFieldPrecio;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHabitacionAbm;
    // End of variables declaration//GEN-END:variables
    
    
    
}
