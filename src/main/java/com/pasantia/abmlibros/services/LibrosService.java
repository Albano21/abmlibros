package com.pasantia.abmlibros.services;

import com.pasantia.abmlibros.entities.Autor;
import com.pasantia.abmlibros.entities.Libro;
import com.pasantia.abmlibros.repositories.AutoresRepository;
import com.pasantia.abmlibros.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Collection;

@Service
@ApplicationScope
public class LibrosService {

    @Autowired
    private LibrosRepository repo;

    // ABM Libros

    public void guardar(Libro nuevo) { repo.save(nuevo);}

    public void borrar(int id) { repo.deleteById(id);}

    public Collection<Libro> buscarTodos() { return repo.findAll();}

    public Libro buscarPorId(int id) { return repo.findById(id).orElse(null);}

}
