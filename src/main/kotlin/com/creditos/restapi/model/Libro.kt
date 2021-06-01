package com.creditos.restapi.model

import javax.persistence.*

@Entity
//@SequenceGenerator(name = "libroseq", sequenceName = "libro_seq")
@Table(name = "libro")
data class Libro(
        @Column
        val nombre:String,
        @Column
        val autor:String,
        @Column
        val genero:String,
        @Column
        val precio:Int,
        @Column(name = "puntuacion_general")
        val puntuacionGeneral:Int,
        @Enumerated(EnumType.STRING)
        val tipo: TipoLibroEnum,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long? = null
)

enum class TipoLibroEnum { VIRTUAL, TAPA_BLANDA, TAPA_DURA }