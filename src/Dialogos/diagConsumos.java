package Dialogos;

import Paneles.panelConsumos;
import Util.Crono;
import Tablas.modeloTablaConsumos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class diagConsumos extends javax.swing.JDialog {

    public diagConsumos(java.awt.Frame parent, boolean modal, Crono Reloj) {
        super(parent, modal);
        initComponents();
        this.Reloj = Reloj;
        misComponentes();
    }

    private void misComponentes(){
        setTitle("Consumos de " + Reloj.getMaquina().getNombre());
        modelo = new modeloTablaConsumos(Reloj.getConsumos(), LTotal);
        PConsumos = new panelConsumos(this, modelo , new picoEscape(), Reloj.getFrame().getLinker());
        
        panelCard.add("cons", PConsumos);
        
        try {
            LTotal.setText("$ " + new DecimalFormat("#,##0.00").format(Reloj.getConsumo()));
        } catch(Exception exc){
            JOptionPane.showMessageDialog(null, exc);
        }
        
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT  , 0) , "picoFlecha" );
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0) , "picoEnter"  );

        BAceptar.getActionMap().put("picoFlecha", new picoFlecha(1));
        BAceptar.getActionMap().put("picoEnter" , new picoEnter (1));
        BCancela.getActionMap().put("picoFlecha", new picoFlecha(2));
        BCancela.getActionMap().put("picoEnter" , new picoEnter (2));
        
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

        jLabel1 = new javax.swing.JLabel();
        BCancela = new javax.swing.JButton();
        BAceptar = new javax.swing.JButton();
        LTotal = new javax.swing.JLabel();
        panelCard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Total:");

        BCancela.setFont(new java.awt.Font("Tahoma", 0, 20));
        BCancela.setText("Cancelar");
        BCancela.setPreferredSize(new java.awt.Dimension(150, 50));
        BCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelaActionPerformed(evt);
            }
        });

        BAceptar.setFont(new java.awt.Font("Tahoma", 0, 20));
        BAceptar.setText("Salvar");
        BAceptar.setPreferredSize(new java.awt.Dimension(150, 50));
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });

        LTotal.setFont(new java.awt.Font("Arial", 1, 20));
        LTotal.setText("$ 0.00");

        panelCard.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BCancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(LTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        acepta = true;
        if(PConsumos.estaEditando())
            PConsumos.detenEdicion();
        cierra();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        acepta = false;
        cierra();
    }//GEN-LAST:event_BCancelaActionPerformed

    public boolean getAcepto(){
        return acepta;
    }
    
    public modeloTablaConsumos getModelo(){
        return modelo;
    }
    
    private void cierra(){
        dispose();
    }
    
    private void cierraSalvando(){
        if(PConsumos.getEditado()){
            switch(JOptionPane.showConfirmDialog(
                    null, 
                    "Confirme salvar cambios", 
                    "confirme", 
                    JOptionPane.YES_NO_CANCEL_OPTION)){
                case 0: acepta = true ; cierra(); break;
                case 1: acepta = false; cierra(); break;
            }
        } else {
            acepta = false; cierra();
        }
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
    private javax.swing.JLabel LTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelCard;
    // End of variables declaration//GEN-END:variables
    boolean             acepta      = false;
    Crono               Reloj       ;
    modeloTablaConsumos modelo      ;
    panelConsumos       PConsumos   ;
}