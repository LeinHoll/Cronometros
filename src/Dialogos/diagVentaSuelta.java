package Dialogos;

import Paneles.panelConsumos;
import Tablas.modeloTablaConsumos;
import Util.Conector;
import Util.soloNumeros;
import Util.upsy;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class diagVentaSuelta extends javax.swing.JDialog {

    public diagVentaSuelta(java.awt.Frame parent, boolean modal, Conector linker) {
        super(parent, modal);
        this.linker = linker;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        modelo = new modeloTablaConsumos(LTotal);
        PConsumos = new panelConsumos(this, modelo, new accionPicoEscape(), linker);
        panelCard.add("cons", PConsumos);
    }
    
    private void cierraSalvando(){
        if(PConsumos.getEditado()){
            switch(JOptionPane.showConfirmDialog(
                    null, 
                    "Confirme salvar cambios", 
                    "confirme", 
                    JOptionPane.YES_NO_CANCEL_OPTION)){
                case 0: salvaCambios(); dispose(); break;
                case 1: dispose(); break;
            }
        } else {
            dispose();
        }
    }
    
    private void salvaCambios(){
        modelo.validaTabla();
        String SQL = "INSERT INTO Venta_Suelta "
                + "(id_productos_servicios, concepto, precio, cantidad, total) "
                + "VALUES (";
        for(int i = 0 ; i < modelo.getRowCount() ; i++){
            if(i != 0) 
                SQL += " ,(";
            SQL +=      ""  + modelo.getCodigo  (i) + ", "
                    +   "'" + modelo.getConcepto(i) + "', "
                    +   ""  + modelo.getPrecio  (i) + ", "
                    +   ""  + modelo.getCantidad(i) + ", "
                    +   ""  + modelo.getTotal   (i) + ")";
        }
        if(!SQL.endsWith("VALUES (")){
            try{
                linker.ejecuta(SQL);
            } catch(Exception exc){
                ouch.whoops("salvaCambios()", exc);
            }
        }
        for(int j = 0 ; j < modelo.getRowCount() ; j++){
            if(modelo.getCodigo(j) != 0){
                try{
                    ResultSet RS = linker.consulta(""
                            + "SELECT tipo, stock "
                            + "FROM Productos_Servicios "
                            + "WHERE ID = " + modelo.getCodigo(j));
                    if(RS.next() && RS.getString("tipo").equals("Producto")){
                        int stock = RS.getInt("stock") - modelo.getCantidad(j);
                        RS.close();
                        linker.ejecuta(""
                                + "UPDATE Productos_Servicios "
                                + "SET stock = "    + stock + " "
                                + "WHERE ID = "     + modelo.getCodigo(j));
                    }
                } catch(Exception exc){}
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        LTotal = new javax.swing.JLabel();
        TFPago = new javax.swing.JFormattedTextField();
        LCambio = new javax.swing.JLabel();
        BAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venta suelta");

        panelCard.setLayout(new java.awt.CardLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 25, 0));

        jPanel1.setLayout(new java.awt.GridLayout(3, 0, 0, 15));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20));
        jLabel1.setText("Total a pagar");
        jPanel1.add(jLabel1);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 20));
        jLabel3.setText("Pago");
        jPanel1.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 20));
        jLabel4.setText("Cambio");
        jPanel1.add(jLabel4);

        jPanel2.add(jPanel1);

        jPanel3.setLayout(new java.awt.GridLayout(3, 0, 0, 20));

        LTotal.setFont(new java.awt.Font("Arial", 1, 20));
        LTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LTotal.setText("$ 0.00");
        jPanel3.add(LTotal);

        TFPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        TFPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFPago.setText("0.00");
        TFPago.setFont(new java.awt.Font("Arial", 1, 20));
        TFPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFPagoFocusGained(evt);
            }
        });
        TFPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFPagoKeyTyped(evt);
            }
        });
        jPanel3.add(TFPago);

        LCambio.setFont(new java.awt.Font("Arial", 1, 20));
        LCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LCambio.setText("$ 0.00");
        jPanel3.add(LCambio);

        jPanel2.add(jPanel3);

        BAceptar.setFont(new java.awt.Font("Arial", 1, 20));
        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(BAceptar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCard, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFPagoKeyReleased
        valida.soloDecimalReleased(TFPago);
        try{
            double cambio = modelo.getTotalTabla() - Double.parseDouble(TFPago.getText());
            LCambio.setText("$" + new DecimalFormat("#,##0.00").format(Math.abs(cambio)));
            if(cambio < 0)
                LCambio.setForeground(Color.red);
            else if (cambio > 0)
                LCambio.setForeground(Color.blue);
            else
                LCambio.setForeground(Color.black);
        } catch(Exception exc){}
    }//GEN-LAST:event_TFPagoKeyReleased

    private void TFPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFPagoKeyTyped
        valida.soloDecimalTyped(evt, TFPago);
    }//GEN-LAST:event_TFPagoKeyTyped

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        salvaCambios();
        dispose();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void TFPagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFPagoFocusGained
        TFPago.selectAll();
    }//GEN-LAST:event_TFPagoFocusGained

    private class accionPicoEscape extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            cierraSalvando();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JLabel LCambio;
    private javax.swing.JLabel LTotal;
    private javax.swing.JFormattedTextField TFPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelCard;
    // End of variables declaration//GEN-END:variables
    Conector            linker      ;
    modeloTablaConsumos modelo      ;
    panelConsumos       PConsumos   ;
    soloNumeros         valida      = new soloNumeros();
    upsy                ouch        = new upsy("diagVentaSuelta");
}