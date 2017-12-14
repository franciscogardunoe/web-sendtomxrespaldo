/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.controller;

import mx.edu.utez.springboot.sendtomx.entity.Operador;
import mx.edu.utez.springboot.sendtomx.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mx.edu.utez.springboot.sendtomx.service.MunicipioService;

/**
 *
 * @author Alumno
 */
@Controller
@RequestMapping("operador")
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @Autowired
    private MunicipioService municipioService;

    @GetMapping("goOperador")
    public String goOperador(Model model) {
        model.addAttribute("operadores", operadorService.findAll());
        model.addAttribute("unMunicipio", municipioService.findAll());
        model.addAttribute("unOperador", new Operador());
        return "operador";
    }

    @RequestMapping(value = "unOperador", method = RequestMethod.POST)
    public String saveOperador(Operador operador) {
        operadorService.saveOperador(operador);
        return "redirect:/operador/goOperador";
    }

    @GetMapping("findOperador/{id}")
    public String findOperador(@PathVariable Integer id, Model model) {
        model.addAttribute("editOperador", operadorService.findOperadorByIdOperador(id));
        model.addAttribute("unMunicipio", municipioService.findAll());
        return "modificarOperador";
    }

    @GetMapping("deleteOperador/{id}")
    public String deleteOperador(@PathVariable Integer id) {
        operadorService.deleteOperador(id);
        return "redirect:/operador/goOperador";
    }
}
