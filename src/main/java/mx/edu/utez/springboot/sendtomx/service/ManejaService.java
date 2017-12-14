/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.service;

import java.util.List;
import mx.edu.utez.springboot.sendtomx.entity.Maneja;

/**
 *
 * @author Alumno
 */
public interface ManejaService {

    List<Maneja> findAll();

    void deleteManeja(Integer id);

    void saveManeja(Maneja maneja);

    public Maneja findManejaByIdManeja(Integer idManeja);

}
