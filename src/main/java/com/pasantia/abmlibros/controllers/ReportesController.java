package com.pasantia.abmlibros.controllers;

import com.pasantia.abmlibros.entities.Libro;
import com.pasantia.abmlibros.services.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

    //Listado de todos los libros ordenados por titulo
    @GetMapping("/ordenados")
    public Collection<Libro> consultarOrdenados(){ return reportesService.buscarTodosOrdenadosPorTitulo(); }

    //Cantidad de libros de un autor indicado por id
    @GetMapping("/cantidad/{id}")
    public int contarLibrosDeAutor(@PathVariable int id){
        return reportesService.contarLibrosDeAutor(id);
    }

    //Listado de todos los libros buscando por titulo
    @GetMapping("/titulo")
    public Collection<Libro> consultarPorTitulo(@RequestParam(required = false) String tit){
        return reportesService.buscarPorTitulo(tit);
    }

    //Listado de todos los libros de un autor buscado por nombre
    @GetMapping("/autor")
    public Collection<Libro> consultarLibrosPorNombreAutor(@RequestParam(required = false) String nom){
        return reportesService.buscarPorNombreAutor(nom);
    }
}
