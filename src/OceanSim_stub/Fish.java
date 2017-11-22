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
public abstract class Fish implements Creature{
        
    protected boolean alive = true;
    protected Location location;
    
    public Fish(){
    
    }
    
    public boolean isAlive()
    {
        return this.alive;
    }
    
    public void setDead()
    {
        this.alive = false;
    }
    
    public void setLocation(int row, int column)
    {
        this.location = new Location(row,column);
    }
    
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    public Location getLocation()
    {
        return this.location;
    }
}
