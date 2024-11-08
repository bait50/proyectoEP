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

import com.turismo.proyecto.models.Experiencia;
import com.turismo.proyecto.services.ExperienciaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping
    public ResponseEntity<List<Experiencia>> obtenerTodas() {
        List<Experiencia> experiencias = experienciaService.obtenerTodas();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> obtenerPorId(@PathVariable Long id) {
        Optional<Experiencia> experiencia = experienciaService.obtenerPorId(id);
        return experiencia.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                          .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/ubicacion/{ubicacion}")
    public ResponseEntity<List<Experiencia>> obtenerPorUbicacion(@PathVariable String ubicacion) {
        List<Experiencia> experiencias = experienciaService.obtenerPorUbicacion(ubicacion);
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Experiencia>> obtenerPorCategoria(@PathVariable String categoria) {
        List<Experiencia> experiencias = experienciaService.obtenerPorCategoria(categoria);
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Experiencia> crearExperiencia(@RequestBody Experiencia experiencia) {
        Experiencia nuevaExperiencia = experienciaService.crearExperiencia(experiencia);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experiencia> actualizarExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        Experiencia experienciaActualizada = experienciaService.actualizarExperiencia(id, experiencia);
        if (experienciaActualizada != null) {
            return new ResponseEntity<>(experienciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarExperiencia(@PathVariable Long id) {
        if (experienciaService.eliminarExperiencia(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}