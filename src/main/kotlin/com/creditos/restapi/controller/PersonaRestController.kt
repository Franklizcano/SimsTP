package com.creditos.restapi.controller

import com.creditos.restapi.business.LibroService
import com.creditos.restapi.business.PersonaService
import com.creditos.restapi.exception.BusinessException
import com.creditos.restapi.exception.NotFoundException
import com.creditos.restapi.model.Persona
import com.creditos.restapi.utils.Constants
import com.fasterxml.jackson.databind.util.JSONPObject
import org.hibernate.EntityMode.parse
import org.hibernate.engine.profile.Fetch.Style.parse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JsonParser
import org.springframework.boot.json.JsonParserFactory
import org.springframework.http.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.net.HttpCookie.parse
import java.util.logging.Level.parse

@RestController
@RequestMapping(Constants.URL_BASE_PERSONAS)
class PersonaRestController {

    @Autowired
    private lateinit var personaBusiness:PersonaService

    @Autowired
    private lateinit var libroBusiness:LibroService

    @GetMapping("")
    fun list(): ResponseEntity<List<Persona>> {
        return try {
            ResponseEntity(personaBusiness.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idPersona: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(personaBusiness.load(idPersona), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@Validated @RequestBody persona: Persona): ResponseEntity<Any> {
        if (persona.nombre.isEmpty() == true) {
            println("El nombre esta vacio")
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        } else {
            return try {
                //personaBusiness.save(persona)
                //val responseHeader = HttpHeaders()
                //responseHeader.set("location", Constants.URL_BASE_PERSONAS + "/" + persona.id)
                ResponseEntity(personaBusiness.save(persona), HttpStatus.CREATED)
            } catch (e: BusinessException) {
                ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
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
    }
