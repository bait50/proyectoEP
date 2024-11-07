package com.turismo.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.proyecto.models.Experiencia;
import java.util.List;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
// Método personalizado para buscar experiencias por ubicación
    List<Experiencia> findByUbicacion(String ubicacion);

// Método para buscar experiencias por categoría
    List<Experiencia> findByCategoria(String categoria);
}