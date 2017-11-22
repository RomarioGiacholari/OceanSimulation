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
public class Plankton implements Creature{
    
    protected boolean alive = true;
    private Location location;
    
    public Plankton(){
        
    }
    
    public void act(Field field)
    {
        
    }
    
    public void setLocation(int row, int column)
    {
        this.location = new Location(row,column);
    }
    
    public boolean isAlive()
    {
        return true;
    }
    
}
