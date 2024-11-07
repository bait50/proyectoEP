package com.turismo.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.proyecto.models.Itinerario;
import com.turismo.proyecto.models.ItinerarioExperiencia;
import com.turismo.proyecto.services.ItinerarioExperienciaService;
import com.turismo.proyecto.services.ItinerarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/itinerarios/experiencias")
public class ItinerarioExperienciaController {
    @Autowired
    private ItinerarioExperienciaService itinerarioExperienciaService;

    @Autowired
    private ItinerarioService itinerarioService;

    @GetMapping
    public ResponseEntity<List<ItinerarioExperiencia>> obtenerTodas() {
        List<ItinerarioExperiencia> itinerarioExperiencias = itinerarioExperienciaService.obtenerTodas();
        return new ResponseEntity<>(itinerarioExperiencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItinerarioExperiencia> obtenerPorId(@PathVariable Long id) {
        Optional<ItinerarioExperiencia> itinerarioExperiencia = itinerarioExperienciaService.obtenerPorId(id);
        return itinerarioExperiencia.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/itinerario/{itinerarioId}")
    public ResponseEntity<List<ItinerarioExperiencia>> obtenerPorItinerario(@PathVariable Long itinerarioId) {
        Optional<Itinerario> itinerario = itinerarioService.obtenerPorId(itinerarioId);
        if (itinerario.isPresent()) {
            List<ItinerarioExperiencia> itinerarioExperiencias = itinerarioExperienciaService.obtenerPorItinerario(itinerario.get());
            return new ResponseEntity<>(itinerarioExperiencias, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ItinerarioExperiencia> agregarExperienciaAItinerario(@RequestBody ItinerarioExperiencia itinerarioExperiencia) {
        ItinerarioExperiencia nuevaItinerarioExperiencia = itinerarioExperienciaService.agregarExperienciaAItinerario(itinerarioExperiencia);
        return new ResponseEntity<>(nuevaItinerarioExperiencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItinerarioExperiencia> actualizarItinerarioExperiencia(@PathVariable Long id, @RequestBody ItinerarioExperiencia itinerarioExperiencia) {
        ItinerarioExperiencia itinerarioExperienciaActualizada = itinerarioExperienciaService.actualizarItinerarioExperiencia(id, itinerarioExperiencia);
        if (itinerarioExperienciaActualizada != null) {
            return new ResponseEntity<>(itinerarioExperienciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItinerarioExperiencia(@PathVariable Long id) {
        if (itinerarioExperienciaService.eliminarItinerarioExperiencia(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

