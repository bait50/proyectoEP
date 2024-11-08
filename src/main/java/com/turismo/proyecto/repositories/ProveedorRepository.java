package com.turismo.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turismo.proyecto.models.Proveedor;
import com.turismo.proyecto.models.Reserva;
import com.turismo.proyecto.models.Usuario;
import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

// Método para buscar reservas por usuario
    List<Reserva> findByUsuario(Usuario usuario);

// Método para buscar reservas por estado
    List<Reserva> findByEstado(String estado);

// Método para buscar proveedores por tipo
    List<Proveedor> findByTipo(String tipo);
}