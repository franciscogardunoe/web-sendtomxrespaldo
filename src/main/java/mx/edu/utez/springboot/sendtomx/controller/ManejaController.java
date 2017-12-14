/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.controller;

import mx.edu.utez.springboot.sendtomx.entity.Maneja;
import mx.edu.utez.springboot.sendtomx.service.CamionService;
import mx.edu.utez.springboot.sendtomx.service.ManejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mx.edu.utez.springboot.sendtomx.service.OperadorService;

/**
 *
 * @author Alumno
 */
@Controller
@RequestMapping("asignarCamion")
public class ManejaController {

    @Autowired
    private ManejaService manejaService;
    
    @Autowired
    private OperadorService operadorService;
    
    @Autowired
    private CamionService camionService;

    @GetMapping("goAsignacionCamion")
    public String goManeja(Model model) {
        model.addAttribute("manejos", manejaService.findAll());
        model.addAttribute("unOperador", operadorService.findAll());
        model.addAttribute("unCamion", camionService.findAll());
        model.addAttribute("unManeja", new Maneja());
        return "maneja";
    }

    @RequestMapping(value = "unManeja", method = RequestMethod.POST)
    public String saveManeja(Maneja maneja) {
        manejaService.saveManeja(maneja);
        return "redirect:/asignarCamion/goAsignacionCamion";
    }

    @GetMapping("findManeja/{id}")
    public String findManeja(@PathVariable Integer id, Model model) {
        model.addAttribute("editManeja", manejaService.findManejaByIdManeja(id));
        model.addAttribute("unOperador", operadorService.findAll());
        model.addAttribute("unCamion", camionService.findAll());
        return "modificarManeja";
    }

    @GetMapping("deleteManeja/{id}")
    public String deleteManeja(@PathVariable Integer id) {
        manejaService.deleteManeja(id);
        return "redirect:/asignarCamion/goAsignacionCamion";
    }
}
