package com.turismo.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismo.proyecto.models.Itinerario;
import com.turismo.proyecto.models.Usuario;
import com.turismo.proyecto.repositories.ItinerarioRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ItinerarioService {
    @Autowired
    private ItinerarioRepository itinerarioRepository;

    public List<Itinerario> obtenerTodos() {
        return itinerarioRepository.findAll();
    }

    public Optional<Itinerario> obtenerPorId(Long id) {
        return itinerarioRepository.findById(id);
    }

    public List<Itinerario> obtenerPorUsuario(Usuario usuario) {
        return itinerarioRepository.findByUsuario(usuario);
    }

    public Itinerario crearItinerario(Itinerario itinerario) {
        return itinerarioRepository.save(itinerario);
    }

    public Itinerario actualizarItinerario(Long id, Itinerario itinerarioActualizado) {
        if (itinerarioRepository.existsById(id)) {
            itinerarioActualizado.setIdItinerario(id);
            return itinerarioRepository.save(itinerarioActualizado);
        }
        return null;
    }

    public boolean eliminarItinerario(Long id) {
        if (itinerarioRepository.existsById(id)) {
            itinerarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}