
package plantalog;

import plantalog.models.User;

/**
 * Runner Class, starts login form, initializes database
 * Start main frame when logged in
 * 
 */
public class Plantalog {
    
    public static User currentUser;
    
    public static void main(String[] args) {
        DBC.connect();
        loadApplication();
    }

    public static void loadApplication(){
        MainFrame.start();
    }
}
