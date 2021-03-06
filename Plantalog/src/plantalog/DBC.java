
package plantalog;
import java.sql.*;
import java.util.ArrayList;
import plantalog.models.Model;
import plantalog.models.Specimen;
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
        String hostname, username, password, database, jdbcDriver, protocol, jdbcUrl;
        if(true){//use mysql
            hostname = "107.170.143.74";
            username = "plantalog";
            password = "plantalog123!";
            database = "plantalog";
            jdbcDriver = "com.mysql.jdbc.Driver";
            protocol = "jdbc:mysql:";
            jdbcUrl = protocol + "//"+hostname+"/"+database+"?username="+username+"&password="+password;  
        }else{//use oracle
            username = "mikulcik2015";
            password = "8213";
            jdbcDriver = "oracle.jdbc.driver.OracleDriver";
            jdbcUrl = "jdbc:oracle:thin:@//csshrpt.eku.edu:1521/cscdb";
        }

        try{
            Class.forName(jdbcDriver);
            //persist the connection throughout the application
            conn = DriverManager.getConnection(jdbcUrl, username, password);

            // Create a statement object that will send SQL statements to DBMS
            stmt = conn.createStatement();
        }
        catch(ClassNotFoundException | SQLException oops)
        {
            oops.printStackTrace();
            disconnect();
        }
    }
    
    public static void execute(String query, String ... params){
        PreparedStatement s = null;
        try {
            s = conn.prepareStatement(query);
            for(int i=1; i <= params.length; i++)
                s.setString(i, params[i-1]);
            s.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if(s != null)close(s);
        }
    }
    public static <T extends Model> ArrayList<T> executeQuery(String query, T modelclass, String ... params){
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            s = conn.prepareStatement(query);
            for(int i=1; i <= params.length; i++)
                s.setString(i, params[i-1]);
            r = s.executeQuery();
            return modelclass.parseResultSet(r);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if(s != null)close(s);
            if(r != null)close(r);
        }
        return new ArrayList();
    }
    
    public static <T> ArrayList<T> executeAndGet(String query, String field, Class<T> type){
        //System.out.println("executing "+ query);
        Statement s = null;
        ResultSet r = null;
        ArrayList<T> results = new ArrayList();
        try {
            s = conn.createStatement();
            r = s.executeQuery(query);
            
            while(r.next()){
                T val = r.getObject(field, type);
                results.add(val);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if(s != null)close(s);
            if(r != null)close(r);
        }
        return results;
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
    
    public static void view(Specimen s, User u){
        execute("insert into Views (user_id, specimen_id) values('"+u.user_id +"', '"+s.specimen_id+"');");
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
}
