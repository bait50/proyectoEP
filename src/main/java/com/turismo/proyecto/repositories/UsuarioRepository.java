package com.turismo.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.proyecto.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}