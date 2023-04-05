package Util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
    
    public Conector() {
        try{
            File DirDB = new File("DB");
            DirDB.mkdir();
            
            System.setProperty("derby.system.home", "DB");
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            Conector = DriverManager.getConnection("jdbc:derby:CronometrosDB;create=true");
            state = Conector.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            creaTablas();
        }catch(Exception exc){
            ouch.whoops("Conector()", exc);
            System.exit(0);
        }
    }
    
    private void creaTablas(){
        String sintaxis[] = {
            "CREATE TABLE Log_Rentas ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "id_maquina INT, "
                + "maquina VARCHAR(20), "
                + "fecha DATE, "
                + "hora_inicio TIME, "
                + "hora_fin TIME, "
                + "tiempo VARCHAR(10), "
                + "usuario VARCHAR(20), "
                + "tarifa VARCHAR(20), "
                + "coste_renta DOUBLE, "
                + "coste_consumos DOUBLE"
                + ")",
            "CREATE TABLE Log_Ventas ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "id_renta INT, "
                + "id_productos_servicios INT, "
                + "concepto VARCHAR(100), "
                + "precio DOUBLE, "
                + "cantidad INT, "
                + "total DOUBLE, "
                + "FOREIGN KEY (id_renta) "
                + "REFERENCES Log_Rentas(ID) "
                + "ON DELETE CASCADE ON UPDATE RESTRICT"
                + ")",
            "CREATE TABLE Maquinas_Cronometros ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "nombre VARCHAR(20), "
                + "IP VARCHAR(15), "
                + "tipo VARCHAR(20)"
                + ")",
            "CREATE TABLE Tarifas ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "tarifa VARCHAR(20), "
                + "lapso INT, "
                + "precio DOUBLE"
                + ")",
            "CREATE TABLE Renta_Activa ("
                + "id_maquina INT, "
                + "fecha DATE, "
                + "hora_inicio TIME, "
                + "prepago DOUBLE, "
                + "tiempo_limite INT, "
                + "id_tarifa INT, "
                + "tiempo_transcurrido BIGINT, "
                + "FOREIGN KEY (id_tarifa) "
                + "REFERENCES Tarifas(ID) "
                + "ON DELETE NO ACTION ON UPDATE RESTRICT, "
                + "FOREIGN KEY (id_maquina) "
                + "REFERENCES Maquinas_Cronometros(ID) "
                + "ON DELETE CASCADE ON UPDATE NO ACTION"
                + ")",
            "CREATE TABLE Venta_Activa ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "id_maquina INT, "
                + "id_productos_servicios INT, "
                + "concepto VARCHAR(100), "
                + "precio DOUBLE, "
                + "cantidad INT, "
                + "total DOUBLE, "
                + "FOREIGN KEY (id_maquina) "
                + "REFERENCES Maquinas_Cronometros(ID) "
                + "ON DELETE CASCADE ON UPDATE NO ACTION"
                + ")",
            "CREATE TABLE Proveedores ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "proveedor VARCHAR(50), "
                + "persona VARCHAR(8), "
                + "direccion VARCHAR(100), "
                + "tel VARCHAR(15), "
                + "cel VARCHAR(15), "
                + "correo VARCHAR(50), "
                + "web VARCHAR(50), "
                + "rfc VARCHAR(15), "
                + "curp VARCHAR(20))",
            "CREATE TABLE Productos_Servicios ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "tipo VARCHAR(8), "
                + "concepto VARCHAR(100), "
                + "precio DOUBLE, "
                + "min_stock INT DEFAULT 0, "
                + "max_stock INT DEFAULT 0, "
                + "stock INT DEFAULT 0)",
            "CREATE TABLE Prc_Prod_Prov ("
                + "id_prod INT, "
                + "id_prov INT, "
                + "prc_co DOUBLE, "
                + "FOREIGN KEY (id_prod) "
                + "REFERENCES Productos_Servicios(ID) "
                + "ON DELETE CASCADE ON UPDATE RESTRICT, "
                + "FOREIGN KEY (id_prov) "
                + "REFERENCES Proveedores(ID) "
                + "ON DELETE CASCADE ON UPDATE RESTRICT)",
            "CREATE TABLE Usuarios ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "usuario VARCHAR(50), "
                + "password VARCHAR(50), "
                + "nombre VARCHAR(50), "
                + "ape_pat VARCHAR(30), "
                + "ape_mat VARCHAR(30), "
                + "direccion VARCHAR(100), "
                + "tel VARCHAR(15), "
                + "cel VARCHAR(15), "
                + "correo VARCHAR(50)"
                + ")",
            "CREATE TABLE Venta_Suelta ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "id_productos_servicios INT, "
                + "fecha DATE DEFAULT CURRENT_DATE, "
                + "hora TIME DEFAULT CURRENT_TIME, "
                + "concepto VARCHAR(100), "
                + "precio DOUBLE, "
                + "cantidad INT, "
                + "total DOUBLE "
                + ")",
            "CREATE TABLE Tarifa_Banderas ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "id_tarifa INT, "
                + "lapso INT, "
                + "precio DOUBLE, "
                + "FOREIGN KEY (id_tarifa) "
                + "REFERENCES Tarifas(ID) "
                + "ON DELETE CASCADE ON UPDATE RESTRICT"
                + ")",
            "CREATE TABLE Permisos ("
                + "id_usuario INT, "
                + "usu_con INT DEFAULT 1, "
                + "usu_mod INT DEFAULT 1, "
                + "usu_alt INT DEFAULT 1, "
                + "usu_baj INT DEFAULT 1, "
                + "maq_con INT DEFAULT 1, "
                + "maq_mod INT DEFAULT 1, "
                + "maq_alt INT DEFAULT 1, "
                + "maq_baj INT DEFAULT 1, "
                + "tar_con INT DEFAULT 1, "
                + "tar_mod INT DEFAULT 1, "
                + "tar_alt INT DEFAULT 1, "
                + "tar_baj INT DEFAULT 1, "
                + "alm_con INT DEFAULT 1, "
                + "alm_mod INT DEFAULT 1, "
                + "alm_alt INT DEFAULT 1, "
                + "alm_baj INT DEFAULT 1, "
                + "pro_con INT DEFAULT 1, "
                + "pro_mod INT DEFAULT 1, "
                + "pro_alt INT DEFAULT 1, "
                + "pro_baj INT DEFAULT 1, "
                + "cli_con INT DEFAULT 1, "
                + "cli_mod INT DEFAULT 1, "
                + "cli_alt INT DEFAULT 1, "
                + "cli_baj INT DEFAULT 1, "
                + "FOREIGN KEY (id_usuario) "
                + "REFERENCES Usuarios(ID) "
                + "ON DELETE CASCADE ON UPDATE RESTRICT"
                + ")",
            "CREATE TABLE Renta_Cancelada ("
                + "ID INT NOT NULL PRIMARY KEY "
                + "GENERATED ALWAYS AS IDENTITY "
                + "(START WITH 1, INCREMENT BY 1), "
                + "nombre VARCHAR(20), "
                + "concepto VARCHAR(100), "
                + "fecha DATE, "
                + "hora_inicio TIME, "
                + "tiempo_transcurrido BIGINT"
                + ")"
        };
                 
        for(String sintax : sintaxis){
            try{
                ejecuta(sintax);
            }catch(Exception exc){
                //System.out.println(exc.getMessage());
            }
        }
    }
    
    public void usuarioDefault(){
        try{
          ResultSet RS = inserta("INSERT INTO Usuarios "
                  + "(usuario, password, nombre) "
                  + "VALUES "
                  + "('default', '1', 'default')");
          if(RS.next()){
              int id = RS.getInt(1);
              RS.close();
              ejecuta("INSERT INTO Permisos "
                      + "(id_usuario) "
                      + "VALUES (" + id + ")");
          }
        } catch(Exception exc){}
    }
    
    public void tarifaDefault(){
        try{
            ResultSet RS = inserta("INSERT INTO Tarifas "
                    + "(tarifa, lapso, precio) "
                    + "VALUES "
                    + "('default', 30, 8)");
            if(RS.next()){
                int id = RS.getInt(1);
                RS.close();
                ejecuta("INSERT INTO Tarifa_Banderas "
                        + "(id_tarifa, lapso, precio) "
                        + "VALUES "
                        + "(" + id + " , 10, 6), "
                        + "(" + id + " , 30, 10), "
                        + "(" + id + " , 60, 16)");
            }
        }catch (Exception exc){}
    }
    
    public synchronized void ejecuta(String SQL) throws Exception{
        state.execute(SQL);
    }
    
    public synchronized ResultSet inserta(String SQL) throws Exception{
        state.execute(SQL, Statement.RETURN_GENERATED_KEYS);
        return state.getGeneratedKeys();
    }
    
    public synchronized ResultSet consulta(String SQL) throws Exception{
        return state.executeQuery(SQL);
    }
    
    public synchronized Connection getConector(){
        return Conector;
    }
    
    public void cierra() throws Exception{
        state.close();
        Conector.close();
    }
    
    Connection  Conector;
    Statement   state   ;
    upsy        ouch    = new upsy("Conector");
}