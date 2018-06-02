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
 * @author Alejandro
 */
public class frmUsuario extends javax.swing.JFrame {
 DefaultComboBoxModel modelo;
    /**
     * Creates new form frmUsuario
     */
    public frmUsuario() {
        initComponents();           
        this.setTitle("Mantenimiento de Tareas");
        tablaP(0);        
        //this.cbxInsumo.removeAllItems();
        //this.cbxTareaDiaria.removeAllItems();
        cus.mostrarRol(this.cbRol);
    }
    
    
     Usuario us=new Usuario();
    DaoUsuario cus=new DaoUsuario();
       
    
   /* public void cargarlistaRol() {
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
           cbRol.setModel(modelo);
           con.desconectar();
         } catch (Exception e) {
             System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
             e.printStackTrace();
         }                    
      }  */
      public void tablaP(int buscar) {
        
         String [] columnas={"Codigo Usuario","Nombre","Apellido","Nickname","password","estado","Correo","Rol"};
        Object [] obj=new Object[9];
        DefaultTableModel tabla=new DefaultTableModel(null,columnas);
        List ls;
        try {
            ls=cus.mostrarUsuario(buscar);
            for(int i=0;i<ls.size();i++){
                us=(Usuario) ls.get(i);
                obj[0]=us.getIdUsuario();
                obj[1]=us.getNombre();
                obj[2]=us.getApellido();
                obj[3]=us.getNickname();
                obj[4]=us.getPassword();
                obj[5]=us.getEdad();
                obj[6]=us.getEstado();
                obj[7]=us.getCorreo();
                 obj[8]=us.getIdRol();
                tabla.addRow(obj);
            }
            ls=cus.mostrarUsuario(buscar);
            this.tbjUsuario.setModel(tabla);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Erro : "+e.toString());
        }
    }
     
    
    
    public void mantenimiento(int accion) {
        int lsi;
        
        try {
            String p="";
            String t="";
            String s="";
            if (validacion()) {
                if (accion == 1 || accion == 2) {    
                    us.setNombre(this.jTxtNombre.getText());
                    us.setApellido(this.jTxtApellido.getText());
                    us.setNickname(this.jTxtNickname.getText());
                    us.setPassword(this.jPFPassword.getText());
                    us.setEdad(Integer.parseInt(this.jSEdad.getValue().toString()));
                     us.setEstado(Integer.parseInt(this.jSEstado.getValue().toString()));
                     us.setCorreo(this.jTxtCorreo.getText());
                    lsi=cus.mostrarIDRol(this.cbRol.getSelectedItem().toString());
                    us.setIdRol(lsi);
                    
                    //JOptionPane.showMessageDialog(this, lsi+" "+lst);
                    if (accion == 1) {                                           
                        us.setIdUsuario(ICONIFIED);
                        p="¿Desea insertar el registro?";
                        t="Insertar";
                        s="Insertado con exito";
                    } else if(accion == 2) {
                        int fila=this.tbjUsuario.getSelectedRow();
                        us.setIdUsuario(Integer.parseInt(String.valueOf(this.tbjUsuario.getValueAt(fila, 0))));
                        p="¿Desea modificar el registro?";
                        t="Modificar";
                        s="Modificado con exito";
                    }
                } else if (accion == 3) {
                    int fila=this.tbjUsuario.getSelectedRow();
                    us.setIdUsuario(Integer.parseInt(String.valueOf(this.tbjUsuario.getValueAt(fila, 0))));
                    us.setNombre("");
                    us.setApellido("");
                    us.setNickname("");
                    us.setPassword("");
                    us.setEdad(0);
                    us.setEstado(0);
                    us.setCorreo("");
                    
                    us.setIdRol(0);
                    p="¿Desea eliminar el registro?";
                    t="Eliminar";
                    s="Eliminado con exito";
                }
                int sino = JOptionPane.showConfirmDialog(this, p,t,JOptionPane.YES_NO_OPTION);
                if(sino==0){
                    cus.mantenimientoUsuario(accion,us);
                    JOptionPane.showMessageDialog(rootPane, s,"Confirmacion",JOptionPane.INFORMATION_MESSAGE);
                    tablaP(0);
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
        if (!"".equals(this.jTxtNickname.getText()) || this.cbRol.getSelectedIndex()!=0 ) {
            resp=true;
        }
        return resp;
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
    this.cbRol.setSelectedIndex(0); 
    }
    
      public void llenarTabla()
    {
    int fila=this.tbjUsuario.getSelectedRow();
   
    this.jTxtNombre.setText(String.valueOf(this.tbjUsuario.getValueAt(fila, 1)));
    this.jTxtApellido.setText(String.valueOf(this.tbjUsuario.getValueAt(fila, 2)));
    this.jTxtNickname.setText(String.valueOf(this.tbjUsuario.getValueAt(fila, 3)));
    this.jPFPassword.setText(String.valueOf(this.tbjUsuario.getValueAt(fila, 4)));    
    this.jSEdad.setValue(this.tbjUsuario.getValueAt(fila, 5));
    this.jSEstado.setValue(this.tbjUsuario.getValueAt(fila, 6));
    this.jTxtCorreo.setText(String.valueOf(this.tbjUsuario.getValueAt(fila, 7)));
    this.cbRol.setSelectedItem(String.valueOf(this.tbjUsuario.getValueAt(fila, 8)));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTxtCorreo = new javax.swing.JTextField();
        jSEdad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSEstado = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jBtnInsertar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jBtnModificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jBtnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jBtnLimpiar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbjUsuario = new javax.swing.JTable();
        jTxtNombre = new javax.swing.JTextField();
        jTxtApellido = new javax.swing.JTextField();
        cbRol = new javax.swing.JComboBox<>();
        jTxtNickname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPFPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Nickname");

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

        jLabel6.setText("Password");

        jBtnModificar.setText("Modificar");
        jBtnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnModificarMouseClicked(evt);
            }
        });

        jLabel7.setText("Edad");

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarMouseClicked(evt);
            }
        });

        jLabel8.setText("Estado");

        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnLimpiarMouseClicked(evt);
            }
        });

        jLabel9.setText("Codigo rol");

        tbjUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tbjUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbjUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbjUsuario);

        jLabel2.setText("Correo");

        jLabel1.setText("Datos usuario");

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
                                        .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(0, 215, Short.MAX_VALUE)))
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
                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnInsertar)
                    .addComponent(jBtnModificar)
                    .addComponent(jBtnEliminar)
                    .addComponent(jBtnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnInsertarMouseClicked
        try {
            mantenimiento(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaP(0);
    }//GEN-LAST:event_jBtnInsertarMouseClicked

    private void jBtnInsertarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnInsertarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnInsertarKeyPressed

    private void jBtnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnModificarMouseClicked
        try {
            mantenimiento(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaP(0);
    }//GEN-LAST:event_jBtnModificarMouseClicked

    private void jBtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarMouseClicked
        try {
            mantenimiento(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tablaP(0);
    }//GEN-LAST:event_jBtnEliminarMouseClicked

    private void jBtnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_jBtnLimpiarMouseClicked

    private void tbjUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbjUsuarioMouseClicked
        llenarTabla();
    }//GEN-LAST:event_tbjUsuarioMouseClicked

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
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnInsertar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JButton jBtnModificar;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtNickname;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTable tbjUsuario;
    // End of variables declaration//GEN-END:variables
}
