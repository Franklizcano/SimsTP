package com.creditos.restapi.service

import com.creditos.restapi.dao.PersonaRepository
import com.creditos.restapi.exception.BusinessException
import com.creditos.restapi.exception.NotFoundException
import com.creditos.restapi.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class PersonaService: BasicCrud<Persona, Long> {

    @Autowired
    private lateinit var personaRepository:PersonaRepository

    @Autowired
    private lateinit var tipoLibroStrategy: TipoLibroStrategy

    @Autowired
    private lateinit var tipoProfesionStrategy: TipoProfesionStrategy

    @Throws(BusinessException::class, NotFoundException::class)
    override fun list(): List<Persona> {

        try {
            return personaRepository.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun get(id: Long): Persona {
        val op: Optional<Persona>

        try {
            op = personaRepository.findById(id)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontró la persona con id $id")
        }

        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(t: Persona): Persona {

        try {
            return personaRepository.save(t)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun remove(id: Long) {

        val op: Optional<Persona>

        try {
            op = personaRepository.findById(id)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontró la persona con id $id")
        } else {
            try {
                personaRepository.deleteById(id)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
    fun mostrarMensajesDeSusLibros(listLibros: List<Libro>): List<String> {
        return listLibros.map { libro -> tipoLibroStrategy.mostrarMensajeLibro(libro.tipo) }
    }
    fun trabajar(persona: Persona): String {
        return tipoProfesionStrategy.trabajar(persona)
    }
}