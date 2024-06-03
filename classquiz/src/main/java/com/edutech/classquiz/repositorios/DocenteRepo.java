package com.edutech.classquiz.repositorios;

import com.edutech.classquiz.modelo.entidades.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepo extends JpaRepository<Docente, Long> {
    @Query("SELECT d FROM Docente d WHERE d.correoElectronico = :correoElectronico AND d.password = :password")
    Docente findByEmailAndPassword(String correoElectronico, String password);
}
