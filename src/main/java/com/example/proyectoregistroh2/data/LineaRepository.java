package com.example.proyectoregistroh2.data;

import com.example.proyectoregistroh2.logic.Linea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LineaRepository extends CrudRepository<Linea, Integer> {
    List<Linea> findByUsuarioId(String usuarioId);
    Optional<Linea> findByUsuarioIdAndDocumentoId(String usuarioId, String documentoId);
}

