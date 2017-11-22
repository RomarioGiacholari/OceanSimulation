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
public interface Creature{
    
 public abstract void act(Field field);
 public abstract boolean isAlive();
 public abstract void setLocation(int row, int column);
    
}
