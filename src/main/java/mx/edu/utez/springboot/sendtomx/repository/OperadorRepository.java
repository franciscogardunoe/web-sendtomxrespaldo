/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.repository;

import java.io.Serializable;
import javax.transaction.Transactional;
import mx.edu.utez.springboot.sendtomx.entity.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Alumno
 */
public interface OperadorRepository extends JpaRepository<Operador, Serializable> {

    public Operador findOperadorByIdOperador(Integer idOperador);

}
