/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astrowolf.backend;
import java.awt.Polygon;
import java.awt.Graphics;
import java.util.Arrays;
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
    private Face[] threeDFaces;
    private Face[] faces;
    public threeDimensionalShape(Face[] faces, int numFaces){
        this.faces=new Face [numFaces];
        threeDFaces=new Face[numFaces];
        Arrays.fill(threeDFaces, new Face());
        for(int i=0;i<numFaces;i++){
            this.faces[i]=faces[i];
        }
    }
    public void update(){
        double xSlope;
        double ySlope;
        for(int i=0;i<faces.length;i++){
            Face curFace=faces[i];
            for(int j=0;j<faces.length;j++){
                int zPoint=faces[i].getCoordinate(j,2);
                //calculate slope
                xSlope=((zPoint)-observerZ)/(curFace.getCoordinate(j,0)-observerX);
                ySlope=(zPoint-observerZ)/(curFace.getCoordinate(j,1)-observerY);
                //calculate points
                threeDFaces[i].setCoordinate(j,0, (int)(paneZ/xSlope));
                threeDFaces[i].setCoordinate(j,1,(int)(paneZ/ySlope));
            }
        }
    }
    public void draw(Graphics g){
        update();
        for(int i=0;i<threeDFaces.length;i++){
            g.drawPolygon(faces[i].getPointXs(),faces[i].getPointYs(),faces[i].getNumOfPoints());
        }
        
    }
}
