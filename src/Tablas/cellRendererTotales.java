package Tablas;

import Paneles.panelRendererTotales;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class cellRendererTotales extends panelRendererTotales implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setFondo(isSelected, row);
        setValor(value,column);
        return this;
    }
    
}