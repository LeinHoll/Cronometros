package Tablas;

import Util.soloNumeros;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class cellEditorDecimal extends DefaultCellEditor{
    
    public cellEditorDecimal(AbstractAction accionEnter){
        super(new JFormattedTextField());
        texto = (JFormattedTextField) getComponent();
        texto.setHorizontalAlignment(JFormattedTextField.TRAILING);
        texto.setFormatterFactory(
                new DefaultFormatterFactory(
                        new NumberFormatter(
                                new DecimalFormat("#,##0.00")
                                )
                        )
                );
        
        texto.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent evt){
                if(texto.getText().equals(""))
                    texto.setText("0");
                Valida.soloDecimalTyped(evt, texto);
                if(evt.getKeyChar() == KeyEvent.VK_ENTER)
                    stopCellEditing();
            }
            
            @Override
            public void keyReleased(KeyEvent evt){
                Valida.soloDecimalReleased(texto);
            }
        });
        
        texto.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent evt){
                if(focoConTecla){
                    int ultimo = texto.getText().length() - 1;
                    texto.setText(texto.getText().substring(ultimo));
                } else
                    texto.selectAll();
            }
        });
        
        texto.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        texto.getActionMap().put("picoEnter", accionEnter);
    }
    
    public void entrandoPorClick(){
        focoConTecla = false;
    }
    
    public void entrandoPorTecla(){
        focoConTecla = true;
    }
    
    public JFormattedTextField getField(){
        return (JFormattedTextField) getComponent();
    }
    
    @Override
    public boolean stopCellEditing() {
        try{
            texto.setText(new DecimalFormat("#,##0.00")
                    .format(Double.parseDouble(texto.getText())));
        }catch(Exception exc){}
        return super.stopCellEditing();
    }
    
    boolean focoConTecla = false;
    JFormattedTextField texto;
    soloNumeros Valida = new soloNumeros();
}