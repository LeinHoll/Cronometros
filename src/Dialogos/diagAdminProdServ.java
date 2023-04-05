package Dialogos;

import setters_getters.setGetPermisos;
import setters_getters.setGetProdServ;
import setters_getters.setGetProdProv;
import Tablas.cellEditorCombo;
import Tablas.cellEditorDecimal;
import Tablas.cellEditorDefault;
import Tablas.cellEditorInteger;
import Tablas.modeloTablaAdminPS;
import Util.Conector;
import Util.soloNumeros;
import Util.upsy;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class diagAdminProdServ extends javax.swing.JDialog {

    public diagAdminProdServ(java.awt.Frame parent, boolean modal, Conector linker, setGetPermisos responsable) {
        super(parent, modal);
        initComponents()    ;
        this.responsable    = responsable;
        this.linker         = linker;
        misComponentes()    ;
    }
    
    private void misComponentes(){
        recuperaArchivos();
        
        nuevos.add(new setGetProdServ());
        
        derecha  .setHorizontalAlignment(SwingUtilities.RIGHT);
        centro   .setHorizontalAlignment(SwingUtilities.CENTER);
        izquierda.setHorizontalAlignment(SwingUtilities.LEFT);
                
        TConsumos.getTableHeader().setReorderingAllowed(false);
        TConsumos.getTableHeader().setResizingAllowed(false);
        
        String opciones[] = {"Producto","Servicio"};
        editorCombo.opciones(opciones);
        
        misTablas();
                
        RadCualquiera.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "accionRadDerecha");
        RadServicios .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "accionRadDerecha");
        RadProductos .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "accionRadDerecha");
        RadNuevos    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "accionRadDerecha");
        
        RadCualquiera.getActionMap().put("accionRadDerecha", new accionRadDerecha());
        RadServicios .getActionMap().put("accionRadDerecha", new accionRadDerecha());
        RadProductos .getActionMap().put("accionRadDerecha", new accionRadDerecha());
        RadNuevos    .getActionMap().put("accionRadDerecha", new accionRadDerecha());
        
        RadCualquiera.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "accionRadIzquierda");
        RadServicios .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "accionRadIzquierda");
        RadProductos .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "accionRadIzquierda");
        RadNuevos    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "accionRadIzquierda");
        
        RadCualquiera.getActionMap().put("accionRadIzquierda", new accionRadIzquierda());
        RadServicios .getActionMap().put("accionRadIzquierda", new accionRadIzquierda());
        RadProductos .getActionMap().put("accionRadIzquierda", new accionRadIzquierda());
        RadNuevos    .getActionMap().put("accionRadIzquierda", new accionRadIzquierda());
        
        TBuscar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "accionBuscarEnter");
        
        TBuscar.getActionMap().put("accionBuscarEnter", new accionBuscarEnter());
        
        TConsumos.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "accionTablaEnter");
        TConsumos.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB  , 0), "accionTablaTab"  );
        TConsumos.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, KeyEvent.CTRL_DOWN_MASK), "accionTablaBorrar");
        
        TConsumos.getActionMap().put("accionTablaEnter" , new accionTablaEnter  ());
        TConsumos.getActionMap().put("accionTablaTab"   , new accionTablaTab    ());
        TConsumos.getActionMap().put("accionTablaBorrar", new accionTablaBorrar ());
        
        BAceptar .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "accionBotonDerecha");
        BAplicar .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "accionBotonDerecha");
        BCancelar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "accionBotonDerecha");
        
        BAceptar .getActionMap().put("accionBotonDerecha", new accionBotonDerecha());
        BAplicar .getActionMap().put("accionBotonDerecha", new accionBotonDerecha());
        BCancelar.getActionMap().put("accionBotonDerecha", new accionBotonDerecha());
        
        BAceptar .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "accionBotonIzquierda");
        BAplicar .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "accionBotonIzquierda");
        BCancelar.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "accionBotonIzquierda");
        
        BAceptar .getActionMap().put("accionBotonIzquierda", new accionBotonIzquierda());
        BAplicar .getActionMap().put("accionBotonIzquierda", new accionBotonIzquierda());
        BCancelar.getActionMap().put("accionBotonIzquierda", new accionBotonIzquierda());
        
        modeloCualquiera.setFreeze  (responsable.getBool_alm_mod());
        modeloServicios .setFreeze  (responsable.getBool_alm_mod());
        modeloProductos .setFreeze  (responsable.getBool_alm_mod());
        modeloNuevos    .setFreeze  (responsable.getBool_alm_alt());
        APSItemEliminar .setEnabled (responsable.getBool_alm_baj());
        
        if(!responsable.getBool_alm_alt() && !responsable.getBool_alm_baj() && !responsable.getBool_alm_mod()){
            BAceptar.setEnabled(false);
        }
    }
    
    private void recuperaArchivos(){
        try{
            ResultSet RSPS = linker.consulta(
                    "SELECT * FROM Productos_Servicios");
            while(RSPS.next()){
                setGetProdServ archivo = new setGetProdServ();
                
                archivo.setID               (RSPS.getInt    ("ID"               ));
                archivo.setTipo             (RSPS.getString ("tipo"             ));
                archivo.setConcepto         (RSPS.getString ("concepto"         ));
                archivo.setPrecio           (RSPS.getDouble ("precio"           ));
                archivo.setStock            (RSPS.getInt    ("stock"            ));
                archivo.setMinStock         (RSPS.getInt    ("min_stock"        ));
                archivo.setMaxStock         (RSPS.getInt    ("max_stock"        ));
                
                archivos.add(archivo);
            }
            RSPS.close();
        }catch(Exception exc){
            ouch.whoops("recuperaArchivos()", exc);
        }
    }
    
    private void misTablas(){       
        if(RadCualquiera.isSelected()){
            modeloCualquiera.setDatos(archivos);
            TConsumos.setModel(modeloCualquiera);
            TConsumos.setRowSorter(sorter = new TableRowSorter(modeloCualquiera));
        } else if(RadServicios.isSelected()){
            modeloServicios.setDatos(archivos);
            TConsumos.setModel(modeloServicios);
            TConsumos.setRowSorter(sorter = new TableRowSorter(modeloServicios));
        } else if(RadProductos.isSelected()){
            modeloProductos.setDatos(archivos);
            TConsumos.setModel(modeloProductos);
            TConsumos.setRowSorter(sorter = new TableRowSorter(modeloProductos));
        } else if(RadNuevos.isSelected()){
            TConsumos.setModel(modeloNuevos);
            TConsumos.setRowSorter(null);
        }
        
        TBuscar.setEnabled(!RadNuevos.isSelected());
        
        for(int i = 0 ; i < TConsumos.getColumnCount() ; i++){
            TableColumn col = TConsumos.getColumnModel().getColumn(i);
            String nombre   = TConsumos.getColumnName(i);
            if(nombre.equals("ID")){
                col.setPreferredWidth(10);
                col.setCellRenderer(derecha);
            } else if(nombre.equals("Tipo")){
                col.setPreferredWidth(30);
                col.setCellRenderer(izquierda);
                col.setCellEditor(editorCombo);
            } else if(nombre.equals("Concepto")){
                col.setPreferredWidth(450);
                col.setCellRenderer(izquierda);
                col.setCellEditor(editorDefault);
            } else if(nombre.equals("Precio")){
                col.setPreferredWidth(30);
                col.setCellRenderer(derecha);
                col.setCellEditor(editorDecimal);
            } else if(nombre.equals("Stock")){
                col.setPreferredWidth(30);
                col.setCellRenderer(derecha);
                col.setCellEditor(editorInteger);
            } else if(nombre.equals("Min")){
                col.setPreferredWidth(30);
                col.setCellRenderer(derecha);
                col.setCellEditor(editorInteger);
            } else if(nombre.equals("Max")){
                col.setPreferredWidth(30);
                col.setCellRenderer(derecha);
                col.setCellEditor(editorInteger);
            }
        }
        
        if(!RadNuevos.isSelected())
            misFiltros();
    }
    
    private void misFiltros(){
        ArrayList<RowFilter<Object,Object>> filtros = new ArrayList();        
        filtros.add(
                RowFilter.regexFilter(
                    "(?i)^" + TBuscar.getText()
                )
        );
        for(int i = 0 ; i < deletes.size() ; i++){
            RowFilter nID = RowFilter.notFilter(
                RowFilter.numberFilter(
                    RowFilter.ComparisonType.EQUAL,
                    deletes.get(i).getID(), 
                    0
                ));
            filtros.add(nID);
        }
        sorter.setRowFilter(RowFilter.andFilter(filtros));
    }
    
    private modeloTablaAdminPS obtenModelo(){
        if(RadCualquiera.isSelected()){
            return modeloCualquiera;
        } else if(RadServicios.isSelected()){
            return modeloServicios;
        } else if(RadProductos.isSelected()){
            return modeloProductos;
        } else if(RadNuevos.isSelected()){
            return modeloNuevos;
        }
        return null;
    }
    
    private void aplicaCambios(){
        String SQL = "";
        
        if(responsable.getBool_alm_mod()){
            for(int x = updates.size() - 1 ; x >= 0 ; x--){
                setGetProdServ update = updates.get(x);
                for(int y = 0 ; y < deletes.size() ; y++){
                    setGetProdServ delete = deletes.get(y);
                    if(update.getID() == delete.getID()){
                        updates.remove(x);
                    }
                }
            }

            for(int i = 0 ; i < updates.size() ; i++){
                setGetProdServ update = updates.get(i);
                try{
                    SQL = "UPDATE Productos_Servicios "
                            + "SET "
                            + "tipo = '"        + update.getTipo()      + "', "
                            + "concepto = '"    + update.getConcepto()  + "', "
                            + "precio = "       + update.getPrecio()    + ", ";

                    if(update.getTipo().equals("Servicio")){
                        SQL += "min_stock = DEFAULT, "
                                + "max_stock = DEFAULT, "
                                + "stock = DEFAULT ";

                    } else if(update.getTipo().equals("Producto")){
                        SQL += "min_stock = "       + update.getMinStock()  + ", "
                                + "max_stock = "    + update.getMaxStock()  + ", "
                                + "stock = "        + update.getStock()     + " ";
                    }

                    SQL += "WHERE ID = " + update.getID();
                    linker.ejecuta(SQL);

                    SQL = "DELETE FROM Prc_Prod_Prov "
                                + "WHERE id_prod = " + update.getID();
                    linker.ejecuta(SQL);

                    if(update.getTipo().equals("Producto") && !update.getProveedores().isEmpty()){
                        SQL = "INSERT INTO Prc_Prod_Prov "
                                + "(id_prod, id_prov, prc_co) "
                                + "VALUES";
                        for(int I = 0 ; I < update.getProveedores().size() ; I++){
                            if(I == 0){
                                SQL += " (";
                            } else {
                                SQL += ", (";
                            }
                            setGetProdProv prov = update.getProveedores().get(I);
                            SQL +=      "" + prov.getIdProdServ()   + ", "
                                    +   "" + prov.getIdProveedor()  + ", "
                                    +   "" + prov.getPrecio()       + ")";
                        }
                        linker.ejecuta(SQL);
                    }

                } catch(Exception exc){
                    ouch.whoops("aplicaCambios()\nUpdates", exc);
                }
            }
        }
        
        if(responsable.getBool_alm_baj()){
            for(int j = 0 ; j < deletes.size() ; j++){
                SQL = "DELETE FROM Productos_Servicios "
                        + "WHERE ID = " + deletes.get(j).getID();

                try{
                    linker.ejecuta(SQL);
                }catch(Exception exc){
                    ouch.whoops("aplicaCambios()\nDeletes", exc);
                }
            }
        }
        
        if(responsable.getBool_alm_alt()){
            for(int k = 0 ; k < nuevos.size() ; k++){
                if(validaFila(k)){
                    try{
                        setGetProdServ nuevo = nuevos.get(k);
                        SQL = "INSERT INTO Productos_Servicios "
                                + "(tipo, concepto, precio, "
                                + "min_stock, max_stock, stock) "
                                + "VALUES (";
                        if(nuevo.getTipo().equals("Servicio")){
                            SQL += "'Servicio', "
                                    + "'"   + nuevo.getConcepto()   + "', "
                                    + ""    + nuevo.getPrecio()     + ", "
                                    + "DEFAULT, DEFAULT, DEFAULT)";
                            linker.ejecuta(SQL);
                        } else if(nuevo.getTipo().equals("Producto")){
                            SQL += "'Producto', "
                                    + "'"   + nuevo.getConcepto()   + "', "
                                    + ""    + nuevo.getPrecio()     + ", "
                                    + ""    + nuevo.getMinStock()   + ", "
                                    + ""    + nuevo.getMaxStock()   + ", "
                                    + ""    + nuevo.getStock()      + ")";
                            if(!nuevo.getProveedores().isEmpty()){
                                ResultSet RS = linker.inserta(SQL);
                                RS.next();
                                SQL = "INSERT INTO Prc_Prod_Prov "
                                        + "(id_prod, id_prov, prc_co) "
                                        + "VALUES";
                                for(int K = 0 ; K < nuevo.getProveedores().size() ; K++){
                                    if(K == 0){
                                        SQL += " (";
                                    } else {
                                        SQL += ", (";
                                    }
                                    setGetProdProv prov = nuevo.getProveedores().get(K);
                                    SQL +=      "" + RS.getInt(1)           + ", "
                                            +   "" + prov.getIdProveedor()  + ", "
                                            +   "" + prov.getPrecio()       + ")";
                                }
                                RS.close();
                                linker.ejecuta(SQL);
                            } else {
                                linker.ejecuta(SQL);
                            }

                        }
                    }catch(Exception exc){
                        ouch.whoops("aplicaCambios()\nInserts", exc);
                    }
                }
            }
        }
        
        archivos.clear();
        updates .clear();
        deletes .clear();
        nuevos  .clear();
        nuevos  .add(new setGetProdServ());
        modeloNuevos.limpiaTabla();
        modeloNuevos.filaVacia();
        recuperaArchivos();
    }
    
    private boolean validaFila(int idx){
        if(modeloNuevos.getConcepto(idx).equals("")
                || modeloNuevos.getPrecio(idx) == 0)
            return false;
        return true;
    }
    
    private void casoEditorInteger(String colNom){
        if(colNom.equals("Stock")){
            casoInteger = COL_STOCK;
        } else if(colNom.equals("Min")){
            casoInteger = COL_MIN_STOCK;
        } else if(colNom.equals("Max")){
            casoInteger = COL_MAX_STOCK;
        }
    }
    
    private void listaEliminados(){
        modeloTablaAdminPS base = obtenModelo();
        int idx[] = TConsumos.getSelectedRows();
        if(RadNuevos.isSelected()){
            for(int i = idx.length - 1 ; i >= 0 ; i--){
                base.removeRow(i);
            }
        } else {
            for(int i = 0 ; i < idx.length ; i++){
                deletes.add(
                    archivos.get(
                        base.getIndice(
                            TConsumos.convertRowIndexToModel(idx[i]))));
            }
            misFiltros();
        }
        BAplicar.setEnabled(true);
    }
    
    private void invocaDiagAdminProdServLv2(){
        setGetProdServ prod;
        int idx;
        boolean mod;
        if(RadNuevos.isSelected()){
            idx     = TConsumos     .getSelectedRow();
            prod    = nuevos        .get(idx);
            mod     = responsable   .getBool_alm_alt();
        } else {
            idx     = TConsumos     .convertRowIndexToModel(TConsumos.getSelectedRow());
            prod    = archivos      .get(idx);
            mod     = responsable   .getBool_alm_mod();
        }

        diagAdminProdServLv2 admPS2 = new diagAdminProdServLv2(this, true, prod, linker, mod);
        admPS2.setLocationRelativeTo(null);
        admPS2.setVisible(true);
        
        if(admPS2.getSalvo()){
            if(RadNuevos.isSelected()){
                nuevos.get(idx).setProveedores(admPS2.getProveedores());
            } else {
                archivos.get(idx).setProveedores(admPS2.getProveedores());
                setUpdate(idx);
            }
        }
    }
    
    private void setUpdate(int idx){
        int idxup = -1;
        for(int i = 0 ; i < updates.size() ; i++){
            if(archivos.get(idx).getID() == updates.get(i).getID()){
                idxup = i;
                break;
            }
        }

        if(idxup != -1){
            updates.set(idxup, archivos.get(idx));
        } else {
            updates.add(archivos.get(idx));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        BGroupTipos = new javax.swing.ButtonGroup();
        popAdminProdServ = new javax.swing.JPopupMenu();
        APSItemProveedores = new javax.swing.JMenuItem();
        APSItemEliminar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsumos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        RadCualquiera = new javax.swing.JRadioButton();
        RadServicios = new javax.swing.JRadioButton();
        RadProductos = new javax.swing.JRadioButton();
        RadNuevos = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        BAceptar = new javax.swing.JButton();
        BAplicar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        TBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        APSItemProveedores.setText("Proveedores");
        APSItemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                APSItemProveedoresActionPerformed(evt);
            }
        });
        popAdminProdServ.add(APSItemProveedores);

        APSItemEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT, java.awt.event.InputEvent.CTRL_MASK));
        APSItemEliminar.setText("Eliminar Archivo");
        APSItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                APSItemEliminarActionPerformed(evt);
            }
        });
        popAdminProdServ.add(APSItemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Catalogo de Productos y Servicios");
        setResizable(false);

        TConsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Concepto", "Precio"
            }
        ));
        TConsumos.setSelectionBackground(new java.awt.Color(153, 204, 255));
        TConsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TConsumosMouseClicked(evt);
            }
        });
        TConsumos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TConsumosPropertyChange(evt);
            }
        });
        TConsumos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TConsumosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TConsumos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modelo"));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        BGroupTipos.add(RadCualquiera);
        RadCualquiera.setSelected(true);
        RadCualquiera.setText("Cualquiera");
        RadCualquiera.setNextFocusableComponent(TBuscar);
        RadCualquiera.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RadCualquieraItemStateChanged(evt);
            }
        });
        jPanel1.add(RadCualquiera);

        BGroupTipos.add(RadServicios);
        RadServicios.setText("Servicios");
        RadServicios.setNextFocusableComponent(TBuscar);
        RadServicios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RadServiciosItemStateChanged(evt);
            }
        });
        jPanel1.add(RadServicios);

        BGroupTipos.add(RadProductos);
        RadProductos.setText("Productos");
        RadProductos.setNextFocusableComponent(TBuscar);
        RadProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RadProductosItemStateChanged(evt);
            }
        });
        jPanel1.add(RadProductos);

        BGroupTipos.add(RadNuevos);
        RadNuevos.setText("Nuevo");
        RadNuevos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RadNuevosItemStateChanged(evt);
            }
        });
        jPanel1.add(RadNuevos);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 17);
        jPanel2.add(BAceptar, gridBagConstraints);

        BAplicar.setText("Aplicar");
        BAplicar.setEnabled(false);
        BAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAplicarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 17);
        jPanel2.add(BAplicar, gridBagConstraints);

        BCancelar.setText("Cancelar");
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 17);
        jPanel2.add(BCancelar, gridBagConstraints);

        TBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Palabra Clave:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                        .addGap(103, 103, 103))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TConsumosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TConsumosKeyTyped
        int tecla   = evt.getKeyChar();
        int fila    = TConsumos.getSelectedRow();
        int columna = TConsumos.getSelectedColumn();
        Component editor;
        
        if(tecla == KeyEvent.VK_TAB){
            TConsumos.transferFocus();
        } else if(tecla != KeyEvent.VK_ENTER) {
            if(TConsumos.editCellAt(fila, columna)){
                String nom = TConsumos.getColumnName(columna);
                if(nom.equals("Concepto")){
                    editorDefault.entrandoPorTecla(tecla);
                } else if(nom.equals("Precio")){
                    valida.soloDecimalTyped(evt, editorDecimal.getField());
                    if(!evt.isConsumed()){
                        editorDecimal.entrandoPorTecla();
                    }
                } else if(nom.equals("Stock") || nom.equals("Min") || nom.equals("Max")){
                    casoEditorInteger(nom);
                    if(valida.soloNum(evt) != -1){
                        editorInteger.entrandoPorTecla(tecla);
                    } else {
                        evt.consume();
                    }
                }
                if(!evt.isConsumed()){
                    editor = TConsumos.getEditorComponent();
                    editor.requestFocusInWindow();
                }
            }
        }
    }//GEN-LAST:event_TConsumosKeyTyped

    private void TConsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TConsumosMouseClicked
        Point p = evt.getPoint();
        
        casoEditorInteger(TConsumos.getColumnName(TConsumos.columnAtPoint(p)));
                
        if(SwingUtilities.isRightMouseButton(evt)){
            TConsumos.changeSelection(TConsumos.rowAtPoint(p), TConsumos.columnAtPoint(p), false, false);
            
            if(TConsumos.getSelectedRow() > -1){
                if(RadNuevos.isSelected()){
                    if(modeloNuevos.getTipo(TConsumos.getSelectedRow()).equals("Producto")){
                        APSItemProveedores.setEnabled(true);
                    } else {
                        APSItemProveedores.setEnabled(false);
                    }
                } else {
                    int idx = TConsumos.convertRowIndexToModel(TConsumos.getSelectedRow());
                    modeloTablaAdminPS base = obtenModelo();
                    
                    if(archivos.get(base.getIndice(idx)).getTipo().equals("Producto")){
                        APSItemProveedores.setEnabled(true);
                    } else {
                        APSItemProveedores.setEnabled(false);
                    }
                }
            }
            
            popAdminProdServ.show(evt.getComponent(), evt.getX(), evt.getY());
        }
        
        editorDecimal.entrandoPorClick();
        editorDefault.entrandoPorClick();
        editorInteger.entrandoPorClick();
    }//GEN-LAST:event_TConsumosMouseClicked

    private void RadCualquieraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RadCualquieraItemStateChanged
        misTablas();
    }//GEN-LAST:event_RadCualquieraItemStateChanged

    private void RadServiciosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RadServiciosItemStateChanged
        misTablas();
    }//GEN-LAST:event_RadServiciosItemStateChanged

    private void RadProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RadProductosItemStateChanged
        misTablas();
    }//GEN-LAST:event_RadProductosItemStateChanged

    private void TConsumosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TConsumosPropertyChange
        try{
            if(evt.getOldValue() != null){
                String editor = evt.getOldValue().toString();

                if(editor.contains("cellEditor")){
                    if(!RadNuevos.isSelected()){
                        modeloTablaAdminPS base = obtenModelo();
                        
                        int idx = TConsumos.convertRowIndexToModel(TConsumos.getSelectedRow());
                        if(editor.contains("Combo")){
                            archivos.get(base.getIndice(idx)).setTipo(base.getTipo(idx));
                        } else if(editor.contains("Decimal")){
                            archivos.get(base.getIndice(idx)).setPrecio(base.getPrecio(idx));
                        } else if(editor.contains("Default")){
                            archivos.get(base.getIndice(idx)).setConcepto(base.getConcepto(idx));
                        } else if(editor.contains("Integer")){
                            switch(casoInteger){
                                case COL_STOCK      : archivos.get(base.getIndice(idx)).setStock    (base.getStock      (idx)); break;
                                case COL_MIN_STOCK  : archivos.get(base.getIndice(idx)).setMinStock (base.getMinStock   (idx)); break;
                                case COL_MAX_STOCK  : archivos.get(base.getIndice(idx)).setMaxStock (base.getMaxStock   (idx)); break;
                            }
                        }
                        setUpdate(base.getIndice(idx));
                    } else {
                        int idx = TConsumos.getSelectedRow();
                        if(editor.contains("Combo")){
                            nuevos.get(idx).setTipo(modeloNuevos.getTipo(idx));
                        } else if(editor.contains("Decimal")){
                            nuevos.get(idx).setPrecio(modeloNuevos.getPrecio(idx));
                        } else if(editor.contains("Default")){
                            nuevos.get(idx).setConcepto(modeloNuevos.getConcepto(idx));
                        } else if(editor.contains("Integer")){
                            switch(casoInteger){
                                case COL_STOCK      : nuevos.get(idx).setStock      (modeloNuevos.getStock      (idx)); break;
                                case COL_MIN_STOCK  : nuevos.get(idx).setMinStock   (modeloNuevos.getMinStock   (idx)); break;
                                case COL_MAX_STOCK  : nuevos.get(idx).setMaxStock   (modeloNuevos.getMaxStock   (idx)); break;
                            }
                        }
                        
                        if(validaFila(TConsumos.getSelectedRow()) 
                                && TConsumos.getSelectedRow() == TConsumos.getRowCount() -1){
                            modeloNuevos.filaVacia();
                            nuevos.add(new setGetProdServ());
                        }
                    }
                    BAplicar.setEnabled(true);
                }
            }
        }catch(Exception exc){}
    }//GEN-LAST:event_TConsumosPropertyChange

    private void APSItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APSItemEliminarActionPerformed
        listaEliminados();
    }//GEN-LAST:event_APSItemEliminarActionPerformed

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        aplicaCambios();
        dispose();
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAplicarActionPerformed
        BAplicar.setEnabled(false);
        aplicaCambios();
    }//GEN-LAST:event_BAplicarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void RadNuevosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RadNuevosItemStateChanged
        misTablas();
    }//GEN-LAST:event_RadNuevosItemStateChanged

    private void APSItemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APSItemProveedoresActionPerformed
        invocaDiagAdminProdServLv2();
    }//GEN-LAST:event_APSItemProveedoresActionPerformed

    private void TBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBuscarKeyReleased
        misFiltros();
    }//GEN-LAST:event_TBuscarKeyReleased

    private class accionBuscarEnter extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            TConsumos.requestFocus();
            if(TConsumos.getRowCount() > 0)
                TConsumos.changeSelection(0, 0, false, false);
        }
    }
    
    private class accionRadDerecha extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(RadCualquiera.isFocusOwner()){
                RadServicios.requestFocus();
                RadServicios.setSelected(true);
            } else if(RadServicios.isFocusOwner()){
                RadProductos.requestFocus();
                RadProductos.setSelected(true);
            } else if(RadProductos.isFocusOwner()){
                RadNuevos.requestFocus();
                RadNuevos.setSelected(true);
            } else if(RadNuevos.isFocusOwner()){
                RadCualquiera.requestFocus();
                RadCualquiera.setSelected(true);
            }
        }
    }
    
    private class accionRadIzquierda extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(RadCualquiera.isFocusOwner()){
                RadNuevos.requestFocus();
                RadNuevos.setSelected(true);
            } else if(RadServicios.isFocusOwner()){
                RadCualquiera.requestFocus();
                RadCualquiera.setSelected(true);
            } else if(RadProductos.isFocusOwner()){
                RadServicios.requestFocus();
                RadServicios.setSelected(true);
            } else if(RadNuevos.isFocusOwner()){
                RadProductos.requestFocus();
                RadProductos.setSelected(true);
            }
        }
    }
    
    private class accionTablaBorrar extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            listaEliminados();
        }
    }
    
    private class accionTablaEnter extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            int nCol = TConsumos.getSelectedColumn();
            int nFil = TConsumos.getSelectedRow();
            int fila = TConsumos.getRowCount()-1;
            int colu = TConsumos.getColumnCount()-1;

            if(nCol >= colu && nFil == fila){
                TConsumos.transferFocus();
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

            TConsumos.changeSelection(nFil, nCol, false, false);
        }
    }
    
    private class accionTablaTab extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            TConsumos.transferFocus();
        }
    }
    
    private class accionBotonDerecha extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BAceptar.isFocusOwner())
                BAplicar.requestFocus();
            else if(BAplicar.isFocusOwner())
                BCancelar.requestFocus();
            else if(BCancelar.isFocusOwner())
                BAceptar.requestFocus();
        }
    }
    
    private class accionBotonIzquierda extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(BAceptar.isFocusOwner())
                BCancelar.requestFocus();
            else if(BAplicar.isFocusOwner())
                BAceptar.requestFocus();
            else if(BCancelar.isFocusOwner())
                BAplicar.requestFocus();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem APSItemEliminar;
    private javax.swing.JMenuItem APSItemProveedores;
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BAplicar;
    private javax.swing.JButton BCancelar;
    private javax.swing.ButtonGroup BGroupTipos;
    private javax.swing.JRadioButton RadCualquiera;
    private javax.swing.JRadioButton RadNuevos;
    private javax.swing.JRadioButton RadProductos;
    private javax.swing.JRadioButton RadServicios;
    private javax.swing.JTextField TBuscar;
    private javax.swing.JTable TConsumos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popAdminProdServ;
    // End of variables declaration//GEN-END:variables
    static final int            COL_STOCK           = 0;
    static final int            COL_MIN_STOCK       = 1;
    static final int            COL_MAX_STOCK       = 2;
    int                         casoInteger         = 0;
    ArrayList<setGetProdServ>   archivos            = new ArrayList();
    ArrayList<setGetProdServ>   updates             = new ArrayList();
    ArrayList<setGetProdServ>   deletes             = new ArrayList();
    ArrayList<setGetProdServ>   nuevos              = new ArrayList();
    cellEditorCombo             editorCombo         = new cellEditorCombo();
    cellEditorDecimal           editorDecimal       = new cellEditorDecimal(new accionTablaEnter());
    cellEditorDefault           editorDefault       = new cellEditorDefault(new accionTablaEnter());
    cellEditorInteger           editorInteger       = new cellEditorInteger(new accionTablaEnter());
    Conector                    linker              ;
    DefaultTableCellRenderer    derecha             = new DefaultTableCellRenderer();
    DefaultTableCellRenderer    centro              = new DefaultTableCellRenderer();
    DefaultTableCellRenderer    izquierda           = new DefaultTableCellRenderer();
    modeloTablaAdminPS          modeloCualquiera    = new modeloTablaAdminPS(modeloTablaAdminPS.CUALQUIERA  );
    modeloTablaAdminPS          modeloProductos     = new modeloTablaAdminPS(modeloTablaAdminPS.PRODUCTOS   );
    modeloTablaAdminPS          modeloServicios     = new modeloTablaAdminPS(modeloTablaAdminPS.SERVICIOS   );
    modeloTablaAdminPS          modeloNuevos        = new modeloTablaAdminPS(modeloTablaAdminPS.NUEVOS      );
    setGetPermisos              responsable         ;
    soloNumeros                 valida              = new soloNumeros();
    TableRowSorter              sorter              ;
    upsy                        ouch                = new upsy("diagAdminProdServ");
}