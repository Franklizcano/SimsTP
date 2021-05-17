package com.creditos.restapi.controller

import com.creditos.restapi.business.BasicCrudLibro
import com.creditos.restapi.exception.BusinessException
import com.creditos.restapi.exception.NotFoundException
import com.creditos.restapi.model.Libro
import com.creditos.restapi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_LIBROS)
class LibroRestController {

    @Autowired
    private lateinit var libroBusiness:BasicCrudLibro

    @GetMapping("")
    fun list(): ResponseEntity<List<Libro>> {
        return try {
            ResponseEntity(libroBusiness.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idLibro: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(libroBusiness.load(idLibro), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody libro: Libro): ResponseEntity<Any> {
        if (libro.nombre.isEmpty() == true) {
            println("Este nombre está vacío")
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        } else {
            return try {
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
