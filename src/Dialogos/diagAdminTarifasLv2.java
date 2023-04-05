package Dialogos;

import Tablas.cellEditorDecimal;
import Tablas.cellEditorInteger;
import Tablas.modeloTablaAdminTarifasLv2;
import setters_getters.setGetTarifas;
import Util.soloNumeros;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingUtilities;

public class diagAdminTarifasLv2 extends javax.swing.JDialog {

    public diagAdminTarifasLv2(java.awt.Dialog parent, boolean modal){
        super(parent, modal);
        initComponents();
        misComponentes();
        setTitle("Nueva tarifa");
    }
    
    public diagAdminTarifasLv2(java.awt.Dialog parent, boolean modal, setGetTarifas tarifa, boolean edicion) {
        super(parent, modal);
        this.edicion    = edicion;
        this.tarifa     = tarifa;
        initComponents();
        misComponentes();
        setTitle("Datos de " + tarifa.getTarifa());
    }
    
    private void misComponentes(){
        JPanel panels[] = {P1,P2,P3};
        for(int i = 0 ; i < panels.length ; i++){
            Component comps[] = panels[i].getComponents();
            for(int j = 0 ; j < comps.length ; j++){
                if(!(comps[j] instanceof JLabel)){
                    comps[j].setEnabled(edicion);
                }
            }
        }
        modelo.setFreeze(edicion);
        
        BCancela.setEnabled(true);        
        
        TBanderas.setModel(modelo);
        TBanderas.getTableHeader().setReorderingAllowed(false);
        TBanderas.getTableHeader().setResizingAllowed(false);
        
        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(SwingUtilities.RIGHT);
        
        TBanderas.getColumnModel().getColumn(0).setCellRenderer(derecha);
        TBanderas.getColumnModel().getColumn(1).setCellRenderer(derecha);
        
        TBanderas.getColumnModel().getColumn(0).setCellEditor(editorInteger);
        TBanderas.getColumnModel().getColumn(1).setCellEditor(editorDecimal);
        
        if(tarifa != null){
            TFTarifa .setText (tarifa.getTarifa());
            FTFLapso .setText (tarifa.getLapso () + "");
            FTFPrecio.setText (tarifa.getPrecio() + "");
            modelo.setBanderas(tarifa.getBanderas());
        }
        
        TBanderas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        TBanderas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB  , 0), "picoTab"  );
        TBanderas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F2   , 0), "picoF2"   );
        TBanderas.getActionMap().put("picoEnter", new picoEnter());
        TBanderas.getActionMap().put("picoTab"  , new picoTab  ());
        TBanderas.getActionMap().put("picoF2"   , new picoF2());
        
        BNuevo  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0), "picoEnter");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0), "picoEnter");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0), "picoEnter");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER , 0), "picoEnter");
        
        BNuevo  .getActionMap().put("picoEnter", new accionPicoEnter(accionPicoEnter.BOTON_NUEVO  ));
        BElimina.getActionMap().put("picoEnter", new accionPicoEnter(accionPicoEnter.BOTON_ELIMINA));
        BAceptar.getActionMap().put("picoEnter", new accionPicoEnter(accionPicoEnter.BOTON_ACEPTAR));
        BCancela.getActionMap().put("picoEnter", new accionPicoEnter(accionPicoEnter.BOTON_CANCELA));

        BNuevo  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "picoEscape");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "picoEscape");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "picoEscape");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "picoEscape");
        
        BNuevo  .getActionMap().put("picoEscape", new accionPicoEscape());
        BElimina.getActionMap().put("picoEscape", new accionPicoEscape());
        BAceptar.getActionMap().put("picoEscape", new accionPicoEscape());
        BCancela.getActionMap().put("picoEscape", new accionPicoEscape());
        
        BNuevo  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlecha");
        BNuevo  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlecha");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlecha");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlecha");
        
        BNuevo  .getActionMap().put("picoFlecha", new accionFlechaVertical());
        BElimina.getActionMap().put("picoFlecha", new accionFlechaVertical());
        
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "picoFlecha");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT , 0), "picoFlecha");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "picoFlecha");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT , 0), "picoFlecha");
        
        BAceptar.getActionMap().put("picoFlecha", new accionFlechaHorizontal());
        BCancela.getActionMap().put("picoFlecha", new accionFlechaHorizontal());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popBanderas = new javax.swing.JPopupMenu();
        MIBandera = new javax.swing.JMenuItem();
        P1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFTarifa = new javax.swing.JTextField();
        FTFLapso = new javax.swing.JFormattedTextField();
        FTFPrecio = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBanderas = new javax.swing.JTable();
        P2 = new javax.swing.JPanel();
        BNuevo = new javax.swing.JButton();
        BElimina = new javax.swing.JButton();
        P3 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();

        MIBandera.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        MIBandera.setText("Calculo");
        MIBandera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIBanderaActionPerformed(evt);
            }
        });
        popBanderas.add(MIBandera);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de tarifa individual");
        setResizable(false);

        P1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos basicos de la tarifa"));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Lapso Base:");

        jLabel3.setText("Precio Base:");

        TFTarifa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TFTarifaFocusGained(evt);
            }
        });
        TFTarifa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFTarifaKeyTyped(evt);
            }
        });

        FTFLapso.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        FTFLapso.setText("0");
        FTFLapso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FTFLapsoFocusGained(evt);
            }
        });
        FTFLapso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FTFLapsoKeyTyped(evt);
            }
        });

        FTFPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        FTFPrecio.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        FTFPrecio.setText("0.00");
        FTFPrecio.setNextFocusableComponent(BNuevo);
        FTFPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FTFPrecioFocusGained(evt);
            }
        });
        FTFPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FTFPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FTFPrecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout P1Layout = new javax.swing.GroupLayout(P1);
        P1.setLayout(P1Layout);
        P1Layout.setHorizontalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FTFLapso, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(TFTarifa, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(FTFPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addContainerGap())
        );
        P1Layout.setVerticalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FTFLapso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FTFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TBanderas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lapso", "Precio"
            }
        ));
        TBanderas.setNextFocusableComponent(BAceptar);
        TBanderas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBanderasMouseClicked(evt);
            }
        });
        TBanderas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TBanderasKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TBanderas);

        P2.setLayout(new java.awt.GridLayout(2, 0, 0, 25));

        BNuevo.setText("<HTML>Nueva<P>Bandera</HTML>");
        BNuevo.setNextFocusableComponent(TBanderas);
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });
        P2.add(BNuevo);

        BElimina.setText("<HTML>Elimina<P>Bandera</HTML>");
        BElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminaActionPerformed(evt);
            }
        });
        P2.add(BElimina);

        P3.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        P3.add(BAceptar);

        BCancela.setText("Cancelar");
        BCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelaActionPerformed(evt);
            }
        });
        P3.add(BCancela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addComponent(P3, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        modelo.agregaFila();
    }//GEN-LAST:event_BNuevoActionPerformed

    private void BEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminaActionPerformed
        if(TBanderas.getRowCount() > 0 && TBanderas.getSelectedRow() >= 0)
            modelo.eliminaFila(TBanderas.getSelectedRows());
    }//GEN-LAST:event_BEliminaActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        aceptar = false;
        cierra();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        if(TBanderas.isEditing())
            TBanderas.getCellEditor().stopCellEditing();
        
        boolean valido = true;
        if(TFTarifa.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El nombre de la tarifa no puede estar en blanco");
            valido = false;
        }else if(Integer.parseInt(FTFLapso.getText()) == 0){
            JOptionPane.showMessageDialog(null, "El lapso base de la tarifa no puede ser 0");
            valido = false;
        }else if(Double.parseDouble(FTFPrecio.getText()) == 0){
            JOptionPane.showMessageDialog(null, "El precio base de la tarifa no puede ser 0");
            valido = false;
        }
        
        if(valido){
            aceptar = true;
            validaTablaBanderas();
            cierra();
        }
    }//GEN-LAST:event_BAceptarActionPerformed

    private void FTFLapsoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFLapsoKeyTyped
        if(FTFLapso.getText().equals(""))
                FTFLapso.setText("0");
        int tecla = valida.soloNum(evt);
        if(tecla == -1)
            evt.consume();
        else if(tecla == 10)
            FTFLapso.transferFocus();
        else{
            validaLapso(evt);
            evt.consume();
        }
    }//GEN-LAST:event_FTFLapsoKeyTyped

    private void FTFPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFPrecioKeyTyped
        valida.soloDecimalTyped(evt, FTFPrecio);
    }//GEN-LAST:event_FTFPrecioKeyTyped

    private void FTFPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FTFPrecioKeyReleased
        valida.soloDecimalReleased(FTFPrecio);
    }//GEN-LAST:event_FTFPrecioKeyReleased

    private void FTFPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTFPrecioFocusGained
        FTFPrecio.selectAll();
    }//GEN-LAST:event_FTFPrecioFocusGained

    private void FTFLapsoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FTFLapsoFocusGained
        FTFLapso.selectAll();
    }//GEN-LAST:event_FTFLapsoFocusGained

    private void TFTarifaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFTarifaFocusGained
        TFTarifa.selectAll();
    }//GEN-LAST:event_TFTarifaFocusGained

    private void TBanderasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBanderasKeyTyped
        int tecla = valida.soloNum(evt);
        
        if(evt.getKeyChar() != KeyEvent.VK_ESCAPE){
            if(tecla != -1 && tecla != 10){
                if(TBanderas.isCellEditable(TBanderas.getSelectedRow(), TBanderas.getSelectedColumn())){
                    editorDecimal.entrandoPorTecla();
                    editorInteger.entrandoPorTecla(tecla);
                    Component editor = TBanderas.getEditorComponent();
                    editor.requestFocusInWindow();
                }
            } else {
                evt.consume();
            }
        }
    }//GEN-LAST:event_TBanderasKeyTyped

    private void TBanderasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBanderasMouseClicked
        Point p = evt.getPoint();
        
        if(SwingUtilities.isRightMouseButton(evt)){
            TBanderas.changeSelection(TBanderas.rowAtPoint(p), TBanderas.columnAtPoint(p), false, false);
            
            popBanderas.show(evt.getComponent(), evt.getX(), evt.getY());
        }
        
        editorDecimal.entrandoPorClick();
        editorInteger.entrandoPorClick();
    }//GEN-LAST:event_TBanderasMouseClicked

    private void MIBanderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIBanderaActionPerformed
        invocaDiagAdminTarifasLv3();
    }//GEN-LAST:event_MIBanderaActionPerformed

    private void TFTarifaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFTarifaKeyTyped
        if(evt.getKeyChar() == 10)
            TFTarifa.transferFocus();
    }//GEN-LAST:event_TFTarifaKeyTyped

    public boolean getAcepto(){
        return aceptar;
    }
    
    public String getTarifa(){
        return TFTarifa.getText();
    }
    
    public int getLapso(){
        return Integer.parseInt(FTFLapso.getText());
    }
    
    public double getPrecio(){
        return Double.parseDouble(FTFPrecio.getText());
    }
    
    public modeloTablaAdminTarifasLv2 getModelo(){
        return modelo;
    }
    
    private void invocaDiagAdminTarifasLv3(){
        diagAdminTarifasLv3 admTarL3 = new diagAdminTarifasLv3(this,true);
        admTarL3.setLocationRelativeTo(null);
        admTarL3.setVisible(true);
        
        if(admTarL3.getAcepto()){
            modelo.setValueAt(admTarL3.getTiempoBandera(), TBanderas.getSelectedRow(), 0);
        }
    }
    
    private void cierra(){
        dispose();
    }
    
    private void validaLapso(KeyEvent evt){
        if((int)evt.getKeyChar() != KeyEvent.VK_BACK_SPACE){
            String valor = FTFLapso.getText();
            if(valor.equals(""))
                FTFLapso.setText(evt.getKeyChar() + "");
            else if (Integer.parseInt(valor) == 0)
                FTFLapso.setText(evt.getKeyChar() + "");
            else
                FTFLapso.setText(valor + evt.getKeyChar());
        }
    }
    
    private void validaTablaBanderas(){
        ArrayList<Integer> lapsos = new ArrayList();
        ArrayList<Double> precios = new ArrayList();
        
        for(int i = 0 ; i < modelo.getRowCount() ; i++){
            boolean ultimoLapso  = true;
            boolean ultimoPrecio = true;
            
            for(int j = 0 ; j < lapsos.size() ; j++){
                if(modelo.getLapso(i) <= lapsos.get(j)){
                    lapsos.add(j, modelo.getLapso(i));
                    ultimoLapso = false;
                    break;
                }
            }
            
            for(int k = 0 ; k < precios.size() ; k++){
                if(modelo.getPrecio(i) <= precios.get(k)){
                    precios.add(k, modelo.getPrecio(i));
                    ultimoPrecio = false;
                    break;
                }
            }
            
            if(ultimoLapso){
                lapsos.add(modelo.getLapso(i));
            }
            
            if(ultimoPrecio){
                precios.add(modelo.getPrecio(i));
            }
        }
        
        modelo.setLapsosYPrecios(lapsos, precios);
    }
    
    private class accionPicoEnter extends AbstractAction{
        public accionPicoEnter(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case BOTON_NUEVO  : BNuevo.doClick(); break;
                case BOTON_ELIMINA: BElimina.doClick(); break;
                case BOTON_ACEPTAR: BAceptar.doClick(); break;
                case BOTON_CANCELA: BCancela.doClick(); break;
            }
        }
        int caso;
        final static int BOTON_NUEVO   = 0;
        final static int BOTON_ELIMINA = 1;
        final static int BOTON_ACEPTAR = 2;
        final static int BOTON_CANCELA = 3;
    }
    
    private class accionPicoEscape extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            cierra();
        }
    }
    
    private class accionFlechaHorizontal extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BAceptar.isFocusOwner())
                BCancela.requestFocus();
            else if(BCancela.isFocusOwner())
                BAceptar.requestFocus();
        }
    }
    
    private class accionFlechaVertical extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BNuevo.isFocusOwner())
                BElimina.requestFocus();
            else if(BElimina.isFocusOwner())
                BNuevo.requestFocus();
        }
    }
    
    private class picoEnter extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            int nCol = TBanderas.getSelectedColumn();
            int nFil = TBanderas.getSelectedRow();
            int fila = modelo.getRowCount()-1;
            int colu = modelo.getColumnCount()-1;

            if(nCol >= colu && nFil == fila){
                TBanderas.transferFocus();
                TBanderas.clearSelection();
            } else if(nCol >= colu){
                nCol = 0;
                if(nFil == fila){
                    nFil = 0;
                } else {
                    nFil += 1;
                }
            } else {
                nCol += 1;
            }

            TBanderas.changeSelection(nFil, nCol, false, false);
        }
    }
    
    private class picoF2 extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(TBanderas.getSelectedRow() > -1)
                invocaDiagAdminTarifasLv3();
        }
    }
    
    private class picoTab extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            TBanderas.transferFocus();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BCancela;
    private javax.swing.JButton BElimina;
    private javax.swing.JButton BNuevo;
    private javax.swing.JFormattedTextField FTFLapso;
    private javax.swing.JFormattedTextField FTFPrecio;
    private javax.swing.JMenuItem MIBandera;
    private javax.swing.JPanel P1;
    private javax.swing.JPanel P2;
    private javax.swing.JPanel P3;
    private javax.swing.JTable TBanderas;
    private javax.swing.JTextField TFTarifa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popBanderas;
    // End of variables declaration//GEN-END:variables
    boolean                     aceptar         = false;
    boolean                     edicion         = true;
    cellEditorDecimal           editorDecimal   = new cellEditorDecimal(new picoEnter());
    cellEditorInteger           editorInteger   = new cellEditorInteger(new picoEnter());
    modeloTablaAdminTarifasLv2  modelo          = new modeloTablaAdminTarifasLv2();
    setGetTarifas               tarifa          ;
    soloNumeros                 valida          = new soloNumeros();
}