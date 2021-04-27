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
    val fechaNac: LocalDate? = null,
    val domicilio: String,

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    var libro_id: List<Persona> = emptyList()*/
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0
}
