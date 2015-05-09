/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

import java.sql.ResultSet;

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
    public String when_added;
    public String lives_in;

    @Override
    public void fromResultSet(ResultSet r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
