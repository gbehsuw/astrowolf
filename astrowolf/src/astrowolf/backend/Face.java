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
    
    private int[] face;
    private int numOfPoints;
    private int[] RGB;
    
    // Face constructor
    public Face(int[] face){
        
        this.face = face;
        numOfPoints = face.length;
        
    }
    
    // Set the colour of the face
    private void setColour(int R, int G, int B){
        RGB[0] = R;
        RGB[1] = G;
        RGB[2] = B;
    }
    
    // Get the colour of the face
    private int[] getColour(){
        return RGB;
    }
    
    // Get the points of the face
    private int[] getFace(){
        return face;
    }
    
    
}
