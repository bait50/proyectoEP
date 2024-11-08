package com.turismo.proyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turismo.proyecto.models.Itinerario;
import com.turismo.proyecto.models.ItinerarioExperiencia;
import com.turismo.proyecto.models.Reserva;
import com.turismo.proyecto.models.Usuario;

import java.util.List;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {
// Método para buscar todas las experiencias de un itinerario específico
    List<ItinerarioExperiencia> findByItinerario(Itinerario itinerario);

// Método para buscar todas las reservas de un usuario específico
    //@EntityGraph(attributePaths = {"usuario"})
    List<Reserva> findByUsuario(Usuario usuario);

// Método para buscar todas las reservas por estado
    @Query("SELECT r FROM Reserva r WHERE r.estado = :estado")
    List<Reserva> findByEstado(@Param("estado") String estado);
}