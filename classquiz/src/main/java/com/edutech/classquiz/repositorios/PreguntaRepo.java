package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepo extends JpaRepository<Pregunta, Long> {
    @Query("SELECT p FROM Pregunta p JOIN Bancopregunta bp ON p.id = bp.preguntasIdpregunta.id WHERE bp.examenesIdexamenen.id = :idexamen")
    List<Pregunta> findPreguntasByExamenId(Long idexamen);
}
