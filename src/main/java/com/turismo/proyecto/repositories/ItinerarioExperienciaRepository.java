package com.turismo.proyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.proyecto.models.Itinerario;
import com.turismo.proyecto.models.ItinerarioExperiencia;
import java.util.List;

public interface ItinerarioExperienciaRepository extends JpaRepository<ItinerarioExperiencia, Long> {

    // Método para buscar todas las experiencias de un itinerario específico
    List<ItinerarioExperiencia> findByItinerario(Itinerario itinerario);
}