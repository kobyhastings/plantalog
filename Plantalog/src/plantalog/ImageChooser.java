/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantalog;

import java.awt.Component;
import java.io.File;
import javax.accessibility.Accessible;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kobyhastings
 */
public class ImageChooser extends JComponent implements Accessible {
    
    protected static JFileChooser chooser = new JFileChooser();
    
    /**
     *
     * Opens the dialog box to choose an image from the local hard drive
     * 
     */
    public static void showImageChooser(Component parent) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & PNG Images", "jpg", "jpeg", "png");
        chooser.setFileFilter(filter);
        int returnVal;
        returnVal = chooser.showOpenDialog(parent);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                chooser.getSelectedFile().getName());
        }
    }
    
    public static File getSelectedFile() {
        return chooser.getSelectedFile();
    }
    
}
