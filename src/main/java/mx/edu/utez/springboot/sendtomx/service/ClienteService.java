/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service;

import java.util.List;
import mx.edu.utez.springboot.sendtomx.entity.Cliente;

/**
 *
 * @author Alumno
 */
public interface ClienteService {

    List<Cliente> findAll();

    void deleteCliente(Integer id);

    void saveCliente(Cliente cliente);

    Cliente getClienteById(Integer id);

    public Cliente findClienteByIdCliente(Integer idCliente);

}
