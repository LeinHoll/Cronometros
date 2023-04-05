package Util;

import java.awt.Dialog.ModalExclusionType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Reporte {
    
    public Reporte(Conector linker, Date ini, Date fin){
        this.linker = linker;
        parametros.put("fecha_ini", ini);
        parametros.put("fecha_fin", fin);
    }
    
    public void ejecutaReporte(){
        try {
            JasperReport report = (JasperReport)
                    JRLoader.loadObject(
                        this.getClass().getResource("/Jasper/LogRentas.jasper")
                    );
                        
            parametros.put("dir", "lib/logVentas.jasper");
            
            JasperPrint print = JasperFillManager.fillReport(report, parametros, linker.getConector());
            
            JasperViewer view = new JasperViewer(print, false);
            view.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            view.setVisible(true);
        } catch(Exception exc){
            ouch.whoops("ejecutaReporte", exc);
        }
    }
    
    Conector    linker      ;
    Map         parametros  = new HashMap();
    upsy        ouch        = new upsy("Reporte");
}*/