/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.utez.springboot.sendtomx.entity.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.edu.utez.springboot.sendtomx.service.MunicipioService;
import mx.edu.utez.springboot.sendtomx.repository.MunicipioRepository;

/**
 *
 * @author Alumno En los servicios todavía se añade el @Service y @Transaccional
 * de javax
 */
@Service
@Transactional
public class MunicipioServiceImpl implements MunicipioService {

    @Autowired //Para que haga la inyección
    private MunicipioRepository municipioRepository;

    @Override
    public List<Municipio> findAll() {
        return municipioRepository.findAll();
    }

}
