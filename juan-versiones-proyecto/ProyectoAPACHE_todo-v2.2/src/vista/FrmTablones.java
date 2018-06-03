/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.CTablones;
import static java.awt.Frame.ICONIFIED;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Tablones;
import utilidadesVarias.EsteticaDiseño;

/**
 *
 * @author herrj
 */
public class FrmTablones extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmTablone
     */
    public FrmTablones() {
        initComponents();
        tablaT();
        cp.mostrarTablon(this.cbFinca);
        disenio.btnPredeterminados(jPanel1);
    }
    Tablones pro = new Tablones();
    CTablones cp = new CTablones();
    EsteticaDiseño disenio = new EsteticaDiseño();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTablones = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        cbFinca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSector = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblTablones.setBackground(new java.awt.Color(102, 102, 102));
        tblTablones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblTablones.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblTablones.setForeground(new java.awt.Color(255, 255, 255));
        tblTablones.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTablones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablonesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTablones);

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 255));
        btnLimpiar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 255));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(204, 204, 255));
        btnModificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });

        btnInsertar.setBackground(new java.awt.Color(204, 204, 255));
        btnInsertar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertarMouseExited(evt);
            }
        });

        cbFinca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione una opcion --" }));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("idFinca");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Sector");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre: ");

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tablones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(156, 156, 156))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbFinca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSector))))
                        .addGap(84, 84, 84))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 48, Short.MAX_VALUE)
                                .addComponent(btnInsertar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbFinca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarMouseClicked
        try {
            mantenimiento(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaT();
    }//GEN-LAST:event_btnInsertarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        try {
            mantenimiento(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaT();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        try {
            mantenimiento(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaT();
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void tblTablonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablonesMouseClicked
        llenarTabla();
    }//GEN-LAST:event_tblTablonesMouseClicked

    private void btnInsertarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarMouseEntered
        disenio.btnCambiarColor(btnInsertar);
    }//GEN-LAST:event_btnInsertarMouseEntered

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        disenio.btnCambiarColor(btnModificar);
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        disenio.btnCambiarColor(btnEliminar);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        disenio.btnCambiarColor(btnLimpiar);
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnInsertarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarMouseExited
        disenio.btnPredeterminado(btnInsertar);
    }//GEN-LAST:event_btnInsertarMouseExited

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        disenio.btnPredeterminado(btnModificar);
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        disenio.btnPredeterminado(btnEliminar);
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        disenio.btnPredeterminado(btnLimpiar);
    }//GEN-LAST:event_btnLimpiarMouseExited

    public void llenarTabla() {
        int fila = this.tblTablones.getSelectedRow();
        String nt = "";

        try {
            nt = cp.mostrarNombreInsumos((int) this.tblTablones.getValueAt(fila, 3));
        } catch (Exception e) {
        }
        this.txtNombre.setText(String.valueOf(this.tblTablones.getValueAt(fila, 1)));
        this.txtSector.setText(String.valueOf(this.tblTablones.getValueAt(fila, 2)));
        this.cbFinca.setSelectedItem(nt);
        // this.txtIdFinca.setText(String.valueOf(this.tblTablones.getValueAt(fila, 3)));

    }

    public void tablaT() {

        String[] columnas = {"Codigo Tablon", "Nombre", "Sector", "ID Finca"};
        Object[] obj = new Object[4];
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
        List ls;
        try {
            ls = cp.mostrarTablones();
            for (int i = 0; i < ls.size(); i++) {
                pro = (Tablones) ls.get(i);
                obj[0] = pro.getIdTablones();
                obj[1] = pro.getNombre();
                obj[2] = pro.getSector();
                obj[3] = pro.getIdFinca();
                tabla.addRow(obj);
            }
            ls = cp.mostrarTablones();
            this.tblTablones.setModel(tabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro : " + e.toString());
        }
    }

    public void limpiar() {
        this.txtNombre.setText("");
        this.txtSector.setText("");
        this.cbFinca.setSelectedItem(0);
    }

    public void mantenimiento(int accion) {
        int lst;
        try {
            String p = "";
            String t = "";
            String s = "";
            if (accion == 1 || accion == 2) {
                pro.setIdTablones(ICONIFIED);
                pro.setNombre(this.txtNombre.getText());
                pro.setSector(this.txtSector.getText());
                lst = cp.mostrarIDTablones(this.cbFinca.getSelectedItem().toString());
                // JOptionPane.showMessageDialog(null, lst);si imprime el id 
                pro.setIdFinca(lst);
                if (accion == 1) {
                    pro.setIdTablones(ICONIFIED);
                    p = "¿Desea insertar el registro?";
                    t = "Insertar";
                    s = "Insertado con exito";
                } else if (accion == 2) {
                    int fila = this.tblTablones.getSelectedRow();
                    pro.setIdTablones(Integer.parseInt(String.valueOf(this.tblTablones.getValueAt(fila, 0))));
                    p = "¿Desea modificar el registro?";
                    t = "Modificar";
                    s = "Modificado con exito";
                }
            } else if (accion == 3) {
                int fila = this.tblTablones.getSelectedRow();
                pro.setIdTablones(Integer.parseInt(String.valueOf(this.tblTablones.getValueAt(fila, 0))));
                pro.setNombre("");
                pro.setSector("");
                pro.setIdFinca(0);
                p = "¿Desea eliminar el registro?";
                t = "Eliminar";
                s = "Eliminado con exito";
            }
            int sino = JOptionPane.showConfirmDialog(this, p, t, JOptionPane.YES_NO_OPTION);
            if (sino == 0) {
                cp.mantenimientoTablon(accion, pro);
                JOptionPane.showMessageDialog(rootPane, s, "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                tablaT();
                limpiar();
            } else {
                limpiar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbFinca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTablones;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSector;
    // End of variables declaration//GEN-END:variables
}