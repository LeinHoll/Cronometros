package Dialogos;

import setters_getters.setGetUsuarios;
import setters_getters.setGetPermisos;
import Util.Conector;
import Util.upsy;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class diagAdminUserLv2 extends javax.swing.JDialog {

    public diagAdminUserLv2(java.awt.Dialog parent, boolean modal, int ID, Conector linker, setGetPermisos responsable) {
        super(parent, modal);
        this.responsable    = responsable;
        this.linker         = linker;
        usuario.setID(ID);
        initComponents();
        misComponentes();
    }
    
    private void misComponentes(){
        recuperaDatos();
        
        TUsuario    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TNombre     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TPaterno    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TMaterno    .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TDireccion  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TDireccion  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB  , 0), "enter");
        TTel        .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TCel        .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        TCorreo     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        TUsuario    .getActionMap().put("enter", new accionTextoEnter(TUsuario));
        TNombre     .getActionMap().put("enter", new accionTextoEnter(TNombre));
        TPaterno    .getActionMap().put("enter", new accionTextoEnter(TPaterno));
        TMaterno    .getActionMap().put("enter", new accionTextoEnter(TMaterno));
        TDireccion  .getActionMap().put("enter", new accionTextoEnter(TDireccion));
        TTel        .getActionMap().put("enter", new accionTextoEnter(TTel));
        TCel        .getActionMap().put("enter", new accionTextoEnter(TCel));
        TCorreo     .getActionMap().put("enter", new accionTextoEnter(TCorreo));
        
        BPass       .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BPermisos   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BSalvar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        BRestaurar  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        
        BPass       .getActionMap().put("enter", new accionBotonEnter(BPass));
        BPermisos   .getActionMap().put("enter", new accionBotonEnter(BPermisos));
        BSalvar     .getActionMap().put("enter", new accionBotonEnter(BSalvar));
        BRestaurar  .getActionMap().put("enter", new accionBotonEnter(BRestaurar));
        
        BPass       .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "horizontal");
        BPermisos   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "horizontal");
        BSalvar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "horizontal");
        BRestaurar  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "horizontal");
        
        BPass       .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "horizontal");
        BPermisos   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "horizontal");
        BSalvar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "horizontal");
        BRestaurar  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "horizontal");
        
        BPass       .getActionMap().put("horizontal", new accionBotonHorizontal(BOT_PASS));
        BPermisos   .getActionMap().put("horizontal", new accionBotonHorizontal(BOT_PERM));
        BSalvar     .getActionMap().put("horizontal", new accionBotonHorizontal(BOT_SALV));
        BRestaurar  .getActionMap().put("horizontal", new accionBotonHorizontal(BOT_REST));
        
        BPass       .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "vertical");
        BPermisos   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "vertical");
        BSalvar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "vertical");
        BRestaurar  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "vertical");
        
        BPass       .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "vertical");
        BPermisos   .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "vertical");
        BSalvar     .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "vertical");
        BRestaurar  .getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "vertical");
        
        BPass       .getActionMap().put("vertical", new accionBotonVertical(BOT_PASS));
        BPermisos   .getActionMap().put("vertical", new accionBotonVertical(BOT_PERM));
        BSalvar     .getActionMap().put("vertical", new accionBotonVertical(BOT_SALV));
        BRestaurar  .getActionMap().put("vertical", new accionBotonVertical(BOT_REST));
        
        valComponentes();
    }
    
    private void valComponentes(){
        if(responsable.getID() != usuario.getID()){
            Component textos[] = PTextos.getComponents();

            for(int i = 0 ; i < textos.length ; i++){
                if(textos[i] instanceof JTextField)
                    textos[i].setEnabled(responsable.getBool_usu_mod());
            }

            TDireccion  .setEnabled(responsable.getBool_usu_mod());
            BPass       .setEnabled(responsable.getBool_usu_mod());
        }
    }
    
    private void recuperaDatos(){
        try{
            if(usuario.getID() == NUEVO){
                usuario = new setGetUsuarios();
                setTitle("Nuevo usuario");
            } else {
                String SQL = "SELECT * "
                            + "FROM Usuarios "
                            + "WHERE ID = " + usuario.getID();
                ResultSet RS = linker.consulta(SQL);
                if(RS.next()){
                    usuario.setUsuario  (RS.getString("usuario"     ));
                    usuario.setPassword (RS.getString("password"    ));
                    usuario.setNombre   (RS.getString("nombre"      ));
                    usuario.setPaterno  (RS.getString("ape_pat"     ));
                    usuario.setMaterno  (RS.getString("ape_mat"     ));
                    usuario.setDireccion(RS.getString("direccion"   ));
                    usuario.setTel      (RS.getString("tel"         ));
                    usuario.setCel      (RS.getString("cel"         ));
                    usuario.setCorreo   (RS.getString("correo"      ));
                    RS.close();
                    SQL = "SELECT * FROM Permisos WHERE id_usuario = " + usuario.getID();
                    usuario.setPermisos(linker.consulta(SQL));
                    setTitle("Datos de " + usuario.getUsuario());
                }
            }
                        
            TUsuario    .setText(usuario.getUsuario     ());
            TNombre     .setText(usuario.getNombre      ());
            TPaterno    .setText(usuario.getPaterno     ());
            TMaterno    .setText(usuario.getMaterno     ());
            TDireccion  .setText(usuario.getDireccion   ());
            TTel        .setText(usuario.getTel         ());
            TCel        .setText(usuario.getCel         ());
            TCorreo     .setText(usuario.getCorreo      ());
        }catch(Exception exc){
            ouch.whoops("recuperaDatos()", exc);
        }
    }
    
    private void habilitaBotones(boolean caso){
        BSalvar     .setEnabled(caso);
        BRestaurar  .setEnabled(caso);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BPass = new javax.swing.JButton();
        BPermisos = new javax.swing.JButton();
        BSalvar = new javax.swing.JButton();
        BRestaurar = new javax.swing.JButton();
        PTextos = new javax.swing.JPanel();
        TUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TCel = new javax.swing.JFormattedTextField();
        TTel = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TPaterno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TDireccion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TNombre = new javax.swing.JTextField();
        TCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TMaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        BPass.setText("Cambiar contraseña");
        BPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPassActionPerformed(evt);
            }
        });
        jPanel1.add(BPass);

        BPermisos.setText("Ver permisos de cuenta");
        BPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPermisosActionPerformed(evt);
            }
        });
        jPanel1.add(BPermisos);

        BSalvar.setText("Salvar cambios");
        BSalvar.setEnabled(false);
        BSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(BSalvar);

        BRestaurar.setText("Restaurar cambios");
        BRestaurar.setEnabled(false);
        BRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRestaurarActionPerformed(evt);
            }
        });
        jPanel1.add(BRestaurar);

        TUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TUsuarioKeyTyped(evt);
            }
        });

        jLabel1.setText("Nombre(s):");

        try {
            TCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TCelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TCelKeyTyped(evt);
            }
        });

        try {
            TTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TTelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TTelKeyTyped(evt);
            }
        });

        jLabel4.setText("Direccion");

        jLabel3.setText("Apellido mat:");

        jLabel5.setText("Telefono");

        TPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TPaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TPaternoKeyTyped(evt);
            }
        });

        TDireccion.setColumns(10);
        TDireccion.setFont(new java.awt.Font("Tahoma", 0, 11));
        TDireccion.setLineWrap(true);
        TDireccion.setRows(2);
        TDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TDireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TDireccionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(TDireccion);

        jLabel6.setText("Celular");

        jLabel8.setText("Nombre de usuario:");

        TNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TNombreKeyTyped(evt);
            }
        });

        TCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TCorreoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TCorreoKeyTyped(evt);
            }
        });

        jLabel2.setText("Apellido pat:");

        TMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TMaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TMaternoKeyTyped(evt);
            }
        });

        jLabel7.setText("Correo electronico");

        javax.swing.GroupLayout PTextosLayout = new javax.swing.GroupLayout(PTextos);
        PTextos.setLayout(PTextosLayout);
        PTextosLayout.setHorizontalGroup(
            PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTextosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)
                        .addComponent(TUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addComponent(TNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(TPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(TMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(60, 60, 60)
                        .addComponent(TTel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(TCel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14)
                        .addComponent(TCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PTextosLayout.setVerticalGroup(
            PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PTextosLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(TUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(TNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(TPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(TMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(TTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(TCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(PTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PTextosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(TCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
            .addComponent(PTextos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PTextos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPassActionPerformed
        diagCambioPassword camPas = new diagCambioPassword(this,true,usuario.getPassword());
        camPas.setLocationRelativeTo(null);
        camPas.setVisible(true);
        
        if(camPas.getSalvo()){
            usuario.setPassword(camPas.getPassword());
            
            habilitaBotones(true);
        }
    }//GEN-LAST:event_BPassActionPerformed

    private void TUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TUsuarioKeyTyped
        habilitaBotones(true);
    }//GEN-LAST:event_TUsuarioKeyTyped

    private void TNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNombreKeyTyped
        habilitaBotones(true);
    }//GEN-LAST:event_TNombreKeyTyped

    private void TPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TPaternoKeyTyped
        habilitaBotones(true);
    }//GEN-LAST:event_TPaternoKeyTyped

    private void TMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TMaternoKeyTyped
        habilitaBotones(true);
    }//GEN-LAST:event_TMaternoKeyTyped

    private void TDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TDireccionKeyTyped
        habilitaBotones(true);
    }//GEN-LAST:event_TDireccionKeyTyped

    private void TTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TTelKeyTyped
        habilitaBotones(true);
    }//GEN-LAST:event_TTelKeyTyped

    private void TCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCelKeyTyped
        habilitaBotones(true);
    }//GEN-LAST:event_TCelKeyTyped

    private void TCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCorreoKeyTyped
        habilitaBotones(true);
    }//GEN-LAST:event_TCorreoKeyTyped

    private void BSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalvarActionPerformed
        try{
            String SQL = "";
            switch(usuario.getID()){
                case NUEVO:
                    SQL = "INSERT INTO Usuarios "
                            + "(usuario, password, nombre, ape_pat, ape_mat, "
                            + "direccion, tel, cel, correo) "
                            + "VALUES ("
                            + "'" + usuario.getUsuario()    + "', "
                            + "'" + usuario.getPassword()   + "', "
                            + "'" + usuario.getNombre()     + "', "
                            + "'" + usuario.getPaterno()    + "', "
                            + "'" + usuario.getMaterno()    + "', "
                            + "'" + usuario.getDireccion()  + "', "
                            + "'" + usuario.getTel()        + "', "
                            + "'" + usuario.getCel()        + "', "
                            + "'" + usuario.getCorreo()     + "')";
                    ResultSet RS = linker.inserta(SQL);
                    if(RS.next()){
                        usuario.setID(RS.getInt(1));
                        RS.close();
                        setGetPermisos p = usuario.getPermisos();
                        SQL = "INSERT INTO Permisos "
                                + "(id_usuario, "
                                + "usu_con, usu_mod, usu_alt, usu_baj, "
                                + "maq_con, maq_mod, maq_alt, maq_baj, "
                                + "tar_con, tar_mod, tar_alt, tar_baj, "
                                + "alm_con, alm_mod, alm_alt, alm_baj, "
                                + "pro_con, pro_mod, pro_alt, pro_baj, "
                                + "cli_con, cli_mod, cli_alt, cli_baj) "
                                + "VALUES ("
                                + "" + usuario.getID()  + ", "
                                + "" + p.getUsu_con()   + ", "
                                + "" + p.getUsu_mod()   + ", "
                                + "" + p.getUsu_alt()   + ", "
                                + "" + p.getUsu_baj()   + ", "
                                + "" + p.getMaq_con()   + ", "
                                + "" + p.getMaq_mod()   + ", "
                                + "" + p.getMaq_alt()   + ", "
                                + "" + p.getMaq_baj()   + ", "
                                + "" + p.getTar_con()   + ", "
                                + "" + p.getTar_mod()   + ", "
                                + "" + p.getTar_alt()   + ", "
                                + "" + p.getTar_baj()   + ", "
                                + "" + p.getAlm_con()   + ", "
                                + "" + p.getAlm_mod()   + ", "
                                + "" + p.getAlm_alt()   + ", "
                                + "" + p.getAlm_baj()   + ", "
                                + "" + p.getPro_con()   + ", "
                                + "" + p.getPro_mod()   + ", "
                                + "" + p.getPro_alt()   + ", "
                                + "" + p.getPro_baj()   + ", "
                                + "" + p.getCli_con()   + ", "
                                + "" + p.getCli_mod()   + ", "
                                + "" + p.getCli_alt()   + ", "
                                + "" + p.getCli_baj()   + ")";
                        linker.ejecuta(SQL);
                    }
                    break;
                default:
                    SQL = "UPDATE Usuarios "
                            + "SET "
                            + "usuario = '"     + usuario.getUsuario    () + "', "
                            + "password = '"    + usuario.getPassword   () + "', "
                            + "nombre = '"      + usuario.getNombre     () + "', "
                            + "ape_pat = '"     + usuario.getPaterno    () + "', "
                            + "ape_mat = '"     + usuario.getMaterno    () + "', "
                            + "direccion = '"   + usuario.getDireccion  () + "', "
                            + "tel = '"         + usuario.getTel        () + "', "
                            + "cel = '"         + usuario.getCel        () + "', "
                            + "correo = '"      + usuario.getCorreo     () + "' "
                            + "WHERE ID = "     + usuario.getID         ();
                    linker.ejecuta(SQL);
                    setGetPermisos p = usuario.getPermisos();
                    SQL = "UPDATE Permisos "
                            + "SET "
                            + "usu_con = " + p.getUsu_con() + ", "
                            + "usu_mod = " + p.getUsu_mod() + ", "
                            + "usu_alt = " + p.getUsu_alt() + ", "
                            + "usu_baj = " + p.getUsu_baj() + ", "
                            + "maq_con = " + p.getMaq_con() + ", "
                            + "maq_mod = " + p.getMaq_mod() + ", "
                            + "maq_alt = " + p.getMaq_alt() + ", "
                            + "maq_baj = " + p.getMaq_baj() + ", "
                            + "tar_con = " + p.getTar_con() + ", "
                            + "tar_mod = " + p.getTar_mod() + ", "
                            + "tar_alt = " + p.getTar_alt() + ", "
                            + "tar_baj = " + p.getTar_baj() + ", "
                            + "alm_con = " + p.getAlm_con() + ", "
                            + "alm_mod = " + p.getAlm_mod() + ", "
                            + "alm_alt = " + p.getAlm_alt() + ", "
                            + "alm_baj = " + p.getAlm_baj() + ", "
                            + "pro_con = " + p.getPro_con() + ", "
                            + "pro_mod = " + p.getPro_mod() + ", "
                            + "pro_alt = " + p.getPro_alt() + ", "
                            + "pro_baj = " + p.getPro_baj() + ", "
                            + "cli_con = " + p.getCli_con() + ", "
                            + "cli_mod = " + p.getCli_mod() + ", "
                            + "cli_alt = " + p.getCli_alt() + ", "
                            + "cli_baj = " + p.getCli_baj() + " "
                            + "WHERE id_usuario = " + p.getID();
                    linker.ejecuta(SQL);
            }
            habilitaBotones(false);
        }catch(Exception exc){
            ouch.whoops("BSalvarActionPerformed(ActionEvent evt)", exc);
        }
    }//GEN-LAST:event_BSalvarActionPerformed

    private void BRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRestaurarActionPerformed
        recuperaDatos();
        habilitaBotones(false);
    }//GEN-LAST:event_BRestaurarActionPerformed

    private void TUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TUsuarioKeyReleased
        usuario.setUsuario(TUsuario.getText());
    }//GEN-LAST:event_TUsuarioKeyReleased

    private void TNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNombreKeyReleased
        usuario.setNombre(TNombre.getText());
    }//GEN-LAST:event_TNombreKeyReleased

    private void TPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TPaternoKeyReleased
        usuario.setPaterno(TPaterno.getText());
    }//GEN-LAST:event_TPaternoKeyReleased

    private void TMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TMaternoKeyReleased
        usuario.setMaterno(TMaterno.getText());
    }//GEN-LAST:event_TMaternoKeyReleased

    private void TDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TDireccionKeyReleased
        usuario.setDireccion(TDireccion.getText());
    }//GEN-LAST:event_TDireccionKeyReleased

    private void TTelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TTelKeyReleased
        usuario.setTel(TTel.getText());
    }//GEN-LAST:event_TTelKeyReleased

    private void TCelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCelKeyReleased
        usuario.setCel(TCel.getText());
    }//GEN-LAST:event_TCelKeyReleased

    private void TCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCorreoKeyReleased
        usuario.setCorreo(TCorreo.getText());
    }//GEN-LAST:event_TCorreoKeyReleased

    private void BPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPermisosActionPerformed
        diagAdminPermisos admPer = new diagAdminPermisos(this, true, usuario.getPermisos(), responsable);
        admPer.setLocationRelativeTo(null);
        admPer.setVisible(true);
        
        if(admPer.getSalvo()){
            usuario.setPermisos(admPer.getPermisos());
            usuario.getPermisos().setID(usuario.getID());
            habilitaBotones(true);
        }
    }//GEN-LAST:event_BPermisosActionPerformed
    
    private class accionTextoEnter extends AbstractAction {
        public accionTextoEnter(JComponent comp){
            this.comp = comp;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            comp.transferFocus();
        }
        JComponent comp;
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
        public accionBotonHorizontal(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case BOT_PASS: BPermisos    .requestFocus(); break;
                case BOT_PERM: BPass        .requestFocus(); break;
                case BOT_REST: BSalvar      .requestFocus(); break;
                case BOT_SALV: BRestaurar   .requestFocus(); break;
            }
        }
        int caso;
    }
    
    private class accionBotonVertical extends AbstractAction {
        public accionBotonVertical(int caso){
            this.caso = caso;
        }
        @Override
        public void actionPerformed(ActionEvent evt){
            switch(caso){
                case BOT_PASS: BSalvar      .requestFocus(); break;
                case BOT_PERM: BRestaurar   .requestFocus(); break;
                case BOT_REST: BPermisos    .requestFocus(); break;
                case BOT_SALV: BPass        .requestFocus(); break;
            }
        }
        int caso;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BPass;
    private javax.swing.JButton BPermisos;
    private javax.swing.JButton BRestaurar;
    private javax.swing.JButton BSalvar;
    private javax.swing.JPanel PTextos;
    private javax.swing.JFormattedTextField TCel;
    private javax.swing.JTextField TCorreo;
    private javax.swing.JTextArea TDireccion;
    private javax.swing.JTextField TMaterno;
    private javax.swing.JTextField TNombre;
    private javax.swing.JTextField TPaterno;
    private javax.swing.JFormattedTextField TTel;
    private javax.swing.JTextField TUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    final static int        BOT_PASS    = 1;
    final static int        BOT_PERM    = 2;
    final static int        BOT_REST    = 3;
    final static int        BOT_SALV    = 4;
    public final static int NUEVO       = 0;
    Conector                linker      ;
    setGetUsuarios          usuario     = new setGetUsuarios();
    setGetPermisos          responsable = new setGetPermisos();
    upsy                    ouch        = new upsy("diagAdminUserLv2");
}