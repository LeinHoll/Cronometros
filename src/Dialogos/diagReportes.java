package Dialogos;

import Util.Conector;
//import Util.Reporte;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class diagReportes extends javax.swing.JDialog {

    public diagReportes(java.awt.Frame parent, boolean modal, Conector linker) {
        super(parent, modal);
        this.linker = linker;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        Date fecha = new Date();
        TFechaIni.setText(new SimpleDateFormat("dd/MM/yyyy").format(fecha));
        TFechaFin.setText(new SimpleDateFormat("dd/MM/yyyy").format(fecha));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TFechaIni = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFechaFin = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        BGenerar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de rentas");
        setResizable(false);

        try {
            TFechaIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Desde el dia:");

        jLabel3.setText("Hasta el dia:");

        try {
            TFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        BGenerar.setText("Genera reporte");
        BGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(BGenerar);

        BCancelar.setText("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFechaIni)
                            .addComponent(TFechaFin)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGenerarActionPerformed
        String fini[] = TFechaIni.getText().split("/");
        String ffin[] = TFechaFin.getText().split("/");
        
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(fini[2]), Integer.parseInt(fini[1]) - 1, Integer.parseInt(fini[0]));
        
        Date ini = cal.getTime();
        
        cal.set(Integer.parseInt(ffin[2]), Integer.parseInt(ffin[1]) - 1, Integer.parseInt(ffin[0]));
        
        Date fin = cal.getTime();
        
        //Reporte rep = new Reporte(linker, ini, fin);
        //rep.ejecutaReporte();
        
        dispose();
    }//GEN-LAST:event_BGenerarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BGenerar;
    private javax.swing.JFormattedTextField TFechaFin;
    private javax.swing.JFormattedTextField TFechaIni;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    Conector linker;
}