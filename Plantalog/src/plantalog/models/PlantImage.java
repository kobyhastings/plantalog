/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;

/**
 *
 * @author Simon
 */
public class PlantImage extends Model
{
    public String plant_id;
    public String image_id;
    public String path;
    public String caption;
    
    public Image image;

    @Override
    public void fromResultSet(ResultSet r) {
        try{
            this.plant_id = r.getString("plant_id");
            this.image_id = r.getString("image_id");
            this.path = r.getString("path");
            this.caption = r.getString("caption");
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        return path;
    }
    
    public Image getImage(){
        if(image == null)
            try{
                image = ImageIO.read(new URL(this.path));
            }catch(IOException e){
            }
        return image;
    }
}
