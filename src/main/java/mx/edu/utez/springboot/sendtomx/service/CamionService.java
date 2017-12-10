/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service;

import java.util.List;
import mx.edu.utez.springboot.sendtomx.entity.Camion;

/**
 *
 * @author Alumno
 */
public interface CamionService {

    List<Camion> findAll();

    void deleteCamion(Integer id);

    void saveCamion(Camion camion);

    Camion getCamionById(Integer id);
    
    void editCamion(Camion camion);

    public Camion findCamionByIdCamion(Integer idCamion);

}
