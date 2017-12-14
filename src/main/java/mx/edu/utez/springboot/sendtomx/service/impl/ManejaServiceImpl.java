/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import mx.edu.utez.springboot.sendtomx.entity.Maneja;
import mx.edu.utez.springboot.sendtomx.repository.ManejaRepository;
import mx.edu.utez.springboot.sendtomx.service.ManejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno En los servicios todavía se añade el @Service y @Transaccional
 * de javax
 */
@Service
@Transactional
public class ManejaServiceImpl implements ManejaService {

    @Autowired //Para que haga la inyección
    private ManejaRepository manejaRepository;

    @Override
    public List<Maneja> findAll() {
        return manejaRepository.findAll();
    }

    @Override
    public void deleteManeja(Integer id) {
        manejaRepository.delete(id);
    }

    @Override
    public void saveManeja(Maneja maneja) {
        manejaRepository.save(maneja);
    }

    @Override
    public Maneja findManejaByIdManeja(Integer idManeja) {
        return manejaRepository.findManejaByIdManeja(idManeja);
    }

}
