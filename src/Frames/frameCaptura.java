package Frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class frameCaptura extends javax.swing.JFrame {

    public frameCaptura(String maquina) {
        initComponents();
        this.setTitle("captura de " + maquina);
        file = new File(maquina + ".png");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Screen");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        try{
            Dimension frame = getSize();
            Image raw = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
            Image escala = raw.getScaledInstance(frame.width, frame.height, Image.SCALE_AREA_AVERAGING);
            LImagen.setIcon(new ImageIcon(escala));
        } catch(Exception exc){}
    }//GEN-LAST:event_formComponentResized

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        file.deleteOnExit();
        file.delete();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LImagen;
    // End of variables declaration//GEN-END:variables
    File file;
}