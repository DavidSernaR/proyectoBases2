package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepo extends JpaRepository<Estado, Long> {
}
