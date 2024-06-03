package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepo extends JpaRepository<Curso, Long> {
}