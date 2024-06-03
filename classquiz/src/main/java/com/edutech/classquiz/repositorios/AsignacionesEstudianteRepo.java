package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.AsignacionesEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionesEstudianteRepo extends JpaRepository<AsignacionesEstudiante, Long> {
}
