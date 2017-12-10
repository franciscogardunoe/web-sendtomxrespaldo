/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.controller;

import mx.edu.utez.springboot.sendtomx.entity.Camion;
import mx.edu.utez.springboot.sendtomx.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Alumno
 */
@Controller
@RequestMapping("camion")
public class CamionController {

    @Autowired
    private CamionService camionService;

    @GetMapping("goCamion")
    public String goCamiones(Model model) {
        model.addAttribute("camiones", camionService.findAll());
        model.addAttribute("unCamion", new Camion());
        return "camion";
    }

    @RequestMapping(value = "unCamion", method = RequestMethod.POST)
    public String saveCamion(Camion camion) {
        camionService.saveCamion(camion);
        return "redirect:/camion/goCamion";
    }

    @GetMapping("findCamion/{id}")
    public String findCamion(@PathVariable Integer id, Model model) {
        model.addAttribute("editCamion", camionService.getCamionById(id));
        //model.addAttribute("editCamion", new Camion());
        return "modificar";
    }

    @GetMapping("deleteCamion/{id}")
    public String deleteCamion(@PathVariable Integer id) {
        camionService.deleteCamion(id);
        return "redirect:/camion/goCamion";
    }

    @CrossOrigin
    @RequestMapping(value = "/editCamion", method = RequestMethod.PUT)
    public String editCamion(Camion camion) {
        camionService.editCamion(camion);
        return "redirect:/camion/goCamion";
    }
}
