/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astrowolf.backend;

/**
 *
 * @author ddrtm
 */
public class Face {
    
    private int[][] facePoints;
    private int numOfPoints;
    private int[] RGB;
    
    // Face constructor
    public Face(int[] x, int[] y, int[] z, int numPoints){
        numOfPoints = numPoints;
        facePoints=new int[numPoints][3];
        for (int i=0;i<numPoints;i++){
            facePoints[i][0]=x[i];
            facePoints[i][1]=y[i];
            facePoints[i][2]=z[i];
        }
        
        
    }
    
    // Set the colour of the face
    public void setColour(int R, int G, int B){
        RGB[0] = R;
        RGB[1] = G;
        RGB[2] = B;
    }
    
    // Get the colour of the face
    public int[] getColour(){
        return RGB;
    }
    public int[] getPointXs(){
        int[] output=new int[numOfPoints];
        for(int i=0;i<numOfPoints;i++){
            output[i]=facePoints[i][0];
        }
        return output;
    }
        public int[] getPointYs(){
        int[] output=new int[numOfPoints];
        for(int i=0;i<numOfPoints;i++){
            output[i]=facePoints[i][1];
        }
        return output;
    }
        public int getNumOfPoints(){
            return numOfPoints;
        }
    // Get the points of the face
    public int[][] getFacePoints(){
        return facePoints;
    }
    public int getCoordinate(int point,int xyz){
        return facePoints[point][xyz];
    }
    public void setCoordinate(int point,int xyz, int newCord){
        facePoints[point][xyz]=newCord;
    }
    
}
