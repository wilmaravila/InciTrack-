/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Ruisu's
 */
public class EstadisticasController {
    
    public static float getPorcen(int total, int value){
        return ((float) value / total) * 100;
    }
    
}
