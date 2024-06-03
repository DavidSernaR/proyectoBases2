package com.edutech.classquiz.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "DOCENTES")
public class Docente {
    @Id
    @Column(name = "IDDOCENTE", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 40)
    private String apellido;

    @Column(name = "USUARIO", nullable = false, length = 40)
    private String usuario;

    @Column(name = "CORREO_ELECTRONICO", nullable = false, length = 40)
    private String correoElectronico;

    @Column(name = "PASSWORD", nullable = false, length = 40)
    private String password;

    @Column(name = "TELEFONO")
    private Long telefono;

    @Column(name = "DIRECCION", length = 40)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "IDINSTITUCION", nullable = false)
    private Institucione idinstitucion;

    @OneToMany(mappedBy = "iddocente")
    private Set<Curso> cursos = new LinkedHashSet<>();

}