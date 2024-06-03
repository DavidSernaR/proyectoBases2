package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Examene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExameneRepo extends JpaRepository<Examene, Long> {
    @Query("SELECT e FROM Examene e WHERE e.id = :id")
    Examene findExamenById(Long idexamenen);
    @Query("SELECT e.id FROM Examene e")
    List<Long> listaExamenesId();
}
