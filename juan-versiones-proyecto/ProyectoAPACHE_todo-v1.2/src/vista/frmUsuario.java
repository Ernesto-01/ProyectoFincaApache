/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Conexion;
import controlador.DaoUsuario;
import modelo.Usuario;
import static java.awt.Frame.ICONIFIED;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jorge
 */
public class frmUsuario extends javax.swing.JInternalFrame {
 DefaultComboBoxModel modelo;
    /**
     * Creates new form frmUsuario
     */
    public frmUsuario() {       
        initComponents();           
        modelo = new DefaultComboBoxModel();
        this.tablaP();
        cargarlistaRol();
        
         jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = jTable2.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(75);
        columnModel.getColumn(4).setPreferredWidth(75);
        columnModel.getColumn(5).setPreferredWidth(50);
        columnModel.getColumn(6).setPreferredWidth(50);
        columnModel.getColumn(7).setPreferredWidth(100);  
        
    }
    
    
     Usuario usu=new Usuario();
    DaoUsuario daou=new DaoUsuario();
       
    
    public void cargarlistaRol() {
       Conexion con = new Conexion();
       Connection cn;
       ResultSet res;
       try {
            con.conectar();
            String sql="Select * from tbl_rol";
            PreparedStatement pre = con.getCon().prepareCall(sql);
            res = pre.executeQuery();
            modelo.removeAllElements();
            while(res.next()){
                 modelo.addElement(res.getString("idRol"));
             }
           jCBRol.setModel(modelo);
           con.desconectar();
         } catch (Exception e) {
             System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
             e.printStackTrace();
         }                    
      }  
      public void tablaP() {
        
          String [] columnas={"Codigo","Nombre","Apellido","Nicname","Password","Edad","Estado","Correo","Codigo rol"};
        Object [] obj=new Object[10];
        DefaultTableModel tabla=new DefaultTableModel(null,columnas);
        List ls;
        try {
            ls=daou.mostrarUsuario();
            for(int i=0;i<ls.size();i++){
                usu=(Usuario) ls.get(i);
                    obj[0]=usu.getIdUsuario();
                    obj[1]=usu.getNombre();
                    obj[2]=usu.getApellido();
                    obj[3]=usu.getNickname();
                    obj[4]=usu.getPassword();
                    obj[5]=usu.getEdad();
                    obj[6]=usu.getEstado();
                    obj[7]=usu.getCorreo();
                    obj[8]=usu.getIdRol();
                tabla.addRow(obj);
            }
            ls=daou.mostrarUsuario();
            this.jTable2.setModel(tabla);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro : "+e.toString());
        }
    }
     
