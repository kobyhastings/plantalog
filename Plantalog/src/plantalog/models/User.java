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
public class User extends Model{
    
    static ArrayList<User> cache = new ArrayList();
    
    public String user_id;
    public String name;
    public String password;
    public String email;
    public Date user_since;
    public char user_type;

    @Override
    public ArrayList<User> parseResultSet(ResultSet r) {
        ArrayList<User> results = new ArrayList();
        try{
            while(r.next()){
                User m = get_from_cache(r.getString("user_id"));
                if(m == null){
                    m = new User();
                    cache.add(m);
                }
                m.email = r.getString("email");
                m.name = r.getString("name");
                m.user_id = r.getString("user_id");
                m.user_since = r.getDate("user_since");
                m.user_type = r.getString("user_type").charAt(0);
                results.add(m);
            }
        }catch(SQLException oops)
        {
            oops.printStackTrace();
        }
        return results;
    }
    
    public boolean isEmployee(){
        return user_type == 'E';
    }
    
    public static User get(String id) {
        ArrayList<User> users = DBC.executeQuery("Select * from User where user_id=\""+id+"\"", new User());
        if(users.size() > 0){
            User u = users.get(0);
            return u;
        }
        return null;
    }
    public static User get_from_cache(String id){
        User m = null; //check cache
        for(User x : cache){
            if (((User)x).user_id.equals(id)){
                m = (User)x;
                break;
            }
        }
        return m;
    }
    public static ArrayList<User> getAll(){
        return DBC.executeQuery("Select * from User;", new User());
    }
}
