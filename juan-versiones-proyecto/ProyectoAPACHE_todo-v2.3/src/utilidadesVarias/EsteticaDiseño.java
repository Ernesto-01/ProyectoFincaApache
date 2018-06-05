/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidadesVarias;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ernesto
 */
public class EsteticaDiseño {
    
    /**
     * Metodo para cambiar color 
     */     
    public void cambiarColor(JComponent componente,Color co){
    componente.setOpaque(true);
    componente.setBackground(co);
    
    }
    public void cambiarColor(JComponent componente){
    componente.setOpaque(true);
    componente.setBackground(Color.white);
    }
    
    /**
     * Metodo para restablecer poner transparente
     */
     public void tranparenteLabel(JComponent componente){
    componente.setBackground(null);
    }
     
     public void btnPredeterminado(JButton btn){
             
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setBackground(Color.LIGHT_GRAY);
        btn.setForeground(Color.WHITE);//CAmbia el Color de la fuente
    }
 
      
    public void btnCambiarColor(JButton btn ){
        btn.setOpaque(true);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);//CAmbia el Color de la fuente
 
    }
    
    
     public void btnPredeterminados(JPanel panel) {
        for (int j = 0; panel.getComponents().length > j; j++) {
            if (panel.getComponents()[j] instanceof JButton) {
                ((JButton) panel.getComponents()[j]).setContentAreaFilled(false);
                ((JButton) panel.getComponents()[j]).setOpaque(true);
                ((JButton) panel.getComponents()[j]).setBackground(Color.LIGHT_GRAY);
                ((JButton) panel.getComponents()[j]).setForeground(Color.WHITE);
            }
        }
    }
    
    
     
}
