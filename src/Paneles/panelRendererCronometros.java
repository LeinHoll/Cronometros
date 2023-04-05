package Paneles;

import java.awt.Color;

public class panelRendererCronometros extends javax.swing.JPanel {

    public panelRendererCronometros() {
        initComponents();
    }
    
    protected void setDisplay(String cronometro, String tarifa){
        LCronometro.setText(cronometro);
        LTarifa    .setText(tarifa);
    }

    protected void setFondo(boolean seleccionado, Object value, int fila){
        String valores[] = value.toString().split("/"); 
        /* valores
         * [0] -> Tiempo limite
         * [1] -> Estado del reloj
         * [2] -> Texto del cronometro
         * [3] -> Nombre de la tarifa
         */
        
        int tiempoLimite  = Integer.parseInt(valores[0]);
        int estadoReloj   = Integer.parseInt(valores[1]);
        String cronometro = valores[2];
        String tarifa     = valores[3];
        
        setDisplay(cronometro, tarifa);
        
        if(tiempoLimite != 0){
            if(estadoReloj == 2 && cronometro.equals("00:00:00")){
                LTarifa     .setForeground(Color.YELLOW);
                LCronometro .setForeground(Color.YELLOW);
                setBackground(Color.BLACK);
            } else {
                String tiempo[] = cronometro.split(":");
                
                if(Integer.parseInt(tiempo[0]) * 3600 + Integer.parseInt(tiempo[1]) * 60 + Integer.parseInt(tiempo[2]) <= 180)
                    colorYFondo(Color.ORANGE, seleccionado, fila);
                else
                    colorYFondo(Color.BLUE, seleccionado, fila);
            }
        } else {
            colorYFondo(Color.BLACK, seleccionado, fila);
        }
    }
    
    private void colorYFondo(Color color, boolean seleccionado, int fila){
        LCronometro .setForeground(color);
        LTarifa     .setForeground(Color.BLACK);
        if(seleccionado)
            setBackground(new Color(153,153,153));
        else {
            if((fila % 2) == 0)
                setBackground(new Color(204,255,204));
            else
                setBackground(new Color(216,234,255));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LTarifa = new javax.swing.JLabel();
        LCronometro = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new java.awt.GridLayout(2, 0));

        LTarifa.setFont(new java.awt.Font("Tahoma", 0, 20));
        LTarifa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LTarifa.setText("- - -");
        add(LTarifa);

        LCronometro.setFont(new java.awt.Font("Arial", 1, 20));
        LCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LCronometro.setText("00:00:00");
        add(LCronometro);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LCronometro;
    private javax.swing.JLabel LTarifa;
    // End of variables declaration//GEN-END:variables
}