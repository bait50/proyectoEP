package com.turismo.proyecto.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.proyecto.models.Itinerario;
import com.turismo.proyecto.models.ItinerarioExperiencia;
import com.turismo.proyecto.models.Reserva;

import java.util.List;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {
// Método para buscar todas las experiencias de un itinerario específico
    List<ItinerarioExperiencia> findByItinerario(Itinerario itinerario);

    @EntityGraph(attributePaths = {"usuario"})
    List<Reserva> findAll();
}