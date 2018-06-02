/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControlInventario;
import static java.awt.Frame.ICONIFIED;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Inventario;

/**
 *
 * @author herrj
 */
public class FrmInventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmInventari
     */
    public FrmInventario() {
        initComponents();
        this.setTitle("Mantenimiento de Inventario");
        tablaI(0);
        in.mostrarFinca(this.cbxFinca);
        in.mostrarProveedor(this.cbxProveedor);
        in.mostrarInsumos(this.cbxInsumo);
    }
    Inventario inv=new Inventario();
    ControlInventario in=new ControlInventario();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtHabilitado = new javax.swing.JRadioButton();
        rbtDeshabilitado = new javax.swing.JRadioButton();
        cbxFinca = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxProveedor = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbxInsumo = new javax.swing.JComboBox();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("Inventario");

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel4.setText("Estado");

        buttonGroup1.add(rbtHabilitado);
        rbtHabilitado.setText("Habilitado");

        buttonGroup1.add(rbtDeshabilitado);
        rbtDeshabilitado.setText("Deshabilitado");

        cbxFinca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione una opcion --" }));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel6.setText("Finca");

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel8.setText("Proveedor");

        cbxProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione una opcion --" }));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel7.setText("Insumo");

        cbxInsumo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione una opcion --" }));

        btnInsertar.setBackground(new java.awt.Color(204, 204, 255));
        btnInsertar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarMouseClicked(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(204, 204, 255));
        btnModificar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 255));
        btnLimpiar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel2.setText("Precio");

        jLabel5.setText("Buscar");

        btnBusqueda.setText("Buscar");
        btnBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusquedaMouseClicked(evt);
            }
        });

        tblInventario.setBackground(new java.awt.Color(102, 102, 102));
        tblInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblInventario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblInventario.setForeground(new java.awt.Color(255, 255, 255));
        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblInventario);

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
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbtHabilitado)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rbtDeshabilitado))
                                        .addComponent(cbxFinca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnInsertar)
                                .addGap(32, 32, 32)
                                .addComponent(btnModificar)
                                .addGap(37, 37, 37)
                                .addComponent(btnEliminar)
                                .addGap(38, 38, 38)
                                .addComponent(btnLimpiar))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(396, 396, 396)
                            .addComponent(btnMostrar))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBusqueda)
                                    .addGap(89, 89, 89))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rbtHabilitado)
                    .addComponent(rbtDeshabilitado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxFinca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusqueda))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMostrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarMouseClicked
        try {
            mantenimiento(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaI(0);
    }//GEN-LAST:event_btnInsertarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        try {
            mantenimiento(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaI(0);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        try {
            mantenimiento(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaI(0);
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaMouseClicked
        try {
            tablaI(Integer.parseInt(this.txtBuscar.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBusquedaMouseClicked

    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked
        llenarTabla();
    }//GEN-LAST:event_tblInventarioMouseClicked

    private void btnMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseClicked
        try {
            tablaI(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMostrarMouseClicked

    public void llenarTabla() {
        int fila=this.tblInventario.getSelectedRow();
        String nf = "";
        String np = "";
        String ni = "";
        try {
            nf = in.mostrarNombreFinca((int) this.tblInventario.getValueAt(fila, 4));
            np = in.mostrarNombreProveedor((int) this.tblInventario.getValueAt(fila, 5));
            ni = in.mostrarNombreInsumos((int) this.tblInventario.getValueAt(fila, 6));
        } catch (Exception e) {
        }
        this.txtCantidad.setText(String.valueOf(this.tblInventario.getValueAt(fila, 1)));
        this.txtPrecio.setText(String.valueOf(this.tblInventario.getValueAt(fila, 2)));
        int es = (int) this.tblInventario.getValueAt(fila, 3);
        if (es == 1) {
            this.rbtHabilitado.setSelected(true);
        } else if (es == 0) {
            this.rbtDeshabilitado.setSelected(false);
        }
        this.cbxFinca.setSelectedItem(nf);
        this.cbxProveedor.setSelectedItem(np);
        this.cbxInsumo.setSelectedItem(ni);
    }
    
     public void tablaI(int buscar) {
        
        String [] columnas={"Codigo Inventario","Cantidad","Precio","Estado","Finca","Proveedor","Insumo"};
        Object [] obj=new Object[7];
        DefaultTableModel tabla=new DefaultTableModel(null,columnas);
        List ls;
        try {
            ls=in.mostrarInventario(buscar);
            for(int i=0;i<ls.size();i++){
                inv=(Inventario) ls.get(i);
                obj[0]=inv.getIdInventario();
                obj[1]=inv.getCantidad();
                obj[2]=inv.getPrecio();
                obj[3]=inv.getEstado();
                obj[4]=inv.getIdFinca();
                obj[5]=inv.getIdProveedor();
                obj[6]=inv.getIdInsumo();
                tabla.addRow(obj);
            }
            ls=in.mostrarInventario(buscar);
            this.tblInventario.setModel(tabla);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro : "+e.toString());
        }
    }
    
    public void limpiar() {
        this.txtCantidad.setText("");
        this.txtPrecio.setText("");
        this.rbtHabilitado.setSelected(false);
        this.rbtDeshabilitado.setSelected(false);
        this.cbxFinca.setSelectedIndex(0);
        this.cbxProveedor.setSelectedIndex(0);
        this.cbxInsumo.setSelectedIndex(0);
    }
    
    public void mantenimiento(int accion) {
        int lsf;
        int lsp;
        int lsi;
        int estado = 0;
        try {
            String p="";
            String t="";
            String s="";
            if (validacion()) {
                if (accion==1 || accion ==2) {                           
                    inv.setIdInventario(ICONIFIED);
                    inv.setCantidad(Integer.parseInt(this.txtCantidad.getText()));
                    inv.setPrecio(Double.parseDouble(this.txtPrecio.getText()));
                    if (this.rbtHabilitado.isSelected()) {
                        estado = 1;
                    } else if(this.rbtDeshabilitado.isSelected()) {
                        estado = 0;
                    }
                    inv.setEstado(estado);
                    lsf = in.mostrarIDFinca(this.cbxFinca.getSelectedItem().toString());
                    inv.setIdFinca(lsf);
                    lsp = in.mostrarIDProveedor(this.cbxProveedor.getSelectedItem().toString());
                    inv.setIdProveedor(lsp);
                    lsi = in.mostrarIDInsumos(this.cbxInsumo.getSelectedItem().toString());
                    inv.setIdInsumo(lsi);
                    if (accion == 1) {
                        p="¿Desea insertar el registro?";
                        t="Insertar";
                        s="Insertado con exito";
                    } else if(accion==2) {                    
                        int fila=this.tblInventario.getSelectedRow();
                       inv.setIdInventario(Integer.parseInt(String.valueOf(this.tblInventario.getValueAt    (fila, 0))));
                        p="¿Desea modificar el registro?";
                        t="Modificar";
                        s="Modificado con exito";
                    }
                } else if (accion==3) {                
                    inv.setCantidad(0);
                    inv.setPrecio(0);
                    inv.setEstado(0);
                    inv.setIdFinca(0);
                     inv.setIdProveedor(0);
                    inv.setIdInsumo(0);
                    p="¿Desea eliminar el registro?";
                    t="Eliminar";
                    s="Eliminado con exito";
                }
                int sino = JOptionPane.showConfirmDialog(this, p,t,JOptionPane.YES_NO_OPTION);
                if(sino==0){
                    in.mantenimientoInventario(accion,inv);
                    JOptionPane.showMessageDialog(rootPane, s,"Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                    tablaI(0);
                    limpiar();
                } else {
                    limpiar();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean validacion() {
        boolean resp=false;
        if (!"".equals(this.txtPrecio.getText()) || !"".equals(this.txtPrecio.getText()) || this.rbtHabilitado.isSelected() || this.rbtDeshabilitado.isSelected() || this.cbxFinca.getSelectedIndex()!=0 || this.cbxProveedor.getSelectedIndex()!=0 || this.cbxInsumo.getSelectedIndex()!=0) {
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxFinca;
    private javax.swing.JComboBox cbxInsumo;
    private javax.swing.JComboBox cbxProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtDeshabilitado;
    private javax.swing.JRadioButton rbtHabilitado;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
