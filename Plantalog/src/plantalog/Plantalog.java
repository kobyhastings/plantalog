
package plantalog;

/**
 * Runner Class, starts login form, initializes database
 * Start main frame when logged in
 * 
 */
public class Plantalog {
    
    public static void main(String[] args) {
        LoginForm.start();
    }

    public static void loadApplication(){
        MainFrame.start();
    }
}
