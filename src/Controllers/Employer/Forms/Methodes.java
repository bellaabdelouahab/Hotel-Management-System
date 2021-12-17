package Controllers.Employer.Forms;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
public class Methodes {
    public static BufferedImage ImageSaver(){
        try{
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG","PNG");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
            BufferedImage imagebBufferedImage = ImageIO.read(chooser.getSelectedFile());
            return imagebBufferedImage;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
