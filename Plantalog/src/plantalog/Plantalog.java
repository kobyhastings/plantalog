
package plantalog;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import plantalog.models.User;

/**
 * Runner Class, starts login form, initializes database
 * Start main frame when logged in
 * 
 */
public class Plantalog {
    
    public static MainFrame main = null;
    public static User currentUser;
    
    public static void main(String[] args) {
        DBC.connect();
        loadApplication();
    }

    public static void loadApplication(){
        MainFrame.start();
    }
    
    
    
    public static <T> DefaultListModel<T> toListModel(ArrayList<T> list){
        DefaultListModel<T> l = new DefaultListModel();
        for(T t: list)
            l.addElement(t);
        return l;
    }
    public static <T> DefaultComboBoxModel<T> toComboBoxModel(ArrayList<T> list){
        DefaultComboBoxModel<T> l = new DefaultComboBoxModel();
        for(T t: list)
            l.addElement(t);
        return l;
    }
}
