package com.upn.santafeback.model.repository;

import com.upn.santafeback.model.Receta;
import com.upn.santafeback.model.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    List<Tratamiento> findTratamientoByIdReceta(Receta receta);
}
