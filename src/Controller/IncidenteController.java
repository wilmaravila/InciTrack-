/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.DAO.IncidenteDao;
import Models.Incidente;
import Models.Persona;
import Models.Usuario;
import java.util.List;

/**
 *
 * @author Ruisu's
 */
public class IncidenteController {
    
    private IncidenteDao incidenteDao;
    
    public IncidenteController(){
    incidenteDao = new IncidenteDao();
}
    
    public List<Incidente> getIncidentes(){
        return incidenteDao.getIncidentes();
    }
    
    public void addIncident(Incidente incidente){
        incidenteDao.crearIncidente(incidente);
    }
    
    public List<Incidente> getIncidenteByType(String type){
        return incidenteDao.getIncidentesByType(type);
    }
    
    public List<Incidente> getIncidenteByDate(int date){
        return incidenteDao.getIncidentesByDate(date);
    }
}
