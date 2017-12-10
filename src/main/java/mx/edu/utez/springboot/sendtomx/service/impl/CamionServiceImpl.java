/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.utez.springboot.sendtomx.entity.Camion;
import mx.edu.utez.springboot.sendtomx.repository.CamionRepository;
import mx.edu.utez.springboot.sendtomx.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno En los servicios todavía se añade el @Service y @Transaccional
 * de javax
 */
@Service
@Transactional
public class CamionServiceImpl implements CamionService {

    @Autowired //Para que haga la inyección
    private CamionRepository camionRepository;

    @Override
    public List<Camion> findAll() {
        return camionRepository.findAll();
    }

    @Override
    public void deleteCamion(Integer id) {
        camionRepository.delete(id);
    }

    @Override
    public void saveCamion(Camion camion) {
        camionRepository.save(camion);
    }

    @Override
    public Camion getCamionById(Integer id) {
        return camionRepository.findOne(id);
    }

    @Override
    public Camion findCamionByIdCamion(Integer idCamion) {
        return camionRepository.findCamionByIdCamion(idCamion);
    }

    @Override
    public void editCamion(Camion camion) {
        System.out.println(camion.getNumeroCarro() + "" + camion.getNumeroPlacas() + "" + camion.getCapacidad() + "" + camion.getIdCamion());
        System.out.println("objeto"+camion.getIdCamion());
        
        
        //camionRepository.updateCamion(camion.getNumeroCarro(), camion.getNumeroPlacas(), camion.getCapacidad(), camion.getIdCamion());
    }

}
