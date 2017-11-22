/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OceanSim_stub;

import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author giacholr
 */
public class Simulator {
            
        public Field field;
        public SimulatorView view;
        public ArrayList<Creature> actors;
        public ArrayList<Creature> newActors;
        
        public RandomGenerator random;
        public int currentStep = 0;
        
        public Simulator(int height, int width)
        {
            actors = new ArrayList<Creature>();
            newActors = new ArrayList<Creature>();
            random = new RandomGenerator();
            if(height <= 0){
                height = ModelConstants.DEFAULT_DEPTH;
            }else if(width <= 0){
                width = ModelConstants.DEFAULT_WIDTH;
            }
            
            field = new Field(height,width);
            view = new SimulatorView(height,width);
            this.populate();
            
            
            
        }
        
        public void simulate(int steps)
        {
            for(int i = 0; i<= steps && view.isViable(field); i++ ){
                
                this.simulateOneStep();
            }
        }
        
        public void simulateOneStep()
        {
            this.currentStep ++;
            Collections.shuffle(actors, random.getRandom());
            for(Creature actor: actors){
                if(actor.isAlive()){
                    actor.act(field); 
                    this.view.showStatus(currentStep,field);
                }
            }
            //view.showStatus(currentStep, field);
        }
        
        public void populate(){
            double possibleShark = ModelConstants.SHARK_P;
            double possibleSardine = ModelConstants.SARDINE_P;
            double possiblePlankton = ModelConstants.PLANKTON_P;
            
            Random random = new Random();
            
            int width = field.getWidth();
            int height = field.getDepth();
            
            for(int i= 0; i< width; i++){
                for(int y=0; y< height; y++){
                    
                    double p = random.nextDouble();
                    
                    if(p <= possibleShark){
                        Shark shark = new Shark();
                        shark.setLocation(i, y);
                        view.setColor(Shark.class,new Color(0,191,255));
                        field.place(shark,i,y);
                        newActors.add(shark);
                        
                    }else if(p > possibleSardine && p <= possiblePlankton){
                        Plankton plankton = new Plankton();
                        view.setColor(Plankton.class, new Color(255,50,50));
                        field.place(plankton, i,y);
                        plankton.setLocation(i, y);
                        newActors.add(plankton);
                        
                    }else if(p > possibleShark && p <= possibleSardine){
                        Sardine sardine = new Sardine();
                        view.setColor(Sardine.class,new Color(255,255,55));
                        field.place(sardine,i,y);
                        sardine.setLocation(i,y);
                        newActors.add(sardine);
                    }
                     actors.addAll(newActors);
                     view.showStatus(0, field); 
                }

            }
            
        }
       
    }
        
