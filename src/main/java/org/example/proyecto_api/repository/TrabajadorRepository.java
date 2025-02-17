package org.example.proyecto_api.repository;

import org.example.proyecto_api.model.Nomina;
import org.example.proyecto_api.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
@RequestMapping
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    List<Trabajador> findTrabajadorByNomina(Nomina nomina);
}
