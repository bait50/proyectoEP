package com.turismo.proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.turismo.proyecto.models.Proveedor;
import com.turismo.proyecto.repositories.ProveedorRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> obtenerPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    public List<Proveedor> obtenerPorTipo(String tipo) {
        return proveedorRepository.findByTipo(tipo);
    }

    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizarProveedor(Long id, Proveedor proveedorActualizado) {
        if (proveedorRepository.existsById(id)) {
            proveedorActualizado.setIdProveedor(id);
            return proveedorRepository.save(proveedorActualizado);
        }
        return null;
    }

    public boolean eliminarProveedor(Long id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}