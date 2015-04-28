
package plantalog;

public class DBC {
    
    public static void connect(){
        //connect to database
    }
    
    public static boolean login(String username, String password){
        //login to database
        return true; // if successful
        //return false if not
    }
    
    public static String[] search(String query){
        // query db for stuff, return results
        String[] strings = {"hi", "people", query};
        return strings;
    }
    
}
