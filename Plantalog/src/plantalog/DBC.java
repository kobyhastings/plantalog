
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
        
        String hostname = "107.170.143.74";
        String username = "plantalog";
        String password = "plantalog123!";
        String database = "plantalog";
        
        String jdbcDriver = "com.mysql.jdbc.Driver";  //"oracle.jdbc.driver.OracleDriver";
        String jdbcUrl = "jdbc:mysql://"+hostname+"/"+database+"?username="+username+"&password="+password;  //"jdbc:oracle:thin:@//csshrpt.eku.edu:1521/cscdb";
        // URL for the database including the protocol (jdbc), the vendor 
        //(oracle), the driver (thin), the server (csshrpt.eku.edu), and 
        //the port number (1521)

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
    
    public static void execute(String query){
        System.out.println("executing "+ query);
        Statement s = null;
        try {
            s = conn.createStatement();
            s.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if(s != null)close(s);
        }
    }
    public static <T extends Model> ArrayList<T> executeQuery(String query, T modelclass){
        //System.out.println("executing "+ query);
        Statement s = null;
        ResultSet r = null;
        try {
            s = conn.createStatement();
            r = s.executeQuery(query);
            return modelclass.parseResultSet(r);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if(s != null)close(s);
            if(r != null)close(r);
        }
        return new ArrayList();
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
