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
public class SpecimenRegion extends Model {
    public String region_name;
    public String description;

    @Override
    public void fromResultSet(ResultSet r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
