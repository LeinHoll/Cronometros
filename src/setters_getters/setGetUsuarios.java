package setters_getters;

import java.sql.ResultSet;

public class setGetUsuarios {
    
    public int getID(){
        return ID;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public setGetPermisos getPermisos() {
        return permisos;
    }

    public void setPermisos(ResultSet RS) throws Exception{
        if(RS.next()){
            permisos.setID(ID);
            permisos.setAlm_alt(RS.getInt("alm_alt"));
            permisos.setAlm_baj(RS.getInt("alm_baj"));
            permisos.setAlm_con(RS.getInt("alm_con"));
            permisos.setAlm_mod(RS.getInt("alm_mod"));
            permisos.setCli_alt(RS.getInt("cli_alt"));
            permisos.setCli_baj(RS.getInt("cli_baj"));
            permisos.setCli_con(RS.getInt("cli_con"));
            permisos.setCli_mod(RS.getInt("cli_mod"));
            permisos.setMaq_alt(RS.getInt("maq_alt"));
            permisos.setMaq_baj(RS.getInt("maq_baj"));
            permisos.setMaq_con(RS.getInt("maq_con"));
            permisos.setMaq_mod(RS.getInt("maq_mod"));
            permisos.setPro_alt(RS.getInt("pro_alt"));
            permisos.setPro_baj(RS.getInt("pro_baj"));
            permisos.setPro_con(RS.getInt("pro_con"));
            permisos.setPro_mod(RS.getInt("pro_mod"));
            permisos.setTar_alt(RS.getInt("tar_alt"));
            permisos.setTar_baj(RS.getInt("tar_baj"));
            permisos.setTar_con(RS.getInt("tar_con"));
            permisos.setTar_mod(RS.getInt("tar_mod"));
            permisos.setUsu_alt(RS.getInt("usu_alt"));
            permisos.setUsu_baj(RS.getInt("usu_baj"));
            permisos.setUsu_con(RS.getInt("usu_con"));
            permisos.setUsu_mod(RS.getInt("usu_mod"));
        }
        RS.close();
    }
    
    public void setPermisos(setGetPermisos permisos){
        this.permisos = permisos;
    }
    
    int             ID          ;
    String          usuario     = "";
    String          password    = "";
    String          nombre      = "";
    String          paterno     = "";
    String          materno     = "";
    String          direccion   = "";
    String          tel         = "";
    String          cel         = "";
    String          correo      = "";
    setGetPermisos  permisos    = new setGetPermisos();
}