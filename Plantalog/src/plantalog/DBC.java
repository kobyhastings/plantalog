
package plantalog;
import java.sql.*;
import java.util.ArrayList;
import plantalog.models.Plant;
import plantalog.models.Specimen;
import plantalog.models.SpecimenRegion;
import plantalog.models.User;

/**
 * Database Connection Class
 * 
 * NOTE: connection code is from the class example.
 * 
 */
public class DBC {
    
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    
    /**
     * Begin connection to database
     * 
     * Sets up connection and statement
     */
    public static void connect(){
        
        String jdbcDriver = "com.mysql.jdbc.Driver";  //"oracle.jdbc.driver.OracleDriver";
        String jdbcUrl = "jdbc:mysql://localhost/Plantalog?username=plantalog&password=plantalogpw";  //"jdbc:oracle:thin:@//csshrpt.eku.edu:1521/cscdb";
        // URL for the database including the protocol (jdbc), the vendor 
        //(oracle), the driver (thin), the server (csshrpt.eku.edu), and 
        //the port number (1521)

        try{
            Class.forName(jdbcDriver);
            //persist the connection throughout the application
            conn = DriverManager.getConnection(jdbcUrl, "plantalog", "plantalogpw");

            // Create a statement object that will send SQL statements to DBMS
            stmt = conn.createStatement();
        }
        catch(ClassNotFoundException | SQLException oops)
        {
            oops.printStackTrace();
            disconnect();
        }
    }
    
    /**
     * Destroys the connection to the database
     * Call on exit
     */
    public static void disconnect(){
            close(rs);
            close(stmt);
            close(conn);        
    }
    
    public static User login(String username, String password){
        try
        {
            ResultSet r = stmt.executeQuery(
                "Select * from Users where name=\""+
                username+"\" and password=\""+password+"\";");
            if(r.next()){
                User u = new User();
                u.fromResultSet(r);
                return u;
            }else{
                return null;
            }
        }catch(SQLException oops)
        {
            oops.printStackTrace();
            disconnect();
            return null;
        }
    }
    
    public static ArrayList<SpecimenRegion> getRegions(String filter){
        ArrayList<SpecimenRegion> regions = new ArrayList();
        try
        {
            SpecimenRegion sr;
            ResultSet r;
            if(filter.isEmpty())
                r = stmt.executeQuery("Select * from SpecimenRegion;");
            else
                r = stmt.executeQuery("Select * from SpecimenRegion where region_name LIKE '%"+filter+"%'");                
            while(r.next()){
                sr = new SpecimenRegion();
                sr.fromResultSet(r);
                regions.add(sr);
            }
        }catch(SQLException oops)
        {
            oops.printStackTrace();
            disconnect();
            return new ArrayList();
        }
        return regions;
        
    }
    public static ArrayList<Plant> getPlants(String filter){
        ArrayList<Plant> plants = new ArrayList();
        try
        {
            Plant p;
            ResultSet r;
            if(filter.isEmpty())
                r = stmt.executeQuery("Select * from Plant;");
            else
                r = stmt.executeQuery(
                        "Select * from Plant where "+
                        "sci_name LIKE '%"+filter+"%' or "+
                        "cultivar LIKE '%"+filter+"%' or "+
                        "com_name LIKE '%"+filter+"%'");
            while(r.next()){
                p = new Plant();
                p.fromResultSet(r);
                plants.add(p);
            }
        }catch(SQLException oops)
        {
            oops.printStackTrace();
            disconnect();
            return new ArrayList();
        }
        return plants;
    }
    public static ArrayList<Specimen> getSpecimens(SpecimenRegion region, Plant plant){
        ArrayList<Specimen> specimens = new ArrayList();
        try
        {
            Specimen s;
            ResultSet r;
            if(region != null && plant != null)
                r = stmt.executeQuery("Select * from Specimen where "+
                        "lives_in='"+region.region_name+"' and "+
                        "plant_id='"+plant.plant_id+"'");
            else if(region != null)
                r = stmt.executeQuery("Select * from Specimen where "+
                        "lives_in='"+region.region_name+"'");
            else if(plant != null)
                r = stmt.executeQuery("Select * from Specimen where "+
                        "plant_id='"+plant.plant_id+"'");
            else
                r = stmt.executeQuery("Select * from Specimen");
            while(r.next()){
                s = new Specimen();
                s.fromResultSet(r);
                specimens.add(s);
            }
        }catch(SQLException oops)
        {
            oops.printStackTrace();
            disconnect();
            return new ArrayList();
        }
        for(Specimen s : specimens)
                s.plant = getPlant(s.plant_id);
        return specimens;
    }
    public static Plant getPlant(String plant_id){
        Plant p = new Plant();
        try
        {
            ResultSet r = stmt.executeQuery("Select * from Plant where plant_id=\""+plant_id+"\"");
            r.next();
            p.fromResultSet(r);
        }catch(SQLException oops)
        {
            oops.printStackTrace();
            disconnect();
            return null;
        }
        return p;
    }
    
    /**
     * Closes a database connection
     * 
     * Note: Method from class example
     * 
     * @param conn  The connection to close
     */
    static void close(Connection conn) 
    {
        if(conn != null) 
        {
            try
            {
                conn.close();
            }
            catch(Throwable whatever)
            {}
        }
    }

    /**
     * Closes a database statement object
     * 
     * Note: Method from class example
     * 
     * @param st Statement to close
     */
    static void close(Statement st)
    {
        if(st != null)
        {
            try
            {
                st.close();
            }
            catch(Throwable whatever)
            {}
        }
    }

    /**
     * Closes a result set
     * 
     * Note: Method from class example
     * 
     * @param rs  Result set to close
     */
    static void close(ResultSet rs)
    {
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(Throwable whatever)
            {}
        }
    }

    /**
     * Drops a table form the database
     * 
     * Note: Method from class example
     * 
     * @param tableName Name of the table to drop
     */
    static void dropTable(String tableName)
    {       
        ResultSet result = null;

        try
        {
            result = stmt.executeQuery("SELECT TABLE_NAME FROM USER_TABLES WHERE TABLE_NAME='" + tableName + "'");
            while (result.next())
            {
                String s = result.getString("TABLE_NAME");
                if (s.equals(tableName))
                {
                    stmt.executeUpdate("DROP TABLE " + tableName);
                    break;
                }
            }
        }
        catch(Throwable oops)
        {
            oops.printStackTrace();
            close(result);
        }
    }
}
