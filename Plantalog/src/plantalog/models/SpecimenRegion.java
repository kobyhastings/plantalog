/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Simon
 */
public class SpecimenRegion extends Model {
    public String region_name;
    public String description;

    @Override
    public void fromResultSet(ResultSet r) {
        
        try{
            this.description = r.getString("description");
            this.region_name = r.getString("region_name");
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        return this.region_name;
    }
}
