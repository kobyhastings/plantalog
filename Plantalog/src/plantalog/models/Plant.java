/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Simon
 */
public class Plant extends Model {
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
    public void fromResultSet(ResultSet r) {
        try{
            plant_id = r.getString("plant_id");
            cultivar = r.getString("cultivar");
            sci_name = r.getString("sci_name");
            com_name = r.getString("com_name");
            notes = r.getString("notes");
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
    }
}
