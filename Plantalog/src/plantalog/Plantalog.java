
package plantalog;

public class Plantalog {
    
    public static void main(String[] args) {
        DBC.connect();
        LoginForm.start();
    }

    public static void loadApplication(){
        MainFrame.start();
    }
}
