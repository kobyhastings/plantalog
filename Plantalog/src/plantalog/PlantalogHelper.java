/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantalog;

/**
 *
 * @author kobyhastings
 */
public class PlantalogHelper {
    
    public static String generateRandomId() {
        String id = "";
        for(int i = 0; i < 9; i++)
            id += (char)((int)(Math.random()*10) + '0');
        return id;
    }
    
}
