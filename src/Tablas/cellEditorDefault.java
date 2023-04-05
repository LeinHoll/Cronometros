package Tablas;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class cellEditorDefault extends DefaultCellEditor{
    
    public cellEditorDefault(AbstractAction accionEnter){
        super(new JTextField());
        texto = (JTextField) getComponent();
        
        texto.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent evt){
                if(evt.getKeyChar() == KeyEvent.VK_ENTER)
                    stopCellEditing();
            }
        });
        
        texto.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent evt){
                if(focoConTecla){
                    try{
                        int ultimo = texto.getText().length() - 1;
                        if(ultimo < 0)
                            ultimo = 0;
                        texto.setText(texto.getText().substring(ultimo));
                    } catch(Exception exc){}
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
    
    public void entrandoPorTecla(int tecla){
        if(tecla == KeyEvent.VK_BACK_SPACE)
            texto.setText("");
        focoConTecla = true;
    }
    
    boolean focoConTecla = false;
    JTextField texto;
}
