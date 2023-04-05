package Tablas;

import Paneles.panelRendererMaquinas;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class cellRendererMaquinas extends panelRendererMaquinas implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setFondo(isSelected, row);
        setDisplay(value);
        return this;
    }
}