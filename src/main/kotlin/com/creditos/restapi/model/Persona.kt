package com.creditos.restapi.model;

import java.time.LocalDate
import javax.persistence.*;

@Entity
@Table(name = "persona")

data class Persona(val dni:Long = 0, val nombre:String? = "", val apellido:String = "", val fechaNac: LocalDate? = null){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0
    // El id es autoincremental
}