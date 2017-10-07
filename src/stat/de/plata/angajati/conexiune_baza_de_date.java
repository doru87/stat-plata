/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stat.de.plata.angajati;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */

public class conexiune_baza_de_date {
    
    
    static Connection conexiune;
    public static Connection baza_de_date(){
        
        try{
            Class.forName("org.sqlite.JDBC");
            conexiune =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\pc\\Documents\\NetBeansProjects\\Stat de Plata Angajati\\baza_de_date.sqlite");
            //JOptionPane.showMessageDialog(null, "Connection to database is successful");
      
            return conexiune;
           
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}
