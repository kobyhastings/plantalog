/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantalog;

/**
 *
 * @author Simon
 */
public class DBC {
    
    public static void connect(){
        //connect to database
    }
    
    public static boolean login(String username, String password){
        //login to database
        return true; // if successful
    }
    
    public static String[] search(String query){
        String[] strings = {"hi", "people", query};
        return strings;
    }
    
}
