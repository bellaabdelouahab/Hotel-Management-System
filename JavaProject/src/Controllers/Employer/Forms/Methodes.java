package Controllers.Employer.Forms;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
public class Methodes {
    public static Image ImageSaver(String name){
        try{
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG","PNG");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
            BufferedImage imagebBufferedImage = ImageIO.read(chooser.getSelectedFile());
            File imgfile = new File(name+".png");
            ImageIO.write(imagebBufferedImage, "png", imgfile);
            Image card = SwingFXUtils.toFXImage(imagebBufferedImage, null );
            return card;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
