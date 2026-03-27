package com.example.proyectoregistroh2.data;

import com.example.proyectoregistroh2.logic.Tipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends CrudRepository<Tipo, String> {
}
