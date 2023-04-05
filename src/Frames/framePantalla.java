package Frames;

import Dialogos.diagAdminMaquinas;
import Dialogos.diagAdminProdServ;
import Dialogos.diagAdminProv;
import Dialogos.diagAdminTarifas;
import Dialogos.diagAdminUser;
import Dialogos.diagCambioMaquina;
import Dialogos.diagCancelar;
import Dialogos.diagConsumos;
import Dialogos.diagFinMaquina;
import Dialogos.diagIniMaquina;
import Dialogos.diagPrepago;
import Dialogos.diagReportes;
import Dialogos.diagTiempoLimite;
import Dialogos.diagVentaSuelta;
import Paneles.panelConsumosResumido;
import Paneles.panelDetalles;
import Tablas.cellRendererCronometros;
import Tablas.cellRendererMaquinas;
import Tablas.cellRendererTotales;
import Tablas.modeloTablaMaquinas;
import Util.Conector;
import Util.Crono;
import Util.socketClient;
import Util.socketServer;
import Util.upsy;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import setters_getters.setGetConsumos;
import setters_getters.setGetMaquinas;
import setters_getters.setGetTarifas;
import setters_getters.setGetUsuarios;

public class framePantalla extends javax.swing.JFrame {
    
    public framePantalla(){}
    
    public framePantalla(Conector linker){
        this.linker = linker;
        initComponents();
        misComponentes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPopMaquina = new javax.swing.JPopupMenu();
        maquinaItemCrono = new javax.swing.JMenuItem();
        maquinaItemCancelar = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        maquinaMenuTarifas = new javax.swing.JMenu();
        maquinaItemConsumos = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        maquinaItemTiempoLimite = new javax.swing.JMenuItem();
        maquinaItemPrepago = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        maquinaMenuCambio = new javax.swing.JMenu();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        maquinaItemFoto = new javax.swing.JMenuItem();
        maquinaItemProcesos = new javax.swing.JMenuItem();
        maquinaCheckTskmgr = new javax.swing.JCheckBoxMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        maquinaItemApagar = new javax.swing.JMenuItem();
        maquinaItemReiniciar = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        maquinaItemCerrar = new javax.swing.JMenuItem();
        PConsumos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TMaquinas = new javax.swing.JTable();
        PDetalles = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        barAccion = new javax.swing.JMenu();
        accionItemCrono = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        accionMenuTarifas = new javax.swing.JMenu();
        accionItemConsumos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        accionItemTiempoLimite = new javax.swing.JMenuItem();
        accionItemPrepago = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        accionMenuCambio = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        accionItemSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        almacenItemVentaSuelta = new javax.swing.JMenuItem();
        almacenItemProdServ = new javax.swing.JMenuItem();
        almacenItemProveedores = new javax.swing.JMenuItem();
        almacenItemClientes = new javax.swing.JMenuItem();
        barPreferencias = new javax.swing.JMenu();
        preferenciasItemMaquinas = new javax.swing.JMenuItem();
        preferenciasItemTarifas = new javax.swing.JMenuItem();
        preferenciasItemUsuarios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        debugItemHilos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jasperItemRentas = new javax.swing.JMenuItem();

        maquinaItemCrono.setFont(new java.awt.Font("Segoe UI", 1, 13));
        maquinaItemCrono.setText("Iniciar");
        maquinaItemCrono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemCronoActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemCrono);

