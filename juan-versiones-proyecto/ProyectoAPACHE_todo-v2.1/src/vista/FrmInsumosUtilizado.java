/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlInsumosUtilizados;
import static java.awt.Frame.ICONIFIED;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.InsumosUtilizados;

/**
 *
 * @author herrj
 */
public class FrmInsumosUtilizado extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmInsumosUtilizado
     */
    public FrmInsumosUtilizado() {
        initComponents();
        this.setTitle("Mantenimiento de Tareas");
        tablaInsumosUtilizados(0);        
        //this.cbxInsumo.removeAllItems();
        //this.cbxTareaDiaria.removeAllItems();
        ciu.mostrarInsumos(this.cbxInsumo);
        ciu.mostrarTareaDiaria(this.cbxTareaDiaria);
    }
    
    ControlInsumosUtilizados ciu = new ControlInsumosUtilizados();
    InsumosUtilizados iu = new InsumosUtilizados();

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
        txtCantidadUtilizada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxInsumo = new javax.swing.JComboBox();
        cbxTareaDiaria = new javax.swing.JComboBox();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtBusquedaId = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInsumosUtilizados = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel1.setText("mantenimiento Insumos utilizados");

        jLabel2.setText("CANTIDAD UTILIZADA: ");

        jLabel3.setText("INSUMO: ");

        jLabel4.setText("TAREA DIARIA: ");

        cbxInsumo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione una opcion --" }));

        cbxTareaDiaria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione una opcion --" }));

        btnInsertar.setText("INSERTAR");
        btnInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarMouseClicked(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        jLabel5.setText("Buscar por id:");

        btnBusqueda.setText("Buscar");
        btnBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusquedaMouseClicked(evt);
            }
        });

        tblInsumosUtilizados.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInsumosUtilizados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInsumosUtilizadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInsumosUtilizados);

        btnMostrar.setText("MOSTRAR TODO");
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(txtCantidadUtilizada, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3)
                        .addGap(72, 72, 72)
                        .addComponent(cbxInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel4)
                        .addGap(40, 40, 40)
                        .addComponent(cbxTareaDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(57, 57, 57)
                        .addComponent(txtBusquedaId, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusqueda)))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnInsertar)
                        .addGap(6, 6, 6)
                        .addComponent(btnModificar)
                        .addGap(6, 6, 6)
                        .addComponent(btnEliminar)
                        .addGap(6, 6, 6)
                        .addComponent(btnLimpiar)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMostrar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(txtCantidadUtilizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(cbxInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(cbxTareaDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsertar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusquedaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBusqueda)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMostrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarMouseClicked
        try {
            mantenimiento(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaInsumosUtilizados(0);
    }//GEN-LAST:event_btnInsertarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        try {
            mantenimiento(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaInsumosUtilizados(0);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        try {
            mantenimiento(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaInsumosUtilizados(0);
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaMouseClicked
        try {
            tablaInsumosUtilizados(Integer.parseInt(this.txtBusquedaId.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBusquedaMouseClicked

    private void tblInsumosUtilizadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInsumosUtilizadosMouseClicked
        llenarTabla();
    }//GEN-LAST:event_tblInsumosUtilizadosMouseClicked

    private void btnMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseClicked
        try {
            tablaInsumosUtilizados(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMostrarMouseClicked

    public void llenarTabla() {
        int fila=this.tblInsumosUtilizados.getSelectedRow();
        String ni="";
        String nt="";
        try {
            ni=ciu.mostrarNombreInsumos((int) this.tblInsumosUtilizados.getValueAt(fila, 2));
            nt=ciu.mostrarNombreTareaDia((int) this.tblInsumosUtilizados.getValueAt(fila, 3));
        } catch (Exception e) {
        }
        this.txtCantidadUtilizada.setText(String.valueOf(this.tblInsumosUtilizados.getValueAt(fila, 1)));
        this.cbxInsumo.setSelectedItem(ni);
        this.cbxTareaDiaria.setSelectedItem(nt);
    }
    
    public void tablaInsumosUtilizados(int buscar) {
        
        String [] columnas={"Codigo Insumo Utilizado","Cantidad Utilizada","Insumo","Tarea Diaria"};
        Object [] obj=new Object[4];
        DefaultTableModel tabla=new DefaultTableModel(null,columnas);
        List ls;
        try {
            ls=ciu.mostrarInsumosUtilizados(buscar);
            for(int i=0;i<ls.size();i++){
                iu=(InsumosUtilizados) ls.get(i);
                obj[0]=iu.getIdInsumoUtilizados();
                obj[1]=iu.getCantidadUtilizada();
                obj[2]=iu.getIdInsumo();
                obj[3]=iu.getIdTareaDiaria();
                tabla.addRow(obj);
            }
            ls=ciu.mostrarInsumosUtilizados(buscar);
            this.tblInsumosUtilizados.setModel(tabla);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro : "+e.toString());
        }
    }
    
    public void limpiar() {
        this.txtCantidadUtilizada.setText("");
        this.cbxInsumo.setSelectedItem(0);
        this.cbxTareaDiaria.setSelectedItem(0);
    }
    
    public void mantenimiento(int accion) {
        int lsi;
        int lst;
        try {
            String p="";
            String t="";
            String s="";
            if (validacion()) {
                if (accion == 1 || accion == 2) {    
                    iu.setCantidadUtilizada(Integer.parseInt(this.txtCantidadUtilizada.getText()));
                    lsi=ciu.mostrarIDInsumos(this.cbxInsumo.getSelectedItem().toString());
                    iu.setIdInsumo(lsi);
                    lst=ciu.mostrarIDTareaDia(this.cbxTareaDiaria.getSelectedItem().toString());
                    iu.setIdTareaDiaria(lst);
                    //JOptionPane.showMessageDialog(this, lsi+" "+lst);
                    if (accion == 1) {                                           
                        iu.setIdInsumoUtilizados(ICONIFIED);
                        p="¿Desea insertar el registro?";
                        t="Insertar";
                        s="Insertado con exito";
                    } else if(accion == 2) {
                        int fila=this.tblInsumosUtilizados.getSelectedRow();
                        iu.setIdInsumoUtilizados(Integer.parseInt(String.valueOf(this.tblInsumosUtilizados.getValueAt(fila, 0))));
                        p="¿Desea modificar el registro?";
                        t="Modificar";
                        s="Modificado con exito";
                    }
                } else if (accion == 3) {
                    int fila=this.tblInsumosUtilizados.getSelectedRow();
                    iu.setIdInsumoUtilizados(Integer.parseInt(String.valueOf(this.tblInsumosUtilizados.getValueAt(fila, 0))));
                    iu.setCantidadUtilizada(0);
                    iu.setIdInsumo(0);
                    iu.setIdTareaDiaria(0);
                    p="¿Desea eliminar el registro?";
                    t="Eliminar";
                    s="Eliminado con exito";
                }
                int sino = JOptionPane.showConfirmDialog(this, p,t,JOptionPane.YES_NO_OPTION);
                if(sino==0){
                    ciu.mantenimientoInsumosUtilizados(accion,iu);
                    JOptionPane.showMessageDialog(rootPane, s,"Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                    tablaInsumosUtilizados(0);
                    limpiar();
                } else {
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: Debe revisar datos a ingresar.", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean validacion() {
        boolean resp=false;
        if (!"".equals(this.txtCantidadUtilizada.getText()) || this.cbxInsumo.getSelectedIndex()!=0 || this.cbxTareaDiaria.getSelectedIndex()!=0) {
            resp=true;
        }
        return resp;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JComboBox cbxInsumo;
    private javax.swing.JComboBox cbxTareaDiaria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInsumosUtilizados;
    private javax.swing.JTextField txtBusquedaId;
    private javax.swing.JTextField txtCantidadUtilizada;
    // End of variables declaration//GEN-END:variables
}