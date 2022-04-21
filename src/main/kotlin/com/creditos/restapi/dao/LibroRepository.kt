package com.creditos.restapi.dao

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import com.creditos.restapi.model.Libro

@Repository
interface LibroRepository: JpaRepository<Libro,Long>