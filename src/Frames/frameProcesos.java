package Frames;

import Tablas.modeloTablaProcesos;
import Util.socketClient;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class frameProcesos extends javax.swing.JFrame {

    public frameProcesos(socketClient cliente) {
        this.cliente = cliente;
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        TProcesos.getTableHeader().setReorderingAllowed(false);
        TProcesos.setModel(modelo);
        TProcesos.setRowSorter(sorter = new TableRowSorter(modelo));
        
        misFiltros();
    }
    
    private void misFiltros(){
        if(CMostrar.isSelected())
            sorter.setRowFilter(null);
        else {
            String excepcion[] = {
                "java.exe", "cmd.exe", "System Idle Process", "System", "smss.exe",
                "csrss.exe", "services.exe", "lsass.exe", "DF5Serv.exe", 
                "svchost.exe", "spoolsv.exe", "javaw.exe", "FrzState2k.exe", 
                "tasklist.exe", "winlogon.exe", "hkcmd.exe", "ctfmon.exe", 
                "jqs.exe", "spkrmon.exe", "alg.exe", "wmiprvse.exe"
            };
            ArrayList<RowFilter<Object, Object>> filtros = new ArrayList();
            for(String exc : excepcion){
                filtros.add(
                        RowFilter.notFilter(
                            RowFilter.regexFilter(
                                exc
                            )
                        )
                );
            }
            sorter.setRowFilter(RowFilter.andFilter(filtros));
        }
    }
    
    public void setModelo(modeloTablaProcesos modelo){
        this.modelo = modelo;
        misComponentes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TProcesos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        BTerminar = new javax.swing.JButton();
        BRefrescar = new javax.swing.JButton();
        BCerrar = new javax.swing.JButton();
        CMostrar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        TProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null},
                {new Boolean(false), null, null, null}
            },
            new String [] {
                "Seleccion", "Nombre de imagen", "PID", "RAM (KB)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TProcesos);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        BTerminar.setText("Terminar Proceso(s)");
        BTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTerminarActionPerformed(evt);
            }
        });
        jPanel1.add(BTerminar);

        BRefrescar.setText("Refrescar Tabla");
        BRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(BRefrescar);

        BCerrar.setText("Cerrar Ventana");
        BCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(BCerrar);

        CMostrar.setText("Mostrar todos los procesos");
        CMostrar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CMostrarItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(CMostrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CMostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTerminarActionPerformed
        String txt = "";
        for(int i = 0 ; i < TProcesos.getRowCount() ; i++){
            int idx = TProcesos.convertRowIndexToModel(i);
            if(modelo.getSeleccion(idx))
                txt += "/pid " + modelo.getPID(idx) + " ";
        }
        if(!txt.equals(""))
            try {
                cliente.habla("killProcesos " + txt);
            } catch(Exception exc){}
    }//GEN-LAST:event_BTerminarActionPerformed

    private void BRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRefrescarActionPerformed
        try {
            cliente.habla("getProcesos");
        } catch(Exception exc){}
    }//GEN-LAST:event_BRefrescarActionPerformed

    private void BCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_BCerrarActionPerformed

    private void CMostrarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CMostrarItemStateChanged
        misFiltros();
    }//GEN-LAST:event_CMostrarItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCerrar;
    private javax.swing.JButton BRefrescar;
    private javax.swing.JButton BTerminar;
    private javax.swing.JCheckBox CMostrar;
    private javax.swing.JTable TProcesos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    modeloTablaProcesos modelo  = new modeloTablaProcesos();
    socketClient        cliente ;
    TableRowSorter      sorter  ;
}