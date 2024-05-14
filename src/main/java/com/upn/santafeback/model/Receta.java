package com.upn.santafeback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recetas")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "medico", nullable = false, length = 200)
    private String medico;

    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "indicaciones", nullable = true, length = 700)
    private String indicaciones;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @OneToMany(mappedBy = "idReceta")
    private Set<Tratamiento> tratamientos = new LinkedHashSet<>();

}