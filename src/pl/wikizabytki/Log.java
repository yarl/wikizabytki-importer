package pl.wikizabytki;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Pawel
 */
public class Log {
    private JTextPane loger;
    
    public Log(JTextPane loger) {
        this.loger = loger;
    }
    
    public void log(String s) {
        try {
            Document doc = loger.getDocument();
            doc.insertString(doc.getLength(), s, null);
        } catch(BadLocationException exc) {
        }
    }
    
    public void bold(String s) {
        try {
            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setBold(attributes, true);
            Document doc = loger.getDocument();
            doc.insertString(doc.getLength(), s, attributes);
        } catch(BadLocationException exc) {
        }
    }
    
    public void red(String s) {
        try {
            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setForeground(attributes, Color.red);
            Document doc = loger.getDocument();
            doc.insertString(doc.getLength(), s, attributes);
        } catch(BadLocationException exc) {
        }
    }
    
    public void green(String s) {
        try {
            SimpleAttributeSet attributes = new SimpleAttributeSet();
            StyleConstants.setForeground(attributes, new Color(0, 102, 0));
            Document doc = loger.getDocument();
            doc.insertString(doc.getLength(), s, attributes);
        } catch(BadLocationException exc) {
        }
    }
}
