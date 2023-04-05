package Util;

import setters_getters.setGetTarifas;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class modeloListaAdminTarifas extends DefaultListModel {
        
    public void setListado(ArrayList<setGetTarifas> Tarifas){
        removeAllElements();
        for(int i = 0 ; i < Tarifas.size() ; i++){
            addElement(Tarifas.get(i).getTarifa());
        }
    }
}
