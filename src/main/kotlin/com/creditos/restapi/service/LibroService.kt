package com.creditos.restapi.service

import com.creditos.restapi.dao.LibroRepository
import com.creditos.restapi.model.Libro
import com.creditos.restapi.exception.BusinessException
import com.creditos.restapi.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
abstract class LibroService: BasicCrud<Libro, Long> {

    @Autowired
    private lateinit var libroRepository:LibroRepository

    @Throws(BusinessException::class, NotFoundException::class)
    override fun list(): List<Libro> {

        try {
            return libroRepository.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun get(id: Long): Libro {
        val op: Optional<Libro>

        try {
            op = libroRepository.findById(id)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontró el libro con id $id")
        }

        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(t: Libro): Libro {

        try {
            return libroRepository.save(t)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }
    override fun remove(id: Long) {

        val op: Optional<Libro>

        try {
            op = libroRepository.findById(id)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontró el libro con id $id")
        }else{
            try {
                libroRepository.deleteById(id)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}