    public void mantenimiento(int accion) {
        try {
            String p="";
            String t="";
            String s="";
            if (accion==1 || accion ==2) {                           
                usu.setIdUsuario(ICONIFIED);
                 usu.setNombre(this.jTxtNombre.getText());
    usu.setApellido(this.jTxtApellido.getText());
    usu.setNickname(this.jTxtNickname.getText());
    usu.setPassword(String.valueOf(jPFPassword.getPassword()));
    usu.setEdad(Integer.parseInt(this.jSEdad.getValue().toString()));
    usu.setEstado(Integer.parseInt(this.jSEstado.getValue().toString()));
      usu.setCorreo(this.jTxtCorreo.getText());
    usu.setIdRol(Integer.parseInt(this.jCBRol.getSelectedItem().toString()));
                
                
               
                if (accion == 1) {
                    p="¿Desea insertar el registro?";
                    t="Insertar";
                    s="Insertado con exito";
                } else if(accion==2) {                    
                    int fila=this.jTable2.getSelectedRow();
                    usu.setIdUsuario(Integer.parseInt(String.valueOf(this.jTable2.getValueAt(fila, 0))));
                    p="¿Desea modificar el registro?";
                    t="Modificar";
                    s="Modificado con exito";
                }
            } else if (accion==3) {                
                usu.setNombre("");
                usu.setApellido("");
                usu.setNickname("");
                usu.setPassword("");               
                usu.setEdad(0);
                usu.setEstado(0);
                usu.setCorreo("");
                usu.setIdRol(0);               
                p="¿Desea eliminar el registro?";
                t="Eliminar";
                s="Eliminado con exito";
            }
            int sino = JOptionPane.showConfirmDialog(this, p,t,JOptionPane.YES_NO_OPTION);
            if(sino==0){
                daou.mantenimientoUsuario(accion,usu);
                JOptionPane.showMessageDialog(rootPane, s,"Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                tablaP();
                limpiar();
            } else {
                limpiar();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void limpiar()
    {
    this.jTxtNombre.setText("");
    this.jTxtApellido.setText("");
    this.jTxtNickname.setText("");
    this.jPFPassword.setText("");
    this.jSEdad.getModel().setValue(0);
    this.jSEstado.getModel().setValue(0);
     this.jTxtCorreo.setText("");
    this.jCBRol.setSelectedIndex(0); 
    }
    
      public void llenarTabla()
    {
    int fila=this.jTable2.getSelectedRow();
   
    this.jTxtNombre.setText(String.valueOf(this.jTable2.getValueAt(fila, 1)));
    this.jTxtApellido.setText(String.valueOf(this.jTable2.getValueAt(fila, 2)));
    this.jTxtNickname.setText(String.valueOf(this.jTable2.getValueAt(fila, 3)));
    this.jPFPassword.setText(String.valueOf(this.jTable2.getValueAt(fila, 4)));    
    this.jSEdad.setValue(this.jTable2.getValueAt(fila, 5));
    this.jSEstado.setValue(this.jTable2.getValueAt(fila, 6));
    this.jTxtCorreo.setText(String.valueOf(this.jTable2.getValueAt(fila, 7)));
    this.jCBRol.setSelectedItem(String.valueOf(this.jTable2.getValueAt(fila, 8)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jTxtApellido = new javax.swing.JTextField();
        jTxtNickname = new javax.swing.JTextField();
        jPFPassword = new javax.swing.JPasswordField();
        jSEdad = new javax.swing.JSpinner();
        jSEstado = new javax.swing.JSpinner();
        jBtnInsertar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jCBRol = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTxtCorreo = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);

        jLabel1.setText("Datos usuario");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Nickname");

        jLabel6.setText("Password");

        jLabel7.setText("Edad");

        jLabel8.setText("Estado");

        jLabel9.setText("Codigo rol");

        jBtnInsertar.setText("Insertar");
        jBtnInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnInsertarMouseClicked(evt);
            }
        });
        jBtnInsertar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnInsertarKeyPressed(evt);
            }
        });

        jBtnModificar.setText("Modificar");
        jBtnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnModificarMouseClicked(evt);
            }
        });

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarMouseClicked(evt);
            }
        });

        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnLimpiarMouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jCBRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Correo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jBtnInsertar)
                                .addGap(26, 26, 26)
                                .addComponent(jBtnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(93, 93, 93)
                                        .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(78, 78, 78)
                                        .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))))
                        .addGap(0, 89, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTxtNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jSEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnInsertar)
                    .addComponent(jBtnModificar)
                    .addComponent(jBtnEliminar)
                    .addComponent(jBtnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnInsertarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnInsertarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnInsertarKeyPressed

    private void jBtnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnInsertarMouseClicked
       try {
            mantenimiento(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaP();    
    }//GEN-LAST:event_jBtnInsertarMouseClicked

    private void jBtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnModificarMouseClicked
       try {
            mantenimiento(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaP();
    }//GEN-LAST:event_jBtnModificarMouseClicked

    private void jBtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarMouseClicked
      try {
            mantenimiento(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaP();  
    }//GEN-LAST:event_jBtnEliminarMouseClicked

    private void jBtnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLimpiarMouseClicked
      limpiar();
    }//GEN-LAST:event_jBtnLimpiarMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       llenarTabla();
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnInsertar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JComboBox<String> jCBRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JSpinner jSEdad;
    private javax.swing.JSpinner jSEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtNickname;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
