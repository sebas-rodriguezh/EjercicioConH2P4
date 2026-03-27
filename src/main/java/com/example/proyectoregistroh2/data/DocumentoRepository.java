package com.example.proyectoregistroh2.data;

import com.example.proyectoregistroh2.logic.Documento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends CrudRepository<Documento, String> {
    List<Documento> findByTipoId(String tipoId);
}
