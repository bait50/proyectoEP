package com.turismo.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismo.proyecto.models.Experiencia;
import com.turismo.proyecto.repositories.ExperienciaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> obtenerTodas() {
        return experienciaRepository.findAll();
    }

    public Optional<Experiencia> obtenerPorId(Long id) {
        return experienciaRepository.findById(id);
    }

    public List<Experiencia> obtenerPorUbicacion(String ubicacion) {
        return experienciaRepository.findByUbicacion(ubicacion);
    }

    public List<Experiencia> obtenerPorCategoria(String categoria) {
        return experienciaRepository.findByCategoria(categoria);
    }

    public Experiencia crearExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public Experiencia actualizarExperiencia(Long id, Experiencia experienciaActualizada) {
        if (experienciaRepository.existsById(id)) {
            experienciaActualizada.setIdExperiencia(id);
            return experienciaRepository.save(experienciaActualizada);
        }
        return null;
    }

    public boolean eliminarExperiencia(Long id) {
        if (experienciaRepository.existsById(id)) {
            experienciaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}