package Frames;

import Arranque.Inicio;
import Util.Conector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class frameLogIn extends javax.swing.JFrame {

    public frameLogIn(Inicio ini, Conector linker) {
        this.ini    = ini   ;
        this.linker = linker;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        checaDB();
        
        TUser.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TPass.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        TUser.getActionMap().put("enter", new accionTextoEnter());
        TPass.getActionMap().put("enter", new accionTextoEnter());
        
        BOk         .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BCancelar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BOk         .getActionMap().put("enter", new accionBotonEnter());
        BCancelar   .getActionMap().put("enter", new accionBotonEnter());
        
        BOk         .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "flecha");
        BCancelar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "flecha");
        
        BOk         .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "flecha");
        BCancelar   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "flecha");
        
        BOk         .getActionMap().put("flecha", new accionBotonFlecha());
        BCancelar   .getActionMap().put("flecha", new accionBotonFlecha());
    }
    
    private void checaDB(){
        try {
            String      SQL = "SELECT ID FROM Usuarios" ;
            ResultSet   RS  = linker.consulta(SQL)      ;
            
            if(!RS.next())
                linker.usuarioDefault();
            
            RS.close();
        } catch(Exception exc) {}
    }
        
    private void cerrando(){
        if(JOptionPane.showConfirmDialog(
                null, 
                "Confirme cerrar programa", 
                "Confirme", 
                JOptionPane.YES_NO_OPTION) == 0){
            try {
                linker.cierra();
            } catch(Exception exc) {}
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BOk = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        TUser = new javax.swing.JTextField();
        TPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cronometros 2.0");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nombre de Usuario: ");

        jLabel2.setText("Contraseña: ");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        BOk.setText("Ok");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TPass, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(TUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrando();
    }//GEN-LAST:event_formWindowClosing

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        cerrando();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOkActionPerformed
        try {
            String SQL = ""
                    + "SELECT ID, password "
                    + "FROM Usuarios "
                    + "WHERE usuario = '" + TUser.getText() + "'";
            ResultSet RS = linker.consulta(SQL);
            if(RS.next()) {
                String SPass = "";
                char[] CPass = TPass.getPassword();
                
                for(char c : CPass)
                    SPass += c;
                
                if(SPass.equals(RS.getString("password"))) {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Bienvenido " + TUser.getText());
                    synchronized(ini){
                        ini.setID(RS.getInt("ID"));
                        ini.setEspera(false);
                        ini.notify();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    TPass.setText("");
                    TPass.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el usuario");
                TPass.setText("");
                TUser.setText("");
                TUser.requestFocus();
            }
            RS.close();
        } catch(Exception exc) {}
    }//GEN-LAST:event_BOkActionPerformed

    private class accionTextoEnter extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent evt){
            BOk.doClick();
        }
    }
    
    private class accionBotonEnter extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent evt){
           if(BOk.isFocusOwner())
               BOk.doClick();
           else if(BCancelar.isFocusOwner())
               BCancelar.doClick();
        }
    }
    
    private class accionBotonFlecha extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BOk.isFocusOwner())
                BCancelar.requestFocus();
            else if(BCancelar.isFocusOwner())
                BOk.requestFocus();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BOk;
    private javax.swing.JPasswordField TPass;
    private javax.swing.JTextField TUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    Conector        linker  ;
    final Inicio    ini     ;
}