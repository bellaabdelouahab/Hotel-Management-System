import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class javaclass {
    public static void main(String args[]){
        try{
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG","PNG");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
            }        
            BufferedImage image = ImageIO.read(chooser.getSelectedFile());
            File imgfile = new File("../../../Resources/IMAGES/ProfileImg/screenshot.png");
            ImageIO.write(image, "png", imgfile);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
