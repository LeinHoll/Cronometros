package Dialogos;

import Util.Crono;
import Util.soloNumeros;
import Util.validaALaMexicana;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;

public class diagPrepago extends javax.swing.JDialog {

    public diagPrepago(java.awt.Frame parent, boolean modal, Crono Reloj) {
        super(parent, modal);
        initComponents();
        this.Reloj = Reloj;
        misComponentes();
    }

    private void misComponentes(){
        setTitle("Prepagos de " + Reloj.getMaquina().getNombre());
        
        LTotal      .setText("$ " + decimal.format(Reloj.getTarifa() + Reloj.getConsumo()));
        LPrepago    .setText("$ " + decimal.format(Reloj.getPrepago()));
        LResultado  .setText("$ " + decimal.format(Reloj.getTotal()));
        
        BAcepta .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BAcepta .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BAcepta .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), "picoEscape");
        RBSuma  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        RBSuma  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        RBSuma  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        RBResta .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        RBResta .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        RBResta .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );

        BAcepta .getActionMap().put("picoFlecha", new picoFlecha(1));
        BAcepta .getActionMap().put("picoEnter" , new picoEnter (1));
        BCancela.getActionMap().put("picoFlecha", new picoFlecha(2));
        BCancela.getActionMap().put("picoEnter" , new picoEnter (2));
        BCancela.getActionMap().put("picoEscape", new picoEscape( ));
        RBResta .getActionMap().put("picoFlecha", new picoFlecha(3));
        RBResta .getActionMap().put("picoEnter" , new picoEnter (3));
        RBSuma  .getActionMap().put("picoFlecha", new picoFlecha(4));
        RBSuma  .getActionMap().put("picoEnter" , new picoEnter (4));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGGrupo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LPrepago = new javax.swing.JLabel();
        LCaso = new javax.swing.JLabel();
        LTotal = new javax.swing.JLabel();
        FTFAbono = new javax.swing.JFormattedTextField();
        RBSuma = new javax.swing.JRadioButton();
        RBResta = new javax.swing.JRadioButton();
        LResultado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BAcepta = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Monto a pagar:");

        jLabel2.setText("Monto abonado:");

        LPrepago.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LPrepago.setText("$ 0.00");

        LCaso.setText("Balance:");

        LTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LTotal.setText("$ 0.00");

        FTFAbono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        FTFAbono.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        FTFAbono.setText("0.00");
        FTFAbono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FTFAbonoMouseClicked(evt);
            }
        });
        FTFAbono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FTFAbonoFocusGained(evt);
            }
        });
        FTFAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FTFAbonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FTFAbonoKeyTyped(evt);
            }
        });

        BGGrupo.add(RBSuma);
        RBSuma.setSelected(true);
        RBSuma.setText("Sumale");
        RBSuma.setNextFocusableComponent(FTFAbono);
        RBSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBSumaActionPerformed(evt);
            }
        });

        BGGrupo.add(RBResta);
        RBResta.setText("Restale");
        RBResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBRestaActionPerformed(evt);
            }
        });

        LResultado.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LResultado.setText("$ 0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(RBSuma))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(LCaso, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(RBResta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LPrepago, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(FTFAbono, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LPrepago)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RBResta, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(FTFAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LResultado)
                    .addComponent(LCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        BAcepta.setText("Aceptar");
        BAcepta.setPreferredSize(new java.awt.Dimension(75, 23));
        BAcepta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptaActionPerformed(evt);
            }
        });
        jPanel2.add(BAcepta);

        BCancela.setText("Cancelar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FTFAbonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTFAbonoFocusGained
        FTFAbono.selectAll();
    }//GEN-LAST:event_FTFAbonoFocusGained

    private void FTFAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFAbonoKeyReleased
        Valida.soloDecimalReleased(FTFAbono);
        calculaEnTyped();
    }//GEN-LAST:event_FTFAbonoKeyReleased

    private void FTFAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFAbonoKeyTyped
        Valida.soloDecimalTyped(evt, FTFAbono);
    }//GEN-LAST:event_FTFAbonoKeyTyped

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        acepto = false;
        cierra();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void BAceptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptaActionPerformed
        acepto = true;
        cierra();
    }//GEN-LAST:event_BAceptaActionPerformed

    private void RBSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBSumaActionPerformed
        calculaEnTyped();
    }//GEN-LAST:event_RBSumaActionPerformed

    private void RBRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBRestaActionPerformed
        calculaEnTyped();
    }//GEN-LAST:event_RBRestaActionPerformed

    private void FTFAbonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FTFAbonoMouseClicked
        FTFAbono.selectAll();
    }//GEN-LAST:event_FTFAbonoMouseClicked

    public boolean getAcepto(){
        return acepto;
    }
    
    public double getPrepagoResultante(){
        return prepagoResultante;
    }
    
    private void calcula(double valor){
        double importe = Reloj.getTarifa() + Reloj.getConsumo();
        double prepago = Reloj.getPrepago();
        double balance;
        
        if(RBSuma.isSelected()){
            balance = prepago + valor;
        } else{
            if(valor > prepago)
                balance = 0;
            else
                balance = prepago - valor;
        }
        
        prepagoResultante = balance;

        colorea(importe - balance);
    }
    
    private void calculaEnTyped(){
        String formateado  = decimal .format(Double.parseDouble(FTFAbono.getText()));
        String mexicaneado = mexicana.mexicanaDecimal(formateado);
        
        calcula(Double.parseDouble(mexicaneado));
    }
    
    private void cierra(){
        dispose();
    }
    
    private void colorea(double resultado){
        
        if(resultado < 0)
            LResultado.setForeground(Color.red);
        else
            LResultado.setForeground(new Color(0,0,0));
        
        LTotal    .setText("$ " + decimal.format(Reloj.getTarifa() + Reloj.getConsumo()));
        LPrepago  .setText("$ " + decimal.format(Reloj.getPrepago()));
        LResultado.setText("$ " + decimal.format(Math.abs(resultado)));
    }
        
    private class picoEnter extends AbstractAction{
        public picoEnter(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 1: BAcepta .doClick(); break;
                case 2: BCancela.doClick(); break;
                case 3:
                    RBResta.setSelected(true);
                    FTFAbono.selectAll();
                    FTFAbono.requestFocus();
                    break;
                case 4:
                    RBSuma.setSelected(true);
                    FTFAbono.selectAll();
                    FTFAbono.requestFocus();
                    break;
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
                case 2: BAcepta .requestFocus(); break;
                case 3: 
                    RBSuma.setSelected(true);
                    RBSuma.requestFocus(); 
                    break;
                case 4: 
                    RBResta.setSelected(true);
                    RBResta.requestFocus(); 
                    break;
            }
        }
        int caso;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAcepta;
    private javax.swing.JButton BCancela;
    private javax.swing.ButtonGroup BGGrupo;
    private javax.swing.JFormattedTextField FTFAbono;
    private javax.swing.JLabel LCaso;
    private javax.swing.JLabel LPrepago;
    private javax.swing.JLabel LResultado;
    private javax.swing.JLabel LTotal;
    private javax.swing.JRadioButton RBResta;
    private javax.swing.JRadioButton RBSuma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    double prepagoResultante = 0;
    boolean acepto = false;
    DecimalFormat decimal = new DecimalFormat("#,##0.00");
    Crono Reloj;
    soloNumeros Valida = new soloNumeros();
    validaALaMexicana mexicana = new validaALaMexicana();
}