package com.upiiz.relaciones.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(50)")
    @NotBlank
    private String nombre;
    @NotBlank
    @Email
    private String correo;
    @NotBlank
    private String matricula;

    // Un estudiante tiene un perfil
    // Traer la llave foránea
    @OneToOne(targetEntity = Perfil.class)
    private Perfil perfil;

    // Un estudiante tiene un tutor -> muchos estudiantes tiene un tutor
    @ManyToOne(targetEntity = Tutor.class)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    // Cursos - Un estudiante tiene muchas - Materias
    @ManyToMany(targetEntity = Curso.class, fetch = FetchType.LAZY)
    private List<Curso> cursos;
}
