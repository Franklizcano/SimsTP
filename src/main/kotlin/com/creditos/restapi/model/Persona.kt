package com.creditos.restapi.model

import java.time.LocalDate
import javax.persistence.*

@Entity
//@SequenceGenerator(name = "personaseq", sequenceName = "persona_seq")
@Table(name = "persona")
data class Persona(
    val dni: Long,
    val nombre: String,
    val apellido: String,
    val domicilio: String,
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = [CascadeType.ALL])
    @JoinColumn(name = "persona_id", nullable = true)
    val libros: List<Libro>,
    @Enumerated(EnumType.STRING)
    var profesion: TipoProfesionEnum,
    val fechaNac: LocalDate? = LocalDate.now(),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)

enum class TipoProfesionEnum { Policia, Medico, Ingeniero }