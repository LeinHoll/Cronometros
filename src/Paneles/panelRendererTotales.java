package Paneles;

import Util.validaALaMexicana;
import java.awt.Color;
import java.text.DecimalFormat;

public class panelRendererTotales extends javax.swing.JPanel {

    public panelRendererTotales() {
        initComponents();
    }
    
    protected void setFondo(boolean seleccionado, int fila){
        if(seleccionado)
            setBackground(new Color(153,153,153));
        else {
            if((fila % 2) == 0)
                setBackground(new Color(204,255,204));
            else
                setBackground(new Color(216,234,255));
        }
    }
    
    protected void setValor(Object value, int column){
        double valor = Double.parseDouble(mexicana.mexicanaDecimal(value.toString()));
        
        switch(column){
            case 4:
                if(valor > 0)
                    LTotal.setForeground(Color.GREEN);
                else
                    LTotal.setForeground(new Color(0,0,0));
            break;
                
            case 5:
                if(valor < 0)
                    LTotal.setForeground(Color.red);
                else
                    LTotal.setForeground(new Color(0,0,0));
            break;
                
            default: LTotal.setForeground(new Color(0,0,0));
        }
        
        LTotal.setText(new DecimalFormat("#,##0.00").format(Math.abs(valor)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LTotal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 234, 255));
        setLayout(new java.awt.GridLayout(1, 0));

        LTotal.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        LTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LTotal.setText("0.00");
        add(LTotal);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LTotal;
    // End of variables declaration//GEN-END:variables
    validaALaMexicana mexicana = new validaALaMexicana();
}