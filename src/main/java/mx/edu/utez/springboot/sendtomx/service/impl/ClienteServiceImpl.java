/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.utez.springboot.sendtomx.entity.Cliente;
import mx.edu.utez.springboot.sendtomx.repository.ClienteRepository;
import mx.edu.utez.springboot.sendtomx.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno En los servicios todavía se añade el @Service y @Transaccional
 * de javax
 */
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired //Para que haga la inyección
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteRepository.delete(id);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteById(Integer id) {
        return clienteRepository.findOne(id);
    }

    @Override
    public Cliente findClienteByIdCliente(Integer idCliente) {
        return clienteRepository.findClienteByIdCliente(idCliente);
    }

}
