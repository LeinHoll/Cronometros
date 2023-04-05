package Tablas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

public class cellEditorCombo extends DefaultCellEditor {

    public cellEditorCombo(){
        super(new JComboBox());
        box = (JComboBox) getComponent();
        
        box.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent evt){
                if(evt.getKeyChar() == KeyEvent.VK_ENTER){
                    stopCellEditing();
                }
            }
        });
        
    }
    
    public void opciones(String opciones[]){
        box.removeAllItems();
        for(int i = 0 ; i < opciones.length ; i++)
            box.addItem(opciones[i]);
    }
    
    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }
    
    JComboBox box;
}