package com.example.proyectoregistroh2.data;


import com.example.proyectoregistroh2.logic.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{
}