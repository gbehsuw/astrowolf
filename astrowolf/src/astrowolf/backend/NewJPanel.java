/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package astrowolf.backend;
import java.awt.Graphics;
import javax.swing.*;
/**
 *
 * @author ddrtm
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    threeDimensionalShape shape;
    public NewJPanel() {

        int[] x={1,300, 300,1};
        int[] y={1, 1, 300, 300};
        int[] z={300,300,300,300};
        int[] x1={1,300,300, 1};
        int[] y1={1, 1, 300, 300};
        int[] z1={200,200,200,200};
        Face[] faces={new Face(x,y,z,4), new Face(x1, y1, z1, 4)}; 
        shape=new threeDimensionalShape(faces,2);
        initComponents();
              Timer t =new Timer(10, e -> {
            
//            shape.moveZ(1);
            repaint();
            
        });
        t.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        shape.draw(g);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
