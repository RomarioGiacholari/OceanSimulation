/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OceanSim_stub;

/**
 *
 * @author giacholr
 */
public class Shark extends Fish{

    
    public Shark(){
        
    }
    
    public void act(Field field)
    {
           Location location = field.freeAdjacentLocation(getLocation());
           
           if( location != null)
           {
               field.clear();
               setLocation(location);
               field.place(this, location);
               
           }else
           {
               setDead();
           }
    }
}
