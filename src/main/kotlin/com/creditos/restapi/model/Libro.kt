package com.creditos.restapi.model

import javax.persistence.*

@Entity
//@SequenceGenerator(name = "libroseq", sequenceName = "libro_seq")
@Table(name = "libro")
data class Libro(
        val nombre:String = "",
        val autor:String = ""
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = 0
}