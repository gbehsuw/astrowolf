
package astrowolf.backend;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class Image extends JPanel {
    private BufferedImage image;
    private double[][] points = {
            {0, 0, 1},   // Top-left
            {200, 0, 1},  // Top-right
            {200, 200, 1}, // Bottom-right
            {0, 200, 1}   // Bottom-left
    };

    public Image() {
        try {
            image = ImageIO.read(new File("C:\\Users\\mithu\\Downloads\\Images\\pkmn.png")); // Load your image
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double[] projectTo2D(double x, double y, double z) {
        double x2D = (int) (x / (double) z) + 800 / 2;
        double y2D = (int) (y / (double) z) + 800 / 2;
        System.out.println(x2D + " " + y2D);
        return new double[] {x2D, y2D};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Project each corner of the image
        double[][] projected = new double[points.length][2];
        for (int i = 0; i < points.length; i++) {
            projected[i] = projectTo2D(points[i][0], points[i][1], points[i][2]);
        }

        // Map the image corners to the projected polygon
        AffineTransform transform = new AffineTransform();
//        transform.translate(projected[0][0], projected[0][1]);
//        transform.shear(
//            (projected[1][0] - projected[0][0]) / (double) image.getWidth(),
//            (projected[3][1] - projected[0][1]) / (double) image.getHeight()
//        );
        transform.scale(
            (projected[1][0] - projected[0][0]) / (double) image.getWidth(),
            (projected[3][1] - projected[0][1]) / (double) image.getHeight()
        );

        g2.drawImage(image, transform, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Image Projection");
        Image panel = new Image();
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
