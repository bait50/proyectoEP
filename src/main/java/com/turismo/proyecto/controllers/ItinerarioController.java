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
import com.turismo.proyecto.models.Usuario;
import com.turismo.proyecto.services.ItinerarioService;
import com.turismo.proyecto.services.UsuarioService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/itinerarios")
public class ItinerarioController {
    
    @Autowired
    private ItinerarioService itinerarioService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Itinerario>> obtenerTodos() {
        List<Itinerario> itinerarios = itinerarioService.obtenerTodos();
        return new ResponseEntity<>(itinerarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itinerario> obtenerPorId(@PathVariable Long id) {
        Optional<Itinerario> itinerario = itinerarioService.obtenerPorId(id);
        return itinerario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                         .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Itinerario>> obtenerPorUsuario(@PathVariable Long usuarioId) {
        Optional<Usuario> usuario = usuarioService.obtenerPorId(usuarioId);
        if (usuario.isPresent()) {
            List<Itinerario> itinerarios = itinerarioService.obtenerPorUsuario(usuario.get());
            return new ResponseEntity<>(itinerarios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Itinerario> crearItinerario(@RequestBody Itinerario itinerario) {
        Itinerario nuevoItinerario = itinerarioService.crearItinerario(itinerario);
        return new ResponseEntity<>(nuevoItinerario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Itinerario> actualizarItinerario(@PathVariable Long id, @RequestBody Itinerario itinerario) {
        Itinerario itinerarioActualizado = itinerarioService.actualizarItinerario(id, itinerario);
        if (itinerarioActualizado != null) {
            return new ResponseEntity<>(itinerarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItinerario(@PathVariable Long id) {
        if (itinerarioService.eliminarItinerario(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}