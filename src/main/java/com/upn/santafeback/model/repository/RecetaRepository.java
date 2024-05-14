package com.upn.santafeback.model.repository;

import com.upn.santafeback.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {

    @Query(value = "select r.* from recetas r inner join usuarios u on u.id = r.id_usuario where u.dni = ?1", nativeQuery = true)
    List<Receta> findByDniUsuario(String idUsuario);
}
