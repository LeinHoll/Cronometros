package Dialogos;

import Paneles.panelConsumos;
import Util.Crono;
import Tablas.modeloTablaConsumos;
import Util.soloNumeros;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class diagFinMaquina extends javax.swing.JDialog {

    public diagFinMaquina(java.awt.Frame parent, boolean modal, Crono Reloj) {
        super(parent, modal);
        initComponents();
        this.Reloj = Reloj;
        misComponentes();
        FTFPago.requestFocus();
    }

    private void misComponentes(){
        setTitle("Finalizando " + Reloj.getMaquina().getNombre());
        LPrepago.setText("$ " + decimal.format(Reloj.getPrepago()));
                
        panelCard.add("cons", PConsumos = new panelConsumos(
                this,
                modelo = new modeloTablaConsumos(
                        Reloj.getConsumos(),
                        Reloj.getDatosFinales(), 
                        LTotal), 
                new picoEscape(), 
                Reloj.getFrame().getLinker()));
        
        colorea(modelo.getTotalTabla() - Reloj.getPrepago());
        
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), "picoEscape");
        FTFPago .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0) , "picoEscape" );

        BAceptar.getActionMap().put("picoFlecha", new picoFlecha(1));
        BAceptar.getActionMap().put("picoEnter" , new picoEnter (1));
        BCancela.getActionMap().put("picoFlecha", new picoFlecha(2));
        BCancela.getActionMap().put("picoEnter" , new picoEnter (2));
        BCancela.getActionMap().put("picoEscape", new picoEscape( ));
        FTFPago .getActionMap().put("picoEscape", new picoEscape( ));
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                cierraSalvando();
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        LTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        LTipoDeCambio = new javax.swing.JLabel();
        LCambio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LPrepago = new javax.swing.JLabel();
        FTFPago = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();
        panelCard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Total de la Renta");

        LTotal.setFont(new java.awt.Font("Arial", 1, 20));
        LTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LTotal.setText("$ 0.00");
        LTotal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LTotalPropertyChange(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("El cliente pago:");

        LTipoDeCambio.setText("Cambio para el Cliente:");

        LCambio.setFont(new java.awt.Font("Arial", 1, 20));
        LCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LCambio.setText("$ 0.00");

        jLabel4.setText("Total Prepagado");

        LPrepago.setFont(new java.awt.Font("Arial", 1, 20));
        LPrepago.setForeground(new java.awt.Color(0, 102, 0));
        LPrepago.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        LPrepago.setText("$ 0.00");

        FTFPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        FTFPago.setText("0.00");
        FTFPago.setFont(new java.awt.Font("Arial", 1, 20));
        FTFPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FTFPagoFocusGained(evt);
            }
        });
        FTFPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FTFPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FTFPagoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(LPrepago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(FTFPago, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                    .addComponent(LTipoDeCambio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LPrepago))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(LTipoDeCambio))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(FTFPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LCambio)))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        BAceptar.setFont(new java.awt.Font("Tahoma", 0, 20));
        BAceptar.setText("Terminar");
        BAceptar.setMaximumSize(new java.awt.Dimension(87, 33));
        BAceptar.setMinimumSize(new java.awt.Dimension(87, 33));
        BAceptar.setPreferredSize(new java.awt.Dimension(150, 50));
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(BAceptar);

        BCancela.setFont(new java.awt.Font("Tahoma", 0, 20));
        BCancela.setText("Cancelar");
        BCancela.setPreferredSize(new java.awt.Dimension(150, 50));
        BCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelaActionPerformed(evt);
            }
        });
        jPanel2.add(BCancela);

        panelCard.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        finalizo     = true;
        cierraSalvando();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        finalizo     = false;
        cierraSalvando();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void FTFPagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTFPagoFocusGained
        FTFPago.selectAll();
    }//GEN-LAST:event_FTFPagoFocusGained

    private void FTFPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFPagoKeyReleased
        Valida.soloDecimalReleased(FTFPago);
        colorea(modelo.getTotalTabla() - Reloj.getPrepago() - Double.parseDouble(FTFPago.getText()));
    }//GEN-LAST:event_FTFPagoKeyReleased

    private void FTFPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFPagoKeyTyped
        Valida.soloDecimalTyped(evt, FTFPago);
    }//GEN-LAST:event_FTFPagoKeyTyped

    private void LTotalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LTotalPropertyChange
        try{
            colorea(modelo.getTotalTabla() - Reloj.getPrepago() - Double.parseDouble(FTFPago.getText()));
        } catch(Exception exc){}
    }//GEN-LAST:event_LTotalPropertyChange

    public boolean getFinalizo(){
        return finalizo;
    }
    
    public modeloTablaConsumos getModelo(){
        return modelo;
    }
    
    public boolean getSalvaCambios(){
        return salvaCambios;
    }
    
    private void cierra(){
        dispose();
    }
    
    private void cierraSalvando(){
        if(PConsumos.getEditado()){
            switch(JOptionPane.showConfirmDialog(
                    null, 
                    "Confirme salvar cambios", 
                    "Confirme", 
                    JOptionPane.YES_NO_CANCEL_OPTION)){
                case 0: salvaCambios = true ; cierra(); break;
                case 1: salvaCambios = false; cierra(); break;
            }
        } else {
            salvaCambios = false; cierra();
        }
    }
    
    private void colorea(double Cambio){
        if(Cambio < 0){
            LTipoDeCambio.setText("Cambio para el cliente");
            LCambio.setForeground(Color.red);
        } else if(Cambio > 0){
            LTipoDeCambio.setText("El Cliente debe");
            LCambio.setForeground(Color.green);
        } else {
            LTipoDeCambio.setText("No hay cambio");
            LCambio.setForeground(Color.black);
        }
        LCambio.setText("$ " + decimal.format(Math.abs(Cambio)));
    }
    
    private class picoEnter extends AbstractAction{
        public picoEnter(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 1: BAceptar .doClick(); break;
                case 2: BCancela.doClick(); break;
            }
        }
        int caso;
    }
    
    private class picoEscape extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            cierraSalvando();
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
    private javax.swing.JFormattedTextField FTFPago;
    private javax.swing.JLabel LCambio;
    private javax.swing.JLabel LPrepago;
    private javax.swing.JLabel LTipoDeCambio;
    private javax.swing.JLabel LTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelCard;
    // End of variables declaration//GEN-END:variables
    boolean finalizo     = false;
    boolean salvaCambios = false;
    DecimalFormat decimal = new DecimalFormat("#,##0.00");
    Crono Reloj;
    modeloTablaConsumos modelo;
    soloNumeros Valida = new soloNumeros();
    panelConsumos PConsumos;
}