package Dialogos;

import Util.soloNumeros;
import Util.validaALaMexicana;
import setters_getters.setGetTarifas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.JButton;

public class diagIniMaquina extends javax.swing.JDialog {

    public diagIniMaquina(java.awt.Frame parent, boolean modal, String nombre, ArrayList<setGetTarifas> Tarifas) {
        super(parent, modal);
        this.Tarifas = Tarifas;
        initComponents();
        misComponentes();
        setTitle("Iniciando " + nombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JFTFPrepago = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        TFTLimite = new javax.swing.JTextField();
        CBTarifa = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("<HTML>Tiempo Rentado<P>(en minutos)</HTML>");

        JFTFPrepago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        JFTFPrepago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        JFTFPrepago.setText("0.00");
        JFTFPrepago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JFTFPrepagoFocusGained(evt);
            }
        });
        JFTFPrepago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JFTFPrepagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFTFPrepagoKeyTyped(evt);
            }
        });

        jLabel2.setText("Prepago");

        TFTLimite.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFTLimite.setText("0");
        TFTLimite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFTLimiteKeyTyped(evt);
            }
        });

        CBTarifa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CBTarifaKeyTyped(evt);
            }
        });

        jLabel3.setText("Tarifa");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        BAceptar.setText("Iniciar");
        BAceptar.setPreferredSize(new java.awt.Dimension(75, 23));
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(BAceptar);

        BCancela.setText("Cancelar");
        BCancela.setPreferredSize(new java.awt.Dimension(80, 23));
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
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFTLimite, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(CBTarifa, 0, 89, Short.MAX_VALUE)
                    .addComponent(JFTFPrepago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFTLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JFTFPrepago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void misComponentes(){
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0) , "picoEscape" );
        JFTFPrepago.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "picoEscape");

        BAceptar.getActionMap().put("picoFlecha", new picoFlecha(1));
        BAceptar.getActionMap().put("picoEnter" , new picoEnter (1));
        BCancela.getActionMap().put("picoFlecha", new picoFlecha(2));
        BCancela.getActionMap().put("picoEnter" , new picoEnter (2));
        BCancela.getActionMap().put("picoEscape", new picoEscape( ));
        JFTFPrepago.getActionMap().put("picoEscape", new picoEscape());
        
        for(int i = 0 ; i < Tarifas.size() ; i++){
            CBTarifa.addItem(Tarifas.get(i).getTarifa());
        }
    }
    
    private void TFTLimiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFTLimiteKeyTyped
        if(TFTLimite.getText().equals(""))
                TFTLimite.setText("0");
        int tecla = Valida.soloNum(evt);
        if(tecla == -1)
            evt.consume();
        else if(tecla == 10)
            TFTLimite.transferFocus();
        else{
            validaLimite(evt);
            evt.consume();
        }
    }//GEN-LAST:event_TFTLimiteKeyTyped

    private void JFTFPrepagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JFTFPrepagoFocusGained
        JFTFPrepago.selectAll();
    }//GEN-LAST:event_JFTFPrepagoFocusGained

    private void JFTFPrepagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFTFPrepagoKeyReleased
        Valida.soloDecimalReleased(JFTFPrepago);
    }//GEN-LAST:event_JFTFPrepagoKeyReleased

    private void JFTFPrepagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFTFPrepagoKeyTyped
        Valida.soloDecimalTyped(evt, JFTFPrepago);
    }//GEN-LAST:event_JFTFPrepagoKeyTyped

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        inicia = false;
        cierra();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        inicia = true;
        cierra();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void CBTarifaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBTarifaKeyTyped
        if(evt.getKeyChar() == 10)
            CBTarifa.transferFocus();
    }//GEN-LAST:event_CBTarifaKeyTyped

    public boolean getAcepto(){
        return inicia;
    }
    
    public Object getIdTarifa(){
        return Tarifas.get(CBTarifa.getSelectedIndex()).getID();
    }
    
    public double getPrepago(){
        String Prepago = new validaALaMexicana().mexicanaDecimal(JFTFPrepago.getText());
        return Double.parseDouble(Prepago);
    }
    
    public int getTarifa(){
        return CBTarifa.getSelectedIndex();
    }
    
    public int getTiempoLimite(){
        return Integer.parseInt(TFTLimite.getText());
    }
    
    private void cierra(){
        dispose();
    }
    
    private void validaLimite(KeyEvent evt){
        if((int)evt.getKeyChar() != KeyEvent.VK_BACK_SPACE){
            String valor = TFTLimite.getText();
            if(valor.equals(""))
                TFTLimite.setText(evt.getKeyChar() + "");
            else if (Integer.parseInt(valor) == 0)
                TFTLimite.setText(evt.getKeyChar() + "");
            else
                TFTLimite.setText(valor + evt.getKeyChar());
        }
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
    private javax.swing.JComboBox CBTarifa;
    private javax.swing.JFormattedTextField JFTFPrepago;
    private javax.swing.JTextField TFTLimite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    boolean inicia = false;
    ArrayList<setGetTarifas> Tarifas = new ArrayList();
    soloNumeros Valida = new soloNumeros();
}