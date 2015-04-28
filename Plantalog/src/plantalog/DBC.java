
package plantalog;
import java.sql.*;

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
    public static void connect(String username, String password){
        
        String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
        String jdbcUrl = "jdbc:oracle:thin:@//csshrpt.eku.edu:1521/cscdb";  
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
        catch(Throwable oops)
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
    
    public static boolean login(String username, String password){
        try
        {
            //login to database
            return true; // if successful
            //return false if not

        }catch(Throwable oops)
        {
            oops.printStackTrace();
            disconnect();
            return false;
        }
    }
    
    public static String[] search(String query){
        // query db for stuff, return results
        String[] strings = {"hi", "people", query};
        return strings;
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
