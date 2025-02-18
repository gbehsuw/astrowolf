]/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astrowolf.backend;
import java.awt.Polygon;
import java.awt.Graphics;
/**
 *
 * @author mithu
 */
public class threeDimensionalShape {
    private int[] z;
    private static int paneZ=100;
    private static int observerX=Const.screenWidth/2;
    private static int observerY=Const.screenHeight/2;
    private static int observerZ=0;
    private Polygon twoD;
    private Polygon threeDPoly=new Polygon();
    
    public void update(){
        threeDPoly.reset();
        for(int i=0;i<z.length;i++){
        int xSlope=(z[i]-observerZ)/(observerX-twoD.xpoints[i]);
        int ySlope=(z[i]-observerZ)/(observerY-twoD.ypoints[i]);
        threeDPoly.addPoint(paneZ/xSlope, paneZ/ySlope);
        }
    }
    public void draw(Graphics g){
        update();
        g.drawPolygon(threeDPoly);
    }
}
