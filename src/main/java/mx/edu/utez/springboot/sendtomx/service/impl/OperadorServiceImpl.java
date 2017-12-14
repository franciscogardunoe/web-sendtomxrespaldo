/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.utez.springboot.sendtomx.entity.Operador;
import mx.edu.utez.springboot.sendtomx.repository.OperadorRepository;
import mx.edu.utez.springboot.sendtomx.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno En los servicios todavía se añade el @Service y @Transaccional
 * de javax
 */
@Service
@Transactional
public class OperadorServiceImpl implements OperadorService {

    @Autowired //Para que haga la inyección
    private OperadorRepository operadorRepository;

    @Override
    public List<Operador> findAll() {
        return operadorRepository.findAll();
    }

    @Override
    public void deleteOperador(Integer id) {
        operadorRepository.delete(id);
    }

    @Override
    public void saveOperador(Operador operador) {
        operadorRepository.save(operador);
    }

    @Override
    public Operador findOperadorByIdOperador(Integer idOperador) {
        return operadorRepository.findOperadorByIdOperador(idOperador);
    }

}