        maquinaItemCancelar.setText("Cancelar renta");
        maquinaItemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemCancelarActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemCancelar);
        menuPopMaquina.add(jSeparator6);

        maquinaMenuTarifas.setText("Tarifas");
        maquinaMenuTarifas.setEnabled(false);
        menuPopMaquina.add(maquinaMenuTarifas);

        maquinaItemConsumos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        maquinaItemConsumos.setText("Consumos");
        maquinaItemConsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemConsumosActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemConsumos);
        menuPopMaquina.add(jSeparator3);

        maquinaItemTiempoLimite.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        maquinaItemTiempoLimite.setText("Tiempo limite");
        maquinaItemTiempoLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemTiempoLimiteActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemTiempoLimite);

        maquinaItemPrepago.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        maquinaItemPrepago.setText("Prepago");
        maquinaItemPrepago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemPrepagoActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemPrepago);
        menuPopMaquina.add(jSeparator4);

        maquinaMenuCambio.setText("Cambio de maquina");
        maquinaMenuCambio.setEnabled(false);
        menuPopMaquina.add(maquinaMenuCambio);
        menuPopMaquina.add(jSeparator8);

        maquinaItemFoto.setText("Captura de pantalla");
        maquinaItemFoto.setEnabled(false);
        maquinaItemFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemFotoActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemFoto);

        maquinaItemProcesos.setText("Procesos activos");
        maquinaItemProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemProcesosActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemProcesos);

        maquinaCheckTskmgr.setSelected(true);
        maquinaCheckTskmgr.setText("Task Manager");
        maquinaCheckTskmgr.setEnabled(false);
        maquinaCheckTskmgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaCheckTskmgrActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaCheckTskmgr);
        menuPopMaquina.add(jSeparator9);

        maquinaItemApagar.setText("Apagar equipo");
        maquinaItemApagar.setEnabled(false);
        maquinaItemApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemApagarActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemApagar);

        maquinaItemReiniciar.setText("Reiniciar equipo");
        maquinaItemReiniciar.setEnabled(false);
        maquinaItemReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemReiniciarActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemReiniciar);
        menuPopMaquina.add(jSeparator10);

        maquinaItemCerrar.setText("Desconectar la terminal");
        maquinaItemCerrar.setEnabled(false);
        maquinaItemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maquinaItemCerrarActionPerformed(evt);
            }
        });
        menuPopMaquina.add(maquinaItemCerrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PConsumos.setLayout(new java.awt.CardLayout());

        TMaquinas.setBackground(new java.awt.Color(240, 240, 240));
        TMaquinas.setFont(new java.awt.Font("Arial", 1, 20));
        TMaquinas.setModel(modelo = new Tablas.modeloTablaMaquinas());
        TMaquinas.setGridColor(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        TMaquinas.setRowMargin(3);
        TMaquinas.setSelectionBackground(new java.awt.Color(102, 204, 255));
        TMaquinas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TMaquinasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TMaquinas);
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "picoEnter"        );
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN , 0), "picoFlechaAbajo"  );
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP   , 0), "picoFlechaArriba" );
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F2   , 0), "picoTiempoLimite" );
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F3   , 0), "picoConsumos"     );
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F7   , 0), "picoPrepagos"     );
        TMaquinas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F9   , 0), "picoCambioMaquina");
        TMaquinas.getActionMap().put("picoEnter"        , new accionPicoEnter       ());
        TMaquinas.getActionMap().put("picoFlechaAbajo"  , new accionPicoFlecha      (accionPicoFlecha.FLECHA_ABAJO));
        TMaquinas.getActionMap().put("picoFlechaArriba" , new accionPicoFlecha      (accionPicoFlecha.FLECHA_ARRIBA));
        TMaquinas.getActionMap().put("picoTiempoLimite" , new accionTiempoLimite    ());
        TMaquinas.getActionMap().put("picoConsumos"     , new accionConsumos        ());
        TMaquinas.getActionMap().put("picoPrepagos"     , new accionPrepagos        ());
        TMaquinas.getActionMap().put("picoCambioMaquina", new accionCambioMaquina   ());

        PDetalles.setLayout(new java.awt.CardLayout());

        barAccion.setText("Accion");
        barAccion.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                barAccionMenuSelected(evt);
            }
        });

        accionItemCrono.setText("Inicia renta");
        accionItemCrono.setEnabled(false);
        accionItemCrono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionItemCronoActionPerformed(evt);
            }
        });
        barAccion.add(accionItemCrono);
        barAccion.add(jSeparator1);

        accionMenuTarifas.setText("Tarifa");
        accionMenuTarifas.setEnabled(false);
        barAccion.add(accionMenuTarifas);

        accionItemConsumos.setText("Consumos");
        accionItemConsumos.setEnabled(false);
        accionItemConsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionItemConsumosActionPerformed(evt);
            }
        });
        barAccion.add(accionItemConsumos);
        barAccion.add(jSeparator7);

        accionItemTiempoLimite.setText("Tiempo limite");
        accionItemTiempoLimite.setEnabled(false);
        accionItemTiempoLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionItemTiempoLimiteActionPerformed(evt);
            }
        });
        barAccion.add(accionItemTiempoLimite);

        accionItemPrepago.setText("Prepago");
        accionItemPrepago.setEnabled(false);
        accionItemPrepago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionItemPrepagoActionPerformed(evt);
            }
        });
        barAccion.add(accionItemPrepago);
        barAccion.add(jSeparator2);

        accionMenuCambio.setText("Cambio de maquina");
        accionMenuCambio.setEnabled(false);
        barAccion.add(accionMenuCambio);
        barAccion.add(jSeparator5);

        accionItemSalir.setText("Salir del programa");
        accionItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionItemSalirActionPerformed(evt);
            }
        });
        barAccion.add(accionItemSalir);

        menuBar.add(barAccion);

        jMenu1.setText("Almacen");

        almacenItemVentaSuelta.setText("Venta suelta");
        almacenItemVentaSuelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almacenItemVentaSueltaActionPerformed(evt);
            }
        });
        jMenu1.add(almacenItemVentaSuelta);

        almacenItemProdServ.setText("Productos & Servicios");
        almacenItemProdServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almacenItemProdServActionPerformed(evt);
            }
        });
        jMenu1.add(almacenItemProdServ);

        almacenItemProveedores.setText("Proveedores");
        almacenItemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almacenItemProveedoresActionPerformed(evt);
            }
        });
        jMenu1.add(almacenItemProveedores);

        almacenItemClientes.setText("Clientes");
        almacenItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almacenItemClientesActionPerformed(evt);
            }
        });
        jMenu1.add(almacenItemClientes);

        menuBar.add(jMenu1);

        barPreferencias.setText("Preferencias");

        preferenciasItemMaquinas.setText("Maquinas");
        preferenciasItemMaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferenciasItemMaquinasActionPerformed(evt);
            }
        });
        barPreferencias.add(preferenciasItemMaquinas);

        preferenciasItemTarifas.setText("Tarifas");
        preferenciasItemTarifas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferenciasItemTarifasActionPerformed(evt);
            }
        });
        barPreferencias.add(preferenciasItemTarifas);

        preferenciasItemUsuarios.setText("Usuarios");
        preferenciasItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferenciasItemUsuariosActionPerformed(evt);
            }
        });
        barPreferencias.add(preferenciasItemUsuarios);

        menuBar.add(barPreferencias);

        jMenu2.setText("Debug");

        debugItemHilos.setText("hilos");
        debugItemHilos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugItemHilosActionPerformed(evt);
            }
        });
        jMenu2.add(debugItemHilos);

        menuBar.add(jMenu2);

        jMenu3.setText("Japser");

        jasperItemRentas.setText("Rentas");
        jasperItemRentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jasperItemRentasActionPerformed(evt);
            }
        });
        jMenu3.add(jasperItemRentas);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PConsumos, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(PDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PConsumos, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void misComponentes(){
        configCards     ();
        configTabla     ();
        configTarifas   ();
        configMaquinas  ();
        configRentas    ();
        configConsumos  ();
        configServer    ();
    }
    
    private void configCards(){
        panel_detalles  = new panelDetalles();
        panel_resumen   = new panelConsumosResumido();
        PDetalles.add(panel_detalles, "1");
        PConsumos.add(panel_resumen , "1");
    }
    
    private void configTabla(){
        DefaultTableCellRenderer Centro = new DefaultTableCellRenderer();
        Centro.setHorizontalAlignment(SwingUtilities.CENTER);
        
        for(int j = 0 ; j < TMaquinas.getColumnCount() ; j++){
            TableColumn col = TMaquinas.getColumnModel().getColumn(j);
            col.setCellRenderer(Centro);
            if(j < 2){
                col.setPreferredWidth(120);
            } else{
                col.setPreferredWidth(15);
            }
            
            switch(j){
                case 0:  col.setCellRenderer(new cellRendererMaquinas   ()); break;
                case 1:  col.setCellRenderer(new cellRendererCronometros()); break;
                default: col.setCellRenderer(new cellRendererTotales    ());
            }
        }
        
        TMaquinas.setRowHeight(75);
        TMaquinas.getTableHeader().setReorderingAllowed(false);
        TMaquinas.getTableHeader().setResizingAllowed  (false);
    }
    
    private void configTarifas(){
        misTarifas();
        
        if(Tarifas.isEmpty()){
            linker.tarifaDefault();
            misTarifas();
        }
    }
    
    private void configMaquinas(){
        try{
            ResultSet RSMaquinas = linker.consulta(
                    "SELECT * "
                    + "FROM Maquinas_Cronometros "
                    + "ORDER BY tipo DESC");
            int counter = 0;
            while(RSMaquinas.next()){
                setGetMaquinas maquina = new setGetMaquinas();
                
                maquina.setID       (RSMaquinas.getInt   ("ID"    ));
                maquina.setNombre   (RSMaquinas.getString("nombre"));
                maquina.setIP       (RSMaquinas.getString("IP"    ));
                maquina.setTipo     (RSMaquinas.getString("tipo"  ));
                
                maquinas.add(maquina);
                Reloj.add(new Crono(this,maquina,counter));
                menuCambio();
                counter++;
            }
            modelo.reseteaTabla(maquinas);
            RSMaquinas.close();
        }catch(Exception exc){
            ouch.whoops("misComponentes()\nque maquinas existen?", exc);
        }
    }
    
    private void configRentas(){
        try{
            ResultSet RSRentando = linker.consulta(
                    "SELECT * "
                    + "FROM Renta_Activa ");
            
            while(RSRentando.next()){
                for(int i = 0 ; i < Reloj.size() ; i++){
                    if(RSRentando.getInt("id_maquina") == Reloj.get(i).getMaquina().getID()){
                        Reloj.get(i).setPrepago         (RSRentando.getDouble   ("prepago"              ));
                        Reloj.get(i).setTiempoLimite    (RSRentando.getInt      ("tiempo_limite"        ));
                        Reloj.get(i).setTiempoRescatado (RSRentando.getLong     ("tiempo_transcurrido"  ));
                        Reloj.get(i).setFechaInicial    (RSRentando.getDate     ("fecha"                ));
                        Reloj.get(i).setHoraInicial     (RSRentando.getTime     ("hora_inicio"          ));
                        for(int j = 0 ; j < Tarifas.size() ; j++){
                            if(RSRentando.getInt("id_tarifa") == Tarifas.get(j).getID()){
                                Reloj.get(i).setTarifario(Tarifas.get(j));
                                break;
                            }
                        }
                        Reloj.get(i).start();
                        break;
                    }
                }
            }
            
            RSRentando.close();
            
        }catch(Exception exc){
            ouch.whoops("misComponentes()\nQue maquinas estan en renta?", exc);
        }
    }
    
    private void configConsumos(){
        try{
            for(int k = 0 ; k < Reloj.size() ; k++){
                if(Reloj.get(k).getEstado() != Crono.ESTADO_STANDBY){
                    ResultSet RSConsumos = linker.consulta(
                            "SELECT * "
                            + "FROM Venta_Activa "
                            + "WHERE id_maquina = " + Reloj.get(k).getMaquina().getID());
                    ArrayList<setGetConsumos> consumos = new ArrayList();
                    
                    while(RSConsumos.next()){
                        setGetConsumos consumo = new setGetConsumos();
                        
                        consumo.setID       (RSConsumos.getInt     ("ID"                       ));
                        consumo.setCodigo   (RSConsumos.getInt     ("id_productos_servicios"   ));
                        consumo.setConcepto (RSConsumos.getString  ("concepto"                 ));
                        consumo.setPrecio   (RSConsumos.getDouble  ("precio"                   ));
                        consumo.setCantidad (RSConsumos.getInt     ("cantidad"                 ));
                        consumo.setTotal    (RSConsumos.getDouble  ("total"                    ));
                        
                        consumos.add(consumo);
                    }
                    
                    Reloj.get(k).setConsumos(consumos);
                    RSConsumos.close();
                }
            }
        } catch(Exception exc){
            ouch.whoops("misComponentes()\nRecuperando consumos", exc);
        }
    }
    
    private void configServer(){
        socketServer serv = new socketServer(this);
        serv.setName("server");
        serv.start();
    }
    
    private void misHilos(){
        try{
            ThreadGroup grupo = Thread.currentThread().getThreadGroup();
            int num = grupo.activeCount();
            Thread hilos[] = new Thread[num * 2];
            num = grupo.enumerate(hilos, false);
            String hilo = "";
            for(int i = 0 ; i < num ; i++){
                hilo += hilos[i].getName() + "\n";
            }
            JOptionPane.showMessageDialog(null, hilo, "hilos", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception exc){}
    }
    
    public void setUsuario(int id){
        try{
            String SQL = "SELECT * FROM Usuarios WHERE ID = " + id;
            ResultSet RS = linker.consulta(SQL);
            if(RS.next()){
                responsable.setID(id);
                responsable.setUsuario  (RS.getString("usuario"));
                responsable.setPassword (RS.getString("password"));
                responsable.setNombre   (RS.getString("nombre"));
                responsable.setPaterno  (RS.getString("ape_pat"));
                responsable.setMaterno  (RS.getString("ape_mat"));
                responsable.setDireccion(RS.getString("direccion"));
                responsable.setTel      (RS.getString("tel"));
                responsable.setCel      (RS.getString("cel"));
                responsable.setCorreo   (RS.getString("correo"));
                RS.close();
                SQL = "SELECT * "
                        + "FROM Permisos "
                        + "WHERE id_usuario = " + id;
                responsable.setPermisos(linker.consulta(SQL));
                setTitle("Cronometros V2.0 - " + responsable.getNombre());
                
                almacenItemProdServ     .setEnabled(responsable.getPermisos().getBool_alm_con());
                almacenItemProveedores  .setEnabled(responsable.getPermisos().getBool_pro_con());
                preferenciasItemMaquinas.setEnabled(responsable.getPermisos().getBool_maq_con());
                preferenciasItemTarifas .setEnabled(responsable.getPermisos().getBool_tar_con());
            }
            RS.close();
        } catch(Exception exc){
            ouch.whoops("setUsuario(int id)", exc);
        }
    }
    
    private void misTarifas(){
        try{
            Tarifas.clear();
            ResultSet RSTarifas = linker.consulta(
                    "SELECT * "
                    + "FROM Tarifas");
            
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
                ResultSet RSBanderas = linker.consulta(
                        "SELECT * "
                        + "FROM Tarifa_Banderas "
                        + "WHERE id_tarifa = " + Tarifas.get(i).getID());
                Tarifas.get(i).setBanderas(RSBanderas);
            }
            
            accionMenuTarifas .removeAll();
            maquinaMenuTarifas.removeAll();
            
            for(int l = 0 ; l < Tarifas.size() ; l++){
                final setGetTarifas aTarifa = Tarifas.get(l);
                final setGetTarifas mTarifa = Tarifas.get(l);
                
                JMenuItem itemATarifa = new JMenuItem(aTarifa.getTarifa());
                JMenuItem itemMTarifa = new JMenuItem(mTarifa.getTarifa());
                
                itemATarifa.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent evt){
                        Reloj.get(TMaquinas.getSelectedRow()).setTarifario(aTarifa);
                        Reloj.get(TMaquinas.getSelectedRow()).syncTarifa();
                    }
                });
                
                itemMTarifa.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent evt){
                        Reloj.get(TMaquinas.getSelectedRow()).setTarifario(mTarifa);
                        Reloj.get(TMaquinas.getSelectedRow()).syncTarifa();
                    }
                });
                
                accionMenuTarifas .add(itemATarifa);
                maquinaMenuTarifas.add(itemMTarifa);
            }
        }catch(Exception exc){
            ouch.whoops("misTarifas()", exc);
        }
    }
    
    private void TMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TMaquinasMouseClicked
        Point p = evt.getPoint();
        int fila = TMaquinas.rowAtPoint(p);
        setActual(fila);
        
        if(SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2){
            iniCrono(fila);
        }
        
        if(SwingUtilities.isRightMouseButton(evt)){
            TMaquinas.changeSelection(fila, TMaquinas.columnAtPoint(p), false, false);
            invocaPopMaquinas(evt);
        }
        
    }//GEN-LAST:event_TMaquinasMouseClicked

    private void maquinaItemPrepagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemPrepagoActionPerformed
        invocaDiagPrepagos();
    }//GEN-LAST:event_maquinaItemPrepagoActionPerformed

    private void maquinaItemCronoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemCronoActionPerformed
        iniCrono(TMaquinas.getSelectedRow());
    }//GEN-LAST:event_maquinaItemCronoActionPerformed

    private void maquinaItemTiempoLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemTiempoLimiteActionPerformed
        invocaDiagTiempoLimite();
    }//GEN-LAST:event_maquinaItemTiempoLimiteActionPerformed

    private void maquinaItemConsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemConsumosActionPerformed
        invocaDiagConsumos();
    }//GEN-LAST:event_maquinaItemConsumosActionPerformed
        
    private void preferenciasItemMaquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferenciasItemMaquinasActionPerformed
        diagAdminMaquinas admMaq = new diagAdminMaquinas(this, true, Reloj, maquinas, responsable.getPermisos());
        admMaq.setLocationRelativeTo(null);
        admMaq.setVisible(true);
        
        if(admMaq.getAcepto()){
            ArrayList<Integer> actualiza = admMaq.getIndices();
            for(int i = 0 ; i < actualiza.size() ; i++){
                if(Reloj.get(i).getEstado() == Crono.ESTADO_STANDBY){
                    maquinas.get(actualiza.get(i)).setTipo  (admMaq.getTipo  (i));
                    maquinas.get(actualiza.get(i)).setNombre(admMaq.getNombre(i));
                    maquinas.get(actualiza.get(i)).setIP    (admMaq.getIP    (i));
                    
                    Reloj.get(i).setMaquina(maquinas.get(actualiza.get(i)));
                    
                    String SQL = "UPDATE Maquinas_Cronometros "
                            + "SET "
                            + "nombre = '"  + admMaq.getNombre(i) + "', "
                            + "IP = '"      + admMaq.getIP(i)     + "', "
                            + "tipo = '"    + admMaq.getTipo(i)   + "' "
                            + "WHERE ID = " + maquinas.get(actualiza.get(i)).getID();
                    try{
                        linker.ejecuta(SQL);
                    } catch(Exception exc){
                        ouch.whoops("MIMaquinasActionPerformed(ActionEvent evt)\nActualizando", exc);
                    }
                }
            }
            ArrayList<Integer> elimina = admMaq.getBorrados();
            for(int j = elimina.size() - 1 ; j >=0 ; j--){
                int remueve = elimina.get(j);
                try{
                    String SQL = "DELETE FROM Maquinas_Cronometros "
                            + "WHERE ID = " + maquinas.get(remueve).getID();
                    
                    linker.ejecuta(SQL);
                    
                    maquinas.remove(remueve);
                    Reloj.remove(remueve);
                    
                }catch(Exception exc){
                    ouch.whoops("MIMaquinasActionPerformed(ActionEvent evt)\nEliminando", exc);
                }
            }
            for(int k = 0 ; k < Reloj.size() ; k++){
                Reloj.get(k).setFila(k);
            }
            for(int l = actualiza.size() ; l < admMaq.getModelo().getRowCount() ; l++){
                String SQL = "INSERT INTO Maquinas_Cronometros "
                        + "(nombre, tipo, IP) "
                        + "VALUES ("
                        + "'" + admMaq.getNombre(l) + "', "
                        + "'" + admMaq.getTipo  (l) + "', "
                        + "'" + admMaq.getIP    (l) + "'"
                        + ")";
                
                try{
                    linker.ejecuta(SQL);
                }catch(Exception exc){
                    ouch.whoops("MIMaquinasActionPerformed(ActionEvent evt)\nAgregando a DB", exc);
                }
            }
            try{
                ResultSet RSMaquinas = linker.consulta("SELECT * FROM Maquinas_Cronometros");
                RSMaquinas.absolute(maquinas.size());
                
                int counter = maquinas.size();
                while(RSMaquinas.next()){
                    setGetMaquinas maquina = new setGetMaquinas();
                    
                    maquina.setID(RSMaquinas.getInt("ID"));
                    maquina.setIP(RSMaquinas.getString("IP"));
                    maquina.setNombre(RSMaquinas.getString("nombre"));
                    maquina.setTipo(RSMaquinas.getString("tipo"));
                    
                    maquinas.add(maquina);
                    Reloj.add(new Crono(this,maquina,counter));
                    counter++;
                }
                
                RSMaquinas.close();
            } catch(Exception exc){
                ouch.whoops("MIMaquinasActionPerformed(ActionEvent evt)\nConsultando por nuevas maquinas", exc);
            }
            modelo.reseteaTabla(maquinas);
            menuCambio();
            
            try{
                ThreadGroup grupo = Thread.currentThread().getThreadGroup();
                int num = grupo.activeCount();
                Thread hilos[] = new Thread[num * 2];
                num = grupo.enumerate(hilos, false);
                for(int i = 0 ; i < num ; i++){
                    if(hilos[i] instanceof socketClient){
                        boolean encontrado = false;
                        for(Crono reloj : Reloj){
                            if(reloj.getMaquina().getIP().equals(hilos[i].getName())){
                                encontrado = true;
                                reloj.setCliente((socketClient) hilos[i]);
                                break;
                            }
                        }
                        if(!encontrado){
                            socketClient hilo = (socketClient)hilos[i];
                            hilo.habla("salir");
                        }
                    }
                }
            }catch(Exception exc){}
        }
    }//GEN-LAST:event_preferenciasItemMaquinasActionPerformed

    private void preferenciasItemTarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferenciasItemTarifasActionPerformed
        diagAdminTarifas admTar = new diagAdminTarifas(this, true, linker, Reloj, responsable.getPermisos());
        admTar.setLocationRelativeTo(null);
        admTar.setVisible(true);
                
        misTarifas();
        
        if(Tarifas.isEmpty()){
            linker.tarifaDefault();
            misTarifas();
        }
        
        for(int i = 0 ; i < Reloj.size() ; i++){
            if(Reloj.get(i).getEstado() != Crono.ESTADO_STANDBY){
                for(int j = 0 ; j < Tarifas.size() ; j++){
                    if(Reloj.get(i).getTarifario().getID() == Tarifas.get(j).getID()){
                        Reloj.get(i).setTarifario(Tarifas.get(j));
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_preferenciasItemTarifasActionPerformed

    private void accionItemCronoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionItemCronoActionPerformed
        iniCrono(TMaquinas.getSelectedRow());
    }//GEN-LAST:event_accionItemCronoActionPerformed

    private void accionItemTiempoLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionItemTiempoLimiteActionPerformed
        invocaDiagTiempoLimite();
    }//GEN-LAST:event_accionItemTiempoLimiteActionPerformed

    private void accionItemConsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionItemConsumosActionPerformed
        invocaDiagConsumos();
    }//GEN-LAST:event_accionItemConsumosActionPerformed

    private void accionItemPrepagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionItemPrepagoActionPerformed
        invocaDiagPrepagos();
    }//GEN-LAST:event_accionItemPrepagoActionPerformed

    private void accionItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_accionItemSalirActionPerformed

    private void barAccionMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_barAccionMenuSelected
        if(TMaquinas.getSelectedRow() != -1){
            accionItemCrono.setEnabled(true);
            Crono reloj = Reloj.get(TMaquinas.getSelectedRow());
            if(reloj.getEstado() == Crono.ESTADO_STANDBY){
                accionItemCrono       .setText("Iniciar " + reloj.getMaquina().getNombre());
                accionMenuTarifas     .setEnabled(false);
                accionItemTiempoLimite.setEnabled(false);
                accionItemConsumos    .setEnabled(false);
                accionItemPrepago     .setEnabled(false);
                accionMenuCambio      .setEnabled(false);
            } else {
                accionItemCrono       .setText("Terminar " + reloj.getMaquina().getNombre());
                accionMenuTarifas     .setEnabled(true);
                accionItemTiempoLimite.setEnabled(true);
                accionItemConsumos    .setEnabled(true);
                accionItemPrepago     .setEnabled(true);
                accionMenuCambio      .setEnabled(true);
            }
        } else {
            accionItemCrono.setEnabled(false);
        }
    }//GEN-LAST:event_barAccionMenuSelected

    private void almacenItemProdServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almacenItemProdServActionPerformed
        diagAdminProdServ admPS = new diagAdminProdServ(this, true, linker, responsable.getPermisos());
        admPS.setLocationRelativeTo(null);
        admPS.setVisible(true);
    }//GEN-LAST:event_almacenItemProdServActionPerformed

    private void almacenItemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almacenItemProveedoresActionPerformed
        diagAdminProv admProv = new diagAdminProv(this, true, linker, responsable.getPermisos());
        admProv.setLocationRelativeTo(null);
        admProv.setVisible(true);
    }//GEN-LAST:event_almacenItemProveedoresActionPerformed

    private void almacenItemVentaSueltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almacenItemVentaSueltaActionPerformed
        diagVentaSuelta venta = new diagVentaSuelta(this, true, linker);
        venta.setLocationRelativeTo(null);
        venta.setVisible(true);
    }//GEN-LAST:event_almacenItemVentaSueltaActionPerformed

    private void almacenItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almacenItemClientesActionPerformed
        JOptionPane.showMessageDialog(null, "de momento no esta soportado");
    }//GEN-LAST:event_almacenItemClientesActionPerformed

    private void preferenciasItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferenciasItemUsuariosActionPerformed
        diagAdminUser admUsr = new diagAdminUser(this, true, linker, responsable.getPermisos());
        admUsr.setLocationRelativeTo(null);
        admUsr.setVisible(true);
    }//GEN-LAST:event_preferenciasItemUsuariosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(
                null, 
                "Confirme cerrar programa", 
                "Confirme", 
                JOptionPane.YES_NO_OPTION) == 0){
            try{
                linker.cierra();
                System.exit(0);
            } catch(Exception exc){}
        }
    }//GEN-LAST:event_formWindowClosing

    private void debugItemHilosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugItemHilosActionPerformed
        misHilos();
    }//GEN-LAST:event_debugItemHilosActionPerformed

    private void maquinaCheckTskmgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaCheckTskmgrActionPerformed
        Reloj.get(TMaquinas.getSelectedRow()).syncTskmgr();
    }//GEN-LAST:event_maquinaCheckTskmgrActionPerformed

    private void maquinaItemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemCerrarActionPerformed
        Crono reloj = Reloj.get(TMaquinas.getSelectedRow());
        if(JOptionPane.showConfirmDialog(
                null, 
                "Confirme desconectar a " + reloj.getMaquina().getNombre(), 
                "Confirme",
                JOptionPane.YES_NO_OPTION) == 0)
            reloj.syncSystema(Crono.COMP_CERRAR);
    }//GEN-LAST:event_maquinaItemCerrarActionPerformed

    private void maquinaItemReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemReiniciarActionPerformed
        Crono reloj = Reloj.get(TMaquinas.getSelectedRow());
        if(JOptionPane.showConfirmDialog(
                null, 
                "Confirme reiniciar " + reloj.getMaquina().getNombre(), 
                "Confirme",
                JOptionPane.YES_NO_OPTION) == 0)
            reloj.syncSystema(Crono.COMP_RESTART);
    }//GEN-LAST:event_maquinaItemReiniciarActionPerformed

    private void maquinaItemApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemApagarActionPerformed
        Crono reloj = Reloj.get(TMaquinas.getSelectedRow());
        if(JOptionPane.showConfirmDialog(
                null, 
                "Confirme apagar " + reloj.getMaquina().getNombre(), 
                "Confirme",
                JOptionPane.YES_NO_OPTION) == 0)
            reloj.syncSystema(Crono.COMP_SHUTDOWN);
    }//GEN-LAST:event_maquinaItemApagarActionPerformed

    private void maquinaItemFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemFotoActionPerformed
        Reloj.get(TMaquinas.getSelectedRow()).syncCaptura();
    }//GEN-LAST:event_maquinaItemFotoActionPerformed

    private void maquinaItemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemCancelarActionPerformed
        Crono reloj = Reloj.get(TMaquinas.getSelectedRow());
        reloj.setEstado(Crono.ESTADO_PAUSADO);
        reloj.syncEstado();
        
        diagCancelar cancela = new diagCancelar(this, true, reloj.getMaquina().getNombre());
        cancela.setLocationRelativeTo(null);
        cancela.setVisible(true);
        
        if(cancela.getTerminar()) {
            try {
                String SQL = "INSERT INTO Renta_Cancelada "
                        + "(nombre, concepto, fecha, hora_inicio, tiempo_transcurrido) "
                        + "VALUES ("
                        + "'"   + reloj     .getMaquina().getNombre () + "', "
                        + "'"   + cancela   .getConcepto            () + "', "
                        + "'"   + reloj     .getFormatoFechaInicial () + "', "
                        + "'"   + reloj     .getFormatoHoraInicial  () + "', "
                        + ""    + reloj     .getTiempoTranscurrido  () + ")";
                linker.ejecuta(SQL);
                terminaReloj(reloj, framePantalla.CANCELANDO_RENTA);
            } catch(Exception exc){
                ouch.whoops("maquinaItemCancelarActionPerformed(ActionEvent evt)", exc);
            }
        } else {
            reloj.setEstado(Crono.ESTADO_RENTANDO);
            reloj.syncEstado();
            reloj.syncRenta();
        }
    }//GEN-LAST:event_maquinaItemCancelarActionPerformed

    private void maquinaItemProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maquinaItemProcesosActionPerformed
        Reloj.get(TMaquinas.getSelectedRow()).syncProcesos();
    }//GEN-LAST:event_maquinaItemProcesosActionPerformed

    private void jasperItemRentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jasperItemRentasActionPerformed
        diagReportes report = new diagReportes(this, true, linker);
        report.setLocationRelativeTo(null);
        report.setVisible(true);
    }//GEN-LAST:event_jasperItemRentasActionPerformed
    
    public int getActual(){
        return actual;
    }
    
    public Conector getLinker(){
        return linker;
    }
    
    public modeloTablaMaquinas getModelo(){
        return modelo;
    }
    
    public panelDetalles getPanelDetalles(){
        return panel_detalles;
    }
    
    public panelConsumosResumido getPanelResumen(){
        return panel_resumen;
    }
    
    public ArrayList<Crono> getReloj(){
        return Reloj;
    }
    
    public ArrayList<setGetTarifas> getTarifas(){
        return Tarifas;
    }
    
    private void setActual(int actual){
        this.actual = actual;
        Crono reloj = Reloj.get(actual);
        if(reloj.getEstado() != Crono.ESTADO_STANDBY)
            reloj.detalles();
        else {
            panel_detalles.setDefaults();
            panel_resumen .getModelo().limpiaDatos();
        }
    }
    
    private void iniCrono(int fila){
        Crono reloj = Reloj.get(fila);
        
        switch(reloj.getEstado()){
            case Crono.ESTADO_STANDBY:
                
                diagIniMaquina iniciando = new diagIniMaquina(this, true, reloj.getMaquina().getNombre(), Tarifas);
                iniciando.setLocationRelativeTo(null);
                iniciando.setVisible(true);
                
                if(iniciando.getAcepto()){
                    try{
                        reloj.setTiempoLimite   (iniciando.getTiempoLimite());
                        reloj.setPrepago        (iniciando.getPrepago());
                        reloj.setTarifario      (Tarifas.get(iniciando.getTarifa()));
                        reloj.setFechaInicial   (new Date());

                        String SQL = "INSERT INTO Renta_Activa "
                                + "(id_maquina, fecha, hora_inicio, prepago, "
                                + "tiempo_limite, id_tarifa, tiempo_transcurrido) "
                                + "VALUES "
                                + "("
                                + ""  + reloj.getMaquina().getID()     + ", "
                                + "'" + reloj.getFormatoFechaInicial() + "', "
                                + "'" + reloj.getFormatoHoraInicial()  + "', "
                                + ""  + reloj.getPrepago()             + ", "
                                + ""  + reloj.getTiempoLimite()        + ", "
                                + ""  + iniciando.getIdTarifa()        + ", "
                                + "0)";

                        linker.ejecuta(SQL);
                        
                        reloj.start();                        
                    }catch(Exception exc){
                        ouch.whoops("iniCrono(int fila)\nINSERT INTO", exc);
                    }
                }
            break;
            default:
                reloj.setEstado(Crono.ESTADO_PAUSADO);
                reloj.syncEstado();
                
                diagFinMaquina finalizando = new diagFinMaquina(this,true,reloj);
                finalizando.setLocationRelativeTo(null);
                finalizando.setVisible(true);
                
                if(finalizando.getSalvaCambios())
                    reloj.setConsumos(finalizando.getModelo(), Crono.DIAG_FIN_MAQUINA);
                
                if(finalizando.getFinalizo()) {
                    terminaReloj(reloj, FINALIZANDO_MAQUINA);
                } else {
                    reloj.setEstado(Crono.ESTADO_RENTANDO);
                    reloj.syncEstado();
                    reloj.syncRenta();
                }
        }
    }
    
    private void invocaDiagCambioMaquina(){
        if(TMaquinas.getSelectedRow() != -1){
            Crono reloj = Reloj.get(TMaquinas.getSelectedRow());
            
            if(reloj.getEstado() != Crono.ESTADO_STANDBY){
                diagCambioMaquina cambiando = new diagCambioMaquina(this,true,reloj,Reloj);
                cambiando.setLocationRelativeTo(null);
                cambiando.setVisible(true);
                
                if(cambiando.getAcepto()){
                    intercambia(reloj, Reloj.get(cambiando.getDestino()));
                }
            }
        }
    }
    
    private void invocaDiagConsumos(){
        if(TMaquinas.getSelectedRow() != -1){
            Crono reloj = Reloj.get(TMaquinas.getSelectedRow());
            
            if(reloj.getEstado() != Crono.ESTADO_STANDBY){
                diagConsumos consumiendo = new diagConsumos(this,true,reloj);
                consumiendo.setLocationRelativeTo(null);
                consumiendo.setVisible(true);
                
                if(consumiendo.getAcepto()){
                    reloj.setConsumos(consumiendo.getModelo(), Crono.DIAG_CONSUMOS);
                }
            }
        }
    }
    
    private void invocaDiagPrepagos(){
        if(TMaquinas.getSelectedRow() != -1){
            Crono reloj = Reloj.get(TMaquinas.getSelectedRow());

            if(reloj.getEstado() != Crono.ESTADO_STANDBY){
                diagPrepago prepagando = new diagPrepago(this,true,reloj);
                prepagando.setLocationRelativeTo(null);
                prepagando.setVisible(true);

                if(prepagando.getAcepto()){
                    reloj.setPrepago(prepagando.getPrepagoResultante());
                    reloj.syncPrepago();
                    reloj.unSegundo();
                }
            }
        }
    }
    
    private void invocaDiagTiempoLimite(){
        if(TMaquinas.getSelectedRow() != -1){
            Crono reloj = Reloj.get(TMaquinas.getSelectedRow());
            
            if(reloj.getEstado() != Crono.ESTADO_STANDBY){
                diagTiempoLimite limitando = new diagTiempoLimite(this,true,reloj);
                limitando.setLocationRelativeTo(null);
                limitando.setVisible(true);
                
                if(limitando.getAcepto()){
                    reloj.setTiempoLimite(limitando.getNuevoTiempoLimite());
                    reloj.setEstado(Crono.ESTADO_RENTANDO);
                    reloj.syncEstado();
                    reloj.syncRenta();
                    reloj.syncLimite();
                    reloj.unSegundo();
                }
            }
        }
    }
    
    private void invocaPopMaquinas(java.awt.event.MouseEvent evt){
        Crono reloj   = Reloj.get(TMaquinas.getSelectedRow());
        
        if(reloj.getBoolEstado())
            maquinaItemCrono.setText("Terminar " + reloj.getMaquina().getNombre());
        else
            maquinaItemCrono.setText("Iniciar " + reloj.getMaquina().getNombre());
        
        maquinaItemFoto     .setEnabled(reloj.getBoolFoto());
        
        maquinaItemApagar   .setEnabled(reloj.getBoolSystem());
        maquinaItemReiniciar.setEnabled(reloj.getBoolSystem());
        
        maquinaItemCancelar     .setEnabled(reloj.getBoolEstado());
        maquinaItemConsumos     .setEnabled(reloj.getBoolEstado());
        maquinaItemPrepago      .setEnabled(reloj.getBoolEstado());
        maquinaItemTiempoLimite .setEnabled(reloj.getBoolEstado());
        maquinaMenuCambio       .setEnabled(reloj.getBoolEstado());
        maquinaMenuTarifas      .setEnabled(reloj.getBoolEstado());
        
        if(reloj.getBoolStatus())
            maquinaCheckTskmgr.setSelected(reloj.getTskmgr());

        maquinaCheckTskmgr  .setEnabled(reloj.getBoolStatus());
        maquinaItemCerrar   .setEnabled(reloj.getBoolStatus());
        maquinaItemProcesos .setEnabled(reloj.getBoolStatus());
        
        menuPopMaquina.show(evt.getComponent(), evt.getX(), evt.getY());
    }
    
    public synchronized void menuCambio(){
        accionMenuCambio .removeAll();
        maquinaMenuCambio.removeAll();
        
        for(int i = 0 ; i < Reloj.size() ; i++){
            if(Reloj.get(i).getEstado() == Crono.ESTADO_STANDBY){
                final Crono reloj = Reloj.get(i);

                JMenuItem aCambio = new JMenuItem(reloj.getMaquina().getNombre());
                JMenuItem mCambio = new JMenuItem(reloj.getMaquina().getNombre());

                aCambio.addActionListener(new cambiando(reloj));
                mCambio.addActionListener(new cambiando(reloj));
                
                accionMenuCambio .add(aCambio);
                maquinaMenuCambio.add(mCambio);
            }
        }
    }
        
    private class cambiando implements ActionListener{
        
        public cambiando(Crono destino){
            this.destino = destino;
        }
        
        @Override
        public void actionPerformed(ActionEvent evt){
            intercambia(Reloj.get(TMaquinas.getSelectedRow()), destino);
        }
        
        Crono destino;
    }
    
    private void intercambia(Crono origen, Crono destino){
        destino.setTiempoLimite (origen.getTiempoLimite ());
        destino.setPrepago      (origen.getPrepago      ());
        destino.setFechaBase    (origen.getFechaBase    ());
        destino.setFechaInicial (origen.getFechaInicial ());
        destino.setTarifario    (origen.getTarifario    ());
        destino.setConsumos     (origen.getConsumos     ());
        
        try{
            linker.ejecuta(
                    "UPDATE Renta_Activa "
                    + "SET id_maquina = "    + destino.getMaquina().getID()
                    + " WHERE id_maquina = " + origen .getMaquina().getID());
            linker.ejecuta(
                    "UPDATE Venta_Activa "
                    + "SET id_maquina = "    + destino.getMaquina().getID()
                    + " WHERE id_maquina = " + origen .getMaquina().getID());
        }catch(Exception exc){
            ouch.whoops("intercambia(Crono origen, Crono destino)", exc);
        }
        
        destino.start();
        
        terminaReloj(origen, INTERCAMBIANDO_MAQUINA);
        
        TMaquinas.changeSelection(destino.getFila(), 0, false, false);
        setActual(destino.getFila());
    }
        
    private void terminaReloj(Crono reloj, int caso){
        try{
            reloj.freno();

            switch(caso){
                case FINALIZANDO_MAQUINA:
                    String SQL = "INSERT INTO Log_Rentas "
                            + "(id_maquina, maquina, fecha, hora_inicio, hora_fin, "
                            + "tiempo, usuario, tarifa, coste_renta, coste_consumos) "
                            + "VALUES "
                            + "("
                            + ""  + reloj.getMaquina().getID()      + ", "
                            + "'" + reloj.getMaquina().getNombre()  + "', "
                            + "'" + reloj.getFormatoFechaInicial()  + "', "
                            + "'" + reloj.getFormatoHoraInicial()   + "', "
                            + "'" + reloj.getFormatoHoraFinal()     + "', "
                            + "'" + reloj.cronometro(reloj.getTiempoTranscurrido()) + "', "
                            + "'default', "
                            + "'" + reloj.getTarifario().getTarifa() + "', "
                            + ""  + reloj.getTarifa()   + ", "
                            + ""  + reloj.getConsumo()  + ")";
                    ResultSet RSin = linker.inserta(SQL);
                    
                    int nid = 0;
                    if(RSin.next()){
                        nid = RSin.getInt(1);
                    }
                    
                    RSin.close();
                    
                    if(nid != 0){                        
                        for(setGetConsumos consumo : reloj.getConsumos()){
                            SQL = "INSERT INTO Log_Ventas "
                                    + "(id_renta, id_productos_servicios, "
                                    + "concepto, precio, cantidad, total) "
                                    + "VALUES"
                                    + "("
                                    + ""  + nid                   + ", "
                                    + ""  + consumo.getCodigo()   + ", "
                                    + "'" + consumo.getConcepto() + "', "
                                    + ""  + consumo.getPrecio()   + ", "
                                    + ""  + consumo.getCantidad() + ", "
                                    + ""  + consumo.getTotal()    + ")";
                            linker.ejecuta(SQL);
                            if(consumo.getCodigo() != 0){
                                ResultSet RS = linker.consulta(""
                                        + "SELECT tipo, stock "
                                        + "FROM Productos_Servicios "
                                        + "WHERE ID = " + consumo.getCodigo());
                                if(RS.next() && RS.getString("tipo").equals("Producto")){
                                    int stock = RS.getInt("stock") - consumo.getCantidad();
                                    RS.close();
                                    linker.ejecuta(""
                                            + "UPDATE Productos_Servicios "
                                            + "SET stock = "    + stock + " "
                                            + "WHERE ID = "     + consumo.getCodigo());
                                }
                            }
                        }
                    }
                    
                case CANCELANDO_RENTA:
                    linker.ejecuta(
                            "DELETE FROM Renta_Activa "
                            + "WHERE id_maquina = " + reloj.getMaquina().getID());
                    linker.ejecuta(
                            "DELETE FROM Venta_Activa "
                            + "WHERE id_maquina = " + reloj.getMaquina().getID());
                    
                case INTERCAMBIANDO_MAQUINA:
                    reloj.limpiaDatos();
                    int fila = reloj.getFila();
                    Crono crono = new Crono(this,maquinas.get(fila), fila);
                    
                    try{
                        ThreadGroup grupo = Thread.currentThread().getThreadGroup();
                        int num = grupo.activeCount();
                        Thread hilos[] = new Thread[num * 2];
                        num = grupo.enumerate(hilos, false);
                        for(int i = 0 ; i < num ; i++){
                            if(hilos[i].getName().equals(crono.getMaquina().getIP())){
                                crono.setCliente((socketClient)hilos[i]);
                                break;
                            }
                        }
                    }catch(Exception exc){}
                    
                    Reloj.set(fila, crono);
                    menuCambio();
                    break;
            }
        }catch(Exception exc){
            ouch.whoops("terminaReloj(Crono reloj)", exc);
        }
    }
    
    private class accionCambioMaquina extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            invocaDiagCambioMaquina();
        }
    }
    
    private class accionConsumos extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            invocaDiagConsumos();
        }
    }
    
    private class accionPicoEnter extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(TMaquinas.getSelectedRow() != -1)
                iniCrono(TMaquinas.getSelectedRow());
        }
    }
    
    private class accionPicoFlecha extends AbstractAction{
        public accionPicoFlecha(int caso){
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
                setActual(TMaquinas.getSelectedRow());    
            }catch(Exception exc){}
        }
        
        int caso;
        public static final int FLECHA_ARRIBA  = -1;
        public static final int FLECHA_ABAJO   =  1;
    }
    
    private class accionPrepagos extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            invocaDiagPrepagos();
        }
    }
    
    private class accionTiempoLimite extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent evt){
            invocaDiagTiempoLimite();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PConsumos;
    private javax.swing.JPanel PDetalles;
    private javax.swing.JTable TMaquinas;
    private javax.swing.JMenuItem accionItemConsumos;
    private javax.swing.JMenuItem accionItemCrono;
    private javax.swing.JMenuItem accionItemPrepago;
    private javax.swing.JMenuItem accionItemSalir;
    private javax.swing.JMenuItem accionItemTiempoLimite;
    private javax.swing.JMenu accionMenuCambio;
    private javax.swing.JMenu accionMenuTarifas;
    private javax.swing.JMenuItem almacenItemClientes;
    private javax.swing.JMenuItem almacenItemProdServ;
    private javax.swing.JMenuItem almacenItemProveedores;
    private javax.swing.JMenuItem almacenItemVentaSuelta;
    private javax.swing.JMenu barAccion;
    private javax.swing.JMenu barPreferencias;
    private javax.swing.JMenuItem debugItemHilos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem jasperItemRentas;
    private javax.swing.JCheckBoxMenuItem maquinaCheckTskmgr;
    private javax.swing.JMenuItem maquinaItemApagar;
    private javax.swing.JMenuItem maquinaItemCancelar;
    private javax.swing.JMenuItem maquinaItemCerrar;
    private javax.swing.JMenuItem maquinaItemConsumos;
    private javax.swing.JMenuItem maquinaItemCrono;
    private javax.swing.JMenuItem maquinaItemFoto;
    private javax.swing.JMenuItem maquinaItemPrepago;
    private javax.swing.JMenuItem maquinaItemProcesos;
    private javax.swing.JMenuItem maquinaItemReiniciar;
    private javax.swing.JMenuItem maquinaItemTiempoLimite;
    private javax.swing.JMenu maquinaMenuCambio;
    private javax.swing.JMenu maquinaMenuTarifas;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPopupMenu menuPopMaquina;
    private javax.swing.JMenuItem preferenciasItemMaquinas;
    private javax.swing.JMenuItem preferenciasItemTarifas;
    private javax.swing.JMenuItem preferenciasItemUsuarios;
    // End of variables declaration//GEN-END:variables
    int                         actual                  ;
    ArrayList<Crono>            Reloj                   = new ArrayList();
    ArrayList<setGetTarifas>    Tarifas                 = new ArrayList();
    ArrayList<setGetMaquinas>   maquinas                = new ArrayList();
    Conector                    linker                  ;
    modeloTablaMaquinas         modelo                  ;
    panelDetalles               panel_detalles          ;
    panelConsumosResumido       panel_resumen           ;
    setGetUsuarios              responsable             = new setGetUsuarios();
    upsy                        ouch                    = new upsy("framePantalla");
    static final int            FINALIZANDO_MAQUINA     = 0;
    static final int            CANCELANDO_RENTA        = 1;
    static final int            INTERCAMBIANDO_MAQUINA  = 2;
}