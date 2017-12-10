/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.controller.rest;

import java.util.List;
import mx.edu.utez.springboot.sendtomx.entity.Camion;
import mx.edu.utez.springboot.sendtomx.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alumno
 */
//@RestController permite retornar un JSON, crear un servicio resfull
//Permite retornar cualquier cosa y pintarla en el navegador
//@Controller, solo retorna el nombre de la vista .html
@RestController
@RequestMapping("camiones")
public class CamionRestController {

    @Autowired
    private CamionService camionService;

    @GetMapping
    public List<Camion> getAll() {
        return camionService.findAll();
    }

    @GetMapping("{id}")
    public Camion getCamionById(@PathVariable("id") Integer idCamion) {
        return camionService.findCamionByIdCamion(idCamion);
    }
    
    @PostMapping
    public Camion save(@RequestBody Camion camion){
        camionService.saveCamion(camion);
        return camion;
    }
}
