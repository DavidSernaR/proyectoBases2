package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Bancopregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancopreguntaRepo extends JpaRepository<Bancopregunta, Long> {
}
