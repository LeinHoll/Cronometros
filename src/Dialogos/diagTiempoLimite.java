package Dialogos;

import Util.Crono;
import Util.soloNumeros;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;

public class diagTiempoLimite extends javax.swing.JDialog {

    public diagTiempoLimite(java.awt.Frame parent, boolean modal, Crono Reloj) {
        super(parent, modal);
        initComponents();
        this.Reloj = Reloj;
        misComponentes();
    }

    private void misComponentes(){
        setTitle("Tiempo de " + Reloj.getMaquina().getNombre());
        
        FTFTiempo       .setText(Reloj.getTiempoLimite() + "");
        LTiempoRentado  .setText(tiempoFormateado(Reloj.getTiempoLimite()));
        LNuevoTiempo    .setText(tiempoFormateado(Reloj.getTiempoLimite()));
        
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

        jLabel1 = new javax.swing.JLabel();
        LTiempoRentado = new javax.swing.JLabel();
        LNuevoTiempo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FTFTiempo = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Minutos Rentados:");

        LTiempoRentado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LTiempoRentado.setText("00:00:00");

        LNuevoTiempo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LNuevoTiempo.setText("00:00:00");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("=");

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

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        BAceptar.setText("O");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(BAceptar);

        BCancela.setText("X");
        BCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelaActionPerformed(evt);
            }
        });
        jPanel2.add(BCancela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FTFTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LTiempoRentado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LNuevoTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LTiempoRentado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FTFTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LNuevoTiempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        acepta = true;
        cierra();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        acepta = false;
        cierra();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void FTFTiempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFTiempoKeyTyped
        int tecla = new soloNumeros().soloNum(evt);
        if(tecla <= -1){
            evt.consume();
        } else if(tecla == 10){
            FTFTiempo.transferFocus();
        }
    }//GEN-LAST:event_FTFTiempoKeyTyped

    private void FTFTiempoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTFTiempoFocusGained
        FTFTiempo.selectAll();
    }//GEN-LAST:event_FTFTiempoFocusGained

    private void FTFTiempoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFTiempoKeyReleased
        if(FTFTiempo.getText().equals(""))
            nuevoTiempoLimite = 0;
        else
            nuevoTiempoLimite = Integer.parseInt(FTFTiempo.getText());
        
        LNuevoTiempo.setText(tiempoFormateado(nuevoTiempoLimite));
    }//GEN-LAST:event_FTFTiempoKeyReleased

    public boolean getAcepto(){
        return acepta;
    }
    
    public int getNuevoTiempoLimite(){
        return nuevoTiempoLimite;
    }

    private String tiempoFormateado(int TiempoLimite){
        String tiempo;
        
        int horas   = TiempoLimite / 60;
        int minutos = TiempoLimite % 60;
        
        tiempo  = (horas   < 10) ?  "0" + horas           : ""  + horas;
        tiempo += (minutos < 10) ? ":0" + minutos + ":00" : ":" + minutos + ":00";
        
        return tiempo;
    }
    
    private void cierra(){
        dispose();
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
    private javax.swing.JLabel LTiempoRentado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    int nuevoTiempoLimite = 0;
    boolean acepta = false;
    Crono Reloj;
}