/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import com.controlador.CTareaDiaria;
import com.modelo.Jornaleros;
import com.modelo.Tablones;
import com.modelo.TareaDiaria;
import com.modelo.Tareas;
import static java.awt.Frame.ICONIFIED;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ernesto
 */
public class FrmTareasDiaria extends javax.swing.JFrame {

    /**
     * Creates new form FrmTareasDiaria
     */
    public FrmTareasDiaria() {
        initComponents();
        llenarTabla();
    }
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Instanciando">
    Tareas tarea=new Tareas();
    Tablones tablones=new Tablones();
    TareaDiaria tareaD=new TareaDiaria();
    Jornaleros jornalero=new Jornaleros();
    
    CTareaDiaria cTareaDiaria=new CTareaDiaria();
            
            
//</editor-fold>
    
  
    //<editor-fold defaultstate="collapsed" desc="Metodos y funciones">
    
    //<editor-fold defaultstate="collapsed" desc="llenar y limpiar Fromulario">
    public void llenarFrm(){
        int fila=this.tblDatos.getSelectedRow();
        this.txtId.setText(String.valueOf(this.tblDatos.getValueAt(fila, 0)));
        this.txtFecha.setText(String.valueOf(this.tblDatos.getValueAt(fila, 1)));        
        this.txtEstado.setText(String.valueOf(this.tblDatos.getValueAt(fila, 2))); 
        this.txtJornada.setText(String.valueOf(this.tblDatos.getValueAt(fila, 3))); 
        this.txtPorcentaje.setText(String.valueOf(this.tblDatos.getValueAt(fila, 4))); 
        this.txtIdTarea.setText(String.valueOf(this.tblDatos.getValueAt(fila, 5))); 
        this.txtIdTablon.setText(String.valueOf(this.tblDatos.getValueAt(fila, 6)));         
        this.txtIdJornalero.setText(String.valueOf(this.tblDatos.getValueAt(fila, 7))); 
    }
     public void limpiar() {
        this.txtId.setText("");
        this.txtFecha.setText("");
        this.txtEstado.setText("");
        this.txtJornada.setText("");
        this.txtPorcentaje.setText("");
        this.txtIdTarea.setText("");
        this.txtIdTablon.setText("");
        this.txtIdJornalero.setText("");
        
        
    }
//</editor-fold>
     
    //<editor-fold defaultstate="collapsed" desc="Mostrar datos en la tabla">
    public void llenarTabla() {
        
        String [] columnas={"ID","Fecha","Estado","Jornada","Porcentaje Realizado","Id Tarea","Id Tablones","Id Jornalero"};
        Object [] obj=new Object[8];
        DefaultTableModel tabla=new DefaultTableModel(null,columnas);
        List ls;
        try {
            ls=cTareaDiaria.mostrarTareaDiaria();
            
            for(int i=0;i<ls.size();i++){
                tareaD=(TareaDiaria) ls.get(i);
                obj[0]=tareaD.getIdTareaDiaria();
                obj[1]=tareaD.getFecha();
                obj[2]=tareaD.getEstado();
                obj[3]=tareaD.getJornada();
                obj[4]=tareaD.getPorcentajeRealizado();
                obj[5]=tareaD.getTarea().getIdTarea();
                obj[6]=tareaD.getTablones().getIdTablones();
                obj[7]=tareaD.getJornalero().getIdJornaleros();
                
                
                tabla.addRow(obj);
                
            }
            
            ls=cTareaDiaria.mostrarTareaDiaria();
            this.tblDatos.setModel(tabla);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro : "+e.toString());
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mantenimiento">
    public void mantenimiento(int accion) {
        try {
            String p="";
            String t="";
            String s="";
            if (accion==1 || accion ==2) {                           
                tareaD.setIdTareaDiaria(ICONIFIED);
                //idTareaDiaria, fecha, estado, jornada, porcentajeRealizado, idTarea, idTablones, idJornalero
                tareaD.setFecha(this.txtFecha.getText());
                tareaD.setEstado(Integer.parseInt(this.txtEstado.getText()));
                tareaD.setJornada(this.txtJornada.getText());
                tareaD.setPorcentajeRealizado(this.txtPorcentaje.getText());
                tareaD.getTarea().setIdTarea(Integer.parseInt(this.txtIdTarea.getText()));
                tareaD.getTablones().setIdTablones(Integer.parseInt(this.txtIdTablon.getText()));
                tareaD.getJornalero().setIdJornaleros(Integer.parseInt(this.txtIdJornalero.getText()));
                
                
                if (accion == 1) {
                    p="¿Desea insertar el registro?";
                    t="Insertar";
                    s="Insertado con exito";
                } else if(accion==2) {                    
                    int fila=this.tblDatos.getSelectedRow();
                    tareaD.setIdTareaDiaria(Integer.parseInt(String.valueOf(this.tblDatos.getValueAt(fila, 0))));
                    p="¿Desea modificar el registro?";
                    t="Modificar";
                    s="Modificado con exito";
                }
            } else if (accion==3) {                 
                int fila=this.tblDatos.getSelectedRow();
                tareaD.setIdTareaDiaria(Integer.parseInt(String.valueOf(this.tblDatos.getValueAt(fila, 0))));
                p="¿Desea eliminar el registro?";
                t="Eliminar";
                s="Eliminado con exito";
            }
            int sino = JOptionPane.showConfirmDialog(this, p,t,JOptionPane.YES_NO_OPTION);
            if(sino==0){
                cTareaDiaria.mantenimientoTareaDiaria(accion, tareaD);
                JOptionPane.showMessageDialog(rootPane, s,"Confirmacion",1);
                llenarTabla();
                limpiar();
            } else {
               limpiar();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
//</editor-fold>
    
//</editor-fold>
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtJornada = new javax.swing.JTextField();
        txtPorcentaje = new javax.swing.JTextField();
        txtIdTarea = new javax.swing.JTextField();
        txtIdTablon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdJornalero = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        jLabel1.setText("Id");

        jLabel2.setText("Fecha");

        jLabel3.setText("Estado");

        jLabel4.setText("Jornada");

        jLabel5.setText("Porcentaje realizado");

        jLabel6.setText("Id tarea");

        jLabel7.setText("Id tablones");

        jLabel8.setText("Gestionar Tareas Diarias");

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        jLabel9.setText("Id Jornalero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(txtFecha)
                                    .addComponent(txtEstado)
                                    .addComponent(txtJornada)
                                    .addComponent(txtPorcentaje)
                                    .addComponent(txtIdTarea)
                                    .addComponent(txtIdTablon)
                                    .addComponent(txtIdJornalero))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdTablon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIdJornalero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
           try {
            mantenimiento(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
           try {
            mantenimiento(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
           try {
            mantenimiento(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        llenarFrm();
    }//GEN-LAST:event_tblDatosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmTareasDiaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTareasDiaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTareasDiaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTareasDiaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTareasDiaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdJornalero;
    private javax.swing.JTextField txtIdTablon;
    private javax.swing.JTextField txtIdTarea;
    private javax.swing.JTextField txtJornada;
    private javax.swing.JTextField txtPorcentaje;
    // End of variables declaration//GEN-END:variables
}
