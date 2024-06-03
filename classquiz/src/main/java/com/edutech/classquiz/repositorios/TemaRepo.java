package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepo extends JpaRepository<Tema, Long> {
}
