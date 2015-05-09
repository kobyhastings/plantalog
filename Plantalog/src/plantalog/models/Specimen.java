/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Simon
 */
public class Specimen extends Model {
    public String plant_id;
    public String specimen_id;
    public String notes;
    public double latitude;
    public double longitude;
    public Date when_added;
    public String lives_in;
    
    public Plant plant;

    @Override
    public void fromResultSet(ResultSet r) {
        
        
        try{
            this.plant_id = r.getString("plant_id");
            this.specimen_id = r.getString("specimen_id");
            this.notes = r.getString("notes");
            this.latitude = r.getFloat("latitude");
            this.longitude = r.getFloat("longitude");
            this.when_added = r.getDate("when_added");
            this.lives_in = r.getString("lives_in");
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        if(plant != null)
            return plant.sci_name + "'"+plant.cultivar+"' " + lives_in;
        else
            return lives_in;
    }
}
