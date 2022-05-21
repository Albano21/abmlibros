package com.pasantia.abmlibros.controllers;

import com.pasantia.abmlibros.entities.Libro;
import com.pasantia.abmlibros.services.AutoresService;
import com.pasantia.abmlibros.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/libro")
public class LibrosController {

    @Autowired
    private LibrosService librosService;
    @Autowired
    private AutoresService autoresService;

    //agregar un libro
    @PutMapping("/{id}")
    public ResponseEntity guardar(@RequestBody Libro nuevo){

        // verifica que el objeto y el titulo no sean null y que el id de autor cargado exista
        if(nuevo != null && nuevo.getTitulo() != null && autoresService.buscarPorId(nuevo.getIdAutor()) != null){
            librosService.guardar(nuevo);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity("Datos invalidos", HttpStatus.BAD_REQUEST);
        }
    }

    //borrar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity borrar(@PathVariable int id){
        if (librosService.buscarPorId(id) != null) {
            librosService.borrar(id);
            return ResponseEntity.ok().build();
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //buscar todas
    @GetMapping("/")
    public Collection<Libro> consultarTodas(){return librosService.buscarTodos();}

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable int id){
        Libro libro = librosService.buscarPorId(id);
        if (libro != null){
            return ResponseEntity.ok(libro);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
