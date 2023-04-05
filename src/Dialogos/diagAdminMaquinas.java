package Dialogos;

import setters_getters.setGetMaquinas;
import setters_getters.setGetPermisos;
import Tablas.cellEditorCombo;
import Tablas.cellEditorDefault;
import Tablas.modeloTablaAdminMaquinas;
import Util.Crono;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class diagAdminMaquinas extends javax.swing.JDialog {

    public diagAdminMaquinas(java.awt.Frame parent, boolean modal, ArrayList<Crono> Relojes, ArrayList<setGetMaquinas> maquinas, setGetPermisos responsable) {
        super(parent, modal);
        this.responsable    = responsable;
        this.Relojes        = Relojes;
        this.maquinas       = maquinas;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        miPuerto();
        
        for(int i = 0 ; i < maquinas.size() ; i++){
            modelo.agregaMaquina(maquinas.get(i));
            indices.add(i);
        }
        
        modelo.setFreeze(responsable.getBool_maq_mod());
        
        BAceptar.setEnabled(responsable.getBool_maq_mod());
        if(responsable.getBool_maq_mod()){
            BAgregar.setEnabled(responsable.getBool_maq_alt());
            BElimina.setEnabled(responsable.getBool_maq_baj());
        }
        
        if(responsable.getID() == 1){
            TPuerto .setEnabled(true);
            BOk     .setEnabled(true);
        }
        
        BAgregar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "picoFlechaIzquierda");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "picoFlechaIzquierda");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "picoFlechaIzquierda");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "picoFlechaIzquierda");
        
        BAgregar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlechaAbajo");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlechaAbajo");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlechaAbajo");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "picoFlechaAbajo");
        
        BAgregar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlechaArriba");        
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlechaArriba");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlechaArriba");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP  , 0), "picoFlechaArriba");
        
        BAgregar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        BElimina.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        BAceptar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        BCancela.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter");
        
        BAgregar.getActionMap().put("picoFlechaIzquierda", new accionFlechaIzquierda());
        BElimina.getActionMap().put("picoFlechaIzquierda", new accionFlechaIzquierda());
        BAceptar.getActionMap().put("picoFlechaIzquierda", new accionFlechaIzquierda());
        BCancela.getActionMap().put("picoFlechaIzquierda", new accionFlechaIzquierda());
        
        BAgregar.getActionMap().put("picoFlechaAbajo", new accionFlechaAbajo(0));
        BElimina.getActionMap().put("picoFlechaAbajo", new accionFlechaAbajo(1));
        BAceptar.getActionMap().put("picoFlechaAbajo", new accionFlechaAbajo(2));
        BCancela.getActionMap().put("picoFlechaAbajo", new accionFlechaAbajo(3));
        
        BAgregar.getActionMap().put("picoFlechaArriba", new accionFlechaArriba(0));
        BElimina.getActionMap().put("picoFlechaArriba", new accionFlechaArriba(1));
        BAceptar.getActionMap().put("picoFlechaArriba", new accionFlechaArriba(2));
        BCancela.getActionMap().put("picoFlechaArriba", new accionFlechaArriba(3));
        
        BAgregar.getActionMap().put("picoEnter", new accionEnter(0));
        BElimina.getActionMap().put("picoEnter", new accionEnter(1));
        BAceptar.getActionMap().put("picoEnter", new accionEnter(2));
        BCancela.getActionMap().put("picoEnter", new accionEnter(3));
        
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN , 0), "picoFlechaAbajo" );
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP   , 0), "picoFlechaArriba");
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter"       );

        TMaquinas.getActionMap().put("picoFlechaAbajo" , new accionFlechaTabla(accionFlechaTabla.FLECHA_ABAJO ));
        TMaquinas.getActionMap().put("picoFlechaArriba", new accionFlechaTabla(accionFlechaTabla.FLECHA_ARRIBA));
        TMaquinas.getActionMap().put("picoEnter"       , new accionEnterTabla ());
        
        TMaquinas.getTableHeader().setReorderingAllowed(false);
        TMaquinas.getTableHeader().setResizingAllowed(false);
        
        TMaquinas.getColumnModel().getColumn(0).setPreferredWidth(100);
        TMaquinas.getColumnModel().getColumn(1).setPreferredWidth(250);
        TMaquinas.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        String opciones[] = {"Maquina","Cronometro"};
        editorCombo.opciones(opciones);
        
        TMaquinas.getColumnModel().getColumn(0).setCellEditor(editorCombo);
        TMaquinas.getColumnModel().getColumn(1).setCellEditor(editorDefault);
        TMaquinas.getColumnModel().getColumn(2).setCellEditor(editorDefault);
    }
    
    private void miPuerto(){
        File puerto = new File("puerto.txt");
        try {
            if(puerto.exists()){
                FileReader      fr = new FileReader(puerto);
                BufferedReader  br = new BufferedReader(fr);
                
                TPuerto.setText(br.readLine());
                
                fr.close();
                br.close();
            }
        } catch(Exception exc){}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TMaquinas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BAgregar = new javax.swing.JButton();
        BElimina = new javax.swing.JButton();
        BAceptar = new javax.swing.JButton();
        BCancela = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TPuerto = new javax.swing.JFormattedTextField();
        BOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador de maquinas y cronometros");
        setResizable(false);

        TMaquinas.setModel(modelo = new modeloTablaAdminMaquinas(Relojes));
        TMaquinas.setNextFocusableComponent(BAceptar);
        TMaquinas.setSelectionBackground(new java.awt.Color(153, 204, 255));
        TMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TMaquinasMouseClicked(evt);
            }
        });
        TMaquinas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TMaquinasKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TMaquinas);

        jPanel1.setLayout(new java.awt.GridLayout(4, 0, 0, 20));

        BAgregar.setText("Agregar");
        BAgregar.setEnabled(false);
        BAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BAgregar);

        BElimina.setText("Eliminar");
        BElimina.setEnabled(false);
        BElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminaActionPerformed(evt);
            }
        });
        jPanel1.add(BElimina);

        BAceptar.setText("Salvar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(BAceptar);

        BCancela.setText("Cancelar");
        BCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelaActionPerformed(evt);
            }
        });
        jPanel1.add(BCancela);

        jLabel1.setText("Puerto del servidor:");

        TPuerto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        TPuerto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TPuerto.setEnabled(false);
        TPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TPuertoKeyTyped(evt);
            }
        });

        BOk.setText("Ok");
        BOk.setEnabled(false);
        BOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BOk)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BOk)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed
        if(TMaquinas.isEditing())
            TMaquinas.getCellEditor().stopCellEditing();
        modelo.agregaFilaVacia();
    }//GEN-LAST:event_BAgregarActionPerformed

    private void BEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminaActionPerformed
        int fila = TMaquinas.getSelectedRow();
        
        if(TMaquinas.isEditing())
            TMaquinas.getCellEditor().stopCellEditing();
        if(fila == -1 && TMaquinas.getRowCount() > 0){
            TMaquinas.changeSelection(0, 0, false, false);
            fila = 0;
        }
        
        puedeEliminar();
        
        if(BElimina.isEnabled()){
            if(fila < indices.size() && fila >= 0){
                borrados.add(indices.get(fila));
                indices.remove(fila);
            }

            modelo.quitaFilas(TMaquinas.getSelectedRows());
        }
    }//GEN-LAST:event_BEliminaActionPerformed

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        if(TMaquinas.isEditing())
            TMaquinas.getCellEditor().stopCellEditing();
        
        boolean correcto = true;
        for(int i = 0 ; i < modelo.getRowCount() ; i++){
            if(modelo.getValueAt(i, 1).equals("")){
                correcto = false;
                break;
            }
        }
        if(correcto){
            acepto = true;
            cierra();
        } else {
            JOptionPane.showMessageDialog(null, "No pueden haber maquinas con nombre en blanco", "datos incorrectos", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelaActionPerformed
        if(TMaquinas.isEditing())
            TMaquinas.getCellEditor().stopCellEditing();
        acepto = false;
        cierra();
    }//GEN-LAST:event_BCancelaActionPerformed

    private void TMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TMaquinasMouseClicked
        if(SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2)
            editorDefault.entrandoPorClick();
        
        if(SwingUtilities.isRightMouseButton(evt))
            TMaquinas.changeSelection(TMaquinas.rowAtPoint(evt.getPoint()), TMaquinas.columnAtPoint(evt.getPoint()), false, false);
        
        puedeEliminar();
    }//GEN-LAST:event_TMaquinasMouseClicked

    private void TMaquinasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TMaquinasKeyTyped
        if(evt.getKeyChar() == KeyEvent.VK_TAB)
            TMaquinas.transferFocus();
        
        if(evt.getKeyChar() != KeyEvent.VK_ENTER){
            if(TMaquinas.editCellAt(TMaquinas.getSelectedRow(), TMaquinas.getSelectedColumn())){
                editorDefault.entrandoPorTecla(evt.getKeyChar());
                Component editor = TMaquinas.getEditorComponent();
                editor.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_TMaquinasKeyTyped

    private void BOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOkActionPerformed
        File puerto = new File("puerto.txt");
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(puerto));
            pw.write(TPuerto.getText());
            pw.close();
            
            puerto.createNewFile();
            
            JOptionPane.showMessageDialog(null, ""
                    + "El nuevo puerto tomara efecto al\n"
                    + "proximo reinicio de la aplicacion");
        } catch(Exception exc){}
    }//GEN-LAST:event_BOkActionPerformed

    private void TPuertoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TPuertoKeyTyped
        int tecla = evt.getKeyChar();
        if(tecla < '0' || tecla > '9')
            evt.consume();
    }//GEN-LAST:event_TPuertoKeyTyped

    public boolean getAcepto(){
        return acepto;
    }
    
    public void cierra(){
        dispose();
    }
    
    public ArrayList<Integer> getIndices(){
        return indices;
    }
    
    public ArrayList<Integer> getBorrados(){
        return borrados;
    }
    
    public String getIP(int fila){
        return modelo.getValueAt(fila, 2).toString();
    }
    
    public modeloTablaAdminMaquinas getModelo(){
        return modelo;
    }
    
    public String getNombre(int fila){
        return modelo.getValueAt(fila, 1).toString();
    }
    
    public String getTipo(int fila){
        return modelo.getValueAt(fila, 0).toString();
    }
    
    public void puedeEliminar(){
        try{
            if(Relojes.get(indices.get(TMaquinas.getSelectedRow())).getEstado() != Crono.ESTADO_STANDBY)
                BElimina.setEnabled(false);
            else
                BElimina.setEnabled(true);
        } catch(Exception exc){}
    }
    
    private class accionFlechaAbajo extends AbstractAction{
        public accionFlechaAbajo(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 0: BAgregar.transferFocus(); break;
                case 1: BElimina.transferFocus(); break;
                case 2: BAceptar.transferFocus(); break;
                case 3: BAgregar.requestFocus(); break;
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
                case 0: BCancela.requestFocus(); break;
                case 1: BAgregar.requestFocus(); break;
                case 2: BElimina.requestFocus(); break;
                case 3: BAceptar.requestFocus(); break;
            }
        }
        int caso = 0;
    }
    
    private class accionFlechaIzquierda extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            TMaquinas.requestFocus();
        }
    }
    
    private class accionEnter extends AbstractAction{
        public accionEnter(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case 0: BAgregar.doClick(); break;
                case 1: BElimina.doClick(); break;
                case 2: BAceptar.doClick(); break;
                case 3: BCancela.doClick(); break;
            }
        }
        int caso = 0;
    }
    
    private class accionEnterTabla extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            int nCol = TMaquinas.getSelectedColumn();
            int nFil = TMaquinas.getSelectedRow();
            int fila = modelo.getRowCount()-1;
            int colu = modelo.getColumnCount()-1;

            if(nCol >= colu && nFil == fila){
                TMaquinas.transferFocus();
                TMaquinas.clearSelection();
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

            TMaquinas.changeSelection(nFil, nCol, false, false);
        }
    }
    
    private class accionFlechaTabla extends AbstractAction{
        public accionFlechaTabla(int caso){
            this.caso = caso;
        }
        
        @Override
        public void actionPerformed(ActionEvent evt){
            try{
                int filaActual = TMaquinas.getSelectedRow() + caso;
                if(filaActual < 0)
                    filaActual = 0;
                if(filaActual >= TMaquinas.getRowCount())
                    filaActual = TMaquinas.getRowCount() -1;
                TMaquinas.changeSelection(filaActual, TMaquinas.getSelectedColumn(), false, false);
                puedeEliminar();
            }catch(Exception exc){}
        }
        
        int caso;
        public static final int FLECHA_ARRIBA  = -1;
        public static final int FLECHA_ABAJO   =  1;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BAgregar;
    private javax.swing.JButton BCancela;
    private javax.swing.JButton BElimina;
    private javax.swing.JButton BOk;
    private javax.swing.JTable TMaquinas;
    private javax.swing.JFormattedTextField TPuerto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    boolean                     acepto          = false;
    ArrayList<Crono>            Relojes         = new ArrayList();
    ArrayList<Integer>          indices         = new ArrayList();
    ArrayList<Integer>          borrados        = new ArrayList();
    ArrayList<setGetMaquinas>   maquinas        = new ArrayList();
    cellEditorDefault           editorDefault   = new cellEditorDefault(new accionEnterTabla());
    cellEditorCombo             editorCombo     = new cellEditorCombo();
    modeloTablaAdminMaquinas    modelo          ;
    setGetPermisos              responsable     ;
}