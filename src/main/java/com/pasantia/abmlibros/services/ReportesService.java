package com.pasantia.abmlibros.services;

import com.pasantia.abmlibros.entities.Autor;
import com.pasantia.abmlibros.entities.Libro;
import com.pasantia.abmlibros.repositories.AutoresRepository;
import com.pasantia.abmlibros.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.Collection;

@Service
@ApplicationScope
public class ReportesService {

    @Autowired
    private AutoresRepository autoresRepo;

    @Autowired
    private LibrosRepository librosRepo;

    // Reportes

    public Collection<Libro> buscarTodosOrdenadosPorTitulo(){ return librosRepo.getAllByOrderByTitulo();}

    public int contarLibrosDeAutor(int id){ return librosRepo.countLibrosByIdAutor(id);}

    public Collection<Libro> buscarPorTitulo(String titulo){ return librosRepo.getAllByTituloContainingIgnoreCase(titulo);}

    public Collection<Libro> buscarPorNombreAutor(String nom){

        Autor autor = autoresRepo.getAutorByNombre(nom);
        if (autor != null){
            return new ArrayList<>();
        }
        else{
            return librosRepo.getAllByIdAutor(autor.getId());
        }

    }

}
