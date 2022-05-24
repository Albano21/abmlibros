package com.pasantia.abmlibros.repositories;

import com.pasantia.abmlibros.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutoresRepository extends JpaRepository<Autor, Integer> {

    Autor getAutorByNombreContainingIgnoreCase(String nombre);
}
