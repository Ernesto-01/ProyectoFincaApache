package utilidadesVarias;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ernesto
 */
public class Utilidades {

    public void letrasEspacios(java.awt.event.KeyEvent evt) {
        Character s = evt.getKeyChar();
        if (!Character.isLetter(s) && s != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        Character s = evt.getKeyChar();
        if (!Character.isDigit(s)) {
            evt.consume();
        }
    }

    public void numerosUnPunto(java.awt.event.KeyEvent evt, JTextField txt) {
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txt.getText().contains(".")) {
            evt.consume();
        }
    }

    public void LimpiarCampos(JPanel panel) {
        for (int j = 0; panel.getComponents().length > j; j++) {
            if (panel.getComponents()[j] instanceof JTextField) {
                ((JTextField) panel.getComponents()[j]).setText("");
            }
        }
    }

    public boolean camposRequeridos(JPanel panel) {
        for (int j = 0; panel.getComponents().length > j; j++) {
            if (panel.getComponents()[j] instanceof JTextField) {
                if (((JTextField) panel.getComponents()[j]).getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campos vacios", "Campos nulos", 2, null);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean camposRequeridos(JPanel panel, JTextField txt) {
        for (int j = 0; panel.getComponents().length > j; j++) {
            if (panel.getComponents()[j] instanceof JTextField) {
                if (txt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campos vacios", "Campos nulos", 2, null);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean camposRequeridosParaInsertar(JPanel panel,JTextField txt) {
        for (int j = 0; panel.getComponents().length > j; j++) {
            if (panel.getComponents()[j] instanceof JTextField) {
                if (((JTextField) panel.getComponents()[j]).getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campos vacios", "Campos nulos", 2, null);
                    return false;
                }
            }
        }
        return true;
    }

}
