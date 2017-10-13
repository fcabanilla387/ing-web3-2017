/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Cancion;
import java.util.ArrayList;

/**
 *
 * @author matia
 */
public class CalcularCancionService {
    private ArrayList<Cancion> canciones;
    
    public CalcularCancionService(ArrayList<Cancion> canciones){
        this.canciones = canciones;
    }            
    
    
    public Cancion CancionMejorPuntuada(){
        float rep = 0;
        Cancion cc = new Cancion();
        for(Cancion c : canciones){
            if(c.getRating()> rep){
                cc = c;
            }
        }
        return cc;
    }
    
    public Cancion CancionMasReproducida(){
        float cant = 0;
        Cancion cc = new Cancion();
        for(Cancion c : canciones){
            if(c.getReproducciones() > cant){
                cc = c;
            }
        }
        return cc;
    }
}
