/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import plantalog.DBC;

/**
 *
 * @author Simon
 */
public class Specimen extends Model {
    
    static ArrayList<Specimen> cache = new ArrayList();
    public String plant_id;
    public String specimen_id;
    public String notes;
    public double latitude;
    public double longitude;
    public Date when_added;
    public String lives_in;
    
    public Plant plant;

    @Override
    public ArrayList<Specimen> parseResultSet(ResultSet r) {
        ArrayList<Specimen> results = new ArrayList();
        try{
            while(r.next()){
                Specimen m = get_from_cache(r.getString("specimen_id"));
                if(m == null){
                    m = new Specimen();
                    cache.add(m);
                }
                m.plant_id = r.getString("plant_id");
                m.specimen_id = r.getString("specimen_id");
                m.notes = r.getString("notes");
                m.latitude = r.getFloat("latitude");
                m.longitude = r.getFloat("longitude");
                m.when_added = r.getDate("when_added");
                m.lives_in = r.getString("lives_in");
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
        if(plant != null)
            return plant.sci_name + "'"+plant.cultivar+"' " + lives_in;
        else
            return lives_in;
    }
    
    public static Model get(String id) {
        ArrayList<Specimen> ps = DBC.executeQuery("Select * from Specimen where specimen_id=\""+id+"\"", new Specimen());
        if(ps.size() > 0){
            Specimen s = ps.get(0);
            ArrayList<Plant> plants = (DBC.executeQuery("Select * from Plant where plant_id=\""+s.plant_id+"\"", new Plant()));
            if(ps.size() > 0)
                s.plant = plants.get(0);
            return s;
        }
        return null;
    }
    
    public static Specimen get_from_cache(String id){
        Specimen m = null; //check cache
        for(Model x : cache){
            if (((Specimen)x).specimen_id.equals(id)){
                m = (Specimen)x;
                break;
            }
        }
        return m;
    }
    public static ArrayList<Specimen> getAll(){
        return DBC.executeQuery("Select * from Specimen;", new Specimen());
    }
    
    public static ArrayList<Specimen> getSpecimens(SpecimenRegion region, Plant plant){
        ArrayList<Specimen> specimens;
        if(region != null && plant != null)
            specimens = DBC.executeQuery("Select * from Specimen where "+
                    "lives_in='"+region.region_name+"' and "+
                    "plant_id='"+plant.plant_id+"'", new Specimen());
        else if(region != null)
            specimens = DBC.executeQuery("Select * from Specimen where "+
                    "lives_in='"+region.region_name+"'", new Specimen());
        else if(plant != null)
            specimens = DBC.executeQuery("Select * from Specimen where "+
                    "plant_id='"+plant.plant_id+"'", new Specimen());
        else
            specimens = DBC.executeQuery("Select * from Specimen", new Specimen());
        
        ArrayList<Plant> plants;
        for(Specimen s : specimens){
            plants = (DBC.executeQuery("Select * from Plant where plant_id=\""+s.plant_id+"\"", new Plant()));
            if(plants.size() > 0)
                s.plant = plants.get(0);
        }
        return specimens;
    }
    
    public static void add(Plant p, SpecimenRegion r, String notes, double latitude, double longitude){
        String id = "";
        for(int i = 0; i < 9; i++)
            id += (char)((int)(Math.random()*10) + '0');
        DBC.execute("insert into Specimen (plant_id, specimen_id, notes, latitude, longitude, lives_in) values (\"" + p.plant_id + "\", \""+ id + "\", \""+ notes + "\", "+ latitude + ", "+ longitude + ", \""+ r.region_name + "\")");
    }

    public int get_num_views(){
        ArrayList<Integer> a = DBC.executeAndGet("select count(*) as count from Views where specimen_id=\""+specimen_id+"\"", "count", Integer.class);
        if(a.size() == 1)
            return a.get(0);
        return 0;
    }
    public static void delete(Specimen s){
        DBC.execute("DELETE FROM Specimen WHERE specimen_id=\"" + s.specimen_id + "\""); 
    }
}
