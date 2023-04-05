package Util;

import setters_getters.setGetConsumos;
import Tablas.modeloTablaConsumos;
import java.sql.ResultSet;
import java.util.ArrayList;

public class runnableConsumos implements Runnable{
    
    public runnableConsumos(Crono reloj, modeloTablaConsumos modelo){
        this.modelo = modelo;
        this.reloj  = reloj;
    }
    
    @Override
    public void run(){
        try{
            int techo = 0;
            if(modelo.getRowCount() > reloj.getConsumos().size())
                techo = modelo.getRowCount(); 
            else
                techo = reloj.getConsumos().size();
            
            for(int j = 0 ; j < techo ; j++){
                String SQL = "";
                if(modelo.validaFila(j)){
                    if(j < reloj.getConsumos().size()){
                        SQL = "UPDATE Venta_Activa "
                                + "SET "
                                + "id_maquina = "             + reloj .getMaquina ().getID() + ", "
                                + "id_productos_servicios = " + modelo.getCodigo  (j)        + ", "
                                + "concepto = '"              + modelo.getConcepto(j)        + "', "
                                + "precio = "                 + modelo.getPrecio  (j)        + ", "
                                + "cantidad = "               + modelo.getCantidad(j)        + ", "
                                + "total = "                  + modelo.getTotal   (j)        + " "
                                + "WHERE ID = "               + reloj .getConsumos().get(j).getID();
                    } else {
                        SQL = "INSERT INTO Venta_Activa "
                                + "(id_maquina, id_productos_servicios, concepto, precio, cantidad, total) "
                                + "VALUES"
                                + "("
                                + ""  + reloj.getMaquina  ().getID() + ", "
                                + ""  + modelo.getCodigo  (j)        + ", "
                                + "'" + modelo.getConcepto(j)        + "', "
                                + ""  + modelo.getPrecio  (j)        + ", "
                                + ""  + modelo.getCantidad(j)        + ", "
                                + ""  + modelo.getTotal   (j)
                                + ")";
                    }
                } else if (j < reloj.getConsumos().size()){
                    SQL = "DELETE FROM Venta_Activa "
                            + "WHERE ID = " + reloj.getConsumos().get(j).getID(); 
                }
                
                if(!SQL.equals(""))
                    reloj.getFrame().getLinker().ejecuta(SQL);
            }
            
            ResultSet RS = reloj.getFrame().getLinker().consulta(
                    "SELECT * "
                    + "FROM Venta_Activa "
                    + "WHERE id_maquina = " + reloj.getMaquina().getID());

            while(RS.next()){
                setGetConsumos consumo = new setGetConsumos();

                consumo.setID       (RS.getInt      ("ID"                       ));
                consumo.setCodigo   (RS.getInt      ("id_productos_servicios"   ));
                consumo.setConcepto (RS.getString   ("concepto"                 ));
                consumo.setPrecio   (RS.getDouble   ("precio"                   ));
                consumo.setCantidad (RS.getInt      ("cantidad"                 ));
                consumo.setTotal    (RS.getDouble   ("total"                    ));

                consumos.add(consumo);
            }

            RS.close();
            reloj.setConsumos(consumos);
        }catch(Exception exc){
            ouch.whoops("run()", exc);
        }
    }
    
    ArrayList<setGetConsumos> consumos = new ArrayList();
    Crono reloj;
    modeloTablaConsumos modelo;
    upsy ouch = new upsy("runnableConsumos");
}
