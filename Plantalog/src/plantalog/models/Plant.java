/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog.models;

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

    @Override
    public String toString(){
        return "Plant(" + plant_id + ", " + sci_name + ", " + cultivar + ")";
    }    
}
