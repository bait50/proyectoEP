package com.turismo.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismo.proyecto.models.Itinerario;
import com.turismo.proyecto.models.ItinerarioExperiencia;
import com.turismo.proyecto.repositories.ItinerarioExperienciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItinerarioExperienciaService {
    @Autowired
    private ItinerarioExperienciaRepository itinerarioExperienciaRepository;

    public List<ItinerarioExperiencia> obtenerTodas() {
        return itinerarioExperienciaRepository.findAll();
    }

    public Optional<ItinerarioExperiencia> obtenerPorId(Long id) {
        return itinerarioExperienciaRepository.findById(id);
    }

    public List<ItinerarioExperiencia> obtenerPorItinerario(Itinerario itinerario) {
        return itinerarioExperienciaRepository.findByItinerario(itinerario);
    }

    public ItinerarioExperiencia agregarExperienciaAItinerario(ItinerarioExperiencia itinerarioExperiencia) {
        return itinerarioExperienciaRepository.save(itinerarioExperiencia);
    }

    public ItinerarioExperiencia actualizarItinerarioExperiencia(Long id, ItinerarioExperiencia itinerarioExperienciaActualizado) {
        if (itinerarioExperienciaRepository.existsById(id)) {
            itinerarioExperienciaActualizado.setIdItinerarioExperiencia(id);
            return itinerarioExperienciaRepository.save(itinerarioExperienciaActualizado);
        }
        return null;
    }

    public boolean eliminarItinerarioExperiencia(Long id) {
        if (itinerarioExperienciaRepository.existsById(id)) {
            itinerarioExperienciaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}