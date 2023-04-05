package Dialogos;

import setters_getters.setGetTarifas;
import setters_getters.setGetPermisos;
import Tablas.modeloTablaAdminTarifasLv2;
import Util.Conector;
import Util.Crono;
import Util.modeloListaAdminTarifas;
import Util.upsy;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class diagAdminTarifas extends javax.swing.JDialog {

    public diagAdminTarifas(java.awt.Frame parent, boolean modal, Conector linker, ArrayList<Crono> Reloj, setGetPermisos responsable) {
        super(parent, modal);
        this.responsable    = responsable;
        this.linker         = linker;
        this.Reloj          = Reloj;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        ListTarifas.setModel(modelo);
        
        BNuevo  .setEnabled(responsable.getBool_tar_alt());
        BElimina.setEnabled(responsable.getBool_tar_baj());
        
        BNuevo  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "picoFlechaIzquierda");
        BEdita  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "picoFlechaIzquierda");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "picoFlechaIzquierda");
        BTermina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "picoFlechaIzquierda");
        
        BNuevo  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlechaAbajo");
        BEdita  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlechaAbajo");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlechaAbajo");
        BTermina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlechaAbajo");
        
        BNuevo  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlechaArriba");        
        BEdita  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlechaArriba");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlechaArriba");
        BTermina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlechaArriba");
        
        BNuevo  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        BEdita  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        BTermina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        
        BNuevo  .getActionMap().put("picoFlechaIzquierda", new accionFlechaIzquierda());
        BEdita  .getActionMap().put("picoFlechaIzquierda", new accionFlechaIzquierda());
        BElimina.getActionMap().put("picoFlechaIzquierda", new accionFlechaIzquierda());
        BTermina.getActionMap().put("picoFlechaIzquierda", new accionFlechaIzquierda());
        
        BNuevo  .getActionMap().put("picoFlechaAbajo", new accionFlechaAbajo(0));
        BEdita  .getActionMap().put("picoFlechaAbajo", new accionFlechaAbajo(1));
        BElimina.getActionMap().put("picoFlechaAbajo", new accionFlechaAbajo(2));
        BTermina.getActionMap().put("picoFlechaAbajo", new accionFlechaAbajo(3));
        
        BNuevo  .getActionMap().put("picoFlechaArriba", new accionFlechaArriba(0));
        BEdita  .getActionMap().put("picoFlechaArriba", new accionFlechaArriba(1));
        BElimina.getActionMap().put("picoFlechaArriba", new accionFlechaArriba(2));
        BTermina.getActionMap().put("picoFlechaArriba", new accionFlechaArriba(3));
        
        BNuevo  .getActionMap().put("picoEnter", new accionEnter(0));
        BEdita  .getActionMap().put("picoEnter", new accionEnter(1));
        BElimina.getActionMap().put("picoEnter", new accionEnter(2));
        BTermina.getActionMap().put("picoEnter", new accionEnter(3));

        misTarifas();
    }
    
    private void misTarifas(){
        try{
            Tarifas.clear();
            ResultSet RSTarifas = linker.consulta("SELECT * FROM Tarifas");
            
            while(RSTarifas.next()){
                setGetTarifas tarifa = new setGetTarifas();
                                
                tarifa.setID      (RSTarifas.getInt   ("ID"   ));
                tarifa.setLapso   (RSTarifas.getInt   ("lapso"));
                tarifa.setPrecio  (RSTarifas.getDouble("precio"));
                tarifa.setTarifa  (RSTarifas.getString("tarifa"));
                                
                Tarifas.add(tarifa);
            }
            
            RSTarifas.close();
            
            for(int i = 0 ; i < Tarifas.size() ; i++){
                ResultSet RSBanderas = linker.consulta("SELECT * "
                        + "FROM Tarifa_Banderas "
                        + "WHERE id_tarifa = " + Tarifas.get(i).getID());
                Tarifas.get(i).setBanderas(RSBanderas);
            }
            
            modelo.setListado(Tarifas);
        }catch(Exception exc){
            ouch.whoops("misTarifas()", exc);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListTarifas = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        BNuevo = new javax.swing.JButton();
        BEdita = new javax.swing.JButton();
        BElimina = new javax.swing.JButton();
        BTermina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administracion de Tarifas");
        setResizable(false);

        jScrollPane1.setViewportView(ListTarifas);

        jPanel1.setLayout(new java.awt.GridLayout(4, 0, 0, 15));

        BNuevo.setText("Nueva Tarifa");
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(BNuevo);

        BEdita.setText("Detalles Tarifa");
        BEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditaActionPerformed(evt);
            }
        });
        jPanel1.add(BEdita);

        BElimina.setText("Eliminar Tarifa");
        BElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminaActionPerformed(evt);
            }
        });
        jPanel1.add(BElimina);

        BTermina.setText("Terminar");
        BTermina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTerminaActionPerformed(evt);
            }
        });
        jPanel1.add(BTermina);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminaActionPerformed
        int index[] = ListTarifas.getSelectedIndices();

        for(int i = index.length - 1 ; i >=0 ; i--){
            boolean ocupado = false;

            for(int j = 0 ; j < Reloj.size() ; j++){
                if(Reloj.get(j).getEstado() != Crono.ESTADO_STANDBY &&
                        Reloj.get(j).getTarifario().getID() == Tarifas.get(index[i]).getID()){
                    ocupado = true;
                    break;
                }
            }

            if(!ocupado){
                try{
                    linker .ejecuta("DELETE FROM Tarifas "
                            + "WHERE ID = " + Tarifas.get(index[i]).getID());
                    Tarifas.remove(index[i]);
                    modelo .remove(index[i]);

                }catch(Exception exc){
                    ouch.whoops("BAceptarActionPerformed(ActionEvent evt)", exc);
                }
            } else{
                JOptionPane.showMessageDialog(null, "la tarifa " + Tarifas.get(index[i]).getTarifa() + " esta siendo usada por alguna\n"
                                                  + "maquina en renta, asegurese de que ningun equipo\n"
                                                  + "la este usando antes de intentarlo de nuevo"
                        ,"La tarifa esta en uso"
                        ,JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_BEliminaActionPerformed

    private void BTerminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTerminaActionPerformed
        dispose();
    }//GEN-LAST:event_BTerminaActionPerformed

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        diagAdminTarifasLv2 admTarL2 = new diagAdminTarifasLv2(this,true);
        admTarL2.setLocationRelativeTo(null);
        admTarL2.setVisible(true);
        
        if(admTarL2.getAcepto()){
            try{
                String SQL = "INSERT INTO Tarifas "
                        + "(tarifa, lapso, precio) "
                        + "VALUES "
                        + "("
                        + "'" + admTarL2.getTarifa() + "', "
                        + ""  + admTarL2.getLapso () + ", "
                        + ""  + admTarL2.getPrecio()
                        + ")";
                linker.ejecuta(SQL);
            }catch(Exception exc){
                ouch.whoops("BNuevoActionPerformed(ActionEvent evt)\nINSERT INTO Tarifas", exc);
            }
            
            try{
                ResultSet RSUltima = linker.consulta("SELECT ID FROM Tarifas ORDER BY ID DESC");
                if(RSUltima.next()){
                    int dummyID = RSUltima.getInt("ID");
                    RSUltima.close();
                    modeloTablaAdminTarifasLv2 modL2 = admTarL2.getModelo();

                    for(int i = 0 ; i < modL2.getRowCount() ; i++){
                        String SQL = "INSERT INTO Tarifa_Banderas "
                                + "(id_tarifa, lapso, precio) "
                                + "VALUES "
                                + "("
                                + "" + dummyID + ", "
                                + "" + modL2.getLapso (i) + ", "
                                + "" + modL2.getPrecio(i) + " "
                                + ")";
                        linker.ejecuta(SQL);
                    }
                }
            }catch(Exception exc){
                ouch.whoops("BNuevoActionPerformed(ActionEvent evt)\nINSERT INTO Tarifa_Banderas", exc);
            }
            
            misTarifas();
        }
    }//GEN-LAST:event_BNuevoActionPerformed

    private void BEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditaActionPerformed
        if(ListTarifas.getSelectedIndex() != -1){
            setGetTarifas tarifa = Tarifas.get(ListTarifas.getSelectedIndex());
            diagAdminTarifasLv2 admTarL2 = new diagAdminTarifasLv2(this, true, tarifa, responsable.getBool_tar_mod());
            admTarL2.setLocationRelativeTo(null);
            admTarL2.setVisible(true);
            
            if(admTarL2.getAcepto()){
                try{
                    String SQL = "UPDATE Tarifas "
                            + "SET "
                            + "tarifa = '"  + admTarL2.getTarifa() + "', "
                            + "lapso = "    + admTarL2.getLapso () + ", "
                            + "precio = "   + admTarL2.getPrecio() + " "
                            + "WHERE ID = " + tarifa.getID();
                    linker.ejecuta(SQL);
                    
                }catch(Exception exc){
                    ouch.whoops("BEditaActionPerformed(ActionEvent evt)\nUPDATE Tarifas", exc);
                }
                
                modeloTablaAdminTarifasLv2 modL2 = admTarL2.getModelo();
                int limite = modL2.getRowCount();
                
                if(modL2.getRowCount() < tarifa.getBanderas().size()){
                    try{
                        for(int i = modL2.getRowCount() ; i < tarifa.getBanderas().size() ; i++){
                            String SQL = "DELETE FROM Tarifa_Banderas "
                                    + "WHERE ID = " + tarifa.getBanderas().get(i).getID();
                            linker.ejecuta(SQL);
                        }
                    }catch(Exception exc){
                        ouch.whoops("BEditaActionPerformed(ActionEvent evt)\nDELETE FROM Tarifa_Banderas", exc);
                    }
                } else if(modL2.getRowCount() > tarifa.getBanderas().size()){
                    limite = tarifa.getBanderas().size();
                    try{
                        for(int i = tarifa.getBanderas().size() ; i < modL2.getRowCount() ; i++){
                            String SQL = "INSERT INTO Tarifa_Banderas "
                                    + "(id_tarifa, lapso, precio) "
                                    + "VALUES"
                                    + "("
                                    + "" + tarifa.getID()     + ", "
                                    + "" + modL2.getLapso (i) + ", "
                                    + "" + modL2.getPrecio(i) + ""
                                    + ")";
                            linker.ejecuta(SQL);
                        }
                    } catch(Exception exc){
                        ouch.whoops("BEditaActionPerformed(ActionEvent evt)\nINSERT INTO Tarifa_Banderas", exc);
                    }
                }
                
                try{
                    for(int i = 0 ; i < limite ; i++){
                        String SQL = "UPDATE Tarifa_Banderas "
                                + "SET "
                                + "lapso = "     + modL2.getLapso (i) + ", "
                                + "precio = "    + modL2.getPrecio(i) + " "
                                + "WHERE ID = "  + tarifa.getBanderas().get(i).getID();
                        linker.ejecuta(SQL);
                    }
                }catch(Exception exc){
                    ouch.whoops("BEditaActionPerformed(ActionEvent evt)\nUPDATE Tarifa_Banderas", exc);
                }
                
                misTarifas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "no has seleccionado ninguna tarifa", "error de seleccion", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_BEditaActionPerformed

    private class accionFlechaAbajo extends AbstractAction{
        public accionFlechaAbajo(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 0: BNuevo.transferFocus(); break;
                case 1: BEdita.transferFocus(); break;
                case 2: BElimina.transferFocus(); break;
                case 3: BNuevo.requestFocus(); break;
            }
        }
        int caso = 0;
    }
    
    private class accionFlechaArriba extends AbstractAction{
        public accionFlechaArriba(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 0: BTermina.requestFocus(); break;
                case 1: BNuevo.requestFocus(); break;
                case 2: BEdita.requestFocus(); break;
                case 3: BElimina.requestFocus(); break;
            }
        }
        int caso = 0;
    }
    
    private class accionFlechaIzquierda extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            ListTarifas.requestFocus();
        }
    }
    
    private class accionEnter extends AbstractAction{
        public accionEnter(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 0: BNuevo.doClick(); break;
                case 1: BEdita.doClick(); break;
                case 2: BElimina.doClick(); break;
                case 3: BTermina.doClick(); break;
            }
        }
        int caso = 0;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEdita;
    private javax.swing.JButton BElimina;
    private javax.swing.JButton BNuevo;
    private javax.swing.JButton BTermina;
    private javax.swing.JList ListTarifas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    ArrayList<Crono>            Reloj       ;
    ArrayList<setGetTarifas>    Tarifas     = new ArrayList();
    Conector                    linker      ;
    modeloListaAdminTarifas     modelo      = new modeloListaAdminTarifas();
    setGetPermisos              responsable ;
    upsy                        ouch        = new upsy("diagAdminTarifas");
}