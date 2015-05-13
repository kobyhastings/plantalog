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
public class SpecimenRegion extends Model {
    
    static ArrayList<SpecimenRegion> cache = new ArrayList();
    
    public String region_name;
    public String description;

    @Override
    public ArrayList<SpecimenRegion> parseResultSet(ResultSet r) {
        ArrayList<SpecimenRegion> results = new ArrayList();
        try{
            while(r.next()){
                SpecimenRegion m = get_from_cache(r.getString("region_name"));
                if(m == null){
                    m = new SpecimenRegion();
                    cache.add(m);
                }
                m.description = r.getString("description");
                m.region_name = r.getString("region_name");
                results.add(m);
            }
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
        return results; //return list of updated values
    }
    
    @Override
    public String toString(){
        return this.region_name;
    }
    
    public static Model get(String id) {
        ArrayList<SpecimenRegion> ps = DBC.executeQuery("Select * from SpecimenRegion where region_name=\""+id+"\"", new SpecimenRegion());
        if(ps.size() > 0){
            SpecimenRegion s = ps.get(0);
            return s;
        }
        return null;
    }
    public static SpecimenRegion get_from_cache(String id){
        SpecimenRegion m = null; //check cache
        for(Model x : cache){
            if (((SpecimenRegion)x).region_name.equals(id)){
                m = (SpecimenRegion)x;
                break;
            }
        }
        return m;
    }
    public static ArrayList<SpecimenRegion> getAll(){
        return DBC.executeQuery("Select * from SpecimenRegion;", new SpecimenRegion());
    }
    
    public static ArrayList<SpecimenRegion> getRegions(String filter){
        ArrayList<SpecimenRegion> regions;
        if(filter.isEmpty())
            regions = DBC.executeQuery("Select * from SpecimenRegion;", new SpecimenRegion());
        else
            regions = DBC.executeQuery("Select * from SpecimenRegion where region_name LIKE '%"+filter+"%'", new SpecimenRegion());
        return regions;
    }
    
    public static void add(String name, String desc){
        DBC.execute("insert into SpecimenRegion values (\"" + name + "\", \""+ desc + "\")");
    }
    
    public static void update(String oldName, String newName, String newDesc){
        DBC.execute("update SpecimenRegion set region_name = \"" + newName + "\", description = \"" + newDesc + "\" where region_name = \"" + oldName + " ");
    }
}