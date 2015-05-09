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
public class User extends Model {
    public String user_id;
    public String name;
    public String password;
    public String email;
    public Date user_since;
    public char user_type;

    @Override
    public void fromResultSet(ResultSet r) {
        try{
        this.email = r.getString("email");
        this.name = r.getString("name");
        this.user_id = r.getString("user_id");
        this.user_since = r.getDate("user_since");
        this.user_type = r.getString("user_type").charAt(0);
        
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
    }
}
