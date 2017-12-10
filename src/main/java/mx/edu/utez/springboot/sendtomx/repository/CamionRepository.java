/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.springboot.sendtomx.repository;

import java.io.Serializable;
import javax.transaction.Transactional;
import mx.edu.utez.springboot.sendtomx.entity.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Alumno
 */
public interface CamionRepository extends JpaRepository<Camion, Serializable> {

    public Camion findCamionByIdCamion(Integer idCamion);

    @Transactional
    @Modifying
    @Query("UPDATE Camion SET numeroCarro = :numeroCarro, numeroPlacas = :numeroPlacas, capacidad = :capacidad WHERE idCamion = :idCamion")
    int updateCamion(@Param("numeroCarro") int numeroCarro, @Param("numeroPlacas") String numeroPlacas, @Param("capacidad") double capacidad, @Param("idCamion") int idCamion);
    //EJEMPLO public List<Camion> findCamionByNumeroPlacasOrCapacidad(int numeroPlacas, int capacidad);
}
