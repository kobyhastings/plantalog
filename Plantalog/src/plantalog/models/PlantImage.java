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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import plantalog.DBC;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.http44.*;
import java.io.File;
import java.util.Map;
import plantalog.PlantalogHelper;

/**
 *
 * @author Simon
 */
public class PlantImage extends Model {
    
    static ArrayList<PlantImage> cache = new ArrayList();
    public String plant_id;
    public String image_id;
    public String path;
    public String caption;
    
    public Image image;
    public Plant plant;
    
//    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
//        "cloud_name", "plantalog",
//        "api_key", "649713167377134",
//        "api_secret", "dzmj_KJaiAH5zMeCuGalMQ-9k5Y"));

    @Override
    public ArrayList<PlantImage> parseResultSet(ResultSet r) {
        ArrayList<PlantImage> results = new ArrayList();
        try{
            while(r.next()){
                PlantImage m = get_from_cache(r.getString("image_id"));
                if(m == null){
                    m = new PlantImage();
                    cache.add(m);
                }
                m.plant_id = r.getString("plant_id");
                m.image_id = r.getString("image_id");
                m.path = r.getString("path");
                m.caption = r.getString("caption");
                results.add(m);
            }
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
        return results;
    }
    
    @Override
    public String toString(){
        return path;
    }
    
    public Image getImage(){
        if(image == null)
            try{
                image = ImageIO.read(new URL("https://res.cloudinary.com/plantalog/image/upload/w_600,h_450,c_fill/" + this.path));
            }catch(IOException e){
            }
        return image;
    }

    public static Model get(String id) {
        ArrayList<PlantImage> ps = DBC.executeQuery("Select * from PlantImage where image_id=\""+id+"\"", new PlantImage());
        if(ps.size() > 0){
            PlantImage i = ps.get(0);
            ArrayList<Plant> plants = (DBC.executeQuery("Select * from Plant where plant_id=\""+i.plant_id+"\"", new Plant()));
            if(ps.size() > 0)
                i.plant = plants.get(0);
            return i;
        }
        return null;
    }
    public static PlantImage get_from_cache(String id){
        PlantImage m = null; //check cache
        for(Model x : cache){
            if (((PlantImage)x).image_id.equals(id)){
                m = (PlantImage)x;
                break;
            }
        }
        return m;
    }
    public static ArrayList<PlantImage> getAll(){
        return DBC.executeQuery("Select * from PlantImage;", new PlantImage());
    }
    
    public static String add(File image, String plant_id, String caption) throws IOException {
        String image_id = PlantalogHelper.generateRandomId();
        
        Map config = ObjectUtils.asMap(
            "cloud_name", "plantalog",
            "api_key", "649713167377134",
            "api_secret", "dzmj_KJaiAH5zMeCuGalMQ-9k5Y");
        Cloudinary cloudinary = new Cloudinary(config);
        Map uploadResult = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());
        
        String path = uploadResult.get("public_id") + "." + uploadResult.get("format");
        DBC.execute(
                "insert into PlantImage values ("
                        + "\"" + plant_id + "\", "
                        + "\""+ image_id + "\", "
                        + "\""+ path + "\", "
                        + "\""+ caption + "\")"
        );
        
        return image_id;
    }
    public static void delete(PlantImage p){
        if(p != null)
            DBC.execute("DELETE FROM PlantImage WHERE image_id=\"" + p.image_id + "\""); 
    }
}
