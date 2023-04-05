package Paneles;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

public class panelRendererMaquinas extends javax.swing.JPanel {

    public panelRendererMaquinas() {
        initComponents();
        String Dirs[][] = {
            {"Imagenes/Cronometro_Standby.png" ,"Imagenes/Cronometro_Rentando.png" ,"Imagenes/Cobra.png"},
            {"Imagenes/Maquina_OFF_Standby.png","Imagenes/Maquina_OFF_Rentando.png","Imagenes/Cobra.png"},
            {"Imagenes/Maquina_ON_Standby.png" ,"Imagenes/Maquina_ON_Rentando.png" ,"Imagenes/Cobra.png"}
        };
        imagenes = new ImageIcon[Dirs.length][Dirs[0].length];
        for(int i = 0 ; i < Dirs.length ; i++){
            for(int j = 0 ; j < Dirs[i].length ; j++){
                URL url        = panelRendererMaquinas.class.getClassLoader().getResource(Dirs[i][j]);
                Image raw      = Toolkit.getDefaultToolkit().getImage(url);
                Image escala   = raw.getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);
                imagenes[i][j] = new ImageIcon(escala);
            }
        }
    }
    
    protected void setDisplay(Object value){
        String valor[] = value.toString().split("/");
        int fila       = Integer.parseInt(valor[0]);
        int columna    = Integer.parseInt(valor[1]);
        
        LImagen .setIcon(imagenes[fila][columna]);
        LNombre .setText(valor[2]);
    }

    protected void setFondo(boolean seleccionado, int fila){
        if(seleccionado)
            setBackground(new Color(153,153,153));
        else {
            if((fila % 2) == 0)
                setBackground(new Color(204,255,204));
            else
                setBackground(new Color(216,234,255));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LImagen = new javax.swing.JLabel();
        LNombre = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));

        LImagen.setBackground(new java.awt.Color(255, 255, 255));
        LImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Maquina_OFF_Standby.png"))); // NOI18N

        LNombre.setFont(new java.awt.Font("Calibri", 0, 20));
        LNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LNombre.setText("NOMBRE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
            .addComponent(LImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LImagen;
    private javax.swing.JLabel LNombre;
    // End of variables declaration//GEN-END:variables
    ImageIcon imagenes[][];
}