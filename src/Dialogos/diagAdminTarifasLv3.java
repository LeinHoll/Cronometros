package Dialogos;

import Util.soloNumeros;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;

public class diagAdminTarifasLv3 extends javax.swing.JDialog {

    public diagAdminTarifasLv3(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), "picoEscape");

        BAceptar.getActionMap().put("picoFlecha", new picoFlecha(1));
        BAceptar.getActionMap().put("picoEnter" , new picoEnter (1));
        BCancela.getActionMap().put("picoFlecha", new picoFlecha(2));
        BCancela.getActionMap().put("picoEnter" , new picoEnter (2));
        BCancela.getActionMap().put("picoEscape", new picoEscape( ));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FTFTiempo = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        LNuevoTiempo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calculo");
        setResizable(false);

        FTFTiempo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        FTFTiempo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        FTFTiempo.setText("0");
        FTFTiempo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FTFTiempoFocusGained(evt);
            }
        });
        FTFTiempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FTFTiempoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FTFTiempoKeyTyped(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("=");

        LNuevoTiempo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LNuevoTiempo.setText("00:00:00");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        BAceptar.setText("O");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(BAceptar);

        BCancela.setText("X");
        BCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelaActionPerformed(evt);
            }
        });
        jPanel1.add(BCancela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FTFTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LNuevoTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LNuevoTiempo)
                    .addComponent(jLabel4)
                    .addComponent(FTFTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FTFTiempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFTiempoKeyTyped
        int tecla = valida.soloNum(evt);
        if(tecla == -1){
            evt.consume();
        } else if(tecla == 10){
            FTFTiempo.transferFocus();
        }
    }//GEN-LAST:event_FTFTiempoKeyTyped

    private void FTFTiempoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFTiempoKeyReleased
        if(FTFTiempo.getText().equals(""))
            tiempoBandera = 0;
        else
            tiempoBandera = Integer.parseInt(FTFTiempo.getText());
        
        LNuevoTiempo.setText(tiempoFormateado(tiempoBandera));
    }//GEN-LAST:event_FTFTiempoKeyReleased

    private void FTFTiempoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTFTiempoFocusGained
        FTFTiempo.selectAll();
    }//GEN-LAST:event_FTFTiempoFocusGained

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        aceptar = true;
        cierra();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        aceptar = false;
        cierra();
    }//GEN-LAST:event_BCancelaActionPerformed

    public boolean getAcepto(){
        return aceptar;
    }
    
    public int getTiempoBandera(){
        return tiempoBandera;
    }
    
    private void cierra(){
        dispose();
    }
    
    private String tiempoFormateado(int TiempoLimite){
        String tiempo;
        
        int horas   = TiempoLimite / 60;
        int minutos = TiempoLimite % 60;
        
        tiempo  = (horas   < 10) ?  "0" + horas           : ""  + horas;
        tiempo += (minutos < 10) ? ":0" + minutos + ":00" : ":" + minutos + ":00";
        
        return tiempo;
    }
       
    private class picoEnter extends AbstractAction{
        public picoEnter(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 1: BAceptar.doClick(); break;
                case 2: BCancela.doClick(); break;
            }
        }
        int caso;
    }
    
    private class picoEscape extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            cierra();
        }
    }
    
    private class picoFlecha extends AbstractAction{
        public picoFlecha(int caso){
            this.caso = caso;
        }

        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 1: BCancela.requestFocus(); break;
                case 2: BAceptar.requestFocus(); break;
            }
        }
        int caso;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BCancela;
    private javax.swing.JFormattedTextField FTFTiempo;
    private javax.swing.JLabel LNuevoTiempo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    int tiempoBandera = 0;
    boolean aceptar = false;
    soloNumeros valida = new soloNumeros();
}