package com.turismo.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.proyecto.models.Itinerario;
import com.turismo.proyecto.models.Usuario;
import java.util.List;

public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {
// Método para buscar itinerarios por usuario
    List<Itinerario> findByUsuario(Usuario usuario);
}