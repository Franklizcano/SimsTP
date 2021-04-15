package com.creditos.restapi.dao

import com.creditos.restapi.model.Persona
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import java.time.DateTimeException
import java.time.LocalDate

@Repository
interface PersonaRepository: JpaRepository<Persona,Long> {

}