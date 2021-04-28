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
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    val libros: List<Libro>,
    val fechaNac: LocalDate? = LocalDate.now(),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
)