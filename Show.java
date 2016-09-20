/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasurehunt;

/**
 *
 * @author Christopher
 */
public class Show {
    UserFace gui;
    
    public Show(UserFace userFace){
        gui = userFace;
    }
    
    
    public void show(String text){
        System.out.println(text);
        gui.addText(text);
    }
}
