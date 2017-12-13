/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.controller;

import mx.edu.utez.springboot.sendtomx.entity.Cliente;
import mx.edu.utez.springboot.sendtomx.service.ClienteService;
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
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MunicipioService municipioService;

    @GetMapping("goCliente")
    public String goClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("unMunicipio", municipioService.findAll());
        model.addAttribute("unCliente", new Cliente());
        return "cliente";
    }

    @RequestMapping(value = "unCliente", method = RequestMethod.POST)
    public String saveCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente/goCliente";
    }

    @GetMapping("findCliente/{id}")
    public String findCliente(@PathVariable Integer id, Model model) {
        model.addAttribute("editCliente", clienteService.getClienteById(id));
        model.addAttribute("unMunicipio", municipioService.findAll());
        return "modificarCliente";
    }

    @GetMapping("deleteCliente/{id}")
    public String deleteCliente(@PathVariable Integer id) {
        clienteService.deleteCliente(id);
        return "redirect:/cliente/goCliente";
    }
}
