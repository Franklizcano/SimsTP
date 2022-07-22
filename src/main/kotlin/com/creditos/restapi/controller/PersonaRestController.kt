package com.creditos.restapi.controller

import com.creditos.restapi.exception.BusinessException
import com.creditos.restapi.exception.NotFoundException
import com.creditos.restapi.model.Persona
import com.creditos.restapi.service.PersonaService
import com.creditos.restapi.utils.Constants
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_PERSONAS)
class PersonaRestController(private val personaBusiness:PersonaService) {

    @GetMapping("")
    fun list(): ResponseEntity<List<Persona>> {
        return try {
            ResponseEntity(personaBusiness.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") idPersona: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(personaBusiness.get(idPersona), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("")
    fun insert(@Validated @RequestBody persona: Persona): ResponseEntity<Any> {
        return try {
                ResponseEntity(personaBusiness.save(persona), HttpStatus.CREATED)
            } catch (e: BusinessException) {
                ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
    }

        @PutMapping("")
        fun update(@RequestBody persona: Persona): ResponseEntity<Any> {
            return try {
                ResponseEntity(personaBusiness.save(persona), HttpStatus.OK)
            } catch (e: BusinessException) {
                ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }

        @DeleteMapping("/{id}")
        fun delete(@PathVariable("id") idPersona: Long): ResponseEntity<Any> {
            return try {
                ResponseEntity(personaBusiness.remove(idPersona), HttpStatus.NO_CONTENT)
            } catch (e: BusinessException) {
                ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            } catch (e: NotFoundException) {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
        }

        @GetMapping("/{id}/mensajes-de-libros")
        fun mostrarMensajesDeLibros(@PathVariable("id") idPersona: Long): ResponseEntity<List<String>> {
            val persona = personaBusiness.get(idPersona)
            val mostrarMensajesDeSusLibros = personaBusiness.mostrarMensajesDeSusLibros(persona.libros)
            return ResponseEntity(mostrarMensajesDeSusLibros, HttpStatus.OK)
        }

        @PostMapping("/{id}/trabajo")
        fun trabajar(@PathVariable("id") idPersona: Long): ResponseEntity<String> {
            return try {
                val persona = personaBusiness.get(idPersona)
                val trabajar = personaBusiness.trabajar(persona)
                personaBusiness.save(persona)
                return ResponseEntity(trabajar, HttpStatus.OK)
            } catch (e: NotFoundException) {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
        }
}
