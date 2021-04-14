package com.creditos.restapi.business

import com.creditos.restapi.dao.PersonaRepository
import com.creditos.restapi.model.Persona
import com.creditos.restapi.exception.BusinessException
import com.creditos.restapi.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws

@Service
class PersonaBusiness : iPersonaBusiness {

    @Autowired
    val personaRepository: PersonaRepository? = null

    @Throws(BusinessException::class, NotFoundException::class)
    override fun list(): List<Persona> {

        try {
            return personaRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>

        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }

        if (!op.isPresent) {
            throw NotFoundException("No se encontró la persona con id $idPersona")
        }

        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {

        try {
            return personaRepository!!.save(persona)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun remove(idPersona: Long) {

        val op: Optional<Persona>

        try {
            op = personaRepository!!.findById(idPersona)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }

        if(!op.isPresent){
            throw NotFoundException("No se encontró la persona con id $idPersona")
        }else{
            try {
                personaRepository!!.deleteById(idPersona)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}