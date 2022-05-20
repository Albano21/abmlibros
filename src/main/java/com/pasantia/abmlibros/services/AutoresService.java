package com.pasantia.abmlibros.services;

import com.pasantia.abmlibros.entities.Autor;
import com.pasantia.abmlibros.repositories.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Collection;

@Service
@ApplicationScope
public class AutoresService {

    @Autowired
    private AutoresRepository repo;

    // ABM Autores

    public void guardar(Autor nuevo){ repo.save(nuevo);}

    public void borrar(int id){ repo.deleteById(id);}

    public Collection<Autor> buscarTodos(){ return repo.findAll();}

    public Autor buscarPorId(int id){ return repo.findById(id).orElse(null);}

}
