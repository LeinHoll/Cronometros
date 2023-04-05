package Paneles;

import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.BorderFactory;

public class panelDetalles extends javax.swing.JPanel {

    public panelDetalles() {
        initComponents();
    }
    
    public void setDefaults(){
        LHoraInicio         .setText("00:00:00");
        LTiempoTranscurrido .setText("00:00:00");
        LTiempoLimite       .setText("00:00:00");
        LTarifa             .setText("$ 0.00");
        LConsumo            .setText("$ 0.00");
        LPrepago            .setText("$ 0.00");
        LTotal              .setText("$ 0.00");
        setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
    }
    
    public void setLConsumo(double consumo){
        LConsumo.setText("$ " + decimal.format(consumo));
    }

    public void setLHoraInicio(Date fecha){
        LHoraInicio.setText(new SimpleDateFormat("HH:mm:ss").format(fecha));
    }
    
    public void setLPrepago(double prepago){
        LPrepago.setText("$ " + decimal.format(prepago));
    }
    
    public void setLTarifa(double tarifa){
        LTarifa.setText("$ " + decimal.format(tarifa));
    }
    
    public void setLTiempoLimite(int TiempoLimite){
        int horas   = TiempoLimite / 60;
        int minutos = TiempoLimite % 60;
        
        String TLimite ;
        TLimite  = (horas   < 10) ?  "0" + horas           : ""  + horas;
        TLimite += (minutos < 10) ? ":0" + minutos + ":00" : ":" + minutos + ":00";
        
        LTiempoLimite.setText(TLimite);
    }
    
    public void setLTiempoTranscurrido(String texto){
        LTiempoTranscurrido.setText(texto);
    }
    
    public void setLTotal(double total){
        LTotal.setText("$ " + decimal.format(total));
    }
    
    public void setTitulo(String nombre){
        setBorder(BorderFactory.createTitledBorder("Detalles de " + nombre));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LTotal = new javax.swing.JLabel();
        LMenu = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LConsumo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LHoraInicio = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        LTiempoTranscurrido = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        LPrepago = new javax.swing.JLabel();
        LTarifa = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        LTiempoLimite = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));
        setLayout(new java.awt.GridLayout(1, 0));

        LTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LTotal.setText("$ 0.00");

        LMenu.setText("Hora de Inicio:");

        jLabel6.setText("Coste por tiempo:");

        LConsumo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LConsumo.setText("$ 0.00");

        jLabel8.setText("Consumos:");

        jLabel10.setText("Total:");

        LHoraInicio.setText("00:00:00");

        jLabel12.setText("Prepago:");

        LTiempoTranscurrido.setText("00:00:00");

        jLabel4.setText("Tiempo Transcurrido:");

        LPrepago.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LPrepago.setText("$ 0.00");

        LTarifa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LTarifa.setText("$ 0.00");

        LTiempoLimite.setText("00:00:00");

        jLabel14.setText("Tiempo Limite:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                            .addComponent(LTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(48, 48, 48)
                            .addComponent(LPrepago, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(39, 39, 39)
                            .addComponent(LConsumo, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LTarifa, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(LMenu)
                                .addComponent(jLabel14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LTiempoLimite)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LTiempoTranscurrido)
                                    .addComponent(LHoraInicio)))))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LMenu)
                        .addComponent(LHoraInicio))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(LTiempoTranscurrido))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(LTiempoLimite))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LTarifa)
                        .addComponent(jLabel6))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(LConsumo)
                        .addComponent(jLabel8))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LPrepago))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(LTotal))
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LConsumo;
    private javax.swing.JLabel LHoraInicio;
    private javax.swing.JLabel LMenu;
    private javax.swing.JLabel LPrepago;
    private javax.swing.JLabel LTarifa;
    private javax.swing.JLabel LTiempoLimite;
    private javax.swing.JLabel LTiempoTranscurrido;
    private javax.swing.JLabel LTotal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
    DecimalFormat decimal = new DecimalFormat("#,##0.00");
}