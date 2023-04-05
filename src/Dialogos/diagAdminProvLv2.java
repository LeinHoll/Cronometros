package Dialogos;

import setters_getters.setGetProveedor;
import setters_getters.setGetProdProv;
import Tablas.cellEditorDecimal;
import Tablas.modeloTablaAdminProvLv2;
import Util.Conector;
import Util.soloNumeros;
import Util.upsy;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

public class diagAdminProvLv2 extends javax.swing.JDialog {
    
    public diagAdminProvLv2(java.awt.Dialog parent, boolean modal, Conector linker, int id_prov, boolean mod) {
        super(parent, modal);
        this.mod = mod;
        this.linker = linker;
        switch(id_prov){
            case 0:
                initComponents();
                misComponentes();
                setTitle("Nuevo proveedor");
                break;
            default:
                recuperaProveedor(id_prov);
                recuperaProductos();
                initComponents();
                misComponentes();
                resetDatos();
        }
    }

    private void misComponentes(){    
        TProv.getTableHeader().setReorderingAllowed(false);
        TProv.getTableHeader().setResizingAllowed(false);
        
        TProv.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TProv.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB  , 0), "tab"  );
        TProv.getActionMap().put("enter", new accionTablaEnter());
        TProv.getActionMap().put("tab"  , new accionEnter(TProv));
        
        TProv.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F2   , KeyEvent.CTRL_DOWN_MASK), "f2");
        TProv.getActionMap().put("f2", new accionTablaCtrlF2());
        
        TProv.setModel(modeloProv);
        TProv.setRowSorter(sorter = new TableRowSorter(modeloProv));
        
        TFNombre    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        CBPersona   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TFRfc       .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TFCurp      .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TFDireccion .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TFDireccion .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB  , 0), "enter");
        TFTelefono  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TFCelular   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TFCorreo    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TFWeb       .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        TFNombre    .getActionMap().put("enter", new accionEnter(TFNombre   ));
        CBPersona   .getActionMap().put("enter", new accionEnter(CBPersona  ));
        TFRfc       .getActionMap().put("enter", new accionEnter(TFRfc      ));
        TFCurp      .getActionMap().put("enter", new accionEnter(TFCurp     ));
        TFDireccion .getActionMap().put("enter", new accionEnter(TFDireccion));
        TFTelefono  .getActionMap().put("enter", new accionEnter(TFTelefono ));
        TFCelular   .getActionMap().put("enter", new accionEnter(TFCelular  ));
        TFCorreo    .getActionMap().put("enter", new accionEnter(TFCorreo   ));
        TFWeb       .getActionMap().put("enter", new accionEnter(TFWeb      ));
        
        BSalvar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "derecha");
        BReversa    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "derecha");
        BLimpia     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "derecha");
        
        BSalvar     .getActionMap().put("derecha", new accionBotonDerecha(accionBotonDerecha.BOT_TERMINA));
        BReversa    .getActionMap().put("derecha", new accionBotonDerecha(accionBotonDerecha.BOT_REVERSA));
        BLimpia     .getActionMap().put("derecha", new accionBotonDerecha(accionBotonDerecha.BOT_LIMPIAR));
        
        BSalvar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "izquierda");
        BReversa    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "izquierda");
        BLimpia     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "izquierda");
        
        BSalvar     .getActionMap().put("izquierda", new accionBotonIzquierda(accionBotonIzquierda.BOT_TERMINA));
        BReversa    .getActionMap().put("izquierda", new accionBotonIzquierda(accionBotonIzquierda.BOT_REVERSA));
        BLimpia     .getActionMap().put("izquierda", new accionBotonIzquierda(accionBotonIzquierda.BOT_LIMPIAR));
        
        BSalvar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BReversa    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BLimpia     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BSalvar     .getActionMap().put("enter", new accionBotonEnter(BSalvar    ));
        BReversa    .getActionMap().put("enter", new accionBotonEnter(BReversa   ));
        BLimpia     .getActionMap().put("enter", new accionBotonEnter(BLimpia    ));
                
        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        
        for(int i = 0 ; i < TProv.getColumnCount() ; i++){
            TableColumn col = TProv.getColumnModel().getColumn(i);
            String      nom = TProv.getColumnName(i);
            if(nom.equals("Producto")){
                col.setPreferredWidth(150);
            } else if(nom.equals("Precio")){
                col.setPreferredWidth(30);
                col.setCellRenderer(derecha);
                col.setCellEditor(editorDecimal);
            }
        }
        
        JPanel ps[] = {P1, P2};
        for(int i = 0 ; i < ps.length ; i++){
            Component comps[] = ps[i].getComponents();
            for(int j = 0 ; j < comps.length ; j++){
                if(!(comps[j] instanceof JLabel))
                    comps[j].setEnabled(mod);
            }
        }
        
        modeloProv  .setFreeze  (mod);
        TFDireccion .setEnabled (mod);
    }
    
    private void recuperaProveedor(int id_prov){
        try{
            String SQL = "SELECT * "
                    + "FROM Proveedores "
                    + "WHERE ID = " + id_prov;
            ResultSet RSProv = linker.consulta(SQL);
            if(RSProv.next()) {
                proveedor.setID         (id_prov);
                proveedor.setProveedor  (RSProv.getString("proveedor"   ));
                proveedor.setPersona    (RSProv.getString("persona"     ));
                proveedor.setRfc        (RSProv.getString("rfc"         ));
                proveedor.setCurp       (RSProv.getString("curp"        ));
                proveedor.setDireccion  (RSProv.getString("direccion"   ));
                proveedor.setTelefono   (RSProv.getString("tel"         ));
                proveedor.setCelular    (RSProv.getString("cel"         ));
                proveedor.setCorreo     (RSProv.getString("correo"      ));
                proveedor.setWeb        (RSProv.getString("web"         ));
            }
            RSProv.close();
        }catch(Exception exc){
            ouch.whoops("recuperaProveedor()", exc);
        }
    }
    
    private void recuperaProductos(){
        productos.clear();
        try{
            String SQL = "SELECT Productos_Servicios.concepto, Productos_Servicios.ID, Prc_Prod_Prov.prc_co "
                    + "FROM Productos_Servicios, Prc_Prod_Prov "
                    + "WHERE Prc_Prod_Prov.id_prov = " + proveedor.getID() + " "
                    + "AND Productos_Servicios.ID = Prc_Prod_Prov.id_prod "
                    + "ORDER BY Prc_Prod_Prov.prc_co ASC";
            ResultSet RSProd = linker.consulta(SQL);
            while(RSProd.next()){
                setGetProdProv producto = new setGetProdProv();
                
                producto.setIdProdServ  (RSProd.getInt          ("ID"       ));
                producto.setIdProveedor (proveedor.getID        (           ));
                producto.setPrecio      (RSProd.getDouble       ("prc_co"   ));
                producto.setProducto    (RSProd.getString       ("concepto" ));
                producto.setProveedor   (proveedor.getProveedor (           ));
                
                productos.add(producto);
            }
            RSProd.close();
            modeloProv.setDatos(productos);
        }catch(Exception exc){
            ouch.whoops("recuperaDatos()", exc);
        }
        
    }
    
    private void invocaDiagPuenteProdProv(){
        diagPuenteProdProv puente = new diagPuenteProdProv(this, true, linker, productos, diagPuenteProdProv.PROVEEDOR, proveedor.getProveedor());
        puente.setLocationRelativeTo(null);
        puente.setVisible(true);
        
        if(puente.getSalvo()){
            ArrayList<setGetProdProv> temps = puente.getDatos();
            
            for(int i = 0 ; i < temps.size() ; i++){
                setGetProdProv temp = temps.get(i);
                for(int j = 0 ; j < productos.size() ; j++){
                    setGetProdProv prod = productos.get(j);
                    if(temp.getIdProdServ() == prod.getIdProdServ()){
                        temps.set(i, prod);
                        break;
                    }
                }
            }
            
            productos = temps;
            modeloProv.setDatos(productos);
        }
    }
    
    private void resetDatos(){
        setTitle("Datos de " + proveedor.getProveedor());
        TFNombre    .setText(proveedor.getProveedor());
        CBPersona   .setSelectedItem(proveedor.getPersona());
        TFRfc       .setText(proveedor.getRfc());
        TFCurp      .setText(proveedor.getCurp());
        TFDireccion .setText(proveedor.getDireccion());
        TFTelefono  .setText(proveedor.getTelefono());
        TFCelular   .setText(proveedor.getCelular());
        TFCorreo    .setText(proveedor.getCorreo());
        TFWeb       .setText(proveedor.getWeb());
        recuperaProductos();
    }
    
    public setGetProveedor getProveedor(){
        proveedor.setProveedor  (TFNombre   .getText());
        proveedor.setPersona    (CBPersona  .getSelectedItem().toString());
        proveedor.setRfc        (TFRfc      .getText());
        proveedor.setCurp       (TFCurp     .getText());
        proveedor.setDireccion  (TFDireccion.getText());
        proveedor.setTelefono   (TFTelefono .getText());
        proveedor.setCelular    (TFCelular  .getText());
        proveedor.setCorreo     (TFCorreo   .getText());
        proveedor.setWeb        (TFWeb      .getText());
        return proveedor;
    }
    
    public ArrayList<setGetProdProv> getProductos(){
        return productos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popProv = new javax.swing.JPopupMenu();
        provItemListado = new javax.swing.JMenuItem();
        P1 = new javax.swing.JPanel();
        TFNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFTelefono = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TFDireccion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TFCurp = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        TFCorreo = new javax.swing.JTextField();
        TFWeb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CBPersona = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        TFCelular = new javax.swing.JFormattedTextField();
        TFRfc = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TProv = new javax.swing.JTable(){
            public boolean getScrollableTracksViewportHeight(){
                return TProv.getPreferredSize().height < TProv.getParent().getHeight();
            }
        };
        P2 = new javax.swing.JPanel();
        BSalvar = new javax.swing.JButton();
        BReversa = new javax.swing.JButton();
        BLimpia = new javax.swing.JButton();

        popProv.setToolTipText("");

        provItemListado.setText("Seleccionar Productos");
        provItemListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provItemListadoActionPerformed(evt);
            }
        });
        popProv.add(provItemListado);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        P1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(TFNombre, gridBagConstraints);

        jLabel1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel2, gridBagConstraints);

        try{
            try {
                TFTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
        }catch(Exception exc){}
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(TFTelefono, gridBagConstraints);

        jLabel3.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel3, gridBagConstraints);

        jLabel5.setText("R.F.C.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel5, gridBagConstraints);

        TFDireccion.setColumns(1);
        TFDireccion.setLineWrap(true);
        TFDireccion.setRows(1);
        jScrollPane1.setViewportView(TFDireccion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jScrollPane1, gridBagConstraints);

        jLabel4.setText("(Tel2/Cel/Fax)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel4, gridBagConstraints);

        jLabel8.setText("C.U.R.P.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel8, gridBagConstraints);

        try {
            TFCurp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAAAAAAAAAAAAAAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TFCurp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFCurpFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(TFCurp, gridBagConstraints);

        jLabel6.setText("Correo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(TFCorreo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(TFWeb, gridBagConstraints);

        jLabel7.setText("Pagina web");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel7, gridBagConstraints);

        CBPersona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fisica", "Moral" }));
        CBPersona.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBPersonaItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(CBPersona, gridBagConstraints);

        jLabel9.setText("Persona");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(jLabel9, gridBagConstraints);

        try{
            try {
                TFCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
        }catch(Exception exc){}
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(TFCelular, gridBagConstraints);

        try {
            TFRfc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUUU-######-AAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TFRfc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFRfcFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 4, 7, 4);
        P1.add(TFRfc, gridBagConstraints);

        TProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Producto", "Precio"
            }
        ));
        TProv.setSelectionBackground(new java.awt.Color(153, 204, 255));
        TProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TProvMouseClicked(evt);
            }
        });
        TProv.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TProvPropertyChange(evt);
            }
        });
        TProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TProvKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(TProv);

        P2.setLayout(new java.awt.GridBagLayout());

        BSalvar.setText("Salvar");
        BSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalvarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 50;
        P2.add(BSalvar, gridBagConstraints);

        BReversa.setText("Revertir");
        BReversa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReversaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 15);
        P2.add(BReversa, gridBagConstraints);

        BLimpia.setText("Limpiar");
        BLimpia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLimpiaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 50;
        P2.add(BLimpia, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addComponent(P2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addComponent(P1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFRfcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFRfcFocusLost
        TFRfc.setText(TFRfc.getText().toUpperCase());
    }//GEN-LAST:event_TFRfcFocusLost

    private void CBPersonaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBPersonaItemStateChanged
        try{
            TFRfc.setText("");
            if(CBPersona.getSelectedItem().equals("Fisica"))
                TFRfc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUUU-######-AAA")));
            else {
                TFRfc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-######-AAA")));}
        } catch(Exception exc){}
    }//GEN-LAST:event_CBPersonaItemStateChanged

    private void TProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TProvMouseClicked
        if(SwingUtilities.isRightMouseButton(evt)){
            Point p = evt.getPoint();
            TProv.changeSelection(TProv.rowAtPoint(p), TProv.columnAtPoint(p), false, false);
            if(mod)
                popProv.show(evt.getComponent(), evt.getX(), evt.getY());
        }
        
        filaEditada = TProv.getSelectedRow();
        editorDecimal.entrandoPorClick();
    }//GEN-LAST:event_TProvMouseClicked

    private void TProvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TProvKeyTyped
        int tecla   = evt.getKeyChar();
        int fila    = TProv.getSelectedRow();
        int columna = TProv.getSelectedColumn();
        
        if(tecla != KeyEvent.VK_TAB 
                && tecla != KeyEvent.VK_ENTER
                && TProv.editCellAt(fila, columna)
                && TProv.getColumnName(columna).equals("Precio")){
            valida.soloDecimalTyped(evt, editorDecimal.getField());
            if(!evt.isConsumed()){
                filaEditada = fila;
                editorDecimal.entrandoPorTecla();
                Component editor = TProv.getEditorComponent();
                editor.requestFocusInWindow();
            }
        }
            
    }//GEN-LAST:event_TProvKeyTyped

    private void TProvPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TProvPropertyChange
        if(evt.getOldValue() != null){
            if(evt.getOldValue().toString().contains("cellEditorDecimal")){
                int idx = TProv.convertRowIndexToModel(filaEditada);
                productos.get(idx).setPrecio(modeloProv.getPrecio(idx));
            }
        }
    }//GEN-LAST:event_TProvPropertyChange

    private void provItemListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provItemListadoActionPerformed
        invocaDiagPuenteProdProv();
    }//GEN-LAST:event_provItemListadoActionPerformed

    private void BSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalvarActionPerformed
        if(TProv.isEditing())
            TProv.getCellEditor().stopCellEditing();
        salvar = true;
        dispose();
    }//GEN-LAST:event_BSalvarActionPerformed

    private void BReversaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReversaActionPerformed
        resetDatos();
    }//GEN-LAST:event_BReversaActionPerformed

    private void BLimpiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLimpiaActionPerformed
        TFNombre    .setText("");
        CBPersona   .setSelectedItem("Fisica");
        TFRfc       .setText("");
        TFCurp      .setText("");
        TFDireccion .setText("");
        TFTelefono  .setText("");
        TFCelular   .setText("");
        TFCorreo    .setText("");
        TFWeb       .setText("");
        modeloProv  .limpiaTabla();
    }//GEN-LAST:event_BLimpiaActionPerformed

    private void TFCurpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFCurpFocusLost
        TFCurp.setText(TFCurp.getText().toUpperCase());
    }//GEN-LAST:event_TFCurpFocusLost

    public boolean getSalvo(){
        return salvar;
    }
    
    private class accionEnter extends AbstractAction{
        public accionEnter(Component comp){
            this.comp = comp;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            comp.transferFocus();
        }
        Component comp;
    }
    
    private class accionBotonEnter extends AbstractAction{
        public accionBotonEnter(JButton boton){
            this.boton = boton;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            boton.doClick();
        }
        JButton boton;
    }
    
    private class accionTablaEnter extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            int nCol = TProv.getSelectedColumn();
            int nFil = TProv.getSelectedRow();
            int fila = TProv.getRowCount()-1;
            int colu = TProv.getColumnCount()-1;

            if(nCol >= colu && nFil == fila){
                TProv.transferFocus();
            } else if(nCol >= colu){
                nCol = 1;
                if(nFil == fila){
                    nFil = 0;
                } else {
                    nFil += 1;
                }
            } else {
                nCol += 1;
            }

            TProv.changeSelection(nFil, nCol, false, false);
        }
    }
    
    private class accionBotonDerecha extends AbstractAction{
        public accionBotonDerecha(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case BOT_TERMINA: BReversa  .requestFocus(); break;
                case BOT_REVERSA: BLimpia   .requestFocus(); break;
                case BOT_LIMPIAR: BSalvar .requestFocus(); break;
            }
        }
        int caso;
        static final int BOT_TERMINA = 0;
        static final int BOT_REVERSA = 1;
        static final int BOT_LIMPIAR = 2;
    }
    
    private class accionBotonIzquierda extends AbstractAction{
        public accionBotonIzquierda(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case BOT_TERMINA: BLimpia   .requestFocus(); break;
                case BOT_REVERSA: BSalvar .requestFocus(); break;
                case BOT_LIMPIAR: BReversa  .requestFocus(); break;
            }
        }
        int caso;
        static final int BOT_TERMINA = 0;
        static final int BOT_REVERSA = 1;
        static final int BOT_LIMPIAR = 2;
    }
    
    private class accionTablaCtrlF2 extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            invocaDiagPuenteProdProv();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BLimpia;
    private javax.swing.JButton BReversa;
    private javax.swing.JButton BSalvar;
    private javax.swing.JComboBox CBPersona;
    private javax.swing.JPanel P1;
    private javax.swing.JPanel P2;
    private javax.swing.JFormattedTextField TFCelular;
    private javax.swing.JTextField TFCorreo;
    private javax.swing.JFormattedTextField TFCurp;
    private javax.swing.JTextArea TFDireccion;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JFormattedTextField TFRfc;
    private javax.swing.JFormattedTextField TFTelefono;
    private javax.swing.JTextField TFWeb;
    private javax.swing.JTable TProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu popProv;
    private javax.swing.JMenuItem provItemListado;
    // End of variables declaration//GEN-END:variables
    int                         filaEditada     = 0;
    boolean                     mod             ;
    boolean                     salvar          = false;
    ArrayList<setGetProdProv>   productos       = new ArrayList();
    cellEditorDecimal           editorDecimal   = new cellEditorDecimal(new accionTablaEnter());
    Conector                    linker          ;
    modeloTablaAdminProvLv2     modeloProv      = new modeloTablaAdminProvLv2();
    TableRowSorter              sorter          ;
    setGetProveedor             proveedor       = new setGetProveedor();
    soloNumeros                 valida          = new soloNumeros();
    upsy                        ouch            = new upsy("diagAdminProvLv2");
}