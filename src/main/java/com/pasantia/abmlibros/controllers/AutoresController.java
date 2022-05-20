package com.pasantia.abmlibros.controllers;


import com.pasantia.abmlibros.entities.Autor;
import com.pasantia.abmlibros.services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/autor")
public class AutoresController {

    @Autowired
    private AutoresService autoresService;

    //agregar un autor
    @PutMapping("/{id}")
    public ResponseEntity guardar(@RequestBody Autor nuevo){

        if(nuevo != null){
            autoresService.guardar(nuevo);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity("Datos invalidos", HttpStatus.BAD_REQUEST);
        }
    }

    //borrar un autor
    @DeleteMapping("/{id}")
    public ResponseEntity borrar(@PathVariable int id){
        if (autoresService.buscarPorId(id) != null) {
            autoresService.borrar(id);
            return ResponseEntity.ok().build();
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //buscar todas
    @GetMapping("/")
    public Collection<Autor> consultarTodas(){return autoresService.buscarTodos();}

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable int id){
        Autor autor = autoresService.buscarPorId(id);
        if (autor != null){
            return ResponseEntity.ok(autor);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
