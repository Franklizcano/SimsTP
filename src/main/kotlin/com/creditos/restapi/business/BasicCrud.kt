package com.creditos.restapi.business

import com.creditos.restapi.model.Persona

interface BasicCrud {

    fun list(): List<Persona>
    fun load(idPersona:Long): Persona
    fun save(persona:Persona): Persona
    fun remove(idPersona: Long)
}