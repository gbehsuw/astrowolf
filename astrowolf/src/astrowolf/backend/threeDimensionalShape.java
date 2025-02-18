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
        Arrays.fill(threeDFaces, new Face(4));
        for(int i=0;i<numFaces;i++){
            this.faces[i]=faces[i];
        }
    }
    public void update(){
        double xSlope;
        double ySlope;
        for(int i=0;i<faces.length;i++){
            Face curFace=faces[i];
            for(int j=0;j<faces[i].getNumOfPoints();j++){
                int zPoint=faces[i].getCoordinate(j,2);
                //calculate slope
                xSlope=(double)((zPoint)-observerZ)/(curFace.getCoordinate(j,0)-observerX);
                ySlope=(double)(zPoint-observerZ)/(curFace.getCoordinate(j,1)-observerY);                //calculate points
                threeDFaces[i].setCoordinate(j,0, curFace.getCoordinate(j,0)-(int)(paneZ/xSlope));
                threeDFaces[i].setCoordinate(j,1, curFace.getCoordinate(j,1) - (int)(paneZ/ySlope));
                
            }
        }
    }
    public void draw(Graphics g){
        update();
        for(int i=0;i<threeDFaces.length;i++){
          
            g.drawPolygon(threeDFaces[i].getPointXs(),threeDFaces[i].getPointYs(),threeDFaces[i].getNumOfPoints());
        }
        
    }
    public void moveZ(int move){
        for(int i=0;i<faces.length;i++){
            faces[i].moveZ(move);
        }
    }

    public int[] getZ() {
        return z;
    }

    public static int getPaneZ() {
        return paneZ;
    }

    public static int getObserverX() {
        return observerX;
    }

    public static int getObserverY() {
        return observerY;
    }

    public static int getObserverZ() {
        return observerZ;
    }

    public Polygon getTwoD() {
        return twoD;
    }

    public Face[] getThreeDFaces() {
        return threeDFaces;
    }

    public Face[] getFaces() {
        return faces;
    }

    public void setZ(int[] z) {
        this.z = z;
    }

    public static void setPaneZ(int paneZ) {
        threeDimensionalShape.paneZ = paneZ;
    }

    public static void setObserverX(int observerX) {
        threeDimensionalShape.observerX = observerX;
    }

    public static void setObserverY(int observerY) {
        threeDimensionalShape.observerY = observerY;
    }

    public static void setObserverZ(int observerZ) {
        threeDimensionalShape.observerZ = observerZ;
    }

    public void setTwoD(Polygon twoD) {
        this.twoD = twoD;
    }

    public void setThreeDFaces(Face[] threeDFaces) {
        this.threeDFaces = threeDFaces;
    }

    public void setFaces(Face[] faces) {
        this.faces = faces;
    }
    
    
}
