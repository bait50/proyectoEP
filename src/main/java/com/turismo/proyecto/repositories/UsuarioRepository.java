package com.turismo.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.proyecto.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
// Método personalizado para buscar usuario por email
    Optional<Usuario> findByEmail(String email);
}