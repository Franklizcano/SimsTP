package com.creditos.restapi.business

import com.creditos.restapi.model.Libro

interface BasicCrudLibro {

    fun list(): List<Libro>
    fun load(idLibro:Long): Libro
    fun save(libro: Libro): Libro
    fun remove(idLibro: Long)
}