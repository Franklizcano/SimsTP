package com.creditos.restapi.controller

import com.creditos.restapi.exception.BusinessException
import com.creditos.restapi.exception.NotFoundException
import com.creditos.restapi.model.Libro
import com.creditos.restapi.service.BasicCrud
import com.creditos.restapi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_LIBROS)
abstract class LibroRestController(@Autowired private val libroBusiness:BasicCrud<Libro, Long>): BasicCrud<Libro, Long> {

    @GetMapping("")
    fun get(): ResponseEntity<List<Libro>> {
        return try {
            ResponseEntity(libroBusiness.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(libroBusiness.get(id), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody libro: Libro): ResponseEntity<Any> {
        return if (libro.nombre.isEmpty()) {
            println("Este nombre está vacío")
            ResponseEntity(HttpStatus.BAD_REQUEST)
        } else {
            try {
                //libroBusiness.save(libro)
                //val responseHeader = HttpHeaders()
                //responseHeader.set("location", Constants.URL_BASE_LIBROS + "/" + libro.id)
                ResponseEntity(libroBusiness.save(libro), HttpStatus.CREATED)
            } catch (e: BusinessException) {
                ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }

    @PutMapping("")
    fun update(@RequestBody libro: Libro): ResponseEntity<Any> {
        return try {
            ResponseEntity(libroBusiness.save(libro), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idLibro: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(libroBusiness.remove(idLibro), HttpStatus.NO_CONTENT)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
