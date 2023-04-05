package Tablas;

import Paneles.panelRendererCronometros;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class cellRendererCronometros extends panelRendererCronometros implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setFondo(isSelected, value, row);
        return this;
    }
    
}