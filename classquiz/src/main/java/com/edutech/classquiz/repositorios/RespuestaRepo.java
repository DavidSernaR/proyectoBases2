package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepo extends JpaRepository<Respuesta, Long> {
}

