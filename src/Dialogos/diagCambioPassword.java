package Dialogos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.KeyStroke;

public class diagCambioPassword extends javax.swing.JDialog {

    public diagCambioPassword(java.awt.Dialog parent, boolean modal, String actual) {
        super(parent, modal);
        this.actual = actual;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        TActual .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TNueva  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TRepite .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        TActual .getActionMap().put("enter", new accionTextoEnter(TActual));
        TNueva  .getActionMap().put("enter", new accionTextoEnter(TNueva));
        TRepite .getActionMap().put("enter", new accionTextoEnter(TRepite));
        
        BOk         .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BCancelar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BOk         .getActionMap().put("enter", new accionBotonEnter(BOk));
        BCancelar   .getActionMap().put("enter", new accionBotonEnter(BCancelar));
        
        BOk         .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "horizontal");
        BCancelar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "horizontal");
        
        BOk         .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "horizontal");
        BCancelar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "horizontal");
        
        BOk         .getActionMap().put("horizontal", new accionBotonHorizontal());
        BCancelar   .getActionMap().put("horizontal", new accionBotonHorizontal());
    }
    
    public boolean getSalvo(){
        return salvar;
    }
    
    public String getPassword(){
        char[] CPass = TNueva.getPassword();
        String SPass = "";
        for(int i = 0 ; i < CPass.length ; i++){
            SPass += CPass[i];
        }
        return SPass;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TActual = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TNueva = new javax.swing.JPasswordField();
        TRepite = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        BOk = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambio pase");

        jLabel1.setText("Contraseña actual:");

        jLabel2.setText("Nueva contraseña:");

        jLabel3.setText("Repitala:");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        BOk.setText("OK");
        BOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOkActionPerformed(evt);
            }
        });
        jPanel1.add(BOk);

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TActual, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TNueva, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(TRepite, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TRepite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        salvar = false;
        dispose();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOkActionPerformed
        char[] Actual = TActual .getPassword();
        char[] nuevo1 = TNueva  .getPassword();
        char[] nuevo2 = TRepite .getPassword();
        
        boolean aprovado = true;
        
        int largo = Actual.length;
        
        if(largo < nuevo1.length)
            largo = nuevo1.length;
        if(nuevo1.length != nuevo2.length)
            aprovado = false;
        
        String sActual = "";
        String sN1 = "";
        String sN2 = "";
        
        if(aprovado){
            for(int i = 0 ; i < largo ; i++){
                if(i < Actual.length)
                    sActual += Actual[i];
                if(i < nuevo1.length){
                    sN1 += nuevo1[i];
                    sN2 += nuevo2[i];
                }
            }
            
            if(!actual.equals(sActual) || !sN1.equals(sN2))
                aprovado = false;
        }
        
        if(aprovado){
            salvar = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, 
                    "La contraseña actual es incorrecta\n"
                    + "o los campos de contraseña nueva\n"
                    + "no concuerdan", "Error", JOptionPane.WARNING_MESSAGE);
            TActual .setText("");
            TNueva  .setText("");
            TRepite .setText("");
            
            TActual.requestFocus();
        }
    }//GEN-LAST:event_BOkActionPerformed

    private class accionTextoEnter extends AbstractAction {
        public accionTextoEnter(JPasswordField pass){
            this.pass = pass;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            pass.transferFocus();
        }
        JPasswordField pass;
    }
    
    private class accionBotonEnter extends AbstractAction {
        public accionBotonEnter(JButton boton){
            this.boton = boton;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            boton.doClick();
        }
        JButton boton;
    }
    
    private class accionBotonHorizontal extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BOk.isFocusOwner()){
                BCancelar.requestFocus();
            } else if(BCancelar.isFocusOwner()){
                BOk.requestFocus();
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BOk;
    private javax.swing.JPasswordField TActual;
    private javax.swing.JPasswordField TNueva;
    private javax.swing.JPasswordField TRepite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    String actual;
    boolean salvar = false;
}