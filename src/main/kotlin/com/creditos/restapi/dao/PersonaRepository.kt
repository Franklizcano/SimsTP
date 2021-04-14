package com.creditos.restapi.dao

import com.creditos.restapi.model.Persona
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface PersonaRepository: JpaRepository<Persona,Long> {
}