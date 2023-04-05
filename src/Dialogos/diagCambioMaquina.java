package Dialogos;

import Util.Crono;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class diagCambioMaquina extends javax.swing.JDialog {

    public diagCambioMaquina(java.awt.Frame parent, boolean modal, Crono reloj, ArrayList<Crono> Relojes) {
        super(parent, modal);
        initComponents();
        this.reloj   = reloj;
        this.Relojes = Relojes;
        misComponentes();
    }

    private void misComponentes(){
        int maquina = reloj.getFila() + 1;
        setTitle("Mudando maquina " + maquina);
        
        ListaMaquinas.setModel(new modeloLista());
        if(ListaMaquinas.getModel().getSize() > 0)
            ListaMaquinas.setSelectedIndex(0);
        
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
    
    private class modeloLista extends DefaultListModel {
        
        public modeloLista(){
            for(int i = 0 ; i < Relojes.size() ; i++){
                int maquina = i + 1;
                if(Relojes.get(i).getEstado() == Crono.ESTADO_STANDBY)
                    addElement("Maquina " + maquina);
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaMaquinas = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Swap");
        setResizable(false);

        jLabel1.setText("Elige el destino");

        ListaMaquinas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListaMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMaquinasMouseClicked(evt);
            }
        });
        ListaMaquinas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ListaMaquinasKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(ListaMaquinas);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaMaquinasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListaMaquinasKeyTyped
        acepto = true;
        cierra();
    }//GEN-LAST:event_ListaMaquinasKeyTyped

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        acepto = true;
        cierra();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        acepto = false;
        cierra();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void ListaMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMaquinasMouseClicked
        if(SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2){
            acepto = true;
            cierra();
        }
    }//GEN-LAST:event_ListaMaquinasMouseClicked

    public boolean getAcepto(){
        return acepto;
    }
    
    public int getDestino(){
        return Integer.parseInt(ListaMaquinas.getSelectedValue().toString().replace("Maquina ", "")) - 1;
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
                case 1: BAceptar .doClick(); break;
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
    private javax.swing.JList ListaMaquinas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    boolean acepto = false;
    ArrayList<Crono> Relojes;
    Crono reloj;
}