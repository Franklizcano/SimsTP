package com.creditos.restapi.business

import com.creditos.restapi.dao.LibroRepository
import com.creditos.restapi.model.Libro
import com.creditos.restapi.exception.BusinessException
import com.creditos.restapi.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class LibroService: BasicCrudLibro {

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

    override fun load(idLibro: Long): Libro {
        val op: Optional<Libro>

        try {
            op = libroRepository.findById(idLibro)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontró el libro con id $idLibro")
        }

        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(libro: Libro): Libro {

        try {
            return libroRepository.save(libro)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }
    override fun remove(idLibro: Long) {

        val op: Optional<Libro>

        try {
            op = libroRepository.findById(idLibro)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontró el libro con id $idLibro")
        }else{
            try {
                libroRepository.deleteById(idLibro)
            } catch (e: Exception) {
                throw BusinessException(e.message)
            }
        }
    }
}