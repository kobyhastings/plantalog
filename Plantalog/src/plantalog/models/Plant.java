/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import plantalog.DBC;

/**
 *
 * @author Simon
 */
public class Plant extends Model {
    
    static ArrayList<Plant> cache = new ArrayList();
    public String plant_id;
    public String sci_name;
    public String cultivar;
    public String com_name;
    public String notes;
    public ArrayList<PlantImage> images;

    @Override
    public String toString(){
        return "Plant(" + plant_id + ", " + sci_name + ", " + cultivar + ")";
    }    

    @Override
    public ArrayList<Plant> parseResultSet(ResultSet r) {
        ArrayList<Plant> results = new ArrayList();
        try{
            while(r.next()){
                Plant m = get_from_cache(r.getString("plant_id"));
                if(m == null){
                    m = new Plant();
                    cache.add(m);
                }
                m.plant_id = r.getString("plant_id");
                m.cultivar = r.getString("cultivar");
                m.sci_name = r.getString("sci_name");
                m.com_name = r.getString("com_name");
                m.notes = r.getString("notes");
                results.add(m);
            }
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
        return results;
    }
    
    
    public static Plant get(String id) {
        ArrayList<Plant> ps = DBC.executeQuery("Select * from Plant where plant_id=\""+id+"\"", new Plant());
        if(ps.size() > 0){
            Plant p = ps.get(0);
            p.images = DBC.executeQuery("Select * from PlantImage where "+
                "plant_id = '" + p.plant_id + "'", new PlantImage());
            return p;
        }
        return null;
    }
    
    public static Plant get_from_cache(String id){
        Plant m = null; //check cache
        for(Model x : cache){
            if (((Plant)x).plant_id.equals(id)){
                m = (Plant)x;
                break;
            }
        }
        return m;
    }
    
    public static ArrayList<Plant> getAll(){
        return DBC.executeQuery("Select * from Plant;", new Plant());
    }
    
    public static ArrayList<Plant> getPlants(String filter){
        ArrayList<Plant> plants;
        if(filter.isEmpty())
            plants = DBC.executeQuery("Select * from Plant;", new Plant());
        else
            plants = DBC.executeQuery(
                    "Select * from Plant where "+
                    "sci_name LIKE '%"+filter+"%' or "+
                    "cultivar LIKE '%"+filter+"%' or "+
                    "com_name LIKE '%"+filter+"%'", new Plant());
        for(Plant p: plants)
            p.images = DBC.executeQuery("Select * from PlantImage where "+
                "plant_id = '" + p.plant_id + "'", new PlantImage());
        return plants;
    }
}
